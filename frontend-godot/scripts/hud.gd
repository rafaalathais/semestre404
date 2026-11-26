extends Control

# Sinal que avisa a cena atual quem está falando e com qual expressão
signal personagem_falou(nome_personagem: String, expressao: String)
signal capitulo_finalizado

@onready var label_dinheiro = $BarraStatus/LabelDinheiro
@onready var label_tempo = $BarraStatus/LabelTempo
@onready var label_sanidade = $BarraStatus/LabelSanidade
@onready var label_felicidade = $BarraStatus/LabelNotas
@onready var caixa_dialogo = $CaixaDialogo

@onready var label_nome = $CaixaDialogo/LabelNome
@onready var label_texto = $CaixaDialogo/LabelTexto
@onready var container_escolhas = $CaixaDialogo/ContainerEscolhas
@onready var botao_continuar = $CaixaDialogo/BotaoContinuar

var roteiro: Dictionary = {}

func _ready() -> void:
	# Conecta a barra superior ao sinal global do GameManager!
	GameManager.status_atualizar.connect(atualizar_barra_status)
	atualizar_barra_status()

func atualizar_barra_status() -> void:
	var s = GameManager.status_jogador
	label_dinheiro.text = "Dinheiro: R$ " + str(s["dinheiro"])
	label_tempo.text = "Tempo: " + str(s["tempo"]) + "h"
	label_sanidade.text = "Sanidade: " + str(s["sanidade"]) + "%"
	label_felicidade.text = "Notas: " + str(s["notas"]) + "%"

func iniciar_roteiro(caminho_json: String, id_inicial: String) -> void:
	var arquivo = FileAccess.open(caminho_json, FileAccess.READ)
	roteiro = JSON.parse_string(arquivo.get_as_text())
	exibir_no(id_inicial)

func exibir_no(id: String) -> void:
	if id == "fim" or not roteiro.has(id):
		caixa_dialogo.visible = false
		label_nome.text = ""
		label_texto.text = "Fim do capítulo!"
		limpar_escolhas()
		botao_continuar.visible = false
		capitulo_finalizado.emit()
		return
	caixa_dialogo.visible = true
	

	var dados = roteiro[id]
	var char_id = dados.get("character", "")
	var expressao = dados.get("expression", "normal")

	label_nome.text = char_id.capitalize()
	label_texto.text = dados.get("text", "")

	# Avisa o cenário para trocar a imagem do personagem
	personagem_falou.emit(char_id, expressao)
	

	limpar_escolhas()

	if dados.has("choices"):
		botao_continuar.visible = false
		for escolha in dados["choices"]:
			criar_botao_escolha(escolha)
	else:
		botao_continuar.visible = true
		for c in botao_continuar.pressed.get_connections():
			botao_continuar.pressed.disconnect(c["callable"])
		botao_continuar.pressed.connect(func(): exibir_no(dados.get("next", "fim")))

func criar_botao_escolha(escolha: Dictionary) -> void:
	var btn = Button.new()
	btn.text = escolha["text"]
	btn.pressed.connect(func(): _ao_escolher(escolha))
	container_escolhas.add_child(btn)

func _ao_escolher(escolha: Dictionary) -> void:
	if escolha.has("efeitos"):
		GameManager.aplicar_efeitos(escolha["efeitos"])
	exibir_no(escolha["next"])

func limpar_escolhas() -> void:
	for filho in container_escolhas.get_children():
		filho.queue_free()

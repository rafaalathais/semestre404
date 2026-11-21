extends Control

@onready var http = $HTTPRequest
@onready var botao = $Button

# Called when the node enters the scene tree for the first time.
func _ready() -> void:
	 # Conecta o clique do botão e a resposta do servidor
	botao.pressed.connect(_ao_clicar_no_botao)
	http.request_completed.connect(_ao_receber_resposta)


func _ao_clicar_no_botao():
	botao.disabled = true
	botao.text = "Salvando..."

	var url = "http://localhost:8080/estado-save/salvar"
	var headers = ["Content-Type: application/json"]
	var dados = {
		"nomeJogador": "JogadorTeste",
		"ultimaAcao": "Clicou na imagem de teste"
	}

	http.request(url, headers, HTTPClient.METHOD_POST, JSON.stringify(dados))

func _ao_receber_resposta(result, response_code, headers, body):
	botao.disabled = false
	if response_code == 200:
		botao.text = "Salvo com sucesso!"
		print("Resposta do Java: ", body.get_string_from_utf8())
	else:
		botao.text = "Erro ao salvar (" + str(response_code) + ")"

# Called every frame. 'delta' is the elapsed time since the previous frame.
func _process(delta: float) -> void:
	pass

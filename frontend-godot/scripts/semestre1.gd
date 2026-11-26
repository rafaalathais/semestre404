extends Node2D

@onready var hud = $HUD
@onready var personagens = {
	"personagem2": $personagem2
}

# Called when the node enters the scene tree for the first time.
func _ready() -> void:
	# Escuta quando o HUD avisar que um personagem falou para trocar a expressão
	hud.personagem_falou.connect(_on_personagem_falou)
	
	# Inicia a história lendo o seu JSON!
	hud.iniciar_roteiro("res://roteiros/semestre1.json", "dialogo_01")

func _on_personagem_falou(nome_personagem: String, expressao: String) -> void:
	if personagens.has(nome_personagem):
		personagens[nome_personagem].mudar_expressao(expressao)

extends Control

@onready var botaoInicar = $botaoIniciar
# Called when the node enters the scene tree for the first time.
func _ready() -> void:
	pass # Replace with function body.


func _on_botao_iniciar_pressed() -> void:
	GameManager.resetar_status()
	get_tree().change_scene_to_file("res://cenas/semestre1.tscn")

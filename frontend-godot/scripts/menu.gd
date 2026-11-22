extends CanvasLayer

@onready var menu = $painelMenu
@onready var botao_menu = $botaoMenu

# Called when the node enters the scene tree for the first time.
func _ready() -> void:
	menu.visible = false
	pass # Replace with function body.


# Called every frame. 'delta' is the elapsed time since the previous frame.
func _process(delta: float) -> void:
	pass

func _on_botao_menu_pressed() -> void:
	menu.visible = true
	botao_menu.visible = false # esconde a engrenagem
	#var instancia_menu = cena_menu.instantiate()
	#add_child(instancia_menu)

func _on_botao_fechar_pressed() -> void:
	menu.visible = false
	botao_menu.visible = true
	# queue_free() # fecha o menu inteiro


func _on_botao_sair_pressed() -> void:
	get_tree().quit() # fecha o jogo

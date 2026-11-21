extends TextureRect
class_name Personagem

# Called when the node enters the scene tree for the first time.
func _ready() -> void:
	pass # Replace with function body.

@export var expressoes: Dictionary[String, Texture2D] = {} #ta no inspetor ->

func mudar_expressao(nome_expressao: String) -> void:
	if expressoes.has(nome_expressao):
		self.texture = expressoes[nome_expressao]
	else:
		print('Expressão nao encontrada: ', nome_expressao)
# Called every frame. 'delta' is the elapsed time since the previous frame.
func _process(delta: float) -> void:
	pass

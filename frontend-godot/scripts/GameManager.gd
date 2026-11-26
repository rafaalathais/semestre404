extends Node

# sinal que avisa a barra de status atualizar
signal status_atualizar

var status_jogador: Dictionary = {
	"dinheiro": 100,
	"tempo": 10,
	"sanidade": 80,
	"notas": 7
}
func aplicar_efeitos(efeitos: Dictionary) -> void:
	for metrica in efeitos.keys():
		if status_jogador.has(metrica):
			status_jogador[metrica] += efeitos[metrica]
	status_atualizar.emit() # dispara para qualquer cena que esteja na tela
	
func resetar_status() -> void:
	status_jogador = {
	"dinheiro": 100,
	"tempo": 10,
	"sanidade": 80,
	"notas": 7
	}
	status_atualizar.emit()
	
# Called when the node enters the scene tree for the first time.
func _ready() -> void:
	pass # Replace with function body.


# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta: float) -> void:
#	pass

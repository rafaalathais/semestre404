package com.grupo.semestre404.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class SaveJogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Jogador jogador;
    private JogadorAtributos jogadorAtributos;
    private int codigoEvento; // codigo do dialogo ou da carta
    private int codigoEscolha;


   
    public SaveJogo(Jogador jogador, JogadorAtributos jogadorAtributos, int codigoEvento, int codigoEscolha) {
        this.jogador = jogador;
        this.jogadorAtributos = jogadorAtributos;
        this.codigoEscolha = codigoEscolha;
        this.codigoEvento = codigoEvento;
    }

}

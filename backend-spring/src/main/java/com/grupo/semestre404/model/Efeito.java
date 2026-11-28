package com.grupo.semestre404.model;

/**
 * essa parte mostra a variação nos atributos do jogador
 * essa parte vai ser usada por cartas, grade e escolhas, NÃO É PRA MUDAR!
 */
public record Efeito(int sanidade, int tempo, double notas, double dinheiro) {

    public static final Efeito NENHUM = new Efeito(0, 0, 0, 0);

    /** usada pela grade para intensificar ganhos e perdas, na grade difícil/media */
    public Efeito multiplicar(double fator) {
        return new Efeito(
            (int) Math.round(sanidade * fator),
            (int) Math.round(tempo * fator),
            notas * fator,
            dinheiro * fator
        );
    }
}
package com.grupo.semestre404.model;

public class JogadorAtributos {

    public static final int SANIDADE_MIN = 0;
    public static final int SANIDADE_MAX = 100;
    public static final int TEMPO_MIN = 0;
    public static final int TEMPO_MAX = 100;
    public static final double NOTAS_MIN = 0.0;
    public static final double NOTAS_MAX = 100.0;
    public static final double DINHEIRO_MIN = -50.0;
    public static final double DINHEIRO_INICIAL = 100.0;

    private int sanidade;
    private int tempo;
    private double indiceNotas;
    private double dinheiro;

    public JogadorAtributos(int sanidade, int tempo, double indiceNotas, double dinheiro) {
        this.sanidade = limitar(sanidade, SANIDADE_MIN, SANIDADE_MAX);
        this.tempo = limitar(tempo, TEMPO_MIN, TEMPO_MAX);
        this.indiceNotas = limitar(indiceNotas, NOTAS_MIN, NOTAS_MAX);
        this.dinheiro = Math.max(dinheiro, DINHEIRO_MIN);
    }

    /** valores iniciais da partida. */
    public static JogadorAtributos inicial() {
        return new JogadorAtributos(70, 70, 50.0, DINHEIRO_INICIAL);
    }

    public int getSanidade() { return sanidade; }
    public int getTempo() { return tempo; }
    public double getIndiceNotas() { return indiceNotas; }
    public double getDinheiro() { return dinheiro; }

    public void alterarSanidade(int variacao) {
        sanidade = limitar(sanidade + variacao, SANIDADE_MIN, SANIDADE_MAX);
    }

    public void alterarTempo(int variacao) {
        tempo = limitar(tempo + variacao, TEMPO_MIN, TEMPO_MAX);
    }

    public void alterarIndiceNotas(double variacao) {
        indiceNotas = limitar(indiceNotas + variacao, NOTAS_MIN, NOTAS_MAX);
    }

    public void alterarDinheiro(double variacao) {
        dinheiro = Math.max(dinheiro + variacao, DINHEIRO_MIN);
    }

    /** essa parte aplica um efeito completo (carta, grade, escolha) */
    public void aplicar(Efeito efeito) {
        alterarSanidade(efeito.sanidade());
        alterarTempo(efeito.tempo());
        alterarIndiceNotas(efeito.notas());
        alterarDinheiro(efeito.dinheiro());
    }

    /** true se algum atributo chegou no limite mínimo (gatilho pro final brusco) */
    public boolean atingiuLimiteMinimo() {
        return sanidade <= SANIDADE_MIN
            || tempo <= TEMPO_MIN
            || indiceNotas <= NOTAS_MIN
            || dinheiro <= DINHEIRO_MIN;
    }

    private static int limitar(int valor, int min, int max) {
        return Math.max(min, Math.min(max, valor));
    }

    private static double limitar(double valor, double min, double max) {
        return Math.max(min, Math.min(max, valor));
    }
}
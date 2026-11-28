package com.grupo.semestre404.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes unitários da classe JogadorAtributos e do record efeito
 *
 * como ler cada teste: todos seguem o padrão "Arrange, Act, Assert":
 *   1. Arrange (preparar): cria o objeto num estado conhecido
 *   2. Act (agir): executa a ação que queremos testar
 *   3. Assert (verificar): confere se o resultado é o esperado
 *
 * Se qualquer assert falhar, o teste fica vermelho e o Maven mostra
 * qual valor era esperado e qual foi obtido.
 */

class JogadorAtributosTest {

    @Test
    void sanidadeNaoPassaDoMaximo() {
        JogadorAtributos j = new JogadorAtributos(95, 50, 50.0, 50.0);
        j.alterarSanidade(20);
        assertEquals(JogadorAtributos.SANIDADE_MAX, j.getSanidade());
    }

    @Test
    void sanidadeNaoFicaAbaixoDoMinimo() {
        JogadorAtributos j = new JogadorAtributos(10, 50, 50.0, 50.0);
        j.alterarSanidade(-30);
        assertEquals(JogadorAtributos.SANIDADE_MIN, j.getSanidade());
    }

    @Test
    void dinheiroNaoFicaAbaixoDoPiso() {
        JogadorAtributos j = new JogadorAtributos(50, 50, 50.0, 10.0);
        j.alterarDinheiro(-200.0);
        assertEquals(-50.0, j.getDinheiro(), 0.001);
    }

    @Test
    void dinheiroPodeFicarNegativoAteOPiso() {
        JogadorAtributos j = new JogadorAtributos(50, 50, 50.0, 10.0);
        j.alterarDinheiro(-40.0);
        assertEquals(-30.0, j.getDinheiro(), 0.001);
        assertFalse(j.atingiuLimiteMinimo());
    }

    // GATILHO DE FINAL BRUSCO
    // atingiuLimiteMinimo() é o método que a classe Final vai consultar
    // para saber se o jogo deve acabar por um atributo no limite.

    @Test
    void atingirOPisoDoDinheiroAcionaLimiteMinimo() {
        JogadorAtributos j = new JogadorAtributos(50, 50, 50.0, 0.0);
        j.alterarDinheiro(-50.0);
        assertTrue(j.atingiuLimiteMinimo());
    }

    @Test
    void sanidadeZeradaAcionaLimiteMinimo() {
        JogadorAtributos j = new JogadorAtributos(10, 50, 50.0, 50.0);
        j.alterarSanidade(-10);
        assertTrue(j.atingiuLimiteMinimo());
    }

    @Test
    void estadoInicialNaoAcionaLimiteMinimo() {
        assertFalse(JogadorAtributos.inicial().atingiuLimiteMinimo());
    }

 /** aplicar(efeito) deve mexer nos 4 atributos de uma vez. */
 // EFEITOS POR CONTA DAS CARTAS, GRADE E ESCOLHAS

    @Test
    void aplicarEfeitoAlteraTodosOsAtributos() {
        JogadorAtributos j = new JogadorAtributos(50, 50, 50.0, 50.0);
        j.aplicar(new Efeito(10, -20, 5.0, -10.0));
        assertEquals(60, j.getSanidade());
        assertEquals(30, j.getTempo());
        assertEquals(55.0, j.getIndiceNotas(), 0.001);
        assertEquals(40.0, j.getDinheiro(), 0.001);
    }

    @Test
    void multiplicarEfeitoIntensificaGanhosEPerdas() {
        Efeito dobrado = new Efeito(10, -10, 5.0, -10.0).multiplicar(2);
        assertEquals(20, dobrado.sanidade());
        assertEquals(-20, dobrado.tempo());
        assertEquals(10.0, dobrado.notas(), 0.001);
        assertEquals(-20.0, dobrado.dinheiro(), 0.001);
    }
}
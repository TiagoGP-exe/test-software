package br.ifmt.cba.negocio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class CilindroTest {
    @Test
    public void quandoTodosDadosCorretos() {
        Cilindro cilindro = new Cilindro(new Circulo(2), 4);
        assertEquals(75.39, cilindro.getArea(), 0.01);
    }

    @Test (expected = RuntimeException.class)
    public void quandoAlturaMenorOuIgualZero() {
        Cilindro cilindro = new Cilindro(new Circulo(2), 0);
        cilindro.getArea();
    }

    @Test (expected = RuntimeException.class)
    public void quandoRaioMenorOuIgualZero() {
        Cilindro cilindro = new Cilindro(new Circulo(-1), 4);
        cilindro.getArea();
    }

    @Test (expected = RuntimeException.class)
    public void quandoCirculoNull() {
        Cilindro cilindro = new Cilindro(null, 4);
        cilindro.getArea();
    }
}

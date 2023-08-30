package br.ifmt.cba.negocio;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import org.junit.Test;

public class CilindroComMockitoTest {
    @Test
    public void quandoTodosDadosCorretos() {
        Circulo circuloFalso = mock(Circulo.class);

        when(circuloFalso.getRaio()).thenReturn(2.0);
        when(circuloFalso.getArea()).thenReturn(12.56);

        Cilindro cilindro = new Cilindro(circuloFalso, 4);
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

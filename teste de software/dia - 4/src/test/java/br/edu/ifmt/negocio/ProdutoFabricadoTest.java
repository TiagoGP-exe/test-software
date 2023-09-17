package br.edu.ifmt.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class ProdutoFabricadoTest {

  private ProdutoFabricado produto;

  @Before
  public void setUp() {
    produto = new ProdutoFabricado();
  }

  @Test
  public void testCustoMateriaPrimaNegativo() {
    try {
      produto.setValorMateriaPrima(-80);
      fail("Deveria lançar uma exceção IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // Esperado
    }
  }

  @Test
  public void testCustoMaoObraNegativo() {
    try {
      produto.setValorMaoObra(-40);
      fail("Deveria lançar uma exceção IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // Esperado
    }
  }

  @Test
  public void testMargemLucroZero() {
    produto.setPercMargem(0);
    produto.setValorMateriaPrima(80);
    produto.setValorMaoObra(40);
    float resultadoEsperado = 120;
    assertEquals(resultadoEsperado, produto.calcularPrecoVenda(), 0.01);
  }
}
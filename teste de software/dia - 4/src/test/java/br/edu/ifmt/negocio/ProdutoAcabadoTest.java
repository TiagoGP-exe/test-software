package br.edu.ifmt.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class ProdutoAcabadoTest {

  private ProdutoAcabado produto;

  @Before
  public void setUp() {
    produto = new ProdutoAcabado();
  }

  @Test
  public void testMargemLucroZero() {
    produto.setPercMargem(0);
    produto.setValorCompra(100);
    assertEquals(100, produto.calcularPrecoVenda(), 0.01);
  }

  @Test
  public void testValorCompraNegativo() {
    try {
      produto.setValorCompra(-100);
      fail("Deveria lançar uma exceção IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // Esperado
    }
  }
}

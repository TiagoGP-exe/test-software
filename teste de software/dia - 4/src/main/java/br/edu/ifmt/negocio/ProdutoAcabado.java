package br.edu.ifmt.negocio;

public class ProdutoAcabado extends Produto {

  private float valorCompra;

  @Override
  public float calcularPrecoVenda() {
    float valorMargem = valorCompra * getPercMargem() / 100;
    return valorCompra + valorMargem;
  }

  public void setValorCompra(float valor) {
    if (valor < 0) {
      throw new IllegalArgumentException("O valor de compra não pode ser negativo.");
    }
    valorCompra = valor;
  }

  public float getValorCompra() {
    return valorCompra;
  }
}
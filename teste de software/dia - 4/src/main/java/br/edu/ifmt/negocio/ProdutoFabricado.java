package br.edu.ifmt.negocio;

public class ProdutoFabricado extends Produto {

  private float valorMateriaPrima;
  private float valorMaoObra;

  @Override
  public float calcularPrecoVenda() {
    float valorBase, valorMargem;
    valorBase = valorMateriaPrima + valorMaoObra;
    valorMargem = valorBase * getPercMargem() / 100;
    return valorBase + valorMargem;
  }

  public void setValorMateriaPrima(float valor) {
    if (valor < 0) {
      throw new IllegalArgumentException("O custo da matéria-prima não pode ser negativo.");
    }
    valorMateriaPrima = valor;
  }

  public float getValorMateriaPrima() {
    return valorMateriaPrima;
  }

  public void setValorMaoObra(float valor) {
    if (valor < 0) {
      throw new IllegalArgumentException("O custo da mão de obra não pode ser negativo.");
    }
    valorMaoObra = valor;
  }

  public float getValorMaoObra() {
    return valorMaoObra;
  }
}

package br.edu.ifmt.negocio;

public abstract class Produto {

  private String nome;
  private int estoque;
  private float percMargem;

  public abstract float calcularPrecoVenda();

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setEstoque(int estoque) {
    this.estoque = estoque;
  }

  public int getEstoque() {
    return estoque;
  }

  public void setPercMargem(float margem) {
    this.percMargem = margem;
  }

  public float getPercMargem() {
    return percMargem;
  }
}

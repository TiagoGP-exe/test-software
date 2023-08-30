package br.ifmt.cba.negocio;

public class Cilindro {
    private Circulo circulo;
    private double altura;

    public Cilindro(Circulo circulo, double altura) {
        this.circulo = circulo;
        this.altura = altura;
    }

    public Circulo getCirculo() {
        return circulo;
    }

    public void setCirculo(Circulo circulo) { 
        this.circulo = circulo;
    }

    public double getAltura() {
        return altura;
    }

    public double setAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getArea() throws RuntimeException {
        if (this.circulo != null && this.altura >0) {
            return 2 * circulo.getArea() + 2 * Math.PI * this.circulo.getRaio() * this.altura;
        } else {
            throw new RuntimeException("Raio ou altura inconsistentes");
        }
    }
}

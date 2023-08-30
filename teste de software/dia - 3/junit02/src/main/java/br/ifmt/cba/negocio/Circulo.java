package br.ifmt.cba.negocio;

public class Circulo {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double getArea() throws RuntimeException {
        if (this.raio > 0 ) {
            // return Math.PI * Math.pow(this.raio, 3);
            return Math.PI * Math.pow(this.raio, 2);
        } else  {
            throw new RuntimeException("Raio com valor inconsistent");
        }
    }
}

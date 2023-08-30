package br.ifmt.cba.execucao;

import javax.swing.JOptionPane;

import br.ifmt.cba.negocio.Cilindro;
import br.ifmt.cba.negocio.Circulo;

public class AppCilindro {
    public static void main(String[] args) {
        double raio;
        double altura;
        try {
            raio = Double.parseDouble(JOptionPane.showInputDialog("Entre com op raio do cilindro: "));
            altura = Double.parseDouble(JOptionPane.showInputDialog("Entre com altura do cilindro: "));
            Cilindro cilindro = new Cilindro(new Circulo(raio), altura);
            JOptionPane.showMessageDialog(null, "Area do cilindro: " + cilindro.getArea());
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}

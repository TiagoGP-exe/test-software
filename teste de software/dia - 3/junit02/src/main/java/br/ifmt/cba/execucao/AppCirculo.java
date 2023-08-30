package br.ifmt.cba.execucao;

import javax.swing.JOptionPane;

import br.ifmt.cba.negocio.Circulo;

public class AppCirculo {
    public static void main(String[] args) {
        double raio;

        try {
            raio = Double.parseDouble(JOptionPane.showInputDialog("Entre com o raio do circulo: "));
            Circulo circulo = new Circulo(raio);
            JOptionPane.showMessageDialog(null, "Area do circulo = " + circulo);
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}

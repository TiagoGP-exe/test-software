package ifmt.cba.execucao;

import ifmt.cba.negocio.Calculadora;

public class AppCalculadora {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        System.out.println("_________________________________________________");
        System.out.println("Soma de 10 + 30 = " + calc.somar(10, 30));
        System.out.println("Subtração de 30 - 15 = " + calc.subtrair(30, 15));
        System.out.println("Multiplicação de 20*30 = " + calc.multiplicar(20, 30));
        System.out.println("Divisão de 50/2 = " + calc.dividir(50, 2));
    }
}

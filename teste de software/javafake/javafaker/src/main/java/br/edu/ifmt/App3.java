package br.edu.ifmt;

import java.util.Locale;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class App3 {
    public static void main(String[] args) {
        FakeValuesService fakeValues = new FakeValuesService(new Locale("pt-BR"), new RandomService());

        System.out.println("Números: " + fakeValues.numerify("###"));
        System.out.println("Caracteres: " + fakeValues.letterify("????", false));
        System.out.println("Alfanuméricos: " + fakeValues.bothify("???-##?#", true));
        System.out.println("Exemplo: " + fakeValues.bothify("+55 ## 9###-###", false));
    }
}

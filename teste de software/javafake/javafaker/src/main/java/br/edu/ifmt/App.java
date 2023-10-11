package br.edu.ifmt;

import java.util.Locale;

import com.github.javafaker.Faker;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("pt-BR"));
        System.out.println("Nome: " + faker.address().lastName());
        System.out.println("Sobrenome: " + faker.date().birthday(20, 60));
        System.out.println("Data de Nascimento: " + faker.date().birthday(20, 60));
        System.out.println("Cidade: " + faker.address().cityName());
        System.out.println("Estado: " + faker.address().state());
        System.out.println("Sigla Estado: " + faker.address().stateAbbr());

        System.out.println("--------------------------------------------------------");

        System.out.println("Animal: " + faker.animal().name());
        System.out.println("Artista: " + faker.artist().name());
        System.out.println("Aviões: " + faker.aviation().aircraft());
        System.out.println("Aeroporto: " + faker.aviation().airport());

        System.out.println("--------------------------------------------------------");
        System.out.println("Cervejas: " + faker.beer().name());
        System.out.println("Malte: " + faker.beer().malt());
        System.out.println("--------------------------------------------------------");
        System.out.println("ISBN10: " + faker.code().isbn10(true));
        System.out.println("ISBN13: " + faker.code().isbn13(true));
        System.out.println("--------------------------------------------------------");
        System.out.println("Cores: " + faker.color().name());
        System.out.println("Código de Cores: " + faker.color().hex());

        System.out.println("--------------------------------------------------------");
        System.out.println("Nome de Produto: " + faker.commerce().productName());
        System.out.println("Cor do Produto: " + faker.commerce().color());
        System.out.println("Departamento do Produto: " + faker.commerce().department());
        System.out.println("Preço: " + faker.commerce().price(2.0, 1000.0));
        System.out.println("Material: " + faker.commerce().material());

        System.out.println("--------------------------------------------------------");
        System.out.println("Nome de Campus: " + faker.educator().campus());
        System.out.println("Nome curso: " + faker.educator().course());
        System.out.println("Escola secundária: " + faker.educator().secondarySchool());
        System.out.println("Universidade: " + faker.educator().university());
    }
}

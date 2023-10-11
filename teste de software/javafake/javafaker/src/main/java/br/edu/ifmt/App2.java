package br.edu.ifmt;

import com.github.javafaker.service.RandomService;

public class App2 {
    public static void main (String[] args) {
        RandomService randomService = new RandomService();
        System.out.println("Hex: " + randomService.hex());
        System.out.println("Hex: " + randomService.hex(10));
        System.out.println("Next Boolean: " + randomService.nextBoolean());
        System.out.println("Next Int: " + randomService.nextInt(1000));
        System.out.println("Next Long: " + randomService.nextLong(100000));
        System.out.println("Next Double: " + randomService.nextDouble());
    }
}

package org.example;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Loteria {

    public static void loteria() {
        System.out.println("\n*** Witaj w loterii ***");
        System.out.println("\nPodaj 6 cyfr z przedziału 1-24");
        int chances = 6;
        final Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i < chances; i++) {
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            if (number < 1 || number > 24) {
                System.out.println("Podaj liczbę z przedziału");
                chances = chances + 1;
            } else {
                if (numbers.contains(number)) {
                    System.out.println("Liczba została już podana");
                    chances = chances + 1;
                } else {
                    numbers.add(number);
                }
            }
        }
        System.out.println("Twoje liczby to: " + numbers);

        final Set<Integer> drawings = new HashSet<>();

        for (int i = 0; i < chances; i++) {
            Random drawing = new Random();
            int draw = drawing.nextInt(24) + 1;
            if (drawings.contains(draw)) {
                chances = chances + 1;
            }
            drawings.add(draw);

        }

        System.out.println("Wylosowane liczby to: " + drawings);

        long count = numbers.stream().filter(tempstring -> {
            return drawings.stream().anyMatch(tempstring2 -> {
                return tempstring.equals(tempstring2);
            });
        }).count();

        int win = 0;
        if (count == 6) {
            win = win + 1500000;
        } else if (count == 5) {
            win = win + 4000;
        } else if (count == 4) {
            win = win + 200;
        } else if (count == 3) {
            win = win + 16;
        } else {
            win = win;
        }
        if (count > 0) {
            System.out.println("Gratuluje, trafiłeś: " + count);
            if (win > 0) {
                System.out.println("Twoja wygrana to: " + win + "zł");
            } else {
                System.out.println("Niestety, to za mało żeby cos wygrać");
            }
        }else {
            System.out.println("Przykro mi, nic nie trafiłeś");
        }

    }
}

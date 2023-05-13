package org.example;

import java.util.Random;
import java.util.Scanner;

public class Asystent {

    public static String[] opcje = new String[]{
            "Czas na Loterię!",
            "Zagrajmy w Wisielca!"
    };

    public static void rozpocznijProgram() {
        generujPowitanie();
        uruchomMenu();
        generujPożegnanie();
    }

    public static void generujPowitanie() {
        String[] listaPowitań = new String[]{
                "Witaj w asystencie",
                "Dzień dobry!",
                "Hello world!",
                "Bonjour!",
                "Hejooo"
        };
        Random random = new Random();
        String powitanie = listaPowitań[random.nextInt(listaPowitań.length)];
        System.out.println(powitanie);
    }

    public static void generujPożegnanie() {
        String[] listaPożegnań = new String[]{
                "pa!",
                "papa!",
                "papapa!",
                "papapapa!",
                "papapapapa!"
        };
        Random random = new Random();
        String pożegnanie = listaPożegnań[random.nextInt(listaPożegnań.length)];
        System.out.println(pożegnanie);
    }

    public static void uruchomMenu() {
        System.out.println("\nMenu:");
        drukujListeOpcji();
        pobierzWybór();
    }

    public static void drukujListeOpcji() {
        System.out.println("1. " + opcje[0]);
        System.out.println("2. " + opcje[1]);
        System.out.println("3. Zakończ program");
    }

    public static void pobierzWybór() {
        System.out.println("\nWybierz co chcesz robić: ");
        Scanner scanner = new Scanner(System.in);
        int wybór = scanner.nextInt();
        if (wybór == 1) {
            Loteria.loteria();
            uruchomMenu();
        } else if (wybór == 2) {
            Wisielec.wisielec();
            uruchomMenu();
        } else if (wybór == 3) {

        } else {
            System.out.println("\nNiewłaściwa opcja");
            pobierzWybór();
        }
        //todo łapanie wyjątków (wartość poza liczbą)

    }

    //todo uruchomOpcje
//    public static void uruchomOpcję(int uruchom) {
//    }
}


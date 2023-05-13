package org.example;

import java.util.Random;
import java.util.Scanner;

public class Wisielec {
    private static String[] passwords = new String[]{
            "wyimaginowany konsultant" ,
            "rubieżne rusałki",
            "europarlamentarzysta ortodoksyjny",
            "gawiedź onieśmielona",
            "chędogi apartamentowiec",
            "podatek katastralny",
            "ewidencja podatkowa"
    };
    static Random random = new Random();
    public static String password = passwords[random.nextInt(passwords.length)];

    public static void wisielec() {
        int chances = 10;
        System.out.println("\n*** Witaj w grze wisielec ***");
        System.out.println("\nMasz " + chances + " szans");
        System.out.print("Twoje hasło to: ");

        char[] passwordTable = password.toCharArray();
        char[] sign = new char[passwordTable.length];
        for (int i = 0; i < passwordTable.length; i++) {
            if (passwordTable[i] == ' ') {
                sign[i] = ' ';
            } else {
                sign[i] = '_';
            }
        }
        System.out.println(sign);

        System.out.println("Podaj literę");
        for (int x = 0; x < 100; x++) {

            Scanner scanner = new Scanner(System.in);
            String letter = scanner.nextLine();
            letter.toLowerCase();

            int notCorrectLetter = 0;
            for (int i = 0; i < passwordTable.length; i++) {

                if (passwordTable[i] != letter.charAt(0)) {
                    notCorrectLetter = notCorrectLetter + 1;
                } else {
                    sign[i] = letter.charAt(0);
                }

            }
            if (chances == 1) {
                System.out.println("WISIELEC!");
                break;
            } else if (notCorrectLetter == passwordTable.length) {
                chances = chances - 1;
                System.out.println("Zła odpowiedź, masz " + chances + " szans");
                System.out.print("Spróbuj jeszcze raz: ");
            } else if (!isHiddenLetter(sign)) {
                System.out.println("Wygrałeś!");
                System.out.println("Hasło to: " + password);
                break;
            } else {
                System.out.println("Good job");
            }
            System.out.println(sign);
        }
    }

    static boolean isHiddenLetter(char[] sign) {
        for (char s : sign) {
            if (s == '_') {
                return true;
            }
        }
        return false;
    }
}

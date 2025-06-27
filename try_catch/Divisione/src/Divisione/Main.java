package Divisione;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il primo numero:");
        int n1 = scanner.nextInt();

        System.out.println("Inserisci il secondo numero:");
        int n2 = scanner.nextInt();

        try {
        	Divisione d = new Divisione(n1,n2);
        	System.out.println("Risultato: " + d.calcola());
        } catch (ArithmeticException e) {
            System.out.println("Errore: divisione per zero.");
        }finally {
            scanner.close();
        }
    }
}

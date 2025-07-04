package Studente;

public class Main {
    public static void main(String[] args) {
        Studente studente1 = new Studente("Mario", "Rossi", 2004);
        Studente studente2 = new Studente("Luca", "Bianchi", 2003);

        studente1.stampaScheda();
        studente2.stampaScheda();
    }
}


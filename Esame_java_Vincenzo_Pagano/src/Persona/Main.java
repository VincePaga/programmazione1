package Persona;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Giulia", "Verdi");
        Studente studente1 = new Studente("Marco", "Rossi", "S1234");
        Professore professore1 = new Professore("Luca", "Bianchi", "Matematica");

        Persona[] persone = { persona1, studente1, professore1 };

        for (Persona p : persone) {
            p.presentati();
        }
    }
}


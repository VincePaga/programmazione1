package Persona;

public class Main {
    public static void main(String[] args) {
        Persona personaGenerica = new Persona("Anna", "Verdi");
        Studente studente = new Studente("Luca", "Bianchi", "S123");
        Professore professore = new Professore("Marco", "Rossi", "Matematica");

        Persona[] persone = {personaGenerica, studente, professore};

        for (Persona p : persone) {
            p.presentati();
        }
    }
}


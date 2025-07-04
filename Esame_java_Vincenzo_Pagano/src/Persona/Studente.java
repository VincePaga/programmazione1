package Persona;

public class Studente extends Persona {
    String matricola;

    public Studente(String nome, String cognome, String matricola) {
        super(nome, cognome); 
        this.matricola = matricola;
    }

    @Override
    public void presentati() {
        System.out.println("Sono lo studente " + nome + " " + cognome + ", matricola: " + matricola);
    }
}

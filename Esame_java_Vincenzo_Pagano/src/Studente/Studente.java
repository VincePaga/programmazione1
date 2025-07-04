package Studente;

public class Studente {
    String nome;
    String cognome;
    int annoNascita;

    public Studente(String nome, String cognome, int annoNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.annoNascita = annoNascita;
    }

    public void stampaScheda() {
        System.out.println(nome + " " + cognome + ", nato nel " + annoNascita);
    }
}


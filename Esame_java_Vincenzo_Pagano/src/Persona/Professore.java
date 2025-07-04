package Persona;

public class Professore extends Persona {
    String materia;

    public Professore(String nome, String cognome, String materia) {
        super(nome, cognome);
        this.materia = materia;
    }

    @Override
    public void presentati() {
        System.out.println("Sono il prof. " + nome + " " + cognome + ", insegno " + materia);
    }
}

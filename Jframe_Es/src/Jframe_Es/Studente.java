package Jframe_Es;

public class Studente extends Persona {
	private String matricola;
	
	public Studente(String nome, String cognome, String matricola) {
		super(nome, cognome);
		this.setMatricola(matricola);
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	@Override
	public String toString() {
		return "Ciao mi chiamo" + getNome() + " " + getCognome() + "con codice matricola" + matricola;
	}
}
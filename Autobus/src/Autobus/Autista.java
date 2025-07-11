package Autobus;

public class Autista extends Persona implements UtenteAutobus {
	private String patente;
	private int esperienza;
	
	public Autista(String nome, String cognome, String codicefiscale, String patente, int esperienza) {
		super(nome, cognome, codicefiscale);
		this.patente = patente;
		this.esperienza = esperienza;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public int getEsperienza() {
		return esperienza;
	}

	public void setEsperienza(int esperienza) {
		this.esperienza = esperienza;
	}

	@Override
	public String toString() {
	    return getNome() + " " + getCognome() + " (CF: " + getCodicefiscale() + "), Patente: " + patente + ", Esperienza: " + getEsperienza() + " anni";
	}

	@Override
	public String getTipo() {
		return "Autista";
	}

}

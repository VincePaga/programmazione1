package Autobus;

public class Passeggero extends Persona implements UtenteAutobus {
	private boolean bagaglio;
	private String destinazione;
	
	public Passeggero(String nome, String cognome, String codicefiscale, String destinazione, boolean bagaglio) {
		super(nome, cognome, codicefiscale);
		this.bagaglio = bagaglio;
		this.destinazione = destinazione;
	}

	public boolean isBagnaglio() {
		return bagaglio;
	}

	public void setBagnaglio(boolean bagnaglio) {
		this.bagaglio = bagnaglio;
	}

	public String getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}

	@Override
	public String toString() {
	    return getNome() + " " + getCognome() + " (CF: " + getCodicefiscale() + "), Destinazione: " + destinazione + (bagaglio ? ", Bagaglio: Sì" : ", Bagaglio: No");
	}

	@Override
	public String getTipo() {
		return "Passeggero";
	}
}

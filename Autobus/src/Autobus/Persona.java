package Autobus;

abstract class Persona implements UtenteAutobus{
	private String nome; 
	private String cognome;
	private String codicefiscale;
	
	public Persona(String nome, String cognome, String codicefiscale) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codicefiscale = codicefiscale;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodicefiscale() {
		return codicefiscale;
	}

	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}
	
}

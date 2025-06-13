package Animale;

public abstract class Animale {
	public String nome;
	public abstract void emettiVerso();
	public void descrizione() {
		System.out.println("Sono un animale di nome: " + nome);
	};
	
	public Animale(String nome) {
		this.nome = nome;
	}
}

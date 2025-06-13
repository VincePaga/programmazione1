package Animale;

public class Cane extends Animale{

	public Cane(String nome) {
		super(nome);
	}

	@Override
	public void emettiVerso() {
		System.out.println(nome + " dice: Bau ");
	}

}

package Divisione;

public class Divisione {
	private int numero1;
	private int numero2;
	
	public Divisione(int numero1, int numero2) {
		this.numero1 = numero1;
		this.numero2 = numero2;
	}
	
	   public int calcola() throws ArithmeticException {
	        return numero1 / numero2;
	}
}


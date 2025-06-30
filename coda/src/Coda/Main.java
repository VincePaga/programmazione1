package Coda;

public class Main {
	public static void main (String[] args) {
		Posta posta = new Posta();
		
		posta.entraInCoda(new Persona("Mario"));
		posta.entraInCoda(new Persona("Marco"));
		posta.entraInCoda(new Persona("Pippo"));
		
		System.out.println("Mostra coda:");
		posta.mostraCOda();
		System.out.println("Il prossimo da servire è: ");
		posta.chiEIlProssimo();
		System.out.println("Il prossimo è: ");
		posta.servireProssimo();
		System.out.println("Il prossimo 2 è: ");
		posta.servireProssimo();
		System.out.println(" ");
		System.out.println("L'ultimo è:");
		posta.mostraCOda();	
	}
}

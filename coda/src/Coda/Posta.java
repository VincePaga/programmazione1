package Coda;
import java.util.LinkedList;
import java.util.Queue;

public class Posta {
	Queue<Persona> coda = new LinkedList<>();
	
	public void entraInCoda(Persona p) {
		coda.add(p);
	} 	
	public void chiEIlProssimo() {
		Persona prossimo = coda.peek();
		if (prossimo != null) {
			System.out.println(prossimo.getNome());
		} else {
			System.out.println("Nessuno in coda.");
		}
	}
	public void servireProssimo() {
		Persona servito = coda.poll();
		if (servito != null) {
			System.out.println(servito.getNome());
		} else {
			System.out.println("Nessuno da servire.");
		}
	}
	public void mostraCOda() {
		for (Persona per : coda) {
			System.out.println(per.nome);
		}
	}
}

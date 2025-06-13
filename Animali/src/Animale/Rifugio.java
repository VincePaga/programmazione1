package Animale;
import java.util.ArrayList;

public class Rifugio {
	private ArrayList<Animale> animali = new ArrayList<>();
	
	public void aggiungiAnimale(Animale a) {
		animali.add(a);
	}
	
	public void stampaVersi() {
		for (Animale a : animali) {
			a.emettiVerso();
		}
	}
	public void descrizione() {
		for (Animale a : animali) {
			a.descrizione();
		}
	}
}

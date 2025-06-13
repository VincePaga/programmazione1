package Animale;

public class Main {
    public static void main(String[] args) {

    	Rifugio rifugio = new Rifugio();
	
    	Animale cane1 = new Cane("Fido");
    	Animale gatto1 = new Gatto("Ellie");
	
    	rifugio.aggiungiAnimale(cane1);
    	rifugio.aggiungiAnimale(gatto1);
	
    	rifugio.stampaVersi();
    	rifugio.descrizione();
    }
}

;
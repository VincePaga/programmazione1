package Autobus;
import java.util.ArrayList;

public class GestoreAutobus {
    private ArrayList<UtenteAutobus> utenti = new ArrayList<>();
    private final int maxPasseggeri = 20;
    private  final int maxAutisti = 2;

    public int getMaxPasseggeri() {
        return maxPasseggeri;
    }

    public int getMaxAutisti() {
        return maxAutisti;
    }

    public ArrayList<UtenteAutobus> getUtenti() {
        return utenti;
    }

    private int contaPasseggeri() {
        int count = 0;
        for (UtenteAutobus u : utenti) {
            if (u.getTipo().equals("Passeggero")) count++;
        }
        return count;
    }

    private int contaAutisti() {
        int count = 0;
        for (UtenteAutobus u : utenti) {
            if (u.getTipo().equals("Autista")) count++;
        }
        return count;
    }

    public void aggiungiPasseggero(Passeggero p) throws PostiEsauritiPasseggeroException {
        if (contaPasseggeri() >= maxPasseggeri) {
            throw new PostiEsauritiPasseggeroException();
        }
        else {
            utenti.add(p);
        }

    }

    public void aggiungiAutista(Autista a) throws PostiEsauritiAutistaException {
        if (contaAutisti() >= maxAutisti) {
            throw new PostiEsauritiAutistaException();
        }
        else {
            utenti.add(a);
        }
    }
}
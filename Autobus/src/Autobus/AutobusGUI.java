package Autobus;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class AutobusGUI extends JFrame {

    private GestoreAutobus gestore = new GestoreAutobus();

    private JLabel labelPasseggeri;
    private JLabel labelAutisti;
    private DefaultListModel<String> listaUtentiModel;
    private JList<String> listaUtenti;

    public AutobusGUI() {
        setTitle("Sistema Prenotazione Autobus");
        setSize(1200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 15));

        // Titolo grande
        JLabel titolo = new JLabel("Sistema di Prenotazione Autobus", SwingConstants.CENTER);
        titolo.setFont(new Font("SansSerif", Font.BOLD, 22));
        titolo.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(titolo, BorderLayout.NORTH);

        // Pannello centrale con info e lista utenti
        JPanel centro = new JPanel(new GridLayout(1, 2, 15, 10));

        // Posti disponibili
        JPanel pannelloInfo = new JPanel(new GridLayout(2, 1, 10, 10));
        pannelloInfo.setBorder(new CompoundBorder(
                new TitledBorder("Posti disponibili"),
                new EmptyBorder(10, 10, 10, 10)
        ));
        labelPasseggeri = new JLabel();
        labelAutisti = new JLabel();
        labelPasseggeri.setFont(new Font("SansSerif", Font.PLAIN, 16));
        labelAutisti.setFont(new Font("SansSerif", Font.PLAIN, 16));
        pannelloInfo.add(labelPasseggeri);
        pannelloInfo.add(labelAutisti);

        centro.add(pannelloInfo);

        // Lista utenti
        listaUtentiModel = new DefaultListModel<>();
        listaUtenti = new JList<>(listaUtentiModel);
        listaUtenti.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(listaUtenti);
        scrollPane.setBorder(new TitledBorder("Utenti registrati"));
        centro.add(scrollPane);

        add(centro, BorderLayout.CENTER);

        // Pannello inferiore per pulsanti
        JPanel pannelloBottoni = new JPanel(new GridLayout(1, 2, 20, 10));
        pannelloBottoni.setBorder(new EmptyBorder(10, 20, 20, 20));

        JButton btnAggiungiPasseggero = new JButton("➕ Aggiungi Passeggero");
        JButton btnAggiungiAutista = new JButton("➕ Aggiungi Autista");

        btnAggiungiPasseggero.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnAggiungiAutista.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnAggiungiPasseggero.setBackground(new Color(0, 153, 255));
        btnAggiungiAutista.setBackground(new Color(0, 204, 102));
        btnAggiungiPasseggero.setForeground(Color.BLACK); // colore testo visibile
        btnAggiungiAutista.setForeground(Color.BLACK);

        btnAggiungiPasseggero.addActionListener(e -> aggiungiPasseggero());
        btnAggiungiAutista.addActionListener(e -> aggiungiAutista());

        pannelloBottoni.add(btnAggiungiPasseggero);
        pannelloBottoni.add(btnAggiungiAutista);

        add(pannelloBottoni, BorderLayout.SOUTH);

        aggiornaEtichette();
        setVisible(true);
    }

    private void aggiungiPasseggero() {
        JPanel pannello = new JPanel(new GridLayout(5, 2, 5, 5));
        JTextField campoNome = new JTextField();
        JTextField campoCognome = new JTextField();
        JTextField campoCF = new JTextField();
        JTextField campoDestinazione = new JTextField();
        JCheckBox checkBagaglio = new JCheckBox("Ha bagaglio?");

        pannello.add(new JLabel("Nome:"));
        pannello.add(campoNome);
        pannello.add(new JLabel("Cognome:"));
        pannello.add(campoCognome);
        pannello.add(new JLabel("Codice Fiscale:"));
        pannello.add(campoCF);
        pannello.add(new JLabel("Destinazione:"));
        pannello.add(campoDestinazione);
        pannello.add(new JLabel(""));
        pannello.add(checkBagaglio);

        int risultato = JOptionPane.showConfirmDialog(this, pannello, "Aggiungi Passeggero", JOptionPane.OK_CANCEL_OPTION);
        if (risultato == JOptionPane.OK_OPTION) {
            try {
                Passeggero p = new Passeggero(
                        campoNome.getText().trim(),
                        campoCognome.getText().trim(),
                        campoCF.getText().trim(),
                        campoDestinazione.getText().trim(),
                        checkBagaglio.isSelected()
                );
                gestore.aggiungiPasseggero(p);
                aggiornaEtichette();
                aggiornaListaUtenti();
            } catch (PostiEsauritiPasseggeroException ex) {
                JOptionPane.showMessageDialog(this, "Posti per passeggeri esauriti!", "Errore", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void aggiungiAutista() {
        JPanel pannello = new JPanel(new GridLayout(5, 2, 5, 5));
        JTextField campoNome = new JTextField();
        JTextField campoCognome = new JTextField();
        JTextField campoCF = new JTextField();
        JTextField campoPatente = new JTextField();
        JTextField campoEsperienza = new JTextField();

        pannello.add(new JLabel("Nome:"));
        pannello.add(campoNome);
        pannello.add(new JLabel("Cognome:"));
        pannello.add(campoCognome);
        pannello.add(new JLabel("Codice Fiscale:"));
        pannello.add(campoCF);
        pannello.add(new JLabel("Patente:"));
        pannello.add(campoPatente);
        pannello.add(new JLabel("Anni di Esperienza:"));
        pannello.add(campoEsperienza);

        int risultato = JOptionPane.showConfirmDialog(this, pannello, "Aggiungi Autista", JOptionPane.OK_CANCEL_OPTION);
        if (risultato == JOptionPane.OK_OPTION) {
            try {
                int anniExp = Integer.parseInt(campoEsperienza.getText().trim());
                Autista a = new Autista(
                        campoNome.getText().trim(),
                        campoCognome.getText().trim(),
                        campoCF.getText().trim(),
                        campoPatente.getText().trim(),
                        anniExp
                );
                gestore.aggiungiAutista(a);
                aggiornaEtichette();
                aggiornaListaUtenti();
            } catch (PostiEsauritiAutistaException ex) {
                JOptionPane.showMessageDialog(this, "Posti per autisti esauriti!", "Errore", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Inserisci un numero valido per anni di esperienza.", "Errore", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void aggiornaEtichette() {
        int rimanentiPasseggeri = gestore.getMaxPasseggeri() - conta("Passeggero");
        int rimanentiAutisti = gestore.getMaxAutisti() - conta("Autista");
        labelPasseggeri.setText("🚍 Posti passeggeri rimanenti: " + rimanentiPasseggeri);
        labelAutisti.setText("🚌 Posti autisti rimanenti: " + rimanentiAutisti);
    }

    private void aggiornaListaUtenti() {
        listaUtentiModel.clear();
        List<UtenteAutobus> utenti = gestore.getUtenti();
        for (UtenteAutobus u : utenti) {
            listaUtentiModel.addElement(u.getTipo() + ": " + u.toString());
        }
    }

    private int conta(String tipo) {
        int count = 0;
        for (UtenteAutobus u : gestore.getUtenti()) {
            if (u.getTipo().equals(tipo)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AutobusGUI::new);
    }
}


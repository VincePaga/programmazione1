package Jframe_Es;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AppGUI extends JFrame {
    private JButton bottoneStudente;
    private JButton bottoneProfessore;
    private JButton bottoneRiepilogo;

    private ArrayList<Studente> arrayStudenti = new ArrayList<>();
    private ArrayList<Professore> arrayProfessori = new ArrayList<>();

    public AppGUI() {
        setTitle("Gestione Scuola");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        bottoneStudente = new JButton("Aggiungi Studente");
        bottoneProfessore = new JButton("Aggiungi Professore");
        bottoneRiepilogo = new JButton("Mostra Riepilogo");

        add(bottoneStudente);
        add(bottoneProfessore);
        add(bottoneRiepilogo);

        // Listener per Studente
        bottoneStudente.addActionListener(e -> apriFinestraStudente());

        // Listener per Professore
        bottoneProfessore.addActionListener(e -> apriFinestraProfessore());

        // Listener per Riepilogo
        bottoneRiepilogo.addActionListener(e -> mostraRiepilogo());

        setVisible(true);
    }

    // Metodo per aprire finestra Studente
    private void apriFinestraStudente() {
        JFrame frameStudente = new JFrame("Aggiungi Studente");
        frameStudente.setSize(300, 200);
        frameStudente.setLayout(new GridLayout(4, 2));

        JTextField campoNome = new JTextField();
        JTextField campoCognome = new JTextField();
        JTextField campoMatricola = new JTextField();
        JButton bottoneAggiungi = new JButton("Aggiungi");

        frameStudente.add(new JLabel("Nome:"));
        frameStudente.add(campoNome);
        frameStudente.add(new JLabel("Cognome:"));
        frameStudente.add(campoCognome);
        frameStudente.add(new JLabel("Matricola:"));
        frameStudente.add(campoMatricola);
        frameStudente.add(bottoneAggiungi);

        bottoneAggiungi.addActionListener(e -> {
            String nome = campoNome.getText();
            String cognome = campoCognome.getText();
            String matricola = campoMatricola.getText();

            if (!nome.isEmpty() && !cognome.isEmpty() && !matricola.isEmpty()) {
                Studente s = new Studente(nome, cognome, matricola);
                arrayStudenti.add(s);
                JOptionPane.showMessageDialog(frameStudente, "Studente aggiunto con successo!");
                frameStudente.dispose(); // Chiudi la finestra dopo aggiunta
            } else {
                JOptionPane.showMessageDialog(frameStudente, "Compila tutti i campi!", "Errore", JOptionPane.ERROR_MESSAGE);
            }
        });

        frameStudente.setVisible(true);
    }

    // Metodo per aprire finestra Professore
    private void apriFinestraProfessore() {
        JFrame frameProfessore = new JFrame("Aggiungi Professore");
        frameProfessore.setSize(300, 200);
        frameProfessore.setLayout(new GridLayout(4, 2));

        JTextField campoNome = new JTextField();
        JTextField campoCognome = new JTextField();
        JTextField campoMateria = new JTextField();
        JButton bottoneAggiungi = new JButton("Aggiungi");

        frameProfessore.add(new JLabel("Nome:"));
        frameProfessore.add(campoNome);
        frameProfessore.add(new JLabel("Cognome:"));
        frameProfessore.add(campoCognome);
        frameProfessore.add(new JLabel("Materia:"));
        frameProfessore.add(campoMateria);
        frameProfessore.add(bottoneAggiungi);

        bottoneAggiungi.addActionListener(e -> {
            String nome = campoNome.getText();
            String cognome = campoCognome.getText();
            String materia = campoMateria.getText();

            if (!nome.isEmpty() && !cognome.isEmpty() && !materia.isEmpty()) {
                Professore p = new Professore(nome, cognome, materia);
                arrayProfessori.add(p);
                JOptionPane.showMessageDialog(frameProfessore, "Professore aggiunto con successo!");
                frameProfessore.dispose(); // Chiudi la finestra dopo aggiunta
            } else {
                JOptionPane.showMessageDialog(frameProfessore, "Compila tutti i campi!", "Errore", JOptionPane.ERROR_MESSAGE);
            }
        });

        frameProfessore.setVisible(true);
    }

    // Metodo per mostrare riepilogo
    private void mostraRiepilogo() {
        JFrame frameRiepilogo = new JFrame("Riepilogo Dati");
        frameRiepilogo.setSize(400, 400);
        JTextArea areaRiepilogo = new JTextArea();
        areaRiepilogo.setEditable(false);

        StringBuilder sb = new StringBuilder();
        sb.append("=== Studenti ===\n");
        for (Studente s : arrayStudenti) {
            sb.append(s.toString()).append("\n");
        }

        sb.append("\n=== Professori ===\n");
        for (Professore p : arrayProfessori) {
            sb.append(p.toString()).append("\n");
        }

        areaRiepilogo.setText(sb.toString());
        frameRiepilogo.add(new JScrollPane(areaRiepilogo));
        frameRiepilogo.setVisible(true);
    }
}


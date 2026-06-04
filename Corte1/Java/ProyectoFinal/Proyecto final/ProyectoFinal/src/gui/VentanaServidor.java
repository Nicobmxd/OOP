package gui;

import servidor.Servidor;

import javax.swing.*;
import java.awt.*;

public class VentanaServidor extends JFrame {

    private JTextArea areaLog;
    private JTextField txtPuerto;
    private JButton btnIniciar;

    public VentanaServidor() {

        setTitle("Servidor de Sensores");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel superior = new JPanel();

        superior.add(new JLabel("Puerto:"));

        txtPuerto = new JTextField("5000", 8);
        superior.add(txtPuerto);

        btnIniciar = new JButton("Iniciar Servidor");
        superior.add(btnIniciar);

        add(superior, BorderLayout.NORTH);

        areaLog = new JTextArea();

        areaLog.setEditable(false);

        add(
                new JScrollPane(areaLog),
                BorderLayout.CENTER
        );

        btnIniciar.addActionListener(e -> iniciarServidor());
    }

    private void iniciarServidor() {

        int puerto =
                Integer.parseInt(
                        txtPuerto.getText()
                );

        btnIniciar.setEnabled(false);

        Thread hilo = new Thread(() -> {

            try {

                areaLog.append(
                        "Servidor iniciado en puerto "
                        + puerto + "\n"
                );

                Servidor servidor =
                        new Servidor(puerto);

                servidor.iniciar();

            } catch (Exception ex) {

                areaLog.append(
                        "Error: "
                        + ex.getMessage()
                        + "\n"
                );
            }
        });

        hilo.start();
    }
}
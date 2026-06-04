package gui;

import cliente.ClienteSocket;
import modelo.*;

import javax.swing.*;
import java.awt.*;

public class VentanaCliente extends JFrame {

    private JTextField txtHost;
    private JTextField txtPuerto;
    private JTextField txtId;

    private JComboBox<String> comboSensor;

    private JTextArea areaResultado;

    public VentanaCliente() {

        setTitle("Cliente Sensor");

        setSize(600, 450);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        panel.setLayout(
                new GridLayout(5,2)
        );

        panel.add(new JLabel("Servidor"));

        txtHost =
                new JTextField("localhost");

        panel.add(txtHost);

        panel.add(new JLabel("Puerto"));

        txtPuerto =
                new JTextField("5000");

        panel.add(txtPuerto);

        panel.add(new JLabel("ID Sensor"));

        txtId =
                new JTextField("S01");

        panel.add(txtId);

        panel.add(new JLabel("Tipo Sensor"));

        comboSensor =
                new JComboBox<>();

        comboSensor.addItem("TEMPERATURA");
        comboSensor.addItem("VOLTAJE");
        comboSensor.addItem("DISTANCIA");

        panel.add(comboSensor);

        JButton btnEnviar =
                new JButton(
                        "Generar y Enviar"
                );

        panel.add(btnEnviar);

        add(panel, BorderLayout.NORTH);

        areaResultado =
                new JTextArea();

        areaResultado.setEditable(false);

        add(
                new JScrollPane(areaResultado),
                BorderLayout.CENTER
        );

        btnEnviar.addActionListener(
                e -> enviarMedicion()
        );
    }

    private void enviarMedicion() {

        try {

            String id =
                    txtId.getText();

            String tipo =
                    comboSensor
                            .getSelectedItem()
                            .toString();

            SensorSimulado sensor;

            switch (tipo) {

                case "TEMPERATURA":

                    sensor =
                            new SensorTemperatura(id);

                    break;

                case "VOLTAJE":

                    sensor =
                            new SensorVoltaje(id);

                    break;

                default:

                    sensor =
                            new SensorDistancia(id);
            }

            Medicion medicion =
                    sensor.generarMedicion();

            String mensaje =
                    medicion
                            .toMensajeSocket();

            ClienteSocket cliente =
                    new ClienteSocket(
                            txtHost.getText(),
                            Integer.parseInt(
                                    txtPuerto.getText()
                            )
                    );

            String respuesta =
                    cliente.enviarMedicion(
                            mensaje
                    );

            areaResultado.append(
                    "\nEnviado: "
                    + mensaje
                    + "\n"
            );

            areaResultado.append(
                    "Servidor: "
                    + respuesta
                    + "\n"
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: "
                    + e.getMessage()
            );
        }
    }
}
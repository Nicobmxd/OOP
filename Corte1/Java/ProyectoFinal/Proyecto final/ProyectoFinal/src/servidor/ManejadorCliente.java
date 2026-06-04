package servidor;

import modelo.Medicion;
import persistencia.CSVManager;

import java.io.*;
import java.net.Socket;

public class ManejadorCliente extends Thread {

    private Socket socket;
    private CSVManager csv;

    public ManejadorCliente(
            Socket socket,
            CSVManager csv) {

        this.socket = socket;
        this.csv = csv;
    }

    @Override
    public void run() {

        try {

            BufferedReader entrada =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()
                            )
                    );

            PrintWriter salida =
                    new PrintWriter(
                            socket.getOutputStream(),
                            true
                    );

            String mensaje;

            while ((mensaje =
                    entrada.readLine()) != null) {

                String[] partes =
                        mensaje.split(";");

                if (partes.length != 4) {

                    salida.println(
                            "ERROR;Formato incorrecto"
                    );

                    continue;
                }

                String id = partes[0];
                String tipo = partes[1];

                double valor;

                try {

                    valor =
                            Double.parseDouble(
                                    partes[2]
                            );

                } catch (Exception e) {

                    salida.println(
                            "ERROR;Valor invalido"
                    );

                    continue;
                }

                String unidad = partes[3];

                String estado =
                        calcularEstado(
                                tipo,
                                valor
                        );

                if (estado.equals("ERROR")) {

                    salida.println(
                            "ERROR;Tipo no reconocido"
                    );

                    continue;
                }

                Medicion medicion =
                        new Medicion(
                                id,
                                tipo,
                                valor,
                                unidad,
                                estado
                        );

                csv.guardar(medicion);

                System.out.println(
                        mensaje +
                        " -> " +
                        estado
                );

                salida.println(
                        "OK;Medicion recibida"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Cliente desconectado"
            );
        }
    }

    private String calcularEstado(
            String tipo,
            double valor) {

        switch (tipo) {

            case "TEMPERATURA":

                return valor >= 70
                        ? "ALERTA"
                        : "NORMAL";

            case "VOLTAJE":

                return valor < 10.5
                        ? "BATERIA_BAJA"
                        : "NORMAL";

            case "DISTANCIA":

                return valor < 0.4
                        ? "OBSTACULO_CERCANO"
                        : "NORMAL";

            default:

                return "ERROR";
        }
    }
}
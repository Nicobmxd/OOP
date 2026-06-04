package servidor;

import persistencia.CSVManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private int puerto;
    private CSVManager csv;

    public Servidor(int puerto) {

        this.puerto = puerto;
        this.csv = new CSVManager("mediciones.csv");
    }

    public void iniciar() {

        try (ServerSocket serverSocket =
                     new ServerSocket(puerto)) {

            System.out.println(
                    "Servidor escuchando en puerto "
                    + puerto
            );

            while (true) {

                Socket cliente =
                        serverSocket.accept();

                System.out.println(
                        "Cliente conectado"
                );

                new ManejadorCliente(
                        cliente,
                        csv
                ).start();
            }

        } catch (IOException e) {

            System.out.println(
                    "Error en servidor"
            );
        }
    }
}
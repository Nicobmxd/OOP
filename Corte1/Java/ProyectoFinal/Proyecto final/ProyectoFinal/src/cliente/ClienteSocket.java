package cliente;

import java.io.*;
import java.net.Socket;

public class ClienteSocket {

    private String host;
    private int puerto;

    public ClienteSocket(String host, int puerto) {
        this.host = host;
        this.puerto = puerto;
    }

    public String enviarMedicion(String mensaje) {

        try (
                Socket socket = new Socket(host, puerto);

                PrintWriter salida =
                        new PrintWriter(
                                socket.getOutputStream(),
                                true
                        );

                BufferedReader entrada =
                        new BufferedReader(
                                new InputStreamReader(
                                        socket.getInputStream()
                                )
                        );
        ) {

            salida.println(mensaje);

            return entrada.readLine();

        } catch (Exception e) {

            return "ERROR;No se pudo conectar";
        }
    }
}
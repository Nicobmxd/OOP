package principal;

import cliente.ClienteSocket;
import modelo.*;

public class MainCliente {

    public static void main(String[] args) {

        SensorSimulado sensor =
                new SensorTemperatura("S01");

        Medicion medicion =
                sensor.generarMedicion();

        String mensaje =
                medicion.toMensajeSocket();

        ClienteSocket cliente =
                new ClienteSocket(
                        "localhost",
                        5000
                );

        String respuesta =
                cliente.enviarMedicion(
                        mensaje
                );

        System.out.println(
                "Enviado: " + mensaje
        );

        System.out.println(
                "Respuesta: " + respuesta
        );
    }
}
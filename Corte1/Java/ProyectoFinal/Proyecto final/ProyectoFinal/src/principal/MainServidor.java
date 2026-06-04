package principal;

import servidor.Servidor;

public class MainServidor {

    public static void main(String[] args) {

        Servidor servidor =
                new Servidor(5000);

        servidor.iniciar();
    }
}
package principal;

import gui.VentanaCliente;

public class MainClienteGUI {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(
                () -> {

                    new VentanaCliente()
                            .setVisible(true);

                }
        );
    }
}
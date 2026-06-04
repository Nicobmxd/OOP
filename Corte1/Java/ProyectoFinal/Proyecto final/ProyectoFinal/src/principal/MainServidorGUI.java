package principal;

import gui.VentanaServidor;

public class MainServidorGUI {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(
                () -> {

                    new VentanaServidor()
                            .setVisible(true);

                }
        );
    }
}
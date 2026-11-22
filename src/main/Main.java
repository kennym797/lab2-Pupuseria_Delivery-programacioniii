
package main;

import interfaces.Imprimible;
import modelo.*;
import excepciones.*;
import vista.VentanaPupuseria;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            VentanaPupuseria ventana = new VentanaPupuseria();
            ventana.setVisible(true);
        });

    }

}


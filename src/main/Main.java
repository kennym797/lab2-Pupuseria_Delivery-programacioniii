package main;

import vista.VentanaPupuseria;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Iniciar la interfaz gráfica Swing en el Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            VentanaPupuseria ventana = new VentanaPupuseria();
            ventana.setVisible(true);
        });
    }
}

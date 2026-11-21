package main;


import modelo.*;
import excepciones.*;

public class Main {

    // Recurso interno para probar try-with-resources
    static class RecursoPedido implements AutoCloseable {

        public RecursoPedido() {
            System.out.println("Iniciando procesamiento del pedido...");
        }

        public void procesar() {
            System.out.println("Procesando pedido...");
        }

        @Override
        public void close() {
            System.out.println("Cerrando recurso del pedido...");
        }
    }

    public static void main(String[] args) {

        try {

            System.out.println("SISTEMA PUPUSERIA DELIVERY");

            Producto pupusa = new Pupusa(
                    1, "Queso con Loroco", "Arroz", 1.25
            );

            Producto bebida = new Bebida(
                    2, "Horchata", 1.50, "Grande", true
            );

            Pedido pedido = new Pedido();

            pedido.agregarProducto(pupusa, 2);
            pedido.agregarProducto(bebida);

            System.out.println(pedido.generarTicket());

        } catch (ProductoInvalidoException |
                 PedidoInvalidoException e) {

            System.out.println("Error: " + e.getMessage());

        }

        // Prueba de try-with-resources
        try (RecursoPedido recurso = new RecursoPedido()) {

            recurso.procesar();

        } catch (Exception e) {

            System.out.println("Error al procesar: "
                    + e.getMessage());
        }
    }
}


package main;

import interfaces.Imprimible;
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

        System.out.println("========================================");
        System.out.println("       SISTEMA DE GESTIÓN DE PUPUSERÍA");
        System.out.println("========================================");

        // 1. Crear productos utilizando herencia y polimorfismo
        try {

            Producto pupusa1 = new Pupusa(
                    1, "Queso con Loroco", "Arroz", 1.25
            );

            Producto bebida1 = new Bebida(
                    2, "Horchata", 1.50, "Grande", true
            );

            // 2. Crear pedido
            Pedido miPedido = new Pedido();

            System.out.println("\n--- REGISTRANDO PRODUCTOS ---");

            miPedido.agregarProducto(pupusa1, 2);
            miPedido.agregarProducto(bebida1);

            // 3. Imprimir ticket utilizando la interfaz
            System.out.println("\n--- TICKET DE COMPRA ---");

            if (miPedido instanceof Imprimible) {
                System.out.println(miPedido.generarTicket());
            }

        } catch (ProductoInvalidoException |
                 PedidoInvalidoException e) {

            System.out.println("Error: " + e.getMessage());
        }

        // 4. Prueba de try-with-resources
        try (RecursoPedido recurso = new RecursoPedido()) {

            recurso.procesar();

        } catch (Exception e) {

            System.out.println("Error al procesar: "
                    + e.getMessage());
        }

        System.out.println("\n========================================");
        System.out.println("   INTEGRACIÓN FINALIZADA");
        System.out.println("========================================");
    }
}

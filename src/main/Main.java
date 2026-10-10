package main;

import interfaces.Imprimible;
import modelo.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   SISTEMA DE GESTIÓN DE PEDIDOS - PUPUSERÍA      ");
        System.out.println("==================================================\n");

        // 1. Instanciación con ID (Herencia e Integración de Clase Abstracta Producto)
        Producto pupusa1 = new Pupusa(1, "Queso con Loroco", "Arroz", 1.25);
        Producto pupusa2 = new Pupusa(2, "Chicharrón", "Maíz", 1.00);
        Producto bebida1 = new Bebida(3, "Horchata", 1.50, "Grande", true);
        Producto bebida2 = new Bebida(4, "Café de Palo", 1.00, "Mediano", false);

        // 2. Creación del Pedido y Polimorfismo por Sobrecarga de métodos
        System.out.println("--- REGISTRANDO PRODUCTOS AL PEDIDO ---");
        Pedido miPedido = new Pedido();
        miPedido.agregarProducto(pupusa1, 3); // Sobrecarga con cantidad
        miPedido.agregarProducto(pupusa2, 2); // Sobrecarga con cantidad
        miPedido.agregarProducto(bebida1);    // Sobrecarga unidad individual
        miPedido.agregarProducto(bebida2);    // Sobrecarga unidad individual

        // 3. Imprimir el Ticket usando la Interfaz Imprimible
        if (miPedido instanceof Imprimible) {
            System.out.println(miPedido.generarTicket());
        }

        System.out.println("¡Integración finalizada exitosamente!");
    }
}

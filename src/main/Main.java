package main;

import modelo.Producto;
import modelo.Pupusa;
import modelo.Bebida;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   SISTEMA DE GESTIÓN DE PEDIDOS - PUPUSERÍA      ");
        System.out.println("==================================================\n");

        // 1. Instanciación con ID (Herencia y Clase Abstracta Producto)
        Pupusa pupusa1 = new Pupusa(1, "Queso con Loroco", "Arroz", 1.25);
        Pupusa pupusa2 = new Pupusa(2, "Chicharrón", "Maíz", 1.00);
        Pupusa pupusa3 = new Pupusa(3, "Revuelta", "Maíz", 1.00);

        Bebida bebida1 = new Bebida(4, "Horchata", 1.50, "Grande", true);
        Bebida bebida2 = new Bebida(5, "Café de Palo", 1.00, "Mediano", false);

        // 2. Muestra del Menú disponible
        System.out.println("--- MENÚ DE PUPUSAS ---");
        System.out.println(pupusa1);
        System.out.println(pupusa2);
        System.out.println(pupusa3);

        System.out.println("\n--- MENÚ DE BEBIDAS ---");
        System.out.println(bebida1);
        System.out.println(bebida2);

        // 3. Polimorfismo con arreglo de la clase abstracta Producto
        System.out.println("\n--- DEMOSTRACIÓN DE POLIMORFISMO Y CÁLCULO DE PRECIOS ---");
        Producto[] ordenDemo = { pupusa1, pupusa2, bebida1, bebida2 };
        
        double totalPrueba = 0.0;
        for (Producto p : ordenDemo) {
            System.out.println("ID " + p.getId() + " | Producto: " + p.getNombre() + " | Precio: $" + String.format("%.2f", p.calcularPrecio()));
            totalPrueba += p.calcularPrecio();
        }

        System.out.println("\n==================================================");
        System.out.println(" Total estimado de la orden demo: $" + String.format("%.2f", totalPrueba));
        System.out.println("==================================================");
    }
}

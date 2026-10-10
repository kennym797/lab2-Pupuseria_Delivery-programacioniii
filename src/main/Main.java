package main;

import modelo.Producto;
import modelo.Pupusa;
import modelo.Bebida;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   SISTEMA DE GESTIÓN DE PEDIDOS - PUPUSERÍA      ");
        System.out.println("==================================================\n");

        // 1. Instanciación de productos usando Herencia (Pupusa y Bebida heredan de Producto)
        Pupusa pupusa1 = new Pupusa("Queso con Loroco", "Arroz", 1.25);
        Pupusa pupusa2 = new Pupusa("Chicharrón", "Maíz", 1.00);
        Pupusa pupusa3 = new Pupusa("Revuelta", "Maíz", 1.00);

        Bebida bebida1 = new Bebida("Horchata", 1.50, "Grande", true);
        Bebida bebida2 = new Bebida("Café de Palo", 1.00, "Mediano", false);

        // 2. Muestra del Menú disponible
        System.out.println("--- MENÚ DE PUPUSAS ---");
        System.out.println("1. " + pupusa1);
        System.out.println("2. " + pupusa2);
        System.out.println("3. " + pupusa3);

        System.out.println("\n--- MENÚ DE BEBIDAS ---");
        System.out.println("1. " + bebida1);
        System.out.println("2. " + bebida2);

        // 3. Demostración de Polimorfismo usando la superclase Producto
        System.out.println("\n--- DEMOSTRACIÓN DE POLIMORFISMO Y CÁLCULO DE PRECIOS ---");
        Producto[] ordenDemo = { pupusa1, pupusa2, bebida1, bebida2 };
        
        double totalPrueba = 0.0;
        for (Producto p : ordenDemo) {
            System.out.println("Producto: " + p.getNombre() + " | Precio: $" + String.format("%.2f", p.calcularPrecio()));
            totalPrueba += p.calcularPrecio();
        }

        System.out.println("\n==================================================");
        System.out.println(" Total estimado de la orden demo: $" + String.format("%.2f", totalPrueba));
        System.out.println("==================================================");
    }
}

package modelo;

import interfaces.Imprimible;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Imprimible {
    private List<Producto> listaProductos;

    public Pedido() {
        this.listaProductos = new ArrayList<>();
    }

    // Sobrecarga 1: Agrega una sola unidad de un producto
    public void agregarProducto(Producto p) {
        listaProductos.add(p);
        System.out.println("Se agregó 1 unidad de: " + p.getNombre());
    }

    // Sobrecarga 2: Agrega múltiples unidades de un producto
    public void agregarProducto(Producto p, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            listaProductos.add(p);
        }
        System.out.println("Se agregaron " + cantidad + " unidades de: " + p.getNombre());
    }

    // Método para calcular el total combinando sobrecarga y sobrescritura
    public double calcularTotalPedido() {
        double total = 0.0;
        for (Producto p : listaProductos) {
            total += p.calcularPrecio(); // Invoca dinámicamente el calcularPrecio() según el tipo real
        }
        return total;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    // Implementación del método heredado de la interfaz Imprimible
    @Override
    public String generarTicket() {
        StringBuilder ticket = new StringBuilder();
        ticket.append("\n==============================================\n");
        ticket.append("         TICKET DE COMPRA - PUPUSERÍA         \n");
        ticket.append("==============================================\n");
        for (Producto p : listaProductos) {
            ticket.append(String.format("- %-30s $%.2f\n", p.getNombre(), p.calcularPrecio()));
        }
        ticket.append("----------------------------------------------\n");
        ticket.append(String.format("TOTAL A PAGAR:                  $%.2f\n", calcularTotalPedido()));
        ticket.append("==============================================\n");
        return ticket.toString();
    }
}

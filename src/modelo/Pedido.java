package modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
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
}

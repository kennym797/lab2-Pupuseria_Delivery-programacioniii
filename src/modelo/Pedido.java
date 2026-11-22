
package modelo;

import interfaces.Imprimible;
import excepciones.PedidoInvalidoException;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Imprimible {

    private List<Producto> listaProductos;

    public Pedido() {
        this.listaProductos = new ArrayList<>();
    }

    // Agregar una sola unidad de un producto
    public void agregarProducto(Producto p)
            throws PedidoInvalidoException {

        agregarProducto(p, 1);
    }

    // Agregar varias unidades de un producto
    public void agregarProducto(Producto p, int cantidad)
            throws PedidoInvalidoException {

        if (p == null) {
            throw new PedidoInvalidoException(
                    "No se puede agregar un producto vacío"
            );
        }

        if (cantidad <= 0) {
            throw new PedidoInvalidoException(
                    "La cantidad debe ser mayor que cero"
            );
        }

        for (int i = 0; i < cantidad; i++) {
            listaProductos.add(p);
        }

        System.out.println(
                "Se agregaron " + cantidad +
                        " unidades de: " + p.getNombre()
        );
    }

    // Calcular el total del pedido
    public double calcularTotalPedido() {
        double total = 0.0;

        for (Producto p : listaProductos) {
            total += p.calcularPrecio();
        }

        return total;
    }

    // Obtener la lista de productos
    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    // Generar ticket de compra
    @Override
    public String generarTicket() {

        StringBuilder ticket = new StringBuilder();

        ticket.append("\n========================================\n");
        ticket.append("       TICKET DE COMPRA - PUPUSERÍA\n");
        ticket.append("========================================\n");

        for (Producto p : listaProductos) {
            ticket.append(
                    String.format("- %-30s $%.2f\n",
                            p.getNombre(), p.calcularPrecio())
            );
        }

        ticket.append("----------------------------------------\n");

        ticket.append(
                String.format("TOTAL A PAGAR:             $%.2f\n",
                        calcularTotalPedido())
        );

        ticket.append("========================================\n");

        return ticket.toString();
    }
}


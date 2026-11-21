package modelo;

import excepciones.ProductoInvalidoException;

public class Bebida extends Producto {
    private String tamano;
    private boolean esFria;

    public Bebida(int id, String nombre, double precioBase,
                  String tamano, boolean esFria)
            throws ProductoInvalidoException {

        super(id, nombre, precioBase);

        this.tamano = tamano;
        this.esFria = esFria;
    }

    public String getTamano() {
        return tamano;
    }

    public boolean isEsFria() {
        return esFria;
    }

    @Override
    public double calcularPrecio() {
        return precioBase;
    }

    @Override
    public String toString() {
        String temperatura = esFria ? "Helada" : "Caliente";
        return super.toString() + " [" + tamano + ", " + temperatura + "]";
    }
}
package modelo;

public class Bebida extends Producto {
    private String tamano; // Ej: "Mediano", "Grande"
    private boolean esFria;

    // Constructor adaptado a la superclase abstracta con id
    public Bebida(int id, String nombre, double precioBase, String tamano, boolean esFria) {
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

    // Implementación del método abstracto heredado
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

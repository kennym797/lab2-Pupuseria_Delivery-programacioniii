package modelo;

public abstract class Producto {
    protected int id;
    protected String nombre;
    protected double precioBase;

    // Constructor base
    public Producto(int id, String nombre, double precioBase) {
        this.id = id;
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    // Método abstracto (obliga a Pupusa y Bebida a implementarlo)
    public abstract double calcularPrecio();

    @Override
    public String toString() {
        return nombre + " - $" + String.format("%.2f", calcularPrecio());
    }
}

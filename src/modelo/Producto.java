
package modelo;

import excepciones.ProductoInvalidoException;

public abstract class Producto {

    protected int id;
    protected String nombre;
    protected double precioBase;

    // Constructor con validaciones
    public Producto(int id, String nombre, double precioBase)
            throws ProductoInvalidoException {

        if (id <= 0) {
            throw new ProductoInvalidoException(
                    "El ID del producto debe ser mayor que cero"
            );
        }

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ProductoInvalidoException(
                    "El nombre del producto no puede estar vacío"
            );
        }

        if (!Double.isFinite(precioBase) || precioBase <= 0) {
            throw new ProductoInvalidoException(
                    "El precio debe ser mayor que cero"
            );
        }

        this.id = id;
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    // Getters y setters
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
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nombre inválido"
            );
        }

        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        if (!Double.isFinite(precioBase) || precioBase <= 0) {
            throw new IllegalArgumentException(
                    "Precio inválido"
            );
        }

        this.precioBase = precioBase;
    }

    // Método abstracto
    public abstract double calcularPrecio();

    @Override
    public String toString() {
        return nombre + " - $" +
                String.format("%.2f", calcularPrecio());
    }
}


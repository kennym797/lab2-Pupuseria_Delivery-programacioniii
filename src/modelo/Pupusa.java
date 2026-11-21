package modelo;

import excepciones.ProductoInvalidoException;

public class Pupusa extends Producto {
    private String tipoMasa; // Ej: "Maíz" o "Arroz"
    private String relleno;  // Ej: "Queso con loroco", "Revuelta"

    public Pupusa(int id, String relleno, String tipoMasa,
                  double precioBase) throws ProductoInvalidoException {

        super(id, "Pupusa de " + relleno + " (" + tipoMasa + ")",
                precioBase);

        this.tipoMasa = tipoMasa;
        this.relleno = relleno;
    }

    public String getTipoMasa() {
        return tipoMasa;
    }

    public String getRelleno() {
        return relleno;
    }


    @Override
    public double calcularPrecio() {
        return precioBase;
    }

    @Override
    public String toString() {
        return super.toString() + " [Masa: " + tipoMasa + "]";
    }
}
package modelo;

public class Pupusa extends Producto {
    private String tipoMasa; // Ej: "Maíz" o "Arroz"
    private String relleno;  // Ej: "Queso con loroco", "Revuelta"

    // Constructor adaptado a la superclase abstracta con id
    public Pupusa(int id, String relleno, String tipoMasa, double precioBase) {
        super(id, "Pupusa de " + relleno + " (" + tipoMasa + ")", precioBase);
        this.tipoMasa = tipoMasa;
        this.relleno = relleno;
    }

    public String getTipoMasa() {
        return tipoMasa;
    }

    public String getRelleno() {
        return relleno;
    }

    // Implementación del método abstracto heredado
    @Override
    public double calcularPrecio() {
        return precioBase;
    }

    @Override
    public String toString() {
        return super.toString() + " [Masa: " + tipoMasa + "]";
    }
}

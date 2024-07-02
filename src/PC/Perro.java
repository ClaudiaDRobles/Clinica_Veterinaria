package PC;

public class Perro extends Mascota {
    private int cantidadBanos;


    //constructor
    public Perro(String codigo, String nombreMascota, String raza, int anioRegistro, int cantidadBanos) {
        super(codigo, nombreMascota, raza, anioRegistro);
        this.cantidadBanos = cantidadBanos;
    }

    public int getCantidadBanos() {
        return cantidadBanos;
    }


    @Override
    public int calcularPuntos() {
        int puntosPorBaño = 10;
        if (cantidadBanos == 0) {
            return 0;
        }

        return cantidadBanos * puntosPorBaño;
    }
    @Override
    public String toString() {
        return "Mascota Perro{" +
                "codigo='" + getCodigo() + '\'' +
                ", nombre de la mascota='" + getNombreMascota() + '\'' +
                ", raza =" + getRaza() +
                ", año de registro=" + getAnioRegistro() +
                ", cantidad de baños=" + cantidadBanos +
                ", puntos=" + calcularPuntos() +
                '}';
    }
}


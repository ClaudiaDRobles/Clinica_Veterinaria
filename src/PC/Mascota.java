package PC;

public abstract class Mascota {
    private String codigo;
    private String nombreMascota;
    private String raza;
    private int anioRegistro;

    //constructor:
    public Mascota(String codigo, String nombreMascota, String raza, int anioRegistro) {
        this.codigo = codigo;
        this.nombreMascota = nombreMascota;
        this.raza = raza;
        this.anioRegistro = anioRegistro;
    }


    public String getCodigo() {
        return codigo;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public String getRaza() {
        return raza;
    }

    public int getAnioRegistro() {
        return anioRegistro;
    }

    public int calcularAntiguedad() {
        int anioActual = 2024;
        int AntiguedadAnios = 0;
        AntiguedadAnios = (anioActual - anioRegistro);
        return AntiguedadAnios;
    }

    public abstract int calcularPuntos();

    public int getPuntos() {
        return calcularPuntos();
    }
}

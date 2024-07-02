package PC;

public class Gato extends Mascota {
    private int numeroVisitas;


    //Constructor
    public Gato(String codigo, String nombreMascota, String raza, int anioRegistro, int numeroVisitas) {
        super(codigo, nombreMascota, raza, anioRegistro);
        this.numeroVisitas = numeroVisitas;
    }

    @Override
    public int calcularPuntos() {
        int puntos = 15 * numeroVisitas;

        if (puntos >150){
            setConsultaGratis(true);
        }
        return puntos;
    }

    public void setConsultaGratis(boolean b) {
    }


    @Override
    public String toString() {
        return "Mascota Gato{" +
                "codigo='" + getCodigo() + '\'' +
                ", nombre de la mascota='" + getNombreMascota() + '\'' +
                ", raza =" + getRaza() +
                ", año de registro=" + getAnioRegistro() +
                ", número visitas=" + numeroVisitas +
                ", puntos=" + calcularPuntos() +
                '}';
    }
}

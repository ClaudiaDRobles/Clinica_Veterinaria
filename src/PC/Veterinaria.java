package PC;

import java.util.ArrayList;
import java.util.List;

public class Veterinaria {
    private List<Mascota> listaMascota;

    //Constructor:

    public Veterinaria() {
        this.listaMascota = new ArrayList<>();
    }

    public List<Mascota> getListaMascota() {
        return listaMascota;
    }

    public void agregarMascota(Mascota mascota) {
        listaMascota.add(mascota);
    }

    public void mostrarMascota() {
        for (Mascota mascota : listaMascota) {
            System.out.println(mascota);
        }
    }
    public Mascota buscarMascotaPorCodigo(String codigo) {
        for (Mascota mascota : listaMascota) {
            if (mascota.getCodigo().equals(codigo)) {
                return mascota;
            }
        }
        return null;
    }

    public ArrayList<String> generarReporteDeMascotas() {
        ArrayList<String> reporte = new ArrayList<>();
        for (Mascota mascota : listaMascota) {
            String detalle = "Código: " + mascota.getCodigo() +
                    ", Nombre: " + mascota.getNombreMascota() +
                    ", Especie: " + (mascota instanceof Perro ? "Perro" : "Gato") +
                    ", Puntos: " + mascota.calcularPuntos();
            reporte.add(detalle);
        }
        return reporte;
    }

}
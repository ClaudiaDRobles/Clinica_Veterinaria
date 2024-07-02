package PC;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejecutora {
    public static void main(String[] args) {
        Veterinaria veterinaria = new Veterinaria();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        Perro mascotaPerro1 = new Perro("PE001", "Filurais", "Mix", 2022, 5);
        Perro mascotaPerro2 = new Perro("PE002", "Coco", "Pequinés", 2023, 1);
        Gato mascotaGato1 = new Gato("GA003", "Ariel", "Siamés", 2024, 5);
        Gato mascotaGato2 = new Gato("GA004", "Lucas", "Persa", 2023, 10);

        veterinaria.agregarMascota(mascotaPerro1);
        veterinaria.agregarMascota(mascotaPerro2);
        veterinaria.agregarMascota(mascotaGato1);
        veterinaria.agregarMascota(mascotaGato2);

        int opcion;

        do {
            try {
                mostrarMenu();
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        registrarMascota(veterinaria, scanner);
                        break;
                    case 2:
                        listarMascotas(veterinaria);
                        break;
                    case 3:
                        buscarMascota(veterinaria, scanner);
                        break;
                    case 4:
                        System.out.println("Saliendo del sistema. ¡Hasta luego!");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            }
        } while (!salir);

        scanner.close();
    }

    // Método para mostrar el menú de opciones
    private static void mostrarMenu() {
        System.out.println("Bienvenidos a VidaPet:");
        System.out.println("1. Registrar Mascota");
        System.out.println("2. Listar Mascotas");
        System.out.println("3. Buscar mascota registrada");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Método para registrar una nueva mascota
    public static void registrarMascota(Veterinaria veterinaria, Scanner scanner) {
        try {
            System.out.print("Ingrese el tipo de mascota (1 para Perro, 2 para Gato): ");
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            System.out.print("Ingrese el código de la mascota: ");
            String codigo = scanner.nextLine();
            System.out.print("Ingrese el nombre de la mascota: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la raza de la mascota: ");
            String raza = scanner.nextLine();
            System.out.print("Ingrese el año de registro: ");
            int anioRegistro = scanner.nextInt();
            scanner.nextLine();

            if (tipo == 1) {
                System.out.print("Ingrese la cantidad de baños: ");
                int cantidadBanos = scanner.nextInt();
                Perro perro = new Perro(codigo, nombre, raza, anioRegistro, cantidadBanos);
                veterinaria.agregarMascota(perro);
                System.out.println("Perro registrado con éxito.");
            } else if (tipo == 2) {
                System.out.print("Ingrese el número de visitas: ");
                int numeroVisitas = scanner.nextInt();
                Gato gato = new Gato(codigo, nombre, raza, anioRegistro, numeroVisitas);
                veterinaria.agregarMascota(gato);
                System.out.println("Gato registrado con éxito.");
            } else {
                try {
                    throw new ExcepcionNegocioChecked("Tipo de mascota no válido.");
                } catch (ExcepcionNegocioChecked e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }



    // Método para listar todas las mascotas
    public static void listarMascotas(Veterinaria veterinaria) {
        System.out.println("Lista de Mascotas:");
        int count = 0;
        for (Mascota mascota : veterinaria.getListaMascota()) {
            count++;
            System.out.println("Mascota " + count + ": " + mascota.getNombreMascota() +
                    " se registró en el año " + mascota.getAnioRegistro() +
                    " y tiene " + mascota.calcularPuntos() + " puntos.");
        }
    }


    // Método para buscar una mascota por su código
    public static void buscarMascota(Veterinaria veterinaria, Scanner scanner) {
        try {
            System.out.print("Ingrese el código de la mascota: ");
            String codigo = scanner.nextLine();
            Mascota mascota = veterinaria.buscarMascotaPorCodigo(codigo);
            if (mascota != null) {
                System.out.println("Mascota encontrada: " + mascota.getNombreMascota() + " con " + mascota.getPuntos() + " puntos.");
            } else {
                System.out.println("Mascota no encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al buscar la mascota: " + e.getMessage());
        }
    }
}


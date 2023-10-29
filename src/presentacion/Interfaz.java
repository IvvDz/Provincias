package presentacion;
import dominio.*;
import java.util.*;
import java.io.*;

public class Interfaz {
    public ArrayList<Provincia> provincias = new ArrayList<>();

    public Interfaz() {
        try {
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Provincias.txt"));
            provincias = (ArrayList<Provincia>) obj.readObject();
            obj.close();
        } catch (IOException | ClassNotFoundException e) {
            provincias = new ArrayList<>();
        }
    }

    public void guardar() {
        try {
            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("Provincias.txt"));
            obj.writeObject(provincias);
            obj.close();
            System.out.println("Guardado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public void leer() {
        Scanner sc = new Scanner(System.in);
        String nomProvincia;

        while (true) {
            System.out.print("Introduzca el nombre de la provincia (enter para finalizar): ");
            nomProvincia = sc.nextLine();

            if (nomProvincia.equals("")) {
                break;
            }

            Provincia p = new Provincia(nomProvincia);

            while (true) {
                System.out.print("Introduzca el nombre del municipio (enter para finalizar): ");
                String nomMunicipio = sc.nextLine();

                if (nomMunicipio.equals("")) {
                    break;
                }

                Municipio m = new Municipio(nomMunicipio);
                p.addMunicipio(m);

                while (true) {
                    System.out.print("Introduzca el nombre de la localidad (enter para finalizar): ");
                    String nomLocalidad = sc.nextLine();

                    if (nomLocalidad.equals("")) {
                        break;
                    }

                    System.out.print("Introduzca el número de habitantes: ");
                    int numeroDeHabitantes = 0;

                    try {
                        numeroDeHabitantes = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Valor introducido incorrecto.");
                    }

                    Localidad l = new Localidad(nomLocalidad, numeroDeHabitantes);
                    m.addLocalidad(l);
                }
            }
            provincias.add(p);
        }
        sc.close();
    }

    public void insertarProvincia() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Defina el nombre de la provincia: ");
        String nombre = sc.nextLine();

        if (!nombre.equals("")) {
            Provincia p = new Provincia(nombre);
            provincias.add(p);
        } else {
            System.out.println("El valor introducido no es válido.");
        }
        sc.close();
    }

    public void insertarMunicipio() {
        Scanner sc = new Scanner(System.in);
        System.out.println("A qué provincia pertenece el municipio: ");
        String nombreProvincia = sc.nextLine();
        Provincia p = new Provincia(nombreProvincia);
        int indice = provincias.indexOf(p);

        if (indice != -1) {
            System.out.println("Defina el nombre del municipio: ");
            String nombreMunicipio = sc.nextLine();
            Municipio m = new Municipio(nombreMunicipio);
            provincias.get(indice).addMunicipio(m);
        } else {
            System.out.println("La provincia no existe.");
        }
        sc.close();
    }

    public void insertarLocalidad() {
        Scanner sc = new Scanner(System.in);
        System.out.println("A qué municipio pertenece la localidad: ");
        String nombreMunicipio = sc.nextLine();

        for (Provincia p : provincias) {
            for (Municipio m : p.getMunicipios()) {
                if (m.getNombre().equals(nombreMunicipio)) {
                    System.out.println("Ingrese el nombre de la localidad: ");
                    String nombreLocalidad = sc.nextLine();
                    System.out.println("Ingrese el número de habitantes: ");

                    int numeroDeHabitantes = 0;

                    try {
                        numeroDeHabitantes = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Valor introducido incorrecto.");
                    }

                    Localidad l = new Localidad(nombreLocalidad, numeroDeHabitantes);
                    m.addLocalidad(l);
                    sc.close();
                    return;
                }
            }
        }

        System.out.println("El municipio no existe.");
        sc.close();
   }
}

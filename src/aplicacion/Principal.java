package aplicacion;
import dominio.*;

public class Principal {
    public static void main(String[] args) {
        Localidad local1 = new Localidad("Barcelona", 5);
        Localidad local2 = new Localidad("Sevilla", 4);

        System.out.println(local1.toString());
        System.out.println(local2.toString());

        Municipio madrid = new Municipio("Madrid", local1, local2);

        System.out.println(madrid.toString());

        Localidad local3 = new Localidad("Bilbao", 7);
        madrid.addLocalidad(local3);
        System.out.println(madrid.toString());
    }
}


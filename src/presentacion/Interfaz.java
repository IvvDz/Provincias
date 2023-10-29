package presentacion;
import dominio.*;
import java.io.*;
import java.util.*;
private static Scanner sc = new Scanner(System.in);
public class Interfaz {
public static boolean procesarPeticion (String peticion, ArrayList<Provincia> 1){ 
	String [] p-peticion.split(" ");
	if (p.length!=2)
	if (p[0].equals("addProvincia"))
		aniadirProvincia(p[1],l);
	else if (p[0].equals("addMunicipio"))
	aniadirMunicipio(p[1],]);
	else if (p[0].equals("addLocalidad"))
	 aniadirLocalidad(p[1],l);
	else //peticion erronea
		System.out.print("peticion erronea. Pida la ayuda 'help'");
	else if (p.length()==1)
		if (p[0].equals("leer")) 1-leer();
		else if (p[0].equals("list")) System.out.print (1);
		else if (p[0].equals("help"))
System.out.print("introduzca ua de las siguientes peticiones: \n addProvindia nombre: añadir provincia\n addMunicipio nombre: añadir Municipio\n addLocalidad nombre: añadir Localidad\n list: listar el contenido\n leer: lectura inicial\n exit: salir\n");
else if (p[0].equals("exit"))
                        return false;
                else {
}
return false;
else {
}
System.out.print("petición erronea"); procesarPeticion("help", l);
System.out.print("petición erronea"); procesarPeticion("help", l);
return true;
}
Provincia p=new Provincia(nombre);
l.add(p);
public static void aniadirMunicipio(String nombre, ArrayList<Provincia> l){ Municipio m=new Municipio (nombre);
}
for (int i=0;i<l.size();i++)
System.out.println(i+": " + l.get(i).getNombre()); System.out.print("Introduzca el número de la provincia: ");
int i=sc.nextInt();
sc.nextLine(); l.get(i).add(m);
public static void aniadirLocalidad(String nombre, ArrayList<Provincia> l) {



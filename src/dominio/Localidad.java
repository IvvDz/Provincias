package dominio;
public class Localidad{
        private String nombre;
        private String numeroDeHabitantes;

        public void setNombre(String nombre)
        {
                this.nombre = nombre;}
        public void setNumeroDeHabintantes(String NumeroDeHabitantes)
        {
                this.numeroDeHabitantes = numeroDeHabitantes;}

        public String getNombre()
        {return nombre;}
        public String getApellido1()
        {return apellido1;}


        public Habitante (String nombre, String apellido1, String apellido2)
        {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

}

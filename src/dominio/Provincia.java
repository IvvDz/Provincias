package dominio;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable
public class Provincia implements Serializable{
    private String nombre_provincia;
    private List<Municipio> municipios;

    public Provincia(String nombre) {
        this.nombre_provincia = nombre;
        this.municipios = new ArrayList<>();
    }

    public void addMunicipio(Municipio mun) {
        municipios.add(mun);
    }

    public int contarHabitantesProvincia() {
        int habitantesProvincia = 0;
        for (Municipio municipio : municipios) {
            habitantesProvincia += municipio.contarHabitantesMunicipio();
        }
        return habitantesProvincia;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("El municipio de " + this.nombre_provincia + " está compuesta por: ");
        for (int i = 0; i < municipios.size(); i++) {
            result.append(municipios.get(i).getNombre());
            if (i == municipios.size() - 2) {
                result.append(" y ");
            } else if (i != municipios.size() - 1) {
                result.append(", ");
            }
        }
        result.append(" y tiene ").append(this.contarHabitantesProvincia()).append(" habitantes");
        return result.toString();
    }
}


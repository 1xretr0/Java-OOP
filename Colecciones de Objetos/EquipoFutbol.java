
/**
 * Write a description of class EquipoFut here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EquipoFutbol
{
    private String nombreEquipo, entrenador, equipo[]; 
    
    public EquipoFutbol(String nombre, String entrenador){
        nombreEquipo = new String(nombre);
        this.entrenador = new String(entrenador);
        equipo = new String[11];
    }
    
    public String getNombreEquipo(){
        return new String(nombreEquipo);
    }
    
    public void setEntrenador(String entrenador){
        this.entrenador = new String(entrenador);
    }
    
    public String getEntrenador(){
        return new String(entrenador);
    }
    
    public void agregaJugador(int index, String nombre){
        if (index >= 1 && index <= 11)
            equipo[index - 1] = new String(nombre);
    }
    
    public String getJugador(int index){
        if ((index >= 1 && index <= 11) && (equipo[index - 1] != null)){
            return new String(equipo[index - 1]);
        }
        else{
            return null;
        }
    }
}

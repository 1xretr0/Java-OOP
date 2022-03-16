
/**
 * Write a description of class EquipoFut here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EquipoFutbol
{
    private String nombre, entrenador;
    private Jugador equipo[];
    
    public EquipoFutbol(String nombre, String entrenador){
        this.nombre = new String(nombre);
        this.entrenador = new String(entrenador);
        equipo = new Jugador[11];
    }
    
    public String getnombre(){
        return new String(nombre);
    }
    
    public void setEntrenador(String entrenador){
        this.entrenador = new String(entrenador);
    }
    
    public String getEntrenador(){
        return new String(entrenador);
    }
    
    public void agregaJugador(int index, Jugador nombre){
        if (index >= 1 && index <= 11)
            equipo[index - 1] = new Jugador(nombre);
    }
    
    public String getJugador(int index){
        if ((index >= 1 && index <= 11) && (equipo[index - 1] != null)){
            return equipo[index - 1].toString();
        }
        else{
            return null;
        }
    }
}

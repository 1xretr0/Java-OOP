/**
 * @author sebas moran
 * @version 1.0
 */
public class Hora
{
    private int segundos;
    
    //  Zona de consttructores
   public Hora(int h, int m, int s) {
       setHoras(h);
       setMinutos(m);
       setSegundos(s);
   }
   
   public Hora(int h, int m) {
       setHoras(h);
       setMinutos(m);
       setSegundos(0);
   }
   
   public Hora(int h) {
       setHoras(h);
       setMinutos(0);
       setSegundos(0);
   }
   
   public Hora() {
       setHoras(0);
       setMinutos(0);
       setSegundos(0);
   }
   
   // Zona de las operaciones
   // setters()
   public void setHoras(int h) {
       //remover ultimo valor de horas en segundos
       segundos -= (segundos / 3600) * 3600;
       
       //validar horas
       int horas = (h >= 0 && h <= 23) ?  h :  0;
       segundos += horas * 3600;
   }
   
   public void setMinutos(int m) {
       //remover ultimo valor de minutos en segundos
       segundos -= ((segundos % 3600) / 60) * 60;
       
       int minutos = (m >= 0 && m <= 59) ?  m :  0;
       segundos += minutos * 60;
   }
   
   public void setSegundos(int s) {
       segundos -= ((segundos % 3600) % 60);
       
       segundos += (s >= 0 && s <= 59) ? s : 0;
   }
   
   // Selectores (getters)
   public int getSegundos() {
       return (segundos % 3600) % 60;
   }
   
   public int getMinutos(){
       return (segundos % 3600) / 60;
   }
   
   public int getHoras(){
       return segundos / 3600;
   }
   
   //custom methods
   public String toString() {
       int horas = segundos / 3600;
       int minutos = (segundos % 3600) / 60;
       int segundos_aux = (segundos % 3600) % 60;
       
       return ((horas == 0 || horas == 12) ? 12 : horas % 12) + ":" +
               (minutos < 10 ? "0" : "") + minutos + ":" +
               (segundos_aux < 10 ? "0" : "") + segundos_aux + 
               (horas < 12 ? " AM" : " PM"); 
   }
   
   public String toMilitaryString(){
       return (segundos / 3600 < 10 ? "0" : "") + (segundos / 3600) + 
       (((segundos % 3600) / 60) < 10 ? "0" : "") + ((segundos % 3600) / 60) + " hrs";
    }
    
    
   public int tick(){
       if (segundos == 86399){
           segundos = 0;
       }
       else{
           segundos++;
       }
       
       return segundos;
   }
}
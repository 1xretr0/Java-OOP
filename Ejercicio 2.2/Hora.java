
/**
 * @author sebas moran
 * @version 1.0
 */
public class Hora
{
    private int segundos = 0;
    
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
   // Modificadores  (setters)
   public void setHoras(int h) {
       int horas = (h >= 0 && h <= 23) ?  h :  0;
       segundos += horas * 3600;
   }
   
   public void setMinutos(int m) {
       int minutos = (m >= 0 && m <= 59) ?  m :  0;
       segundos += minutos * 60;
   }
   
   public void setSegundos(int s) {
       segundos += (s >= 0 && s <= 59) ?  s :  0;
   }
   
   // Selectores (getters)
   public int getSegundos() {
       return segundos;
   }
   
   public int getMinutos(){
       return segundos / 60;
   }
   
   public int getHoras(){
       return segundos / 3600;
   }
   
   public String toString() {
       int horas = segundos / 60;
       int minutos = 
       return ((horas == 0 || horas == 12) ? 12 : horas % 12) + ":" +
               (minutos < 10 ? "0" : "") + minutos + ":" +
               (segundos < 10 ? "0" : "") + segundos + 
               (horas <12 ? " AM" : " PM"); 
   }
}


/**
 * Write a description of class Hora here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hora
{
    //  Zona de atributos
   private int horas;
   private int minutos;
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
   // Modificadores  (setters)
   public void setHoras(int h) {
       horas = (h >= 0 && h <= 23) ?  h :  0;
   }
   
   public void setMinutos(int m) {
       minutos = (m >= 0 && m <= 59) ?  m :  0;
   }
   
   public void setSegundos(int s) {
       segundos = (s >= 0 && s <= 59) ?  s :  0;
   }
   
   // Selectores (getters)
   public int getHoras() {
       return horas;
   }
   
   public int getMinutos() {
       return minutos;
   }
   
   public int getSegundos() {
       return segundos;
   }
   
   
   public String toString() {
       return ((horas == 0 || horas == 12) ? 12 : horas % 12) + ":" +
               (minutos < 10 ? "0" : "") + minutos + ":" +
               (segundos < 10 ? "0" : "") + segundos + 
               (horas <12 ? " AM" : " PM");
   }
   
   public
   String toMilitaryString() {
       return (horas < 10 ? "0" : "") + horas + (minutos < 10 ? "0" : "") 
               + minutos + " hrs.";
   }
   
   
}






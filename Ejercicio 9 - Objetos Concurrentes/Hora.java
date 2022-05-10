/**
 * @author sebas moran
 * @version 1.0
 */
import java.awt.*;
import java.awt.event.*;

public class Hora extends Frame implements Runnable
{
    private int segundos;
    private Thread hilo;
    private TextField hora_text;
    
    
    //  Zona de consttructores
   public Hora(int h, int m, int s, String nombre) {
       super(nombre);
       setHoras(h);
       setMinutos(m);
       setSegundos(s);
       setLayout(new FlowLayout() );
       hora_text = new TextField(8);
       hora_text.setEditable(false);
       add(hora_text);
       addWindowListener(new CW());
       setSize(190,80);
       
       hilo = new Thread();
       hilo.start();
       setVisible(true);
    }
   
   private class CW extends WindowAdapter{
       void windowClosing(WindowListener e) {
           setVisible(false);
           dispose();
       }
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
   
   // override a thread
   public void run(){
       int count = 1;
       while (true){
           tick();
           try {
               hilo.sleep(1000);
           }
           catch (InterruptedException excp){
               excp.printStackTrace();
           }
           hora_text.setText(toString());
       }
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
   
   public static void main(){
       Hora hora = new Hora(18, 45, 0, "CDMX");
       Hora hora2 = new Hora(11, 45, 0, "TOKYO");
   }
}
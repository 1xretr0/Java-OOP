import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import java.util.Vector;
import java.io.*;

/**
 * conserva los puntos representados por un polinomio
 * en un intervalo dado. generara una lista de valores
 * desde el limite inferior al superior del intervalo
 *
 * @author sebas moran
 * @version 1.0
 */
public class PuntosEcuacion extends Canvas implements Runnable
{
    // declaracion variable polinomio
    private Polinomio poli;
    // declaracion vector que almacena puntos evaluados
    private Vector <Punto> puntos;
    // declaracion limites a evaluar el polinomio
    private double linf, lsup, inc;
    // bandera para paint
    private boolean flag = false;
    // declaracion thread para paint
    private Thread hilo;
    // declaracion write flow para output file
    private DataOutputStream write;

    
    public PuntosEcuacion()
    {
        // super("Grafica");
        // addWindowListener(new CW());
        // setResizable(false);
        
    }
    
    // private class CW extends WindowAdapter{     // listener
        // public void windowClosing(WindowEvent e){
            // setVisible(false);
            // dispose();
        // }
    // }

    /**
     * obtiene los valores de los polinomios evaluados
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Vector getPuntosEcuacion()
    {
        return puntos;
    }
    
    public Punto getPunto(int num){
        return puntos.get(num);
    }
    
    public void calculaPuntos(double linf, double lsup, double inc) throws IOException {
        this.linf = linf;
        this.lsup = lsup;
        this.inc = inc;
        puntos = new Vector<Punto>(0);
        // se evalua el polinomio desde linf a lsup
        for(double i = linf; i <= lsup; i += inc){
            // Punto punto = new Punto(i, poli.evalua(i));
            // puntos.add(punto);
             double x = i;
            i = Math.round(i * 100.0) / 100.0;
            double y = poli.evalua(i);
            Punto aux = new Punto(x, y);
            puntos.add(aux);
        }
        
        // try para exception al escribir en archivo
        try {
            write = new DataOutputStream(new BufferedOutputStream(
            new FileOutputStream("puntos.txt")));
            int i = 0;
            while (i < (puntos.size() - 1)){
                write.writeUTF(puntos.get(i).toString());
                i++;
            }
            
        }
        catch (FileNotFoundException exc){
            System.out.println("El archivo no se encontro.");
        }
        finally{
            if (write != null){
                write.close();
            }
        }
        
        // bandera para indicar que ya se puede dibujar grafica evaluada
        this.flag = true;
        hilo = new Thread(this);
        hilo.start();
    }
    
    public void agregaPolinomio(Polinomio poli){
        this.poli = poli;
    }
    
    public void paint(Graphics gc1d){
        Graphics2D gc = (Graphics2D) gc1d;
        gc.translate(250,250);
        
        // lineas horizontales
        gc.setColor(Color.black);
        gc.setStroke(new BasicStroke(2f));
        gc.draw(new Line2D.Float(-250, 0, 250, 0));

        gc.setColor(Color.gray);
        gc.setStroke(new BasicStroke(1.0f));
        for (int i = -250; i <= 250; i += 10){
            gc.draw(new Line2D.Float(250, i, -250, i));
        }
        
        // lineas verticales
        gc.setColor(Color.black);
        gc.setStroke(new BasicStroke(2f));
        gc.draw(new Line2D.Float(0, 250, 0, -250));
        
        gc.setColor(Color.gray);
        gc.setStroke(new BasicStroke(1.0f));
        for (int i = -250; i <= 250; i += 10){
            gc.draw(new Line2D.Float(i, 250, i, -250));
        }
        
        // verificacion de flag
        if (flag){
            // lineas de punto a punto
            try{
                gc.setColor(Color.red);
                gc.setStroke(new BasicStroke(2f));
                int p_size = getPuntosEcuacion().size();
                for (int i = 0; i < p_size-1; i++){
                    double x1 = (double) getPunto(i).getX() * 10;
                    double y1 = (double) getPunto(i).getY() * -10;
                    double x2 = (double) getPunto(i+1).getX() * 10;
                    double y2 = (double) getPunto(i+1).getY() * -10;
                    gc.draw(new Line2D.Double(x1, y1, x2, y2));
                    if(y1 <= 240 && y1 >= -240){
                        gc.draw(new Line2D.Double(x1, y1, x2, y2));
                        hilo.sleep(50);
                    }
                }
                // puntos evaluados
                gc.setColor(Color.blue);
                gc.setStroke(new BasicStroke(1.0f));
                for (int i = 0; i < p_size; i++){
                    double x = (double) getPunto(i).getX() * 10;
                    double y = (double) getPunto(i).getY() * -10;
                    gc.fill(new Ellipse2D.Double(x-2.5, y-2.5, 5, 5));
                }
            }
            catch (InterruptedException exc){
                exc.printStackTrace();
            }
            hilo.stop();
        }
    }
    
    public void run(){
        repaint();
    }
    
    // public static void main(String args[]){
        // Termino termino1 = new Termino(0, 1);
        // Termino termino2 = new Termino(1, 2);
        // Termino termino3 = new Termino(2, 3);
        // Termino termino4 = new Termino(3, 4);
        
        // Polinomio polinomio1 = new Polinomio(2);
        // polinomio1.agregaTermino(new Termino(1, 2));
        
        // PuntosEcuacion puntos1 = new PuntosEcuacion(polinomio1, 0, 5, 1);
        
        // System.out.println(puntos1.getPunto(2));
        
        // puntos1.resize(500, 500);
        // puntos1.show();
    // }
}

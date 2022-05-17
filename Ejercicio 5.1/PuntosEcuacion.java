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
    private Polinomio poli;
    private Vector <Punto> puntos;
    private double linf, lsup, inc;
    private boolean flag = false;
    private Thread hilo;
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
        puntos = new Vector<Punto>(1);
        for(double i = linf; i <= lsup; i += inc){
            Punto punto = new Punto(i, poli.evalua(i));
            puntos.add(punto);
        }
          
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
        
        if (flag){
            // lineas de punto a punto
            gc.setColor(Color.red);
            gc.setStroke(new BasicStroke(2f));
            int p_size = getPuntosEcuacion().size();
            for (int i = 0; i < p_size; i+=inc){
                try {
                    if (i+1 < p_size){
                        double x1 = (double) getPunto(i).getX() * 10;
                        double y1 = (double) getPunto(i).getY() * -10;
                        double x2 = (double) getPunto(i+1).getX() * 10;
                        double y2 = (double) getPunto(i+1).getY() * -10;
                        gc.draw(new Line2D.Double(x1, y1, x2, y2));   
                        hilo.sleep(50);
                    }
                }    
                catch (InterruptedException exc){
                    exc.printStackTrace();
                }
            }
            
            // puntos evaluados
            gc.setColor(Color.blue);
            gc.setStroke(new BasicStroke(1.0f));
            for (int i = 0; i < p_size; i++){
                double x = (double) getPunto(i).getX() * 10;
                double y = (double) getPunto(i).getY() * -10;
                gc.fill(new Ellipse2D.Double(x-5, y-5, 10, 10));
            }
            
            // imprimir funcion
            gc.setColor(Color.red);
            gc.setFont(new Font("Helvetica", Font.BOLD, 20));
            gc.drawString(poli.toString(), -240, 230);
            
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

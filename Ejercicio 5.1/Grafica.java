import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;

public class Grafica extends Frame
{   
    private PuntosEcuacion puntos;
    private Polinomio poli;
    private double linf, lsup;
    public Grafica(PuntosEcuacion p, double linf, double lsup, Polinomio po){
        super("Grafica");
        addWindowListener(new CW()); 
        puntos = p;
        poli = po;
        this.linf = linf;
        this.lsup = lsup;
        
        setSize(520, 640);
        setVisible(true);
        setResizable(false);
    }
    
    public void paint(Graphics gc){
        Graphics2D gc2D = (Graphics2D) gc;
        gc.translate(260, 330);
        
        gc2D.setPaint(Color.GRAY);
        for(int i = -240; i <= 240; i = i + 20){
            gc2D.draw(new Line2D.Float(i, -300, i, 300));
        }
        
        for(int i = -300; i <= 300; i = i + 20){
            gc2D.draw(new Line2D.Float(-250, i, 250, i));
        }
        
        gc2D.setPaint(Color.BLACK);
        gc2D.setStroke(new BasicStroke(3.0f));
        gc2D.draw(new Line2D.Float(-250, 0, 250, 0));
        gc2D.draw(new Line2D.Float(0, -300, 0, 300)); 
        
        gc2D.setPaint(Color.RED);
        double j = linf;
        while(j < lsup){
            double y = poli.evalua(j) * -20;
            gc2D.fill(new Ellipse2D.Double((j*20) - 2 , y - 2, 4, 4));
            j = j + 0.005;
        }
        
        gc2D.setPaint(Color.BLUE);
        int i = 0, psize = puntos.getPuntosEcuacion().size();
        while(i < psize){
            double x = (int) puntos.getPunto(i).getX() * 20;
            double y = (double) puntos.getPunto(i).getY() * -20;
            gc2D.fill(new Ellipse2D.Double(x - 5, y - 5, 10, 10));
            i++;
        }
    }
    
    private class CW extends WindowAdapter{     // listener
        public void windowClosing(WindowEvent e){
            setVisible(false);
            dispose();
        }
    }
    
    public static void main(String args[]){
        
    }
}
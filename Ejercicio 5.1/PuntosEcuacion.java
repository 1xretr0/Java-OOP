import java.awt.*;
import java.util.Vector;
import java.awt.geom.*;
/**
 * conserva los puntos representados por un polinomio
 * en un intervalo dado. generara una lista de valores
 * desde el limite inferior al superior del intervalo
 *
 * @author sebas moran
 * @version 1.0
 */
public class PuntosEcuacion extends Frame
{
    private Polinomio poli;
    private Vector <Punto> puntos;
    private double linf, lsup, inc;
    
    public PuntosEcuacion(Polinomio poli, double linf, double lsup,
    double inc)
    {
        super("PuntosEcuacion");
        
        this.poli = poli;
        puntos = new Vector<Punto>(1);
        this.linf = linf;
        this.lsup = lsup;
        this.inc = inc;
    }
    
    public boolean handleEvent(Event e){
        if (e.id == Event.WINDOW_DESTROY){
            setVisible(false); dispose();
            // hide() esta deprecated
            return true;
        }
        return super.handleEvent(e);
    }

    /**
     * obtiene los valores de los polinomios evaluados
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Vector getPuntosEcuacion()
    {
        for (double i = linf; i <= lsup; i+=inc){
            double x = i;
            double y = poli.evalua(i);
            
            Punto punto_aux = new Punto(x, y);
            puntos.add(punto_aux);
        }
        
        return new Vector<Punto>(puntos);
    }
    
    public Punto<Integer> getPunto(int num){
        return puntos.get(num);
    }
    
    public void paint(Graphics gc1d){
        Graphics2D gc = (Graphics2D) gc1d;
        
        gc.translate(250,250);
        gc.setColor(Color.black);
        gc.setStroke(new BasicStroke(2f));
        // linea horizontal
        gc.draw(new Line2D.Float(-250, 0, 250, 0));
        gc.draw(new Line2D.Float(-250, 100, 250, 100));
        gc.setColor(Color.gray);
        gc.setStroke(new BasicStroke(1.0f));
        for (int i = 10; i <= 250; i += 20){
            gc.draw(new Line2D.Float(250, i, -250, i));
        }
        
        for (int i = -10; i >= -250; i -= 20){
            gc.draw(new Line2D.Float(250, i, -250, i));
        }
        
        gc.setColor(Color.black);
        gc.setStroke(new BasicStroke(2f));
        // linea vertical
        gc.draw(new Line2D.Float(0, 250, 0, -250));
        gc.setColor(Color.gray);
        gc.setStroke(new BasicStroke(1.0f));
        for (int i = 10; i <= 250; i += 20){
            gc.draw(new Line2D.Float(i, 250, i, -250));
        }
        
        for (int i = -10; i >= -250; i -= 20){
            gc.draw(new Line2D.Float(i, 250, i, -250));
        }
    }
    
    public static void main(String args[]){
        Termino termino1 = new Termino(2, 0);
        Termino termino2 = new Termino(5, 1);
        Termino termino3 = new Termino(8, 2);
        Termino termino4 = new Termino(4, 3);
        
        Polinomio polinomio1 = new Polinomio(4);
        polinomio1.agregaTermino(termino1);
        polinomio1.agregaTermino(termino2);
        polinomio1.agregaTermino(termino3);
        polinomio1.agregaTermino(termino4);
        
        PuntosEcuacion puntos1 = new PuntosEcuacion(polinomio1, 1, 5, 1);
        puntos1.getPuntosEcuacion();
        // System.out.println(puntos1.getPunto(2));
        
        puntos1.resize(500, 500);
        puntos1.show();
    }
}

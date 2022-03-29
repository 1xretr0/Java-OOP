import java.util.Vector;
/**
 * conserva los puntos representados por un polinomio
 * en un intervalo dado. generara una lista de valores
 * desde el limite inferior al superior del intervalo
 *
 * @author sebas moran
 * @version 1.0
 */
public class PuntosEcuacion
{
    private Polinomio poli;
    private Vector <Punto> puntos;
    private double linf, lsup, inc;
    
    /**
     * Constructor for objects of class PuntosEcuacion
     */
    public PuntosEcuacion(Polinomio poli, double linf, double lsup,
    double inc)
    {
        this.poli = poli;
        puntos = new Vector<Punto>(1);
        this.linf = linf;
        this.lsup = lsup;
        this.inc = inc;
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
    
    public void main(String args[]){
        
    }
}

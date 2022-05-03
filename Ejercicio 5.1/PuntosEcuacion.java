
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
        System.out.println(puntos1.getPunto(2));
    }
}

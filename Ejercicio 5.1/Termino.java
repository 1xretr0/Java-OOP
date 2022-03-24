import java.lang.Math;

/**
 * representa el termino de un polinomio de una variable (x)
 * formado por un coeficiente y un exponente
 *
 * @author sebas moran
 * @version 1.0
 */
public class Termino
{
    private double coeficiente;
    private int exponente;
    
    /**
     * Constructor for objects of class Termino
     */
    public Termino(double coeficiente, int exponente)
    {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
    }

    /**
     * metodo evalua recibe valor de x y calcula el valor total
     * del termino dado
     *
     * @param  x
     * @return  valor total del termino
     */
    public double evalua(double x)
    {
        return coeficiente * Math.pow(x, exponente);
    }
    
    /**
     * getter para atributo exponente
     * 
     * @return exponente
     */
    public int getExponente(){
        return exponente;
    }
    
    public String toString(){
        return new String(coeficiente + "x^" + exponente);
    }
}


/**
 * conservara polinomios de una sola variable x de grado n
 *
 * @author sebas moran
 * @version 1.0
 */
public class Polinomio
{
    private Termino terminos[];
    
    /**
     * Constructor for objects of class Termino
     * 
     * @param int grado maximo del polinomio
     */
    public Polinomio(int grado){
        terminos = new Termino[grado];
    }
    
    /**
     * permite agregar un termino al polinomio
     * en la posicion de su grado
     *
     * @param  Termino term
     * @param  int index osea el exponente del termino a agregar
     */
    public void agregaTermino(Termino term, int index)
    {
        terminos[index-1] = term;
    }
    
    /**
     * permite agregar un termino al polinomio
     * en la posicion de su grado
     *
     * @param  Termino term
     */
    public void agregaTermino(Termino term)
    {
        terminos[term.getExponente()-1] = term;
    }
    
    /**
     * evalua el total de los terminos del polinomio
     * para una x en especifico
     * 
     * @param double x
     * @return valor total del polinomio
     */
    public double evalua(double x){
        double total = 0;
        
        for (int i = 0; i < terminos.length; i++){
            if (terminos[i] != null)
                total += terminos[i].evalua(x);;
        }
        
        return total;
    }
    
    public String toString(){
        String polinomio = "";
        
        for (int i = terminos.length; i > 0; i--){
            if (terminos[i-1] != null)     
                polinomio += terminos[i-1].toString() + " + ";
        }
        
        return polinomio;
    }
}

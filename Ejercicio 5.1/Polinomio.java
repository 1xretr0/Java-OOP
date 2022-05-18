
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
        terminos = new Termino[grado+1];
    }
    
    /**
     * permite agregar un termino al polinomio
     * en la posicion del index entregado
     *
     * @param  Termino term
     * @param  int index osea el exponente del termino a agregar
     */
    public void agregaTermino(Termino term, int index)
    {
        if (index >= 0 && index <= terminos.length)
            terminos[index] = new Termino(term.getCoeficiente(), term.getExponente());
    }
    
    /**
     * permite agregar un termino al polinomio
     * automaticamente en la posicion de su grado
     *
     * @param  Termino term
     */
    public void agregaTermino(Termino term)
    {
        if (terminos[term.getExponente()] == null){
            terminos[term.getExponente()] = new Termino(
            term.getCoeficiente(), term.getExponente());
        }
        else{
            terminos[term.getExponente()] = new Termino(
            term.getCoeficiente() + 
            terminos[term.getExponente()].getCoeficiente(),
            term.getExponente());
        }
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
        
        for(Termino recorre : terminos){
            if(!(recorre == null)){     //if(recorre != null)
                total += recorre.evalua(x);
            }
        }
        return total;
    }
    
    public String toString(){
        String polinomio = "y =";
        
        for (int i = terminos.length; i > 0; i--){
            if (terminos[i-1] != null){
                if (i == 1){
                    polinomio += new String(terminos[i-1].toString());
                } else {
                    if (terminos[i-1].getCoeficiente() < 0)
                        polinomio += new String(terminos[i-1].toString());
                    else
                        polinomio += new String("+" + terminos[i-1].toString());    
                }
            }
                
        }
        
        return new String(polinomio);
    }
}

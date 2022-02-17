/**
 * representa la hora en 5 ciudades distintas del mundo mediante
 * el uso de la clase hora
 *
 * @author sebas moran
 * @version 1.0
 */

public class RelojInternacional
{
    private Hora GMT, CST, AST, PST, CET;
    
    //constructor
    public RelojInternacional(int horas, int minutos, int segundos){
        setGMT(horas, minutos, segundos);
    }
    
    //setters
    public void setGMT(int h, int m, int s){
        this.GMT = new Hora(h, m, s);
        this.CST = new Hora(h-6, m, s);
        this.AST = new Hora(h-3, m, s);
        this.PST = new Hora(h-8, m, s);
        this.CET = new Hora(h+1, m, s);
    }
    
    //getters
    public String getGMT(){
        return GMT.toString();
    }
    
    public String getCST(){
        return CST.toString();
    }
    
    public String getAST(){
        return AST.toString();
    }
    
    public String getPST(){
        return PST.toString();
    }
    
    public String getCET(){
        return CET.toString();
    }
}

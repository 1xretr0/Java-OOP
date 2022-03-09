
/**
 * Write a description of class Bidimensional here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bidimensional extends Figura
{
    private double perimetro, base, altura;    
    
    public Bidimensional(double area, double perimetro, double base, double altura){
        this.setArea(area);
        setPerimetro(perimetro);
        setBase(base);
        setAltura(altura);
    }
    
    public void setPerimetro(double perimetro){
        this.perimetro = perimetro;
    }
    
    public double getPerimetro(){
        return perimetro;
    }
    
    public void setBase(double base){
        this.base = base;
    }
    
    public double getBase(){
        return base;
    }
    
    public void setAltura(double altura){
        this.altura = altura;
    }
    
    public double getAltura(){
        return altura;
    }
}

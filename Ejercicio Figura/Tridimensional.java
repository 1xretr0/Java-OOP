
/**
 * Write a description of class Tridimensional here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tridimensional extends Figura
{
    private double volumen;
    
    public Tridimensional(double area, double volumen){
        this.setArea(area);
        setVolumen(volumen);
    }
    
    public void setVolumen(double volumen){
        this.volumen = volumen;
    }
    
    public double getVolumen(){
        return volumen;
    }
}

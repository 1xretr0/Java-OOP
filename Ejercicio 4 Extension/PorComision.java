
/**
 * Write a description of class PorComision here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PorComision extends Empleado
{
    private double comision;
    private double pago;
    
    public PorComision(String nombre, String apellido, double comision, double pago){
        super(nombre, apellido);
        setPago(pago);
        setComision(comision);
    }
    
    public void setPago(double p) {
        pago = (p >= 38.30) ? p : 38.30;
    }
    
    public void setComision(double c){
        comision = c;
    }
    
    public double getPago(){
        return pago;
    }
    
    public double getComision(){
        return comision;
    }
    
    public double calculaSalario(){
        return comision * pago;
    }
}


/**
 * Write a description of class PorPiezas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PorPiezas extends Empleado
{
    private int piezas;
    private double pago;
    
    public PorPiezas(String nombre, String apellido, int piezas, double pago){
        super(nombre, apellido);
        setPago(pago);
        setPiezas(piezas);
    }
    
    public void setPago(double p) {
        pago = (p >= 38.30) ? p : 38.30;
    }
    
    public void setPiezas(int p){
        piezas = p;
    }
    
    public double getPago(){
        return pago;
    }
    
    public int getPiezas(){
        return piezas;
    }
    
    public double calculaSalario(){
        return piezas * pago;
    }
}

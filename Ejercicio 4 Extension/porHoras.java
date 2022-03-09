
/**
 * Write a description of class Horas here.
 * 
 * @author Roberto Salazar Marquez
 * @version 1.0
 */
public class PorHoras extends Empleado
{
    // Variables de Instancia 
    private int horas;
    private double pago;

    /**
     * Constructor para objetos de la clase Horas
     */
    public PorHoras(String nombre, String apellido, int horas, double pago)
    {
        super(nombre, apellido);
        setPago(pago);
        setHoras(horas);

    }
    
    public void setPago(double p) {
        pago = (p >= 38.30) ? p : 38.30;
    }
    
    public void setHoras(int h){
        horas = (h > 0) ? h : 0;
    }
    
    public double getPago(){
        return pago;
    }
    
    public int getHoras(){
        return horas;
    }
    
    public double calculaSalario() {
        return horas * pago;
    }
    
}

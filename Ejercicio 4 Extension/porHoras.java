public class porHoras extends Empleado{
    private int horas;
    private double pago;
    
    public porHoras(String nombre, String apellido, int horas,
    double pago){
        super(nombre, apellido);
        setPago(pago);
        setHoras(horas);
    }
    
    public void setPago(double pago){
        this.pago = (pago >= 38) ? pago : 38;
    }
    
    public void setHoras(int horas){
        this.horas = horas;
    }
    
    
}
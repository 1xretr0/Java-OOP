public class Articulo
{
    private int cantidad;
    private double precio;
    private String descrip;
    
    public Articulo(int cant, String des, double precio){
        cantidad = (cant >= 1) ? cant : 1;
        descrip = new String(des);
        this.precio = (precio >= 0.1) ? precio : 0.1;
    }
    
    public double importe(){
        return cantidad * precio;
    }
}
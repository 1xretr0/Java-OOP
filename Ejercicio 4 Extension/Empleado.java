public abstract class Empleado{
    private String nombre, apellido;
    
    public Empleado(String nombre, String apellido){
        this.nombre = new String(nombre);
        this.apellido = new String(apellido);
    }
        
    public String getNombre(){
        return new String(this.nombre);
    }
    
    public String getApellido(){
        return new String(this.apellido);
    }
    
    public abstract double calcularSalario(); /* este metodo cambia
    su forma de calcularse de clase a clase*/
}
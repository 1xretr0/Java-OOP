/**
 * Abstract class Empleado - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Empleado implements Salario
{
    // instance variables - replace the example below with your own
    private String nombre;
    private String apellido;
    
    public Empleado(String nombre, String apellido){
        this.nombre = new String(nombre);
        this.apellido = new String(apellido);
    }
    
    public String getNombre() {
        return new String(this.nombre);
    }
    
    public String getApellido() {
        return new String(this.apellido);
    }
    
    // public abstract double calculaSalario();
    
}





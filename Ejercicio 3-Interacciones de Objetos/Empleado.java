
/**
 * Write a description of class Empleado here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Date;

public class Empleado
{
    private String nombre, apellido;
    private int numeroEmpleado;
    private Date ingreso;
    private double salario;
    private static int empleados = 100;
    
    //constructors
    public Empleado(String nom, String ap, double sal, int dia,
    int mes, int año){
        nombre = new String(nom);
        apellido = new String(ap);
        numeroEmpleado = 100;
        ingreso = new Date(año, mes, dia);
        setSalario(sal);
    }
    
    public Empleado(Empleado emp){
        nombre = new String(emp.getNombre());
        apellido = new String(emp.getApellido());
        numeroEmpleado = emp.getNumeroEmpleado();
        Date temp = emp.getIngreso();
        ingreso = new Date(temp.getYear(), temp.getMonth(), temp.getDay());
        setSalario(emp.getSalario());
    }
    
    //setters & getters
    public void setSalario(double sal){
        salario = (sal > 0) ? sal : 1;
    }
    
    public String getNombre(){
        return new String(nombre);
    }
    
    public String getApellido(){
        return new String(apellido);
    }
    
    public int getNumeroEmpleado(){
        return numeroEmpleado;
    }
    
    public Date getIngreso(){
        return new Date();
    }
    
    public double getSalario(){
        return salario;
    }
    
    public Empleado getEmpleado(){
        return new Empleado(this);
    }
    
    public String toString(){
        return "Empleado: " + nombre + " " + apellido + ", ID: " +
        Integer.toString(numeroEmpleado) + ", Fecha Ingreso: " + 
        ingreso.toString() + ", Salario: " + Double.toString(salario);
    }
    
    public static void main(String args[]){
        Empleado robert = new Empleado("Roberto", "Salazar", 800.00,
        15,2,2022);
        System.out.println(robert.toString());
    }
}

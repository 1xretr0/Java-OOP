
/**
 * Write a description of class Gerente here.
 * 
 * @author Roberto Salazar Marquez
 * @version 1.0
 */
public class Gerente extends Empleado
{
    // Variables de Instancia 
    private double salario;

    /**
     * Constructor para objetos de la clase Gerente
     */
    public Gerente(String nombre, String apellido, double salario)
    {
        super(nombre, apellido);
        setSalario(salario);
    }
    
    public void setSalario(double sal) {
        salario = (sal >= 2640) ? sal : 2640;
    }
    
    public double getSalario() {
        return salario;
    }
    
    public double calculaSalario() {
        return salario;
    }
    
}







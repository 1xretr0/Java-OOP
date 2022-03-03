public class Gerente extends Empleado{
    private double salario;
    
    public Gerente(String nombre, String apellido){
        super(nombre, apellido);
        setSalario(salario);
    }
    
    public void setSalario(double salario){
        this.salario = (sal >= 2640) ? salario : 2640;
    }
    
    public double getSalario(){
        return salario;
    }
    
    public double calcularSalario(){
        return getSalario();
    }
}

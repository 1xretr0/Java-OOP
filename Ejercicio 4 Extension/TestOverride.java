
/**
 * Write a description of class TestOverride here.
 * 
 * @author Roberto Salazar Marquez
 * @version 1.0
 */

public class TestOverride
{
    // Variables de Instancia 
    
    private final float PI = 3.14159f;

     public static void main(String args[]) {
         Punto p = new Punto(2,3);
         Circulo c = new Circulo(3,4,5);
         Cilindro cy = new Cilindro(3,4,5,6);
         
         cy.toString();
         c.toString();
        
        }
}






/**
 * Write a description of class TestCast here.
 * 
 * @author Roberto Salazar Marquez
 * @version 1.0
 */
public class TestCast
{
    // Variables de Instancia 

    public static void main(String args[]) {
        Punto p, pointRef;
        Circulo c, circleRef;
        
        p = new Punto(3,5);
        c = new Circulo(2, 1, 8);
        
        //  Caso 1
        pointRef = c;
        //  Caso 2
        pointRef = c;
        circleRef = (Circulo) pointRef;     // (Cast) = Conversión explícita
        //  Caso 3
        circleRef = (Circulo) p;            // Error!!!
    }
    
}







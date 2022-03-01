
/**
 * Write a description of class TestCast here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestCast
{
    public static void main(String args[]){
        Punto p, pointRef;
        Circle c, circleRef;
        
        p = new Punto(3,5);
        c = new Circle(2,1,8);
        
        // caso 1
        pointRef = c;
        // caso 2
        pointRef = c;
        circleRef = (Circle) pointRef; // (cast) conversión
        // caso 3
        circleRef = (Circle) p; // error!
    }
}
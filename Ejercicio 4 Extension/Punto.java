
/**
 * Write a description of class Punto here.
 * 
 * @author Roberto Salazar Marquez
 * @version 1.0
 */
public class Punto extends Object
{
    private int x;
    private int y;
    
    public Punto(int x, int y) {
        setX(x);
        setY(y);
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public String toString() {
        return "Punto (" + x + "," + y +")";
    }
}





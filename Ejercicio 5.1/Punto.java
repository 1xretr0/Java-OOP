public class Punto <E>
{
    private E x;
    private E y;
    
    public Punto(E x, E y) {
        setX(x);
        setY(y);
    }
    
    public void setX(E x) {
        this.x = x;
    }
    
    public void setY(E y) {
        this.y = y;
    }
    
    public E getX() {
        return x;
    }
    
    public E getY() {
        return y;
    }
    
    public String toString() {
        return new String("Punto (" + x + "," + y +")");
    }
}
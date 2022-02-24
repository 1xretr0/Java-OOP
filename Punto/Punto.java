public class Punto{
    private int x, y;
    
    public Punto(int x, int y){
        setX(x);
        setY(y);
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public String toString(){
        return "Punto: (" + x + ", " + y + ")";
    }
}
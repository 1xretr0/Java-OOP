public class ProdCons{
    private Productor p;
    private Consumidor c;
    private Almacen a;
    
    public ProdCons(){
        a = new Almacen();
        p = new Productor(a);
        c = new Consumidor(a);
        
        p.start(); c.start();
    }
    
    public static void main(){
        new ProdCons();
    }
}
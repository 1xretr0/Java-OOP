public class Almacen {
    public int valor;
    public boolean libre;
    
    public Almacen(){
        libre = true;
    }
    
    public synchronized void setValor(int val){
        while (!libre){
            try{
                wait();    
            }
            catch (InterruptedException exc){
                exc.printStackTrace();
            }
        }      
        valor = val;
        libre = false;
        notify();
    }
    
    public synchronized int getValor(){
        while (libre){
            try{
                wait();
            }
            catch (InterruptedException exc){
                exc.printStackTrace();
            }
        }
        libre = true;
        notify();
        return valor;
    }
}
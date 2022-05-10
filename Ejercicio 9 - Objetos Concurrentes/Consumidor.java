public class Consumidor extends Thread{
    private Almacen dato;
    
    public Consumidor(Almacen almacen){
        dato = almacen;
        
    }
    
    public void run(){
        int num;
        for (int i = 1; i <= 10; i++){
            
            try{
                sleep((int) Math.random() * 500);    
            }
            catch (InterruptedException exc){
                exc.printStackTrace();
            }
            num = dato.getValor();
            System.out.println("Se extrajo del almacen el valor: " 
            + num);
        }
    }
}
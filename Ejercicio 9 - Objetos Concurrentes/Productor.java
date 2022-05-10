public class Productor extends Thread{
    private Almacen dato;
    
    public Productor(Almacen almacen){
        dato = almacen;
    }
    
    public void run(){
        for (int i = 1; i <= 10; i++){
            dato.setValor(i);
            System.out.println("Se guardo en el almacen el valor: "
            + i);
            try{
                sleep((int) Math.random() * 500);    
            }
            catch (InterruptedException exc){
                exc.printStackTrace();
            }
        }
    }
}
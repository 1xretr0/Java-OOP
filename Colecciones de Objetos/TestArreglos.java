public class TestArreglos{
    private int arreglo[];  // declaracion de un bojeto arreglo
    private int []arreglo2 = new int[5];
    private int[] arreglo3;
    private int atributo;
    
    public TestArreglos(){
        arreglo = new int[5];
        arreglo3 = new int[10];
        for (int i = 0; i < arreglo3.length; i++)
            arreglo3[i] = i;
            
        atributo = 10;
        ejemplo(atributo);
        
    }
    
    public int ejemplo(int valor){
        valor = 2;
        return valor;
    }
    
    public static void main(String[] args){
        
    }
}
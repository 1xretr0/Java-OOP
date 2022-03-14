public class TestArreglos
{
    private int arreglo[], arreglo1;
    private int []arreglo2, arreglo4 = new int[10]; 
    private int[] arreglo3, arreglo5 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; 
    private int atributo;
    
    public TestArreglos()
    {
        arreglo = new int[20];
        arreglo2 = new int[20];
        arreglo = new int[50];
        
        for(int i = 0; i < arreglo.length; i++ )
            arreglo[i] = i;
        
        atributo = 10;
        System.out.println(ejemplo(arreglo));
    }
    
    public int ejemplo(int valor[]){
        valor[3] = 2;
        return valor[3];
    }
    
    public static void main(String[] args){
        
    }
}
public class TestGenericos{
    
    public static void imprimeArreglo(Double[] arregloEntrada){
        for (Double elemento : arregloEntrada)
            System.out.print(elemento + ", ");
        System.out.println();
    }
    
    public static void imprimeArreglo(Integer[] arregloEntrada){
        for (Integer elemento : arregloEntrada)
            System.out.print(elemento + ", ");
        System.out.println();
    }
    
    // metodo genérico, así evitamos usar el mismo metodo para cada
    // tipo de dato
    public static <E> void imprimeArreglo(E[] arregloEntrada){
        for (E elemento : arregloEntrada)
            System.out.print(elemento + ", ");
        System.out.println();
    }
    
    public static void main(String[] args){
        Double doble[] = {1.0, 2.0, 3.0, 4.0, 5.0};
        Integer entero[] = {1, 2, 3, 4, 5};
        Character caracter[] = {'a', 'b', 'c', 'd', 'e'};
        
        imprimeArreglo(doble);
    }
    
    public TestGenericos(){
        
    }
}
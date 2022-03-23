public class TestMatrices{
    private int matriz[][];
    private int matriz2[][] = {{1,2,3}, {4,5}, {6,7,8,9}};
    
    public TestMatrices(){
        matriz = new int[3][3];
        int cont = 1;
        
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                matriz[i][j] = cont;
            }
        }
    }
}
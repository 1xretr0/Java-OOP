import java.util.Vector;

public class Factura
{
    private String empresa, cliente;
    private static int folio;
    private Vector<Articulo> articulos;
    
    public Factura(String nomCliente){
        empresa = new String("Papelería Juanito");
        cliente = new String(nomCliente);
        folio++;
        articulos = new Vector<Articulo>(1);
    }
    
    public int getNumArticulos(){
        return articulos.size();
    }
    
    public void agregaArticulo(Articulo art){
        articulos.add(art);
    }
    
    public Articulo getArticulo(int index){
        return articulos.get(index);
    }
    
    public void setArticulo(int index, Articulo nuevo){
        articulos.set(index, nuevo);
    }
    
    public double calculaTotalArticulos(){  // Aqui nos quedamos
        // Articulo recorre;
        double sum = 0.0;
        
        /*
         * for (int i = 0; i < articulos.size(); ++i){
            recorre = getArticulo(i);
            sum += recorre.importe();
        }
        */
        
        for (Articulo recorre : articulos)
            sum += recorre.importe();
        
        return sum;
    }
}
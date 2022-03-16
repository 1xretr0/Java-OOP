public class Jugador{
    private String nombre, posicion;
    private int numero, minutoEntrada, minutoSalida, tarjetas;
    
    public Jugador(Jugador j){
        setNombre(j.getNombre());
        setPosicion(j.getPosicion());
        this.numero = j.numero;
        setMinutoEntrada(j.getMinutoEntrada());
        setMinutoSalida(j.getMinutoSalida());
        this.tarjetas = j.getTarjetas();
    }
    
    public Jugador(String nombre, String posicion, int numero){
        setNombre(nombre);
        setPosicion(posicion);
        this.numero = numero;
    }
    
    // setters
    public void setNombre(String nombre){
        this.nombre = new String(nombre);
    }
    
    public void setPosicion(String posicion){
        this.posicion = new String(posicion);
    }
    
    public void setMinutoEntrada(int minuto){
        this.minutoEntrada = minuto;
    }
    
    public void setMinutoSalida(int minuto){
        this.minutoSalida = minuto;
    }
    
    // getteres
    public String getNombre(){
        return new String(nombre);
    }
    
    public String getPosicion(){
        return new String(posicion);
    }
    
    public int getMinutoEntrada(){
        return minutoEntrada;
    }
    
    public int getMinutoSalida(){
        return minutoSalida;
    }
    
    public int getNumero(){
        return numero;
    }
    
    public int getTarjetas(){
        return tarjetas;
    }
    
    // custom
    public void agregarTarjeta(){
        this.tarjetas++;
    }
    
    public String toString(){
        return new String(numero + " " + nombre + " " + posicion);
    }
}
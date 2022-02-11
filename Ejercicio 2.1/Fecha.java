/**
 * @author sebas
 * @version 2/02/22
 */

public class Fecha
{
    //atributes
    private int dia, mes, año, formato = 1;
    
    //constructos
    public Fecha(int d, int m, int a){
        setDia(d);
        setMes(m);
        setAño(a);
    }
    
    public Fecha(int m, int a){
        setDia(1);
        setMes(m);
        setAño(a);
    }
    
    public Fecha(int a){
        setDia(1);
        setMes(1);
        setAño(a);
    }
    
    public Fecha(){
        setDia(1);
        setMes(1);
        setAño(1900);
    }
    
    //setters
    public void setDia(int d){
        //int diasMesNormal[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        //int diasMesBisiesto[] = {31,29,31,30,31,30,31,31,30,31,30,31};
        
        /*if (año % 400 == 0){
            diasMes[2] = 29;
            
            if (d >= 1 && d <= diasMes[mes]){
                dia = d;
            }
        }
        else if (año % 100 == 0){
            if (d >= 1 && d <= diasMes[mes]){
                dia = d;
            }
        }
        else if (año % 4 == 0){
            diasMes[2] = 29;
            if (d >= 1 && d <= diasMes[mes]){
                dia = d;
            }
        }
        else {
            if (d >= 1 && d <= diasMes[mes]){
                dia = d;
            }
        }*/
        
        if (año % 4 == 0){
            int diasMes[] = {31,29,31,30,31,30,31,31,30,31,30,31};
            dia = (d >= 1 && d <= diasMes[mes--]) ? d : 1;
        }
        else{
            int diasMes[] = {31,28,31,30,31,30,31,31,30,31,30,31};
            dia = (d >= 1 && d <= diasMes[mes--]) ? d : 1;
        }
        
        
    }
    
    public void setMes(int m){
        mes = (m >= 1 && m <= 12) ? m : 1;
    }
    
    public void setAño(int a){
        año = (a != 0) ? a : 1900;
    }
    
    //getters
    public int getDia(){
        return dia;
    }
    
    public int getMes(){
        return mes;
    }
    
    public int getAño(){
        return año;
    }
    
    //custom methods
    public void setFormato(int fmt){
        if (fmt >= 1 && fmt <= 5){
            formato = fmt;
        }
    }
    
    public int getFormato(){
        return formato;
    }
    
    public String toString(){
        String cadena = "";
        switch (formato){
            case 1:
                //cadena = dia + "/" + mes + "/" + año;
                cadena = (dia < 10 ? "0" : "") + dia + "/" + (mes < 10 ? "0" : "")
                + mes + "/" + año;
                break;
            case 2:
                cadena = (mes < 10 ? "0" : "") + mes + "/" + (dia < 10 ? "0" : "")
                + dia + "/" + año;
                break;
            case 3:
                cadena = año + "/" + (mes < 10 ? "0" : "") + mes + "/" +
                (dia < 10 ? "0" : "") + dia;
                break;
            case 4: 
                cadena = (dia < 10 ? "0" : "") + dia + " " + (mes < 10 ? "0" : "")
                + mes + " " + año;
                break;
            case 5: {
                String nombreMes = "";
                
                switch(mes){
                    case 1:
                        nombreMes = "Enero";
                        break;
                    case 2:
                        nombreMes = "Febrero";
                        break;
                    case 3:
                        nombreMes = "Marzo";
                        break;
                    case 4:
                        nombreMes = "Abril";
                        break;
                    case 5:
                        nombreMes = "Mayo";
                        break;
                    case 6:
                        nombreMes = "Junio";
                        break;
                    case 7:
                        nombreMes = "Julio";
                        break;
                    case 8:
                        nombreMes = "Agosto";
                        break;
                    case 9:
                        nombreMes = "Septiembre";
                        break;
                    case 10:
                        nombreMes = "Octubre";
                        break;
                    case 11:
                        nombreMes = "Noviembre";
                        break;
                    case 12:
                        nombreMes = "Diciembre";
                        break;
                    default:
                        nombreMes = "Enero";
                        break;
                }
                
                cadena = (dia < 10 ? "0" : "") + dia + " de " + nombreMes + " de "
                + año;
                break;
            }
        }
        
        return cadena;
    }
    
    public boolean esDomingoPascua(){
        int a = año % 19;
        int b = año % 4;
        int c = año % 7;
        int d = (19 * a + 24) % 30;
        int e = (2 * b + 4 * c + 6 * d + 5) % 7;
        String pascua = "";
        int dia_aux, mes_aux;
        
        if (d+e < 10){
            dia_aux = d + e + 22;
            mes_aux = 3;
            pascua = (dia_aux < 10 ? "0" : "") + dia_aux + "/" + 
            (mes_aux < 10 ? "0" : "") + mes_aux + "/" + año;
        } else if (d+e > 9){
            dia_aux = d + e - 9;
            mes_aux = 4;
            pascua = (dia_aux < 10 ? "0" : "") + dia_aux + "/" + 
            (mes_aux < 10 ? "0" : "") + mes_aux + "/" + año;
        }
        
        //String fecha_aux = "26/04/" + año
        if (pascua == ("26/04"+año)){
            pascua = "19/04" + año;
        }
        
        if (pascua == ("25/04"+año) && d == 28 && e == 6 && a > 10){
            pascua = "18/04" + año;
        }
        
        this.setFormato(1);
        if (this.toString() == pascua){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void nextDay(){
        dia += 1;
    }
}
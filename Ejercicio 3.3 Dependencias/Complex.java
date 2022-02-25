import java.util.*;

/**
 * Write a description of class Complex here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complex
{
    private int p_real, p_imag;
    // private static double i = Math.sqrt(-1);
    
    public Complex(int real, int imag){
        setReal(real);
        setImag(imag);
    }
    
    public Complex(){
        setReal(0);
        setImag(0);
    }
    
    public Complex(Complex Comp){
        setReal(Comp.getReal());
        setImag(Comp.getImag());
    }
    
    public void setReal(int real){
        this.p_real = real;
    }
    
    public void setImag(int imag){
        this.p_imag = imag;
    }
    
    public int getReal(){
        return this.p_real;
    }
    
    public int getImag(){
        return this.p_imag;
    }
    
    // custom methods
    public Complex suma(Complex comp){
        int real_aux = this.getReal() + comp.getReal();
        int imag_aux = this.getImag() + comp.getImag();
        return new Complex(real_aux, imag_aux);
    }
    
    public Complex resta(Complex comp){
        int real_aux = this.getReal() - comp.getReal();
        int imag_aux = this.getImag() - comp.getImag();
        return new Complex(real_aux, imag_aux);
    }
    
    public String toString(){
        return "(" + this.p_real + ", " + this.p_imag + "i)";
    }
}

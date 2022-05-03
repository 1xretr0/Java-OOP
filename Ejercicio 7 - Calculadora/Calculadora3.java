
/**
 * Write a description of class Calculador here.
 * 
 * @author Roberto Salazar Marquez
 * @version 1.0
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;

public class Calculadora3 extends Applet
{
    // Variables de Instancia 
    private JButton b1, b2, b3,b4, b5, b6, b7, b8, b9;
    private JButton b10, b11, b12, b13, b14, b15, b16, b17;
    private JTextField display;
    private JPanel teclado, displ;
    private boolean punto = true, op = true;
    private char car = ' ';
    private double num1, num2, res;
    

    /**
     * Constructor para objetos de la clase Calculador
     */
    public Calculadora3()
    {        
        b1 = new JButton("1");  b2 = new JButton("2");
        b3 = new JButton("3");  b4 = new JButton("4");
        b5 = new JButton("5");  b6 = new JButton("6");
        b7 = new JButton("7");  b8 = new JButton("8");
        b9 = new JButton("9");  b10 = new JButton("0");
        b11 = new JButton("+");  b12 = new JButton("-");
        b13 = new JButton("*");  b14 = new JButton("/");
        b15 = new JButton("=");  b16 = new JButton(".");
        b17 = new JButton("C"); 
        
        display = new JTextField("0");
        teclado = new JPanel();
        displ = new JPanel();
        
        teclado.setLayout( new GridLayout(4, 4, 3, 3) );
        teclado.add(b7);
        teclado.add(b8);
        teclado.add(b9);
        teclado.add(b14);
        teclado.add(b4);
        teclado.add(b5);
        teclado.add(b6);
        teclado.add(b13);
        teclado.add(b1);
        teclado.add(b2);
        teclado.add(b3);
        teclado.add(b12);
        teclado.add(b15);
        teclado.add(b10);
        teclado.add(b16);
        teclado.add(b11);
        
        displ.setLayout( new BorderLayout() );
        displ.add(b17, "East");
        displ.add(display, "Center");
        
        setLayout(new BorderLayout() );
        this.add(teclado, "Center");
        add(displ, "North");
        
        punto = op = true;
        
        b1.addActionListener( new BotonNumerico() );
        b2.addActionListener( new BotonNumerico() );
        b3.addActionListener( new BotonNumerico() );
        b4.addActionListener( new BotonNumerico() );
        b5.addActionListener( new BotonNumerico() );
        b6.addActionListener( new BotonNumerico() );
        b7.addActionListener( new BotonNumerico() );
        b8.addActionListener( new BotonNumerico() );
        b9.addActionListener( new BotonNumerico() );
        b10.addActionListener( new BotonNumerico() );
        b11.addActionListener( new BotonOpera() );
        b12.addActionListener( new BotonOpera() );
        b13.addActionListener( new BotonOpera() );
        b14.addActionListener( new BotonOpera() );
        b15.addActionListener( new BotonIgual() );
        b16.addActionListener( new BotonPunto() );
        b17.addActionListener( new BotonC() );
        
        setSize(300,350);
        setVisible(true);  
        display.setEnabled(false);
    }
    
    
    private class BotonC implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display.setText("0");
            punto = true;
            op = true;
            num1 = num2 = 0.0;
        }
    }
    
    private class BotonNumerico implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String displaynum = display.getText();
            if( displaynum.equals("0") )
                displaynum = "";
            displaynum = displaynum + e.getActionCommand();
            display.setText( displaynum );
        }
    }
    
    private class BotonIgual implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            num2 = Double.parseDouble( display.getText());
            switch (car) {
                case '+': res = num1 + num2; break;
                case '-': res = num1 - num2; break;
                case '*': res = num1 * num2; break;
                case '/': res = num1 / num2; break;
            }
            display.setText( String.valueOf(res) );
            op = punto = true;
        }
    }
    
    private class BotonOpera implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(op) {
                String sign = new String( e.getActionCommand() ); 
                car = sign.charAt(0);
                num1 = Double.parseDouble(display.getText());
                display.setText("0");
                op = false;
                punto = true;
            }
        }
    }
    
    private class BotonPunto implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(punto) {
                String displaynum = display.getText();
                displaynum = displaynum + ".";
                display.setText( displaynum );
                punto = false;
            }
        }
    }
    
    
    public static void main(String arg[]) {
        Calculadora3 calc = new Calculadora3();  
    }
    
    
}





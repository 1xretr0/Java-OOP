
/**
 * Write a description of class Calculadora here.
 * 
 * @author Roberto Salazar Marquez
 * @version 1.0
 */
import java.awt.*;

public class Calculadora extends Frame
{
    // Variables de Instancia 
    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;  // teclas de numeros
    private Button b11, b12, b13, b14, b15, b16, b17;        // teclas +,-,*,/,=, ., C
    private TextField display;
    private Panel teclado, displ;
    private boolean punto = true, op = true;
    private char c = ' ';
    private double num1 = 0.0, num2 = 0.0, res;

    /**
     * Constructor para objetos de la clase Calculadora
     */
    public Calculadora()
    {
        super("Calculadora");
        
        b1 = new Button("1"); b2 = new Button("2");
        b3 = new Button("3"); b4 = new Button("4");
        b5 = new Button("5"); b6 = new Button("6");
        b7 = new Button("7"); b8 = new Button("8");
        b9 = new Button("9"); b10 = new Button("0");
        b11 = new Button("+"); b12 = new Button("-");
        b13 = new Button("*"); b14 = new Button("/");
        b15 = new Button("="); b16 = new Button(".");
        b17 = new Button("C"); 
        
        display = new TextField("0");
        teclado = new Panel();
        displ = new Panel();    
        
        teclado.setLayout( new GridLayout(4, 4, 5, 5) );
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
        displ.add(display, "Center");
        displ.add(b17, "East");
        
        add(displ, "North");
        add(teclado, "Center");
        
    }
    
    public boolean handleEvent(Event e) {
        if(e.id == Event.WINDOW_DESTROY ) {
            hide();
            dispose();
            return true;
        }
        return super.handleEvent(e);
    }
    
     public boolean action(Event e, Object o)
    {
        if(e.target instanceof Button) {
            if(e.target == b17) {
                display.setText("0");
                punto = true;
                op = true;
                num1 = num2 = 0.0;
            }
            else {
                if(e.target == b11 || e.target == b12 || e.target == b13 || e.target == b14) {
                    if(op) {
                        Button b = (Button) e.target;
                        String sign = new String(b.getLabel()); 
                        c = sign.charAt(0);
                        num1 = Double.parseDouble(display.getText());
                        display.setText("0");
                        op = false;
                        punto = true;
                    }
                } else {
                    if(e.target == b16) {
                        if(punto) {
                            String displaynum = display.getText();
                            displaynum = displaynum + ".";
                            display.setText( displaynum );
                            punto = false;
                        }
                    } else {
                        if(e.target == b15) {
                            num2 = Double.parseDouble( display.getText());
                            switch (c) {
                                case '+': res = num1 + num2; break;
                                case '-': res = num1 - num2; break;
                                case '*': res = num1 * num2; break;
                                case '/': res = num1 / num2; break;
                            }
                            display.setText( String.valueOf(res) );
                            op = punto = true;
                        } else {
                            Button b = (Button) e.target;
                            String displaynum = display.getText();
                            if( displaynum.equals("0") )
                                displaynum = "";
                            displaynum = displaynum + b.getLabel();
                            display.setText( displaynum );
                        }
                    } 
                }
            }
        }
        
        
        return true;
    }
    
    public static void main(String args[]) {
        Calculadora calc = new Calculadora();
        calc.resize(300,350);
        calc.show();
    }
    
}

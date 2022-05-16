import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PuntosEcuacionUI extends JFrame{
    private PuntosEcuacion lienzo;
    private JPanel buttons, crear_polinomio, add_termino, graficar,
    add_termino2;
    
    public PuntosEcuacionUI(){
        super("Graficador");
        addWindowListener(new CW());
        setSize(800,550);
        
        // panel global de botones
        buttons = new JPanel();
        buttons.setLayout(new GridLayout(3,0));
        
        // panel seccion crear polinomio
        crear_polinomio = new JPanel();
        crear_polinomio.setLayout(new BorderLayout());
        crear_polinomio.add(new JLabel("Parámetros de la Gráfica                                        "), 
        "North");
        crear_polinomio.add(new JLabel("Grado del polinomio: "),
        "West");
        crear_polinomio.add(new JTextField());
        crear_polinomio.add(new JButton("Crear Polinomio"), 
        "South");
        
        // panel seccion añadir termino
        add_termino = new JPanel();
        add_termino.setLayout(new GridLayout(3,2));
        add_termino.add(new JLabel("Coeficiente del Termino: "),
        "West");
        add_termino.add(new JTextField());
        add_termino.add(new JLabel("Exponente del Termino: "),
        "West");
        add_termino.add(new JTextField());
        add_termino.add(new JButton("Añadir Termino"), "South");
        
        graficar = new JPanel();
        graficar.setLayout(new GridLayout(4,2));
        graficar.add(new JLabel("Límite Inferior: "));
        graficar.add(new JTextField());
        graficar.add(new JLabel("Límite Superior: "));
        graficar.add(new JTextField());
        graficar.add(new JLabel("Intervalo: "));
        graficar.add(new JTextField());
        graficar.add(new JButton("Graficar"));
        
        buttons.add(crear_polinomio);
        buttons.add(add_termino);
        buttons.add(graficar);
        // buttons.add(new Button("Button 2"), "East");
        
        
        
        lienzo = new PuntosEcuacion();
        add(lienzo, "Center");
        add(buttons, "West");
        
        setResizable(false);
        setVisible(true);
        
    }
    
    private class CW extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            setVisible(false);
            dispose();
        }
    }
    
    // public static void main(String arg[]){
        // PuntosEcuacionUI graficadora = new PuntosEcuacionUI();
    // }
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PuntosEcuacionUI extends JFrame{
    private PuntosEcuacion lienzo;
    private JPanel buttons, crear_polinomio, add_termino, graficar;
    private JTextField t_grado, t_coef, t_exp, t_linf, t_lsup, t_inc;
    private JButton b_crear, b_add, b_graficar;
    private Polinomio polinomio;
    
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
        crear_polinomio.add(new JLabel("Parámetros de la Gráfica"), 
        "North");
        crear_polinomio.add(new JLabel("Grado del polinomio: "),
        "West");
        t_grado = new JTextField();
        crear_polinomio.add(t_grado);
        b_crear = new JButton("Crear Polinomio");
        crear_polinomio.add(b_crear, "South");
        
        // panel seccion añadir termino
        add_termino = new JPanel();
        add_termino.setLayout(new GridLayout(3,2));
        add_termino.add(new JLabel("Coeficiente del Termino: "),
        "West");
        t_coef = new JTextField();
        add_termino.add(t_coef);
        add_termino.add(new JLabel("Exponente del Termino: "),
        "West");
        t_exp = new JTextField();
        add_termino.add(t_exp);
        b_add = new JButton("Añadir Termino");
        add_termino.add(b_add, "South");
        
        // panel seccion graficar
        graficar = new JPanel();
        graficar.setLayout(new GridLayout(4,2));
        graficar.add(new JLabel("Límite Inferior: "));
        t_linf = new JTextField();
        graficar.add(t_linf);
        graficar.add(new JLabel("Límite Superior: "));
        t_lsup = new JTextField();
        graficar.add(t_lsup);
        graficar.add(new JLabel("Intervalo: "));
        t_inc = new JTextField();
        graficar.add(t_inc);
        b_graficar = new JButton("Graficar");
        graficar.add(b_graficar);
        
        b_crear.addActionListener(new BotonCrear());
        b_add.addActionListener(new BotonAdd());
        b_graficar.addActionListener(new BotonGraficar());
        
        // añadir secciones a seccion global
        buttons.add(crear_polinomio);
        buttons.add(add_termino);
        buttons.add(graficar);
        
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
    
    // funcion listener para boton crear polinomio
    private class BotonCrear implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int grado = Integer.parseInt(t_grado.getText());
            polinomio = new Polinomio(grado);
        }
    }
    
    // funcion listener para boton añadir termino
    private class BotonAdd implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double coeficiente = Double.parseDouble(t_coef.getText());
            int exponente = Integer.parseInt(t_exp.getText());
            
            polinomio.agregaTermino(new Termino(coeficiente,exponente));
            
            t_coef.setText("");
            t_exp.setText("");
        }
    }
    
    // funcion listener para boton graficar polinomio
    private class BotonGraficar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double inf = Double.parseDouble(t_linf.getText());
            double sup = Double.parseDouble(t_lsup.getText());
            double inc = Double.parseDouble(t_inc.getText());
            
            lienzo.agregaPolinomio(polinomio);
            lienzo.calculaPuntos(inf, sup, inc);
        }
    }
    
    // public static void main(String arg[]){
        // PuntosEcuacionUI graficadora = new PuntosEcuacionUI();
    // }
}
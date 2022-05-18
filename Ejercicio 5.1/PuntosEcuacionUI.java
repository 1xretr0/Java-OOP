import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;
import java.io.*;

// this class is the main ui of the project
// creates the ui and calls puntosecuacion for the polinomio process and
// graphic painting

public class PuntosEcuacionUI extends JFrame{
    // declaracion elemento grafico puntos ecuacion
    private PuntosEcuacion lienzo;
    // declaracion panel global de botones y paneles por seccion
    private JPanel buttons, crear_polinomio, add_termino, graficar, p_grafica;
    // declaracion txt fields
    private JTextField t_grado, t_coef, t_exp, t_linf, t_lsup, t_inc, t_poli;
    // declaracion buttons
    private JButton b_crear, b_add, b_graficar;
    // declaracion objeto polinomio
    private Polinomio polinomio;
    // declaracion write flow para output file
    private DataOutputStream write;
    
    
    public PuntosEcuacionUI(){
        super("Graficador");
        addWindowListener(new CW());
        setSize(810,550);
        
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
        // t_grado accept only numbers
        t_grado.addKeyListener(new KeyAdapter(){
           public void keyTyped(KeyEvent e){
               char c = e.getKeyChar();
               if (((c < '0') || (c > '9')) && (c !=
               KeyEvent.VK_BACK_SPACE)){
                   e.consume();
               }
           }
        });
        
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
        
        // listeners para botones
        b_crear.addActionListener(new BotonCrear());
        b_add.addActionListener(new BotonAdd());
        b_graficar.addActionListener(new BotonGraficar());
        
        // añadir secciones a seccion global
        buttons.add(crear_polinomio);
        buttons.add(add_termino);
        buttons.add(graficar);
        
        // panel seccion grafica
        p_grafica = new JPanel();
        p_grafica.setLayout(new BorderLayout());
        
        lienzo = new PuntosEcuacion();
        p_grafica.add(lienzo);
        t_poli = new JTextField();
        t_poli.setEditable(false);
        p_grafica.add(t_poli, "South");
        
        // add grafica y botones a pantalla
        add(p_grafica, "Center");
        add(buttons, "West");
        
        setResizable(false);
        setVisible(true);
    }
    
    // closing window event
    private class CW extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            setVisible(false);
            dispose();
        }
    }
    
    // funcion listener para boton crear polinomio
    private class BotonCrear implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                int grado = Integer.parseInt(t_grado.getText());
                polinomio = new Polinomio(grado);
                // dialog creacion polinomio
                JOptionPane.showMessageDialog(null, "Polinomio creado!");
            }
            catch (NumberFormatException exc){
                JOptionPane.showMessageDialog(null, 
                "Error. Ingrese un grado mayor a 0.");
            }
        }
    }
    
    // funcion listener para boton añadir termino
    private class BotonAdd implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                double coeficiente = Double.parseDouble(t_coef.getText());
                int exponente = Integer.parseInt(t_exp.getText());
                polinomio.agregaTermino(new Termino(coeficiente,exponente));
            }
            catch (NumberFormatException exc){
                // valida tipo de dato ingresado
                JOptionPane.showMessageDialog(null, 
                "Error. Coeficiente y/o Exponente no Valido.");
            }
            catch (ArrayIndexOutOfBoundsException exc){
                // valida exponentes con el grado del polinomio
                // exc.printStackTrace();
                JOptionPane.showMessageDialog(null,
                ("Error. Grado del polinomio: " + t_grado.getText()));
            }
            catch (NullPointerException exc){
                JOptionPane.showMessageDialog(null, 
                "Error. Cree un polinomio antes.");
            }
            
            t_coef.setText("");
            t_exp.setText("");
        }
    }
    
    // funcion listener para boton graficar polinomio
    private class BotonGraficar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                double inf = Double.parseDouble(t_linf.getText());
                double sup = Double.parseDouble(t_lsup.getText());
                double inc = Double.parseDouble(t_inc.getText());
                
                lienzo.agregaPolinomio(polinomio);
                // escribe polinomio en text field
                t_poli.setText(polinomio.toString());
                lienzo.calculaPuntos(inf, sup, inc);
                
                try
                {
                    guardaPuntos();
                }
                catch (java.io.IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
            catch (NumberFormatException exc){
                JOptionPane.showMessageDialog(null, 
                "Error. Limite inferior, superior y/o intervalo no validos.");
                t_linf.setText("");
                t_lsup.setText("");
                t_inc.setText("");
            }
            catch (NullPointerException exc){
                JOptionPane.showMessageDialog(null, 
                "Error. Crea un polinomio antes.");
            }
        }
    }
    
    public void guardaPuntos() throws IOException {
        // try para exception al escribir en archivo
        try {
            write = new DataOutputStream(new BufferedOutputStream(
            new FileOutputStream("puntos.txt")));
            
            Vector <Punto> puntos = lienzo.getPuntosEcuacion();
            int i = 0;
            while (i < (puntos.size() - 1)){
                write.writeUTF(puntos.get(i).toString() + '\n');
                i++;
            }
            
        }
        catch (FileNotFoundException exc){
            System.out.println("El archivo no se encontro.");
        }
        finally{
            if (write != null){
                write.close();
            }
        }
    }
    
    // public static void main(String arg[]){
        // PuntosEcuacionUI graficadora = new PuntosEcuacionUI();
    // }
}
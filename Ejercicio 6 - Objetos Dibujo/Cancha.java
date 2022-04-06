import java.awt.*;
import java.awt.geom.*;

/**
 * Write a description of class Dibujo here.
 *
 * @author sebas moran
 * @version 1.0
 */
public class Cancha extends Frame
{
    public Cancha(){
        super("Cancha");
    }
    
    public boolean handleEvent(Event e){
        if (e.id == Event.WINDOW_DESTROY){
            setVisible(false); dispose();
            // hide() esta deprecated
            return true;
        }
        return super.handleEvent(e);
    }
    
    public void paint(Graphics gc1d){
        Graphics2D gc = (Graphics2D) gc1d;
        
        // dibuja cancha base
        gc.setColor(Color.green);
        gc.fill(new Rectangle2D.Float(50, 50, 400, 250));
        
        // dibuja lineas marcadas
        gc.setColor(Color.lightGray);
        gc.setStroke(new BasicStroke(3.5f));
        gc.draw(new Rectangle2D.Float(55, 55, 390, 240));
        
        // linea media
        gc.draw(new Line2D.Float(250, 55, 250, 292));
        
        // porterias
        gc.draw(new Line2D.Float(55, 135, 95, 135));
        // gc.draw(new Line2D.Float(55, 175, 75, 175));
        gc.draw(new Line2D.Float(55, 215, 95, 215));
        
        gc.draw(new Line2D.Float(390, 135, 400, 135));
        // gc.draw(new Line2D.Float(55, 175, 75, 175));
        gc.draw(new Line2D.Float(390, 215, 400, 215));
    }
    
    public static void main(String args[]){
        Cancha cancha = new Cancha();
        cancha.resize(550, 450);
        cancha.show();
    }
}

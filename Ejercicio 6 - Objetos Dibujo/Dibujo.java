import java.awt.*;

/**
 * Write a description of class Dibujo here.
 *
 * @author sebas moran
 * @version 1.0
 */
public class Dibujo extends Frame
{
    public Dibujo(){
        super("Dibujo");
    }
    
    public boolean handleEvent(Event e){
        if (e.id == Event.WINDOW_DESTROY){
            setVisible(false); dispose();
            // hide() esta deprecated
            return true;
        }
        return super.handleEvent(e);
    }
    
    public void paint(Graphics gc){
        Color color = new Color(0, 0, 0);
        gc.setColor(color.blue);
        Font font = new Font("calibri", 1, 20);
        gc.setFont(font);
        gc.drawString("Saludos Programas!!!", 100, 150);
    }
    
    public static void main(String args[]){
        Dibujo dibujo = new Dibujo();
        dibujo.resize(350, 300);
        dibujo.show();
    }
}

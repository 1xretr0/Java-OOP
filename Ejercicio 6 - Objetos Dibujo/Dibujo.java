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
        // antigua awt
        /* Color color = new Color(0, 0, 0);
        gc.setColor(color.blue);
        Font font = new Font("Arial", Font.PLAIN, 20);
        gc.setFont(font);
        gc.drawString("Saludos Programas!!!", 100, 150);
        gc.drawLine(0, 0, 125, 200);
        gc.drawRect(100, 40, 90, 125);
        gc.setColor(Color.blue);
        gc.fillRoundRect(150,100,70, 90, 45, 45);
        gc.fillOval(200, 200, 100, 50);
        gc.setColor(Color.gray);
        gc.fillRoundRect(300, 300, 100, 100, 180, 180);
        gc.setColor(Color.green);
        gc.drawArc(300, 100, 70, 100, 45, 225);
        gc.drawRect(300,100, 70, 100);
        
        // para crear poligono
        int arrX[] = {25, 225, 40, 60, 305};
        int arrY[] = {50, 145, 234, 345, 65};
        gc.fillPolygon(arrX, arrY, 3); */
        
        // nueva awt
        Graphics2D gc2D = (Graphics2D) gc;
    }
    
    public static void main(String args[]){
        Dibujo dibujo = new Dibujo();
        dibujo.resize(550, 450);
        dibujo.show();
    }
}

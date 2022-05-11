import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ReadFile4 extends Frame
{
    private TextArea editor;
    private DataInputStream lee;
    private DataOutputStream escribe;
    
    private String nombres[] = {"Juan", "Raúl", "Luis"};
    private String apellidos[] = {"Pérez", "Gómez", "Montiel"};
    private int edades[] = {15, 20, 25};
    
    public ReadFile4() throws IOException{
        super("Editor de texto");
        String c;
        editor = new TextArea();
        add(editor, "Center");
        
        try{
            escribe = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("agenda.dat")));
            for(int i = 0; i < 3; i++){
                escribe.writeUTF(nombres[i]);
                escribe.writeUTF(apellidos[i]);
                escribe.writeInt(edades[i]);
            }
        }catch(FileNotFoundException e){
            System.out.println("El archivo no se encontró");
        }catch(EOFException e){
            e.printStackTrace();
        }finally{
            if(lee != null){
                lee.close();
            }
        }
        
        addWindowListener(new CW());
        setVisible(true);
        setSize(500, 500);
    }
    
    private class CW extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            setVisible(false);
            dispose();
        }
    }
}
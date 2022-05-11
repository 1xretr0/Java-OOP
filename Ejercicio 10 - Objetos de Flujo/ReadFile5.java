import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ReadFile5 extends Frame
{
    private TextArea editor;
    private DataInputStream lee;
    private DataOutputStream escribe;
    
    private String nombres[] = {"Juan", "Raul", "Luis"};
    private String apellidos[] = {"Pérez", "Gómez", "Montiel"};
    private int edades[] = {15, 20, 25};
    
    public ReadFile5() throws IOException{
        super("Editor de texto");
        String c;
        editor = new TextArea();
        add(editor, "Center");
        
        try{
            lee = new DataInputStream(new BufferedInputStream(
            new FileInputStream("agenda.dat")));
            
            while (true){
                String nom = lee.readUTF();
                String ap = lee.readUTF();
                int edad = lee.readInt();
                editor.append(nom + " " + ap + ", edad: " + edad + "\n");
            }
            
        }catch(FileNotFoundException e){
            System.out.println("El archivo no se encontró.");
        }
        catch (EOFException exc){
            System.out.println("Archivo leído.");
        }
        finally{
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
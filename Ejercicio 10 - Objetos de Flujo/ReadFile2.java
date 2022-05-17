import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ReadFile2 extends Frame
{
    TextArea editor;
    FileReader entrada;

    public ReadFile2() throws IOException
    {
        super("Lector de Archivos");
        int c;
        editor = new TextArea();
        setLayout(new BorderLayout());
        add(editor,"Center");
        try {
            entrada = new FileReader("ReadFile.java");
        
            while((c = entrada.read()) !=  -1) {
                editor.append(String.valueOf((char)c));
            }
        }catch(FileNotFoundException e)
         {  System.out.println("Archivo no encontrado");  }
        finally {
            if(entrada != null)
                entrada.close();
        }

        
        addWindowListener(new CW() );
        setSize(500,550);
        setVisible(true);
    }

    private class CW extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        try {
            ReadFile2 readFile = new ReadFile2();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}
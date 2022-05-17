import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ReadFile extends Frame
{
    TextArea editor;
    FileInputStream entrada;

    public ReadFile() throws IOException
    {
        super("Lector de Archivos");
        int c;
        editor = new TextArea();
        setLayout(new BorderLayout());
        add(editor,"Center");
        try {
            entrada = new FileInputStream("ReadFile.java");
        
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
    }

    private class CW extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            setVisible(true);
            dispose();
        }
    }

}
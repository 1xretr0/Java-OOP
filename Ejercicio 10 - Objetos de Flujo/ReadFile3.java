import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ReadFile3 extends Frame
{
    private TextArea editor;
    private BufferedReader entrada;
    
    public ReadFile3() throws IOException{
        super("Editor de texto");
        String c;
        editor = new TextArea();
        add(editor, "Center");
        
        try{
            entrada = new BufferedReader(new FileReader("ReadFile3.java"));
            while((c = entrada.readLine()) != null){  
                editor.append(c + '\n');
            }
        }catch(FileNotFoundException e){
            System.out.println("El archivo no se encontró");
        }finally{
            if(entrada != null){
                entrada.close();
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
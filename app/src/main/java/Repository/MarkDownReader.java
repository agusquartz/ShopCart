
package Repository;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 *
 * @author agustin
 */
public class MarkDownReader {
    public MarkDownReader(){
        
    }
    
    public static void main(String[] args){
        String directorioPrincipal = System.getProperty("user.dir");
        String nuevaRuta = directorioPrincipal.replace(directorioPrincipal.substring(directorioPrincipal.lastIndexOf("app")), "");
        String readmePath = nuevaRuta + "README.md"; // Ruta del archivo README.md
        String readmeContent = ""; // Variable para almacenar el contenido del archivo

        
        
        System.out.println(nuevaRuta);
        System.out.println(directorioPrincipal);
        
        StringBuilder contenido = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(readmePath))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Parser parser = Parser.builder().build();
        Node document = parser.parse(contenido.toString());
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String contenidoHTML = renderer.render(document);
        
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 720);
        
        JEditorPane editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        editorPane.setText(contenidoHTML);
        editorPane.setEditable(false);
        editorPane.setBackground(Color.WHITE);
        
        JScrollPane pane1 = new JScrollPane(editorPane);
        pane1.setBackground(Color.WHITE);
        
        frame.add(pane1);
        frame.setVisible(true);
    }
}

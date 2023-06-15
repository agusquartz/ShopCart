
package Repository;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author agustin
 */
public class MarkDownReader {
    public MarkDownReader(){
        
    }
    
    public static void main(String[] args){
        String readmePath = File.separator + "README.md"; // Ruta del archivo README.md
        String readmeContent = ""; // Variable para almacenar el contenido del archivo

        
        String directorioPrincipal = System.getProperty("user.dir");
        System.out.println(directorioPrincipal);
        
    try {
        BufferedReader reader = new BufferedReader(new FileReader(readmePath));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
        }

        readmeContent = sb.toString();
    } catch (IOException e) {
        e.printStackTrace();
    }
        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String htmlContent = renderer.render(parser.parse(readmeContent));
        
        
        JFrame frame = new JFrame();
        JLabel readmeLabel = new JLabel();
        readmeLabel.setText(htmlContent);
        readmeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        
        frame.add(readmeLabel);
        frame.setVisible(true);
    }
}

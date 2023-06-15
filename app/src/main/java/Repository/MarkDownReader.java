
package Repository;

import View.EventsHandler;
import View.ScrollBarModified;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author agustin
 */
public class MarkDownReader {
    private String mainPath = System.getProperty("user.dir");
    private String newPath = mainPath.replace(mainPath.substring(mainPath.lastIndexOf("app")), "");
    private String readmePath = newPath + "README.md";
    private EventsHandler eventsHandler = EventsHandler.getInstance();
    private StringBuilder content;
    private String contentHTML;
    private JEditorPane editorPane;
    private JScrollPane pane1;
    
    public MarkDownReader(){
        
         content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(readmePath))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                content.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Parser parser = Parser.builder().build();
        Node document = parser.parse(content.toString());
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        contentHTML = renderer.render(document);
        
        editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        editorPane.setText(contentHTML);
        editorPane.setEditable(false);
        editorPane.setBackground(Color.WHITE);
        
        pane1 = new JScrollPane(editorPane);
        pane1.setPreferredSize(new Dimension(960, 690));
        pane1.setBackground(Color.WHITE);
        fixPanel(pane1);
    }
    
    /**
     * Returns the jscrollpanel with all the readme.md data on it.
     * @return 
     */
    public JScrollPane getREADME(){
        return pane1;
    }
    
    /**
     * Modifies the ScrollBar of the ScrollPanel
     * @param scroll 
     */
    private void fixPanel(JScrollPane scroll) {
        scroll.setVerticalScrollBar(new ScrollBarModified());
        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 30, 30));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(new Color(30, 30, 30));
        scroll.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60), 2));
    }
}

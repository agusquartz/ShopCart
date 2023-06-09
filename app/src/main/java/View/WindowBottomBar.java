
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author agustin
 */
public class WindowBottomBar extends JPanel{
    private JLabel labelVersion;
    private final int HEIGHT = 20;
    private int WINDOWWIDTH;
    
    public WindowBottomBar(Window window){
        WINDOWWIDTH = window.getWidth();
        setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(WINDOWWIDTH, HEIGHT));
        setBackground(Color.decode("#29323C"));
        
        labelVersion = new JLabel();
        labelVersion.setForeground(Color.WHITE);
        labelVersion.setText(" version 1.0"); 
        labelVersion.setFont(new Font("Monospaced", Font.PLAIN, 10));
        
        this.add(labelVersion, BorderLayout.LINE_START);
    }
    
}

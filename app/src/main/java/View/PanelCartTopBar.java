
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author agustin
 */
public class PanelCartTopBar extends JPanel{
    private JLabel labelTitle;
    private JLabel labelAvailableClients;
    private Font font;
    
    public PanelCartTopBar(Color color){
        this.setLayout(new BorderLayout(5, 5));
        this.setBackground(color);
        this.font = new Font(Font.SANS_SERIF, Font.PLAIN, 16);
        
        labelTitle = new JLabel("Cart");
        labelTitle.setFont(font);
        labelTitle.setForeground(Color.WHITE);
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        
        labelAvailableClients = new JLabel("Available Clients");
        labelAvailableClients.setPreferredSize(new Dimension(200, 20));
        labelAvailableClients.setFont(font);
        labelAvailableClients.setForeground(Color.WHITE);
        labelAvailableClients.setHorizontalAlignment(SwingConstants.CENTER);
        
        this.add(labelAvailableClients, BorderLayout.LINE_END);
        this.add(labelTitle, BorderLayout.CENTER);
    }
}

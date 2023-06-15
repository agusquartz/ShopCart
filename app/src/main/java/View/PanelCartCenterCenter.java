
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author agustin
 */
public class PanelCartCenterCenter extends JPanel{
    private GridBagConstraints gbc = new GridBagConstraints();
    private JTextField textFieldMovie;
    private JLabel labelText;
    private JLabel labelAdvice;
    private EventsHandler eventsHandler = EventsHandler.getInstance();
    
    public PanelCartCenterCenter(Color color){
        this.setLayout(new GridBagLayout());
        this.setBackground(color);
        
        gbc.insets = new Insets(10, 10, 10, 10);
        
        labelAdvice = new JLabel();
        labelAdvice.setForeground(Color.RED);
        
        labelText = new JLabel("You've selected");
        labelText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        labelText.setForeground(Color.WHITE);
        labelText.setHorizontalAlignment(SwingConstants.CENTER);
        
        textFieldMovie = new JTextField();
        textFieldMovie.setPreferredSize(new Dimension(250, 50));
        LineBorder lineBorder = new LineBorder(Color.WHITE, 2);
        TitledBorder border = BorderFactory.createTitledBorder(lineBorder, "Movie Name");
        border.setTitleJustification(TitledBorder.BELOW_TOP);
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font(Font.SERIF, Font.PLAIN, 10));
        
        textFieldMovie.setBorder(border);
        textFieldMovie.setBackground(color);
        textFieldMovie.setFont(new Font(Font.SERIF, Font.PLAIN, 14));
        textFieldMovie.setForeground(Color.WHITE);
        textFieldMovie.setEditable(false);
        textFieldMovie.setHorizontalAlignment(SwingConstants.CENTER);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(labelText, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(textFieldMovie, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(labelAdvice, gbc);
        
        eventsHandler.addSupplier("getAdviceLabel", () -> getAdviceLabel());
        eventsHandler.addSupplier("getCartTextField", () -> getCartTextField());
    }
    
    private JLabel getAdviceLabel(){
        return labelAdvice;
    }
    
    private JTextField getCartTextField(){
        return textFieldMovie;
    }
    
}

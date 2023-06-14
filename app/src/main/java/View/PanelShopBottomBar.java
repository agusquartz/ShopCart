
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author agustin
 */
public class PanelShopBottomBar extends JPanel{
    private ButtonSquare buttonRent;
    private ButtonSquare buttonAddMovie;
    private ButtonSquare buttonMoreInfo;
    private Dimension buttonDimension;
    private Dimension panelDimension;
    private EventsHandler eventsHandler;
    
    public PanelShopBottomBar(Color color, EventsHandler eventsHandler) {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        this.setBackground(color);
        this.panelDimension = new Dimension(1080, 40);
        this.buttonDimension = new Dimension(120, 30);
        this.setPreferredSize(panelDimension);
        this.eventsHandler = eventsHandler;
        
        buttonRent = new ButtonSquare(eventsHandler);
        buttonRent.setPreferredSize(buttonDimension);
        buttonRent.setText("Rent");
        
        buttonAddMovie = new ButtonSquare(eventsHandler);
        buttonAddMovie.setPreferredSize(buttonDimension);
        buttonAddMovie.setText("Add Movie");
        
        buttonMoreInfo = new ButtonSquare(eventsHandler);
        buttonMoreInfo.setPreferredSize(buttonDimension);
        buttonMoreInfo.setText("More Info");
        
        this.add(buttonMoreInfo);
        this.add(buttonAddMovie);
        this.add(buttonRent);
    }
    
}


package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author agustin
 */
public class LeftBar extends JPanel{
    private ImageAvatar userIcon;
    private ButtonSquare buttonShop;
    private ButtonSquare buttonCart;
    private ButtonSquare buttonSummary;
    private ButtonSquare buttonUsers;
    private ButtonSquare buttonSettings;
    private EventsHandler eventsHandler;
    
    public LeftBar(Color color, EventsHandler eventsHandler){
        this.setBounds(0, 20, 120, 700);
        this.setBackground(color);
        this.eventsHandler = eventsHandler;
        
        GridLayout layout = new GridLayout(12, 1);
        layout.setVgap(5);
        this.setLayout(layout);
        
        userIcon = new ImageAvatar();
        buttonShop = new ButtonSquare(eventsHandler);
        buttonCart = new ButtonSquare(eventsHandler);
        buttonSummary = new ButtonSquare(eventsHandler);
        buttonUsers = new ButtonSquare(eventsHandler);
        buttonSettings = new ButtonSquare(eventsHandler);
        
        userIcon.setPreferredSize(new Dimension(120, 120));
        buttonShop.setPreferredSize(new Dimension(120, 50));
        buttonCart.setPreferredSize(new Dimension(120, 50));
        buttonSummary.setPreferredSize(new Dimension(120, 50));
        buttonUsers.setPreferredSize(new Dimension(120, 50));
        buttonSettings.setPreferredSize(new Dimension(120, 50));
        
        buttonShop.setText("Shop");
        buttonCart.setText("Cart");
        buttonSummary.setText("Summary");
        buttonUsers.setText("Users");
        buttonSettings.setText("Settings");
       
        this.add(userIcon);
        this.add(buttonShop);
        this.add(buttonCart);
        this.add(buttonSummary);
        this.add(buttonUsers);
        this.add(buttonSettings);
    }
}

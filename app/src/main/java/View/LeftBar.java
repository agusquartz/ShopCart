
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
    private ButtonSquare buttonRentalPolicy;
    private ButtonSquare buttonSummary;
    private ButtonSquare buttonClients;
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
        buttonRentalPolicy = new ButtonSquare(eventsHandler);
        buttonSummary = new ButtonSquare(eventsHandler);
        buttonClients = new ButtonSquare(eventsHandler);
        buttonSettings = new ButtonSquare(eventsHandler);
        
        userIcon.setPreferredSize(new Dimension(120, 120));
        buttonShop.setPreferredSize(new Dimension(120, 50));
        buttonRentalPolicy.setPreferredSize(new Dimension(120, 50));
        buttonSummary.setPreferredSize(new Dimension(120, 50));
        buttonClients.setPreferredSize(new Dimension(120, 50));
        buttonSettings.setPreferredSize(new Dimension(120, 50));
        
        buttonShop.setText("Shop");
        buttonRentalPolicy.setText("Policy");
        buttonSummary.setText("Summary");
        buttonClients.setText("Clients");
        buttonSettings.setText("Settings");
       
        this.add(userIcon);
        this.add(buttonShop);
        this.add(buttonRentalPolicy);
        this.add(buttonSummary);
        this.add(buttonClients);
        this.add(buttonSettings);
    }
}

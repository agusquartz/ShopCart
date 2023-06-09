
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
    
    public LeftBar(Color color){
        this.setBounds(0, 20, 120, 700);
        this.setBackground(color);
        
        GridLayout layout = new GridLayout(12, 1);
        layout.setVgap(5);
        this.setLayout(layout);
        
        userIcon = new ImageAvatar();
        buttonShop = new ButtonSquare();
        buttonCart = new ButtonSquare();
        buttonSummary = new ButtonSquare();
        buttonUsers = new ButtonSquare();
        buttonSettings = new ButtonSquare();
        
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

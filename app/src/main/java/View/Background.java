
package View;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author agustin
 */
public class Background extends JPanel{
    private PanelShop panelShop;
    private PanelCart panelCart;
    private PanelSummary panelSummary;
    private PanelUsers panelUsers;
    private PanelSettings panelSettings;
    
    public Background(Color color){
        this.setLayout(new CardLayout());
        this.setBackground(color);
        
        panelShop = new PanelShop(color);
        panelShop.setBackground(Color.red);
        
        panelCart = new PanelCart();
        panelShop.setBackground(Color.blue);
        
        panelSummary = new PanelSummary();
        panelShop.setBackground(Color.yellow);
        
        panelUsers = new PanelUsers();
        panelShop.setBackground(Color.white);
        
        panelSettings = new PanelSettings();
        panelShop.setBackground(Color.black);
        
        this.add(panelShop, "panelShop");
        this.add(panelCart, "panelCart");
        this.add(panelSummary, "panelSummary");
        this.add(panelUsers, "panelUsers");
        this.add(panelSettings, "panelSettings");
    }
}

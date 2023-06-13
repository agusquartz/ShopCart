
package View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private PanelUserCreate panelUserCreate;
    private PanelUserEdit panelUserEdit;
    private EventsHandler eventsHandler = EventsHandler.getInstance();
    
    public Background(Color color){
        this.setLayout(new CardLayout());
        this.setBackground(color);
        
        panelShop = new PanelShop(color);
        
        panelCart = new PanelCart();
        
        panelSummary = new PanelSummary();
        
        panelUsers = new PanelUsers(color);
        
        panelSettings = new PanelSettings(color);
        
        panelUserCreate = new PanelUserCreate(new Color(204, 204, 204), EventsHandler.getInstance());
        
        panelUserEdit = new PanelUserEdit(new Color(204, 204, 204), EventsHandler.getInstance());
        
        this.add(panelShop, "panelShop");
        this.add(panelCart, "panelCart");
        this.add(panelSummary, "panelSummary");
        this.add(panelUsers, "panelUsers");
        this.add(panelSettings, "panelSettings");
        this.add(panelUserCreate, "panelUserCreate");
        this.add(panelUserEdit, "panelUserEdit");
        
        
        eventsHandler.addSupplier("getPanelUserEdit", () -> getPanelUserEdit());
    }
    
    private PanelUserEdit getPanelUserEdit(){
        return panelUserEdit;
    }
}

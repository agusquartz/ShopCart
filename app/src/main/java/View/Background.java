
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
    private PanelShopAddMovie panelShopAddMovie;
    private PanelPolicy panelPolicy;
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
        panelShopAddMovie = new PanelShopAddMovie("Add Movie", new Color(204, 204, 204));
        
        panelPolicy = new PanelPolicy();
        
        panelSummary = new PanelSummary(color);
        
        panelUsers = new PanelUsers(color);
        
        panelSettings = new PanelSettings(color);
        
        panelUserCreate = new PanelUserCreate(new Color(204, 204, 204), EventsHandler.getInstance());
        
        panelUserEdit = new PanelUserEdit(new Color(204, 204, 204), EventsHandler.getInstance());
        
        this.add(panelSettings, "panelSettings");
        this.add(panelShop, "panelShop");
        this.add(panelShopAddMovie, "panelAddMovie");
        this.add(panelPolicy, "panelPolicy");
        this.add(panelSummary, "panelSummary");
        this.add(panelUsers, "panelUsers");
        this.add(panelUserCreate, "panelUserCreate");
        this.add(panelUserEdit, "panelUserEdit");
        
        
        eventsHandler.addSupplier("getPanelUserEdit", () -> getPanelUserEdit());
        eventsHandler.addSupplier("getPanelUserCreate", () -> getPanelUserCreate());
    }
    
    /**
     * Returns the panel where you can edit a client's data
     * @return 
     */
    private PanelUserEdit getPanelUserEdit(){
        return panelUserEdit;
    }
    
    /**
     * Returns the panel where you can create a new user
     * @return 
     */
    private PanelUserCreate getPanelUserCreate(){
        return panelUserCreate;
    }
}

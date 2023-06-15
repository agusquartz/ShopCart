
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
    private PanelShopAddMovie panelShopAddMovie;
    private PanelMoreInfo panelMoreInfo;
    private PanelCart panelCart;
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
        panelMoreInfo = new PanelMoreInfo();
        panelCart = new PanelCart(color);
        
        panelPolicy = new PanelPolicy();
        
        panelSummary = new PanelSummary(color);
        
        panelUsers = new PanelUsers(color);
        
        panelSettings = new PanelSettings(color);
        
        panelUserCreate = new PanelUserCreate(new Color(204, 204, 204), EventsHandler.getInstance());
        
        panelUserEdit = new PanelUserEdit(new Color(204, 204, 204), EventsHandler.getInstance());
        
        this.add(panelSettings, "panelSettings");
        this.add(panelShop, "panelShop");
        this.add(panelShopAddMovie, "panelAddMovie");
        this.add(panelMoreInfo, "panelMoreInfo");
        this.add(panelCart, "panelCart");
        this.add(panelPolicy, "panelPolicy");
        this.add(panelSummary, "panelSummary");
        this.add(panelUsers, "panelUsers");
        this.add(panelUserCreate, "panelUserCreate");
        this.add(panelUserEdit, "panelUserEdit");
        
        
        eventsHandler.addSupplier("getPanelUserEdit", () -> getPanelUserEdit());
        eventsHandler.addSupplier("getPanelUserCreate", () -> getPanelUserCreate());
        eventsHandler.addSupplier("getPanelShopAddMovie", () -> getPanelShopAddMovie());
        eventsHandler.addSupplier("getPanelMoreInfo", () -> getPanelMoreInfo());
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
    
    /**
     * Returns the panel where you can add a new movie
     * @return 
     */
    private PanelShopAddMovie getPanelShopAddMovie(){
        return panelShopAddMovie;
    }
    
    private PanelMoreInfo getPanelMoreInfo(){
        return panelMoreInfo;
    }
}


package View;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author agustin
 */
public class PanelShop extends JPanel{
    private PanelShopUpBar panelShopUpBar;
    
    public PanelShop(Color color){
        this.setLayout(new BorderLayout());
        this.setBackground(color);
        
        panelShopUpBar = new PanelShopUpBar(this);
        add(panelShopUpBar, BorderLayout.PAGE_START);
    }
}

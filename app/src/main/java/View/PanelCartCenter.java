
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *  This is the center of the panel cart
 * @author agustin
 */
public class PanelCartCenter extends JPanel{
    private PanelCartCenterBottomBar panelCartBottomBar;
    private PanelCartCenterCenter panelCartCenterCenter;
    
    public PanelCartCenter(Color color){
        this.setBackground(color);
        this.setLayout(new BorderLayout());
        
        panelCartCenterCenter = new PanelCartCenterCenter(color);
        panelCartBottomBar = new PanelCartCenterBottomBar(color);
        
        this.add(panelCartBottomBar, BorderLayout.PAGE_END);
        this.add(panelCartCenterCenter, BorderLayout.CENTER);
    }
}

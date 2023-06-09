
package View;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author agustin
 */
public class PanelShopUpBar extends LayeredPanelRound{
    
    public PanelShopUpBar(JFrame frame) {
        super(frame);
        settings();
    }
    
    public PanelShopUpBar(JPanel panel) {
        super(panel);
        settings();
    }
    
    private void settings(){
        this.setBackground(Color.decode("#041E40"));
        this.setRoundBottomLeft(15);
        this.setRoundTopLeft(15);
        this.setRoundBottomRight(15);
        this.setRoundTopRight(15);
//        this.setPreferredSize(new Dimension(30, 30)); // Take size from panel and then with layeredpane build it
    }
    
}

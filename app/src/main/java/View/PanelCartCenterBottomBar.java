
package View;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author agustin
 */
public class PanelCartCenterBottomBar extends JPanel {
    private ButtonSquare buttonProceed;
    private EventsHandler eventsHandler = EventsHandler.getInstance();
    
    public PanelCartCenterBottomBar(Color color){
        this.setBackground(color);
        
        buttonProceed = new ButtonSquare(eventsHandler);
        buttonProceed.setText("Proceed");
        
        this.add(buttonProceed);
    }
}

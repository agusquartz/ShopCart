
package View;

import java.awt.Color;

/**
 *
 * @author agustin
 */
public class PanelUserEdit extends PanelUser{
    
    
    public PanelUserEdit(Color background, EventsHandler eventsHandler){
        super("Edit Client", background, eventsHandler);
        this.getButtonContinue().setText("Save");
    }
    
    
    
}

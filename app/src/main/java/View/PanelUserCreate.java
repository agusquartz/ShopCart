
package View;

import java.awt.Color;

/**
 *
 * @author agustin
 */
public class PanelUserCreate extends PanelUser{
    
    public PanelUserCreate(Color background, EventsHandler eventsHandler){
        super("Create User", background, eventsHandler);
        this.getButtonContinue().setText("Create");
    }
}

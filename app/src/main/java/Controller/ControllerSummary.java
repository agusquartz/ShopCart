
package Controller;

import Repository.Action;
import Repository.Client;
import Repository.Repository;
import View.EventsHandler;
import View.TableModified;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author agustin
 */
public class ControllerSummary {
    private final Repository REPOSITORY = Repository.getInstance();
    private EventsHandler eventsHandler = EventsHandler.getInstance();
    private DefaultTableModel mode;
    
    public ControllerSummary(){
        
    }
    
    /**
     * Clean the Clients Table and Add all the clients with their Data in it
     * @param table 
     */
    public void loadSummary(TableModified table){
        HashMap<String, ArrayList<Action>> actions = REPOSITORY.getActions();
        mode = (DefaultTableModel) table.getModel();
        mode.setRowCount(0);
        actions.forEach((key, value) -> {
            value.forEach(e -> {
                mode.addRow(new Object[]{
                    key, e.isAvailable(), e.getName(), e.getPrice(),
                    e.getRentedDate(), e.getReturnedDate()
                });
            });
        });
    }
    
}

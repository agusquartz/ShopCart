
package Controller;

import Repository.Action;
import java.time.LocalDate;
import Repository.Repository;
import View.EventsHandler;
import View.TableModified;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *This class contains the control of rents, as save,load, modify  and calculate the money earned.
 * @author agustin
 */
public class ControllerSummary {
    private final Repository REPOSITORY = Repository.getInstance();
    private EventsHandler eventsHandler = EventsHandler.getInstance();
    private DefaultTableModel mode;
    private static int moneyCounter;
    private ControllerMovies controllerMovies;
    private ControllerClient controllerClient;
    
    /**
     * Main Constructor
     */
    public ControllerSummary(){
        controllerClient = new ControllerClient();
        controllerMovies = new ControllerMovies();
    }
    
    /**
     * Save the summary data to local (JSON format)
     */
    public void saveSummary(){
        REPOSITORY.saveActions();
    }
    
    /**
     * Clean the Clients Table and Add all the clients with their Data in it
     * @param table  the table where data is load.
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
    
    /**
     * Modifies the status of the product to available, the client can rent again
     * and the returned date is saved to the summary
     * @param clientID client's ID number
     * @param movieName movie's name
     */
    public void modifyStatus(String clientID, String movieName){
        HashMap<String, ArrayList<Action>> actions = REPOSITORY.getActions();
        actions.get(clientID).forEach(action -> {
            if(action.getName().equals(movieName) && !(action.isAvailable())){
                action.setAvailable(true);
                action.setReturnedDate(DateTimeFormatter.ofPattern("dd-MM-YYYY").format(LocalDate.now()));
                controllerMovies.searchMovie(movieName).setAvailable(true);
                controllerClient.searchClient(clientID).setCanRent(true);
            }
        });
    }
    
    /**
     * Returns the total money earned until now
     * @return int 
     */
    public int getTotalMoney(){
        HashMap<String, ArrayList<Action>> actions = REPOSITORY.getActions();
        moneyCounter = 0;
        actions.forEach((key, value) -> {
            value.forEach(e -> {
                moneyCounter += Integer.parseInt(e.getPrice());
            });
        });
        return moneyCounter;
    }
    
}


package Controller;

import Repository.Client;
import Repository.Repository;
import View.EventsHandler;
import View.PanelUserCreate;
import View.PanelUserEdit;
import View.TableModified;
import java.util.TreeMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author agustin
 */
public class ControllerClient {
    private final Repository REPOSITORY = Repository.getInstance();
    private EventsHandler eventsHandler = EventsHandler.getInstance();
    private DefaultTableModel mode;
    
    public ControllerClient(){
    }
    
    /**
     * Search and returns a client
     * @param idNumber
     * @return 
     */
    public Client searchClient(String idNumber){
        return this.REPOSITORY.getClients().get(idNumber);
    }
    
    /**
     * Returns how many clients there are in the system
     * @return 
     */
    public int amountOfClients(){
        return this.REPOSITORY.getClients().size();
    }
    
    /**
     * Edit a client's data
     * @param panel 
     */
    public void editClient(PanelUserEdit panel){
        Client client = REPOSITORY.searchClient(panel.getIDNumber());
        client.setAge(panel.getAge());
        client.setEmail(panel.getEmail());
        client.setPhoneNumber(panel.getPhone());
        client.setCity(panel.getCity());
        client.setName(panel.getName());
        client.setSurname(panel.getSurname());
    }
    
    /**
     * Creates a new client
     * @param panel 
     */
    public void createClient(PanelUserCreate panel){
        Client client = new Client(panel.getIDNumber(), panel.getName(),
                panel.getSurname(),  panel.getAge(), panel.getEmail(),
                panel.getPhone(), panel.getCity());
        REPOSITORY.getClients().put(panel.getIDNumber(), client);
    }
    
    /**
     * Removes a client from the system
     * @param idNumber 
     */
    public void deleteClient(String idNumber){
        REPOSITORY.getClients().remove(idNumber);
    }
    
    /**
     * Save the clients data to local (JSON format)
     */
    public void save(){
        REPOSITORY.saveClients();
    }
    
    /**
     * Clean the Clients Table and Add all the clients with their Data in it
     * @param table 
     */
    public void loadClients(TableModified table){
        TreeMap<String, Client> clients = REPOSITORY.getClients();
        mode = (DefaultTableModel) table.getModel();
        mode.setRowCount(0);
        clients.forEach((key, value) -> {
            mode.addRow(new Object[]{
                key, value.getName(), value.getSurname(), value.getAge(),
                value.getPhoneNumber(), value.getEmail(), value.getCity(),
                value.isCanRent()
            });
        });
    }
    
}


package View;

import Controller.ControllerClient;
import Repository.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.function.Supplier;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author agustin
 */
public class EventsHandler implements ActionListener{
    
    private HashMap<String, Runnable> methods;
    private HashMap<String, Supplier<Object>> supplier;
    private static EventsHandler instance;
    private ControllerClient controllerClient;
    
    private EventsHandler(){
        methods = new HashMap();
        supplier = new HashMap();
        controllerClient = new ControllerClient();
    }
    
    static{
        try {
            instance = new EventsHandler();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating JSONMovies singleton instance");
        }
    }

    public static EventsHandler getInstance(){
        return instance;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String eventSource = ((JButton)e.getSource()).getText();
        
        switch(eventSource){
            case "X":
                controllerClient.save();
                System.exit(0);
                break;
            case "Shop":
                methods.get("showPanelShop").run();
                break;
            case "Cart":
                methods.get("showPanelCart").run();
                break;
            case "Summary":
                methods.get("showPanelSummary").run();
                break;
            case "Users":
                TableModified tableUsers = (TableModified)supplier.get("getClientsTable").get();
                refreshTableUsers(tableUsers);
                break;
            case "Settings":
                methods.get("showPanelSettings").run();
                break;
            case "Add":
                methods.get("showPanelUserCreate").run();
                break;
            case "Edit":
                TableModified tableUsers2 = (TableModified)supplier.get("getClientsTable").get();
                PanelUserEdit panelUserEdit = (PanelUserEdit)supplier.get("getPanelUserEdit").get();
                DefaultTableModel model = (DefaultTableModel) tableUsers2.getModel();
                String clientID = (String) model.getValueAt(tableUsers2.getSelectedRow(), 0);
                updatePanelUserEdit(panelUserEdit, controllerClient.searchClient(clientID));
                methods.get("showPanelUserEdit").run();
                break;
            case "Delete":
                TableModified tableUsers3 = (TableModified)supplier.get("getClientsTable").get();
                DefaultTableModel model1 = (DefaultTableModel) tableUsers3.getModel();
                String clientID1 = (String) model1.getValueAt(tableUsers3.getSelectedRow(), 0);
                System.out.println(controllerClient.searchClient(clientID1));
                controllerClient.deleteClient(clientID1);
                refreshTableUsers(tableUsers3);
                break;
            case "Save":
                PanelUserEdit panelUserEdit1 = (PanelUserEdit)supplier.get("getPanelUserEdit").get();
                controllerClient.editClient(panelUserEdit1);
                methods.get("showPanelUsers").run();
                break;
            case "Cancel":
                methods.get("showPanelUsers").run();
                break;
        }
    }
    
    
    public void addMethods(String name, Runnable method){
        methods.put(name, method);
    }
    
    public void addSupplier(String name, Supplier<Object> metodo){
        supplier.put(name, metodo);
    }
    
    private void refreshTableUsers(TableModified table){
        controllerClient.loadClients(table);
        methods.get("showPanelUsers").run();
    }
    
    private void updatePanelUserEdit(PanelUserEdit panel, Client client){
        panel.setIDNumber(client.getIdNumber());
        panel.setName(client.getName());
        panel.setSurname(client.getSurname());
        panel.setAge(client.getAge());
        panel.setEmail(client.getEmail());
        panel.setPhone(client.getPhoneNumber());
        panel.setCity(client.getCity());
    }
}

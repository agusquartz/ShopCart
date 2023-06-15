
package View;

import Controller.ControllerClient;
import Controller.ControllerMovies;
import Controller.ControllerSummary;
import Repository.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.function.Supplier;
import javax.swing.JButton;
import javax.swing.JLabel;
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
    private ControllerSummary controllerSummary;
    private ControllerMovies controllerMovies;
    
    private EventsHandler(){
        methods = new HashMap();
        supplier = new HashMap();
        controllerClient = new ControllerClient();
        controllerSummary = new ControllerSummary();
        controllerMovies = new ControllerMovies();
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
                controllerMovies.saveMovies();
                controllerSummary.saveSummary();
                System.exit(0);
                break;
            case "Shop":
                refreshTableShop((TableModified)supplier.get("getShopTable").get());
                break;
            case "Add Movie":
                methods.get("showPanelAddMovie").run();
                break;
            case "Back":
                refreshTableShop((TableModified)supplier.get("getShopTable").get());
                break;
            case "Add New":
                PanelShopAddMovie panelShopAddMovie = (PanelShopAddMovie)supplier.get("getPanelShopAddMovie").get();
                controllerMovies.createNewMovie(panelShopAddMovie);
                refreshTableShop((TableModified)supplier.get("getShopTable").get());
                break;
            case "Policy":
                methods.get("showPanelPolicy").run();
                break;
            case "Summary":
                refreshTableSummary((TableModified)supplier.get("getSummaryTable").get());
                ((JLabel)supplier.get("getLabelMoney").get()).setText("Total: $" + controllerSummary.getTotalMoney());
                break;
            case "Return":
                TableModified tableSummary = (TableModified)supplier.get("getSummaryTable").get();
                DefaultTableModel modelSummary = (DefaultTableModel)tableSummary.getModel();
                if((modelSummary.getValueAt(tableSummary.getSelectedRow(), 1).toString()).equals("false")){
                    controllerSummary.modifyStatus(
                            modelSummary.getValueAt(
                                tableSummary.getSelectedRow(), 0).toString(),
                            modelSummary.getValueAt(
                                tableSummary.getSelectedRow(), 2).toString());
                }
                refreshTableSummary(tableSummary);
                break;
            case "Clients":
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
                refreshTableUsers((TableModified)supplier.get("getClientsTable").get());
                break;
            case "Create":
                PanelUserCreate panelUserCreate = (PanelUserCreate)supplier.get("getPanelUserCreate").get();
                if(!(panelUserCreate.getIDNumber().equals("") || panelUserCreate.getIDNumber().equals(" "))){
                    controllerClient.createClient(panelUserCreate);
                }
                refreshTableUsers((TableModified)supplier.get("getClientsTable").get());
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
    
    private void refreshTableShop(TableModified table){
        controllerMovies.loadMovies(table);
        methods.get("showPanelShop").run();
    }
    
    private void refreshTableUsers(TableModified table){
        controllerClient.loadClients(table);
        methods.get("showPanelUsers").run();
    }
    
    private void refreshTableSummary(TableModified table){
        controllerSummary.loadSummary(table);
        methods.get("showPanelSummary").run();
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

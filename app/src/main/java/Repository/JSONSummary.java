
package Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import org.json.simple.JSONObject;

/**
 *This class is Read and write System of Summary
 * @author agustin
 */
public class JSONSummary extends JSONBase {
    private HashMap<String, ArrayList<Action>> actions;
    private static JSONSummary instance;
    private static int counter = 0;
    private ArrayList<Action> actionList;
    
    private JSONSummary(){
        super("summary.json");
    }

    // Static block initialization implementation of singleton design pattern
    static{
        try {
            instance = new JSONSummary();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating JSONSummary singleton instance");
        }
    }
    /**
     *  Returns one and unique instance of the class
     * @return instance
     */
    public static JSONSummary getInstance(){
        return instance;
    }
    /**
     * Load the Summary in the repository
     * @param actions the TreeMap where new actions are gonna be stored.
     * @param jsonSummary the manager of the summary.JSON file.
     */
    public void loadActions(HashMap actions, JSONSummary jsonSummary){
        JSONObject jsonObject = jsonSummary.getJsonObject();
        this.actions = actions;
        actionList = new ArrayList();
        ArrayList<String> rentedByList = new ArrayList();
        
        jsonObject.values().forEach(e -> {
            JSONObject object = (JSONObject)e;
            String name = object.get("name").toString();
            String price = object.get("price").toString();
            String rentedBy = object.get("rentedBy").toString();
            String rentedDate = object.get("rentedDate").toString();
            String returnedDate = object.get("returnedDate").toString();
            String available = object.get("available").toString();
            
            actionList.add(new Action(name, price, rentedBy, rentedDate, returnedDate, available));
            rentedByList.add(rentedBy);
        });
        HashSet<String> set = new HashSet(rentedByList); // Delete reapited
        
        set.forEach(e -> actions.put(e, new ArrayList<>())); // Create actions by users
        
        actionList.forEach(e -> ( (ArrayList)actions.get( ((Action) e).getRentedBy() ) ).add(e) );
    }
    /**
     * Configure the clients and movies from repository according to the summary file
     * @param clients clients list from repository
     * @param movies  movies list from repository
     */
    public void config(TreeMap<String, Client> clients, HashMap<String, Movie> movies){
        actionList.forEach(e -> {
            if(!(e.isAvailable())){
                clients.get(e.getRentedBy()).setCanRent(false);
                movies.get(e.getName()).setAvailable(false);
            }
        });
    }
    
    @Override
    /**
     * Save the clients in Summary.JSON file
     */
    public void saveToJSONFile() {
        HashMap<String, HashMap<String, String>> map = new HashMap();
        
        actions.forEach((key, value) -> {
            value.forEach(e -> {
                map.put((String.valueOf(counter++)), (((Action)e).toHashMap()));
            });
        });
        
        JSONObject jsonObject = new JSONObject(map);
        
        try (FileWriter fileWriter = new FileWriter(this.REPOSITORYPATH + this.FILENAME)) {
            fileWriter.write(jsonObject.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
}


package Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;
import org.json.simple.JSONObject;

/**
 *This class is Read and write System of clients
 * @author agustin
 */
public class JSONClients extends JSONBase{
    private TreeMap clients;
    private static JSONClients instance;
    
    private JSONClients(){
        super("clients.json");
    }
    
    // Static block initialization implementation of singleton design pattern
    static{
        try {
            instance = new JSONClients();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating JSONUsers singleton instance");
        }
    }
    /**
     *  Returns one and unique instance of the class
     * @return instance
     */
    public static JSONClients getInstance(){
        return instance;
    }
    /**
     * Load the clients in the repository
     * @param clients the TreeMap where new clients are gonna be stored
     * @param jsonClients the manager of the client.JSON file
     */
    public void loadClients(TreeMap clients, JSONClients jsonClients){
        JSONObject jsonObject = jsonClients.getJsonObject();
        this.clients = clients;
        
        jsonObject.values().forEach(e -> {
            JSONObject client = (JSONObject)e;
            String idNumber = client.get("idNumber").toString();
            String name = client.get("name").toString();
            String surname = client.get("surname").toString();
            String age = client.get("age").toString();
            String email = client.get("email").toString();
            String phoneNumber = client.get("phoneNumber").toString();
            String city = client.get("city").toString();
            
            
            clients.put(idNumber, new Client(
                    idNumber, name, surname, age, email, phoneNumber, city)
            );            
        });
    }

    @Override
    /**
     * Save the clients in Client.JSON file
     */
    public void saveToJSONFile() {
        HashMap<String, HashMap<String, String>> map = new HashMap();
        
        clients.forEach((key, value) -> {
            map.put((((Client)value).getIdNumber()), (((Client)value).toHashMap()));
        });
        
        JSONObject jsonObject = new JSONObject(map);
        
        try (FileWriter fileWriter = new FileWriter(this.REPOSITORYPATH + this.FILENAME)) {
            fileWriter.write(jsonObject.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}

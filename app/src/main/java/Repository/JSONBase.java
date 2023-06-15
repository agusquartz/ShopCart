
package Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class is the JSON base Systems.
 * @author agustin
 */
public abstract class JSONBase {
    protected final static String REPOSITORYPATH = System.getProperty("user.dir") + File.separator + "repository" + File.separator;
    protected final String FILENAME;
    private JSONParser jsonParser;
    private FileReader fileReader;
    private Object object;
    private JSONObject jsonObject;
    
    
    /**
     * Main Constructor
     * @param fileName name of the file
     */
    protected JSONBase(String fileName){
        this.FILENAME = fileName;
        this.jsonParser = new JSONParser();
        this.object = null;
        this.jsonObject = null;
        loadFromJSONFile();
    }

    public String getFILENAME() {
        return FILENAME;
    }
    
    public JSONObject getJsonObject() {       
        return jsonObject;
    }
    
    public abstract void saveToJSONFile();
    
    /**
     * Read the JSON file and convert it to JSON OBJECT.
     */
    private void loadFromJSONFile(){
        try {
            fileReader = new FileReader(REPOSITORYPATH + FILENAME);
            object = jsonParser.parse(fileReader);
            jsonObject = (JSONObject) object;
            
        } catch (FileNotFoundException | ParseException ex) {
            Logger.getLogger(JSONBase.class.getName()).log(Level.SEVERE, "File not found or parsing error from " + FILENAME, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSONBase.class.getName()).log(Level.SEVERE, "Other error", ex);
        } finally{
            try {
                fileReader.close();
            } catch (IOException ex) {
                Logger.getLogger(JSONBase.class.getName()).log(Level.SEVERE, "File isn't open", ex);
            }
        }
    }
    
}

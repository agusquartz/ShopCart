
package Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import org.json.simple.JSONObject;

/**
 *
 * @author agustin
 */
public class JSONMovies extends JSONBase{
    private HashMap movies;
    private static JSONMovies instance;
    
    private JSONMovies(){
        super("movies.json");
    }

    // Static block initialization implementation of singleton design pattern
    static{
        try {
            instance = new JSONMovies();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating JSONMovies singleton instance");
        }
    }
    
    public static JSONMovies getInstance(){
        return instance;
    }
    
    public void loadMovies(HashMap movies, JSONMovies jsonMovies){
        JSONObject jsonObject = jsonMovies.getJsonObject();
        this.movies = movies;
        
        jsonObject.values().forEach(e -> {
            JSONObject movie = (JSONObject)e;
            String name = movie.get("name").toString();
            String releaseYear = movie.get("releaseYear").toString();
            String director = movie.get("director").toString();
            String genre = movie.get("genre").toString();
            String description = movie.get("description").toString();
            String price = movie.get("price").toString();
            String photoName = movie.get("photoName").toString();
            
            
            movies.put(name, new Movie(name, releaseYear, director, genre,
                    description, price, photoName)
            );            
        });
    }
    
    @Override
    public void saveToJSONFile() {
        HashMap<String, HashMap<String, String>> map = new HashMap();
        
        movies.forEach((key, value) -> {
            map.put((((Movie)value).getName()), (((Movie)value).toHashMap()));
        });
        
        JSONObject jsonObject = new JSONObject(map);
        
        try (FileWriter fileWriter = new FileWriter(this.REPOSITORYPATH + this.FILENAME)) {
            fileWriter.write(jsonObject.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
}


package Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import org.json.simple.JSONObject;

/**
 *This class is Read and write System of Movies
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
    /**
     *  Returns one and unique instance of the class
     * @return instance
     */
    public static JSONMovies getInstance(){
        return instance;
    }
    /**
     * Load the movies in the repository
     * @param movies the TreeMap where new clients are gonna be stored.
     * @param jsonMovies the manager of the movies.JSON file.
     */
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
    /**
     * Save the clients in Movie.JSON file
     */
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

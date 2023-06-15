
package Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 *This class is the place where all data is stored.
 * @author agustin
 */
public class Repository {
    private static Repository instance;
    
    private JSONClients jsonClients;
    private JSONMovies jsonMovies;
    private JSONSummary jsonSummary;
    private TreeMap<String, Client> clients;
    private HashMap<String, Movie> movies;
    private HashMap<String, ArrayList<Action>> actions;
    
    /**
     *Main Constructor  
     */
    private Repository(){
        this.jsonClients = JSONClients.getInstance();
        this.jsonMovies = JSONMovies.getInstance();
        this.jsonSummary = JSONSummary.getInstance();
        this.clients = new TreeMap();
        this.movies = new HashMap();
        this.actions = new HashMap();
        
        jsonClients.loadClients(this.clients, this.jsonClients);
        jsonMovies.loadMovies(this.movies, this.jsonMovies);
        jsonSummary.loadActions(this.actions, jsonSummary);
        jsonSummary.config(this.clients, this.movies);
    }
    
    // Static block initialization implementation of singleton design pattern
    static{
        try {
            instance = new Repository();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating Repository singleton instance");
        }
    }
    
    public static Repository getInstance(){
        return instance;
    }
    

    public HashMap<String, ArrayList<Action>> getActions() {
        return actions;
    }
    
    public TreeMap<String, Client> getClients(){
        return this.clients;
    }

    public HashMap<String, Movie> getMovies() {
        return movies;
    }
    
    public Movie searchMovie(String name){
        return this.movies.get(name);
    }
    
    public Client searchClient(String idNumber){
        return this.clients.get(idNumber);
    }
    
    public Repository saveClients(){
        jsonClients.saveToJSONFile();
        return this;
    }
    
    public Repository saveMovies(){
        jsonMovies.saveToJSONFile();
        return this;
    }
    
    public Repository saveActions(){
        jsonSummary.saveToJSONFile();
        return this;
    }
}

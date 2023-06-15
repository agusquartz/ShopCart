
package Controller;

import Repository.Movie;
import Repository.Repository;
import View.EventsHandler;
import View.TableModified;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *This class contains the control of movies, as search,amount,save and load 
 * @author agustin
 */
public class ControllerMovies {
    private final Repository REPOSITORY = Repository.getInstance();
    private EventsHandler eventsHandler = EventsHandler.getInstance();
    private DefaultTableModel mode;
    
    /**
     * Main Constructor
     */
    public ControllerMovies(){
        
    }
    
    /**
     * This method search movies with .
     * @param idNumber
     * @return 
     */
    public Movie searchMovie(String idNumber){
        return this.REPOSITORY.getMovies().get(idNumber);
    }
    
    /**
     * 
     * @return 
     */
    public int amountOfMovies(){
        return this.REPOSITORY.getMovies().size();
    }
    
    /**
     * Save the movies data to local (JSON format)
     */
    public void saveMovies(){
        REPOSITORY.saveMovies();
    }
    
    /**
     * Clean the Clients Table and Add all the clients with their Data in it
     * @param table table  the table where data is load.
     */
    public void loadMovies(TableModified table){
        HashMap<String, Movie> movies = REPOSITORY.getMovies();
        mode = (DefaultTableModel) table.getModel();
        mode.setRowCount(0);
        
        movies.forEach((key, value) -> {
            if(value.isAvailable()){
                mode.addRow(new Object[]{
                    value.getName(), value.getPrice(), value.getDirector(),
                    value.getGenre(), value.getReleaseYear()
                });
            }
        });
    }
}

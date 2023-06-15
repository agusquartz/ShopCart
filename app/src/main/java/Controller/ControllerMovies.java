
package Controller;

import Repository.Movie;
import Repository.Repository;
import View.EventsHandler;
import View.PanelMoreInfo;
import View.PanelShopAddMovie;
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
     * This method creates a new movie and add it in the repository
     * @param panel The panel where the data is obtained
     */
    public void createNewMovie(PanelShopAddMovie panel){
        Movie movie = new Movie(panel.getTextFieldName(), panel.getTextFieldReleaseYear()
        , panel.getTextFieldDirector(), panel.getTextFieldGenre(), panel.getTextFieldDescription()
        , panel.getTextFieldPrice(), "");
        REPOSITORY.getMovies().put(movie.getName(), movie);
    }
    
    /**
     * This method search a movie with it's Name
     * @param movieName Name of the movie 
     * @return Movie 
     */
    public Movie searchMovie(String movieName){
        return this.REPOSITORY.getMovies().get(movieName);
    }
    
    /**
     * This method returns how many movies are in the system.
     * @return int
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
    
    public void showMovieInfo(PanelMoreInfo panel, String movieName){
        panel.showData(REPOSITORY.searchMovie(movieName));
    }
}


package Repository;

import java.util.HashMap;


/**
 *This class represent a movie product
 * @author agustin
 */
public class Movie implements Comparable<Movie>{
    private String name;
    private String releaseYear;
    private String director;
    private String genre;
    private String description;
    private String price;
    private String photoName;
    private boolean available;
    
    
    /**
     * Constructor with less parameter
     * @param name movie's name
     * @param releaseYear movie's release
     * @param director movie's director
     * @param genre movie's genre
     * @param price movie's  price
     */
    public Movie(String name, String releaseYear, String director,
            String genre, String price){
        this(name, releaseYear, director, genre, "", price, "");
    }
    
    /**
     *  Main Constructor
     * @param name movie's name
     * @param releaseYear movie's release 
     * @param director movie's director
     * @param genre movie's genre
     * @param description movie's description
     * @param price movie's  price
     * @param photoName movie's photo name 
     */
    public Movie(String name, String releaseYear, String director,
            String genre, String description, String price, String photoName){
        this.name = name;
        this.releaseYear = releaseYear;
        this.director = director;
        this.genre = genre;
        this.description = description;
        this.price = price;
        this.photoName = photoName;
        this.available = true;
    }

    public Movie setName(String name) {
        this.name = name;
        return this;
    }

    public Movie setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public Movie setDirector(String director) {
        this.director = director;
        return this;
    }

    public Movie setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public Movie setDescription(String description) {
        this.description = description;
        return this;
    }

    public Movie setPrice(String price) {
        this.price = price;
        return this;
    }

    public Movie setPhotoName(String photoName) {
        this.photoName = photoName;
        return this;
    }

    public Movie setAvailable(boolean available) {
        this.available = available;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getPhotoName() {
        return photoName;
    }

    public boolean isAvailable() {
        return available;
    }
    /**
     * This method convert movie's  data that are gonna be saved in hashMap 
     * @return 
     */
    public HashMap toHashMap(){
        return new HashMap<String, String>(){{
            put("name", name);
            put("releaseYear", releaseYear);
            put("director", director);
            put("genre", genre);
            put("description", description);
            put("price", price);
            put("photoName", photoName);            
        }};
    }

    @Override
    /**
     * Compare movies by their names
     */
    public int compareTo(Movie otherMovie) {
        return this.getName().compareTo(otherMovie.getName());
    }

    @Override
    public String toString() {
        return "Movie{" + "name=" + name + ", releaseYear=" + releaseYear + ", director=" + director + ", genre=" + genre + ", description=" + description + ", price=" + price + ", photoName=" + photoName + ", available=" + available + '}';
    }
    
    
}

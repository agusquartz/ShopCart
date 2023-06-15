
package Repository;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * This class represents the action of rent movies
 * @author agustin
 */
public class Action {
    private Client client;
    private Movie movie;
    
    private String name;
    private String price;
    private String rentedBy;
    private String rentedDate;
    private String returnedDate;
    private boolean available;
    
    /**
     * Constructor with less parameter
     * @param client client who rents a product
     * @param movie  movie that's being renter
     * @param priceEvent a modification off the price
     */
    public Action(Client client, Movie movie, int priceEvent){
        this.client = client;
        this.movie = movie;
        this.name = movie.getName();
        this.price = String.valueOf((Integer.parseInt(movie.getPrice()) + priceEvent));
        this.rentedBy = client.getIdNumber();
        this.rentedDate = LocalDate.now().toString();
        this.returnedDate = "";
        this.available = false;
        
        this.movie.setAvailable(available);
    }
    
    /**
     * Main Constructor
     * @param name movie's name
     * @param price rent's price
     * @param rentedBy Client'S ID
     * @param rentedDate Date of the rent
     * @param returnedDate Movie return date
     * @param available Movie available 
     */
    public Action(String name, String price, String rentedBy, String rentedDate, String returnedDate, String available){
        this.name = name;
        this.price = price;
        this.rentedBy = rentedBy;
        this.rentedDate = rentedDate;
        this.returnedDate = returnedDate;
        
        if(available.equals("true")) this.available = true;
        else this.available = false;
    }

    public Client getClient() {
        return client;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getRentedBy() {
        return rentedBy;
    }

    public String getRentedDate() {
        return rentedDate;
    }

    public String getReturnedDate() {
        return returnedDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setRentedDate(String rentedDate) {
        this.rentedDate = rentedDate;
    }

    public void setReturnedDate(String returnedDate) {
        this.returnedDate = returnedDate;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    /**
     * This method convert rent's data that are gonna be saved in hashMap 
     * @return HashMap
     */
    public HashMap<String, String> toHashMap(){
        return new HashMap<String, String>(){{
            put("name", name);
            put("price", price);
            put("rentedBy", rentedBy);
            put("rentedDate", rentedDate);
            put("returnedDate", returnedDate);
            put("available", isAvailableString());            
        }};
    }

    @Override
    public String toString() {
        return "Action{" + ", name=" + name + ", price=" + price + ", rentedBy=" + rentedBy + ", rentedDate=" + rentedDate + ", returnedDate=" + returnedDate + ", available=" + available + '}';
    }
    /**
     *This method converts isAvailable to String
     * @return String
     */
    private String isAvailableString(){
        if(isAvailable()) return "true";
        else return "false";
    }
    
    
}


package Repository;

import java.time.LocalDate;
import java.util.HashMap;

/**
 *
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
    
    private String isAvailableString(){
        if(isAvailable()) return "true";
        else return "false";
    }
    
    
}

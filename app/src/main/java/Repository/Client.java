
package Repository;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *This class represent a person who buys from shop
 * @author agustin
 */
public class Client implements Comparable<Client>{
    private boolean canRent;
    private String name;
    private String surname;
    private String email;
    private String age;
    private String phoneNumber;
    private String city;
    private final String IDNUMBER;
    
    /**
     * Constructor with less parameter
     * @param idNumber Client's ID Number 
     * @param name Client's name
     * @param surname Client's Surname
     * @param age Client's age
     * @param email Client's email
     */
    public Client(String idNumber, String name, String surname, String age, String email){
        this(idNumber, name, surname, age, email, "", "");
    }
    /**
     * Main Constructor
     * @param idNumber Client's ID Number 
     * @param name Client's name
     * @param surname Client's Surname
     * @param age Client's age
     * @param email Client's email
     * @param phoneNumber Client's phoneNumber
     * @param city  Client's city
     */
    public Client(String idNumber, String name, String surname, String age, String email, String phoneNumber, String city){
        this.IDNUMBER = idNumber;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.canRent = true;
    }

    /**
     * This Boolean method returns if a client can rent a movie again
     * @return Boolean
     */
    public boolean isCanRent() {
        return canRent;
    }

    /**
     * 
     * @param canRent 
     * @return Client 
     */
    public Client setCanRent(boolean canRent) {
        this.canRent = canRent;
        return this;
    }

    public Client setName(String name) {
        this.name = name;
        return this;
    }

    public Client setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Client setEmail(String email) {
        this.email = email;
        return this;
    }

    public Client setAge(String age) {
        this.age = age;
        return this;
    }

    public Client setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Client setCity(String city) {
        this.city = city;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getIdNumber() {
        return IDNUMBER;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCity() {
        return city;
    }
    
    /**
     * This method convert client's  data that are gonna be saved in hashMap 
     * @return 
     */
    public HashMap toHashMap(){
        return new HashMap<String, String>(){{
            put("name", name);
            put("surname", surname);
            put("email", email);
            put("age", age);
            put("idNumber", IDNUMBER);
            put("phoneNumber", phoneNumber);
            put("city", city);            
        }};
    }

    @Override
    public String toString() {
        return "Client{" + "canRent=" + canRent + ", name=" + name + ", surname=" + surname + ", email=" + email + ", age=" + age + ", phoneNumber=" + phoneNumber + ", city=" + city + ", IDNUMBER=" + IDNUMBER + '}';
    }

    
    @Override
    /**
     * Compare client by their ID number.
     */
    public int compareTo(Client otherClient) {
        return this.getIdNumber().compareTo(otherClient.getIdNumber());
    }
    
}

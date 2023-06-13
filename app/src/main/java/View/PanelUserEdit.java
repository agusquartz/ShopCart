
package View;

import java.awt.Color;
import java.awt.event.ActionListener;

/**
 *
 * @author agustin
 */
public class PanelUserEdit extends PanelUser{
    
    
    public PanelUserEdit(Color background, EventsHandler eventsHandler){
        super("Edit User", background, eventsHandler);
        this.getButtonContinue().setText("Save");
    }
    
    public void setName(String name){
        this.getTextFieldName().setText(name);
    }
    
    public void setSurname(String surname){
        this.getTextFieldSurname().setText(surname);
    }
    
    public void setIDNumber(String idNumber){
        this.getTextFieldIDCard().setText(idNumber);
        this.getTextFieldIDCard().setEditable(false);
    }
    public void setEmail(String email){
        this.getTextFieldEmail().setText(email);
    }
    public void setAge(String age){
        this.getTextFieldAge().setText(age);
    }
    
    public void setPhone(String phone){
        this.getTextFieldPhone().setText(phone);
    }
    
    public void setCity(String city){
        this.getTextFieldCity().setText(city);
    }
    
    
    public String getName(){
        return this.getTextFieldName().getText();
    }
    
    public String getSurname(){
        return this.getTextFieldSurname().getText();
    }
    
    public String getIDNumber(){
        return this.getTextFieldIDCard().getText();
    }
    public String getEmail(){
        return this.getTextFieldEmail().getText();
    }
    public String getAge(){
        return this.getTextFieldAge().getText();
    }
    
    public String getPhone(){
        return this.getTextFieldPhone().getText();
    }
    
    public String getCity(){
        return this.getTextFieldCity().getText();
    }
    
}

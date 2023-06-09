
package View;

import java.awt.Color;

/**
 *
 * @author agustin
 */
public class PanelUserEdit extends PanelUser{
    
    public PanelUserEdit(Color background){
        super("Edit User", background);
    }
    
    public void setName(String name){
        this.getTextFieldName().setText(name);
    }
    
    public void setSurname(String surname){
        this.getTextFieldSurname().setText(surname);
    }
    
    public void setIDNumber(String idNumber){
        this.getTextFieldIDCard().setText(idNumber);
    }
    
    public void setPhone(String phone){
        this.getTextFieldPhone().setText(phone);
    }
    
    public void setCity(String city){
        this.getTextFieldCity().setText(city);
    }
    
}

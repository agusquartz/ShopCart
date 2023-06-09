
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author agustin
 */
public class EventsHandler implements ActionListener{
    
    public EventsHandler(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String eventSource = ((JButton)e.getSource()).getText();
        
        switch(eventSource){
            
        }
    }
    
}

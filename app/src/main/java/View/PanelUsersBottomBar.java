
package View;

import AgustinShopCart.Colors;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author agustin
 */
public class PanelUsersBottomBar extends JPanel{
    private ButtonSquare buttonEdit;
    private ButtonSquare buttonAdd;
    private ButtonSquare buttonDelete;
    private Dimension panelDimension;
    private Dimension buttonDimension;
    private EventsHandler eventsHandler;
    
    public PanelUsersBottomBar(Color color, EventsHandler eventsHandler){
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        this.setBackground(color);
        this.panelDimension = new Dimension(1080, 40);
        this.buttonDimension = new Dimension(100, 30);
        this.setPreferredSize(panelDimension);
        this.eventsHandler = eventsHandler;
        
        buttonEdit = new ButtonSquare(eventsHandler);
        buttonAdd = new ButtonSquare(eventsHandler);
        buttonDelete = new ButtonSquare(eventsHandler);
        
        buttonEdit.setPreferredSize(buttonDimension);
        buttonAdd.setPreferredSize(buttonDimension);
        buttonDelete.setPreferredSize(buttonDimension);
        
        buttonEdit.setText("Edit");
        buttonAdd.setText("Add");
        buttonDelete.setText("Delete");
        
        this.add(buttonEdit);
        this.add(buttonAdd);
        this.add(buttonDelete);
    }
}

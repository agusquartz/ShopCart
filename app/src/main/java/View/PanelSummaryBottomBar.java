
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
public class PanelSummaryBottomBar extends JPanel{
    private ButtonSquare buttonReturn;
    private JLabel labelMoney;
    private Dimension panelDimension;
    private Dimension buttonDimension;
    private EventsHandler eventsHandler;
    
    public PanelSummaryBottomBar(Color color, EventsHandler eventsHandler){
        this.setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 5));
        this.setBackground(color);
        this.panelDimension = new Dimension(1080, 40);
        this.buttonDimension = new Dimension(100, 30);
        this.setPreferredSize(panelDimension);
        this.eventsHandler = eventsHandler;
        
        buttonReturn = new ButtonSquare(eventsHandler);
        labelMoney = new JLabel();
        
        labelMoney.setForeground(Color.WHITE);
        labelMoney.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        
        labelMoney.setPreferredSize(buttonDimension);
        buttonReturn.setPreferredSize(buttonDimension);
        
        buttonReturn.setText("Return");
        
        eventsHandler.addSupplier("getLabelMoney", () -> getLabelMoney());
        
        this.add(buttonReturn);
        this.add(labelMoney);
    }
    
    private JLabel getLabelMoney(){
        return labelMoney;
    }
}


package View;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import AgustinShopCart.Colors;
import java.awt.CardLayout;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agustin
 */
public class Window extends JFrame{
    private Color color1 = Color.decode(Colors.ARSENIC.toString()); // LeftBar
    private Color color2 = Color.decode(Colors.LIGHTSLATEGRAY.toString());
    private Color color3 = Color.decode(Colors.DEEPSPACESPARKLE.toString()); // Center JPanel
    private WindowTopBar windowTopBar;
    private WindowBottomBar windowBottomBar;
    private LeftBar leftBar;
    private Background background;
    private EventsHandler eventsHandler;
    
    public Window(){
        this.eventsHandler = EventsHandler.getInstance();
        this.setUndecorated(true);
        this.setSize(1080, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("AgusShop");
        
        windowTopBar = new WindowTopBar(this, eventsHandler);
        this.add(windowTopBar, BorderLayout.PAGE_START);
        
        windowBottomBar = new WindowBottomBar(this);
        this.add(windowBottomBar, BorderLayout.PAGE_END);
        
        leftBar = new LeftBar(color1, eventsHandler);
        this.add(leftBar, BorderLayout.LINE_START);
        
        background = new Background(color3);
        this.add(background, BorderLayout.CENTER);
        
        eventsHandler.addMethods("showPanelShop", () -> showCardPanel("panelShop"));
        eventsHandler.addMethods("showPanelAddMovie", () -> showCardPanel("panelAddMovie"));
        eventsHandler.addMethods("showPanelPolicy", () -> showCardPanel("panelPolicy"));
        eventsHandler.addMethods("showPanelSummary", () -> showCardPanel("panelSummary"));
        eventsHandler.addMethods("showPanelUsers", () -> showCardPanel("panelUsers"));
        eventsHandler.addMethods("showPanelSettings", () -> showCardPanel("panelSettings"));
        eventsHandler.addMethods("showPanelUserCreate", () -> showCardPanel("panelUserCreate"));
        eventsHandler.addMethods("showPanelUserEdit", () -> showCardPanel("panelUserEdit"));
        
        
        setVisible(true);
    }
    
    public void showCardPanel(String name){
        CardLayout cardLayout = (CardLayout) background.getLayout();
        cardLayout.show(background, name);
    }
}

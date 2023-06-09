
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import AgustinShopCart.Colors;

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
    
    public Window(){
        
        this.setUndecorated(true);
        this.setSize(1080, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("AgusShop");
        
        windowTopBar = new WindowTopBar(this);
        this.add(windowTopBar, BorderLayout.PAGE_START);
        
        windowBottomBar = new WindowBottomBar(this);
        this.add(windowBottomBar, BorderLayout.PAGE_END);
        
        leftBar = new LeftBar(color1);
        this.add(leftBar, BorderLayout.LINE_START);
        
        background = new Background(color3);
        this.add(background, BorderLayout.CENTER);
        
        setVisible(true);
    }
}

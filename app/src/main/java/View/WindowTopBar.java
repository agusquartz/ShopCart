
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author agustin
 */
public class WindowTopBar extends JPanel{
    private final int HEIGHT = 20;
    private final int WINDOWWIDTH;
    private ButtonCloseWindow closeButton;
    private int xPositionMouse;
    private int yPositionMouse;
    private JLabel labelUserType;
    private EventsHandler eventsHandler;
    
    
    public WindowTopBar(Window window, EventsHandler eventsHandler){
        WINDOWWIDTH = window.getWidth();
        setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(WINDOWWIDTH, HEIGHT));
        this.eventsHandler = eventsHandler;
        setBackground(Color.decode("#29323C"));
        
        labelUserType = new JLabel(" Administrator");
        labelUserType.setForeground(Color.WHITE);
        labelUserType.setFont(new Font("Monospaced", Font.PLAIN, 10));
        add(labelUserType, BorderLayout.LINE_START);
        
        closeButton = new ButtonCloseWindow(window, WINDOWWIDTH, HEIGHT, eventsHandler);
        add(closeButton, BorderLayout.LINE_END);
        
        draggedEffect(window);
    }
    
    private void draggedEffect(Window window){
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                thisMousePressed(evt);
            }
        });
        
        this.addMouseMotionListener(new java.awt.event.MouseAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                thisMouseDragged(evt, window);
            }
        });
    }
    
    private void thisMousePressed(MouseEvent e) {
        xPositionMouse = e.getX();
        yPositionMouse = e.getY();
    }

    private void thisMouseDragged(MouseEvent e, Window window) {
        Point point = MouseInfo.getPointerInfo().getLocation();
        window.setLocation(point.x - xPositionMouse, point.y - yPositionMouse);
    }
}

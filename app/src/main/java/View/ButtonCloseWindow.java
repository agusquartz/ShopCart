
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  This class represents a button to close windows.
 *  The button is created with an icon
 * @author agustin
 */
public class ButtonCloseWindow extends ButtonSquare{
    private final int HEIGHT;
    private Window window;
    
    public ButtonCloseWindow(Window window, int windowWidth, int height){
        this.window = window;
        this.HEIGHT = height;
        
        setColor1(Color.decode("#29323C"));
        
        setText("X");
        setForeground(new Color(255, 36, 36));
        setFont(new Font("arial", Font.PLAIN, 20));
        
        setExitOnClick();
    }
    
    /**
     * Set the event to close the JFrame (Stop the program) when the button
     * is clicked
     */
    private void setExitOnClick(){
        this.addActionListener(e -> {
            System.exit(0);
        });
    }
}

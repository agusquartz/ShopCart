
package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author agustin
 */
public abstract class ButtonBase extends JButton{
    private static int buttonIDCounter = 0;
    private final int BUTTONID;
    private final static String SOURCEPATH = System.getProperty("user.dir");
    private boolean hover;
    private Color color1 = Color.decode("#364649"); // Darker
    private Color color2 = Color.decode("#485563"); // Lighter
    
    public ButtonBase(){
        this.BUTTONID = buttonIDCounter++;
        this.setFocusable(false);
        this.setText(null);
        this.setContentAreaFilled(false);
        this.setForeground(Color.WHITE);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setBorder(new EmptyBorder(10, 20, 10, 20));
        
        hoverEffect();
    }
    
    /**
    * The path is localized and saved into a variable, then transformed and
    * converted into an ImageIcon
    * @param width New widht of the image
    * @param height New height of the image
    * @param path The name of the path is inserted with the extension
    * @throws IOException 
    */
    public ImageIcon setImage(int width, int height, String path) throws IOException {
        Image image = null;
        ImageIcon icon = null; 
        try {
            // Search, buffer and instance the Images
            BufferedImage bufferedImage = ImageIO.read(this.getClass().getClassLoader().getResource(SOURCEPATH + File.separator + "images" + File.separator + path));
            image = bufferedImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
        } 
        catch (IOException ex) {
            //Print
            System.out.println("Error loading the image");
            ex.printStackTrace();
        }
        return icon;
    }
    
    /**
    * The path is localized, then transformed and converted into an ImageIcon
     * @param size The new size of the image
    * @param name The name of the image that is inserted with the extension
    */
    public ImageIcon setImage(int size, String name) {
        ImageIcon icon = null;
        Image image = null;
        try {
            BufferedImage bufferedImage = ImageIO.read(new FileInputStream(SOURCEPATH + name));
            image = bufferedImage.getScaledInstance(size, size, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImageAvatar.class.getName()).log(Level.SEVERE, "FILENOTFOUND", ex);
        } catch (IOException ex) {
            Logger.getLogger(ImageAvatar.class.getName()).log(Level.SEVERE, "ANOTHERERROR", ex);
        }
        return icon;
    }
    
    private void hoverEffect(){
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mouseHoverIn();
            }
        });
        
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mouseHoverExit();
            }
        });
    }

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }
    
    public boolean isHover() {
        return hover;
    }

    public void setHover(boolean hover) {
        this.hover = hover;
    }
    
    private void mouseHoverIn() {                                      
        setHover(true);
        repaint();
    }
    
    private void mouseHoverExit(){
        setHover(false);
        repaint();
    }
}

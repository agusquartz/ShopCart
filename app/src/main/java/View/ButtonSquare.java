
package View;

import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/**
 *
 * @author agustin
 */
public class ButtonSquare extends ButtonBase{
//    private Color color1 = Color.decode("#CCFFAA");
//    private Color color2 = Color.decode("#1E5B53");
//    private Color color1 = Color.decode("#29323C"); // Darker
//    private Color color2 = Color.decode("#485563"); // Lighter
//    private boolean hover;
    private EventsHandler eventsHandler;
    
    
    public ButtonSquare(EventsHandler eventsHandler){
        super();
        this.eventsHandler = eventsHandler;
        this.addActionListener(eventsHandler);
    }
    
    /**
     *
     * @param grphcs
     */
    @Override
    protected void paintComponent(Graphics grphcs){
        int width = getWidth();
        int height = getHeight();
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = img.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if(isHover()){
            //  Create Gradients Color
            GradientPaint gradient = new GradientPaint(0, 0, getColor1(), width, 0, getColor2());
            graphics2D.setPaint(gradient);
        } else{
            GradientPaint gradient = new GradientPaint(0, 0, getColor1(), width, 0, getColor1());
            graphics2D.setPaint(gradient);
        }
        
        graphics2D.fillRect(0, 0, width, height);
        //  Add Style
//        createStyle(graphics2D);
        graphics2D.dispose();
        grphcs.drawImage(img, 0, 0, null);
        super.paintComponent(grphcs);
    }
}

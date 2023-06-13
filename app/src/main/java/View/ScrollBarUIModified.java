package View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author agustin
 */
public class ScrollBarUIModified extends BasicScrollBarUI {

    private final int THUMB_SIZE = 80;

    @Override
    protected Dimension getMaximumThumbSize() {
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            return new Dimension(0, THUMB_SIZE);
        } else {
            return new Dimension(THUMB_SIZE, 0);
        }
    }

    @Override
    protected Dimension getMinimumThumbSize() {
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            return new Dimension(0, THUMB_SIZE);
        } else {
            return new Dimension(THUMB_SIZE, 0);
        }
    }

    @Override
    protected JButton createIncreaseButton(int i) {
        return new ScrollBarButton();
    }

    @Override
    protected JButton createDecreaseButton(int i) {
        return new ScrollBarButton();
    }

    @Override
    protected void paintTrack(Graphics graphics, JComponent jComponent, Rectangle rectangle) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int orientation = scrollbar.getOrientation();
        int size;
        int xPosition;
        int yPosition;
        int width;
        int height;
        
        if (orientation == JScrollBar.VERTICAL) {
            size = rectangle.width / 2;
            xPosition = rectangle.x + ((rectangle.width - size) / 2);
            yPosition = rectangle.y;
            width = size;
            height = rectangle.height;
        } else {
            size = rectangle.height / 2;
            yPosition = rectangle.y + ((rectangle.height - size) / 2);
            xPosition = 0;
            width = rectangle.width;
            height = size;
        }
        
        graphics2D.setColor(scrollbar.getBackground());
        graphics2D.fillRect(xPosition, yPosition, width, height);
    }

    @Override
    protected void paintThumb(Graphics graphics, JComponent jComponent, Rectangle rectangle) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int xPosition = rectangle.x;
        int yPosition = rectangle.y;
        int width = rectangle.width;
        int height = rectangle.height;
        
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            yPosition += 8;
            height -= 16;
        } else {
            xPosition += 8;
            width -= 16;
        }
        
        graphics2D.setColor(scrollbar.getForeground());
        graphics2D.fillRoundRect(xPosition, yPosition, width, height, 10, 10);
    }

    private class ScrollBarButton extends JButton {

        public ScrollBarButton() {
            setBorder(BorderFactory.createEmptyBorder());
        }

        @Override
        public void paint(Graphics grphcs) {
        }
    }
}

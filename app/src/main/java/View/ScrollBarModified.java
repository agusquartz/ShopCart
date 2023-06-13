package View;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

/**
 *
 * @author agustin
 */
public class ScrollBarModified extends JScrollBar {

    public ScrollBarModified() {
        setUI(new ScrollBarUIModified());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(48, 144, 216));
        setBackground(new Color(30, 30, 30));
    }
}

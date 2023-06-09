package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *  Class to create a rounded corner JPanel
 *  It also includes a JLayeredPane
 *  <p>
 *  You must get the layered pane from the object and when you finished
 *  using it you must add to this again.
 * 
 */
public class LayeredPanelRound extends JPanel {
    private JLayeredPane layeredPane = new JLayeredPane();
    private int roundTopLeft = 0;
    private int roundTopRight = 0;
    private int roundBottomLeft = 0;
    private int roundBottomRight = 0;

    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        LayeredPanelRound panel = new LayeredPanelRound(frame);
        
        JButton b1 = new JButton("Button_01");
        b1.setFocusable(false);
        b1.setBackground(Color.RED);
        b1.setBounds(50, 50, 100, 50);
        
        JButton b2 = new JButton("Button_02");
        b2.setBackground(Color.BLUE);
        b2.setBounds(75, 25, 100, 50);
        
        JLayeredPane pane = panel.getLayeredPane();
        pane.add(b1, 10);
        pane.add(b2, 20);
        
        panel.add(pane);
        
        frame.add(panel);
        frame.setVisible(true);
    }
    
    public LayeredPanelRound(JFrame frame) {
        this.setOpaque(false);
        layeredPane.setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight()));
    }
    
    public LayeredPanelRound(JPanel panel) {
        this.setOpaque(false);
        layeredPane.setPreferredSize(new Dimension(panel.getWidth(), panel.getHeight()));
    }
    
    
    // ---------- Public Methods ----------
    
    public JLayeredPane getLayeredPane(){
        return this.layeredPane;
    }
    
    public int getRoundTopLeft() {
        return this.roundTopLeft;
    }

    /**
     * Method that sets the top left corner rounded
     * @param roundTopLeft 
     */
    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
        repaint();
    }

    public int getRoundTopRight() {
        return this.roundTopRight;
    }

    /**
     * Method that sets the top right corner rounded
     * @param roundTopRight 
     */
    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
        repaint();
    }

    public int getRoundBottomLeft() {
        return this.roundBottomLeft;
    }

    /**
     * Method that sets the bottom left corner rounded
     * @param roundBottomLeft 
     */
    public void setRoundBottomLeft(int roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
        repaint();
    }

    public int getRoundBottomRight() {
        return this.roundBottomRight;
    }

    /**
     * Method that sets the bottom right corner rounded
     * @param roundBottomRight 
     */
    public void setRoundBottomRight(int roundBottomRight) {
        this.roundBottomRight = roundBottomRight;
        repaint();
    }
    
    
    // ---------- Private Methods ----------

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        Area area = new Area(createRoundTopLeft());
        if (roundTopRight > 0) {
            area.intersect(new Area(createRoundTopRight()));
        }
        if (roundBottomLeft > 0) {
            area.intersect(new Area(createRoundBottomLeft()));
        }
        if (roundBottomRight > 0) {
            area.intersect(new Area(createRoundBottomRight()));
        }
        g2.fill(area);
        g2.dispose();
        super.paintComponent(grphcs);
    }

    private Shape createRoundTopLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopLeft);
        int roundY = Math.min(height, roundTopLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundTopRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopRight);
        int roundY = Math.min(height, roundTopRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomLeft);
        int roundY = Math.min(height, roundBottomLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomRight);
        int roundY = Math.min(height, roundBottomRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }
}
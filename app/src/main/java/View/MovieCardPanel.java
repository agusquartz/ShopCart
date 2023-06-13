package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieCardPanel extends JPanel {
    private Image imagen;
    private boolean available;
    private String name;
    private String price;
    private JButton agregarCarrito;
    private JButton masInfo;

    public MovieCardPanel(Image imagen, boolean available, String name, String price) {
        this.imagen = imagen;
        this.available = available;
        this.name = name;
        this.price = price;

        setLayout(new BorderLayout());

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(300, 400));

        JPanel imagenLabel = new JPanel();
        imagenLabel.setBounds(0, 0, 100, 400);
        imagenLabel.setBackground(Color.red);
        layeredPane.add(imagenLabel, JLayeredPane.DEFAULT_LAYER);

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(new Color(0, 0, 0, 150));
        infoPanel.setBounds(0, 300, 300, 100);
        infoPanel.setLayout(new GridLayout(2, 1));

        JLabel nameLabel = new JLabel(name);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoPanel.add(nameLabel);

        JLabel priceLabel = new JLabel(price);
        priceLabel.setForeground(Color.WHITE);
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoPanel.add(priceLabel);

        layeredPane.add(infoPanel, JLayeredPane.PALETTE_LAYER);

        agregarCarrito = new JButton("Agregar al carrito");
        agregarCarrito.setBounds(20, 350, 120, 30);
        agregarCarrito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción al hacer clic en "Agregar al carrito"
            }
        });
        layeredPane.add(agregarCarrito, JLayeredPane.MODAL_LAYER);

        masInfo = new JButton("Más información");
        masInfo.setBounds(160, 350, 120, 30);
        masInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción al hacer clic en "Más información"
            }
        });
        layeredPane.add(masInfo, JLayeredPane.MODAL_LAYER);

        add(layeredPane);
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(this.getWidth(), this.getHeight());
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setVisible(true);
    }
    
    public static void main(String[] args){
        new MovieCardPanel(null, true, "Harry Potter", "27");
    }
}

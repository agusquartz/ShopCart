package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CardLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel(new CardLayout());

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.GREEN);

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.BLUE);

        contentPane.add(panel1, "Panel 1");
        contentPane.add(panel2, "Panel 2");
        contentPane.add(panel3, "Panel 3");

        JButton button1 = new JButton("Panel 1");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Panel 1");
            }
        });

        JButton button2 = new JButton("Panel 2");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Panel 2");
            }
        });

        JButton button3 = new JButton("Panel 3");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Panel 3");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        frame.add(contentPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}

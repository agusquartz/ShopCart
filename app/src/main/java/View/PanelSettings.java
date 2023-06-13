
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author agustin
 */
public class PanelSettings extends JPanel{
    private JLabel labelTitle;
    private JLabel labelTheme;
    private JLabel labelDataBase;
    private JComboBox<String> comboBoxThemes;
    private JComboBox<String> comboBoxDataBases;
    private GridBagConstraints gbc;
    private final Dimension SIZE;
    
    public PanelSettings(Color color){
        this.setBackground(color);
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        SIZE = new Dimension(100, 30);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        
        labelTitle = new JLabel("SETTINGS");
        labelTheme = new JLabel("Theme:");
        labelDataBase = new JLabel("DataBase:");
        comboBoxThemes = new JComboBox<>();
        comboBoxDataBases = new JComboBox<>();
        
        labelTitle.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        labelTheme.setHorizontalAlignment(SwingConstants.RIGHT);
        labelDataBase.setHorizontalAlignment(SwingConstants.RIGHT);
        
        labelTitle.setPreferredSize(SIZE);
        labelTheme.setPreferredSize(SIZE);
        labelDataBase.setPreferredSize(SIZE);
        comboBoxDataBases.setPreferredSize(SIZE);
        comboBoxThemes.setPreferredSize(SIZE);
        
        comboBoxThemes.addItem("Dark");
        comboBoxDataBases.addItem("JSON");
        
        labelTitle.setForeground(Color.WHITE);
        labelTheme.setForeground(Color.WHITE);
        labelDataBase.setForeground(Color.WHITE);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(labelTheme, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(comboBoxThemes, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(labelDataBase, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(comboBoxDataBases, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(labelTitle, gbc);
    }
    
}

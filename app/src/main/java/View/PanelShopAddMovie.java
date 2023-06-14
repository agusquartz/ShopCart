
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *  This class represents the place where you can add a new movie to the system
 * @author agustin
 */
public class PanelShopAddMovie extends JPanel{
    private JTextField textFieldName;
    private JTextField textFieldReleaseYear;
    private JTextField textFieldDirector;
    private JTextField textFieldGenre;
    private JTextField textFieldDescription;
    private JTextField textFieldPrice;
    private JLabel labelTittle;
    private ButtonSquare buttonCancel;
    private ButtonSquare buttonContinue;
    private final Dimension TEXTFIELDDIMENSION = new Dimension(150, 40);
    private GridBagConstraints gbc = new GridBagConstraints();
    private EventsHandler eventsHandler = EventsHandler.getInstance();
    
    /**
     * Main contructor of the panel
     * @param title
     * @param background 
     */
    public PanelShopAddMovie(String title, Color background){
        this.setLayout(new GridBagLayout());
        this.setBackground(background);
        gbc.insets = new Insets(5, 5, 5, 5);        
        build(title, background);
    }
    
    /**
     * Method in charge of build and add all the elements of the panel
     * @param title
     * @param background 
     */
    private void build(String title, Color background){
        
        buttonCancel = new ButtonSquare(eventsHandler);
        buttonCancel.setText("Back");
        buttonCancel.setPreferredSize(TEXTFIELDDIMENSION);
        gbc.gridx = 0;
        gbc.gridy = 7;
        this.add(buttonCancel, gbc);
        
        buttonContinue = new ButtonSquare(eventsHandler);
        buttonContinue.setText("Add Movie");
        buttonContinue.setPreferredSize(TEXTFIELDDIMENSION);
        gbc.gridx = 1;
        gbc.gridy = 7;
        this.add(buttonContinue, gbc);
        
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        labelTittle = new JLabel(title, SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(labelTittle, gbc);
        
        textFieldName = new JTextField();
        configTextField(textFieldName, "Name", background, Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(textFieldName, gbc);
        
        textFieldReleaseYear = new JTextField();
        configTextField(textFieldReleaseYear, "Release Year", background, Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(textFieldReleaseYear, gbc);
        
        textFieldDirector = new JTextField();
        configTextField(textFieldDirector, "Director", background, Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(textFieldDirector, gbc);
        
        textFieldGenre = new JTextField();
        configTextField(textFieldGenre, "Genre", background, Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 4;
        this.add(textFieldGenre, gbc);
        
        textFieldDescription = new JTextField();
        configTextField(textFieldDescription, "Descripion", background, Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 5;
        this.add(textFieldDescription, gbc);
        
        textFieldPrice = new JTextField();
        configTextField(textFieldPrice, "Price", background, Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 6;
        this.add(textFieldPrice, gbc);
    }
    
    /**
     * Method in charge of configure the text fields
     * @param field
     * @param label
     * @param background
     * @param foreground 
     */
    private void configTextField(JTextField field, String label, Color background, Color foreground){
        field.setPreferredSize(TEXTFIELDDIMENSION);
        LineBorder lineBorder = new LineBorder(Color.BLACK, 2);
        TitledBorder border = BorderFactory.createTitledBorder(lineBorder, label);
        border.setTitleJustification(TitledBorder.BELOW_TOP);
        border.setTitleColor(foreground);
        border.setTitleFont(new Font(Font.SERIF, Font.PLAIN, 10));
        
        field.setBorder(border);
        field.setBackground(background);
        field.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        field.setForeground(foreground);
    }
}

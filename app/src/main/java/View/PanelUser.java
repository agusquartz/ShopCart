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
 *
 * @author agustin
 */
public abstract class PanelUser extends JPanel{
    private JTextField textFieldEmail;
    private JTextField textFieldAge;
    private JTextField textFieldName;
    private JTextField textFieldSurname;
    private JTextField textFieldIDCard;
    private JTextField textFieldPhone;
    private JTextField textFieldCity;
    private JLabel labelTittle;
    private ButtonSquare buttonCancel;
    private ButtonSquare buttonContinue;
    private final Dimension TEXTFIELDDIMENSION = new Dimension(150, 40);
    private GridBagConstraints gbc = new GridBagConstraints();
    private EventsHandler eventsHandler;
    
    public PanelUser(String title, Color background, EventsHandler eventsHandler){
        this.eventsHandler = eventsHandler;
        this.setLayout(new GridBagLayout());
        this.setBackground(background);
        
        gbc.insets = new Insets(5, 5, 5, 5);
        
        build(title, background);
    }

    public JTextField getTextFieldName() {
        return textFieldName;
    }

    public JTextField getTextFieldSurname() {
        return textFieldSurname;
    }

    public JTextField getTextFieldIDCard() {
        return textFieldIDCard;
    }

    public JTextField getTextFieldPhone() {
        return textFieldPhone;
    }

    public JTextField getTextFieldCity() {
        return textFieldCity;
    }

    public ButtonSquare getButtonCancel() {
        return buttonCancel;
    }

    public JTextField getTextFieldEmail() {
        return textFieldEmail;
    }

    public JTextField getTextFieldAge() {
        return textFieldAge;
    }

    public ButtonSquare getButtonContinue() {
        return buttonContinue;
    }
    
    private void build(String title, Color background){ 
        
        buttonCancel = new ButtonSquare(eventsHandler);
        buttonCancel.setText("Cancel");
        buttonCancel.setPreferredSize(TEXTFIELDDIMENSION);
        gbc.gridx = 0;
        gbc.gridy = 8;
        this.add(buttonCancel, gbc);
        
        buttonContinue = new ButtonSquare(eventsHandler);
        buttonContinue.setText("Continue");
        buttonContinue.setPreferredSize(TEXTFIELDDIMENSION);
        gbc.gridx = 1;
        gbc.gridy = 8;
        this.add(buttonContinue, gbc); 
        
        textFieldName = new JTextField();
        configTextField(textFieldName, "Name", background, Color.BLACK, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(textFieldName, gbc);
        
        textFieldSurname = new JTextField();
        configTextField(textFieldSurname, "Surname", background, Color.BLACK, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(textFieldSurname, gbc);
        
        textFieldAge = new JTextField();
        configTextField(textFieldAge, "Age", background, Color.BLACK, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(textFieldAge, gbc);
        
        textFieldEmail = new JTextField();
        configTextField(textFieldEmail, "Email", background, Color.BLACK, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        this.add(textFieldAge, gbc);
        
        textFieldIDCard = new JTextField();
        configTextField(textFieldIDCard, "ID Number", background, Color.BLACK, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        this.add(textFieldIDCard, gbc);
        
        textFieldPhone = new JTextField();
        configTextField(textFieldPhone, "Phone Number", background, Color.BLACK, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        this.add(textFieldPhone, gbc);
        
        textFieldCity = new JTextField();
        configTextField(textFieldCity, "City", background, Color.BLACK, gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        this.add(textFieldCity, gbc);       
        
        labelTittle = new JLabel(title, SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(labelTittle, gbc);
    }
    
    private void configTextField(JTextField field, String label, Color background, Color foreground, GridBagConstraints gbc){
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
        
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
    }
    
}

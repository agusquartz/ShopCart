
package View;

import AgustinShopCart.Colors;
import Repository.Movie;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author agustin
 */
public class PanelMoreInfo extends JPanel{
    private Dimension dimensionLabel;
    private JLabel labelName;
    private JLabel labelDescription;
    private JLabel labelDirector;
    private JLabel labelGenre;
    private JLabel labelReleaseYear;
    private final String html = "<html><body style='width: %1spx'>%1s";
    
    
    public PanelMoreInfo(){
        this.setBackground(Color.decode(Colors.QUICKSILVER.toString()));
        dimensionLabel = new Dimension(930, 80);
        labelName = new JLabel();
        labelDescription = new JLabel();
        labelDirector = new JLabel();
        labelGenre = new JLabel();
        labelReleaseYear = new JLabel();
        
        labelName.setPreferredSize(dimensionLabel);
        labelDescription.setPreferredSize(dimensionLabel);
        labelDirector.setPreferredSize(dimensionLabel);
        labelGenre.setPreferredSize(dimensionLabel);
        labelReleaseYear.setPreferredSize(dimensionLabel);
        
        labelName.setHorizontalAlignment(SwingConstants.CENTER);
        
        this.add(labelName);
        this.add(labelDescription);
        this.add(labelDirector);
        this.add(labelGenre);
        this.add(labelReleaseYear);
    }
    
    public void showData(Movie movie){
        labelName.setText(movie.getName());
        labelDescription.setText(String.format(html, 500, movie.getDescription()));
        labelDirector.setText("Director: " + movie.getDirector());
        labelGenre.setText("Genre: " + movie.getGenre());
        labelReleaseYear.setText("Release Year: " + movie.getReleaseYear());
    }
}


package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author agustin
 */
public class PanelUsers extends JPanel{
    private PanelUsersBottomBar panelBottomBar;
    private JLabel labelTitle;
    private TableModified tableModified;
    private JScrollPane jScrollPane;
    private EventsHandler eventsHandler = EventsHandler.getInstance();
    
    public PanelUsers(Color color){
        this.setBackground(color);
        this.setLayout(new BorderLayout());
        this.panelBottomBar = new PanelUsersBottomBar(color, eventsHandler);
        this.labelTitle = new JLabel("Users");
        
        tableConfig();
        
        labelTitle.setForeground(Color.WHITE);
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitle.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        
        eventsHandler.addSupplier("getClientsTable", () -> returnTable());
        
        this.add(labelTitle, BorderLayout.PAGE_START);
        this.add(panelBottomBar, BorderLayout.PAGE_END);
        this.add(jScrollPane, BorderLayout.CENTER);
    }
    
    private void tableConfig(){
        this.tableModified = new TableModified();
        this.jScrollPane = new JScrollPane();

        tableModified.setModel(new DefaultTableModel(new Object [][] {}
                ,new String [] {"ID", "Name", "Surname", "Age", "Phone", "Email", "City", "CanRent"}){
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        jScrollPane.setViewportView(tableModified);
        jScrollPane.setPreferredSize(new Dimension(950, 600));

        tableModified.fixTable(jScrollPane);
        
        setAllAlignmentCenter(8, tableModified);
        
        tableModified.setColumnWidth(0, 100);
        tableModified.setColumnWidth(1, 75);
        tableModified.setColumnWidth(2, 100);
        tableModified.setColumnWidth(3, 30);
        tableModified.setColumnWidth(4, 125);
        tableModified.setColumnWidth(7, 75);
        
    }
    
    private void setAllAlignmentCenter(int columns, TableModified table){
        for(int i = 0; i<columns; i++){
            table.setColumnAlignment(i, JLabel.CENTER);
            table.setCellAlignment(i, JLabel.CENTER);
        }
    }
    
    private TableModified returnTable(){
        return tableModified;
    }
    
}

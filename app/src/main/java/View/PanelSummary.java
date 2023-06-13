
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
public class PanelSummary extends JPanel{
    private JLabel labelTitle;
    private TableModified tableModified;
    private JScrollPane jScrollPane;
    private EventsHandler eventsHandler = EventsHandler.getInstance();
    
    public PanelSummary(Color color){
        this.setBackground(color);
        this.setLayout(new BorderLayout());
        this.labelTitle = new JLabel("Summary");
        
        tableConfig();
        
        labelTitle.setForeground(Color.WHITE);
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitle.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        
        eventsHandler.addSupplier("getSummaryTable", () -> returnTable());
        
        this.add(labelTitle, BorderLayout.PAGE_START);
        this.add(jScrollPane, BorderLayout.CENTER);
        
    }
    
    private void tableConfig(){
        this.tableModified = new TableModified();
        this.jScrollPane = new JScrollPane();

        tableModified.setModel(new DefaultTableModel(new Object [][] {}
                ,new String [] {"RentedBy", "Available", "Name", "Price", "Rented Date", "Returned Date"}){
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        jScrollPane.setViewportView(tableModified);
        jScrollPane.setPreferredSize(new Dimension(950, 600));

        tableModified.fixTable(jScrollPane);
        
        setAllAlignmentCenter(6, tableModified);
        
        tableModified.setColumnWidth(2, 100);
        
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

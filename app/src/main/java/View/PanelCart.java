
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author agustin
 */
public class PanelCart extends JPanel{
    private PanelCartTopBar panelCartTopBar;
    private PanelCartCenter panelCartCenter;
    private TableModified tableModified;
    private JScrollPane jScrollPane;
    private EventsHandler eventsHandler = EventsHandler.getInstance();
    
    public PanelCart(Color color){
        this.setLayout(new BorderLayout());
        this.setBackground(color);
        
        panelCartTopBar = new PanelCartTopBar(color);
        panelCartCenter = new PanelCartCenter(color);
        
        tableConfig();
        
        eventsHandler.addSupplier("getCartTable", () -> returnTable());
        
        this.add(panelCartTopBar, BorderLayout.PAGE_START);
        this.add(jScrollPane, BorderLayout.LINE_END);
        this.add(panelCartCenter, BorderLayout.CENTER);
    }
    
    private void tableConfig(){
        this.tableModified = new TableModified();
        this.jScrollPane = new JScrollPane();

        tableModified.setModel(new DefaultTableModel(new Object [][] {}
                ,new String [] {"Name", "ID Number"}){
                boolean[] canEdit = new boolean [] {
                    false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        jScrollPane.setViewportView(tableModified);
        jScrollPane.setPreferredSize(new Dimension(200, 600));

        tableModified.fixTable(jScrollPane);
        
        setAllAlignmentCenter(5, tableModified);   
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

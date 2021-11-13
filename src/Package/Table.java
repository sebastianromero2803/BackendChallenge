package Package;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class Table extends JFrame implements ActionListener{
    
    JPanel panel1 = new JPanel(new BorderLayout());
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JTable table;
    JLabel label1;
    JButton button1;
    JScrollPane jsp;
    
    public Table(int dimension){
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null); 
        this.add(panel1);  
        
        LoadComponents(dimension);
    }
    
    public void LoadComponents(int dimension){
        panel1.add(panel2, BorderLayout.SOUTH);
        panel1.add(panel3, BorderLayout.NORTH);
        
        panel2.setBorder(new EmptyBorder(10,10,10,10));
        
        Table(dimension);
    }
    
    public void Table(int dimension){
        String[][] body = Process(dimension);
        String[] titles = new String[dimension];
        
        for(int i = 0; i<dimension; i++)
            titles[i] = "Column";

        table = new JTable(body,titles);
        jsp = new JScrollPane(table);
        
        DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
        alinear.setHorizontalAlignment(SwingConstants.CENTER);
        
        for(int i = 0; i < table.getColumnCount(); i++)
            table.getColumnModel().getColumn(i).setCellRenderer(alinear);
        
        panel1.add(jsp, BorderLayout.CENTER);   
        
        button1 = new JButton("Back");
        button1.addActionListener(this);
        panel2.add(button1);
        
        label1 = new JLabel("The sum of the diagonals is: " + Process2(body));
        panel3.add(label1);
    }
    
    public String[][] Process(int dimension){
        int end = 0;
        int beginning = dimension-1;
        int value = (int) Math.pow(dimension, 2);
        
        String[][] body = new String[dimension][dimension];

        while(value > 0){           
            for(int i = beginning; i>=end; i--){
                body[end][i] = Integer.toString(value);
                value -= 1;
            }

            for(int i = end+1; i<=beginning; i++){
                body[i][end] = Integer.toString(value);
                value -= 1;
            }   

            for(int i = end+1; i<=beginning; i++){
                body[beginning][i] = Integer.toString(value);
                value -= 1;
            }

            for(int i = beginning-1; i>=end+1; i--){
                body[i][beginning] = Integer.toString(value);
                value -= 1;
            }

            beginning -= 1;
            end += 1;
        }   
        
        return body;
    }
    
    public int Process2(String[][] matrix){
        int sum1 = 0, sum2 = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            sum1 += Integer.parseInt(matrix[i][i]);
        }

        int column = matrix.length-1;
        
        for (int i = 0; i < matrix.length; i++) {
            if(i != column)
                sum2 += Integer.parseInt(matrix[i][column]);
                column -= 1;
        }
        
        return (sum1+sum2);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button1)
            this.dispose();
            
    }
}

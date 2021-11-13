package Package;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Option3 extends JFrame implements ActionListener{
    
    JPanel panel1 = new JPanel(new BorderLayout());
    JPanel panel2 = new JPanel(new BorderLayout());
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JButton button1;
    JButton button2;
    JTextArea textArea1;
    JLabel label1;
    JComboBox<Integer> select;
    Font font = new Font("Verdana", Font.BOLD,11);
    
    public Option3(){
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 200);
        this.setResizable(false);
        this.setLocationRelativeTo(null); 
        this.add(panel1);   
        
        LoadComponents();
    }
    
    public void LoadComponents(){
        panel1.setBorder(new EmptyBorder(10,10,10,10));
        panel1.add(panel2, BorderLayout.CENTER);
        
        panel2.setBorder(new EmptyBorder(10,10,10,10));
        panel2.add(panel3, BorderLayout.NORTH);
        panel2.add(panel4, BorderLayout.SOUTH);
        
        Labels();
        TextArea();
        ComboBox();
        Buttons();
    }
    
    public void TextArea(){
        textArea1 = new JTextArea("In this section the matrix is fill in the form of a spiral, \nand calculate the sum of their diagonals");
        textArea1.setFont(font);
        textArea1.setEditable(false);
        textArea1.setOpaque(false);
        panel1.add(textArea1, BorderLayout.NORTH);
    }
    
    public void ComboBox(){
        Integer[] options = {0,2,3,4,5,6,7,8,9,10};
        select = new JComboBox(options);
        select.setSelectedIndex(0);
        panel3.add(select);
    }
    
    public void Labels(){
        label1 = new JLabel("Select the dimenion of the matrix");
        panel3.add(label1);
    }
    
    public void Buttons(){
        button1 = new JButton("Back");
        button1.addActionListener(this);
        panel4.add(button1);
        
        button2 = new JButton("Generate");
        button2.addActionListener(this);
        panel4.add(button2);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button1){
            this.dispose();
            Menu menu = new Menu();
        }
        else if(e.getSource() == button2){
            Table table = new Table((int) select.getSelectedItem()); 
        }
    }
    
}

package Package;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame implements ActionListener{
    
    private JPanel panel1 = new JPanel(new BorderLayout());
    private JPanel panel2 = new JPanel(new GridLayout(5,1,10,10));   
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    
    public Menu(){
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setResizable(false);
        this.setLocationRelativeTo(null); 
        this.add(panel1);   
        
        LoadComponents();
    }
    
    public void LoadComponents(){
        panel2.setBorder(new EmptyBorder(0,10,10,10));
        panel1.add(panel2,BorderLayout.CENTER);
        Labels();
        Buttons();
    }
    
    public void Labels(){
        label1 = new JLabel("Welcome to the Challenge C# Junior Developer",SwingConstants.CENTER);
        panel1.add(label1, BorderLayout.NORTH);
        
        label2 = new JLabel("Please select a option:");  
        panel2.add(label2);
    }
    
    public void Buttons(){
        button1 = new JButton("1. Find Multiples of x or y");
        panel2.add(button1);
        button1.addActionListener(this);
        
        button2 = new JButton("2. Find Power Number");
        panel2.add(button2);
        button2.addActionListener(this);
        
        button3 = new JButton("3. Make a Matrix and sum diagonals");
        panel2.add(button3);
        button3.addActionListener(this);
        
        button4 = new JButton("4. Make a Program to access the database");
        panel2.add(button4);
        button4.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button1){
            this.dispose();
            Option1 option = new Option1();
        }
        else if(e.getSource() == button2){
            this.dispose();
            Option2 option = new Option2();
        }
        else if(e.getSource() == button3){
            this.dispose();
            Option3 option = new Option3();
        }
        else if(e.getSource() == button4){
            this.dispose();
            Option4 option = new Option4();
        }
    }
}

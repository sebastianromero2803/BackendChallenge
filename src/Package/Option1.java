package Package;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Option1 extends JFrame implements ActionListener{
    
    JPanel panel1 = new JPanel(new BorderLayout());
    JPanel panel2 = new JPanel(new GridLayout(6,2));
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JPanel panel6 = new JPanel();
    JPanel panelScroll = new JPanel(new BorderLayout());
    JTextArea TextArea1;
    JTextArea TextArea2;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JTextField field1;
    JTextField field2;
    JTextField field3;
    JButton button1;
    JButton button2;
    JScrollPane scroll;
    Font font = new Font("Verdana", Font.BOLD,11); 
    
    public Option1(){
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);  
        this.setResizable(false);
        this.add(panel1);
        
        LoadComponents();
    }
    
    public void LoadComponents(){
        panel1.setBorder(new EmptyBorder(10,10,10,10));
        panel1.add(panel2, BorderLayout.CENTER);
        panel1.add(panel6, BorderLayout.SOUTH);
        
        panel2.add(panel3);
        panel2.add(panel4);
        panel2.add(panel5);
        panel2.add(panelScroll);
        panel2.add(panel6);
        
        Labels();
        TextAreas();
        TextFields();
        Buttons();
    }
    
    public void TextAreas(){
        TextArea1 = new JTextArea("In this section, please enter the two numbers (x,y), of \nwhich you want to find the multiples from 1 to the \nnumber n");
        TextArea1.setEditable(false);
        TextArea1.setOpaque(false);
        TextArea1.setFont(font);
        panel1.add(TextArea1, BorderLayout.NORTH);
        
        TextArea2 = new JTextArea("");
        TextArea2.setEditable(false);
        TextArea2.setOpaque(false);
        TextArea2.setFont(font);
        scroll = new JScrollPane(TextArea2);
        panelScroll.add(scroll, BorderLayout.CENTER);
    }
    
    public void Labels(){
        label2 = new JLabel("Select X:");
        panel3.add(label2);
        
        label3 = new JLabel("Select Y:");
        panel4.add(label3);
        
        label4 = new JLabel("Select n:");
        panel5.add(label4);
        
        label1 = new JLabel("The multiples of X and Y to n are:", SwingConstants.CENTER);
        panelScroll.add(label1, BorderLayout.NORTH);
        
        label5 = new JLabel("The sum of the multiples is: ", SwingConstants.CENTER);
        panel2.add(label5);
    }
    
    public void TextFields(){
        field1 = new JTextField(10);
        field1.setHorizontalAlignment(SwingConstants.CENTER);
        panel3.add(field1);
        
        field2 = new JTextField(10);
        field2.setHorizontalAlignment(SwingConstants.CENTER);
        panel4.add(field2);
        
        field3 = new JTextField(10);
        field3.setHorizontalAlignment(SwingConstants.CENTER);
        panel5.add(field3);
    }
    
    public void Buttons(){
        button1 = new JButton("Back");
        button1.addActionListener(this);
        panel6.add(button1);
        
        button2 = new JButton("Find");
        button2.addActionListener(this);
        panel6.add(button2);
    }
    
    public ArrayList Process(){
        int x = Integer.parseInt(field1.getText());
        int y = Integer.parseInt(field2.getText());
        int n = Integer.parseInt(field3.getText());
        ArrayList<Integer> multiples = new ArrayList<Integer>();
        
        for (int i = 1; i < n; i++) {
            if((i%x == 0) && (i%y == 0))
                multiples.add(i);
            else if(i%x == 0)
                multiples.add(i);
            else if(i%y == 0)
                multiples.add(i);
        }
        return multiples;
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button1){
            this.dispose();
            Menu menu = new Menu();
        }
        else if(e.getSource() == button2){
            TextArea2.setText("");
            ArrayList<Integer> multiples = Process();
            int sum = 0;
            
            label1.setText("The multiples of " + field1.getText() + " and " + field2.getText() + " to " + field3.getText() + " are:");
            
            for(int multiple:multiples) {
                TextArea2.append(multiple + " , ");  
                sum += multiple;
            }
            
            label5.setText("The sum of the multiples is: " + sum);
        }
    }
}

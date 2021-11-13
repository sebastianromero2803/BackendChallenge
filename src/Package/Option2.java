package Package;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Option2 extends JFrame implements ActionListener{
    
    JPanel panel1 = new JPanel(new BorderLayout());
    JPanel panel2 = new JPanel(new BorderLayout());
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JScrollPane scroll;
    JComboBox<Integer> select;
    JLabel label1;
    JButton button1;
    JButton button2;
    JTextArea textArea1;
    JTextArea textArea2;
    Font font = new Font("Verdana", Font.BOLD,11); 
    
    public Option2(){
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setResizable(false);
        this.setLocationRelativeTo(null); 
        this.add(panel1);   
        
        LoadComponents();
        String hola = "123";
    }
    
    public void LoadComponents(){
        panel1.setBorder(new EmptyBorder(10,10,10,10));
        panel1.add(panel2, BorderLayout.CENTER);
        panel1.add(panel4, BorderLayout.SOUTH);
        
        panel2.setBorder(new EmptyBorder(10,10,10,10));
        panel2.add(panel3, BorderLayout.NORTH);
        
        Labels();
        TextArea();
        Buttons();
        ComboBox();
    }
    
    public void Labels(){
        label1 = new JLabel("How many numbers do you want to see: ");
        panel3.add(label1);
    }
    
    public void Buttons(){
        button1 = new JButton("Back");
        button1.addActionListener(this);
        panel4.add(button1);
        
        button2 = new JButton("See");
        button2.addActionListener(this);
        panel4.add(button2);
    }
    
    public void TextArea(){
        textArea1 = new JTextArea("In this section, you can see the numbers in which your \ndigits raised to the power of 5 and added together result \nin the initial number");
        textArea1.setOpaque(false);
        textArea1.setEditable(false);
        textArea1.setFont(font);
        panel1.add(textArea1, BorderLayout.NORTH); 
        
        textArea2 = new JTextArea("");
        textArea2.setOpaque(false);
        textArea2.setEditable(false);
        textArea2.setFont(font);
        scroll = new JScrollPane(textArea2);
        panel2.add(scroll, BorderLayout.CENTER);
    }
    
    public void ComboBox(){
        Integer[] options = {0,1,2,3,4,5,6}; 
        select = new JComboBox<Integer>(options);
        select.setSelectedIndex(0);
        panel3.add(select);
    }
    
    public ArrayList Process(){
        int amount = (int) select.getSelectedItem();
        long lenght, flag, digit, sum, number = 2;
        ArrayList<Long> numbers = new ArrayList<Long>();
        ArrayList<Long> digits = new ArrayList<Long>();
        
        while(numbers.size() != amount){
            sum = 0;
            flag = number;
            lenght = Long.toString(flag).length();
            
            for(long i = (lenght-1); i>=0; i--){
                digit = (long) (flag/Math.pow(10, i));
                digits.add(digit);
                flag %= Math.pow(10,i);
            }
            
            for (Long x : digits) {
                sum += Math.pow(x, 5);
            }
            
            if(sum == number)
                numbers.add(number);
            
            digits.clear();
            number += 1;
        }
        
        return numbers;
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button1)
        {
            this.dispose();
            Menu menu = new Menu();
        }
        else if(e.getSource() == button2)
        {
            textArea2.setText("");
            ArrayList<Long> numbers = Process();
            
            for (Object number : numbers) {
                textArea2.append(number + "\n\n");
            }
            
            numbers.clear();
        }
    }
}

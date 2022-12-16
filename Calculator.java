import javax.swing.*;
import java.awt.event.*;
class Calculator extends JFrame implements ActionListener{
    private JTextField textField; 
    private JButton button1, button2, button3, plusButton, button4, button5, button6, minusButton, button7, button8, button9, multiplyButton, divideButton, button0, equalButton, clearButton; 
    private Integer result;
    private String operation;
    public Calculator(){
        setLayout(null);
        setSize(240,230);
        setTitle("Calculator");

        // First Row
        textField = new JTextField();
        textField.setBounds(10,20,200,30);
        button1 = new JButton("1");
        button1.setBounds(10,60,50,30);
        button2 = new JButton("2");
        button2.setBounds(60,60,50,30);
        button3 = new JButton("3");
        button3.setBounds(110,60,50,30);
        plusButton = new JButton("+");
        plusButton.setBounds(160,60,50,30);
        // Second Row
        button4 = new JButton("4");
        button4.setBounds(10,90,50,30);
        button5 = new JButton("5");
        button5.setBounds(60,90,50,30);
        button6 = new JButton("6");
        button6.setBounds(110, 90,50,30);
        minusButton = new JButton("-");
        minusButton.setBounds(160,90,50,30);
        // Third Row
        button7 = new JButton("7");
        button7.setBounds (10,120,50,30);
        button8 = new JButton("8");
        button8.setBounds(60,120,50,30);
        button9 = new JButton("9");
        button9.setBounds(110,120,50,30);
        multiplyButton = new JButton("*");
        multiplyButton.setBounds(160,120,50,30);
        // Fourth Row
        divideButton = new JButton("/");
        divideButton.setBounds(10,150,50,30);
        button0 = new JButton("0");
        button0.setBounds(60,150,50,30); 
        equalButton =new JButton("="); 
        equalButton.setBounds(110,150,50,30);
        clearButton = new JButton("C");
        clearButton.setBounds(160,150,50,30);

        add(textField);
        add(button1);
        add(button2);
        add(button3);
        add(plusButton);
        add(button4);
        add(button5);
        add(button6);
        add(minusButton);
        add(button7);
        add(button8);
        add(button9);
        add(multiplyButton);
        add(divideButton);
        add(button0);
        add(equalButton);
        add(clearButton);
        button1.addActionListener(this);
        button2.addActionListener(this); 
        button3.addActionListener(this);
        plusButton.addActionListener(this); 
        button4.addActionListener(this);
        button5.addActionListener(this); 
        button6.addActionListener(this);
        minusButton.addActionListener(this); 
        button7.addActionListener(this);
        button8.addActionListener(this); 
        button9.addActionListener(this);
        multiplyButton.addActionListener(this); 
        divideButton.addActionListener(this);
        button0.addActionListener(this); 
        equalButton.addActionListener(this);
        clearButton.addActionListener(this);
    }
    public void doAction(String op){
        if(operation == null){
            operation = op;
            result = Integer.parseInt(textField.getText());
            textField.setText("");
        }
        else{
            switch(operation){
                case "+":   result = result + Integer.parseInt(textField.getText());
                            break;
                case "-":   result = result - Integer.parseInt(textField.getText());
                            break;
                case "/":   try{
                                if(textField.getText().equals("0"))
                                    throw new ArithmeticException("Math Error: Division by 0");
                                result = result / Integer.parseInt(textField.getText());
                            }
                            catch(ArithmeticException e){
                                textField.setText(e.getMessage());
                                // System.out.println(e.getMessage());
                                operation = null;
                                result = -1;
                            }
                            break;
                case "*" :  result = result * Integer.parseInt(textField.getText());
                            break;
            }
            if(op.equals("=")){
                if(result != -1)
                    textField.setText(result.toString());
                result = 0;
                operation = null;
            }
            else{
                operation = op;
                textField.setText("");
            }
        }
    }

    public void actionPerformed(ActionEvent e){
        // t1.setText("");
        if(e.getSource()==button1)
            textField.setText("1");
        else if(e.getSource()==button2)
            textField.setText("2");
        else if(e.getSource()==button3)
            textField.setText("3");
        else if(e.getSource()==button4)
            textField.setText("4");
        else if(e.getSource()==button5)
            textField.setText("5");
        else if(e.getSource()==button6)
            textField.setText("6");
        else if(e.getSource()==button7)
            textField.setText("7");
        else if(e.getSource()==button8)
            textField.setText("8");
        else if(e.getSource()==button9)
            textField.setText("9");
        else if(e.getSource()==button0)
            textField.setText("0");
        else if(e.getSource()==clearButton){
            textField.setText(""); 
            result = 0;
            operation = null;
        }
        else if(e.getSource()==plusButton)
            doAction("+");
        else if(e.getSource()==minusButton)
            doAction("-");
        else if(e.getSource()==multiplyButton)
            doAction("*");
        else if(e.getSource()==divideButton)
            doAction("/");
        else if(e.getSource()==equalButton)
            doAction ("=");
    }
    public static void main(String args[]){
        new Calculator().setVisible(true);
    }
}
import javax.swing.*;
import java.awt.event.*;

public class main {
	
	private JLabel messageLabel1; 
	private JTextField textField1; 
	private JButton button1;

	    public main()
	    {
	    	final int WINDOW_WIDTH = 350, WINDOW_HEIGHT = 200; 
	    	JFrame window = new JFrame("Lab 12"); 
	    	window.setSize(WINDOW_WIDTH,WINDOW_HEIGHT); 
	    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    	window.setLayout(null);
	    	
	    	messageLabel1 = new JLabel("Enter a value in kilometer:"); 
	    	messageLabel1.setSize(200, 30);
	    	messageLabel1.setLocation(50, 50); 
	    	window.add(messageLabel1);
	    	
	    	textField1 = new JTextField(10); 
	    	textField1.setSize(100, 30); 
	    	textField1.setLocation(215, 50); 
	    	window.add(textField1);
	    	
	    	button1 = new JButton("Calculate"); 
	    	button1.setSize(100, 30); 
	    	button1.setLocation(100, 100); 
	    	window.add(button1);
	    	
	    	button1.addActionListener(new Button1Clicked());
	    	
	    	
	        window.setVisible(true);
	    }
	    
	    public static void main(String[] args) 
	    {
	         new main();
	    }
	    
	   
	    private class Button1Clicked implements ActionListener
	    {
	                public void actionPerformed(ActionEvent e)
	                {
	                	
	                	JOptionPane.showMessageDialog(null, Double.parseDouble(textField1.getText())*0.6214 +" miles"); 
	                }
	    }
	    
}
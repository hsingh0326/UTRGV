package Lab13;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class main {
	
	private JLabel messageLabel1;
	private JTextField textField1;
	private JButton button1;
	private String[] columnNames = {"VIN","Brand","Model","Year","Mileage","Price","Color"}; 
	private Object[][] data={{"","","","","","","",}}; 
	private JTable table; 
	private DefaultTableModel dm; 
	private JScrollPane scroll;
	
	
	
	
	Inventory iv = new Inventory();
	
	public main()
	{
		final int WINDOW_WIDTH = 800, WINDOW_HEIGHT = 600;
		JFrame window = new JFrame("LAB 13");
		window.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);
		
		table = new JTable(); 
		dm = new DefaultTableModel(data, columnNames); 
		table.setModel(dm); 
		scroll = new JScrollPane(table); 
		scroll.setSize(700, 270); 
		scroll.setLocation(50, 50); 
		window.add(scroll);
		
		
		messageLabel1 = new JLabel("Brand");
		messageLabel1.setSize(100, 30);
		messageLabel1.setLocation(50, 450);
		window.add(messageLabel1);
		textField1 = new JTextField(10);
		textField1.setSize(100, 30);
		textField1.setLocation(150, 450);
		window.add(textField1);
		button1 = new JButton("Search");
		button1.setSize(100, 30);
		button1.setLocation(100, 400);
		button1.addActionListener(new Button1Clicked());
		window.add(button1);
		
		
		
		window.setVisible(true);
	}
	
	private class Button1Clicked implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (textField1.getText().equals(""))
			{
				try {
					dm.setDataVector(iv.getTable0(), columnNames);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			else
			{
				try {
					dm.setDataVector(iv.getTable(textField1.getText()), columnNames);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			dm.fireTableDataChanged();
		}
	}
	
	public static void main(String[] args) {
		new main();
	}

}

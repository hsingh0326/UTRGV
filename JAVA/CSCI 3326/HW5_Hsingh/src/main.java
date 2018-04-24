// Harsimrajeet Singh
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.SQLException;

public class main extends JFrame
{

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private String[] columnNames = {"VIN","Brand","Model","Year","Mileage","Price","Color"};
	private Object[][] data={{"","","","","","","",}};
	private JTable table;
	private DefaultTableModel dm;
	private JScrollPane scroll;
	private CarInventory ci = new CarInventory();
	public main() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		super("Carmax");
		setSize(800,610);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		table = new JTable();
		dm = new DefaultTableModel(ci.getTable0(), columnNames);
	    table.setModel(dm);
		scroll = new JScrollPane(table);
		scroll.setSize(700, 270);
		scroll.setLocation(50, 50);
		add(scroll);
		
		label1 = new JLabel("VIN");
		label1.setSize(100, 30);
		label1.setLocation(50, 400);
		add(label1);		
		textField1 = new JTextField();
		textField1.setSize(100, 30);
		textField1.setLocation(100, 400);
		add(textField1);
		
		label2 = new JLabel("Brand");
		label2.setSize(100, 30);
		label2.setLocation(50, 450);
		add(label2);		
		textField2 = new JTextField();
		textField2.setSize(100, 30);
		textField2.setLocation(100, 450);
		add(textField2);
		
		label3 = new JLabel("Model");
		label3.setSize(100, 30);
		label3.setLocation(250, 450);
		add(label3);		
		textField3 = new JTextField();
		textField3.setSize(100, 30);
		textField3.setLocation(300, 450);
		add(textField3);		
		
		label4 = new JLabel("Year");
		label4.setSize(100, 30);
		label4.setLocation(450, 450);
		add(label4);		
		textField4 = new JTextField();
		textField4.setSize(100, 30);
		textField4.setLocation(500, 450);
		add(textField4);
		
		label5 = new JLabel("Mileage");
		label5.setSize(100, 30);
		label5.setLocation(50, 500);
		add(label5);		
		textField5 = new JTextField();
		textField5.setSize(100, 30);
		textField5.setLocation(100, 500);
		add(textField5);
		
		label6 = new JLabel("Price");
		label6.setSize(100, 30);
		label6.setLocation(250, 500);
		add(label6);		
		textField6 = new JTextField();
		textField6.setSize(100, 30);
		textField6.setLocation(300, 500);
		add(textField6);		
		
		label7 = new JLabel("Color");
		label7.setSize(100, 30);
		label7.setLocation(450, 500);
		add(label7);		
		textField7 = new JTextField();
		textField7.setSize(100, 30);
		textField7.setLocation(500, 500);
		add(textField7);

		button1 = new JButton("Search");
		button1.setSize(100, 30);
		button1.setLocation(50, 350);
		button1.addActionListener(new Button1Clicked());
		add(button1);
		button2 = new JButton("Delete");
		button2.setSize(100, 30);
		button2.setLocation(200, 350);
		button2.addActionListener(new Button2Clicked());
		add(button2);
		button3 = new JButton("Update");
		button3.setSize(100, 30);
		button3.setLocation(350, 350);
		button3.addActionListener(new Button3Clicked());
		add(button3);
		button4 = new JButton("Add");
		button4.setSize(100, 30);
		button4.setLocation(500, 350);
		button4.addActionListener(new Button4Clicked());
		add(button4);
		setVisible(true);
	}
	private class Button1Clicked implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			try 
			{
				int year, mileage, price;
				
				if(textField4.getText().equals(""))
					year = -1;
				else
					year = Integer.parseInt(textField4.getText());
				
				if(textField5.getText().equals(""))
					mileage = -1;
				else
					mileage = Integer.parseInt(textField5.getText());
				
				if(textField6.getText().equals(""))
					price = -1;
				else
					price = Integer.parseInt(textField6.getText());
				
				dm.setDataVector(ci.getTable2(textField1.getText(),textField2.getText(),textField3.getText(),year,mileage,price,textField7.getText()), columnNames);
				dm.fireTableDataChanged();
			} 
			catch (InstantiationException | IllegalAccessException| ClassNotFoundException | SQLException e) 
			{
				JOptionPane.showMessageDialog(null,"Threw Exception","Error",JOptionPane.ERROR_MESSAGE); 
				e.printStackTrace();
			}
		}
	}
	private class Button2Clicked implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{			
			try 
			{
				if(textField1.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Please enter a VIN","Missing Information",JOptionPane.WARNING_MESSAGE);
				}
				else{
					ci.deleteEntry(textField1.getText());
					dm.setDataVector(ci.getTable0(), columnNames);
					dm.fireTableDataChanged();
				}
			} 
			catch (InstantiationException | IllegalAccessException| ClassNotFoundException | SQLException e) 
			{
				JOptionPane.showMessageDialog(null,"Threw Exception","Error",JOptionPane.ERROR_MESSAGE); 
				e.printStackTrace();
			}
		}
	
	}
	private class Button3Clicked implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			try 
			{
				if(textField1.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Please enter a VIN","Missing Information",JOptionPane.WARNING_MESSAGE);
				}
				else{
					int year, mileage, price;
					
					if(textField4.getText().equals(""))
						year = -1;
					else
						year = Integer.parseInt(textField4.getText());
					
					if(textField5.getText().equals(""))
						mileage = -1;
					else
						mileage = Integer.parseInt(textField5.getText());
					
					if(textField6.getText().equals(""))
						price = -1;
					else
						price = Integer.parseInt(textField6.getText());
					
					ci.updateEntry(textField1.getText(),textField2.getText(),textField3.getText(),year,mileage,price,textField7.getText());
					dm.setDataVector(ci.getTable0(), columnNames);
					dm.fireTableDataChanged();
				}
				
			} 
			catch (InstantiationException | IllegalAccessException| ClassNotFoundException | SQLException e) 
			{
				JOptionPane.showMessageDialog(null,"Threw Exception","Error",JOptionPane.ERROR_MESSAGE); 
				e.printStackTrace();
			}
		}
	}
	private class Button4Clicked implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			try 
			{
				if(textField1.getText().equals("") || textField2.getText().equals("") || textField3.getText().equals("") || textField4.getText().equals("") || textField5.getText().equals("") || textField6.getText().equals("") || textField7.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Please complete all fields","Missing Information",JOptionPane.WARNING_MESSAGE);
				}
				else{
					ci.addEntry(textField1.getText(),textField2.getText(),textField3.getText(),Integer.parseInt(textField4.getText()),Integer.parseInt(textField5.getText()),Integer.parseInt(textField6.getText()),textField7.getText());
					dm.setDataVector(ci.getTable0(), columnNames);
					dm.fireTableDataChanged();
				}				
			} 
			catch (InstantiationException | IllegalAccessException| ClassNotFoundException | SQLException e) 
			{
				JOptionPane.showMessageDialog(null,"Threw Exception","Error",JOptionPane.ERROR_MESSAGE); 
				e.printStackTrace();
			}
		}
	}	
	
	public static void main(String args[]) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		new main();
	}
}

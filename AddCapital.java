import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextField;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class AddCapital {
	
	private ArrayList<String> capitals;
	private ArrayList<String> routes;
	private JFrame frame;
	private JTextField textField;
	public AddCapital( ArrayList<String> capitals, ArrayList<String> routes) {
		this.routes = routes;
		this.capitals = capitals;
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Add Capital ");
		lblNewLabel.setForeground(new Color(0, 153, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(146, 22, 161, 33);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(131, 85, 224, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel(" Capital Name ");
		lblNewLabel_1.setForeground(new Color(0, 153, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(43, 89, 77, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton(" Add Capital ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(check(textField.getText()))
				{
					if(textField.getText() != " ")
					capitals.add(textField.getText());
					JOptionPane.showMessageDialog(frame, "New Capital added");
				}
				else
				{
					JOptionPane.showMessageDialog(frame, textField.getText() + " already in system ");
				}
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 153));
		btnNewButton.setBounds(43, 182, 161, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDeleteCapital = new JButton(" Delete Capital ");
		btnDeleteCapital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					if("Ankara-Tokyo".contains("Ankara"))
						System.out.println("it is contains");
					int index = delete(textField.getText());
					System.out.println(textField.getText());
					if( index >= 0)
					{
						capitals.remove(index);
						routes_remove(textField.getText());
						JOptionPane.showMessageDialog(frame, textField.getText() + " succesfully removed");
					}
					else
						JOptionPane.showMessageDialog(frame, textField.getText() + " is not in the system");
			}
		});
		btnDeleteCapital.setBackground(new Color(255, 0, 51));
		btnDeleteCapital.setBounds(232, 182, 163, 27);
		frame.getContentPane().add(btnDeleteCapital);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	public boolean check(String capital)
	{
		if(capital.isEmpty())
			return false;
		for(int i=0 ; i<capitals.size() ; i++)
		{
			if(capital.equals(capitals.get(i)))
				return false;
		}
		return true;
	}
	public int delete(String capital)
	{
		for(int i=0 ; i<capitals.size() ; i++)
		{
			if(capital.equals(capitals.get(i)))
				return i;
		}
		return -1;
	}
	public void routes_remove(String capital)
	{
		for(int i = 0 ; i<routes.size() ; i++)
		{
			if(routes.get(i).contains(capital))
			{
				System.out.println(routes.get(i));
				routes.remove(i);
				i--;
			}
		}
	}
	public JFrame getFrame() {
		return frame;
	}
}

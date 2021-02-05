import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class Add_route {
	
	private ArrayList<String> capitals;
	private ArrayList<String> routes;
	public JFrame getFrame() {
		return frame;
	}
	private JFrame frame;
	public Add_route(ArrayList<String> capitals , ArrayList<String> routes) {
		this.capitals = capitals;
		this.routes = routes;
		initialize();
	}

	private void initialize() {	
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
	
		JLabel lblNewLabel = new JLabel(" Add New Routes ");
		lblNewLabel.setForeground(new Color(0, 153, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(154, 21, 187, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(new Color(0, 255, 255));
		comboBox.setBounds(103, 115, 102, 27);
		frame.getContentPane().add(comboBox);
		for(int i= 0 ; i<capitals.size() ; i++)
			comboBox.addItem(capitals.get(i));
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBackground(new Color(0, 255, 255));
		comboBox_1.setBounds(332, 115, 102, 27);
		frame.getContentPane().add(comboBox_1);
		for(int i= 0 ; i<capitals.size() ; i++)
			comboBox_1.addItem(capitals.get(i));
		
		JLabel lblNewLabel_1 = new JLabel(" Departure ");
		lblNewLabel_1.setForeground(new Color(0, 153, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(24, 115, 69, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblArrival = new JLabel(" Arrival ");
		lblArrival.setForeground(new Color(0, 153, 255));
		lblArrival.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArrival.setBounds(253, 113, 69, 27);
		frame.getContentPane().add(lblArrival);
		
		JButton btnNewButton = new JButton(" Add Route ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String departure = (String) comboBox.getSelectedItem();
				String arri = (String) comboBox_1.getSelectedItem();
				
				if(check_route(departure,arri))
				{
					JOptionPane.showMessageDialog(frame, "New route added succesfully");
					routes.add(departure+ "-" + arri);
				}
				else
					JOptionPane.showMessageDialog(frame, "Please choose a unique route");
				
				
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 153));
		btnNewButton.setBounds(135, 210, 244, 27);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 524, 343);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		
	}
	public boolean check_route(String departure , String arrival)
		{
			if(departure.equals(arrival))
				return false;
			
			for(int i=0 ; i<routes.size() ; i++)
			{
				String route= departure + "-" + arrival;
				if(route.equals(routes.get(i)))
					return false;
			}
			
			
			return true;
		}
}

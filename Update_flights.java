import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update_flights {

	private JFrame frame;
	private ArrayList<String> booked_flights;
	private String[] array;
	private Update_info update;
	private ArrayList<String> routes;
	private ArrayList<Integer> times;
	private int index1;
	private int[] system_time;
	private Delay delay ;
	public Update_flights(ArrayList<String> booked_flights, ArrayList<String> routes,int[] system_time, ArrayList<Integer> times) {
		this.times = times;
		this.system_time = system_time;
		this.routes = routes;
		this.booked_flights = booked_flights;
		initialize();
	}
	

	private void initialize() {
		
		array = new String[booked_flights.size() / 5];
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 904, 342);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		int j=0;
		for(int i = 0 ; i <booked_flights.size() ; i= i+6)
		{
			array[j] = booked_flights.get(i) + "  " + booked_flights.get(i+1) +"  "+ booked_flights.get(i+2) +"  "+ booked_flights.get(i+3)+ "  "+ booked_flights.get(i+4);
			j++;
		}
		
		JLabel lblNewLabel = new JLabel("  Update Flight Information ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setForeground(new Color(0, 153, 255));
		lblNewLabel.setBounds(303, 22, 246, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Choose Flight ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(new Color(0, 153, 255));
		lblNewLabel_1.setBounds(39, 133, 109, 34);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(new Color(0, 255, 255));
		comboBox.setBounds(169, 137, 699, 29);
		frame.getContentPane().add(comboBox);
		for(int i= 0 ; i<array.length; i++)
			comboBox.addItem(array[i]);
		
		
		JButton btnNewButton = new JButton(" Update ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index1 = find_index((String) comboBox.getSelectedItem());
				update = new Update_info(routes, booked_flights, index1,system_time,times);
				update.getFrame().setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 153));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(86, 229, 213, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete ");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index1 = find_index((String) comboBox.getSelectedItem());
				int index = index1;
				System.out.println(index);
				while(index < index1+6)
				{
					booked_flights.remove(index1);
					index++;
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDelete.setBackground(new Color(255, 0, 51));
		btnDelete.setBounds(364, 229, 213, 29);
		frame.getContentPane().add(btnDelete);
		
		JButton btnNewButton_1 = new JButton(" Set Delay ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index1 = find_index((String) comboBox.getSelectedItem());
				delay  = new Delay(index1,booked_flights,times);
				delay.getFrame().setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBackground(new Color(255, 0, 51));
		btnNewButton_1.setBounds(630, 229, 213, 29);
		frame.getContentPane().add(btnNewButton_1);
	}

	public int find_index(String selected)
	{
		for(int i=0 ; i<array.length ; i++)
		{
			if(selected.equals(array[i]))
				return (6*i);
		}
		return -1;
	}
	public JFrame getFrame() {
		return frame;
	}
}

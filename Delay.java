import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class Delay {

	private JFrame frame;
	private int index;
	private ArrayList<String> booked_flights;
	private ArrayList<Integer> times;
	private int delay;
	public Delay(int index , ArrayList<String> booked_flights,ArrayList<Integer> times) {
		this.times = times;
		this.booked_flights = booked_flights;
		this.index = index;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 379, 297);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Set  Delay ");
		lblNewLabel.setForeground(new Color(0, 153, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(107, 24, 164, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox<Integer> comboBox = new JComboBox<Integer>();
		comboBox.setBackground(new Color(0, 255, 255));
		comboBox.setBounds(132, 111, 142, 28);
		frame.getContentPane().add(comboBox);
		for(int i= 0; i<59 ; i++)
			comboBox.addItem(i);
		
		JLabel lblNewLabel_1 = new JLabel("Delay Time ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(0, 153, 255));
		lblNewLabel_1.setBounds(36, 111, 75, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton(" Add Delay ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delay = (int) comboBox.getSelectedItem();
				booked_flights.set(index+5 ,"Delay : "+delay + " mins \n\n");
				int time_index = (index/6) * 10; 
				increase_time(time_index);
				increase_time(time_index+5);
				JOptionPane.showMessageDialog(frame, delay  + " mins delay added to the flight , flight will departure delayed and arrive delayed");
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 51));
		btnNewButton.setBounds(95, 187, 176, 21);
		frame.getContentPane().add(btnNewButton);
	}
	public JFrame getFrame() {
		return frame;
	}
	
	public void increase_time(int index)
	{
		times.set(index+4, times.get(index+4) + delay);
				
				if(times.get(index+4) == 60)
				{
					times.set(index+4, 0);
					times.set(index+3,times.get(index+3)+1);
				}
				if(times.get(index+3) == 24)
				{
					times.set(index+2,times.get(index+2)+1);
					times.set(index+3, 0);
				}
				if(times.get(index+2) == 31)
				{
					times.set(index+1,times.get(index+1)+1);
					times.set(index+2, 1);
				}
				if(times.get(index+1) == 13)
				{
					times.set(index,times.get(index)+1);
					times.set(index+1, 1);
				}
	}
}

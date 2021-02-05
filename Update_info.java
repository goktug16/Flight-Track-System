import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("unused")
public class Update_info {

	private JFrame frame;
	private ArrayList<String> routes;
	private ArrayList<String> booked_flightes;
	private ArrayList<Integer> times;
	private int index;
	private int[] system_time;
	public Update_info(ArrayList<String> routes , ArrayList<String> booked_flights , int index,int[] system_time,ArrayList<Integer> times) {
		this.times = times;
		this.system_time= system_time;
		this.index = index;
		this.routes = routes;
		this.booked_flightes = booked_flights;
		initialize();
	}
	private void initialize() {
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		ArrayList<Integer> selected_items = new ArrayList <Integer>();
		String[] airlines = {"Qatar Airways" , "Singapore Airways" , "Emirates" , "Turkish Airlines" , "Lufthansa" ,"Japan Airlines"};
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 657, 475);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book a Flight ");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel.setForeground(new Color(51, 153, 255));
		lblNewLabel.setBounds(194, 22, 221, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Update Flight");
		btnNewButton.setBackground(new Color(0, 255, 153));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(154, 376, 253, 31);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Route  ");
		lblNewLabel_1.setForeground(new Color(51, 153, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_1.setBounds(48, 95, 87, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(new Color(51, 255, 255));
		comboBox.setBounds(133, 96, 163, 31);
		frame.getContentPane().add(comboBox);
		for(int i=0 ; i< routes.size() ; i++)
			comboBox.addItem(routes.get(i));
		
		JLabel lblNewLabel_2 = new JLabel("Departure Time ");
		lblNewLabel_2.setForeground(new Color(51, 153, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_2.setBounds(10, 193, 105, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox<Integer> comboBox_1 = new JComboBox<Integer>();
		comboBox_1.setBackground(new Color(51, 255, 255));
		comboBox_1.setBounds(133, 193, 73, 21);
		frame.getContentPane().add(comboBox_1);
		for(int i = 1 ; i<=30 ; i++)
			comboBox_1.addItem(i);
		
		JComboBox<Integer> comboBox_2 = new JComboBox<Integer>();
		comboBox_2.setBackground(new Color(51, 255, 255));
		comboBox_2.setBounds(216, 193, 73, 21);
		frame.getContentPane().add(comboBox_2);
		for(int i = 1 ; i<=12 ; i++)
			comboBox_2.addItem(i);
		
		JComboBox<Integer> comboBox_3 = new JComboBox<Integer>();
		comboBox_3.setBackground(new Color(51, 255, 255));
		comboBox_3.setBounds(298, 193, 69, 21);
		frame.getContentPane().add(comboBox_3);
		for(int i= 2003; i<2023 ;i++)
			comboBox_3.addItem(i);
		
		JComboBox<Integer> comboBox_4 = new JComboBox<Integer>();
		comboBox_4.setBackground(new Color(51, 255, 255));
		comboBox_4.setBounds(377, 193, 73, 21);
		frame.getContentPane().add(comboBox_4);
		for(int i = 1 ; i<=24 ; i++)
			comboBox_4.addItem(i);
		
		JComboBox<Integer> comboBox_5 = new JComboBox<Integer>();
		comboBox_5.setBackground(new Color(51, 255, 255));
		comboBox_5.setBounds(460, 193, 73, 21);
		frame.getContentPane().add(comboBox_5);
		for(int i = 0 ; i<=59 ; i++)
			comboBox_5.addItem(i);
		
		JLabel lblNewLabel_3 = new JLabel(" Day ");
		lblNewLabel_3.setForeground(new Color(51, 153, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_3.setBounds(133, 170, 45, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblMonth = new JLabel(" Month ");
		lblMonth.setForeground(new Color(51, 153, 255));
		lblMonth.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblMonth.setBounds(216, 170, 45, 13);
		frame.getContentPane().add(lblMonth);
		
		JLabel lblYear = new JLabel(" Year ");
		lblYear.setForeground(new Color(51, 153, 255));
		lblYear.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblYear.setBounds(298, 170, 45, 13);
		frame.getContentPane().add(lblYear);
		
		JLabel lblHour = new JLabel(" Hour ");
		lblHour.setForeground(new Color(51, 153, 255));
		lblHour.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblHour.setBounds(377, 170, 45, 13);
		frame.getContentPane().add(lblHour);
		
		JLabel lblMinute = new JLabel(" Minute ");
		lblMinute.setForeground(new Color(51, 153, 255));
		lblMinute.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblMinute.setBounds(460, 170, 45, 13);
		frame.getContentPane().add(lblMinute);
		
		JLabel lblArrivalTime = new JLabel("Arrival Time ");
		lblArrivalTime.setForeground(new Color(51, 153, 255));
		lblArrivalTime.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblArrivalTime.setBounds(10, 241, 105, 25);
		frame.getContentPane().add(lblArrivalTime);
		
		JLabel lblChooseAirline = new JLabel("Choose Airline ");
		lblChooseAirline.setForeground(new Color(51, 153, 255));
		lblChooseAirline.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblChooseAirline.setBounds(10, 284, 105, 25);
		frame.getContentPane().add(lblChooseAirline);
		
		JLabel lblFlightNumber = new JLabel("Flight Number ");
		lblFlightNumber.setForeground(new Color(51, 153, 255));
		lblFlightNumber.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblFlightNumber.setBounds(302, 284, 105, 25);
		frame.getContentPane().add(lblFlightNumber);
		
		JLabel label = new JLabel(" Day ");
		label.setForeground(new Color(51, 153, 255));
		label.setFont(new Font("Tahoma", Font.ITALIC, 10));
		label.setBounds(133, 224, 45, 13);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(" Month ");
		label_1.setForeground(new Color(51, 153, 255));
		label_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		label_1.setBounds(216, 224, 45, 13);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel(" Year ");
		label_2.setForeground(new Color(51, 153, 255));
		label_2.setFont(new Font("Tahoma", Font.ITALIC, 10));
		label_2.setBounds(298, 224, 45, 13);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel(" Hour ");
		label_3.setForeground(new Color(51, 153, 255));
		label_3.setFont(new Font("Tahoma", Font.ITALIC, 10));
		label_3.setBounds(387, 224, 45, 13);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel(" Minute ");
		label_4.setForeground(new Color(51, 153, 255));
		label_4.setFont(new Font("Tahoma", Font.ITALIC, 10));
		label_4.setBounds(460, 224, 45, 13);
		frame.getContentPane().add(label_4);
		
		JComboBox<Integer> comboBox_6 = new JComboBox<Integer>();
		comboBox_6.setBackground(new Color(51, 255, 255));
		comboBox_6.setBounds(133, 244, 73, 21);
		frame.getContentPane().add(comboBox_6);
		for(int i = 1 ; i<=30 ; i++)
			comboBox_6.addItem(i);
		
		
		JComboBox<Integer> comboBox_7 = new JComboBox<Integer>();
		comboBox_7.setBackground(new Color(51, 255, 255));
		comboBox_7.setBounds(216, 244, 73, 21);
		frame.getContentPane().add(comboBox_7);
		for(int i = 1 ; i<=12 ; i++)
			comboBox_7.addItem(i);
		
		
		JComboBox<Integer> comboBox_8 = new JComboBox<Integer>();
		comboBox_8.setBackground(new Color(51, 255, 255));
		comboBox_8.setBounds(298, 244, 73, 21);
		frame.getContentPane().add(comboBox_8);
		for(int i= 2003; i<2023 ;i++)
			comboBox_8.addItem(i);
		
		
		JComboBox<Integer> comboBox_9 = new JComboBox<Integer>();
		comboBox_9.setBackground(new Color(51, 255, 255));
		comboBox_9.setBounds(377, 244, 73, 21);
		frame.getContentPane().add(comboBox_9);
		for(int i = 1 ; i<24 ; i++)
			comboBox_9.addItem(i);
		
		JComboBox<Integer> comboBox_10 = new JComboBox<Integer>();
		comboBox_10.setBackground(new Color(51, 255, 255));
		comboBox_10.setBounds(460, 244, 73, 21);
		frame.getContentPane().add(comboBox_10);
		for(int i = 0 ; i<=59 ; i++)
			comboBox_10.addItem(i);
		
		JComboBox<String> comboBox_11 = new JComboBox<String>();
		comboBox_11.setBackground(new Color(51, 255, 255));
		comboBox_11.setBounds(133, 287, 145, 21);
		frame.getContentPane().add(comboBox_11);
		for(int i= 0 ; i < 6 ; i++)
			comboBox_11.addItem(airlines[i]);
		
		JComboBox<String> comboBox_12 = new JComboBox<String>();
		comboBox_12.setBackground(new Color(51, 255, 255));
		comboBox_12.setBounds(405, 287, 128, 21);
		frame.getContentPane().add(comboBox_12);
		for(int i = 100 ; i< 120 ; i++)
			comboBox_12.addItem("YTU  " + i);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				System.out.println("start");
					selected_items.add(0,(Integer) comboBox_3.getSelectedItem());
					
					selected_items.add(1,(Integer) comboBox_2.getSelectedItem());
					selected_items.add(2,(Integer) comboBox_1.getSelectedItem());
					
					selected_items.add(3,(Integer) comboBox_4.getSelectedItem());
					selected_items.add(4,(Integer) comboBox_5.getSelectedItem());
					
					selected_items.add(5,(Integer) comboBox_8.getSelectedItem());
					selected_items.add(6,(Integer) comboBox_7.getSelectedItem());
					selected_items.add(7,(Integer) comboBox_6.getSelectedItem());
					
					selected_items.add(8,(Integer) comboBox_9.getSelectedItem());
					selected_items.add(9,(Integer) comboBox_10.getSelectedItem());
					
					String air = (String) comboBox_11.getSelectedItem();
					String flight_number = "Flight Number: " + (String) comboBox_12.getSelectedItem() + "  ";
					String route  = "Route: " +(String) comboBox.getSelectedItem() +"  ";
					int number = index/6;
					int start_i = number*10;
					if(check_valid(selected_items))
					{
						String departure = "Departure time: "+selected_items.get(2)+"/"+selected_items.get(1)+"/"+selected_items.get(0) + "    " + selected_items.get(3)+":"+selected_items.get(4)+"\n";
						String arrival ="Arrival time: "+selected_items.get(7)+"/"+selected_items.get(6)+"/"+selected_items.get(5) + "    " + selected_items.get(8)+":"+selected_items.get(9)+"\n";
						System.out.println(index);
						booked_flightes.set(index,route);
						booked_flightes.set(index+1,flight_number);
						booked_flightes.set(index+2,air);
						booked_flightes.set(index+3,departure);
						booked_flightes.set(index+4,arrival);
						booked_flightes.set(index+5,"\n");
						
						times.set(start_i, (Integer) comboBox_3.getSelectedItem());
						times.set(start_i+1, (Integer) comboBox_2.getSelectedItem());
						times.set(start_i+2, (Integer) comboBox_1.getSelectedItem());
						times.set(start_i+3, (Integer) comboBox_4.getSelectedItem());
						times.set(start_i+4, (Integer) comboBox_5.getSelectedItem());
						times.set(start_i+5, (Integer) comboBox_8.getSelectedItem());
						times.set(start_i+6, (Integer) comboBox_7.getSelectedItem());
						times.set(start_i+7, (Integer) comboBox_6.getSelectedItem());
						times.set(start_i+8, (Integer) comboBox_9.getSelectedItem());
						times.set(start_i+9, (Integer) comboBox_10.getSelectedItem());
						JOptionPane.showMessageDialog(frame, "Your flight information succesfully updated");
					}
					else
						JOptionPane.showMessageDialog(frame, "Choose a proper departure or arrival time according to system time and departure time");
				
			}
		});
		
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public boolean check_valid(ArrayList<Integer> selected_items )
	{	
		int[] departure = new int[5];
		int[] arrival = new int[5];
		
		for(int i=0 ; i<5 ; i++)
			departure[i] = selected_items.get(i);
		for(int i=0 ; i<5 ; i++)
			arrival[i] = selected_items.get(i+5);
		
	
		
		if(arrival[0] < departure[0])
			return false;
		else if( arrival[1] < departure [1]  && arrival[0] == departure[0])
			return false;
		else if( arrival[2] < departure [2]  && arrival[1] == departure[1] && arrival[0] == departure[0])
			return false;
		else if( arrival[3] < departure [3]  && arrival[2] == departure[2] && arrival[1] == departure[1]&& arrival[0] == departure[0])
			return false;
		else if( arrival[4] <= departure [4]  && arrival[3] == departure[3] && arrival[2] == departure[2] && arrival[1] == departure[1]&& arrival[0] == departure[0])
			return false;
		if(departure[0] < system_time[0])
			return false;
		else if( departure[1] < system_time [1]  && departure[0] == system_time[0])
			return false;
		else if( departure[2] < system_time [2]  && departure[1] == system_time[1] && departure[0] == system_time[0])
			return false;
		else if( departure[3] < system_time [3]  && departure[2] == system_time[2] && departure[1] == system_time[1]&& departure[0] == system_time[0])
			return false;
		else if( departure[4] <= system_time [4]  && departure[3] == system_time[3] && departure[2] == system_time[2] && departure[1] == system_time[1]&& departure[0] == system_time[0])
			return false;
		
		return true;
	}
}

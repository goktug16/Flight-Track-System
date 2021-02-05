import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class MainScreen {

	private JFrame frame;
	int[] system_time = new int[5];
	ArrayList<String> routes = new ArrayList<String>();
	ArrayList<Integer> times = new ArrayList<Integer>();
	ArrayList<String>  capitals = new ArrayList<String>();
	ArrayList<String> booked_flights = new ArrayList<String>();
	static ArrayList<String> files = new ArrayList<String>();
	private BookFlight flights;
	private Add_route add_new;
	private AddCapital add_cap;
	private Show_booked booked;
	private Delete_route delete;
	private Update_flights update;
	private static boolean set = true;
	public static boolean pause = false;
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		try {
				MainScreen window = new MainScreen();
				window.frame.setVisible(true);	
				JOptionPane.showMessageDialog(window.getFrame(), "System date will be adjust after pressing 'Book a Flight' button so adjust system time before book a flight \n" + "You need to do all your works (Book flight,delete/add route,delete/add capitals, cancel/update/delay flights ...) before hitting start button.\n"
				+ "After starting system , you can pause the system with 'pause' button and resume with 'resume button'. \n"+
				"'Pause' button will stop system time , you can continue flights after pressin 'resume' button.\n"+
				"'Stop' button kills the system.\n" + "Adjust system date before starting system, its allowed the change after start ,but it will cause errors. \n"
				+ "After you update/cancel/delay some flight you can see the result by pressing show booked flights button(if its already open close and open again please).\n"
				+ "When you press stop button all finished flights information will be write into 'Flight Informations.txt' . \n "+
				"If you add new flights after pressing 'pause' button , those flights should be after the system current time otherwise, it will not occure as a thread ");
				int i=0;
				ExecutorService executor  = Executors.newCachedThreadPool();
				while(set)  // before hitting start
					Thread.sleep(1000);
				int c=0;
				while(set == false )
				{
					Thread.sleep(1000);
					while(pause)
					{
						Thread.sleep(1000);
						if(c==0)
							JOptionPane.showMessageDialog(window.getFrame(), "System paused, press resume button to continue " );
						c++;
					}
					window.increase_system();
						
					for(int j=0 ; j<window.booked_flights.size() / 6 ; j++)
					{
						i = j*10;
						if(window.times.get(i) == window.system_time[0] && window.times.get(i+1) == window.system_time[1] )
							if(window.times.get(i+2) == window.system_time[2] && window.times.get(i+3) == window.system_time[3] )
								if(window.times.get(i+4) == window.system_time[4] ) {
									executor.execute(new Flight(window.files,window.times, window.booked_flights, j,window.booked_flights.get(j*6),window.booked_flights.get((j*6)+1)));
								}
						
					}
					for(int f=0 ; f<window.system_time.length ; f++)
							System.out.print(window.system_time[f] + "  ");
						System.out.println();				
				}
				executor.shutdown();
				
				String[] write = new String[files.size()];
				String s="";
				
				for(int a = 0; a<files.size() ; a++)
					write[a] = files.get(a);
					
				File file_new = new File("java_testworks.txt");
					
				try {
					file_new.createNewFile();
				} catch (IOException e1) {
					System.err.println(e1);
					e1.printStackTrace();
				}	
					
				char[] array = new char[files.size() * 400];
				for(String a : write)
					s+=a;
				
				array = s.toCharArray();
					
				try {
					FileWriter fw = new FileWriter("Flight Informations.txt");
					fw.write(array);
					fw.close();
				}
				catch(Exception e)
				{
						System.out.println(e);
				}
				
				
				JOptionPane.showMessageDialog(window.getFrame(), "System is finished , all flight informations saved into Flight Informations.txt file ,if you want to add new flights you need to run program again. " );
	} catch (Exception e) {
					e.printStackTrace();
	}
			
	}
	
	
	public static boolean isPause() {
		return pause;
	}


	public MainScreen() {
		String[] caps = {"Ankara" , "Paris" , "Tokyo" , "Washington" , "Istanbul" ,"Tripoli"};
		for(int i = 0 ; i < 5 ; i++)
		{
			routes.add(caps[i] + "-" + caps[i+1] );
			if(i + 2 <= 5)
				routes.add(caps[0] + "-" + caps[2+i]);
		}
		for(int i = 5 ; i > 0 ; i--)
			routes.add(caps[i] + "-" + caps[i-1] );
		
		for(int i = 0 ; i < 6 ; i++)
			capitals.add(caps[i]);
		
		
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 632, 611);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  Flight Tracker ");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 32));
		lblNewLabel.setForeground(new Color(51, 153, 255));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(186, 26, 246, 59);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox<Integer> comboBox = new JComboBox<Integer>();
		comboBox.setBackground(new Color(51, 255, 255));
		comboBox.setBounds(168, 147, 64, 30);
		frame.getContentPane().add(comboBox);
		for(int i = 1 ; i<=30 ; i++)
			comboBox.addItem(i);
		
		JComboBox<Integer> comboBox_1 = new JComboBox<Integer>();
		comboBox_1.setBackground(new Color(51, 255, 255));
		comboBox_1.setBounds(242, 147, 64, 30);
		frame.getContentPane().add(comboBox_1);
		for(int i = 1 ; i<=12 ; i++)
			comboBox_1.addItem(i);
		
		JComboBox<Integer> comboBox_2 = new JComboBox<Integer>();
		comboBox_2.setBackground(new Color(51, 255, 255));
		comboBox_2.setBounds(316, 147, 64, 30);
		frame.getContentPane().add(comboBox_2);
		for(int i= 2003; i<2023 ;i++)
			comboBox_2.addItem(i);
		
		JLabel lblNewLabel_1 = new JLabel("Adjust System Date");
		lblNewLabel_1.setForeground(new Color(51, 51, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(30, 140, 147, 41);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" Day");
		lblNewLabel_2.setForeground(new Color(51, 51, 255));
		lblNewLabel_2.setBounds(168, 117, 64, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblMonth = new JLabel(" Month");
		lblMonth.setForeground(new Color(51, 51, 255));
		lblMonth.setBounds(242, 117, 64, 13);
		frame.getContentPane().add(lblMonth);
		
		JLabel lblYear = new JLabel(" Year");
		lblYear.setForeground(new Color(51, 51, 255));
		lblYear.setBounds(316, 117, 64, 13);
		frame.getContentPane().add(lblYear);
		
		JComboBox<Integer> comboBox_3 = new JComboBox<Integer>();
		comboBox_3.setBackground(new Color(51, 255, 255));
		comboBox_3.setBounds(390, 147, 64, 30);
		frame.getContentPane().add(comboBox_3);
		for(int i = 1 ; i<24 ; i++)
			comboBox_3.addItem(i);
		
		JComboBox<Integer> comboBox_4 = new JComboBox<Integer>();
		comboBox_4.setBackground(new Color(51, 255, 255));
		comboBox_4.setBounds(464, 147, 64, 30);
		frame.getContentPane().add(comboBox_4);
		for(int i = 0 ; i<=59 ; i++)
			comboBox_4.addItem(i);
		
		JLabel lblHour = new JLabel(" Hour");
		lblHour.setForeground(new Color(51, 51, 255));
		lblHour.setBounds(390, 117, 64, 13);
		frame.getContentPane().add(lblHour);
		
		JLabel lblMinute = new JLabel(" Minute");
		lblMinute.setForeground(new Color(51, 51, 255));
		lblMinute.setBounds(464, 117, 64, 13);
		frame.getContentPane().add(lblMinute);
		
		JButton btnNewButton = new JButton(" Book a Flight ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						system_time[2] = (int) comboBox.getSelectedItem();   // do this with button 
						system_time[1] = (int) comboBox_1.getSelectedItem();
						system_time[0] = (int) comboBox_2.getSelectedItem();
						system_time[3] = (int) comboBox_3.getSelectedItem();
						system_time[4] = (int) comboBox_4.getSelectedItem();
						flights = new BookFlight(routes,booked_flights,system_time,times);
						flights.getFrame().setVisible(true);
			}		
		});		
						
		btnNewButton.setBackground(new Color(0, 255, 153));
		btnNewButton.setBounds(60, 260, 214, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAddNewRoute = new JButton(" Add new Routes ");
		btnAddNewRoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					add_new = new Add_route(capitals,routes);
					add_new.getFrame().setVisible(true);
			}
		});
		btnAddNewRoute.setBackground(new Color(0, 255, 153));
		btnAddNewRoute.setBounds(337, 260, 214, 30);
		frame.getContentPane().add(btnAddNewRoute);
		
		JButton btnAddCapital= new JButton(" Add/Delete Capital ");
		btnAddCapital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_cap = new AddCapital(capitals,routes);
				add_cap.getFrame().setVisible(true);
			}
		});
		btnAddCapital.setBackground(new Color(0, 255, 153));
		btnAddCapital.setBounds(60, 329, 214, 30);
		frame.getContentPane().add(btnAddCapital);
		
		JButton btnShowBookedFlights = new JButton(" Show Booked Flights ");
		btnShowBookedFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				booked = new Show_booked(booked_flights);
				booked.getFrame().setVisible(true);
				for(int i=0 ; i<times.size() ; i++)
					System.out.println(times.get(i));
			}
		});
		btnShowBookedFlights.setBackground(new Color(0, 255, 153));
		btnShowBookedFlights.setBounds(337, 329, 214, 30);
		frame.getContentPane().add(btnShowBookedFlights);
		
		JButton btnDeleteARoute = new JButton(" Delete a Route ");
		btnDeleteARoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete = new Delete_route(routes);
				delete.getFrame().setVisible(true);
			}
		});
		btnDeleteARoute.setBackground(new Color(0, 255, 153));
		btnDeleteARoute.setBounds(60, 395, 214, 30);
		frame.getContentPane().add(btnDeleteARoute);
		
		JButton btnUpdateFlightInformation = new JButton("Delay/Update/Cancel Flight   ");
		btnUpdateFlightInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update = new Update_flights(booked_flights,routes,system_time,times);
				update.getFrame().setVisible(true);			}
		});
		btnUpdateFlightInformation.setBackground(new Color(0, 255, 153));
		btnUpdateFlightInformation.setBounds(337, 395, 214, 30);
		frame.getContentPane().add(btnUpdateFlightInformation);
		
		JButton btnNewButton_1 = new JButton(" Start ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				set = false;
			}
		});
		btnNewButton_1.setBackground(new Color(0, 255, 102));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(44, 523, 147, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnPause = new JButton(" Pause ");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pause = true;
			}
		});
		btnPause.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPause.setBackground(new Color(255, 0, 51));
		btnPause.setBounds(136, 461, 138, 30);
		frame.getContentPane().add(btnPause);
		
		JButton btnNewButton_2 = new JButton(" Resume ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pause = false ;
			}
		});
		btnNewButton_2.setBackground(new Color(0, 255, 102));
		btnNewButton_2.setBounds(337, 462, 138, 30);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton(" Stop ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				set = true;
			}
		});
		btnNewButton_3.setBackground(new Color(255, 0, 51));
		btnNewButton_3.setBounds(432, 523, 147, 30);
		frame.getContentPane().add(btnNewButton_3);
		
		
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void increase_system()
	{
		system_time[4]++;
		
		if(system_time[4] == 60)
		{
			system_time[4] = 0;
			system_time[3]++;
		}
		if(system_time[3] == 24)
		{
			system_time[2]++;
			system_time[3] = 0;
		}
		if(system_time[2] == 31)
		{
			system_time[1]++;
			system_time[2] = 1;
		}
		if(system_time[1] == 13)
		{
			system_time[0]++;
			system_time[1] = 1;
		}	
	}
}

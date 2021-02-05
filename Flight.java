import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class Flight implements Runnable {

	private JFrame frame;
	ArrayList<Integer> times;
	ArrayList<String> booked_flights;
	ArrayList<String> files;
	//MainScreen window;
	int b_index;
	String departure ="";
	String arrival = "";
	String route ;
	String number;
	boolean permission = false;
	public Flight(ArrayList<String> files,ArrayList<Integer> times, ArrayList<String> booked_flights,int index,String route,String number) {
		//this.window= window;
		this.files = files;
		this.number = number;
		this.route = route;
		this.times =times;
		this.booked_flights = booked_flights;
		this.b_index = index;
		initialize();
	}
	public void run()
	{
		//System.out.println(MainScreen.pause);
		int test_index= b_index*6;
		route=booked_flights.get(test_index);
		String fli_info = booked_flights.get(test_index+1);
		String air = booked_flights.get(test_index+2);
		
		
		
		int time_spent = 0;
		try {
			 set_dep_ar();
			 time_spent = time_s();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			System.out.println("time spent in min : " +time_s());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			for(int c = 0 ; c<time_spent ; c++)
			{
				Thread.sleep(1000);
				while(MainScreen.pause)
				{
					Thread.sleep(1000);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while(permission == false)
		{
			try {
				frame.setVisible(true);
				increase_time();
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		set_dep_ar();
		
		files.add("Route : "+route + "\n");
		files.add("Flight Number :" + fli_info +"\n");
		files.add("Airline : "+air +" \n ");
		files.add("Scheduled " + booked_flights.get(test_index+3));
		files.add("Scheduled " + booked_flights.get(test_index+4));
		files.add("Take Off time  :" + departure + "\n");
		files.add("Landing time  :" + arrival + "\n");
		files.add(booked_flights.get(test_index+5));
		files.add("\n");
		
	}
	public void set_dep_ar()
	{
		departure="";
		arrival="";
		int times_index = b_index *10;
		for(int i=0 ; i<3; i++)
		{
			departure += times.get(times_index+i).toString();
			arrival += times.get(times_index+i+5).toString();
			if(i != 2)
			{
				departure += "/";
				arrival += "/";
			}
		}
		departure += " ";
		arrival +=" ";
		for(int i=3; i<5; i++)
		{
			
			if(i == 4)
			{
				departure += ":";
				arrival += ":";
			}
			departure += times.get(times_index+i).toString();
			arrival += times.get(times_index+i+5).toString();
			
		}
	}
	public int time_s() throws ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm");  

		Date dateObj1 = format.parse(departure);
		Date dateObj2 = format.parse(arrival);
		
		long diff = dateObj2.getTime() - dateObj1.getTime();
		int diffmin = (int) (diff / (60 * 1000));
		
		return diffmin;
	}
	public void increase_time()
	{
		
		int index = b_index*10;
		index +=5;
		times.set(index+4, times.get(index+4) + 1);
				
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
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 824, 265);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(route + "  "+ number  +" flight wait tower permission to land ");
		lblNewLabel.setForeground(new Color(0, 153, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(47, 25, 709, 57);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("  Give Permission ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				permission = true;
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 51));
		btnNewButton.setBounds(144, 115, 253, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(" Wait ");
		btnNewButton_1.setBackground(new Color(255, 0, 51));
		btnNewButton_1.setBounds(484, 115, 234, 29);
		frame.getContentPane().add(btnNewButton_1);
	}
}

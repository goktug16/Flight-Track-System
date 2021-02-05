import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Color;
import java.awt.Rectangle;

@SuppressWarnings("unused")
public class Show_booked {

	private JFrame frame;
	private ArrayList<String> booked_flights;
	public Show_booked(ArrayList<String> booked_flights) {
		this.booked_flights = booked_flights;
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 447, 376);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 402, 319);
		String [] items = new String[30];
		String info;
		for(int i =0 ; i<booked_flights.size() ; i++) {
			info =booked_flights.get(i);
			items[i] = info;
		}
		
		JList<String> list = new JList<String>(items);
	
		frame.getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(new Rectangle(10,10, 400, 400));
		scrollPane.setBackground(new Color(51, 153, 255));
		panel.add(scrollPane);
		
			
	}
	public JFrame getFrame() {
		return frame;
	}
}

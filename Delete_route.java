import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete_route {

	private JFrame frame;
	private ArrayList<String> routes;

	public Delete_route(ArrayList<String> routes) {
		this.routes = routes;
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" Delete Route ");
		lblNewLabel_1.setForeground(new Color(0, 153, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(137, 22, 198, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Select Route ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setForeground(new Color(0, 153, 255));
		lblNewLabel.setBounds(75, 103, 92, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(new Color(0, 255, 255));
		comboBox.setBounds(181, 104, 154, 33);
		frame.getContentPane().add(comboBox);
		for(int i = 0 ; i<routes.size() ; i++)
			comboBox.addItem(routes.get(i));
		
		JButton btnNewButton = new JButton(" Delete ");
		btnNewButton.setBackground(new Color(255, 0, 51));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String route = (String) comboBox.getSelectedItem();
				routes.remove(route);
				JOptionPane.showMessageDialog(frame, route + " succesfully removed");
			}
		});
		btnNewButton.setBounds(114, 184, 209, 33);
		frame.getContentPane().add(btnNewButton);
	}
	public JFrame getFrame() {
		return frame;
	}
}

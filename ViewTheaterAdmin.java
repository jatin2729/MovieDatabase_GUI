import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewTheaterAdmin extends JFrame {

	private JPanel contentPane;
	static String xtheater;
	static String ytheater;
	static String addtheater;
	static String phTheater;
	static String addTheater;
	static String titleTheater;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTheaterAdmin frame = new ViewTheaterAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewTheaterAdmin() {
		setTitle("Theater");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 793, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Theater Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(67, 58, 149, 25);
		contentPane.add(lblNewLabel);

		JLabel lblTheater = new JLabel(titleTheater);
		lblTheater.setForeground(Color.RED);
		lblTheater.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTheater.setBounds(231, 58, 317, 25);
		contentPane.add(lblTheater);

		JLabel lblStreetAdd = new JLabel("Address:");
		lblStreetAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStreetAdd.setBounds(128, 99, 88, 25);
		contentPane.add(lblStreetAdd);

		JLabel lblAdd = new JLabel(addTheater);
		lblAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAdd.setBounds(231, 99, 229, 83);
		contentPane.add(lblAdd);

		JLabel lblPhoneNo = new JLabel("Phone No:");
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPhoneNo.setBounds(113, 192, 103, 25);
		contentPane.add(lblPhoneNo);

		JLabel label = new JLabel(phTheater);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(231, 196, 229, 25);
		contentPane.add(label);

		JLabel lblCordinates = new JLabel("Cordinates:");
		lblCordinates.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCordinates.setBounds(101, 247, 115, 25);
		contentPane.add(lblCordinates);

		JLabel lblfsf = new JLabel("X:");
		lblfsf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblfsf.setBounds(231, 251, 21, 25);
		contentPane.add(lblfsf);

		JLabel lblsefs = new JLabel("Y:");
		lblsefs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblsefs.setBounds(231, 285, 21, 25);
		contentPane.add(lblsefs);

		JLabel lblX = new JLabel(xtheater);
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblX.setBounds(253, 251, 57, 25);
		contentPane.add(lblX);

		JLabel lblY = new JLabel(ytheater);
		lblY.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblY.setBounds(253, 288, 67, 25);
		contentPane.add(lblY);
	}
}

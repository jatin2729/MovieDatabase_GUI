import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewTheater extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTheater frame = new ViewTheater();
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
	public ViewTheater() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Information");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Times New Roman", Font.BOLD, 28));
		label.setBounds(243, 16, 221, 36);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Location:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(88, 201, 72, 33);
		contentPane.add(label_1);

		JLabel lblStreetAdd = new JLabel("Street Address:");
		lblStreetAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStreetAdd.setBounds(35, 128, 125, 33);
		contentPane.add(lblStreetAdd);

		JLabel label_4 = new JLabel("Distance:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_4.setBounds(88, 244, 72, 33);
		contentPane.add(label_4);

		JLabel lblTheaterName = new JLabel("Theater Name:");
		lblTheaterName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTheaterName.setBounds(35, 79, 119, 33);
		contentPane.add(lblTheaterName);

		JLabel lblX = new JLabel((String) null);
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblX.setBounds(198, 204, 38, 27);
		contentPane.add(lblX);

		JLabel label_6 = new JLabel("X:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_6.setBounds(175, 201, 22, 33);
		contentPane.add(label_6);

		JLabel label_7 = new JLabel("Y:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_7.setBounds(281, 201, 22, 33);
		contentPane.add(label_7);

		JLabel lblY = new JLabel((String) null);
		lblY.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblY.setBounds(303, 204, 38, 27);
		contentPane.add(lblY);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(169, 82, 230, 27);
		contentPane.add(lblNewLabel);

		JLabel lbladdress = new JLabel("New label");
		lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbladdress.setBounds(166, 135, 367, 27);
		contentPane.add(lbladdress);

		JLabel lblContact = new JLabel("Contact:");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContact.setBounds(88, 165, 69, 20);
		contentPane.add(lblContact);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(167, 168, 147, 20);
		contentPane.add(lblNewLabel_1);
	}
}

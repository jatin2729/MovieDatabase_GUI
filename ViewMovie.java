import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewMovie extends JFrame {

	private JPanel contentPane;
	static String movie_title4;
	static String y3;
	static String x3;
	static String rating4;
	static String genre4;
	static String theater4;
	static String showtime4;
	static String distance4;
	static String ddate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMovie frame = new ViewMovie();
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
	public ViewMovie() {
		setTitle("Movie Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 982, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel(movie_title4);
		lblTitle.setForeground(new Color(204, 0, 0));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTitle.setBounds(153, 73, 586, 41);
		contentPane.add(lblTitle);

		JLabel lblTheater = new JLabel(theater4);
		lblTheater.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTheater.setBounds(153, 115, 278, 33);
		contentPane.add(lblTheater);

		JLabel lblShowtime = new JLabel(showtime4);
		lblShowtime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblShowtime.setBounds(153, 164, 340, 33);
		contentPane.add(lblShowtime);

		JLabel lblX = new JLabel("X:");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblX.setBounds(151, 213, 22, 33);
		contentPane.add(lblX);

		JLabel lblY = new JLabel("Y:");
		lblY.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblY.setBounds(257, 213, 22, 33);
		contentPane.add(lblY);

		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLocation.setBounds(64, 213, 72, 33);
		contentPane.add(lblLocation);

		JLabel lblYco = new JLabel(y3);
		lblYco.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYco.setBounds(279, 216, 38, 27);
		contentPane.add(lblYco);

		JLabel lblXco = new JLabel(x3);
		lblXco.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblXco.setBounds(174, 216, 38, 27);
		contentPane.add(lblXco);

		JLabel lblNewLabel = new JLabel("Title:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(91, 79, 57, 33);
		contentPane.add(lblNewLabel);

		JLabel lblTheater_1 = new JLabel("Theater:");
		lblTheater_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTheater_1.setBounds(64, 115, 66, 33);
		contentPane.add(lblTheater_1);

		JLabel lblShowTime = new JLabel("Show Time:");
		lblShowTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblShowTime.setBounds(39, 164, 94, 33);
		contentPane.add(lblShowTime);

		JLabel lblRating = new JLabel("Rating:" + rating4);
		lblRating.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRating.setBounds(454, 115, 212, 33);
		contentPane.add(lblRating);

		JLabel lblGenre = new JLabel("Genre:" + genre4);
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGenre.setBounds(696, 115, 249, 33);
		contentPane.add(lblGenre);

		JLabel label = new JLabel("|");
		label.setFont(new Font("Tahoma", Font.BOLD, 19));
		label.setBounds(666, 115, 15, 33);
		contentPane.add(label);

		JLabel label_1 = new JLabel("|");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_1.setBounds(435, 115, 15, 33);
		contentPane.add(label_1);

		JLabel lblDistance = new JLabel("Distance:");
		lblDistance.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDistance.setBounds(64, 256, 72, 33);
		contentPane.add(lblDistance);

		JLabel label_2 = new JLabel(distance4 + " miles");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(153, 256, 103, 33);
		contentPane.add(label_2);

		JLabel lblInformation = new JLabel("Information");
		lblInformation.setForeground(Color.BLUE);
		lblInformation.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblInformation.setBounds(341, 26, 221, 36);
		contentPane.add(lblInformation);

		JLabel lblDate = new JLabel("Date: " + ddate);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDate.setBounds(538, 164, 190, 33);
		contentPane.add(lblDate);

		JLabel label_3 = new JLabel("|");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_3.setBounds(508, 164, 15, 33);
		contentPane.add(label_3);
	}
}

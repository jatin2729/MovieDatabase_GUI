import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ViewAdmin extends JFrame {

	private JPanel contentPane;
	static JTextField textField_id;
	static JTextField textField_title;
	static JTextField textField_release;
	static JTextField textField_rating;
	static JTextField textField_genre;
	static JTextField textField_time;
	static JTextField textField_theater;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAdmin frame = new ViewAdmin();
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
	public ViewAdmin() {
		setTitle("View ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 815, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMovieId = new JLabel("Movie id:");
		lblMovieId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMovieId.setBounds(40, 93, 85, 20);
		contentPane.add(lblMovieId);

		JLabel lblMovieTitle = new JLabel("Movie Title:");
		lblMovieTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMovieTitle.setBounds(40, 129, 103, 20);
		contentPane.add(lblMovieTitle);

		JLabel lblMovieReleaseDate = new JLabel("Movie Release Date:");
		lblMovieReleaseDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMovieReleaseDate.setBounds(40, 165, 159, 20);
		contentPane.add(lblMovieReleaseDate);

		JLabel lblMovieRating = new JLabel("Movie Rating:");
		lblMovieRating.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMovieRating.setBounds(40, 201, 142, 20);
		contentPane.add(lblMovieRating);

		JLabel lblMoviegenre = new JLabel("Movie_Genre:");
		lblMoviegenre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMoviegenre.setBounds(40, 237, 126, 20);
		contentPane.add(lblMoviegenre);

		JLabel lblMovieTheater_1 = new JLabel("Movie Theater:");
		lblMovieTheater_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMovieTheater_1.setBounds(40, 309, 126, 20);
		contentPane.add(lblMovieTheater_1);

		textField_id = new JTextField();
		textField_id.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_id.setEditable(false);
		textField_id.setBounds(211, 91, 146, 26);
		contentPane.add(textField_id);
		textField_id.setColumns(10);

		textField_title = new JTextField();
		textField_title.setEditable(false);
		textField_title.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_title.setBounds(211, 129, 254, 26);
		contentPane.add(textField_title);
		textField_title.setColumns(10);

		textField_release = new JTextField();
		textField_release.setEditable(false);
		textField_release.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_release.setColumns(10);
		textField_release.setBounds(211, 163, 254, 26);
		contentPane.add(textField_release);

		textField_rating = new JTextField();
		textField_rating.setEditable(false);
		textField_rating.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_rating.setColumns(10);
		textField_rating.setBounds(211, 199, 254, 26);
		contentPane.add(textField_rating);

		textField_genre = new JTextField();
		textField_genre.setEditable(false);
		textField_genre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_genre.setColumns(10);
		textField_genre.setBounds(211, 235, 254, 26);
		contentPane.add(textField_genre);

		textField_time = new JTextField();
		textField_time.setEditable(false);
		textField_time.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_time.setColumns(10);
		textField_time.setBounds(211, 271, 254, 26);
		contentPane.add(textField_time);

		textField_theater = new JTextField();
		textField_theater.setEditable(false);
		textField_theater.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_theater.setColumns(10);
		textField_theater.setBounds(211, 307, 254, 26);
		contentPane.add(textField_theater);

		JLabel lblMovieTheater = new JLabel("Movie Time:");
		lblMovieTheater.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMovieTheater.setBounds(40, 273, 126, 20);
		contentPane.add(lblMovieTheater);
	}
}

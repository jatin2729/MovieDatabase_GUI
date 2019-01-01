import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

public class AddMovie extends JFrame {

	private JPanel contentPane;
	static JTextField txtTitle;
	private JTextField txtGenre;
	static JLabel lblTheter;
	static JLabel lblTitle;
	String time = "";
	static JScrollPane scrollPane;
	static JList listTheater;
	static JButton btnAddMovie;

	static Connection connection = sqliteConnection.dbConnector();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMovie frame = new AddMovie();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public AddMovie() throws ParseException {
		setFont(new Font("Dialog", Font.BOLD, 16));
		setTitle("Add Movie");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 667, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("HH");
		for (int i = 1; i <= 9; i++) {
			comboBox.addItem("0" + i);
		}
		for (int j = 10; j <= 12; j++) {
			comboBox.addItem(j);
		}
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBounds(157, 218, 60, 32);
		contentPane.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("MM");
		for (int i = 0; i <= 9; i++) {
			comboBox_1.addItem("0" + i);
		}
		for (int j = 10; j <= 59; j++) {
			comboBox_1.addItem(j);
		}

		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_1.setBounds(214, 218, 60, 32);
		contentPane.add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setToolTipText("AM/PM");
		comboBox_2.addItem("PM");
		comboBox_2.addItem("AM");

		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_2.setBounds(280, 218, 60, 32);
		contentPane.add(comboBox_2);

		JComboBox comboBox_MM = new JComboBox();
		comboBox_MM.setToolTipText("MM");
		for (int i = 1; i <= 12; i++) {
			comboBox_MM.addItem(i);
		}
		comboBox_MM.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_MM.setBounds(157, 82, 60, 31);
		contentPane.add(comboBox_MM);

		JComboBox comboBox_DD = new JComboBox();
		comboBox_DD.setToolTipText("DD");
		for (int i = 1; i <= 31; i++) {
			comboBox_DD.addItem(i);
		}
		comboBox_DD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_DD.setBounds(221, 82, 60, 31);
		contentPane.add(comboBox_DD);

		JComboBox comboBox_Year = new JComboBox();
		comboBox_Year.setToolTipText("YYYY");
		for (int i = 2018; i <= 2022; i++) {
			comboBox_Year.addItem(i);
		}
		comboBox_Year.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_Year.setBounds(290, 82, 85, 31);
		contentPane.add(comboBox_Year);

		lblTitle = new JLabel("Title :");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitle.setBounds(98, 23, 49, 37);
		contentPane.add(lblTitle);

		JLabel lblReleaseDate = new JLabel("Release Date :");
		lblReleaseDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblReleaseDate.setBounds(28, 76, 120, 37);
		contentPane.add(lblReleaseDate);

		JLabel lblRating = new JLabel("Rating :");
		lblRating.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRating.setBounds(82, 124, 65, 37);
		contentPane.add(lblRating);

		JLabel lblGenre = new JLabel("Genre :");
		lblGenre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGenre.setBounds(87, 172, 60, 37);
		contentPane.add(lblGenre);

		txtTitle = new JTextField();
		txtTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTitle.setBounds(157, 28, 306, 31);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);

		txtGenre = new JTextField();
		txtGenre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtGenre.setColumns(10);
		txtGenre.setBounds(157, 177, 183, 31);
		contentPane.add(txtGenre);

		JComboBox comboboxRatings = new JComboBox();
		comboboxRatings.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboboxRatings.setBounds(157, 134, 103, 27);
		comboboxRatings.addItem("G");
		comboboxRatings.addItem("PG");
		comboboxRatings.addItem("PG-13");
		comboboxRatings.addItem("R");
		comboboxRatings.addItem("NC-17");
		contentPane.add(comboboxRatings);

		// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
		// LocalDateTime now = LocalDateTime.now();
		// String year2 = dtf.format(now);
		//
		// DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("MM");
		// LocalDateTime now1 = LocalDateTime.now();
		// String month1 = dtf1.format(now1);
		//
		// DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("DD");
		// LocalDateTime now2 = LocalDateTime.now();
		// String day1 = dtf2.format(now2);

		// System.out.println(month1 + " " + day1 + " " + " " + year2);

		MaskFormatter mf3 = new MaskFormatter("##-##-####");
		mf3.setPlaceholderCharacter(' ');

		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTime.setBounds(97, 218, 51, 37);
		contentPane.add(lblTime);

		lblTheter = new JLabel("Theater:");
		lblTheter.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTheter.setBounds(71, 263, 77, 37);
		contentPane.add(lblTheter);

		JButton btnAddtime = new JButton("Add Time:");
		btnAddtime.setBounds(348, 221, 115, 29);
		contentPane.add(btnAddtime);
		btnAddMovie = new JButton("Add Movie");
		btnAddMovie.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddMovie.setBounds(157, 408, 125, 45);
		contentPane.add(btnAddMovie);
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancel.setBounds(332, 408, 125, 45);
		contentPane.add(btnCancel);

		String[] theaterarr = new String[50];

		PreparedStatement pst;
		try {
			String query = "select Theater_Name from Theater";
			pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			int i = 0;
			while (rs.next()) {

				theaterarr[i] = rs.getString(1);
				System.out.println(rs.getString(1));
				i++;
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("No such theater:");
		}

		scrollPane = new JScrollPane();
		scrollPane.setBounds(157, 266, 246, 113);
		contentPane.add(scrollPane);

		listTheater = new JList(theaterarr);
		scrollPane.setViewportView(listTheater);

		listTheater.setFont(new Font("Tahoma", Font.PLAIN, 18));
		listTheater.setVisibleRowCount(5);
		listTheater.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		JButton btnUpdateMovieTime = new JButton("Update Movie time");
		btnUpdateMovieTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateShowTime frame;
				try {
					frame = new UpdateShowTime();
					frame.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnUpdateMovieTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdateMovieTime.setBounds(179, 478, 236, 45);
		contentPane.add(btnUpdateMovieTime);

		// Object[] indices = listTheater.getSelectedValues(); // array of all selected
		// theater from JLIST

		btnAddtime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				time = time + comboBox.getSelectedItem().toString() + ":" + comboBox_1.getSelectedItem().toString()
						+ " " + comboBox_2.getSelectedItem().toString() + ", ";
				// System.out.println(time);

			}
		});

		btnAddMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String date = comboBox_Year.getSelectedItem().toString() + "/"
						+ comboBox_MM.getSelectedItem().toString() + "/" + comboBox_DD.getSelectedItem().toString();

				// DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				// Date date1 = new Date();
				// String x1 = dateFormat.format(date1);
				//

				if (!(txtTitle.getText().isEmpty() || txtGenre.getText().isEmpty())) {

					try {

						Object[] indices = listTheater.getSelectedValues();// array of all selected theater from JLIST

						// String date = comboBox_3.getSelectedItem().toString() + "/"
						// + comboBox_4.getSelectedItem().toString() + "/"
						// + comboBox_5.getSelectedItem().toString();

						// System.out.println(date1);

						Random rand = new Random();
						int y = rand.nextInt(30000) + 1;

						PreparedStatement pst3, pst1, pst2;

						String query10 = "insert into Movies (Movie_ID,Movie_Title,Movie_Release_Date,Movie_Rating,Movie_Genre) values (?,?,?,?,?)";
						pst3 = connection.prepareStatement(query10);
						pst3.setInt(1, y);
						pst3.setString(2, txtTitle.getText().toLowerCase());
						pst3.setString(3, date);
						pst3.setString(4, comboboxRatings.getSelectedItem().toString().toLowerCase());
						// System.out.println(comboboxRatings.getSelectedItem().toString().toLowerCase());
						pst3.setString(5, txtGenre.getText().toLowerCase());
						// pst.setString(6, time);
						// pst.setString(7, (String) indices[i]);
						pst3.execute();
						pst3.close();
						Object[] theaterlist = new Object[indices.length + 1];

						JOptionPane.showMessageDialog(null, "Movie inserted:");

						for (int i = 0; i < indices.length; ++i) {
							System.out.println(indices[i] + " " + "indices");

							try {
								String query3 = "select Theater_Name, Theater_ID from Theater";
								PreparedStatement pst4;
								pst4 = connection.prepareStatement(query3);
								ResultSet rs1 = pst4.executeQuery();
								System.out.println("Theater");
								int k = 0;
								while (rs1.next()) {
									for (int l = 0; l < indices.length; l++) {
										if (indices[l].equals(rs1.getString(1))) {
											theaterlist[k] = rs1.getString(2);
											k++;
											System.out.println("K is " + rs1.getString(2));
										}
									}

									// System.out.print(rs1.getString(1));
									// System.out.println(rs1.getString(2));
								}

							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								System.out.println("No such theater:");
							}

							int x = rand.nextInt(60000) + 30000;
							String query2 = "insert into ShowTime (show_ID,date,time,Movie_ID,Theater_ID) values (?,?,?,?,?)";
							int cut = time.lastIndexOf(",");
							String time1 = time.substring(0, cut);
							System.out.println(time1);
							pst1 = connection.prepareStatement(query2);
							pst1.setInt(1, x);
							pst1.setString(2, date);
							pst1.setString(3, time1);
							pst1.setInt(4, y);
							pst1.setString(5, (String) theaterlist[i]);
							pst1.execute();
							pst1.close();

							System.out.println("Showtime inserted:");

						}
						AddMovie.super.dispose();
						// AddMovie frame1 = new AddMovie();
						// frame1.setVisible(true);

					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Movie already exist:");
						System.out.println(e);
					}

				} else {

					JOptionPane.showMessageDialog(null, "Please fill all the Fields:");
				}
			}
		});

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMovie.super.dispose();
			}
		});

	}
}

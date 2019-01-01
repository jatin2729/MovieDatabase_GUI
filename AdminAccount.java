import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class AdminAccount extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection connection = sqliteConnection.dbConnector();
	JButton btnViewMovies;
	static String id_showTime;
	JButton btnViewTheater;

	static String id;
	static String title;
	static String releasedate;
	static String rating;
	static String genre;

	static String theatername;
	static String thID;
	static String addressth;
	static String phno;
	static String x;
	static String y;

	static JButton buttonRemove;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAccount frame = new AdminAccount();
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
	public AdminAccount() {
		setFont(new Font("Dialog", Font.BOLD, 16));
		setTitle("Admin Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1120, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAddmovie = new JButton("Add Movies");
		btnAddmovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// AdminAccount.super.dispose();
				AddMovie frame;
				try {
					frame = new AddMovie();
					frame.setVisible(true);
					frame.setLocation(650, 250);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnAddmovie.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddmovie.setBounds(15, 10, 146, 49);
		contentPane.add(btnAddmovie);

		JButton btnAddTheater = new JButton("Add Theater");
		btnAddTheater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					AddTheater frame;
					frame = new AddTheater();
					frame.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnAddTheater.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddTheater.setBounds(15, 60, 146, 49);
		contentPane.add(btnAddTheater);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(177, 66, 927, 262);
		contentPane.add(scrollPane);
		table = new JTable();
		table.setForeground(Color.BLACK);
		scrollPane.setViewportView(table);

		table.setRowHeight(26);
		// table.setEnabled(false);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));

		try {

			// String query = "select e.Movie_ID, e.Movie_Title,
			// e.Movie_Genre,e.Movie_Rating, s.date, s.time, t.Theater_Name,t.X, t.Y,
			// s.show_ID from Movies e "
			// + "inner join ShowTime s on e.Movie_ID=s.Movie_ID "
			// + "inner join Theater t on s.Theater_ID=t.Theater_ID order by s.date asc";
			String query = "select * from Movies";

			// String query = "select * from Movies Inner join ShowTime on
			// Movies.Movie_ID=ShowTime.Movie_ID "
			// + "Inner join Theater on Theater.Theater_ID=ShowTime.Theater_ID order by
			// Movies.Movie_ID";
			// System.out.println(query);
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery(); // rs2xml.jar file need to be added in the project libararies
			table.setModel(DbUtils.resultSetToTableModel(rs));// helps to convert rs to table//dbutils is class inside
																// rs2xl.jar

			table.setEnabled(true);

			Font myFont = new Font("Serif", Font.BOLD, 18);
			table.setFont(new Font("Serif", Font.PLAIN, 20));

			table.getColumnModel().getColumn(0).setMinWidth(0);
			table.getColumnModel().getColumn(0).setMaxWidth(0);

		} catch (Exception e) {
			System.out.println("cant load table");

		}
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {

				int row = table.getSelectedRow();
				int colcount = table.getColumnCount();

				if (colcount == 5 || colcount == 8) {

					if (colcount == 8) {
						ViewAdmin frame = new ViewAdmin();
						frame.setVisible(true);
						String title1 = table.getModel().getValueAt(row, 1).toString();
						String releasedate1 = table.getModel().getValueAt(row, 4).toString();
						String rating1 = table.getModel().getValueAt(row, 3).toString();
						String genre1 = table.getModel().getValueAt(row, 2).toString();
						String time = table.getModel().getValueAt(row, 5).toString();
						String th = table.getModel().getValueAt(row, 6).toString();
						String id1 = table.getModel().getValueAt(row, 0).toString();
						ViewAdmin.textField_id.setText(id1);
						ViewAdmin.textField_title.setText(title1);
						ViewAdmin.textField_release.setText(releasedate1);
						ViewAdmin.textField_rating.setText(rating1);
						ViewAdmin.textField_genre.setText(genre1);
						ViewAdmin.textField_time.setText(time);
						ViewAdmin.textField_theater.setText(th);
					} else {

						// ViewAdmin frame = new ViewAdmin();
						// frame.setVisible(true);

						id = table.getModel().getValueAt(row, 0).toString();
						title = table.getModel().getValueAt(row, 1).toString();
						releasedate = table.getModel().getValueAt(row, 2).toString();
						rating = table.getModel().getValueAt(row, 3).toString();
						genre = table.getModel().getValueAt(row, 4).toString();

						// AllMovieAdmin.textField_id.setText(id);
						// AllMovieAdmin.lbltitle1.setText(title);
						AllMovieAdmin frame = new AllMovieAdmin();
						frame.setVisible(true);
						// AllMovieAdmin.textField_release.setText(releasedate);
						// AllMovieAdmin.textField_rating.setText(rating);
						// AllMovieAdmin.textField_genre.setText(genre);
					}

				} else {

					thID = table.getModel().getValueAt(row, 0).toString();
					theatername = table.getModel().getValueAt(row, 1).toString();
					addressth = table.getModel().getValueAt(row, 2).toString() + "  "
							+ table.getModel().getValueAt(row, 3).toString() + "-"
							+ table.getModel().getValueAt(row, 4).toString();
					phno = table.getModel().getValueAt(row, 5).toString();
					x = table.getModel().getValueAt(row, 6).toString();
					y = table.getModel().getValueAt(row, 7).toString();

					AllTheaterAdmin frame = new AllTheaterAdmin();
					frame.setVisible(true);

					// frame.textField_time.setText(time);
					// frame.textField_theater.setText(theater);
				}
			}
		});

		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setForeground(Color.WHITE);
		btnSignOut.setBackground(Color.RED);
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminAccount.super.dispose();
				AdminLogIn frame = new AdminLogIn();
				frame.setVisible(true);
				frame.setLocation(650, 250);
			}
		});
		btnSignOut.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSignOut.setBounds(15, 312, 146, 49);
		contentPane.add(btnSignOut);

		buttonRemove = new JButton("Remove Selected");
		buttonRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();

				PreparedStatement pst2, pst3, pst4, pst5;

				try {

					String id = table.getModel().getValueAt(row, 0).toString();
					if (table.getColumnCount() == 8) {
						id_showTime = table.getModel().getValueAt(row, 7).toString();
						String query4 = "DELETE FROM ShowTime where show_ID=?";
						pst3 = AddMovie.connection.prepareStatement(query4);
						pst3.setString(1, id_showTime);
						pst3.execute();
					} else if (table.getColumnCount() == 5) {

						String query3 = "DELETE FROM Movies where Movie_ID=?";
						pst2 = AddMovie.connection.prepareStatement(query3);
						pst2.setString(1, id);
						pst2.execute();

						String query34 = "DELETE FROM ShowTime where Movie_ID=?";
						pst5 = AddMovie.connection.prepareStatement(query34);
						pst5.setString(1, id);
						pst5.execute();
						btnViewMovies.doClick();

					} else {
						String id1 = table.getModel().getValueAt(row, 0).toString();

						String query5 = "DELETE FROM Theater where Theater_ID=?";
						pst4 = AddMovie.connection.prepareStatement(query5);
						pst4.setString(1, id1);
						pst4.execute();

						String query6 = "DELETE FROM ShowTime where Theater_ID=?";
						pst5 = AddMovie.connection.prepareStatement(query6);
						pst5.setString(1, id1);
						pst5.execute();
						btnViewTheater.doClick();

					}
					System.out.println(id);

					JOptionPane.showMessageDialog(null, "Removed: ");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("cant delete");
				}

			}
		});
		buttonRemove.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonRemove.setBounds(646, 16, 206, 34);
		contentPane.add(buttonRemove);

		btnViewMovies = new JButton("View Movies");
		btnViewMovies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					String query = "Select * From Movies";

					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery(); // rs2xml.jar file need to be added in the project libararies
					table.setModel(DbUtils.resultSetToTableModel(rs));// helps to convert rs to table//dbutils is class
																		// inside
																		// rs2xl.jar

					table.setEnabled(true);

					table.getColumnModel().getColumn(0).setMinWidth(0);
					table.getColumnModel().getColumn(0).setMaxWidth(0);

					Font myFont = new Font("Serif", Font.BOLD, 18);
					table.setFont(new Font("Serif", Font.PLAIN, 20));
					// btnViewMovies.doClick();

				} catch (Exception e211) {
					System.out.println("cant load table");

				}

			}
		});
		btnViewMovies.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewMovies.setBounds(15, 125, 146, 49);
		contentPane.add(btnViewMovies);

		btnViewTheater = new JButton("View Theater");
		btnViewTheater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					String query = "select * from Theater";

					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery(); // rs2xml.jar file need to be added in the project libararies
					table.setModel(DbUtils.resultSetToTableModel(rs));// helps to convert rs to table//dbutils is class
																		// inside
																		// rs2xl.jar

					table.setEnabled(true);
					table.getColumnModel().getColumn(0).setMinWidth(0);
					table.getColumnModel().getColumn(0).setMaxWidth(0);
					table.getColumnModel().getColumn(0).setWidth(0);

					// table.getColumnModel().getColumn(0).setPreferredWidth(0);
					table.getColumnModel().getColumn(1).setPreferredWidth(200);
					table.getColumnModel().getColumn(2).setPreferredWidth(160);
					table.getColumnModel().getColumn(3).setPreferredWidth(40);
					table.getColumnModel().getColumn(4).setPreferredWidth(10);
					table.getColumnModel().getColumn(5).setPreferredWidth(90);
					table.getColumnModel().getColumn(6).setPreferredWidth(20);
					table.getColumnModel().getColumn(7).setPreferredWidth(20);
					// table.getColumnModel().getColumn(8).setPreferredWidth(0);

					table.getColumnModel().getColumn(8).setMinWidth(0);
					table.getColumnModel().getColumn(8).setMaxWidth(0);
					// table.getColumnModel().getColumn(8).setPreferredWidth(0);

					// table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

					Font myFont = new Font("Serif", Font.BOLD, 18);
					table.setFont(new Font("Serif", Font.PLAIN, 20));
					// btnViewMovies.doClick();

				} catch (Exception e211) {
					System.out.println("cant load table");

				}

			}
		});
		btnViewTheater.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewTheater.setBounds(15, 176, 146, 49);
		contentPane.add(btnViewTheater);

		JButton btnUpdateShowtime = new JButton("Update Showtime");
		btnUpdateShowtime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateShowTime frame;
				try {
					frame = new UpdateShowTime();
					frame.setVisible(true);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnUpdateShowtime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdateShowtime.setBounds(234, 16, 206, 34);
		contentPane.add(btnUpdateShowtime);

		JButton btnViewShowtime = new JButton("View ShowTime");
		btnViewShowtime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					String query = "select e.Movie_ID, e.Movie_Title, e.Movie_Genre,e.Movie_Rating, s.date, s.time, t.Theater_Name, "
							+ "s.show_ID from Movies e " + "inner join ShowTime s on e.Movie_ID=s.Movie_ID "
							+ "inner join Theater t on s.Theater_ID=t.Theater_ID order by s.date asc";

					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery(); // rs2xml.jar file need to be added in the project libararies
					table.setModel(DbUtils.resultSetToTableModel(rs));// helps to convert rs to table//dbutils is class
																		// inside
																		// rs2xl.jar
					// table.getColumnModel().getColumn(0).setPreferredWidth(10);
					table.getColumnModel().getColumn(0).setMinWidth(0);
					table.getColumnModel().getColumn(0).setMaxWidth(0);
					table.getColumnModel().getColumn(3).setPreferredWidth(5);
					table.getColumnModel().getColumn(4).setPreferredWidth(20);
					table.getColumnModel().getColumn(5).setPreferredWidth(150);
					table.getColumnModel().getColumn(7).setMinWidth(0);
					table.getColumnModel().getColumn(7).setMaxWidth(0);
					table.setEnabled(true);

					Font myFont = new Font("Serif", Font.BOLD, 18);
					table.setFont(new Font("Serif", Font.PLAIN, 20));

				} catch (Exception e) {
					System.out.println("cant load table");

				}
			}
		});
		btnViewShowtime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewShowtime.setBounds(0, 229, 161, -4);
		contentPane.add(btnViewShowtime);
	}
}

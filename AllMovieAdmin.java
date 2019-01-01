import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import net.proteanit.sql.DbUtils;

public class AllMovieAdmin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	int mile1;
	JButton btnRefresh;
	int x;
	static JLabel lbltitle1;
	static String movie_title1;
	static String theater;
	static String rating1;
	static String genre1;
	static String showtime1;
	static String x2;
	static String y2;
	static String distance2;
	static int mile3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllMovieAdmin frame = new AllMovieAdmin();
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
	public AllMovieAdmin() {
		setTitle("Movie showtimes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1085, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 131, 979, 265);
		contentPane.add(scrollPane);

		btnRefresh = new JButton("Refresh Table");
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRefresh.setBounds(856, 79, 164, -3);
		contentPane.add(btnRefresh);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		table.setRowHeight(30);

		JLabel lblRating = new JLabel("Rating: " + AdminAccount.rating);
		lblRating.setForeground(Color.DARK_GRAY);
		lblRating.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblRating.setBounds(49, 84, 183, 39);
		contentPane.add(lblRating);

		JLabel lblGenre = new JLabel("Genre: " + AdminAccount.genre);
		lblGenre.setForeground(Color.DARK_GRAY);
		lblGenre.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblGenre.setBounds(289, 84, 302, 39);
		contentPane.add(lblGenre);

		JLabel lblShowTimeFor = new JLabel("Show time for:");
		lblShowTimeFor.setForeground(Color.BLACK);
		lblShowTimeFor.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblShowTimeFor.setBounds(49, 8, 423, 39);
		contentPane.add(lblShowTimeFor);

		JLabel label_5 = new JLabel("|");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Times New Roman", Font.BOLD, 24));
		label_5.setBounds(247, 84, 28, 39);
		contentPane.add(label_5);
		try {
			x = Integer.parseInt(AdminAccount.id);
			String query = "select s.show_ID, s.date, s.time, t.Theater_Name,t.X, t.Y, t.Distance from Movies e "
					+ "inner join ShowTime s on e.Movie_ID=s.Movie_ID "
					+ "inner join Theater t on s.Theater_ID=t.Theater_ID  Where e.Movie_ID in (" + x + ") "
					+ "order by t.Distance asc";

			PreparedStatement pst = AddMovie.connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery(); // rs2xml.jar file need to be added in the project libararies
			table.setModel(DbUtils.resultSetToTableModel(rs));// helps to convert rs to table//dbutils is class inside
																// rs2xl.jar
			TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
			table.setRowSorter(sorter);
			table.setEnabled(true);

			table.getColumnModel().getColumn(0).setMinWidth(0);
			table.getColumnModel().getColumn(0).setMaxWidth(0);
			// table.getColumnModel().getColumn(0).setWidth(0);

			table.getColumnModel().getColumn(1).setPreferredWidth(60);
			table.getColumnModel().getColumn(2).setPreferredWidth(340);
			table.getColumnModel().getColumn(3).setPreferredWidth(160);
			table.getColumnModel().getColumn(4).setPreferredWidth(5);
			table.getColumnModel().getColumn(5).setPreferredWidth(5);
			// table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
			table.getColumnModel().getColumn(6).setMinWidth(0);
			table.getColumnModel().getColumn(6).setMaxWidth(0);

			Font myFont = new Font("Serif", Font.BOLD, 18);
			table.setFont(new Font("Serif", Font.PLAIN, 22));

			lbltitle1 = new JLabel(AdminAccount.title.toUpperCase());
			lbltitle1.setForeground(new Color(255, 0, 0));
			lbltitle1.setFont(new Font("Times New Roman", Font.BOLD, 28));
			lbltitle1.setBounds(49, 49, 471, 39);
			contentPane.add(lbltitle1);

			JButton btnNewButton = new JButton("Remove Selected");
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int row = table.getSelectedRow();

					PreparedStatement pst2, pst3, pst4, pst5;

					try {
						String tsd = lbltitle1.getText();

						String showid = table.getModel().getValueAt(row, 0).toString();

						// id_showTime = table.getModel().getValueAt(row, 7).toString();
						String query4 = "DELETE FROM ShowTime where show_ID=?";
						pst3 = AddMovie.connection.prepareStatement(query4);
						pst3.setString(1, showid);
						pst3.execute();

						JOptionPane.showMessageDialog(null, "Removed: ");
						btnRefresh.doClick();

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println("can't delete showtime:");
					}

				}
			});
			btnNewButton.setBounds(617, 86, 193, 37);
			contentPane.add(btnNewButton);

		} catch (Exception e) {
			System.out.println("cant load table");

		}

		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String query = "select  s.show_ID, s.date, s.time, t.Theater_Name,t.X, t.Y, t.Distance from Movies e "
							+ "inner join ShowTime s on e.Movie_ID=s.Movie_ID "
							+ "inner join Theater t on s.Theater_ID=t.Theater_ID  Where e.Movie_ID in (" + x + ") "
							+ "order by t.Distance asc";

					// String query = "select s.show_ID, s.date, s.time, t.Theater_Name,t.X, t.Y,
					// t.Distance from Movies e "
					// + "inner join ShowTime s on e.Movie_ID=s.Movie_ID "
					// + "inner join Theater t on s.Theater_ID=t.Theater_ID Where e.Movie_ID in (" +
					// x + ") "
					// + "order by t.Distance asc";

					PreparedStatement pst = AddMovie.connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery(); // rs2xml.jar file need to be added in the project libararies
					table.setModel(DbUtils.resultSetToTableModel(rs));// helps to convert rs to table//dbutils is
																		// class
																		// inside
																		// rs2xl.jar

					table.getColumnModel().getColumn(0).setMinWidth(0);
					table.getColumnModel().getColumn(0).setMaxWidth(0);

					table.getColumnModel().getColumn(6).setMinWidth(0);
					table.getColumnModel().getColumn(6).setMaxWidth(0);

					TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
					table.setRowSorter(sorter);
					// table.setEnabled(true);
					table.setEnabled(true);

					Font myFont = new Font("Serif", Font.BOLD, 18);
					table.setFont(new Font("Serif", Font.PLAIN, 20));

				} catch (Exception e2) {
					System.out.println("cant load table");

				}

			}
		});

		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {

				String query = "select s.show_ID, s.date, s.time, t.Theater_Name,t.X, t.Y, t.Distance from Movies e "
						+ "inner join ShowTime s on e.Movie_ID=s.Movie_ID "
						+ "inner join Theater t on s.Theater_ID=t.Theater_ID  Where e.Movie_ID in (" + x + ") "
						+ "order by t.Distance asc";

				int colCounter = table.getColumnCount();
				int row = table.getSelectedRow();

				movie_title1 = lbltitle1.getText();
				ViewMovie.movie_title4 = movie_title1;

				ViewMovie.ddate = table.getModel().getValueAt(row, 1).toString();
				System.out.println(ViewMovie.ddate);
				// rating1 = "Rating: " + lblRating.getText();
				ViewMovie.rating4 = AdminAccount.rating;
				genre1 = AdminAccount.genre;
				ViewMovie.genre4 = genre1;
				theater = table.getModel().getValueAt(row, 3).toString();
				ViewMovie.theater4 = theater;
				showtime1 = table.getModel().getValueAt(row, 2).toString();
				ViewMovie.showtime4 = showtime1;
				distance2 = table.getModel().getValueAt(row, 6).toString();
				ViewMovie.distance4 = distance2;

				ViewMovie.x3 = table.getModel().getValueAt(row, 4).toString();
				ViewMovie.y3 = table.getModel().getValueAt(row, 5).toString();
				ViewMovie frame = new ViewMovie();
				frame.setVisible(true);

				// frame.textField_time.setText(time);
				// frame.textField_theater.setText(theater);

			}
		});
	}
}

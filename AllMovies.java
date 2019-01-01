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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import net.proteanit.sql.DbUtils;

public class AllMovies extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtX;
	private JTextField txtY;
	int mile1;
	JButton btnRefresh;
	int x;
	private JLabel lbltitle;
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
					AllMovies frame = new AllMovies();
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
	public AllMovies() {
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
		JLabel label = new JLabel("Enter Your Location:");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(637, 16, 227, 27);
		contentPane.add(label);

		JLabel label_1 = new JLabel("X:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(617, 50, 28, 20);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Y:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(731, 50, 28, 20);
		contentPane.add(label_2);

		txtX = new JTextField();
		txtX.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtX.setColumns(10);
		txtX.setBounds(647, 46, 69, 28);
		contentPane.add(txtX);

		txtY = new JTextField();
		txtY.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtY.setColumns(10);
		txtY.setBounds(764, 47, 69, 28);
		contentPane.add(txtY);

		JButton btnByDistance = new JButton("Sort by Distance");
		btnByDistance.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnByDistance.setBounds(856, 46, 172, 29);
		contentPane.add(btnByDistance);

		btnRefresh = new JButton("Refresh Table");
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRefresh.setBounds(856, 79, 164, -4);
		contentPane.add(btnRefresh);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		table.setRowHeight(30);

		JLabel lblRating = new JLabel("Rating: " + UserAccount.movie_Rating);
		lblRating.setForeground(Color.DARK_GRAY);
		lblRating.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblRating.setBounds(49, 84, 183, 39);
		contentPane.add(lblRating);

		JLabel lblGenre = new JLabel("Genre: " + UserAccount.movie_genre);
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
			x = Integer.parseInt(UserAccount.movieID);
			String query = "select s.date, s.time, t.Theater_Name,t.X, t.Y, t.Distance from Movies e "
					+ "inner join ShowTime s on e.Movie_ID=s.Movie_ID "
					+ "inner join Theater t on s.Theater_ID=t.Theater_ID  Where e.Movie_ID in (" + x + ") "
					+ "order by t.Distance asc";
			// String query = "select e.Movie_Title, e.Movie_Genre,e.Movie_Rating, s.date,
			// s.time, t.Theater_Name,t.X, t.Y, t.Distance from Movies e "
			// + "inner join ShowTime s on e.Movie_ID=s.Movie_ID "
			// + "inner join Theater t on s.Theater_ID=t.Theater_ID order by t.Distance
			// asc";

			// String query = "select * from Movies";
			PreparedStatement pst = AddMovie.connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery(); // rs2xml.jar file need to be added in the project libararies
			table.setModel(DbUtils.resultSetToTableModel(rs));// helps to convert rs to table//dbutils is class inside
																// rs2xl.jar
			TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
			table.setRowSorter(sorter);
			table.setEnabled(true);

			// table.getColumnModel().getColumn(0).setMinWidth(0);
			// table.getColumnModel().getColumn(0).setMaxWidth(0);
			// table.getColumnModel().getColumn(0).setWidth(0);

			table.getColumnModel().getColumn(0).setPreferredWidth(60);
			table.getColumnModel().getColumn(1).setPreferredWidth(340);
			table.getColumnModel().getColumn(2).setPreferredWidth(160);
			table.getColumnModel().getColumn(3).setPreferredWidth(5);
			table.getColumnModel().getColumn(4).setPreferredWidth(5);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

			Font myFont = new Font("Serif", Font.BOLD, 18);
			table.setFont(new Font("Serif", Font.PLAIN, 22));

			lbltitle = new JLabel(UserAccount.movie_name.toUpperCase());
			lbltitle.setForeground(new Color(255, 0, 0));
			lbltitle.setFont(new Font("Times New Roman", Font.BOLD, 28));
			lbltitle.setBounds(49, 49, 471, 39);
			contentPane.add(lbltitle);

		} catch (Exception e) {
			System.out.println("cant load table");

		}
		btnByDistance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < table.getRowCount(); ++i) {
					String theaterName = table.getModel().getValueAt(i, 2).toString();
					int xDiff1, yDiff1;
					Double dis1;
					String x1 = table.getModel().getValueAt(i, 3).toString();
					String y1 = table.getModel().getValueAt(i, 4).toString();

					if (txtX.getText().isEmpty() || txtY.getText().isEmpty()) {
						xDiff1 = Integer.parseInt(x1);
						yDiff1 = Integer.parseInt(y1);
					} else {

						xDiff1 = Integer.parseInt(txtX.getText()) - Integer.parseInt(x1);
						yDiff1 = Integer.parseInt(txtY.getText()) - Integer.parseInt(y1);
					}
					dis1 = Math.sqrt((xDiff1 * xDiff1) + (yDiff1 * yDiff1));
					mile1 = (int) Math.round(dis1);
					System.out.println(mile1);

					PreparedStatement pst;
					String query = "update Theater set Distance='" + mile1 + "' where Theater_Name='" + theaterName
							+ "' ";

					try {
						pst = AddMovie.connection.prepareStatement(query);
						pst.execute();
						pst.close();
						// JOptionPane.showMessageDialog(null, "distance added: " + mile);

					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Can't add distance");
					}

				}
				btnRefresh.doClick();

			}
		});

		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String query = "select  s.date, s.time, t.Theater_Name,t.X, t.Y, t.Distance from Movies e "
							+ "inner join ShowTime s on e.Movie_ID=s.Movie_ID "
							+ "inner join Theater t on s.Theater_ID=t.Theater_ID  Where e.Movie_ID in (" + x + ") "
							+ "order by t.Distance asc";

					PreparedStatement pst = AddMovie.connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery(); // rs2xml.jar file need to be added in the project libararies
					table.setModel(DbUtils.resultSetToTableModel(rs));// helps to convert rs to table//dbutils is
																		// class
																		// inside
																		// rs2xl.jar
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
				int colCounter = table.getColumnCount();
				int row = table.getSelectedRow();

				movie_title1 = lbltitle.getText();
				ViewMovie.movie_title4 = movie_title1;
				ViewMovie.ddate = table.getModel().getValueAt(row, 0).toString();
				System.out.println(ViewMovie.ddate);
				// rating1 = "Rating: " + lblRating.getText();
				ViewMovie.rating4 = UserAccount.movie_Rating;
				genre1 = UserAccount.movie_genre;
				ViewMovie.genre4 = genre1;
				theater = table.getModel().getValueAt(row, 2).toString();
				ViewMovie.theater4 = theater;
				showtime1 = table.getModel().getValueAt(row, 1).toString();
				ViewMovie.showtime4 = showtime1;
				distance2 = table.getModel().getValueAt(row, 5).toString();
				ViewMovie.distance4 = distance2;

				x2 = table.getModel().getValueAt(row, 3).toString();
				ViewMovie.x3 = x2;
				y2 = table.getModel().getValueAt(row, 4).toString();
				ViewMovie.y3 = y2;
				if (!(txtX.getText().isEmpty() || txtY.getText().isEmpty())) {
					try {
						int xDiff = Integer.parseInt(txtX.getText()) - Integer.parseInt(x2);
						int yDiff = Integer.parseInt(txtY.getText()) - Integer.parseInt(y2);
						Double dis = Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));
						mile3 = (int) Math.round(dis);
						System.out.println(mile3);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "please enter number only in location:");
						return;
					}
				} else {

				}
				// AllTheaters frame = new AllTheaters();
				// frame.setVisible(true);
				ViewMovie frame = new ViewMovie();
				frame.setVisible(true);

				// frame.textField_time.setText(time);
				// frame.textField_theater.setText(theater);

			}
		});
	}
}

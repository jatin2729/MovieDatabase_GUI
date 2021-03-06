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

public class AllTheaterAdmin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	int y;
	private JLabel lblTheater;
	private JLabel lblNewLabel_1;
	private JLabel lblLocation;
	private JLabel lblDistance;
	private JLabel lblDis;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllTheaterAdmin frame = new AllTheaterAdmin();
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
	public AllTheaterAdmin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1160, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 110, 1123, 250);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		table.setRowHeight(30);

		lblLocation = new JLabel("Location:");
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLocation.setBounds(33, 78, 92, 29);
		contentPane.add(lblLocation);

		lblTheater = new JLabel(AdminAccount.theatername.toUpperCase());
		lblTheater.setForeground(Color.RED);
		lblTheater.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblTheater.setBounds(238, 16, 353, 46);
		contentPane.add(lblTheater);

		lblNewLabel_1 = new JLabel("Movies Playing At:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_1.setBounds(33, 16, 201, 46);
		contentPane.add(lblNewLabel_1);

		JLabel lblX = new JLabel("X:" + AdminAccount.x);
		lblX.setForeground(Color.DARK_GRAY);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblX.setBounds(140, 78, 69, 29);
		contentPane.add(lblX);

		JLabel lblY = new JLabel("Y:" + AdminAccount.y);
		lblY.setForeground(Color.DARK_GRAY);
		lblY.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblY.setBounds(209, 78, 69, 29);
		contentPane.add(lblY);

		try {
			y = Integer.parseInt(AdminAccount.thID);

			String query = "select e.Movie_Title, e.Movie_Genre,e.Movie_Rating, s.date, s.time,t.Theater_Name,t.X, t.Y, t.Distance,s.show_ID from Movies e "
					+ "inner join ShowTime s on e.Movie_ID=s.Movie_ID "
					+ "inner join Theater t on s.Theater_ID=t.Theater_ID Where t.Theater_ID in (" + y + ") "
					+ "order by t.Distance asc";

			// String query = "select * from Movies";
			PreparedStatement pst = AddMovie.connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery(); // rs2xml.jar file need to be added in the project libararies
			table.setModel(DbUtils.resultSetToTableModel(rs));// helps to convert rs to table//dbutils is class inside
																// rs2xl.jar
			TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
			table.setRowSorter(sorter);
			table.setEnabled(true);
			Font myFont = new Font("Serif", Font.BOLD, 18);
			table.setFont(new Font("Serif", Font.PLAIN, 22));

			table.getColumnModel().getColumn(0).setPreferredWidth(210);
			table.getColumnModel().getColumn(1).setPreferredWidth(40);
			table.getColumnModel().getColumn(2).setPreferredWidth(40);
			table.getColumnModel().getColumn(3).setPreferredWidth(40);
			table.getColumnModel().getColumn(4).setPreferredWidth(210);
			table.getColumnModel().getColumn(5).setMinWidth(0);
			table.getColumnModel().getColumn(5).setMaxWidth(0);

			table.getColumnModel().getColumn(6).setMinWidth(0);
			table.getColumnModel().getColumn(6).setMaxWidth(0);

			table.getColumnModel().getColumn(7).setMinWidth(0);
			table.getColumnModel().getColumn(7).setMaxWidth(0);

			table.getColumnModel().getColumn(8).setMinWidth(0);
			table.getColumnModel().getColumn(8).setMaxWidth(0);

			table.getColumnModel().getColumn(9).setMinWidth(0);
			table.getColumnModel().getColumn(9).setMaxWidth(0);

		} catch (Exception e) {
			System.out.println("cant load table");

		}

		btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					y = Integer.parseInt(AdminAccount.thID);

					String query = "select e.Movie_Title, e.Movie_Genre,e.Movie_Rating, s.date, s.time,t.Theater_Name,t.X, t.Y, t.Distance,s.show_ID from Movies e "
							+ "inner join ShowTime s on e.Movie_ID=s.Movie_ID "
							+ "inner join Theater t on s.Theater_ID=t.Theater_ID Where t.Theater_ID in (" + y + ") "
							+ "order by t.Distance asc";

					// String query = "select * from Movies";
					PreparedStatement pst = AddMovie.connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery(); // rs2xml.jar file need to be added in the project libararies
					table.setModel(DbUtils.resultSetToTableModel(rs));// helps to convert rs to table//dbutils is class
																		// inside
																		// rs2xl.jar
					TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
					table.setRowSorter(sorter);
					table.setEnabled(true);
					Font myFont = new Font("Serif", Font.BOLD, 18);
					table.setFont(new Font("Serif", Font.PLAIN, 22));

					table.getColumnModel().getColumn(0).setPreferredWidth(210);
					table.getColumnModel().getColumn(1).setPreferredWidth(40);
					table.getColumnModel().getColumn(2).setPreferredWidth(40);
					table.getColumnModel().getColumn(3).setPreferredWidth(40);
					table.getColumnModel().getColumn(4).setPreferredWidth(210);
					table.getColumnModel().getColumn(5).setMinWidth(0);
					table.getColumnModel().getColumn(5).setMaxWidth(0);

					table.getColumnModel().getColumn(6).setMinWidth(0);
					table.getColumnModel().getColumn(6).setMaxWidth(0);

					table.getColumnModel().getColumn(7).setMinWidth(0);
					table.getColumnModel().getColumn(7).setMaxWidth(0);

					table.getColumnModel().getColumn(8).setMinWidth(0);
					table.getColumnModel().getColumn(8).setMaxWidth(0);

					table.getColumnModel().getColumn(9).setMinWidth(0);
					table.getColumnModel().getColumn(9).setMaxWidth(0);

				} catch (Exception e56) {
					System.out.println("cant load table");

				}

			}
		});
		btnNewButton_1.setBounds(642, 72, 190, -2);
		contentPane.add(btnNewButton_1);

		btnNewButton = new JButton("Remove Selected");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();

				PreparedStatement pst2, pst3, pst4, pst5;

				try {
					String tsd1 = lblTheater.getText();

					String showid = table.getModel().getValueAt(row, 9).toString();

					// id_showTime = table.getModel().getValueAt(row, 7).toString();
					String query4 = "DELETE FROM ShowTime where show_ID=?";
					pst3 = AddMovie.connection.prepareStatement(query4);
					pst3.setString(1, showid);
					pst3.execute();

					JOptionPane.showMessageDialog(null, "Removed: ");

					btnNewButton_1.doClick();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("can't delete showtime:");
				}

			}
		});
		btnNewButton.setBounds(396, 72, 190, 36);
		contentPane.add(btnNewButton);

		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int colCounter = table.getColumnCount();
				int row = table.getSelectedRow();

				String movie_title1 = table.getModel().getValueAt(row, 0).toString();
				ViewMovie.movie_title4 = movie_title1;
				String rating1 = table.getModel().getValueAt(row, 2).toString();
				ViewMovie.rating4 = rating1;

				ViewMovie.ddate = table.getModel().getValueAt(row, 3).toString();

				String genre1 = table.getModel().getValueAt(row, 1).toString();
				ViewMovie.genre4 = genre1;

				ViewMovie.theater4 = lblTheater.getText();
				String showtime1 = table.getModel().getValueAt(row, 4).toString();
				ViewMovie.showtime4 = showtime1;
				String distance2 = table.getModel().getValueAt(row, 8).toString();
				ViewMovie.distance4 = distance2;

				String x2 = table.getModel().getValueAt(row, 6).toString();
				ViewMovie.x3 = x2;

				String y2 = table.getModel().getValueAt(row, 7).toString();
				ViewMovie.y3 = y2;
				// if (!(txtX.getText().isEmpty() || txtY.getText().isEmpty())) {
				// try {
				// int xDiff = Integer.parseInt(txtX.getText()) - Integer.parseInt(x2);
				// int yDiff = Integer.parseInt(txtY.getText()) - Integer.parseInt(y2);
				// Double dis = Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));
				// mile3 = (int) Math.round(dis);
				// System.out.println(mile3);
				// } catch (Exception e1) {
				// JOptionPane.showMessageDialog(null, "please enter number only in location:");
				// return;
				// }
				// } else {
				//
				// }
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

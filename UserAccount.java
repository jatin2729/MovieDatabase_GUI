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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import net.proteanit.sql.DbUtils;

public class UserAccount extends JFrame {

	private JPanel contentPane;
	private JTextField txtXco;
	private JTextField txtYco;
	private JTable table;
	static String theater_id;
	static String zipcode;
	static String Street_add;
	static String theater_name;
	static String movie_name;
	static String state;
	static String phoneNo;
	static String x;
	static String y;
	static String distance11;
	static int mile;
	JButton btnRefresh;
	static String movieID;
	int colcount1;
	static String movie_genre;
	static String movie_Rating;
	// static String theaterID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAccount frame = new UserAccount();
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
	public UserAccount() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1138, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSortByRating = new JLabel("Filter By Rating:");
		lblSortByRating.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSortByRating.setBounds(15, 16, 165, 35);
		contentPane.add(lblSortByRating);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(177, 23, 103, 77);
		contentPane.add(scrollPane);

		String listRating[] = new String[] { "All", "G", "PG", "PG-13", "R", "NC-17" };

		JList list = new JList(listRating);
		list.setFont(new Font("Tahoma", Font.PLAIN, 18));
		list.setVisibleRowCount(5);
		scrollPane.setViewportView(list);

		Object[] indices = list.getSelectedValues();

		for (int i = 0; i < 6; i++) {

		}

		JLabel lblNewLabel_1 = new JLabel("Enter Your Location:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(710, 36, 227, 27);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("X:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(710, 69, 28, 20);
		contentPane.add(lblNewLabel_2);

		JLabel lblY = new JLabel("Y:");
		lblY.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblY.setBounds(814, 70, 28, 20);
		contentPane.add(lblY);

		txtXco = new JTextField();
		txtXco.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtXco.setBounds(741, 67, 69, 33);
		contentPane.add(txtXco);
		txtXco.setColumns(10);

		txtYco = new JTextField();
		txtYco.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtYco.setColumns(10);
		txtYco.setBounds(837, 67, 69, 33);
		contentPane.add(txtYco);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 144, 1071, 295);
		contentPane.add(scrollPane_1);

		// MyTableModel model = new MyTableModel();
		// sorter = new TableRowSorter<MyTableModel>(model);
		//// table = new JTable(model);

		table = new JTable();
		// table.setRowSorter(sorter);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table);

		table.setRowHeight(30);
		// table.setEnabled(false);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));

		try {

			// String query = "select e.Movie_Title, e.Movie_Genre,e.Movie_Rating, s.date,
			// s.time, t.Theater_Name,t.X, t.Y, t.Distance from Movies e "
			// + "inner join ShowTime s on e.Movie_ID=s.Movie_ID "
			// + "inner join Theater t on s.Theater_ID=t.Theater_ID order by s.date desc";

			String query = "select * from Movies";

			PreparedStatement pst = AddMovie.connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery(); // rs2xml.jar file need to be added in the project libararies
			table.setModel(DbUtils.resultSetToTableModel(rs));// helps to convert rs to table//dbutils is class inside
																// rs2xl.jar
			TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
			table.setRowSorter(sorter);
			table.setEnabled(true);

			table.getColumnModel().getColumn(0).setMinWidth(0);
			table.getColumnModel().getColumn(0).setMaxWidth(0);
			table.getColumnModel().getColumn(0).setWidth(0);

			table.getColumnModel().getColumn(1).setPreferredWidth(400);
			table.getColumnModel().getColumn(2).setPreferredWidth(10);
			table.getColumnModel().getColumn(3).setPreferredWidth(0);
			table.getColumnModel().getColumn(4).setPreferredWidth(10);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

			// RowFilter<TableModel, Object> rf = null;
			//
			// try {
			// rf = RowFilter.regexFilter(list.getSelectedValue().toString());
			// } catch (java.util.regex.PatternSyntaxException e) {
			// return;
			// }
			// sorter.setRowFilter(rf);

			Font myFont = new Font("Serif", Font.BOLD, 18);
			table.setFont(new Font("Serif", Font.PLAIN, 22));

		} catch (Exception e) {
			System.out.println("cant load table");

		}

		JButton btnNewButton = new JButton("Sort by Distance");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colcount1 = table.getColumnCount();
				if (colcount1 != 5 || colcount1 == 9) {
					for (int i = 0; i < table.getRowCount(); ++i) {
						String theaterName;
						if (colcount1 == 9) {
							theaterName = table.getModel().getValueAt(i, 1).toString();
						} else {
							theaterName = table.getModel().getValueAt(i, 5).toString();
						}
						int xDiff1, yDiff1;
						Double dis1;
						String x1 = table.getModel().getValueAt(i, 6).toString();
						String y1 = table.getModel().getValueAt(i, 7).toString();

						if (txtXco.getText().isEmpty() || txtYco.getText().isEmpty()) {
							xDiff1 = Integer.parseInt(x1);
							yDiff1 = Integer.parseInt(y1);
						} else {

							xDiff1 = Integer.parseInt(txtXco.getText()) - Integer.parseInt(x1);
							yDiff1 = Integer.parseInt(txtYco.getText()) - Integer.parseInt(y1);
						}
						dis1 = Math.sqrt((xDiff1 * xDiff1) + (yDiff1 * yDiff1));
						mile = (int) Math.round(dis1);
						System.out.println(mile);

						PreparedStatement pst;
						String query = "update Theater set Distance='" + mile + "' where Theater_Name='" + theaterName
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
				} else {

				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(929, 66, 172, 29);
		contentPane.add(btnNewButton);

		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int colCounter = table.getColumnCount();
				int row = table.getSelectedRow();
				// System.out.println(rowcounter);
				if (colCounter == 5) {
					movieID = table.getModel().getValueAt(row, 0).toString();
					movie_name = table.getModel().getValueAt(row, 1).toString();
					movie_genre = table.getModel().getValueAt(row, 4).toString();
					movie_Rating = table.getModel().getValueAt(row, 3).toString();

					AllMovies frame = new AllMovies();
					frame.setVisible(true);
					System.out.println(movieID);
				} else {
					theater_id = table.getModel().getValueAt(row, 0).toString();
					theater_name = table.getModel().getValueAt(row, 1).toString();
					Street_add = table.getModel().getValueAt(row, 2).toString();
					zipcode = table.getModel().getValueAt(row, 3).toString();

					state = table.getModel().getValueAt(row, 4).toString();
					phoneNo = table.getModel().getValueAt(row, 5).toString();
					x = table.getModel().getValueAt(row, 6).toString();
					y = table.getModel().getValueAt(row, 7).toString();
					distance11 = table.getModel().getValueAt(row, 8).toString();

					if (!(txtXco.getText().isEmpty() || txtYco.getText().isEmpty())) {
						try {
							int xDiff = Integer.parseInt(txtXco.getText()) - Integer.parseInt(x);
							int yDiff = Integer.parseInt(txtYco.getText()) - Integer.parseInt(y);
							Double dis = Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));
							mile = (int) Math.round(dis);
							System.out.println(mile);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "please enter number only in location:");
							return;
						}
					} else {

					}
					AllTheaters frame = new AllTheaters();
					frame.setVisible(true);
					// xxx frame = new xxx();
					// frame.setVisible(true);
				}
				// frame.textField_time.setText(time);
				// frame.textField_theater.setText(theater);

			}
		});

		btnRefresh = new JButton("Refresh Table");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int colcount2 = table.getColumnCount();
				if (colcount2 != 5) {

					try {

						// String query = "select e.Movie_Title, e.Movie_Genre,e.Movie_Rating, s.date,
						// s.time, t.Theater_Name,t.X, t.Y, t.Distance from Movies e "
						// + "inner join ShowTime s on e.Movie_ID=s.Movie_ID "
						// + "inner join Theater t on s.Theater_ID=t.Theater_ID order by t.Distance
						// asc";

						String query = "Select * from Theater order by Distance asc";

						PreparedStatement pst = AddMovie.connection.prepareStatement(query);
						ResultSet rs = pst.executeQuery(); // rs2xml.jar file need to be added in the project libararies
						table.setModel(DbUtils.resultSetToTableModel(rs));// helps to convert rs to table//dbutils is
																			// class
																			// inside
																			// rs2xl.jar
						TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
						table.setRowSorter(sorter);

						table.getColumnModel().getColumn(0).setMinWidth(0);
						table.getColumnModel().getColumn(0).setMaxWidth(0);
						table.getColumnModel().getColumn(0).setWidth(0);

						table.getColumnModel().getColumn(1).setPreferredWidth(400);
						table.getColumnModel().getColumn(2).setPreferredWidth(260);
						table.getColumnModel().getColumn(3).setPreferredWidth(100);
						table.getColumnModel().getColumn(4).setPreferredWidth(60);
						table.getColumnModel().getColumn(5).setPreferredWidth(250);
						table.getColumnModel().getColumn(6).setPreferredWidth(60);
						table.getColumnModel().getColumn(7).setPreferredWidth(60);
						table.getColumnModel().getColumn(8).setPreferredWidth(80);
						table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
						// table.setEnabled(true);
						table.setEnabled(true);

						Font myFont = new Font("Serif", Font.BOLD, 18);
						table.setFont(new Font("Serif", Font.PLAIN, 22));

					} catch (Exception e2) {
						System.out.println("cant load table");

					}
				} else {

				}
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRefresh.setBounds(929, 99, 164, -2);
		contentPane.add(btnRefresh);

		JButton btnFilter = new JButton("Filter");
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				table = new JTable();
				// table.setRowSorter(sorter);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				scrollPane_1.setViewportView(table);

				table.setRowHeight(26);
				table.setEnabled(false);
				table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
				// List list12 = list.getSelectedValuesList();
				Object[] selected = list.getSelectedValues();

				String check = "(";
				String selection[] = new String[selected.length];
				if (selection.length == 0) {
					check = "('pg-13','pg','g','nc-17','r')";
				}
				for (int i = 0; i < selection.length; ++i) {

					selection[i] = selected[i].toString().toLowerCase();
					if (!selection[i].equals("all")) {

						if (i != selection.length - 1) {
							check += "'" + selection[i] + "',";
						} else if (selection.length == 1) {
							check = "('" + selection[0] + "')";
						} else {
							check += "'" + selection[i] + "')";
						}
					} else {
						check = "('pg-13','pg','g','nc-17','r')";
					}

				}
				System.out.println(check);

				try {
					String query21 = "select * from Movies where Movie_Rating in " + check
							+ "order by Movie_Release_Date asc";
					// String query21 = "select e.Movie_Title, e.Movie_Genre,e.Movie_Rating, s.date,
					// s.time, t.Theater_Name,t.X, t.Y, t.Distance from Movies e "
					// + "inner join ShowTime s on e.Movie_ID=s.Movie_ID "
					// + "inner join Theater t on s.Theater_ID=t.Theater_ID " + "Where
					// e.Movie_Rating in " + ""
					// + check + "" + "order by t.Distance asc";
					System.out.println(query21);

					// String query22 = "select e.Movie_Title, e.Movie_Genre,e.Movie_Rating, s.date,
					// s.time, t.Theater_Name,t.X, t.Y, t.Distance from Movies e "
					// + "inner join ShowTime s on e.Movie_ID=s.Movie_ID "
					// + "inner join Theater t on s.Theater_ID=t.Theater_ID " + "Where
					// e.Movie_Rating in ("
					//
					// + "order by t.Distance asc";
					// WHERE e.Movie_Rating='pg-13'

					PreparedStatement pst21 = AddMovie.connection.prepareStatement(query21);
					ResultSet rs21 = pst21.executeQuery(); // rs2xml.jar file need to be added in the

					// table.setModel(new DefaultTableModel());
					table.setModel(DbUtils.resultSetToTableModel(rs21));
					table.setEnabled(true);

					Font myFont = new Font("Serif", Font.BOLD, 18);
					table.setFont(new Font("Serif", Font.PLAIN, 20));
					System.out.println("table loaded");

					table.addMouseListener(new MouseAdapter() {

						@Override
						public void mouseClicked(java.awt.event.MouseEvent e) {
							int colCounter = table.getColumnCount();
							int row = table.getSelectedRow();
							// System.out.println(rowcounter);
							if (colCounter == 5) {
								movieID = table.getModel().getValueAt(row, 0).toString();
								theater_name = table.getModel().getValueAt(row, 1).toString();

								AllMovies frame = new AllMovies();
								frame.setVisible(true);
								System.out.println(movieID);
							} else {

								theater_id = table.getModel().getValueAt(row, 0).toString();
								zipcode = table.getModel().getValueAt(row, 3).toString();
								Street_add = table.getModel().getValueAt(row, 2).toString();
								theater_name = table.getModel().getValueAt(row, 1).toString();
								state = table.getModel().getValueAt(row, 4).toString();
								phoneNo = table.getModel().getValueAt(row, 5).toString();
								x = table.getModel().getValueAt(row, 6).toString();
								y = table.getModel().getValueAt(row, 7).toString();

								if (!(txtXco.getText().isEmpty() || txtYco.getText().isEmpty())) {
									try {
										int xDiff = Integer.parseInt(txtXco.getText()) - Integer.parseInt(x);
										int yDiff = Integer.parseInt(txtYco.getText()) - Integer.parseInt(y);
										Double dis = Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));
										mile = (int) Math.round(dis);
										System.out.println(mile);
									} catch (Exception e1) {
										JOptionPane.showMessageDialog(null, "please enter number only in location:");
										return;
									}
								} else {

								}

								AllTheaters frame = new AllTheaters();
								frame.setVisible(true);

								// xxx frame = new xxx();
								// frame.setVisible(true);
							}
							// frame.textField_time.setText(time);
							// frame.textField_theater.setText(theater);

						}
					});

					// table.addMouseListener(new MouseAdapter() {
					//
					// @Override
					// public void mouseClicked(java.awt.event.MouseEvent e) {
					//
					// int row = table.getSelectedRow();
					// int col = table.getColumnCount();
					// if (col == 9) {
					// title = table.getModel().getValueAt(row, 0).toString();
					// releasedate = table.getModel().getValueAt(row, 3).toString();
					// rating = table.getModel().getValueAt(row, 2).toString();
					// genre = table.getModel().getValueAt(row, 1).toString();
					// time = table.getModel().getValueAt(row, 4).toString();
					// theater = table.getModel().getValueAt(row, 5).toString();
					// x = table.getModel().getValueAt(row, 6).toString();
					// y = table.getModel().getValueAt(row, 7).toString();
					//
					// if (!(txtXco.getText().isEmpty() || txtYco.getText().isEmpty())) {
					// try {
					// int xDiff = Integer.parseInt(txtXco.getText()) - Integer.parseInt(x);
					// int yDiff = Integer.parseInt(txtYco.getText()) - Integer.parseInt(y);
					// Double dis = Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));
					// mile = (int) Math.round(dis);
					// System.out.println(mile);
					// } catch (Exception e1) {
					// JOptionPane.showMessageDialog(null, "please enter number only in location:");
					// return;
					// }
					// } else {
					//
					// }
					//
					// xxx frame = new xxx();
					// frame.setVisible(true);
					// } else {
					//
					// }
					// }
					// });

				} catch (Exception e2) {
					System.out.println("cant load table");

				}

			}
		});
		btnFilter.setBounds(177, 104, 115, 29);
		contentPane.add(btnFilter);

		JButton btnViewMovies = new JButton("View Movies");
		btnViewMovies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from Movies";
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

					table.getColumnModel().getColumn(0).setMinWidth(0);
					table.getColumnModel().getColumn(0).setMaxWidth(0);
					table.getColumnModel().getColumn(0).setWidth(0);

					table.getColumnModel().getColumn(1).setPreferredWidth(400);
					table.getColumnModel().getColumn(2).setPreferredWidth(10);
					table.getColumnModel().getColumn(3).setPreferredWidth(0);
					table.getColumnModel().getColumn(4).setPreferredWidth(10);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

				} catch (Exception e0) {
					System.out.println("cant load table");
				}

			}
		});
		btnViewMovies.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewMovies.setBounds(381, 36, 146, 47);
		contentPane.add(btnViewMovies);

		JButton btnViewTheaters = new JButton("View Theaters");
		btnViewTheaters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String query = "select * from Theater";
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
					// table.getColumnModel().getColumn(0).setPreferredWidth(-0);

					table.getColumnModel().getColumn(0).setMinWidth(0);
					table.getColumnModel().getColumn(0).setMaxWidth(0);
					table.getColumnModel().getColumn(0).setWidth(0);

					table.getColumnModel().getColumn(1).setPreferredWidth(400);
					table.getColumnModel().getColumn(2).setPreferredWidth(260);
					table.getColumnModel().getColumn(3).setPreferredWidth(100);
					table.getColumnModel().getColumn(4).setPreferredWidth(60);
					table.getColumnModel().getColumn(5).setPreferredWidth(250);
					table.getColumnModel().getColumn(6).setPreferredWidth(60);
					table.getColumnModel().getColumn(7).setPreferredWidth(60);
					table.getColumnModel().getColumn(8).setPreferredWidth(80);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

				} catch (Exception e0) {
					System.out.println("cant load table");
				}
			}
		});
		btnViewTheaters.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewTheaters.setBounds(381, 81, 146, 47);
		contentPane.add(btnViewTheaters);

	}
}

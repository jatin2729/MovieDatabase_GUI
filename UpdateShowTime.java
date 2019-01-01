import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class UpdateShowTime extends JFrame {

	private JPanel contentPane;
	String time = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateShowTime frame = new UpdateShowTime();
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
	 */
	public UpdateShowTime() throws ParseException {
		setTitle("Update Showtime");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 654, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Theater:");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(91, 138, 77, 37);
		contentPane.add(label);

		JComboBox cmbHH = new JComboBox();
		cmbHH.setToolTipText("HH");
		cmbHH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cmbHH.setBounds(177, 278, 60, 32);
		contentPane.add(cmbHH);
		for (int i = 1; i <= 12; ++i) {
			cmbHH.addItem(i);
		}

		JComboBox cmbMIN = new JComboBox();
		cmbMIN.setToolTipText("MM");
		cmbMIN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cmbMIN.setBounds(234, 278, 60, 32);
		contentPane.add(cmbMIN);
		for (int i = 0; i <= 9; ++i) {
			cmbMIN.addItem("0" + i);
		}
		for (int i = 10; i <= 59; ++i) {
			cmbMIN.addItem(i);
		}

		JComboBox cmb_am_pm = new JComboBox();
		cmb_am_pm.setToolTipText("AM/PM");
		cmb_am_pm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cmb_am_pm.setBounds(300, 278, 60, 32);
		contentPane.add(cmb_am_pm);
		cmb_am_pm.addItem("PM");
		cmb_am_pm.addItem("AM");

		JLabel label_4 = new JLabel("Time:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_4.setBounds(117, 278, 51, 37);
		contentPane.add(label_4);

		JButton btnAddTime = new JButton("Add Time:");
		btnAddTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				time = time + cmbHH.getSelectedItem().toString() + ":" + cmbMIN.getSelectedItem().toString() + " "
						+ cmb_am_pm.getSelectedItem().toString() + ", ";
			}
		});
		btnAddTime.setBounds(368, 281, 115, 29);
		contentPane.add(btnAddTime);

		JLabel lblMovies = new JLabel("Movies:");
		lblMovies.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMovies.setBounds(103, 9, 65, 37);
		contentPane.add(lblMovies);

		String[] theaterarr = new String[50];

		PreparedStatement pst;
		try {
			String query = "select Theater_Name from Theater";
			pst = AddMovie.connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			int i = 0;
			while (rs.next()) {

				theaterarr[i] = rs.getString(1);
				System.out.println(rs.getString(1));
				i++;
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
			System.out.println("No such theater:");
		}
		// Object theater = listTheater.getSelectedValue();
		String[] movieArr = new String[50];

		PreparedStatement pst1;
		try {
			String query = "select Movie_Title from Movies";
			pst1 = AddMovie.connection.prepareStatement(query);
			ResultSet rs = pst1.executeQuery();
			int i = 0;
			while (rs.next()) {

				movieArr[i] = rs.getString(1);
				// System.out.println(rs.getString(1));
				i++;
			}

		} catch (SQLException e1) {

			System.out.println("No such Movies:");
		}

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(177, 141, 283, 100);
		contentPane.add(scrollPane_2);

		JList listTheater = new JList(theaterarr);
		scrollPane_2.setViewportView(listTheater);
		listTheater.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listTheater.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(177, 16, 283, 106);
		contentPane.add(scrollPane_1);

		JList listMovies = new JList(movieArr);
		listMovies.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane_1.setViewportView(listMovies);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement pst4, pst5, pst6, pst7, pst8;
				String movie = (String) listMovies.getSelectedValue();

				Random rand = new Random();
				int y = rand.nextInt(30000) + 1;

				try {

					String query6 = "select Movie_ID from Movies where Movie_Title='" + movie + "' ";
					pst6 = AddMovie.connection.prepareStatement(query6);
					ResultSet rs1 = pst6.executeQuery();
					System.out.println("movie id= " + rs1.getString(1));

					String query9 = "select Movie_Release_Date from Movies where Movie_Title='" + movie + "' ";
					PreparedStatement pst9 = AddMovie.connection.prepareStatement(query9);
					ResultSet rs9 = pst9.executeQuery();
					System.out.println(rs9.getString(1));

					String query7 = "select Theater_ID from Theater where Theater_Name='"
							+ listTheater.getSelectedValue().toString() + "' ";
					pst7 = AddMovie.connection.prepareStatement(query7);
					ResultSet rs2 = pst7.executeQuery();
					System.out.println("Theater id= " + rs2.getString(1));

					String query2 = "insert into ShowTime (show_ID,date,time,Movie_ID,Theater_ID) values (?,?,?,?,?)";
					int cut = time.lastIndexOf(",");
					String time1 = time.substring(0, cut);
					System.out.println(time1);
					pst8 = AddMovie.connection.prepareStatement(query2);
					pst8.setInt(1, y);
					pst8.setString(2, rs9.getString(1));
					pst8.setString(3, time1);
					pst8.setString(4, rs1.getString(1));
					pst8.setString(5, rs2.getString(1));
					pst8.execute();
					pst8.close();
					pst6.close();
					pst7.close();
					pst9.close();
					rs9.close();

					JOptionPane.showMessageDialog(null, "Showtime Updated:");
					// System.out.println("Showtime inserted:");

					UpdateShowTime.super.dispose();

				} catch (SQLException e12) {
					JOptionPane.showMessageDialog(null, "Can not update movie:");
					// System.out.println(e12);
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnUpdate.setBounds(187, 341, 242, 45);
		contentPane.add(btnUpdate);

	}
}

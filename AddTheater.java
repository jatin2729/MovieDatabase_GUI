import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

public class AddTheater extends JFrame {

	private JPanel contentPane;
	private JTextField txtTheater;
	private JTextField txtAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTheater frame = new AddTheater();
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
	public AddTheater() throws ParseException {
		setTitle("Add Theater");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 501, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		MaskFormatter mf1 = new MaskFormatter("###-###-####");
		mf1.setPlaceholderCharacter('_');

		JFormattedTextField txtPhoneNo = new JFormattedTextField(mf1);
		txtPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 18));

		txtPhoneNo.setBounds(174, 233, 261, 35);
		contentPane.add(txtPhoneNo);

		MaskFormatter mf2 = new MaskFormatter("#####");
		mf2.setPlaceholderCharacter(' ');
		JFormattedTextField txtZipcode = new JFormattedTextField(mf2);
		txtZipcode.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtZipcode.setBounds(175, 146, 118, 35);
		contentPane.add(txtZipcode);

		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLocation.setBounds(38, 284, 132, 20);
		contentPane.add(lblLocation);

		JLabel lblX = new JLabel("X:");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblX.setBounds(175, 284, 22, 20);
		contentPane.add(lblX);

		JLabel lblY = new JLabel("Y:");
		lblY.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblY.setBounds(298, 285, 22, 20);
		contentPane.add(lblY);

		// MaskFormatter mf5 = new MaskFormatter("####");
		JFormattedTextField txtXco = new JFormattedTextField();
		txtXco.setToolTipText("X cordinate");
		txtXco.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtXco.setBounds(198, 284, 61, 26);

		contentPane.add(txtXco);

		// MaskFormatter mf6 = new MaskFormatter("####");
		JFormattedTextField txtYco = new JFormattedTextField();
		txtYco.setToolTipText("Y cordinate");
		txtYco.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtYco.setBounds(321, 284, 61, 26);
		contentPane.add(txtYco);

		JLabel lblTheaterName = new JLabel("Theater Name:");
		lblTheaterName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTheaterName.setBounds(38, 69, 132, 20);
		contentPane.add(lblTheaterName);

		txtTheater = new JTextField();
		txtTheater.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTheater.setBounds(175, 58, 260, 35);
		contentPane.add(txtTheater);
		txtTheater.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAddress.setColumns(10);
		txtAddress.setBounds(175, 99, 260, 35);
		contentPane.add(txtAddress);

		JLabel lblStreetAdd = new JLabel("Street Add:");
		lblStreetAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStreetAdd.setBounds(38, 110, 132, 20);
		contentPane.add(lblStreetAdd);

		JLabel lblZipCode = new JLabel("Zip Code:");
		lblZipCode.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblZipCode.setBounds(38, 152, 132, 20);
		contentPane.add(lblZipCode);

		JLabel lblState = new JLabel("State:");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblState.setBounds(38, 197, 132, 20);
		contentPane.add(lblState);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(175, 192, 74, 26);
		comboBox.addItem("NY");
		comboBox.addItem("NJ");
		comboBox.addItem("CT");
		comboBox.addItem("MA");
		comboBox.addItem("MD");
		comboBox.addItem("FL");
		comboBox.addItem("CA");

		contentPane.add(comboBox);

		JLabel lblPhoneNo = new JLabel("Phone No:");
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhoneNo.setBounds(38, 240, 132, 20);
		contentPane.add(lblPhoneNo);

		Connection connection = sqliteConnection.dbConnector();

		JButton btnAddTheater = new JButton("Add Theater");
		btnAddTheater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!(txtAddress.getText().isEmpty() || txtTheater.getText().isEmpty() || txtPhoneNo.getText().isEmpty()
						|| txtXco.getText().isEmpty() || txtYco.getText().isEmpty()
						|| txtZipcode.getText().isEmpty())) {

					try {

						Random rand = new Random();
						int y = rand.nextInt(30000) + 1;

						PreparedStatement pst;
						String query = "insert into Theater (Theater_ID,Theater_Name,Street_Add,Zip_Code,State,Phone_no,X,Y,Distance) values (?,?,?,?,?,?,?,?,?)";
						pst = connection.prepareStatement(query);
						pst.setInt(1, y);
						pst.setString(2, txtTheater.getText().toLowerCase());
						pst.setString(3, txtAddress.getText());
						pst.setString(4, txtZipcode.getText());
						pst.setString(5, comboBox.getSelectedItem().toString());
						pst.setString(6, txtPhoneNo.getText());
						pst.setString(7, txtXco.getText());
						pst.setString(8, txtYco.getText());
						pst.setInt(9, 0);
						pst.execute();
						pst.close();
						JOptionPane.showMessageDialog(null, "Theater Added");
						AddTheater.super.dispose();

					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Theater already exist:");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Please fill all the Fields:");
				}
			}
		});
		btnAddTheater.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddTheater.setBounds(68, 331, 166, 54);
		contentPane.add(btnAddTheater);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddTheater.super.dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancel.setBounds(249, 331, 160, 54);
		contentPane.add(btnCancel);

	}
}

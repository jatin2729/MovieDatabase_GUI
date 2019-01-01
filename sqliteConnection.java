import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class sqliteConnection {
	static Connection conn = null;

	public static Connection dbConnector() {
		try {
			/**
			 * 
			 * forname is method in the class namned Class
			 */
			Class.forName("org.sqlite.JDBC");// loading driver from library (mysql connector driver)
			/**
			 * get connection is a method in
			 */
			Connection conn = DriverManager
					.getConnection("jdbc:sqlite:D:\\CS313\\Moviedatabase 370 Project4\\database\\MovieDataBase.db");

			// JOptionPane.showMessageDialog(null, "connection successful");
			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			JOptionPane.showMessageDialog(null, "connection Failed");
			return null;
		}
	}
}

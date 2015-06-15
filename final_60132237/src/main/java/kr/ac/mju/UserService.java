package kr.ac.mju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import org.junit.runner.Request;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private String URL = "jdbc:mysql://localhost:3306/lms";
	private final static String ID = "sogong";
	private final static String PASSWORD = "mju12345";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, ID, PASSWORD);
	}

	public void insertData(User user) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		connection = getConnection();
		
		String insertData = "INSERT INTO MEMBER "
				+ "(ID, PW, NAME, POS) VALUES"
				+ "(?, ?, ?, ?)";
		statement = connection.prepareStatement(insertData);

		statement.setString(1, user.getID());
		statement.setString(2, user.getPassword());
		statement.setString(3, user.getName());
		statement.setString(4, user.getPos());
		statement.executeUpdate();
		
		connection.close();
		statement.close();
	}
}

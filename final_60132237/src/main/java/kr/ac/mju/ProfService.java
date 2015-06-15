package kr.ac.mju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import org.springframework.stereotype.Service;

@Service
public class ProfService {
	private final static String URL = "jdbc:mysql://localhost:3306/lms";
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

	public void createClass(Gangjwa gangjwa) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		connection = getConnection();
		
		String insertData = "INSERT INTO GANGJWA "
				+ "(ID, PROF_name, NAME, YEAR, GRADE, MAX, CREDIT) VALUES"
				+ "(?, ?, ?, ?, ?, ?, ?)";
		statement = connection.prepareStatement(insertData);

		statement.setString(1, gangjwa.getId());
		statement.setString(2, gangjwa.getProf_name());
		statement.setString(3, gangjwa.getName());
		statement.setString(4, gangjwa.getYear());
		statement.setString(5, gangjwa.getGrade());
		statement.setString(6, gangjwa.getMax());
		statement.setString(7, gangjwa.getCredit());
		statement.executeUpdate();
		
		connection.close();
		statement.close();
	}

	public Vector<Gangjwa> List() throws SQLException {
		
		Vector<Gangjwa> gangjwaList = new Vector<Gangjwa>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		String sql = "select * from lms.gangjwa;";

		connection = getConnection();
		statement = connection.prepareStatement(sql);
		resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Gangjwa gangjwa = new Gangjwa();
				gangjwa.setId(resultSet.getString("id"));
				gangjwa.setProf_name(resultSet.getString("prof_name"));
				gangjwa.setName(resultSet.getString("name"));
				gangjwa.setYear(resultSet.getString("year"));
				gangjwa.setGrade(resultSet.getString("grade"));
				gangjwa.setMax(resultSet.getString("max"));
				gangjwa.setCredit(resultSet.getString("credit"));
				gangjwaList.add(gangjwa);
			}
			resultSet.close();
			
			connection.close();
			statement.close();

		return gangjwaList;
	}
	
	public void Grade(Regist regist) throws SQLException{
		Connection connection = null;
		PreparedStatement statement = null;

		String sql = "update lms.sugang set classgrade = ? where stuname =? and name = ?;";

		connection = getConnection();
		statement = connection.prepareStatement(sql);
		
		statement = connection.prepareStatement(sql);
		statement.setString(1, regist.getClassGrade());
		statement.setString(2, regist.getStudentname());
		statement.setString(3, regist.getClassname());
			
		statement.executeUpdate();
		
		connection.close();
		statement.close();
	}

	public Vector<Regist> grantGrade(String no) throws SQLException {

		Vector<Regist> registList = new Vector<Regist>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String number = null;

		String sql = "select * from lms.sugang;";

		connection = getConnection();
		statement = connection.prepareStatement(sql);
		resultSet = statement.executeQuery();

		while (resultSet.next()) {
			Regist regist = new Regist();
			number = resultSet.getString("no");
			if (no.equals(number)) {
				regist.setStudentname(resultSet.getString("stuname"));
				regist.setNo(resultSet.getString("no"));
				regist.setProname(resultSet.getString("proname"));
				regist.setClassname(resultSet.getString("name"));
				regist.setYear(resultSet.getString("year"));
				regist.setGrade(resultSet.getString("grade"));
				regist.setMax(resultSet.getString("max"));
				regist.setCredit(resultSet.getString("credit"));
				regist.setClassGrade(resultSet.getString("classgrade"));
				registList.add(regist);
			}
		}
		resultSet.close();
		
		connection.close();
		statement.close();

		return registList;
	}

}

package kr.ac.mju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
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
	
	private void closeConnection(Connection connection, 
			Statement statement, ResultSet resultSet) throws SQLException {
		if(connection == null) {
			return;
		}
		connection.close();
		statement.close();
		resultSet.close();
	}
	
	
	
	
	public void create() throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306", 
				"root",
				"tiger");
		String accountSQL = "grant all privileges on *.* to sogong@localhost "
				+ "identified by 'mju12345' with grant option;";
		statement = connection.prepareStatement(accountSQL);
		statement.executeUpdate();
		System.out.println("sogong 계정 생성");
		
		connection.close();
		statement.close();
		
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306", 
				"sogong",
				"mju12345");
		String dbSQL = "create database lms;";
		statement = connection.prepareStatement(dbSQL);
		statement.executeUpdate();
		System.out.println("lms 데이터베이스 생성");
		
		connection.close();
		statement.close();
		
		connection = getConnection();
		String tableSQL = "CREATE TABLE MEMBER"
				+ "(ID VARCHAR(10),"
				+ "PW VARCHAR(10),"
				+ "NAME VARCHAR(10),"
				+ "POS VARCHAR(10));";
		statement = connection.prepareStatement(tableSQL);
		statement.executeUpdate();
		statement.close();
		
		tableSQL = "CREATE TABLE GANGJWA"
				+ "(ID VARCHAR(10),"
				+ "PROF_NAME VARCHAR(10),"
				+ "NAME VARCHAR(30),"
				+ "YEAR VARCHAR(10),"
				+ "GRADE VARCHAR(10),"
				+ "MAX VARCHAR(10),"
				+ "CREDIT VARCHAR(10));";
		statement = connection.prepareStatement(tableSQL);
		statement.executeUpdate();

		statement.close();
		
		tableSQL = "CREATE TABLE sugang"
				+ "(stuname VARCHAR(10),"
				+ "no VARCHAR(10),"
				+ "proname VARCHAR(30),"
				+ "name VARCHAR(10),"
				+ "year VARCHAR(10),"
				+ "GRADE VARCHAR(10),"
				+ "MAX VARCHAR(10),"
				+ "CREDIT VARCHAR(10),"
				+ "classgrade VARCHAR(10));";
		statement = connection.prepareStatement(tableSQL);
		statement.executeUpdate();

		connection.close();
		statement.close();
	}
	
	public void drop() throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		connection = getConnection();
		
		String dropTableSQL = "drop table member;";
		statement = connection.prepareStatement(dropTableSQL);
		statement.executeUpdate();
		statement.close();
		
		dropTableSQL = "drop table gangjwa;";
		statement = connection.prepareStatement(dropTableSQL);
		statement.executeUpdate();

		statement.close();
		
		dropTableSQL = "drop table sugang;";
		statement = connection.prepareStatement(dropTableSQL);
		statement.executeUpdate();

		statement.close();
		
		String dropDBSQL = "drop database lms";
		statement = connection.prepareStatement(dropDBSQL);
		statement.executeUpdate();
		System.out.println("drop DB");
		
		connection.close();
		statement.close();
		
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306", 
				"root",
				"tiger");
		String dropAccount = "drop user sogong@localhost;";
		statement = connection.prepareStatement(dropAccount);
		statement.executeUpdate();
		
		connection.close();
		statement.close();
	}

	public User login(String userID, String userPassword) 
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "select * from member";
		User user = null;
		
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		resultSet = statement.executeQuery();
		while(resultSet.next()) {
			String id = resultSet.getString("id");
			String password = resultSet.getString("pw");
			
			if(id.equals(userID) && password.equals(userPassword)) {
				user = new User();
				user.setID(id);
				user.setName(resultSet.getString("name"));
				user.setPassword(password);
				user.setPos(resultSet.getString("pos"));
				closeConnection(connection, statement, resultSet);
				return user;
			}
		}
			
		closeConnection(connection, statement, resultSet);
		return null;
	}

}

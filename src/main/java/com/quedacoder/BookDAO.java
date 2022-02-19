package com.quedacoder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class BookDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/book_store";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Sdub4life";
	private Connection jdbcConnection;
	
	public void connect() throws ClassNotFoundException {
		try {
			
			// only need to connect if not already connected
			if (jdbcConnection == null || jdbcConnection.isClosed()) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
				System.out.println("Connection Established to MySQL Database");
			}
		} catch (SQLException e) { // wrapping in a try/catch block because these sql methods can throw SQLExceptions
			e.printStackTrace();
		}
		
	}
	
	public void disconnect() {
		try {
			// Only disconnect if already connected
			if (jdbcConnection != null && !jdbcConnection.isClosed()) {
				jdbcConnection.close(); 
				System.out.println("MySQL database connection closed.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Book> listAllBooks() {
		
		ArrayList<Book> bookList = new ArrayList<>();
		
		try {
			connect();
			Statement statement = jdbcConnection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM book");
			
			while(resultSet.next()) {
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				float price = resultSet.getFloat("price");
				bookList.add(new Book(title, author, price));
			}
			
			// cleanup
			resultSet.close();
		    statement.close();
		    disconnect(); 
		}
	    catch (SQLException | ClassNotFoundException e) {
	    	e.printStackTrace();
	    }
		
		return bookList;
	}
	
	public boolean insertBook(Book book) {
		
		boolean rowInserted = true;
		
		try {
			connect();
			String sql = "INSERT INTO book ( title, author, price ) VALUES ( ?, ?, ? )";
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setFloat(3, book.getPrice());
			rowInserted = statement.executeUpdate() > 0;
			statement.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		disconnect();
		return rowInserted;
	}

}

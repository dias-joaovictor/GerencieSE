package model;

import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataBase {
	public static Connection getConnection() throws Exception{
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/estoquedb","root", "root");
//		return conn;
		
		//Pool de conexões usando C3PO
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		//cpds.setJdbcUrl("jdbc:mysql://localhost/estoquedb");  //<-- local
		//cpds.setUser("root");
		//cpds.setPassword("root");
		
		cpds.setJdbcUrl("jdbc:mysql://estoquedb.servebbs.com:3306/estoquedb");
		cpds.setUser("rootdb");
		cpds.setPassword("connection.root");
		cpds.setMinPoolSize(1);
		cpds.setMaxPoolSize(20);
	
		Connection conn = cpds.getConnection();
		return conn;
	}
}

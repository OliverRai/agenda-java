package br.com.caelum.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
	    System.out.println("Conectando ao banco");
	    try {
	            //Class.forName("com.mysql.jdbc.Driver");
	            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); //Essa linha foi a diferenša
	            return DriverManager.getConnection("jdbc:mysql://localhost/fj21?useTimezone=true&serverTimezone=America/Sao_Paulo", "root", "laberinto1");
	            } catch(SQLException e) {
	                e.printStackTrace();
	                throw new RuntimeException(e);
	                
	        }
	         
	    }
}
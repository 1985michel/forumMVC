package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CRUD {
	
	static DbUser dbUser;
	public String address;
	public static String diretorioDb = "D:/Program Files/JDBC_CRUD/hsqldb-2.3.3/hsqldb/db/";

	public CRUD(DbUser user) {
		CRUD.dbUser = user;				
		//address = "jdbc:hsqldb:file:"+diretorioDb + dbUser.getLogin();	
		address = "jdbc:postgresql://localhost:5433/usuarios";
	}
	
	public DbUser getDbUser(){
		return CRUD.dbUser;
	}

	static {
		try {
			//Class.forName("org.hsqldb.jdbcDriver");
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Não foi poss�vel carregar o driver do Banco de Dados");
		}
	}

	

}

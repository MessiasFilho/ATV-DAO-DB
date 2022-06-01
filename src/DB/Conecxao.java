package DB;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Conecxao {

	public static Connection conn = null ; 
	
	
	public static  Connection getConnection() {
		if  (conn == null  ) {
			try {
				Properties por = LoadProperties  (); 
				String url = por.getProperty("dburl"); 
				conn = DriverManager.getConnection(url,por); 
			}catch (SQLException e ) {
				throw new DB_EXP(e.getMessage()); 
				
			}
		}
		return conn ; 
	}
	
	public static void closeConnection () {
		if (conn != null  ) {
			try {
				conn.close();
			}catch (SQLException e ) {
				throw new DB_EXP(e.getMessage()); 
			}
		}
	}
	
	
	private static Properties LoadProperties  () {
		
		try { FileInputStream fs = new FileInputStream ("DB.propriedades"); 
			Properties prop =  new Properties (); 
			prop.load(fs);
			return prop; 
		}catch (IOException e) {
			throw new DB_EXP(e.getMessage() ); 
		}
	}
	
	public static void closeStatement (Statement st) {
			if (st != null) {
			try {	
				st.close();
			}catch (SQLException e ) {
				throw new DB_EXP(e.getMessage());
			}
		}
		
		
	}
	
	public static void closeResultSet (ResultSet rs) {
		if (rs != null) {
		try {	
			rs.close();
		}catch (SQLException e ) {
			throw new DB_EXP(e.getMessage());
		}
	}
	
	
}
	
}

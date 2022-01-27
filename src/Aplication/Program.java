package Aplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DB.Conecxao;
import DB.DB_EXP;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Connection conn = null ; 
		Statement st = null ; 
		ResultSet rs = null ; 
		try {
			
			conn = Conecxao.getConnection() ; 
			st = conn.createStatement() ; 
			rs = st.executeQuery("SELECT * from Department "); 
			
			while (rs.next()) {
				System.out.println(rs.getInt("Id") + " " + rs.getString("Name"));
			}
			
			
		}catch (SQLException e ) {
			throw new DB_EXP(e.getMessage()); 
		}
		
		
	}

}

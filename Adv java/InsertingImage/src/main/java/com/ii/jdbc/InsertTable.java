package com.ii.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTable {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		InputStream fin = null;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "learner1", "learning1");
			fin = new FileInputStream("D:\\Docs\\java codes\\Adv java\\InsertingImage\\src\\main\\java\\com\\ii\\jdbc\\minions.png");
			pstmt = con.prepareStatement("insert into ImageTable values(1, ?)");
			pstmt.setBlob(1, fin);
			int n = pstmt.executeUpdate();
			
			if(n>0)
			{
				System.out.println("inserted");
				
			}
		}
		catch(ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
				if(fin != null) {
					fin.close();
				}
			}
			catch(SQLException | IOException e) { }
		}
	}

}

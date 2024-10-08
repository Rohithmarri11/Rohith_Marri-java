package TestModules;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TruncateInputData {
	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "learner1", "learning1");
			pstmt = con.prepareStatement("truncate table InputData");
			int n = pstmt.executeUpdate();
			
			if(n>=0)
			{
				System.out.println("InputData Truncated");
				
			}
			else {
				System.out.println("Not truncated");
			}
		}
		catch(ClassNotFoundException | SQLException e) {
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
			}
			catch(SQLException e) { }
		}
	}

}

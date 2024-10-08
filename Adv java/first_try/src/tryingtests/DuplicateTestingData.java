package TestModules;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestingData {

	public static void main(String[] args) {
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            File file = new File("D:\\Docs\\java codes\\Adv java\\TestCases\\src\\TestModules\\InputData.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n"); // Append newline character
            }
            br.close();
            String str = sb.toString();

            // Create a database connection
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "learner1", "learning1");

            // Create a prepared statement with a parameter
            pstmt = con.prepareStatement("select * from InputData", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            rs = pstmt.executeQuery();
            rs.last();
            int rowCount = rs.getRow();
            rs.beforeFirst();
            String [][] InputString = new String[rowCount][];
            int ISindex=0;
            String [] SubInputString = new String[rowCount];
            int SISindex=0;
            String value = "";
            int Testcs;
            String intgr = "";
            char c=0;
            //System.out.println(rs.next());
            while(c != '\n'){
            	rs.next();
            	c = rs.getString("Data").charAt(0);
            	if(c == '\n') continue;
            	intgr += c;
            	
            }
            Testcs = Integer.parseInt(intgr);
            //System.out.print(intgr + intgr + rowCount);
            while(rs.next()) {
            	c = rs.getString("Data").charAt(0);
            	
            	if(c == ' ') { SubInputString[SISindex] = value; SISindex++; value=""; }
            	else if(c == '\n') {
            		SubInputString[SISindex] = value; SISindex++; value="";
            		InputString[ISindex] = SubInputString; ISindex++; SISindex=0; SubInputString = new String[rowCount];}
            	else { value += c; }
            	
            }
            System.out.print(InputString.length);
            
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                // Log the exception or handle it appropriately
            }
        }

	}

}

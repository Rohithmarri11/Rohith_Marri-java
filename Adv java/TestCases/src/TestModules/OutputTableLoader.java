package TestModules;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OutputTableLoader {
	public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            File file = new File("D:\\Docs\\java codes\\Adv java\\TestCases\\src\\TestModules\\OutputData.txt");
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
            pstmt = con.prepareStatement("insert into OutputData values (?)");

            // Batch insert the values, including space and new line characters
            for (int i = 0; i < str.length(); i++) {
                String value = String.valueOf(str.charAt(i));
                pstmt.setString(1, value);
                pstmt.addBatch();
            }
            int[] n = pstmt.executeBatch();

            if (n.length > 0) {
                System.out.println("Inserted");
            }
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
            } catch (SQLException e) {
                // Log the exception or handle it appropriately
            }
        }
    }
}

package TestModules;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import TestFiles.PrimeorNot;

public class TestingData {

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ArrayList<String[]> InputString = new ArrayList<>();
        ArrayList<String> SubInputString = new ArrayList<>();
        ArrayList<String[]> OutputString = new ArrayList<>();
        ArrayList<String> SubOutputString = new ArrayList<>();
        try {
            

            // Create a database connection
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "learner1", "learning1");

            // Create a prepared statement with a parameter
            pstmt1 = con.prepareStatement("select * from InputData", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            rs1 = pstmt1.executeQuery();
            
            String value = "";
            int Testcs;
            String intgr = "";
            char c = 0;

            while (c != '\n') {
                rs1.next();
                c = rs1.getString("Data").charAt(0);
                if (c == '\n') continue;
                intgr += c;
            }
            Testcs = Integer.parseInt(intgr);

            while (rs1.next()) {
                c = rs1.getString("Data").charAt(0);

                if (c == ' ') {
                    SubInputString.add(value);
                    value = "";
                } else if (c == '\n') {
                	SubInputString.add(value);
                    String[] subInputArray = SubInputString.stream().toArray(String[]::new);
                    InputString.add(subInputArray);
                    SubInputString.clear();
                    value = "";
                } else {
                    value += c;
                }
            }
            
            //////////////////////////////////////////////////////
            
            pstmt2 = con.prepareStatement("select * from OutputData", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            rs2 = pstmt2.executeQuery();
            
            value = "";
            c = 0;

            while (rs2.next()) {
                c = rs2.getString("Data").charAt(0);

                if (c == ' ') {
                    SubOutputString.add(value);
                    value = "";
                } else if (c == '\n') {
                	SubOutputString.add(value);
                    String[] subOutputArray = SubOutputString.stream().toArray(String[]::new);
                    OutputString.add(subOutputArray);
                    SubOutputString.clear();
                    value = "";
                } else {
                    value += c;
                }
            }
            
            
            
            PrimeorNot pon = new PrimeorNot();
            for(int i =0; i<Testcs; i++) {
            	String[]Result = pon.CheckPrime(InputString.get(i));
            	if(Arrays.equals(Result, OutputString.get(i)) )
            	System.out.println("Passed");
            	else System.out.println("Failed");
            }
            

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt1 != null) {
                    pstmt1.close();
                }
                if (pstmt2 != null) {
                    pstmt2.close();
                }
                if (con != null) {
                    con.close();
                }
                if (rs1 != null) {
                    rs1.close();
                }
                if (rs2 != null) {
                    rs2.close();
                }
            } catch (SQLException e) {
                // Log the exception or handle it appropriately
            }
        }

    }

}
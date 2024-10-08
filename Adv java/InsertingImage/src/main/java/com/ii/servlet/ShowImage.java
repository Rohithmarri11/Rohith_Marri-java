package com.ii.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowImage extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Blob blob = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "learner1", "learning1");
            pstmt = con.prepareStatement("select * from ImageTable");
            rs = pstmt.executeQuery();
            if(rs.next()) {
                blob = rs.getBlob("image");
            }
            response.setContentType("image/jpeg");
            OutputStream out = response.getOutputStream();
            if (blob!= null) {
                out.write(blob.getBytes(1, (int) blob.length()));
            }
        } catch(ClassNotFoundException | SQLException  e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!= null) {
                    rs.close();
                }
                if(pstmt!= null) {
                    pstmt.close();
                }
                if(con!= null) {
                    con.close();
                }
            } catch(SQLException e) { }
        }
    }
}
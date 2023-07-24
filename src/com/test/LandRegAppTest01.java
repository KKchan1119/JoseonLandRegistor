package com.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class LandRegAppTest01 {
    public static void main(String[] args){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test";
            String userName = "Chan";
            String passWd= "dc3890!Q@";
            conn = DriverManager.getConnection(url, userName, passWd);
            stmt = conn.createStatement();
            String sql = "SELECT `id`, `name`, `age`, `asset`, `address`";
            rs = stmt.executeQuery(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            System.out.println("error : " +e);
        }finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
                if(stmt != null && !stmt.isClosed()){
                    stmt.close();
                }
                if(rs != null && !rs.isClosed()){
                    rs.close();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}

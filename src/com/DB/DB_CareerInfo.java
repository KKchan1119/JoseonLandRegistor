package com.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_CareerInfo {
    Connection con = null;
    ResultSet rs =null;
    PreparedStatement psmt = null;
    public void SelectCareer(){
        try{
            con = DBConnection.getConnection();
            String sql = "SELECT * FROM career";
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();

            while(rs.next()){
                int index = 1;
                int id = rs.getInt(index++);
                int pid = rs.getInt(index++);
                int jid = rs.getInt(index++);
                int year = rs.getInt(index++);
                int salary = rs.getInt(index++);
                String location = rs.getString(index);
                System.out.println(id+"| 사람ID: " +pid +" | 직업ID: "+ jid+" | 봉급: "+ salary+" | 년차: "+ year+" | 노동지역: "+ location );
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(con != null){
                try {
                    con.close();
                }catch (SQLException e){

                }
            }

            if(psmt != null){
                try {
                    psmt.close();
                }catch (SQLException e){

                }
            }
        }
    }

    public void InsertCareer(int id, int pid, int jid, int salary, int year, String location){
        try{
            con = DBConnection.getConnection();

            String sql = "INSERT INTO job(`id`, `pid`, `jid`, `salary`, `year`, `location`)" +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            psmt = con.prepareStatement(sql);
            psmt.setInt(1,id);
            psmt.setInt(2, pid);
            psmt.setInt(3, jid);
            psmt.setInt(4, salary);
            psmt.setInt(5, year);
            psmt.setString(6, location);
            psmt.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(psmt != null){
                try {
                    psmt.close();
                }catch (SQLException e){
                }
            }
            if(con != null){
                try {
                    con.close();
                }catch (SQLException e2){

                }
            }
        }
    }

    public void DeleteCareer(int id){
        try {
            con = DBConnection.getConnection();

            String sql = "DELETE FROM career WHERE id = ? ";

            psmt = con.prepareStatement(sql);
            psmt.setInt(1, id);
            psmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(con != null){
                try {
                    con.close();
                }catch (SQLException e){

                }
            }

            if(psmt != null){
                try {
                    psmt.close();
                }catch (SQLException e){

                }
            }
        }
    }

}

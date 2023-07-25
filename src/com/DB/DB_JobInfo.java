package com.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_JobInfo {
    Connection con = null;
    ResultSet rs =null;
    PreparedStatement psmt = null;
    public void SelectJob(){
        try{
            con = DBConnection.getConnection();
            String sql = "SELECT * FROM job";
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();

            while(rs.next()){
                int index = 1;
                int id = rs.getInt(index++);
                int rank = rs.getInt(index++);
                String job = rs.getString(index++);
                String info = rs.getString(index);
                System.out.println(id+"| 서열: " +rank +" | 직업: "+ job+" | 직업정보: "+ info );
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

    public void InsertJob(int id, int rank, String job, String info){
        try{
            con = DBConnection.getConnection();

            String sql = "INSERT INTO job(`id`, `rank`, `job`, `info`)" +
                    "VALUES (?, ?, ?, ?)";
            psmt = con.prepareStatement(sql);
            psmt.setInt(1,id);
            psmt.setInt(2, rank);
            psmt.setString(3, job);
            psmt.setString(4, info);
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

    public void DeleteJob(int id){
        try {
            con = DBConnection.getConnection();

            String sql = "DELETE FROM job WHERE id = ? ";

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

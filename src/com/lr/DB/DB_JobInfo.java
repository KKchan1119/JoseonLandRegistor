package com.lr.DB;

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
                String jobName = rs.getString(index++);
                String jobInfo = rs.getString(index);
                System.out.println(id+"| 서열: " +rank +" | 직업: "+ jobName+" | 직업정보: "+ jobInfo );
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

    public void InsertJob(int id, int rank, String jobName, String jobInfo){
        try{
            con = DBConnection.getConnection();

            String sql = "INSERT INTO job(`id`, `rank`, `jobName`, `jobInfo`)" +
                    "VALUES (?, ?, ?, ?)";
            psmt = con.prepareStatement(sql);
            psmt.setInt(1,id);
            psmt.setInt(2, rank);
            psmt.setString(3, jobName);
            psmt.setString(4, jobInfo);
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

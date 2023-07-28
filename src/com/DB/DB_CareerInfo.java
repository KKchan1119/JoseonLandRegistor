package com.DB;

import com.entity.Career;

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
            String sql = "SELECT people.name, job.job, career.salary, career.year, career.location\n" +
                    "FROM career\n" +
                    "INNER JOIN people, job\n" +
                    "WHERE career.pid = people.id and career.jid =job.id";
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();

            while(rs.next()){
                int index = 1;
                String name = rs.getString(index++);
                String job = rs.getString(index++);
                int year = rs.getInt(index++);
                int salary = rs.getInt(index++);
                String location = rs.getString(index);
                System.out.println("| 이름: " +name +" | 직업: "+ job +" | 봉급: "+ salary+" | 년차: "+ year+" | 노동지역: "+ location );
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

    public void UpdateCareer(Career Cr){
        try{
            String sql ="UPDATE career SET " +
                    "`salary` =?" +
                    "`year`  = ?" +
                    "`location =?`";
            psmt = con.prepareStatement(sql);
            psmt.setInt(1,Cr.getSalary());
            psmt.setInt(2,Cr.getYear());
            psmt.setString(3, Cr.getLocation());
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

    public Career getCareer(int id){
        con = DBConnection.getConnection();
        Career Cr = null;
        try {
            String sql = "SELECT * FROM career WHERE id = ?";
            psmt = con.prepareStatement(sql);
            psmt.setInt(1,id);
            rs = psmt.executeQuery();
            rs.next();

            Cr = new Career(rs.getInt("id"), rs.getInt("pid"),
                    rs.getInt("jid"), rs.getInt("salary"),
                    rs.getInt("year"), rs.getString("location"));
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

        return Cr;
    }

}

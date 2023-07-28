package com.lr.DB;

import com.lr.entity.People;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB_PeopleInfo {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement psmt = null;
    public void SelectPeople(){
        try{
            con = DBConnection.getConnection();
            stmt = con.createStatement();
            String sql = "SELECT * FROM people";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                int index = 1;
                int id = rs.getInt(index++);
                String name = rs.getString(index++);
                int age = rs.getInt(index++);
                int asset = rs.getInt(index++);
                String address = rs.getString(index);
                System.out.println(id+"| 함자: " +name +" | 나이: "+ age+" | 재산: "+ asset +" | 주소: "+address);
            }

        } catch (SQLException e) {
            System.out.println("error : " +e);
        }finally {
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
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

    public void DeletePeople(int id){
        try {
            con = DBConnection.getConnection();

            String sql = "DELETE FROM people WHERE id = ? ";

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

    public void InsertPeople(String nameIn, int ageIn, int assetIn, String addressIn){
        try{
            con = DBConnection.getConnection();

            String sql = "INSERT INTO people(name, `age`, `asset`, `address`)" +
                    " VALUES (?, ?, ?, ?)";
            psmt = con.prepareStatement(sql);
            psmt.setString(1,nameIn);
            psmt.setInt(2, ageIn);
            psmt.setInt(3, assetIn);
            psmt.setString(4, addressIn);
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


    public void UpdatePeople(People lr){
        con = DBConnection.getConnection();
        try{
            String sql = "UPDATE people SET " +
                    "name = ?," +
                    "age = ?, " +
                    "asset = ?," +
                    "address = ? WHERE id = ?";
            psmt = con.prepareStatement(sql);
            psmt.setString(1,lr.getName());
            psmt.setInt(2,lr.getAge());
            psmt.setInt(3,lr.getAsset());
            psmt.setString(4,lr.getAddress());
            psmt.setInt(5,lr.getId());
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


    public People getPeople(int id) {
        con = DBConnection.getConnection();
        People Pp = null;
        try {
            String sql = "SELECT * FROM people WHERE id = ?";
            psmt = con.prepareStatement(sql);
            psmt.setInt(1,id);
            rs = psmt.executeQuery();
            rs.next();
            Pp = new People(rs.getInt("id"), rs.getString("name"),rs.getInt("age"),
                    rs.getInt("asset"), rs.getString("address"));
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

        return Pp;
    }
}

package com.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_Product {
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement psmt = null;
    public void InsertProduct(){
        try{
            con = DBConnection.getConnection();


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


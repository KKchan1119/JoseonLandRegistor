package com.test;
import com.DB.DBConnection;
import com.entity.LendReg;

import java.sql.*;
import java.util.ArrayList;

public class LandRegAppTest {
    public static void main(String[] args){
        Connection conn = new DBConnection().getConnection();
        ArrayList<LendReg>list = new ArrayList<LendReg>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int index = 1;
        try{
            con = DBConnection.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("select id, `name`, age, asset, address");

            pstmt = con.prepareStatement(sql.toString());

            rs = pstmt.executeQuery();

            while(rs.next()){
                index = 1;
                int id = rs.getInt(index++);
                String name = rs.getString(index++);
                int age = rs.getInt(index++);
                int asset = rs.getInt(index++);
                String address = rs.getString(index++);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(rs != null)rs.close();
                if(pstmt != null)pstmt.close();
                if(con != null)con.close();
            }catch (SQLException e2){
                e2.printStackTrace();
            }
        }
        for(LendReg model:list){
            System.out.println("이름: "+model.getName()
                    +"나이: "+model.getAge()
                    +"재산: "+model.getAsset()
                    +"주소: "+model.getAddress());
        }
    }
}

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

        try{
            con = DBConnection.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("select * from people");

            pstmt = con.prepareStatement(sql.toString());

            rs = pstmt.executeQuery();

            while(rs.next()){

                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                int asset = rs.getInt(4);
                String address = rs.getString(5);
                list.add(new LendReg(id, name, age, asset, address));

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

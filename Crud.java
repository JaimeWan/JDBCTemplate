package JDBCTemplate;
import JDBCTemplate.DAO.InsertDate;

import java.sql.*;
import java.util.Properties;
import java.lang.reflect.*;

public class Crud {
    static Connection con;
    String a;
    PreparedStatement sql;
    String stb;

    public Crud() {
        TemplateDemo c = new TemplateDemo();
        con = c.open();
    }
    public void selectByID(int a, int b) {
        try {
//            stb = "select * from student_copy where ID=?";
            GetProperties q=new GetProperties();
            Properties prop=q.GetProp();
            stb=prop.getProperty("selectByID");
//           new InitStatement().select(sql,stb);
            sql = con.prepareStatement(stb);
            sql.setInt(a, b);
            ResultTest resultTest = new ResultTest();
            resultTest.getResult(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void selectByName(String a) {
//        stb = "select * from student where name like ";
        GetProperties q=new GetProperties();
        Properties prop=q.GetProp();
        stb=prop.getProperty("selectByName");
        stb = stb + a;
        try {
            sql = con.prepareStatement(stb);
            ResultTest resultTest = new ResultTest();
            resultTest.getResult(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void  DeleteByName(String c) {
        try {
//            stb = "delete from student_copy where name='"+c+"'";
            GetProperties q=new GetProperties();
            Properties prop=q.GetProp();
            stb=prop.getProperty("DeleteByName");
            stb=stb+c;
            sql = con.prepareStatement(stb);
            sql.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void Insert() {
        try {
            InsertDate insertDate=new InsertDate();
            String current_time=insertDate.getCurrent_time();
            GetProperties q=new GetProperties();
            Properties prop=q.GetProp();
            stb=prop.getProperty("insert");
            stb=stb+current_time+")";
            sql = con.prepareStatement(stb);
            sql.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void Update(String a,int b) {
        try {
            InsertDate insertDate=new InsertDate();
            String current_time=insertDate.getCurrent_time();
            stb = "UPDATE student_copy SET name='"+a+"',update_at="+current_time +" WHERE ID="+b;
       /*     GetProperties q=new GetProperties();
            Properties prop=q.GetProp();
            stb=prop.getProperty("Update");*/
            sql = con.prepareStatement(stb);
            sql.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}





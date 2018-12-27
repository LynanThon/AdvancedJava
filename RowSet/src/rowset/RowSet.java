package rowset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

public class RowSet
{
    public static void main(String[] args) 
    {
        try 
        {
            //1. Load Driver
//        Class.forName("com.mysql.jdbc.Driver");
//        System.out.println("Driver Loaded successfully");

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/mydb","root","root");
            Statement stt = con.createStatement();
            
            stt.execute("insert into batch4 values (202,'Diana')");
            System.out.println("Success to insert data");
            
            ResultSet rs = stt.executeQuery("select id from batch4 where id>=100");
            while(rs.next())
            {
                //System.out.println("Id : "+ rs.getInt("id"));
                Integer ii = rs.getInt("id");
                //System.out.println("Id is :" + ii);
                if(ii == 202)
                {
                    System.out.println("=======");
                }
                else 
                {
                    System.out.println("Id is : "+ ii);
                }
            }
            
            ResultSet rs1 = stt.executeQuery("select name from batch4 where id=100");
            while(rs1.next())
            {
                System.out.println("Name : "+ rs1.getString(1));
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println("Failed!!" + ex.getMessage());
        }        
    }
}

class MyListener implements RowSetListener
{
    @Override 
    public void rowSetChanged(RowSetEvent rse)
    {
    }

    @Override
    public void rowChanged(RowSetEvent rse)
    {

    }

    @Override 
    public void cursorMoved(RowSetEvent rse)
    {
        System.out.println("Cursor Moved...");
    }
}
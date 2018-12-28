package rowset1;

import java.sql.SQLException;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSet1 
{
    public static void main(String[] args) 
    {
        try
        {
            JdbcRowSet jrc = RowSetProvider.newFactory().createJdbcRowSet();
            jrc.setUrl("jdbc:derby://localhost:1527/mydb");
            jrc.setUsername("root");
            jrc.setPassword("root");
            jrc.setCommand("select * from batch4");
            //jrc.setString(23, "Anna" ,123);
            //jrc.addRowSetListener(new MyListener());
            jrc.execute();
            
            System.out.println("Success...");
            while(jrc.next())
            {
                System.out.println("Id : "+jrc.getInt(1));
                System.out.println("Name : " + jrc.getString(2));
            }
        }
        
        catch(SQLException ex)
        {
            System.out.println("Failed!! " + ex.getMessage());
        }
        
//        catch (ClassNotFoundException e)
//        {
//            System.out.println("class not found" + e.getMessage());
//        }
    }
    
}

class MyListener implements RowSetListener
{
    @Override
    public void rowSetChanged(RowSetEvent rse)
    {}
    
    @Override
    public void rowChanged(RowSetEvent rse)
    {}
    
    @Override 
    public void cursorMoved(RowSetEvent rse)
    {
        System.out.println("Coursor Moved");
    }
}
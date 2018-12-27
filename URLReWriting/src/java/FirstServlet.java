import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        String name = request.getParameter("user");
        PrintWriter out = response.getWriter();
        
        //print as hyperlink
        //out.println("<a href='SecondServlet?user="+name+"'>Second</a>");
        
        //print as html form
//        out.println("<form action='SecondServlet'>"
//        + "<input type='hidden' name='user' value='"+name+"'>"
//        + "<input type='submit' value='Second'> </form>");
//        
        out.println("<form action='SecondServlet'>");
        out.println("<input type='hidden' name='user' value='"+name+"'>");
        out.println("<input type='submit' value='Click'>");
        out.println("</form>");
    }

}

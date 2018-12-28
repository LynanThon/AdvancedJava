import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String user = request.getParameter("user");
        request.setAttribute("user", user);
        
        
////        HttpSession s = request.getSession();
////        s.setAttribute("user", user);
        

//cookies
        Cookie ck = new Cookie("user", user);   //("name" , "value")
        response.addCookie(ck);
        PrintWriter pw = response.getWriter();
        pw.println("<a href='SecondServlet'>Second</a>");

////        RequestDispatcher rd = request.getRequestDispatcher("/SecondServlet");
////        rd.forward(request, response);
        
//        resp.setContentType("text/html");
//        PrintWriter pw = resp.getWriter();
//        pw.print("<a href='/SecondServlet'>Second</a>");
    }    
}



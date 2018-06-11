package calcData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

public class CalcServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String brutto = request.getParameter("wynagrod");
        double br;
        try{
            br = Double.parseDouble(brutto);
        }
        catch (Exception e){
            br = Double.valueOf(0);
        }
        double ne = br - (br*0.23);
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Result</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>Result</h1>");
            out.println("<p>Brutto: " + br + "</p>");
            out.println("<p>Netto: " + ne + "</p>");
            out.println("<a href=home.jsp>Back</a>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}

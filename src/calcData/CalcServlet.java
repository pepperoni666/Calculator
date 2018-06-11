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
        String gdzie = request.getParameter("gdzie");
        double kosztUzyskania = 139.06;
        if(gdzie.equals("on"))
            kosztUzyskania = 111.25;
        double br;
        try{
            br = Double.parseDouble(brutto);
        }
        catch (Exception e){
            br = Double.valueOf(0);
        }
        double ue = br * 0.0976;
        double ur = br * 0.015;
        double uc = br * 0.0245;
        double uz = (br - (ue + ur + uc)) * 0.09;
        double tmp;

        if((br - (ue + ur + uc + uz)*12) < 85528)
            tmp = ((br - (ue + ur + uc)) - kosztUzyskania)*0.18 - 46.33;
        else
            tmp = 15395.04 + ((br - (ue + ur + uc + uz)*12) - 85528)*0.32 - 46.33;

        double zp = Math.round(tmp - (br - (ue + ur + uc))*0.0775);

        double ne = br - zp - tmp - uz;
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Result</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>Result</h1>");
            out.println("<p>Brutto: " + br + "</p>");
            out.println("<p>ubezpieczenie emerytalne: " + ue + "</p>");
            out.println("<p>ubezpieczenie rentowe: " + ur + "</p>");
            out.println("<p>ubezpieczenie chorobowe: " + uc + "</p>");
            out.println("<p>ubezpieczenie zdrowotne: " + uz + "</p>");
            out.println("<p>zaliczka na PIT: " + zp + "</p>");
            out.println("<p>Netto: " + ne + "</p>");
            out.println("<a href=home.jsp>Zmien kryteria obliczen</a>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}

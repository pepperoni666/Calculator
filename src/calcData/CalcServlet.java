package calcData;

import sun.nio.cs.HistoricallyNamedCharset;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalcServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        double br = 0, ue = 0, ur = 0, uc = 0, uz = 0, zp = 0, ne = 0;

        String val = request.getParameter("wynagrod");
        String gdzie = request.getParameter("gdzie");
        String[] tto = request.getParameterValues("tto");
        double kosztUzyskania = 139.06;
        if(gdzie.equals("on"))
            kosztUzyskania = 111.25;

        if(tto[0].equals("brutto")) {
            try {
                br = Double.parseDouble(val);
            } catch (Exception e) {
                br = Double.valueOf(0);
            }
            ue = br * 0.0976;
            ur = br * 0.015;
            uc = br * 0.0245;
            uz = (br - (ue + ur + uc)) * 0.09;
            double tmp;

            if ((br - (ue + ur + uc + uz) * 12) < 85528)
                tmp = ((br - (ue + ur + uc)) - kosztUzyskania) * 0.18 - 46.33;
            else
                tmp = 15395.04 + ((br - (ue + ur + uc + uz) * 12) - 85528) * 0.32 - 46.33;

            zp = Math.round(tmp - (br - (ue + ur + uc)) * 0.0775);

            ne = br - zp - tmp - uz;
        }
        else{
            try {
                ne = Double.parseDouble(val);
            } catch (Exception e) {
                ne = Double.valueOf(0);
            }
        }
        HistoryService service= new HistoryService();
        UsersEntity user = (UsersEntity) request.getSession().getAttribute("user");
        HistoryEntity his = new HistoryEntity(user.getEmail(), br, ue, ur, uc, uz, zp, ne);
        service.addToHis(his);
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Result</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>Result</h1>");
            out.println("<br/><b>Brutto: " + br + "</b>");
            out.println("<p>ubezpieczenie emerytalne: " + ue + "</p>");
            out.println("<p>ubezpieczenie rentowe: " + ur + "</p>");
            out.println("<p>ubezpieczenie chorobowe: " + uc + "</p>");
            out.println("<p>ubezpieczenie zdrowotne: " + uz + "</p>");
            out.println("<p>zaliczka na PIT: " + zp + "</p>");
            out.println("<b>Netto: " + ne + "</b>");
            out.println("<p><a href=home.jsp>Zmien kryteria obliczen</a></p>");
            out.println("</center>");
            out.println("<p><a href=history.jsp>View calculations history</a></p>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}

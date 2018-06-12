package calcData;

import sun.nio.cs.HistoricallyNamedCharset;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalcServlet extends HttpServlet {

    private HistoryEntity calcBrutto(String val, String email, double kosztUzyskania){
        double br = 0, ue = 0, ur = 0, uc = 0, uz = 0, zp = 0, ne = 0;

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

        return new HistoryEntity(email, br, ue, ur, uc, uz, zp, ne);
    }

    private HistoryEntity calcNetto(String val, String email, double kosztUzyskania){
        double br = 0, ue = 0, ur = 0, uc = 0, uz = 0, zp = 0, ne = 0;

        try {
            ne = Double.parseDouble(val);
        } catch (Exception e) {
            ne = Double.valueOf(0);
        }

        return new HistoryEntity(email, br, ue, ur, uc, uz, zp, ne);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String val = request.getParameter("wynagrod");
        String gdzie = request.getParameter("gdzie");
        String[] tto = request.getParameterValues("tto");
        double kosztUzyskania = 139.06;
        if(gdzie.equals("on"))
            kosztUzyskania = 111.25;

        UsersEntity user = (UsersEntity) request.getSession().getAttribute("user");
        HistoryEntity his = null;
        if(tto[0].equals("brutto")) {
            his = calcBrutto(val, user.getEmail(), kosztUzyskania);
        }
        else{
            his = calcNetto(val, user.getEmail(), kosztUzyskania);
        }
        HistoryService service= new HistoryService();
        service.addToHis(his);
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Result</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>Result</h1>");
            out.println("<br/><b>Brutto: " + his.getBrutto() + "</b>");
            out.println("<p>ubezpieczenie emerytalne: " + his.getUbez_emerytalne() + "</p>");
            out.println("<p>ubezpieczenie rentowe: " + his.getUbez_rentowe() + "</p>");
            out.println("<p>ubezpieczenie chorobowe: " + his.getUbez_chorobowe() + "</p>");
            out.println("<p>ubezpieczenie zdrowotne: " + his.getUbez_zdrowotne() + "</p>");
            out.println("<p>zaliczka na PIT: " + his.getZaliczka_pit() + "</p>");
            out.println("<b>Netto: " + his.getNetto() + "</b>");
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

package calcData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String conf_password = request.getParameter("conf_password");
        if(password.equals(conf_password) && !password.isEmpty()) {

            UsersEntity user = new UsersEntity(email, password);

            try {
                UsersDao registerService = new UsersDao();
                boolean result = registerService.register(user);
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Registration Successful</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<center>");
                if (result) {
                    out.println("<h1>Thanks for Registering with us :</h1>");
                    out.println("To login with new UserId and Password<a href=login.jsp>Click here</a>");
                } else {
                    out.println("<h1>Registration Failed</h1>");
                    out.println("To try again<a href=register.jsp>Click here</a>");
                }
                out.println("</center>");
                out.println("</body>");
                out.println("</html>");
            } finally {
                out.close();
            }
        }
        else
            response.sendRedirect("register.jsp");
    }
}

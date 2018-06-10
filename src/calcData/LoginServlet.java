package calcData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        LoginService loginService = new LoginService();
        boolean result = loginService.authenticateUser(email, password);
        UsersEntity user = loginService.getUserByEmail(email);
        if(result == true){
            request.getSession().setAttribute("user", user);
            response.sendRedirect("home.jsp");
        }
        else{
            response.sendRedirect("error.jsp");
        }
    }
}

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("u");
        String password = request.getParameter("p");
        if (password.equals(user.substring(0,1))) {
            getServletContext().log("All is OK 222222222222222222222");

            request.getSession().setAttribute("username", user);
            response.sendRedirect("index.jsp");
            getServletContext().log("All is OK 3333333333333333333333");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

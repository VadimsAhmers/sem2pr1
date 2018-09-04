import app.model.MessageService;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = {"/add.do", "/view.do", "/viewPrivate.do"})
public class AddServlet extends javax.servlet.http.HttpServlet {




    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        MessageService svc = (MessageService) getServletContext().getAttribute("msgSvc");
        String user = request.getSession().getAttribute("username").toString();
        String recepient = request.getParameter("user");
        String msg = request.getParameter("msg");
        request.setCharacterEncoding("utf8");

        String path = request.getServletPath();

        if (path.equals("/viewPrivate.do")){
            request.setAttribute("messages", svc.getMessagesTo(user));
        }
        else {
            request.setAttribute("messages", svc.getAllMessages());
            if (path.equals("/add.do")) {
                if ((msg != null) && (msg != "")) {
                    if (recepient == null) {
                        svc.addMessage(user, msg);
                    } else svc.addMessage(user, recepient, msg);
                }
            }
        }

        try (PrintWriter out = response.getWriter();){
            //request.getRequestDispatcher("oldstylejsp.jsp").forward(request, response);
            //response.sendRedirect("oldstylejsp.jsp");
            //getServletContext().log("All is OK");
            request.getRequestDispatcher("messages.jsp").forward(request, response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}

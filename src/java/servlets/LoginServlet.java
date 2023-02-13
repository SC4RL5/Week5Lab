package servlets;

import models.AccountService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Swift
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        String action = request.getParameter("action");
        if (action != null && action.equals("logout")) {
            session.invalidate();
            session = request.getSession();
            request.setAttribute("message", "You have successfully logged out.");
        }

        if (username != null) {
            response.sendRedirect("/Week5Lab_MyLogin/home");
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || username.equals("") || password == null || password.equals("")) {
            request.setAttribute("message", "Invalid username or password");
            request.setAttribute("username", username);
            request.setAttribute("password", password);

            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }

        AccountService ac = new AccountService();

        if (ac.login(username, password) != null) {
            session.setAttribute("username", username);
            response.sendRedirect("/Week5Lab_MyLogin/home");
        } else {
            request.setAttribute("message", "Invalid username or password");
            request.setAttribute("username", username);
            request.setAttribute("password", password);

            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}

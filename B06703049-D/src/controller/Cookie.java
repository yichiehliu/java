package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserService;

@WebServlet(name = "Cookie", urlPatterns = "/Cookie")
public class Cookie extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        javax.servlet.http.Cookie[] cookies = request.getCookies();
        UserService userService = (UserService) getServletContext().getAttribute("userService");

        if (cookies != null) {
            for (javax.servlet.http.Cookie cookie : cookies) {
                // System.out.println(1234466);

                String username = cookie.getName();
                String password = cookie.getValue();

                // System.out.println("acc:"+useraccount);
                // System.out.println("pwd:"+password);

                if (userService.checkLogin(username, password)) {
                    request.getSession().setAttribute("login", username);
                    request.getRequestDispatcher("/index.jsp").forward(request, response);

                } else {
                    request.setAttribute("error", "Username or password error");
                }
            }
        }
        response.sendRedirect("/index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
package controller;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserModule;
import model.UserService;

@WebServlet(urlPatterns = { "/delete.do" }, initParams = { @WebInitParam(name = "SUCCESS_VIEW", value = "message.do") })
public class Delete extends HttpServlet {
    private String SUCCESS_VIEW;

    @Override
    public void init() throws ServletException {
        SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("login");
        String message = request.getParameter("message");
        UserService userService = (UserService) getServletContext().getAttribute("userService");
        UserModule UserModule = new UserModule();
        UserModule.setUsername(username);
        UserModule.setDate(new Date(Long.parseLong(message)));
        userService.deleteUserModule(UserModule);
        response.sendRedirect(SUCCESS_VIEW);
    }
}

package controller;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserService;

@WebServlet(urlPatterns = { "/register.do" }, initParams = {
        @WebInitParam(name = "SUCCESS_VIEW", value = "success.jsp"),
        @WebInitParam(name = "ERROR_VIEW", value = "register.jsp") })
public class Register extends HttpServlet {
    private String SUCCESS_VIEW;
    private String ERROR_VIEW;

    @Override
    public void init() throws ServletException {
        SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
        ERROR_VIEW = getServletConfig().getInitParameter("ERROR_VIEW");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmedPasswd = request.getParameter("confirmedPasswd");

        UserService userService = (UserService) getServletContext().getAttribute("userService");
        // System.out.println(userService.USERS);
        List<String> errors = new ArrayList<String>();
        if (isInvalidEmail(email)) {
            errors.add("Email is blank or Email input is not the right format");
        }
        if (userService.isInvalidUsername(username)) {
            errors.add("Username is blank or username has been used");
        }
        if (isInvalidPassword(password, confirmedPasswd)) {
            errors.add("Please check the Password again");
        }
        String resultPage = ERROR_VIEW;
        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
        } else {
            resultPage = SUCCESS_VIEW;
            userService.createUserData(email, username, password);
        }

        request.getRequestDispatcher(resultPage).forward(request, response);
    }

    private boolean isInvalidEmail(String email) {
        return email == null || !email.matches("^[_a-z0-9-]+([.]" + "[_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$");
    }

    private boolean isInvalidPassword(String password, String confirmedPasswd) {
        return password == null || password.length() < 6 || password.length() > 16 || !password.equals(confirmedPasswd);
    }
}

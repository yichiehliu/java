package controller;

import java.io.*;
import java.text.DateFormat;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserModule;
import model.UserService;

@WebServlet(urlPatterns = { "/message.do" }, initParams = { @WebInitParam(name = "MEMBER_VIEW", value = "member.jsp") })
public class Message extends HttpServlet {
    private String MEMBER_VIEW;

    @Override
    public void init() throws ServletException {
        MEMBER_VIEW = getServletConfig().getInitParameter("MEMBER_VIEW");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String username = (String) request.getSession().getAttribute("login");

        UserService userService = (UserService) getServletContext().getAttribute("userService");

        UserModule UserModule = new UserModule();
        UserModule.setUsername(username);

        String userMessage = request.getParameter("userMessage");
        String userTitle = request.getParameter("userTitle");
        if (userMessage != null && userMessage.length() != 0) {
            if (userMessage.length() < 200) {
                UserModule.setDate(new Date());
                UserModule.setTxt(userMessage);
                UserModule.setTitle(userTitle);
                userService.addUserModule(UserModule);
            } else {
                request.setAttribute("userMessage", userMessage);
            }
        }
//        System.out.println(UserModule);
        List<UserModule> UserModules = userService.getUserModules(UserModule);
//        System.out.println(UserModules);
        request.setAttribute("UserModules", UserModules);
        request.getRequestDispatcher(MEMBER_VIEW).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        processRequest(request, response);
    }
}

package web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.UserService;

@WebListener
public class BlogListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String USERS = sce.getServletContext().getInitParameter("USERS");
        context.setAttribute("userService", new UserService(USERS));
    }

}

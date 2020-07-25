package mvc;


import java.io.*;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name="Controller",
		urlPatterns = "/Controller")
public class Controller extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
                       throws ServletException, IOException {
		
		
        Cookie[] cookies = request.getCookies();
        AccountCheck accountCheck = new AccountCheck();
		HashMap<String, User> usermap = (HashMap<String, User>) getServletContext().getAttribute("user_hmap");

        
        if(cookies != null) {
            for(Cookie cookie : cookies) {
//            	System.out.println(1234466);

                String useraccount = cookie.getName();
                String password = cookie.getValue();
//        		System.out.println("acc:"+useraccount);
//        		System.out.println("pwd:"+password);
        		Boolean checkedaccount = accountCheck.checkAccountNameExistence(useraccount, usermap);
        		request.setAttribute("checkedaccount", checkedaccount);
                if(checkedaccount) {
                	Boolean checkedpwd = accountCheck.checkPassword(useraccount, password, usermap);
            		request.setAttribute("checkedpwd", checkedpwd);
            		if(checkedpwd) {
                        request.setAttribute(useraccount, password);
                        request.getRequestDispatcher("/Logout.jsp").forward(request, response);
            		}
                }
            }
        }

        response.sendRedirect("Login.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                             throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                            throws ServletException, IOException {
        processRequest(request, response);

    }
} 
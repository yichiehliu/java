package mvc;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.AccountCheck;
import mvc.User;

/**
 * Servlet implementation class AddNewUser
 */
@WebServlet("/AddNewUser")
public class AddNewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewUser() {
        super();
        // TODO Auto-generated constructor stub
    }
    
//	private User user_obj = new User();
	private AccountCheck ac = new AccountCheck();
//	private Map<String, userobj> usermap = new HashMap<>();
	private HashMap<String, User> usermap = new HashMap();


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String page = request.getParameter("page");
		String name = request.getParameter("username");
		String address = request.getParameter("address");
		String phonenumber = request.getParameter("phonenumber");
		String education = request.getParameter("education");
		String useraccount = request.getParameter("useraccount");
		String password = request.getParameter("password");
		
		ServletContext context = this.getServletContext(); 
		context.setAttribute("user_hmap", usermap); 
		HttpSession session = request.getSession();
		if ("下一頁".equals(page)) {
			
            session.setAttribute("name", name);
            session.setAttribute("address", address);
            session.setAttribute("phonenumber", phonenumber);
            session.setAttribute("education", education);

            request.getRequestDispatcher("/addnewuser_p2.jsp").forward(request, response);
			
		} else if ("送出".equals(page)) {
            session.setAttribute("useraccount", useraccount);
            session.setAttribute("password", password);

            
            Boolean checkedaccount = ac.checkAccountNameExistence(useraccount, usermap);
            if (checkedaccount) {
                request.setAttribute("error_add", "所輸入的帳號名稱已經有人使用，請輸入另一個帳號名稱!");
                request.getRequestDispatcher("/View").forward(request, response);
            }
            
            User userobj = ac.addNewUser((String) session.getAttribute("name"), (String) session.getAttribute("address"), (String) session.getAttribute("phonenumber"), (String) session.getAttribute("education"),(String) session.getAttribute("useraccount"), (String) session.getAttribute("password"), usermap);
            request.getRequestDispatcher("/addnewuser_p3.jsp").forward(request, response);
            
		} else if("tologout".equals(page)) {
			session.invalidate();
		}
		
		
	}

}

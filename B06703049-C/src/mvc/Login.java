package mvc;

import java.io.*;
import java.util.*;

import javax.servlet.http.Cookie;
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
 * Servlet implementation class Login
 */

@WebServlet("/Login")
public class Login extends HttpServlet {
//	private String SUCCESS_VIEW;
//	private String ERROR_VIEW;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	private User userobj = new User();
//	private AccountCheck ac = new AccountCheck();
//	private Map<String, userobj> usermap = new HashMap<>();
//	private HashMap usermap = new HashMap();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.getRequestDispatcher("Controller").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		
		List<String> errors = new ArrayList<String>();
		
		String useraccount = request.getParameter("useraccount");
		String password = request.getParameter("password");
		
		
		AccountCheck accountCheck = new AccountCheck();
		HashMap<String, User> usermap = (HashMap<String, User>) getServletContext().getAttribute("user_hmap");
		Boolean checkedaccount = accountCheck.checkAccountNameExistence(useraccount, usermap);
		request.setAttribute("checkedaccount", checkedaccount);
		
	
		//null是找不到這個field 要empty是isEmpty		
		if(useraccount.isEmpty() || password.isEmpty()) {
			request.setAttribute("error", "請輸入帳號和密碼");
			request.getRequestDispatcher("/View").forward(request, response);
		} else {
			if (!checkedaccount) {
				request.setAttribute("error", "輸入帳號錯誤，查無此帳號");
				request.getRequestDispatcher("/View").forward(request, response);
			} 
			
			if(checkedaccount) {
				Boolean checkedpwd = accountCheck.checkPassword(useraccount, password, usermap);
				
				if(checkedpwd) {
					User get_user = usermap.get(useraccount);
					String login = request.getParameter("auto");
					HttpSession session = request.getSession();

					session.setAttribute("checkedpwd", checkedpwd);
					session.setAttribute("useraccount", useraccount);
					session.setAttribute("education", get_user.getEducation());
					session.setAttribute("address",  get_user.getAddress());
					session.setAttribute("phonenumber", get_user.getPhoneNumber());
					session.setAttribute("name", get_user.getName());
//					request.getSession().setAttribute("useraccount", useraccount);
//					request.getSession().setAttribute("userpwd", password);


		            if ("is".equals(login)) {
		            	
		                Cookie cookie = new Cookie(useraccount, password);
		                Cookie cookie_auto = new Cookie("auto", "1");
//		                System.out.print(cookie.getValue());
//		                System.out.print("OK有自動登入2222");
		                cookie.setMaxAge(7 * 24 * 60 * 60);
		                response.addCookie(cookie);
		                cookie_auto.setMaxAge(7 * 24 * 60 * 60);
		                response.addCookie(cookie_auto);
		             	request.getRequestDispatcher("/Controller").forward(request, response);
		            } else {
		            	request.getRequestDispatcher("/Logout.jsp").forward(request, response);
		            }
				} else if (!checkedpwd) {
					request.setAttribute("error", "輸入密碼錯誤");
					request.getRequestDispatcher("/View").forward(request, response);
				}

			}
		}
		

		
//		HttpSession session = request.getSession();
//		        
//		String page = request.getParameter("page");
//		if("tologout".equals(page)) {
//			 request.getSession().invalidate();
//		}
		

	}
}

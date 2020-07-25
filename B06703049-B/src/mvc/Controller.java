package mvc;

import java.util.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	// private static final long serialVersionUID = 1L;
	private Model model = new Model();
	// new一個Model 物件
	// 新的物件Model叫model
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password = request.getParameter("password");
		Boolean checkedpwd = model.checkPassword(password);
		request.setAttribute("checkedpwd", checkedpwd);
		request.getRequestDispatcher("View").forward(request, response);
	}

}

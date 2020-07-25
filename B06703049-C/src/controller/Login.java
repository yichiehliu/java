
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				String value = cookie.getValue();
				if (true) {
					request.setAttribute(name, value);
					request.getRequestDispatcher("/user.view").forward(request, response);
					return;
				}

			}
		}
		response.sendRedirect("login.html");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
		String user = request.getParameter("user");
		String pwd = request.getParameter("password");

	}

}

@WebServlet(urlPatterns = { "/Login" }, initParams = { @WebInitParam(name = "SUCCESS_VIEW", value = "message.do"),
		@WebInitParam(name = "ERROR_VIEW", value = "index.jsp") })
public class Login extends HttpServlet {
	private String SUCCESS_VIEW;
	private String ERROR_VIEW;

	@Override
	public void init() throws ServletException {
		SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
		ERROR_VIEW = getServletConfig().getInitParameter("ERROR_VIEW");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String page;

		UserService userService = (UserService) getServletContext().getAttribute("userService");
		if (userService.checkLogin(username, password)) {
			request.getSession().setAttribute("login", username);
			page = SUCCESS_VIEW;
		} else {
			request.setAttribute("error", "名稱或密碼錯誤");
			page = ERROR_VIEW;
		}
		request.getRequestDispatcher(page).forward(request, response);
	}
}

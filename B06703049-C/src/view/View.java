

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class View
 */
@WebServlet("/View")
public class View extends HttpServlet {
	// private static final long serialVersionUID = 1L;

	private String htmlTemplate = "<html>" + "<head>" + "<meta http-equiv='content-type'"
			+ "content='text/html;charset=UTF-8'>"+ "<title>Login</title>" + "<body>" + "<h1>%s</h1>" + "</body>" + "</head>" + "</html>";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
//		String password = request.getParameter("password");
		Boolean matched = (Boolean) request.getAttribute("checkedpwd");
		if (matched == true) {
			String html = String.format(htmlTemplate, "登入密碼正確!");
			out.println(html);
		} else {
			String html = String.format(htmlTemplate, "登入密碼錯誤!");
			out.println(html);
		}
		// out.println(matched);

		out.close();
	}

}

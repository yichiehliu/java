package mvc;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Model
 */
@WebServlet("/Model")
public class Model extends HttpServlet {
	// private static final long serialVersionUID = 1;

	// private Map<String, Boolean> pwdMatch = new HashMap<String, Boolean>()

	public Boolean checkPassword(String password) {
		// Boolean checked = pwdMatch.get(password)
		if (password.equals("123456")) {
			return true;
		} else {
			return false;
		}

	}

}

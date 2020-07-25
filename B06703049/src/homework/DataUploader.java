package homework;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataUploader
 */
@WebServlet("/DataUploader")
public class DataUploader extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public DataUploader() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8"); //通知tomcat使用UTF-8碼錶編碼
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String address = request.getParameter("address");
		String phonenumber = request.getParameter("phonenumber");
		String birthday = request.getParameter("birthday");
		String education = request.getParameter("education");
		String[] sports = request.getParameterValues("sports");
		
		String autobio = request.getParameter("autobiography");
//		String hobby = 

//		doGet(request, response);
		
		Date d1 = new Date();
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY HH:mm a");
		String formattedDate = df.format(d1);
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("姓名:"+username+"</p>");
		out.println("住址:"+address+"</p>");
		out.println("電話號碼:"+phonenumber+"</p>");
		out.println("生日(yyyy/mm/dd):"+birthday+"</p>");
		out.println("學歷:"+education+"</p>");
		out.println("運動:");
		for(int i=0;i<sports.length;i++) {
			if(sports[i]!=null) {
				out.println(sports[i]+" ");
			}
		}

		out.println("</p>"+"靜態休閒:");
		for(String type : request.getParameterValues("hobby")) {
			out.println(type+" ");
		}
		out.println("</p>"+"自傳:"+autobio+"</p>");
		out.println("登入個人資料時間:"+formattedDate+"</p>");
		out.println("使用者來源端IP:"+request.getHeader("host")+"</p>");
		out.println("使用者端的瀏覽器類型:"+request.getHeader("user-agent")+"</p>");

		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}

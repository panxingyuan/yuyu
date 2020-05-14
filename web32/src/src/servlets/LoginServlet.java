package src.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.main.UserManager;
import src.main.Validdation;

@WebServlet(name = "Login", urlPatterns = { "/Login.action" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -1L;

	private boolean isValid(String u, String p) {
		return true;
		/*
		 * if(! u.equals("hzs")) return false;
		 * 
		 * if(! p.equals("123456")) return false;
		 * 
		 * return true;
		 */
		// return Validdation.isValid(u, p);
		//return UserManager.getInstance().checkUserPassword(u, p);
		// return false;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("--------------------");
		String name = request.getParameter("username");
		String pass = request.getParameter("passwd");
		System.out.println("username:" + name + "\tpasswd:" + pass);

		if (isValid(name, pass)) {
			System.out.println("OK");
			request.getSession().setAttribute("user", name);
			request.getRequestDispatcher("/succ.jsp").forward(request, response);
		} else
		{
			System.out.println("��ƥ��");
			request.getSession().setAttribute("info", "�û������벻ƥ��");
			request.getRequestDispatcher("/fail.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("=====================");
		/*
		 * String name = request.getParameter("username"); String pass =
		 * request.getParameter("passwd"); System.out.println("====," + name +
		 * "\tpasswd:" + pass);
		 * 
		 * if(this.isValid(name, pass)){ System.out.println("ok");
		 * request.getSession().setAttribute("user", name);
		 * request.getRequestDispatcher("/succ.jsp").forward(request,response); } else {
		 * System.out.println("failed"); }
		 */
		/*
		 * if(UserManager.getInstance().checkUserPassword(name, pass)) {
		 * System.out.println("=====================");
		 * request.getSession().setAttribute("user", name);
		 * request.getRequestDispatcher("/succ.jsp").forward(request,response); }else {
		 * request.getSession().setAttribute("info", "�û������벻ƥ��");
		 * request.getRequestDispatcher("/fail.jsp").forward(request,response); }
		 */
	}

}
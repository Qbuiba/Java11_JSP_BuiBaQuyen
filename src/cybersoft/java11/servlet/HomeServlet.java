package cybersoft.java11.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java11.utils.PathConst;
import cybersoft.java11.utils.UrlConstant;

@WebServlet(name = "homeServlet", urlPatterns = PathConst.HOME)
public class HomeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * METHODS
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO show Home Page
		String message = "this is greeting from server";
		req.setAttribute("message", message);

		req.getRequestDispatcher(UrlConstant.HOME_PAGE).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String userMessage = req.getParameter("userMessage");
		req.setAttribute("userMessage", userMessage);
		req.getRequestDispatcher(UrlConstant.HOME_PAGE).forward(req, resp);
	}

}

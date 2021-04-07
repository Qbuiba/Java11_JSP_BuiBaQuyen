package cybersoft.java11.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java11.utils.PathConst;
import cybersoft.java11.utils.UrlConstant;

@WebServlet(name = "userServlet", urlPatterns = { PathConst.USER_DASHBOARD, PathConst.USER_ADD, PathConst.USER_EDIT,
		PathConst.USER_DELETE })

public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String servletPath = req.getServletPath();

		switch (servletPath) {
		case PathConst.USER_DASHBOARD: {
			req.getRequestDispatcher(UrlConstant.USER_DASHBOARD).forward(req, resp);
			break;
		}
		case PathConst.USER_ADD: {
			req.getRequestDispatcher(UrlConstant.USER_ADD).forward(req, resp);
			break;
		}
		case PathConst.USER_EDIT: {
			req.getRequestDispatcher(UrlConstant.USER_EDIT).forward(req, resp);
			break;
		}
		case PathConst.USER_DELETE: {
			req.getRequestDispatcher(UrlConstant.USER_DELETE).forward(req, resp);
			break;
		}
		default:
			break;
		}

	}

}

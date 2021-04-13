package cybersoft.java11.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java11.controller.UserController;
import cybersoft.java11.model.User;
import cybersoft.java11.utils.PathConst;
import cybersoft.java11.utils.UrlConstant;

@WebServlet(name = "userServlet", urlPatterns = { PathConst.USER_DASHBOARD, PathConst.USER_ADD, PathConst.USER_EDIT,
		PathConst.USER_DELETE })

public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserController userController;

	/**
	 * INIT METHODS
	 */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		userController = new UserController();
	}

	/**
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String servletPath = req.getServletPath();

		switch (servletPath) {
		case PathConst.USER_DASHBOARD:
			List<User> userList = userController.findAll();

			req.setAttribute("userList", userList);
			req.getRequestDispatcher(UrlConstant.USER_DASHBOARD).forward(req, resp);
			break;

		case PathConst.USER_ADD:
			RequestDispatcher rd = getServletContext().getRequestDispatcher(UrlConstant.USER_ADD);
			rd.forward(req, resp);
			
//			req.getRequestDispatcher(UrlConstant.USER_ADD).forward(req, resp);;
//			req.getRequestDispatcher(UrlConstant.USER_ADD).forward(req, resp);
			break;

		case PathConst.USER_EDIT:
			req.getRequestDispatcher(UrlConstant.USER_EDIT).forward(req, resp);
			break;

		case PathConst.USER_DELETE:
			String username = req.getParameter("username");
			userController.remove(username);
			
			resp.sendRedirect(req.getContextPath()+PathConst.USER_DASHBOARD);
			break;
			

		default:
			break;

		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User( req.getParameter("fullname"), Integer.parseInt(req.getParameter("dayofbirth")), req.getParameter("username"),req.getParameter("password"), Integer.parseInt( req.getParameter("role")));
		userController.add(user);
		
		resp.sendRedirect(req.getContextPath()+PathConst.USER_DASHBOARD);
	}
	

}

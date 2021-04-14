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
		List<User> userList = userController.findAll();

		switch (servletPath) {
		case PathConst.USER_DASHBOARD:

			req.setAttribute("userList", userList);
			req.getRequestDispatcher(UrlConstant.USER_DASHBOARD).forward(req, resp);
			break;

		case PathConst.USER_ADD:
			RequestDispatcher rd = getServletContext().getRequestDispatcher(UrlConstant.USER_ADD);
			rd.forward(req, resp);

			break;

		case PathConst.USER_EDIT:
			String editUser = req.getParameter("username");
			User reqUser = null;
			for (User user : userList) {
				if (user.getUsername().equals(editUser)) {
					reqUser = user;
					break;
				}
			}
			req.setAttribute("reqUser", reqUser);
			req.getRequestDispatcher(UrlConstant.USER_EDIT).forward(req, resp);
			break;

		case PathConst.USER_DELETE:
			String username = req.getParameter("username");
			userController.remove(username);

			resp.sendRedirect(req.getContextPath() + PathConst.USER_DASHBOARD);
			break;

		default:
			break;

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();

		switch (servletPath) {
		case PathConst.USER_ADD:
			User user = new User(req.getParameter("fulname"), Integer.parseInt(req.getParameter("birthday")),
					req.getParameter("username"), req.getParameter("password"),
					Integer.parseInt(req.getParameter("role")));
			int result = userController.add(user);

			switch (result) {
			case 1:
				resp.sendRedirect(req.getContextPath() + PathConst.USER_DASHBOARD);
				break;
			case 2:
				String errMsg = "username or password can not be null";
				req.setAttribute("errMsg", errMsg);
				req.setAttribute("user", user);
				doGet(req, resp);
				break;
			case 3:
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + result);
			}

		case PathConst.USER_EDIT:
			break;

		default:
			break;

		}
	}

}

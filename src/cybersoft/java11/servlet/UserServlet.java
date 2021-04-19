package cybersoft.java11.servlet;

import java.io.IOException;
import java.util.List;

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
	private List<User> userList;

	/**
	 * INIT METHODS
	 */
	@Override
	public void init() throws ServletException {
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
			try {
				userList = userController.findAll();
			} catch (Exception e) {
				System.out.println("error " + e.getMessage());
			}
			req.setAttribute("userList", userList);
			req.getRequestDispatcher(UrlConstant.USER_DASHBOARD).forward(req, resp);
			break;

		case PathConst.USER_ADD:
			req.getRequestDispatcher(UrlConstant.USER_ADD).forward(req, resp);
			break;

		case PathConst.USER_EDIT:
			String editUserName = req.getParameter("username");
			User curUser = findUser(editUserName);
			req.setAttribute("user", curUser);
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

	private User findUser(String editUserName) {
		User user = null;
		for (User e : userList) {
			if (e.getUsername().equals(editUserName)) {
				user = e;
				break;
			}
		}
		return user;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		User addUser = null;
		User updateUser = null;

		switch (servletPath) {
		case PathConst.USER_ADD:

			try {
				addUser = getUserFromRequest(req);
			} catch (NumberFormatException e) {
				System.out.println("error in parsing number at " + e.getMessage());
			}

			userController.add(addUser);
			resp.sendRedirect(req.getContextPath() + PathConst.USER_DASHBOARD);
			break;

		case PathConst.USER_EDIT:

			try {
				updateUser = getUserFromRequest(req);
			} catch (NumberFormatException e) {
				System.out.println("error in parsing number at " + e.getMessage());
			}

			if (userController.update(updateUser.getUsername(), updateUser)) {
				System.out.println("Update successfully");
			} else {
				System.out.println("Update failed");
			}
			resp.sendRedirect(req.getContextPath() + PathConst.USER_DASHBOARD);
			break;
		default:
		}
	}

	private User getUserFromRequest(HttpServletRequest req) throws NumberFormatException {
		User user = new User(req.getParameter("username"), req.getParameter("password"), req.getParameter("fullname"),
				Integer.parseInt(req.getParameter("role")), Integer.parseInt(req.getParameter("yearofbirth")));
		return user;
	}

}

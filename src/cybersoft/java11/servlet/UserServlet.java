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
			userList = userController.findAll();
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

		switch (servletPath) {
		case PathConst.USER_ADD:
			User addUser = new User(req.getParameter("fullname"), Integer.parseInt(req.getParameter("yearofbirth")),
					req.getParameter("username"), req.getParameter("password"),
					Integer.parseInt(req.getParameter("role")));
			userController.add(addUser);

			resp.sendRedirect(req.getContextPath() + PathConst.USER_DASHBOARD);
			break;

		case PathConst.USER_EDIT:
			User updateUser = new User(req.getParameter("fullname"), Integer.parseInt(req.getParameter("yearofbirth")),
					req.getParameter("username"), req.getParameter("password"),
					Integer.parseInt(req.getParameter("role")));
			String updateUserName = req.getParameter("username");

			if (userController.update(updateUserName, updateUser)) {
				System.out.println("Update successfully");
			} else {
				System.out.println("Update failed");
			}
			resp.sendRedirect(req.getContextPath() + PathConst.USER_DASHBOARD);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + servletPath);
		}

	}

}

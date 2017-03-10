package com.exam.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.dao.userQuery;
import com.exam.entity.userEntity;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		userEntity user = new userEntity();
		userQuery query = new userQuery();

		try {
			user = query.getUser(name, pass);
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}

		if (user == null) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			request.setAttribute("name", user.getName());
			request.setAttribute("pass", user.getPass());
			request.getRequestDispatcher("/logined.jsp").forward(request, response);
		}

	}

}

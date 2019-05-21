package com.sample.app.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Comment")
public class Comment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Comment() {
		super();
	}

	private List<String> comments = new ArrayList<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().write(comments.get(comments.size()-1));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String comment = request.getParameter("comment");
		comments.add(comment);

		response.getWriter().write("Your comment is stored successfully");
	}

}

package com.sample.app.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(description = "Search For a Product", urlPatterns = { "/productSearch" })
public class ProductSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private static List<String> products = (List<String>) Arrays.asList("phone", "camera");
	
    public ProductSearch() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product = request.getParameter("product");
		
		if(products.contains(product)) {
			response.getWriter().write(product + " found in the catalog");
			return;
		}
		
		// Don't set this header in production
		response.setHeader("X-XSS-Protection", "0");
		response.getWriter().write(product + " not found in the catalog");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

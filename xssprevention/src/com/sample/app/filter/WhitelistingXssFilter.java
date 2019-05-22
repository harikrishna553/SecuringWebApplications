package com.sample.app.filter;

import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/*")
public class WhitelistingXssFilter implements Filter {
	private static final Pattern onlyAlphaNumeric = Pattern.compile("[A-Za-z0-9_\\.\\+@\\$]+");

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
			if (hasXss((HttpServletRequest) request)) {
				System.out.println("XSS Detected!");
				((HttpServletResponse) response).sendError(400, "XSS Detected");
			}
			chain.doFilter(request, response);
		}
	}

	private boolean hasXss(HttpServletRequest request) {

		for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
			for (String value : entry.getValue()) {

				if (!onlyAlphaNumeric.matcher(value).matches()) {
					return true;
				}

			}
		}
		return false;
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}
}

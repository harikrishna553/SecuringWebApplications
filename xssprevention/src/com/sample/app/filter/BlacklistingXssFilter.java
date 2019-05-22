package com.sample.app.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * This filter may not prevent from double encoding attack, and some other
 * encoding attacks, you should use data canonicalization to solve these
 * problems.
 *
 *
 */
@WebFilter("/*")
public class BlacklistingXssFilter implements Filter {

	private static List<String> BLACKLISTED_STRINGS = Arrays.asList("<script>", "</script>");

	public BlacklistingXssFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (isXSSAtackPossible(request)) {
			((HttpServletResponse) response).sendError(400, "XSS Detected");
			return;
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

	private boolean isXSSAtackPossible(ServletRequest request) {
		for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
			for (String value : entry.getValue()) {
				for (String blackListed : BLACKLISTED_STRINGS) {
					if (value != null && value.contains(blackListed)) {
						return true;
					}
				}

			}
		}

		return false;
	}

}

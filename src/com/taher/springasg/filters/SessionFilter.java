package com.taher.springasg.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter({"/products", "/display","/logout"})
public class SessionFilter implements Filter {

	public SessionFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		System.out.println("filter called");
		String currUri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String redirectUrl = contextPath + "/login";
		System.out.println(currUri);
		boolean flag = authUserAgainstCookie(req);
	
		if (isLogoutUri(currUri, contextPath)) {
			if (!isSessionExpired(req)) {
			
				req.getSession(false).invalidate();
				System.out.println("session invalidated");
				res.sendRedirect(redirectUrl);
				return;
			}
		}
		
		if (!isLoginUrl(currUri, contextPath)) {
			System.out.println("checking for session");
			if (!flag) {
				res.sendRedirect(redirectUrl);
				return;
			}
		}
	
System.out.println(req.getRequestURL());
System.out.println(req.getMethod());
		chain.doFilter(req, res);
	}

	private boolean authUserAgainstCookie(HttpServletRequest req) {
		boolean flag = false;
		Cookie[] cookies = req.getCookies();
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (!isSessionExpired(req)) {
					if (cookie.getValue().equals(req.getSession(false).getAttribute("sessID"))) {
						System.out.println("session valid");
						flag = true;
					}
				}
			}
		}
		return flag;
	}

	private boolean isSessionExpired(HttpServletRequest req) {
		return req.getSession(false) == null; // return true if not existing
	}

	private boolean isLoginUrl(String currUri, String contextPath) {
		return currUri.equals(contextPath + "/login");
	}

//	private boolean isSessionValid(HttpServletRequest req) {
//		return req.getSession(false).getAttribute("username") != null;
//	}

	private boolean isLogoutUri(String currUri, String contextPath) {
		return currUri.equals(contextPath + "/logout");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}


//if (isLoginUrl(currUri, contextPath)) {
//	if (flag) {
//		redirectUrl = contextPath + "/products";
//		res.sendRedirect(redirectUrl);
//	}
//}
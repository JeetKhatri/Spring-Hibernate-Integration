package com.jeetkhatri.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jeetkhatri.model.Users;

public class sessionCheckInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String url = request.getRequestURL().toString();
		String[] arr = url.split("/");
		String name = arr[arr.length - 1];
		// System.out.println("-->"+name);

		if (name.equalsIgnoreCase("index.html")
				|| name.equalsIgnoreCase("loginPage.html")
				|| name.equalsIgnoreCase("SpringHibernateIntegration")
				|| name.equalsIgnoreCase("addUserPage.html")) {

		} else {
			Users user = (Users) request.getSession().getAttribute("user");
			if (user == null) {
				System.out.println("session null");
				modelAndView.setViewName("loginPage");
			}
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
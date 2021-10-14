package com.douzone.mysite.mvc.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.web.mvc.Action;
import com.douzone.web.util.MvcUtil;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 로그아웃 처리 */
		HttpSession session = request.getSession();
		session.removeAttribute("authUser");
		session.invalidate();

		MvcUtil.redirect(request.getContextPath(), request, response);
	}

}

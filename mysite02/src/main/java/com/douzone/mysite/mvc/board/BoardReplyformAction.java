package com.douzone.mysite.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.web.mvc.Action;
import com.douzone.web.util.MvcUtil;

public class BoardReplyformAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long no = Long.parseLong(request.getParameter("no"));
		System.out.println("aaa");
		System.out.println(no);
		System.out.println("aaa");
		request.setAttribute("no", no);
		MvcUtil.forward("board/reply", request, response);
	}

}

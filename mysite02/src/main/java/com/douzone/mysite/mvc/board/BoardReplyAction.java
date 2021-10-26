package com.douzone.mysite.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mysite.dao.BoardDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.UserVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.MvcUtil;

public class BoardReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션인증
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		System.out.println("replyAction");	
		if(authUser == null) {
					
			MvcUtil.forward("user/loginform", request, response);
		}
		
		else {
			Long ano = authUser.getNo();
			
			Long no = Long.parseLong(request.getParameter("no"));
			String title = request.getParameter("title");
			String contents = request.getParameter("content");
			
			System.out.println("==");
			System.out.println(title);
			System.out.println(contents);
			System.out.println("==");
			
			BoardVo vo = new BoardDao().findByID(no);
			
			vo.setTitle(title);
			vo.setContents(contents);
			vo.setUserNo(ano);
			
			new BoardDao().insertreply(vo);
			
			MvcUtil.redirect(request.getContextPath() + "/board", request, response);
		}
		
	}

}

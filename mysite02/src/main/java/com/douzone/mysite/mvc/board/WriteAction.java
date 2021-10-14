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

public class WriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션인증
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			
			System.out.println("ghkrdls");	
			MvcUtil.redirect(request.getContextPath(), request, response);
		}	
		else {
			Long no = authUser.getNo();
			
			BoardVo vo = new BoardVo();
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			vo.setTitle(title);
			vo.setContents(content);
			vo.setUserNo(no);
			
			new BoardDao().insert(vo);
			
			MvcUtil.forward("board/list", request, response);
		}
	}

}

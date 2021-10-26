package com.douzone.mysite.mvc.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.dao.BoardDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.PageVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.MvcUtil;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageVo page = null ;
		if(request.getParameter("page") == null)
		{
			page = new PageVo( 1,10);			
			
		}else {
			
			page = new PageVo( Integer.parseInt(request.getParameter("page")),10);			
			
		}
		
		List<BoardVo> list = new BoardDao().findAll(page);
		
		System.out.println(list.get(0));
		request.setAttribute("list", list);
		
		MvcUtil.forward("board/list", request, response);

	}

}

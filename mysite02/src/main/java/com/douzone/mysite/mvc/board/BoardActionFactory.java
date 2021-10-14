package com.douzone.mysite.mvc.board;

import com.douzone.mysite.mvc.guestbook.DeleteAction;
import com.douzone.web.mvc.Action;
import com.douzone.web.mvc.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		
		Action action = null;
		
		if("writeform".equals(actionName)) {
			action = new WriteFormAction();
		} else if("write".equals(actionName)) {
			action = new WriteAction();
		}else {
			action = new BoardListAction();
		}
		
		return action;
	}

}

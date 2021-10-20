package com.douzone.mysite.mvc.board;

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
		} else if("delete".equals(actionName)) {
			action = new BoardDeleteAction();
		} else if("view".equals(actionName)) {
			action = new BoardViewAction();
		} else if("updateform".equals(actionName)) {
			action = new BoardUpdateFormAction();
		} else if("update".equals(actionName)) {
			action = new BoardUpdateAction();
		} else if("search".equals(actionName)) {
			action = new BoardSearchAction();
		} else {
			action = new BoardListAction();
		}
		
		return action;
	}

}

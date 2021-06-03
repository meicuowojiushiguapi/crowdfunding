package com.xc.crowdfunding.util;

import com.xc.crowdfunding.bean.Page;
import com.xc.crowdfunding.bean.User;

import java.util.List;

public class AjaxResult {

	private boolean success ;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	private String message ;
	private Page page;

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}

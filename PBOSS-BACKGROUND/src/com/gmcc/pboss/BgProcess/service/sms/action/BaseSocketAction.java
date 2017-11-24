package com.gmcc.pboss.BgProcess.service.sms.action;

import open.tool.socketserver.data.Request;
import open.tool.socketserver.data.Response;
import open.tool.socketwork.Action;

import com.sunrise.jop.infrastructure.db.DBAccessUser;

/**
 * 
 * @author Canigar
 *
 */
public abstract class BaseSocketAction implements Action{

	private Request request;
	private Response response;
	private DBAccessUser dbAccessUser;
	
	public abstract void execute();

	public Request getRequest() {
		// TODO Auto-generated method stub
		return request;
	}

	public Response getResponse() {
		// TODO Auto-generated method stub
		return response;
	}

	public void setRequest(Request request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	public void setResponse(Response response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	public DBAccessUser getDbAccessUser() {
		return dbAccessUser;
	}

	public void setDbAccessUser(DBAccessUser dbAccessUser) {
		this.dbAccessUser = dbAccessUser;
	}


}

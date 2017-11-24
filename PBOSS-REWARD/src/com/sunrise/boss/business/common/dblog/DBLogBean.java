package com.sunrise.boss.business.common.dblog;

import java.util.HashMap;

/**
 * <p>Title: DbLogConfig</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Sunrise </p>
 * @author yjr
 * @version 1.0
 */
public class DBLogBean {

	private String tablename; //ҵ�����

	private String logname;   //��־����

	private HashMap mapping;  //ҵ�������־���ֶ�ӳ���ϵ
	
	private String action;    //��Ҫ�Ǽ���־�Ĳ���

	public String getLogname() {
		return logname;
	}

	public void setLogname(String logname) {
		this.logname = logname;
	}

	public HashMap getMapping() {
		return mapping;
	}

	public void setMapping(HashMap mapping) {
		this.mapping = mapping;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}

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

	private String tablename; //业务表名

	private String logname;   //日志表名

	private HashMap mapping;  //业务表与日志表字段映射关系
	
	private String action;    //需要登记日志的操作

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

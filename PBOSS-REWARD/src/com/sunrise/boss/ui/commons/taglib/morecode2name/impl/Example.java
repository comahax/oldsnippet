/**
 * 
 */
package com.sunrise.boss.ui.commons.taglib.morecode2name.impl;

import java.util.Map;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.morecode2name.MoreCode2Name;

/**
 * @author mys
 * 举例说明实现morecode2name的接口方法
 */


public class Example implements MoreCode2Name {

	/**
	 * params 可以传listvo过来 ，获取分页信息；或者是自己定义的bean等等；
	 */
	public String translateMore(Object params, User user) throws Exception {
		// TODO  实现你自己的方法
		return null;
	}

	public Object getList(Object params, User user) throws Exception {
		// TODO  实现你自己的方法
		return null;
	}
	
	public String getAllName() throws Exception {		
		return "全部匹配";
	}
	public String getAllCode() throws Exception {	
		return "*,";
	}

	public Object getObject(Object params, User user) throws Exception {
		return null;
	}
	
}

package com.gmcc.pboss.menu.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.menu.model.SaDbWebfunctionitem;

public interface SaDbWebfunctionitemDao extends BaseDao {	
	/**
	 * 根据登录人员类型获取菜单项
	 * @param type 根据登录人员的isnet字段确定菜单查询的类型type
	 * 	isnet=0或1 取type=0和1的菜单；isnet=4取type=0和4的菜单
	 * @return KEY-funcid:String  VALUE-ArrayList<SaDbWebfunctionitem>
	 */
	public Map getMenuMap(short type);
	
	public List getAllMenu();
	
}

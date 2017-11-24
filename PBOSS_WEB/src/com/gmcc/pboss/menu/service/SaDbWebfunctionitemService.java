package com.gmcc.pboss.menu.service;

import java.util.List;
import java.util.Map;

import com.gmcc.pboss.menu.model.SaDbWebfunctionitem;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.common.service.CacheService;

public interface SaDbWebfunctionitemService extends BaseService, CacheService{
	/**
	 * 将所有菜单信息读入一个Map中
	 * @param loginMember 登录人员信息，尚不包括菜单信息
	 * @return KEY-funcid:String  VALUE-ArrayList<SaDbWebfunctionitem>
	 */
	public Map getMenuMap(LoginMember loginMember);
	
	public Map getMenuMap(String city, int type);
	
	public String getShowReward(String city);
	public String getShowLocalReward(String city);
}

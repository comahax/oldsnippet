package com.gmcc.pboss.member.extend.dao;

import java.util.List;

import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.member.extend.model.ChPwEmployeeextend;
import com.gmcc.pboss.member.extend.model.Provincecityadmin;

public interface ProvincecityadminDao extends BaseDao {
	
	//¹Ì¶¨ÃÜÂëµÇÂ½
	public Provincecityadmin getCityadminLogin(Long mobile);

}

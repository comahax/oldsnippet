package com.gmcc.pboss.biz.basic.dictItem.dao;

import java.util.Map;

import com.gmcc.pboss.common.dao.BaseDao;

public interface DictItemDao extends BaseDao {
	
	//查询IM_PR_COMCATEGORYRELA表，获取商品种类-资源类别组合
	//key-商品种类，value-资源列别
	public Map<String,String> getComcatoAndRestype();

}

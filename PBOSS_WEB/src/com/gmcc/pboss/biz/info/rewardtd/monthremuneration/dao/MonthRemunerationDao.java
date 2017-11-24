package com.gmcc.pboss.biz.info.rewardtd.monthremuneration.dao;

import java.util.List;

import com.gmcc.pboss.common.dao.BaseDao;

public interface MonthRemunerationDao extends BaseDao {
	public List getBusistat(String wayid,String rwmon);
	
	public List getOtherList(String wayid,String rwmon);
	
	public List getCountList(String wayid,String rwmon);
}

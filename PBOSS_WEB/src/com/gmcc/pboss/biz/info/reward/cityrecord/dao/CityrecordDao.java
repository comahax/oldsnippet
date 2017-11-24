package com.gmcc.pboss.biz.info.reward.cityrecord.dao;

import java.util.List;

import com.gmcc.pboss.biz.info.node.model.Way;
import com.gmcc.pboss.biz.info.reward.cityrecord.support.CityrecordQueryParameter;
import com.gmcc.pboss.common.dao.BaseDao;

public interface CityrecordDao extends BaseDao {
	
	public List getOpnlevel2();
	
	public Way getWayInfo(String wayid, String magcode);
	
	public List getBusistat(String opnid,String wayid,String month);
	
	//public List getBusistat(String wayid,String month);
	public List getBusistat(CityrecordQueryParameter param);

}

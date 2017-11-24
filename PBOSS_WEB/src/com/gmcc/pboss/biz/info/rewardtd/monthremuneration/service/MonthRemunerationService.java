package com.gmcc.pboss.biz.info.rewardtd.monthremuneration.service;

import java.util.List;

import com.gmcc.pboss.common.service.BaseService;

public interface MonthRemunerationService  extends BaseService{
	public List getBusistat(String wayid,String rwmon);
	
	public List getOtherList(String wayid,String rwmon);
	
	public List getCountList(String wayid,String rwmon);
	
}

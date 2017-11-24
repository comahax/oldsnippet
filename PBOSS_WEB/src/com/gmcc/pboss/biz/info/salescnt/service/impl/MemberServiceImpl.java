package com.gmcc.pboss.biz.info.salescnt.service.impl;

import java.util.ArrayList;
import java.util.Map;

import com.gmcc.pboss.biz.info.salescnt.dao.MemberDao;
import com.gmcc.pboss.biz.info.salescnt.service.MemberService;
import com.gmcc.pboss.biz.info.salescnt.support.SalescntQueryParameter;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.Page;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public class MemberServiceImpl extends QueryBaseServiceImpl implements MemberService {

	public MemberServiceImpl() {
		//设置业务相关属性
		serviceName = "店员查询";
		serviceCode = ServiceCode.SALES_TOTAL;
		isNeedLogin = true;
	}
	
	private MemberDao memDao;

	public MemberDao getMemDao() {
		return memDao;
	}
	
	public void setMemDao(MemberDao memDao) {
		this.memDao = memDao;
	}
	
	public QueryResult getAll(QueryParameter parameter) {
		
		Map resimCnt = memDao.getMember((SalescntQueryParameter) parameter);// 店员数据
		
		ArrayList list = new ArrayList();
		list.add(resimCnt);

		QueryResult result = new QueryResult(Page.EMPTY, list);

		return result;
	}
}

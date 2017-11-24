package com.gmcc.pboss.manager.service.impl;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.manager.service.ManagerMemberService;
import com.gmcc.pboss.manager.support.ManagerMemberQueryParameter;
import com.gmcc.pboss.manager.support.MagMemQueryParameterProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.member.dao.IChannelDao;
import com.gmcc.pboss.member.dao.IMemberDao;
import com.gmcc.pboss.common.bean.Channel;

public class ManagerMemberServiceImpl extends QueryBaseServiceImpl implements ManagerMemberService {
	
	/**
	 * 构造器：给ServiceCode与ServiceName赋值
	 */
	public ManagerMemberServiceImpl() {
		super();
		this.serviceCode = ServiceCode.MANAGER_MEMBER_QUERY;
		this.serviceName = "经理人员-店员查询";
		isNeedLogin = true;// 需要登录
		this.setProcessor(new MagMemQueryParameterProcessor());
	}
	
	/**渠道DAO*/
	private IChannelDao channelDao;	
	public IChannelDao getChannelDao() {
		return channelDao;
	}
	public void setChannelDao(IChannelDao channelDao) {
		this.channelDao = channelDao;
	}
	//店员详细信息查询时，获取店员所属渠道信息
	public Channel getEmployeeChannel(String emp_wayid,long emp_isnet){
		return this.channelDao.getChannelByWayId(emp_wayid, emp_isnet);
	}
}

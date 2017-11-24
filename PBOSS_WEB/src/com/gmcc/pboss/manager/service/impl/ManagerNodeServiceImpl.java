package com.gmcc.pboss.manager.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.manager.model.WayReversed;
import com.gmcc.pboss.biz.info.node.model.Way;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.manager.service.ManagerNodeService;
import com.gmcc.pboss.manager.support.ManagerNodeQueryParameter;
import com.gmcc.pboss.manager.support.ManagerNodeQueryParameterProcessor;
import com.gmcc.pboss.biz.info.node.dao.WayDao;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.manager.dao.NodeDao;

public class ManagerNodeServiceImpl extends BaseServiceImpl implements	ManagerNodeService {
	
	/**
	 * 构造器：给ServiceCode与ServiceName赋值
	 */
	public ManagerNodeServiceImpl(){
		super();
		this.serviceCode = ServiceCode.MANAGER_NODE_QUERY;
		this.serviceName = "经理人员-网点查询";
		this.isNeedLogin = true;
		//this.setProcessor(new ManagerNodeQueryParameterProcessor());
	}
	
	//渠道dao-HQL查询
	private WayDao wayDao;
	public WayDao getWayDao() {
		return wayDao;
	}
	public void setWayDao(WayDao wayDao) {
		this.wayDao = wayDao;
	}
	//渠道Dao-SQL查询
	private NodeDao nodeDao;
	public NodeDao getNodeDao() {
		return nodeDao;
	}
	public void setNodeDao(NodeDao nodeDao) {
		this.nodeDao = nodeDao;
	}
	
	public ServiceResult query(LoginMember member, QueryParameter parameter) {
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//使用通用业务员编码，对于子业务，可以继承ServiceRetCode定义不用的业务编码（在getAll方法中实现）

		ManagerNodeQueryParameter p = (ManagerNodeQueryParameter)parameter;
		this.setProcessor(new ManagerNodeQueryParameterProcessor());
		QueryResult queryResult=null;
		if(p.isPopup()){//弹出框，弹出当前经理下的所有网点供选择
			queryResult = wayDao.getAll(this.getProcessor(), parameter);
		}
		else if(!StringUtils.isNotEmpty(p.getWayid())){//查询经理人员下的所有网点--经理人员网点列表
			queryResult = nodeDao.getAllSQL(this.getProcessor(), parameter);
			List list = queryResult.getData();
			List wayList = new ArrayList<WayReversed>();
			for(int i=0;i<list.size();i++){
				Object[] obj=(Object[])list.get(i);
				WayReversed temp = new WayReversed(
						(String)obj[0],(String)obj[1],(String)obj[2],(String)obj[3],(String)obj[4],
						(String)obj[5],(String)obj[6],(String)obj[7],(String)obj[8],(String)obj[9]);
				wayList.add(temp);
			}
			queryResult.setData(wayList);
		}
		else{//查询某个网点的详情
			queryResult = wayDao.getAll(this.getProcessor(), parameter);
		}

		result.setRetResult(queryResult);

		result.setRetObject(null);//对于getAll,只返回QueryResult,没有必要加上RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		return result;
	}
}

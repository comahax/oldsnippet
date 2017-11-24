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
	 * ����������ServiceCode��ServiceName��ֵ
	 */
	public ManagerNodeServiceImpl(){
		super();
		this.serviceCode = ServiceCode.MANAGER_NODE_QUERY;
		this.serviceName = "������Ա-�����ѯ";
		this.isNeedLogin = true;
		//this.setProcessor(new ManagerNodeQueryParameterProcessor());
	}
	
	//����dao-HQL��ѯ
	private WayDao wayDao;
	public WayDao getWayDao() {
		return wayDao;
	}
	public void setWayDao(WayDao wayDao) {
		this.wayDao = wayDao;
	}
	//����Dao-SQL��ѯ
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
		result.setRetCode(ServiceRetCode.FAIL);//ʹ��ͨ��ҵ��Ա���룬������ҵ�񣬿��Լ̳�ServiceRetCode���岻�õ�ҵ����루��getAll������ʵ�֣�

		ManagerNodeQueryParameter p = (ManagerNodeQueryParameter)parameter;
		this.setProcessor(new ManagerNodeQueryParameterProcessor());
		QueryResult queryResult=null;
		if(p.isPopup()){//�����򣬵�����ǰ�����µ��������㹩ѡ��
			queryResult = wayDao.getAll(this.getProcessor(), parameter);
		}
		else if(!StringUtils.isNotEmpty(p.getWayid())){//��ѯ������Ա�µ���������--������Ա�����б�
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
		else{//��ѯĳ�����������
			queryResult = wayDao.getAll(this.getProcessor(), parameter);
		}

		result.setRetResult(queryResult);

		result.setRetObject(null);//����getAll,ֻ����QueryResult,û�б�Ҫ����RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		return result;
	}
}

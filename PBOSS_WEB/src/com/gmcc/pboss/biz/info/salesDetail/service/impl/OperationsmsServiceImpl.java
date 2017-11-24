package com.gmcc.pboss.biz.info.salesDetail.service.impl;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import java.util.HashMap;
import com.gmcc.pboss.biz.info.salesDetail.service.OperationsmsService;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.biz.info.salesDetail.dao.OperationsmsDao;
import com.gmcc.pboss.biz.info.salesDetail.model.ChPwOperationsms;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.biz.info.salesDetail.support.OperationsmsParamProcessor;

public class OperationsmsServiceImpl extends BaseServiceImpl implements
		OperationsmsService {

	/**
	 * 业务编码和名称设置
	 */
	public OperationsmsServiceImpl(){
		super();
		this.serviceCode = ServiceCode.OPERATION_SMS;
		this.serviceName = "业务编码查询";
		this.isNeedLogin = true;
	}
	/**
	 * 获取访问数据库的operationsmsDao
	 */
	private OperationsmsDao operationsmsDao;
	public void setOperationsmsDao(OperationsmsDao operationsmsDao){
		this.operationsmsDao = operationsmsDao;
	}
	public OperationsmsDao getOperationsmsDao(){
		return this.operationsmsDao;
	}
	
	/**
	 * 获取短信业务编码列表
	 * Map<opnid,opnname>
	 */
	public Map getOpnInfo(String cityid) {
		// TODO Auto-generated method stub
		short opntype = 2;
		String smsno = "10086111";
		List opnList = this.operationsmsDao.getOpnInfo(opntype, smsno, cityid);
		Iterator iter = opnList.iterator();
		
		Map map = new HashMap<String,String>();//opnid ,opnname
		while(iter.hasNext()){
			ChPwOperationsms item = (ChPwOperationsms)iter.next();
			map.put(item.getId().getOpnid(), item.getOpnname());
		}
		//Map map = this.operationsmsDao.getOpnInfo(opntype, smsno, cityid);
		return map;
	}
	
	/**
	 * 获取短信业务编码列表
	 * List<ChPwOperationsms>
	 */
	public List getOperationsms(String cityid){
		short opntype = 2;
		String smsno = "10086111";
		List opnList = this.operationsmsDao.getOpnInfo(opntype, smsno, cityid);
		return opnList;
	}
	
	/**
	 * 获取短信业务编码列表--这里使用JSON封装，用于界面表格的显示
	 */
	public ServiceResult query(LoginMember loginMember, QueryParameter parameter){
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//使用通用业务员编码，对于子业务，可以继承ServiceRetCode定义不用的业务编码（在getAll方法中实现）

		//查询条件处理器
		this.setProcessor(new OperationsmsParamProcessor());
		QueryResult queryResult = this.operationsmsDao.getAll(getProcessor(), parameter);
			
		result.setRetResult(queryResult);

		result.setRetObject(null);//对于getAll,只返回QueryResult,没有必要加上RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);	
		return result;
	}

}

package com.gmcc.pboss.biz.index.support;

import java.text.ParseException;

import org.hibernate.Query;

import com.gmcc.pboss.biz.communi.service.CommunicatePlateauRetCode;
import com.gmcc.pboss.biz.communi.support.CommunicatePlateauParameter;
import com.gmcc.pboss.common.exception.AssertConditionException;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.DateUtil;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
//import com.gmcc.pboss.biz.communi.support.processor.CommunicatePlateauParameterProcessor;

public class AdvinfoPendingParameterProcessor extends
	DefaultHqlQueryProcessor implements QueryParameterProcessor{
	
	private String systemParam;
	public AdvinfoPendingParameterProcessor(String systemParam){
		this.paramEnclose = false;
		this.systemParam = systemParam;
	}
	
	public String getHql(QueryParameter parameter) {
		CommunicatePlateauParameter param = (CommunicatePlateauParameter)parameter;
		String type = param.getType();
		StringBuffer hqlSb = new StringBuffer();
		boolean isIndexPage = param.isIndexPage();
		hqlSb.append("select  advinfo ");
		hqlSb.append("from ChPwAdvinfo advinfo left outer join fetch advinfo.rcvObjs as obj ");
		hqlSb.append("where advinfo.type = :type and advinfo.state = 3 ");
		
		//把从系统参数表中获取的参数添加到Query语句中
		hqlSb.append(" and advinfo.content like :content ");
		
		hqlSb.append("and (obj.rvcobjid is null or (not exists (select 1 from advinfo.rcvObjs objs where objs.objid = :employeeid)) or (obj.state =1 and obj.objid = :employeeid) ) and ");
		if(!"5".equals(type)){
			// 如果不是代办类型
			hqlSb.append("advinfo.enddate >= :curdate and ");
		}
		if(!isIndexPage) {
			// 【公告/业务/知识库信息查询】界面
			if(!"".equals(param.getStartDate())) {
				hqlSb.append("advinfo.releasetime >= :startdate and ");
			}
			if(!"".equals(param.getAccountDate())) {
				hqlSb.append("advinfo.releasetime <= :accountdate and ");
			}
		}
		hqlSb.append("( ");
		if(param.isNet()) {
			// 店主
			hqlSb.append("(advinfo.desttype = 2) or ");
		}
		hqlSb.append("(advinfo.desttype=3) or (advinfo.desttype=4 and obj.objid= :employeeid) ");
		hqlSb.append("or ( advinfo.desttype=5 and exists ");
		hqlSb.append("( select 1 from ChPwAdvgroupobj g where str(g.groupid) = obj.objid and g.oid = :employeeid ))");
		hqlSb.append(") ");
		hqlSb.append(" order by advinfo.releasetime desc");
		
		return hqlSb.toString();
	}
	
	public String getCntHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		CommunicatePlateauParameter param = (CommunicatePlateauParameter)parameter;
		String type = param.getType();
		boolean isIndexPage = param.isIndexPage();
		StringBuffer hqlSb = new StringBuffer();
		hqlSb.append("select count(distinct advinfo.advinfoid) ");
		hqlSb.append("from ChPwAdvinfo advinfo left outer join advinfo.rcvObjs  as obj  ");
		hqlSb.append("where advinfo.type = :type and advinfo.state = 3 ");
		
		//把从系统参数表中获取的参数添加到Query语句中
		hqlSb.append(" and advinfo.content like :content ");
		
		hqlSb.append("and (obj.rvcobjid is null or (not exists (select 1 from advinfo.rcvObjs objs where objs.objid = :employeeid)) or (obj.state =1 and obj.objid = :employeeid) ) and ");
		hqlSb.append("( ");
		if(param.isNet()) {
			// 店主
			hqlSb.append("(advinfo.desttype = 2) or ");
		}
		hqlSb.append("(advinfo.desttype=3) or (advinfo.desttype=4 and obj.objid= :employeeid) ");
		hqlSb.append("or ( advinfo.desttype=5 and exists ");
		hqlSb.append("( select 1 from ChPwAdvgroupobj g where str(g.groupid) = obj.objid and g.oid = :employeeid ))");	
		if(!"5".equals(type)){
			// 如果不是代办类型
			hqlSb.append("advinfo.enddate >= :curdate and ");
		}
		if(!isIndexPage) {
			// 【公告/业务/知识库信息查询】界面
			if(!"".equals(param.getStartDate())) {
				hqlSb.append("advinfo.releasetime >= :startdate and ");
			}
			if(!"".equals(param.getAccountDate())) {
				hqlSb.append("advinfo.releasetime <= :accountdate and ");
			}
		}
		hqlSb.append(") ");
		
		return hqlSb.toString();
	}



	public String[] getParamEncloseName() {
		String [] rtn = {"rvcobjid","objid","state"};
		return rtn;
	}

	public void process(Query query, QueryParameter parameter) {
		CommunicatePlateauParameter param = (CommunicatePlateauParameter)parameter;
		String typeStr = param.getType();
		long type = Long.parseLong(typeStr);
		String startdateStr = param.getStartDate();
		String accountdateStr = param.getAccountDate();
		java.util.Date startDate = null;
		java.util.Date accountDate = null;
		boolean isIndexPage = param.isIndexPage();
		try {
			if(!isIndexPage) {
				// 【公告/业务/知识库信息查询】界面 或者 【我的提问查询】界面
				if(startdateStr == null) {
					// 用户进入查询界面,系统默认查询当前月的信息（从1号到当前日）
					startDate = DateUtil.getCurrentMonthFirstDay(new java.util.Date());
				}else if(!"".equals(startdateStr)){
					startDate = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", startdateStr+" 00:00:00");
				}
				if(accountdateStr == null) {
					// 用户进入查询界面,系统默认查询当前月的信息（从1号到当前日）
					accountDate = new java.util.Date();
				}else if(!"".equals(accountdateStr)){
					accountDate = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", accountdateStr+" 23:59:59");
				}
				if(!"".equals(startdateStr)) {
					query.setTimestamp("startdate", startDate);
				}
				if(!"".equals(accountdateStr)) {
					query.setTimestamp("accountdate", accountDate);
				}
			}
			
			
		} catch (ParseException e) {
			throw new AssertConditionException(CommunicatePlateauRetCode.COMMUNICATE_DATE_FORMAT,"月份格式不正确！");
		}
		String employeeid = param.getEmployeeid();
		query.setString("employeeid", employeeid);
		
		query.setLong("type", type);
		if(!"5".equals(typeStr)) {
			query.setDate("curdate", new java.util.Date());
		}
		
		//把从系统参数表中获取的参数添加到Query语句中
		query.setString("content", "%"+this.systemParam+"%");
		
	}

}

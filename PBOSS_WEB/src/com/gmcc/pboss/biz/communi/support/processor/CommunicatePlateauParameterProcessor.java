package com.gmcc.pboss.biz.communi.support.processor;

import java.text.ParseException;

import org.hibernate.Query;

import com.gmcc.pboss.biz.communi.service.CommunicatePlateauRetCode;
import com.gmcc.pboss.biz.communi.support.CommunicatePlateauParameter;
import com.gmcc.pboss.common.exception.AssertConditionException;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.DateUtil;

public class CommunicatePlateauParameterProcessor extends
		DefaultHqlQueryProcessor implements QueryParameterProcessor {

	private String systemParam;//ϵͳ������ȷ���Ƿ����δ�������ΪNULL������
	public CommunicatePlateauParameterProcessor() {
		paramEnclose = false; //��ʹ�ò�����װ
		this.systemParam = null;
	}
	public CommunicatePlateauParameterProcessor(String sysparam) {
		paramEnclose = false; //��ʹ�ò�����װ
		this.systemParam = sysparam;
	}

	public String getHql(QueryParameter parameter) {
		CommunicatePlateauParameter param = (CommunicatePlateauParameter)parameter;
		String type = param.getType();
		StringBuffer hqlSb = new StringBuffer();
		boolean isIndexPage = param.isIndexPage();
		hqlSb.append("select  advinfo ");
		hqlSb.append("from ChPwAdvinfo advinfo left outer join fetch advinfo.rcvObjs as obj ");
		hqlSb.append("where advinfo.type = :type and advinfo.state = 3 ");
		
		//���ϵͳ������ΪNULL
		if(this.systemParam!=null){
			//�Ѵ�ϵͳ�������л�ȡ�Ĳ�����ӵ�Query�����
			hqlSb.append(" and advinfo.content like :content ");
		}
		
		hqlSb.append("and (obj.rvcobjid is null or (not exists (select 1 from advinfo.rcvObjs objs where objs.objid = :employeeid)) or (obj.state =1 and obj.objid = :employeeid) ) and ");
		
		if(!"5".equals(type)){
			// ������Ǵ�������
			hqlSb.append("advinfo.enddate >= :curdate and ");
		}
		if(!isIndexPage) {
			// ������/ҵ��/֪ʶ����Ϣ��ѯ������
			if(!"".equals(param.getStartDate())) {
				hqlSb.append("advinfo.releasetime >= :startdate and ");
			}
			if(!"".equals(param.getAccountDate())) {
				hqlSb.append("advinfo.releasetime <= :accountdate and ");
			}
		}
		hqlSb.append("( ");
		if(param.isNet()) {
			// ����
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
		
		//���ϵͳ������ΪNULL
		if(this.systemParam!=null){
			//�Ѵ�ϵͳ�������л�ȡ�Ĳ�����ӵ�Query�����
			hqlSb.append(" and advinfo.content like :content ");
		}
		
		hqlSb.append("and (obj.rvcobjid is null or (not exists (select 1 from advinfo.rcvObjs objs where objs.objid = :employeeid)) or (obj.state =1 and obj.objid = :employeeid) ) and ");	
		if(!"5".equals(type)){
			// ������Ǵ�������
			hqlSb.append("advinfo.enddate >= :curdate and ");
		}
		if(!isIndexPage) {
			// ������/ҵ��/֪ʶ����Ϣ��ѯ������
			if(!"".equals(param.getStartDate())) {
				hqlSb.append("advinfo.releasetime >= :startdate and ");
			}
			if(!"".equals(param.getAccountDate())) {
				hqlSb.append("advinfo.releasetime <= :accountdate and ");
			}
		}
		hqlSb.append("( ");
		if(param.isNet()) {
			// ����
			hqlSb.append("(advinfo.desttype = 2) or ");
		}
		hqlSb.append("(advinfo.desttype=3) or (advinfo.desttype=4 and obj.objid= :employeeid) ");
		hqlSb.append("or ( advinfo.desttype=5 and exists ");
		hqlSb.append("( select 1 from ChPwAdvgroupobj g where str(g.groupid) = obj.objid and g.oid = :employeeid ))");
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
				// ������/ҵ��/֪ʶ����Ϣ��ѯ������ ���� ���ҵ����ʲ�ѯ������
				if(startdateStr == null) {
					// �û������ѯ����,ϵͳĬ�ϲ�ѯ��ǰ�µ���Ϣ����1�ŵ���ǰ�գ�
					startDate = DateUtil.getCurrentMonthFirstDay(new java.util.Date());
				}else if(!"".equals(startdateStr)){
					startDate = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", startdateStr+" 00:00:00");
				}
				if(accountdateStr == null) {
					// �û������ѯ����,ϵͳĬ�ϲ�ѯ��ǰ�µ���Ϣ����1�ŵ���ǰ�գ�
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
			throw new AssertConditionException(CommunicatePlateauRetCode.COMMUNICATE_DATE_FORMAT,"�·ݸ�ʽ����ȷ��");
		}
		String employeeid = param.getEmployeeid();
		query.setString("employeeid", employeeid);
		
		query.setLong("type", type);
		if(!"5".equals(typeStr)) {
			query.setDate("curdate", new java.util.Date());
		}
		
		//���ϵͳ������ΪNULL
		if(this.systemParam!=null){
			//�Ѵ�ϵͳ�������л�ȡ�Ĳ�����ӵ�Query�����
			query.setString("content", "%"+this.systemParam+"%");
		}
	}
	
	public void setSystemParam(String sysParam){
		this.systemParam = sysParam;
	}
	public String getSystemParam(){
		return this.systemParam;
	}

}

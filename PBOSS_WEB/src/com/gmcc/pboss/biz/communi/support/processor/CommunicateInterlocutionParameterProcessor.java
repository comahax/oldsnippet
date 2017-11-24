package com.gmcc.pboss.biz.communi.support.processor;

import java.text.ParseException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;

import com.gmcc.pboss.biz.communi.service.CommunicatePlateauRetCode;
import com.gmcc.pboss.biz.communi.support.CommunicatePlateauParameter;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.exception.AssertConditionException;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.DateUtil;

public class CommunicateInterlocutionParameterProcessor extends
		DefaultHqlQueryProcessor implements QueryParameterProcessor {

	
	public CommunicateInterlocutionParameterProcessor() {
		paramEnclose = false; //��ʹ�ò�����װ
	}

	@Override
	public String getHql(QueryParameter parameter) {
		CommunicatePlateauParameter param = (CommunicatePlateauParameter)parameter;
		StringBuffer hqlSb = new StringBuffer();
		boolean isIndexPage = param.isIndexPage();
		hqlSb.append("select advinfo from ChPwAdvinfo advinfo where advinfo.type = 2 and advinfo.oprcode = :employeeid ");
		if(!isIndexPage) {
			// ���ҵ����ʲ�ѯ������
			if(!"".equals(param.getStartDate())) {
				hqlSb.append(" and advinfo.releasetime >= :startdate ");
			}
			if(!"".equals(param.getAccountDate())) {
				hqlSb.append(" and advinfo.releasetime <= :accountdate ");
			}
			if(param.getTitle() != null && !"".equals(param.getTitle())) {
				hqlSb.append(" and advinfo.title = :title ");
			}
			String state = param.getState();
			if(state != null ) {
				if(!"-1".equals(state))
					hqlSb.append(" and advinfo.state = :state ");
				else {
					// ��ѡ�����״̬ʱĬ��ȫѡ���������ļ��ж�ȡ ȫ������״̬��Keyֵ
					Map qustionStateMap = Constant.getConstantsMap(ConstantsType.QUESTION_STATE);
					if(qustionStateMap.size() > 0) {
						hqlSb.append(" and ( ");
						Set keySet = qustionStateMap.keySet();
						for(Iterator it = keySet.iterator();it.hasNext();) {
							String queState = (String)it.next();
							hqlSb.append(" advinfo.state = ").append(queState+" or");
						}
						hqlSb = hqlSb.replace(hqlSb.length()-2,hqlSb.length(),"");
						hqlSb.append(")");
					}
				}
			}
		}else {
			// �������ҳ���������ļ��ж�ȡ ȫ������״̬��Keyֵ
			Map qustionStateMap = Constant.getConstantsMap(ConstantsType.QUESTION_STATE);
			if(qustionStateMap.size() > 0) {
				hqlSb.append(" and ( ");
				Set keySet = qustionStateMap.keySet();
				for(Iterator it = keySet.iterator();it.hasNext();) {
					String queState = (String)it.next();
					hqlSb.append(" advinfo.state = ").append(queState+" or");
				}
				hqlSb = hqlSb.replace(hqlSb.length()-2,hqlSb.length(),"");
				hqlSb.append(")");
			}
		
		}
		hqlSb.append(" order by advinfo.releasetime desc");
		return hqlSb.toString();
	}
	
	public String getCntHql(QueryParameter parameter) {
		CommunicatePlateauParameter param = (CommunicatePlateauParameter)parameter;
		String type = param.getType();
		boolean isIndexPage = param.isIndexPage();
		StringBuffer hqlSb = new StringBuffer();
		hqlSb.append("select count(*) from ChPwAdvinfo advinfo where advinfo.type = 2 and advinfo.oprcode = :employeeid ");
		if(!isIndexPage) {
			// ���ҵ����ʲ�ѯ������
			if(!"".equals(param.getStartDate())) {
				hqlSb.append(" and advinfo.releasetime >= :startdate ");
			}
			if(!"".equals(param.getAccountDate())) {
				hqlSb.append(" and advinfo.releasetime <= :accountdate ");
			}
			if(param.getTitle() != null && !"".equals(param.getTitle())) {
				hqlSb.append(" and advinfo.title = :title ");
			}
			String state = param.getState();
			if(state != null ) {
				if(!"-1".equals(state))
					hqlSb.append(" and advinfo.state = :state ");
				else {
					// ��ѡ�����״̬ʱĬ��ȫѡ���������ļ��ж�ȡ ȫ������״̬��Keyֵ
					Map qustionStateMap = Constant.getConstantsMap(ConstantsType.QUESTION_STATE);
					if(qustionStateMap.size() > 0) {
						hqlSb.append(" and ( ");
						Set keySet = qustionStateMap.keySet();
						for(Iterator it = keySet.iterator();it.hasNext();) {
							String queState = (String)it.next();
							hqlSb.append(" advinfo.state = ").append(queState+" or");
						}
						hqlSb = hqlSb.replace(hqlSb.length()-2,hqlSb.length(),"");
						hqlSb.append(")");
					}
				}
			}
		}else {
			// �������ҳ���������ļ��ж�ȡ ȫ������״̬��Keyֵ
			Map qustionStateMap = Constant.getConstantsMap(ConstantsType.QUESTION_STATE);
			if(qustionStateMap.size() > 0) {
				hqlSb.append(" and ( ");
				Set keySet = qustionStateMap.keySet();
				for(Iterator it = keySet.iterator();it.hasNext();) {
					String queState = (String)it.next();
					hqlSb.append(" advinfo.state = ").append(queState+" or");
				}
				hqlSb = hqlSb.replace(hqlSb.length()-2,hqlSb.length(),"");
				hqlSb.append(")");
			}
		
		}
		hqlSb.append(" order by advinfo.releasetime desc");
		return hqlSb.toString();
	}

	@Override
	public String[] getParamEncloseName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void process(Query query, QueryParameter parameter) {
		CommunicatePlateauParameter param = (CommunicatePlateauParameter)parameter;
		String startdateStr = param.getStartDate();
		String accountdateStr = param.getAccountDate();
		java.util.Date startDate = null;
		java.util.Date accountDate = null;
		boolean isIndexPage = param.isIndexPage();
		String state = param.getState();
		String title = param.getTitle();
		String employeeid = param.getEmployeeid();
		try {
			if(!isIndexPage) {
				// ���ҵ����ʲ�ѯ������
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
				if(state != null ) {
					if(!"-1".equals(state))
						query.setLong("state", Long.valueOf(state));
				}
			}
			
		} catch (ParseException e) {
			throw new AssertConditionException(CommunicatePlateauRetCode.COMMUNICATE_DATE_FORMAT,"�·ݸ�ʽ����ȷ��");
		}
		query.setString("employeeid", employeeid);
		if(title != null && !"".equals(title)) {
			query.setString("title", title);
		}
		
	}

}

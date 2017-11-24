package com.gmcc.pboss.biz.info.reward.dao.hibernate;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Query;

import com.gmcc.pboss.biz.info.reward.model.SimFail;
import com.gmcc.pboss.biz.info.reward.support.RewardFailQueryParameter;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.common.support.Page;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryResult;

public abstract class AbstractFailDaoHibernate extends BaseDaoHibernate {

	public AbstractFailDaoHibernate(Class persistentClass) {
		super(persistentClass);
	}
	//��ȡҵ��SQL
	public abstract String getSQL(RewardFailQueryParameter parameter);
	/**
	 * 
	 * @return
	 */
	public abstract String[] getFields();
	/**
	 * ���ɶ���
	 * @param date
	 * @return
	 */
	private List setRestl(List date){
		Iterator iter = date.iterator();
		if (date.size()<0) return date;
		String[] setProperty = getFields();
		String strTem,PropertyType;
		List rtn = new ArrayList();
		try {
			while (iter.hasNext()) {
				Object setObj = getPersistentClass().newInstance();//����Ŀ�����ʵ��
				Object[] obj = (Object[])iter.next();
				//�������ֵ
				for (int i=0;i<setProperty.length;i++){
					//���丳ֵ,��ֵ������
					strTem = setProperty[i].trim();
					try{
						PropertyType = PropertyUtils.getPropertyType(setObj,strTem).getSimpleName();
						//��������,����Hibernate�Ǹ���setProperty����,������һһ��Ӧ! [*�ؼ�ǰ��]
						if ("String".equals(PropertyType)){
							PropertyUtils.setSimpleProperty(setObj,strTem , obj[i]);
						}else if("Long".equals(PropertyType)){
							//����Long,Hibernate�Զ�ΪBigDecimal����
							BigDecimal setV = (BigDecimal)obj[i];
							PropertyUtils.setSimpleProperty(setObj,strTem , new Long(setV.longValue()));
						}else if("Boolean".equals(PropertyType)){
							BigDecimal setV = (BigDecimal)obj[i];
							int b= setV.intValue();
							boolean s=true;
							if (b==0) s=false;//��0Ϊ�� 
							PropertyUtils.setSimpleProperty(setObj,strTem , new Boolean(s));
						}else if ("Byte".equals(PropertyType)){
							BigDecimal setV = (BigDecimal)obj[i];
							String s = setV.toEngineeringString();
							Byte b = new Byte(s);
							PropertyUtils.setSimpleProperty(setObj,strTem , b);
						}else if("Date".equals(PropertyType)){
							PropertyUtils.setSimpleProperty(setObj,strTem , (Date)obj[i]);
						}else{
							PropertyUtils.setSimpleProperty(setObj,strTem , obj[i]);//�ȸ�ֵ,��������
						}
					}catch(Exception e){
						logger.error("[AbstractFailDaoHibernate.setRestl] �����丳ֵ����:"+e.getMessage());
					}//try
				}//for
				rtn.add(setObj);
			}//while
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("[AbstractFailDaoHibernate.setRestl]���������:"+e.getMessage());
		}
		return rtn;
	};

	public QueryResult getAll(QueryParameterProcessor processor, QueryParameter parameter) {
		Query query = getSession().createSQLQuery(getSQL((RewardFailQueryParameter) parameter));
		Page page = null;
		if (parameter.getAction() == QueryAction.ALL) {
			page = Page.EMPTY;
		} else if (parameter.getAction() == QueryAction.SECTION) {
			page = new Page(getAllRows(processor, parameter), parameter.getSize(), parameter.getNo());
			query.setFirstResult(page.getFirstResult());
			query.setMaxResults(page.getSize());
		} else {
			throw new RuntimeException("�Ƿ���ѯ");
		}

		processor.process(query, parameter);
		List dates = setRestl(query.list());//��ֵ
		QueryResult result = new QueryResult(page, dates);
		return result;
	}

	public int getAllRows(QueryParameterProcessor processor, QueryParameter parameter) {
		String sql = "SELECT COUNT(*) FROM (" + getSQL((RewardFailQueryParameter) parameter) + ")";

		Query query = getSession().createSQLQuery(sql);

		processor.process(query, parameter);

		return ((BigDecimal) query.uniqueResult()).intValue();
	}

}

package com.gmcc.pboss.biz.info.salesDetail.dao.hibernate;

import java.math.BigDecimal;
import java.util.List;
import com.gmcc.pboss.biz.info.salesDetail.dao.RegisternewDao;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;
import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.Page;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.util.Assert;
import com.gmcc.pboss.biz.info.salesDetail.model.ChPwRegisternew;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class RegisternewDaoHibernate extends BaseHqlQueryDao implements
		RegisternewDao {
	public RegisternewDaoHibernate(){
		super(ChPwRegisternew.class);
	}
	
	/**
	 * ��ȡSQL���ܼ�¼��--SQL����HQL��乲ͬ������Parameter����
	 * @param processor ʹ��DefaultHqlQueryProcessor��������ȡHQL�Ĳ���
	 * @param parameter ��ѯ����
	 * ����BaseDao
	 */
	public int getAllRowsSQL(QueryParameterProcessor processor, QueryParameter parameter) {		
		DefaultHqlQueryProcessor hqlProc =  (DefaultHqlQueryProcessor) processor;//����������ת��
		//��֤HQLû�г���
		String hql = hqlProc.getCntHql(parameter);//����SQL����ѯ��¼������
		
		SQLQuery query = getSession().createSQLQuery(hql);
		hqlProc.process(query, parameter);
		Object count = query.uniqueResult();
		if(count == null)
			return 0;
		else {
			BigDecimal all = new BigDecimal(count.toString());
			return all.intValue();
		}
	}
	/**
	 * @param processor ʹ��DefaultHqlQueryProcessor��������ȡHQL�Ĳ���
	 * @param parameter ��ѯ����
	 * ����BaseDao
	 */
	public QueryResult getAllSQL(QueryParameterProcessor processor, QueryParameter parameter) {

		Assert.isTrue(QueryParameterProcessor.class.isAssignableFrom(processor.getClass()), 
				ServiceConditionCode.ASSIGNABLE_FROM, processor.getClass().getName()
				+ " ���� " + QueryParameterProcessor.class.getName() + " ��ʵ���࣡");
		
		DefaultHqlQueryProcessor hqlProc =  (DefaultHqlQueryProcessor) processor;
		String hql = hqlProc.getHql(parameter);//��ȡHQL
		Query query = getSession().createSQLQuery(hql);
		//.setResultTransformer(Transformers.aliasToBean(WayReversed.class));
		hqlProc.process(query, parameter);
		Page page;
		if (parameter.getAction() == QueryAction.ALL) {
			int all_size = parameter.getAll_size();
			if(parameter.getAll_size() > 0) {
				query.setFirstResult(0);
				query.setMaxResults(all_size);
			}
			page = Page.EMPTY;
		} else if (parameter.getAction() == QueryAction.SECTION) {
			page = new Page(getAllRowsSQL(processor, parameter), parameter.getSize(), parameter.getNo());//
			query.setFirstResult(page.getFirstResult());
			query.setMaxResults(page.getSize());//10
			//�������д��뱾����û�У������ڷ�ҳ��ѯ����ʱ�����ֵ�һҳֻ��ѯ��5����¼
			//���ڴ��������ơ��������Ŀǰֻ����һ���ط����ֹ��������ط��ķ�ҳ��ѯ��
			//����ʹ��SQL����HQL��δ���ֹ�
			query.setFetchSize(page.getSize());
		} else {
			throw new RuntimeException("�Ƿ���ѯ");
		}
		List rtn = query.list();
		//ChPwRegistersim.classû�м̳���BaseModel,����Ҫʹ�ò�����װ��������SQL��ѯ�У���ѯ��������࣬����Ҫ������װ
		//ʹ�ò�����װ
		/**
		if (hqlProc.isParamEnclose()){
			......
		}
		*/
		QueryResult result = new QueryResult(page, rtn);
		return result;
	}
}

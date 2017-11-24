package com.gmcc.pboss.biz.info.salesCardsTotal.dao.hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import com.gmcc.pboss.biz.info.salesCardsTotal.dao.SalesCardsTotalDao;
import com.gmcc.pboss.biz.info.salesDetail.model.ChPwRegistersim;
import com.gmcc.pboss.common.bean.BaseModel;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;
import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.Page;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.util.Assert;

public class SalesCardsTotalDaoHibernate extends BaseHqlQueryDao implements
		SalesCardsTotalDao {

	public SalesCardsTotalDaoHibernate(){
		super(ChPwRegistersim.class);
	}

	/**
	 * ��ȡHQL���ܼ�¼��
	 * @param processor ʹ��DefaultHqlQueryProcessor��������ȡHQL�Ĳ���
	 * @param parameter ��ѯ����
	 * ����BaseDao
	 */
	public int getAllRows(QueryParameterProcessor processor, QueryParameter parameter) {		
		DefaultHqlQueryProcessor hqlProc =  (DefaultHqlQueryProcessor) processor;//����������ת��
		//��֤HQLû�г���
		String hql = hqlProc.getCntHql(parameter);
		
		hql=" select  count(*)  from ( "+hql+" ) ";
		
		Query query = getSession().createSQLQuery(hql);
		//.setResultTransformer(Transformers.aliasToBean(com.gmcc.pboss.biz.info.salesDetail.model.RegistersimDetail.class));
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
	public QueryResult getAll(QueryParameterProcessor processor, QueryParameter parameter) {

		Assert.isTrue(QueryParameterProcessor.class.isAssignableFrom(processor.getClass()), 
				ServiceConditionCode.ASSIGNABLE_FROM, processor.getClass().getName()
				+ " ���� " + QueryParameterProcessor.class.getName() + " ��ʵ���࣡");
		
		DefaultHqlQueryProcessor hqlProc =  (DefaultHqlQueryProcessor) processor;
		String hql = hqlProc.getHql(parameter);//��ȡHQL
		Query query = getSession().createSQLQuery(hql);
		//����ڴ��ṩ��װ���������Ч�ʣ��ر��ǲ�ѯȫ����¼ʱ��
		//���ʹ�÷�ҳ�����ڴ˺���Service����з�װЧ�������Բ��
		//.setResultTransformer(Transformers.aliasToBean(com.gmcc.pboss.biz.info.salesDetail.model.RegistersimDetail.class));
		
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
			page = new Page(getAllRows(processor, parameter), parameter.getSize(), parameter.getNo());
			query.setFirstResult(page.getFirstResult());
			query.setMaxResults(page.getSize());
			query.setFetchSize(page.getSize());
		} else {
			throw new RuntimeException("�Ƿ���ѯ");
		}
		List rtn = query.list();
		//ʹ�ò�����װ
		if (hqlProc.isParamEnclose()){
			Iterator list = rtn.iterator();
			List newRtn = new ArrayList();
			String[] setParm = hqlProc.getParamEncloseName();//��ȡ��װ��,�������һ���Ͳ�ѯ�����ĸ������
			while (list.hasNext()){
				Object[] objAll = (Object[]) list.next();//������Ƕ�������,��ϵͳ����
				Object obj = objAll[0];
				Assert.isTrue(BaseModel.class.isAssignableFrom(obj.getClass()),ServiceConditionCode.ASSIGNABLE_FROM, 
						"[BaseHqlQueryDao]������װ����:"+ obj.getClass().getName()+ " ���� " + BaseModel.class.getName() + " �ļ̳У�");
				//��ʼ��װ
				BaseModel newMdl = (BaseModel)obj;
				for (int i =1;i<objAll.length;i++){
					newMdl.add(setParm[i-1], objAll[i]);
				}
				newRtn.add(newMdl);
			}//����
			rtn = newRtn;
		}
		QueryResult result = new QueryResult(page, rtn);
		return result;
	}
	
}

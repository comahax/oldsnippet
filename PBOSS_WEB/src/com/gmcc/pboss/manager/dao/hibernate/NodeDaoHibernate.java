package com.gmcc.pboss.manager.dao.hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

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
import com.gmcc.pboss.manager.dao.NodeDao;
import com.gmcc.pboss.biz.info.node.model.Way;
import com.gmcc.pboss.manager.model.WayReversed;

public class NodeDaoHibernate extends BaseHqlQueryDao implements NodeDao {
	public NodeDaoHibernate(){
		super(Way.class);
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
		//����ʹ�õ���SQL��ѯ-�������������Ҳ����ʵ�֣�����Ч�ʺܲ�
		//String hql = hqlProc.getHql(parameter);
		//hql = "select count(*) from (" + hql + ")";
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
			page = new Page(getAllRowsSQL(processor, parameter), parameter.getSize(), parameter.getNo());
			query.setFirstResult(page.getFirstResult());
			query.setMaxResults(page.getSize());
		} else {
			throw new RuntimeException("�Ƿ���ѯ");
		}
		List rtn = query.list();
		//Way.classû�м̳���BaseModel,����Ҫʹ�ò�����װ��������SQL��ѯ�У���ѯ��������࣬����Ҫ������װ
		//ʹ�ò�����װ
		/**
		if (hqlProc.isParamEnclose()){
			......
		}
		*/
		QueryResult result = new QueryResult(page, rtn);
		return result;
	}
	/**
	 * ��HQL���������ѯ ����Ψһ�Ľ��
	 * @param processor ʹ��DefaultHqlQueryProcessor��������ȡHQL�Ĳ���
	 * @param parameter ��ѯ����
	 * @return
	public Object getOneSQL(QueryParameterProcessor processor, QueryParameter parameter) {
		
		Assert.isTrue(QueryParameterProcessor.class.isAssignableFrom(processor.getClass()), 
				ServiceConditionCode.ASSIGNABLE_FROM, processor.getClass().getName()
				+ " ���� " + QueryParameterProcessor.class.getName() + " ��ʵ���࣡");
		DefaultHqlQueryProcessor hqlProc =  (DefaultHqlQueryProcessor) processor;
		String hql = hqlProc.getHql(parameter);//��ȡHQL
		Query query = getSession().createSQLQuery(hql).setResultTransformer(Transformers.aliasToBean(WayReversed.class));
		hqlProc.process(query, parameter);
		List datas = query.list();
		//��ѯ����
		if (datas.size() == 0) {
			return null;
		} else if (datas.size() == 1) {
			//Way.classû�м̳���BaseModel,����Ҫʹ�ò�����װ
			//ʹ�ò�����װ
			if (hqlProc.isParamEnclose()){
				Iterator list = datas.iterator();
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
				datas = newRtn;
			}
			
			return datas.get(0);
		} else {
			String errMsg ="NodeDaoHibernate.getOneSQL]:�������Ωһ: "+" ["+datas.size()+"] " +hql; 
			logger.error(errMsg);
			throw new IllegalStateException(errMsg);
		}
	}
	*/
}

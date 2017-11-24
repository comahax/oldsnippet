package com.gmcc.pboss.common.dao.hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import com.gmcc.pboss.common.bean.BaseModel;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.Page;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.util.Assert;

/**
 * ʹ��HQL��ѯ
 * @author yuwenjun
 *
 */
public abstract class BaseHqlQueryDao extends BaseDaoHibernate {
	
	public BaseHqlQueryDao(Class persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}

	/**
	 * ��ȡHQL���ܼ�¼��
	 * @param processor ʹ��DefaultHqlQueryProcessor��������ȡHQL�Ĳ���
	 * @param parameter ��ѯ����
	 * ����BaseDao
	 */
	/*
	 * ʷ���� 2011-10-14 ������б�ע����������δ�޸�
	 *ע�������ѯ������group by������ʽ�ο�����getAllRowsSQL()ʵ�ַ�ʽ��
	 *    ������Ա���Լ���DAO��д�˷������򱾷���ǰ���Ѵ���ʹ�ã��������̫��
	 *    ��δ�޸ġ� 
	 *    �ؼ����ڴ��д��� String hql = hqlProc.getCntHql(parameter); �Բ�ѯ���
	 *    ��select��order by���ֵĴ���
	 */
	public int getAllRows(QueryParameterProcessor processor, QueryParameter parameter) {		
		DefaultHqlQueryProcessor hqlProc =  (DefaultHqlQueryProcessor) processor;//����������ת��
		//��֤HQLû�г���
		String hql = hqlProc.getCntHql(parameter);
		
		Query query = getSession().createQuery(hql);
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
		Query query = getSession().createQuery(hql);
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
	/**
	 * ��HQL���������ѯ ����Ψһ�Ľ��
	 * @param processor ʹ��DefaultHqlQueryProcessor��������ȡHQL�Ĳ���
	 * @param parameter ��ѯ����
	 * @return
	 */
	public Object getOne(QueryParameterProcessor processor, QueryParameter parameter) {
		
		Assert.isTrue(QueryParameterProcessor.class.isAssignableFrom(processor.getClass()), 
				ServiceConditionCode.ASSIGNABLE_FROM, processor.getClass().getName()
				+ " ���� " + QueryParameterProcessor.class.getName() + " ��ʵ���࣡");
		DefaultHqlQueryProcessor hqlProc =  (DefaultHqlQueryProcessor) processor;
		String hql = hqlProc.getHql(parameter);//��ȡHQL
		Query query = getSession().createQuery(hql);
		hqlProc.process(query, parameter);
		List datas = query.list();
		//��ѯ����
		if (datas.size() == 0) {
			return null;
		} else if (datas.size() == 1) {
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
			String errMsg ="BaseHqlQeuryDao.getOne]:�������Ωһ: "+" ["+datas.size()+"] " +hql; 
			logger.error(errMsg);
			throw new IllegalStateException(errMsg);
		}
	}


//	/**
//	 * ���ɶ���
//	 * @param date
//	 * @return
//	 */
//	private List setRestl(List date){
//		Iterator iter = date.iterator();
//		if (date.size()<0) return date;
//		String[] setProperty = getFields();
//		String strTem,PropertyType;
//		List rtn = new ArrayList();
//		try {
//			while (iter.hasNext()) {
//				Object setObj = getPersistentClass().newInstance();//����Ŀ�����ʵ��
//				Object[] obj = (Object[])iter.next();
//				//�������ֵ
//				for (int i=0;i<setProperty.length;i++){
//					//���丳ֵ,��ֵ������
//					strTem = setProperty[i].trim();
//					try{
//						PropertyType = PropertyUtils.getPropertyType(setObj,strTem).getSimpleName();
//						//��������,����Hibernate�Ǹ���setProperty����,������һһ��Ӧ!@@�ؼ�ǰ��
//						if ("String".equals(PropertyType)){
//							PropertyUtils.setSimpleProperty(setObj,strTem , obj[i]);
//						}else if("Long".equals(PropertyType)){
//							//����Long,Hibernate�Զ�ΪBigDecimal����
//							BigDecimal setV = (BigDecimal)obj[i];
//							PropertyUtils.setSimpleProperty(setObj,strTem , new Long(setV.longValue()));
//						}else if("Boolean".equals(PropertyType)){
//							BigDecimal setV = (BigDecimal)obj[i];
//							int b= setV.intValue();
//							boolean s=true;
//							if (b==0) s=false;//��0Ϊ�� 
//							PropertyUtils.setSimpleProperty(setObj,strTem , new Boolean(s));
//						}else if ("Byte".equals(PropertyType)){
//							BigDecimal setV = (BigDecimal)obj[i];
//							String s = setV.toEngineeringString();
//							Byte b = new Byte(s);
//							PropertyUtils.setSimpleProperty(setObj,strTem , b);
//						}else if("Date".equals(PropertyType)){
//							PropertyUtils.setSimpleProperty(setObj,strTem , (Date)obj[i]);
//						}else{
//							PropertyUtils.setSimpleProperty(setObj,strTem , obj[i]);//�ȸ�ֵ,��������
//						}
//					}catch(Exception e){
//						logger.error("[AbstractFailDaoHibernate.setRestl] �����丳ֵ����:"+e.getMessage());
//					}//try
//				}//for
//				rtn.add(setObj);
//			}//while
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			logger.error("[AbstractFailDaoHibernate.setRestl]���������:"+e.getMessage());
//		}
//		return rtn;
//	};
	
	/**
	 * ʷ���� 2011-10-14
	 * ʹ��SQL��ѯ
	 * HQLʵ�ֵĶ�����Ӳ�ѯ�ܲ����㣬���Ӳ�ѯʹ��SQL���ӱ��
	 * ��ȡSQL���ܼ�¼��--SQL����HQL��乲ͬ������Parameter����
	 * @param processor ʹ��DefaultHqlQueryProcessor��������ȡSQL�Ĳ���
	 * @param parameter ��ѯ����
	 * ����BaseDao
	 */
	public int getAllRowsSQL(QueryParameterProcessor processor, QueryParameter parameter) {		
		DefaultHqlQueryProcessor hqlProc =  (DefaultHqlQueryProcessor) processor;//����������ת��
		//��֤HQLû�г���
		String hql = hqlProc.getCntHql(parameter);//����SQL����ѯ��¼������
		
		//hql.matches("group\\s*by");
		Pattern p = Pattern.compile("group\\s*by[\\w|\\W|\\s|\\S]*",
				Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(hql);	
		if(m.find()){
			//�����ѯ����а���group by���������һ�д���
			hql=" select  count(*)  from ( "+hql+" ) ";
		}
		
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
	 * ʷ���� 2011-10-14
	 * ʹ��SQL��ѯ
	 * HQLʵ�ֵĶ�����Ӳ�ѯ�ܲ����㣬���Ӳ�ѯʹ��SQL���ӱ��
	 * @param processor ʹ��DefaultHqlQueryProcessor��������ȡSQL�Ĳ���
	 * @param parameter ��ѯ����
	 * ����BaseDao
	 */
	public QueryResult getAllSQL(QueryParameterProcessor processor, QueryParameter parameter) {

//		Assert.isTrue(QueryParameterProcessor.class.isAssignableFrom(processor.getClass()), 
//				ServiceConditionCode.ASSIGNABLE_FROM, processor.getClass().getName()
//				+ " ���� " + QueryParameterProcessor.class.getName() + " ��ʵ���࣡");
		
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
			query.setMaxResults(page.getSize());
			query.setFetchSize(page.getSize());
		} else {
			throw new RuntimeException("�Ƿ���ѯ");
		}
		List rtn = query.list();
		//ʹ�ò�����װ
//		if (hqlProc.isParamEnclose()){
//			Iterator list = rtn.iterator();
//			List newRtn = new ArrayList();
//			String[] setParm = hqlProc.getParamEncloseName();//��ȡ��װ��,�������һ���Ͳ�ѯ�����ĸ������
//			while (list.hasNext()){
//				Object[] objAll = (Object[]) list.next();//������Ƕ�������,��ϵͳ����
//				Object obj = objAll[0];
//				Assert.isTrue(BaseModel.class.isAssignableFrom(obj.getClass()),ServiceConditionCode.ASSIGNABLE_FROM, 
//						"[BaseHqlQueryDao]������װ����:"+ obj.getClass().getName()+ " ���� " + BaseModel.class.getName() + " �ļ̳У�");
//				//��ʼ��װ
//				BaseModel newMdl = (BaseModel)obj;
//				for (int i =1;i<objAll.length;i++){
//					newMdl.add(setParm[i-1], objAll[i]);
//				}
//				newRtn.add(newMdl);
//			}//����
//			rtn = newRtn;
//		}
		QueryResult result = new QueryResult(page, rtn);
		return result;
	}
}

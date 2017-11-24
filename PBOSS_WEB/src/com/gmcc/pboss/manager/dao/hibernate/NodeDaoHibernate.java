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
	 * 提取SQL的总记录数--SQL语句和HQL语句共同存在于Parameter类中
	 * @param processor 使用DefaultHqlQueryProcessor的子类提取HQL的操作
	 * @param parameter 查询参数
	 * 重载BaseDao
	 */
	public int getAllRowsSQL(QueryParameterProcessor processor, QueryParameter parameter) {		
		DefaultHqlQueryProcessor hqlProc =  (DefaultHqlQueryProcessor) processor;//参数处理器转换
		//保证HQL没有出错
		String hql = hqlProc.getCntHql(parameter);//构造SQL，查询记录总条数
		//这里使用的是SQL查询-按照下面的做法也可以实现，但是效率很差
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
	 * @param processor 使用DefaultHqlQueryProcessor的子类提取HQL的操作
	 * @param parameter 查询参数
	 * 重载BaseDao
	 */
	public QueryResult getAllSQL(QueryParameterProcessor processor, QueryParameter parameter) {

		Assert.isTrue(QueryParameterProcessor.class.isAssignableFrom(processor.getClass()), 
				ServiceConditionCode.ASSIGNABLE_FROM, processor.getClass().getName()
				+ " 不是 " + QueryParameterProcessor.class.getName() + " 的实现类！");
		
		DefaultHqlQueryProcessor hqlProc =  (DefaultHqlQueryProcessor) processor;
		String hql = hqlProc.getHql(parameter);//提取HQL
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
			throw new RuntimeException("非法查询");
		}
		List rtn = query.list();
		//Way.class没有继承自BaseModel,不需要使用参数封装，而且在SQL查询中，查询结果不是类，不需要参数封装
		//使用参数封装
		/**
		if (hqlProc.isParamEnclose()){
			......
		}
		*/
		QueryResult result = new QueryResult(page, rtn);
		return result;
	}
	/**
	 * 用HQL进行连表查询 返回唯一的结果
	 * @param processor 使用DefaultHqlQueryProcessor的子类提取HQL的操作
	 * @param parameter 查询参数
	 * @return
	public Object getOneSQL(QueryParameterProcessor processor, QueryParameter parameter) {
		
		Assert.isTrue(QueryParameterProcessor.class.isAssignableFrom(processor.getClass()), 
				ServiceConditionCode.ASSIGNABLE_FROM, processor.getClass().getName()
				+ " 不是 " + QueryParameterProcessor.class.getName() + " 的实现类！");
		DefaultHqlQueryProcessor hqlProc =  (DefaultHqlQueryProcessor) processor;
		String hql = hqlProc.getHql(parameter);//提取HQL
		Query query = getSession().createSQLQuery(hql).setResultTransformer(Transformers.aliasToBean(WayReversed.class));
		hqlProc.process(query, parameter);
		List datas = query.list();
		//查询数据
		if (datas.size() == 0) {
			return null;
		} else if (datas.size() == 1) {
			//Way.class没有继承自BaseModel,不需要使用参数封装
			//使用参数封装
			if (hqlProc.isParamEnclose()){
				Iterator list = datas.iterator();
				List newRtn = new ArrayList();
				String[] setParm = hqlProc.getParamEncloseName();//提取封装名,数组个数一定和查询出来的个数相等
				while (list.hasNext()){
					Object[] objAll = (Object[]) list.next();//如果不是对象数组,由系统报错
					Object obj = objAll[0];
					Assert.isTrue(BaseModel.class.isAssignableFrom(obj.getClass()),ServiceConditionCode.ASSIGNABLE_FROM, 
							"[BaseHqlQueryDao]参数封装出错:"+ obj.getClass().getName()+ " 不是 " + BaseModel.class.getName() + " 的继承！");
					//开始封装
					BaseModel newMdl = (BaseModel)obj;
					for (int i =1;i<objAll.length;i++){
						newMdl.add(setParm[i-1], objAll[i]);
					}
					newRtn.add(newMdl);
				}//遍列
				datas = newRtn;
			}
			
			return datas.get(0);
		} else {
			String errMsg ="NodeDaoHibernate.getOneSQL]:结果不是惟一: "+" ["+datas.size()+"] " +hql; 
			logger.error(errMsg);
			throw new IllegalStateException(errMsg);
		}
	}
	*/
}

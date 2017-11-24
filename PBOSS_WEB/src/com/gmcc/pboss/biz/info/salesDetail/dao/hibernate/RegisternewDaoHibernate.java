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
	 * 提取SQL的总记录数--SQL语句和HQL语句共同存在于Parameter类中
	 * @param processor 使用DefaultHqlQueryProcessor的子类提取HQL的操作
	 * @param parameter 查询参数
	 * 重载BaseDao
	 */
	public int getAllRowsSQL(QueryParameterProcessor processor, QueryParameter parameter) {		
		DefaultHqlQueryProcessor hqlProc =  (DefaultHqlQueryProcessor) processor;//参数处理器转换
		//保证HQL没有出错
		String hql = hqlProc.getCntHql(parameter);//构造SQL，查询记录总条数
		
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
			page = new Page(getAllRowsSQL(processor, parameter), parameter.getSize(), parameter.getNo());//
			query.setFirstResult(page.getFirstResult());
			query.setMaxResults(page.getSize());//10
			//下面这行代码本可以没有，但是在分页查询中有时候会出现第一页只查询到5条记录
			//故在此做此限制。这个问题目前只在这一个地方出现过，其他地方的分页查询，
			//不论使用SQL还是HQL都未出现过
			query.setFetchSize(page.getSize());
		} else {
			throw new RuntimeException("非法查询");
		}
		List rtn = query.list();
		//ChPwRegistersim.class没有继承自BaseModel,不需要使用参数封装，而且在SQL查询中，查询结果不是类，不需要参数封装
		//使用参数封装
		/**
		if (hqlProc.isParamEnclose()){
			......
		}
		*/
		QueryResult result = new QueryResult(page, rtn);
		return result;
	}
}

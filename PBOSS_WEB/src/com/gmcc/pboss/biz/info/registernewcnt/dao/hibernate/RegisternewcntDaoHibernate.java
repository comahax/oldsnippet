package com.gmcc.pboss.biz.info.registernewcnt.dao.hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import com.gmcc.pboss.biz.info.registernewcnt.dao.RegisternewcntDao;
import com.gmcc.pboss.biz.info.salesDetail.model.ChPwRegisternew;
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

public class RegisternewcntDaoHibernate extends BaseHqlQueryDao implements RegisternewcntDao {

	public RegisternewcntDaoHibernate(){
		super(ChPwRegisternew.class);
	}
	
	/**
	 * 提取HQL的总记录数
	 * @param processor 使用DefaultHqlQueryProcessor的子类提取HQL的操作
	 * @param parameter 查询参数
	 * 重载BaseDao
	 */
	public int getAllRows(QueryParameterProcessor processor, QueryParameter parameter) {		
		DefaultHqlQueryProcessor hqlProc =  (DefaultHqlQueryProcessor) processor;//参数处理器转换
		//保证HQL没有出错
		String str = hqlProc.getHql(parameter);
		StringBuffer hql = new StringBuffer();
		hql.append("select count(*) from ( ");
		hql.append(str);
		hql.append(" )");
		
		Query query = getSession().createSQLQuery(hql.toString());
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
	public QueryResult getAll(QueryParameterProcessor processor, QueryParameter parameter) {

		Assert.isTrue(QueryParameterProcessor.class.isAssignableFrom(processor.getClass()), 
				ServiceConditionCode.ASSIGNABLE_FROM, processor.getClass().getName()
				+ " 不是 " + QueryParameterProcessor.class.getName() + " 的实现类！");
		
		DefaultHqlQueryProcessor hqlProc =  (DefaultHqlQueryProcessor) processor;
		String hql = hqlProc.getHql(parameter);//提取HQL
		Query query = getSession().createSQLQuery(hql);
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
			throw new RuntimeException("非法查询");
		}
		List rtn = query.list();
		//使用参数封装
		if (hqlProc.isParamEnclose()){
			Iterator list = rtn.iterator();
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
			rtn = newRtn;
		}
		QueryResult result = new QueryResult(page, rtn);
		return result;
	}
}

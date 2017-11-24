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
 * 使用HQL查询
 * @author yuwenjun
 *
 */
public abstract class BaseHqlQueryDao extends BaseDaoHibernate {
	
	public BaseHqlQueryDao(Class persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 提取HQL的总记录数
	 * @param processor 使用DefaultHqlQueryProcessor的子类提取HQL的操作
	 * @param parameter 查询参数
	 * 重载BaseDao
	 */
	/*
	 * 史晓龙 2011-10-14 添加下列备注，方法本身未修改
	 *注：如果查询语句包含group by，则处理方式参考方法getAllRowsSQL()实现方式，
	 *    开发人员在自己的DAO重写此方法。因本方法前期已大量使用，改造风险太大，
	 *    故未修改。 
	 *    关键在于此行代码 String hql = hqlProc.getCntHql(parameter); 对查询语句
	 *    中select和order by部分的处理
	 */
	public int getAllRows(QueryParameterProcessor processor, QueryParameter parameter) {		
		DefaultHqlQueryProcessor hqlProc =  (DefaultHqlQueryProcessor) processor;//参数处理器转换
		//保证HQL没有出错
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
	/**
	 * 用HQL进行连表查询 返回唯一的结果
	 * @param processor 使用DefaultHqlQueryProcessor的子类提取HQL的操作
	 * @param parameter 查询参数
	 * @return
	 */
	public Object getOne(QueryParameterProcessor processor, QueryParameter parameter) {
		
		Assert.isTrue(QueryParameterProcessor.class.isAssignableFrom(processor.getClass()), 
				ServiceConditionCode.ASSIGNABLE_FROM, processor.getClass().getName()
				+ " 不是 " + QueryParameterProcessor.class.getName() + " 的实现类！");
		DefaultHqlQueryProcessor hqlProc =  (DefaultHqlQueryProcessor) processor;
		String hql = hqlProc.getHql(parameter);//提取HQL
		Query query = getSession().createQuery(hql);
		hqlProc.process(query, parameter);
		List datas = query.list();
		//查询数据
		if (datas.size() == 0) {
			return null;
		} else if (datas.size() == 1) {
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
			String errMsg ="BaseHqlQeuryDao.getOne]:结果不是惟一: "+" ["+datas.size()+"] " +hql; 
			logger.error(errMsg);
			throw new IllegalStateException(errMsg);
		}
	}


//	/**
//	 * 生成对象
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
//				Object setObj = getPersistentClass().newInstance();//创建目标对象实例
//				Object[] obj = (Object[])iter.next();
//				//构造对象赋值
//				for (int i=0;i<setProperty.length;i++){
//					//反射赋值,出值则跳过
//					strTem = setProperty[i].trim();
//					try{
//						PropertyType = PropertyUtils.getPropertyType(setObj,strTem).getSimpleName();
//						//处理类型,因于Hibernate是根据setProperty来查,所以能一一对应!@@关键前提
//						if ("String".equals(PropertyType)){
//							PropertyUtils.setSimpleProperty(setObj,strTem , obj[i]);
//						}else if("Long".equals(PropertyType)){
//							//对于Long,Hibernate自动为BigDecimal类型
//							BigDecimal setV = (BigDecimal)obj[i];
//							PropertyUtils.setSimpleProperty(setObj,strTem , new Long(setV.longValue()));
//						}else if("Boolean".equals(PropertyType)){
//							BigDecimal setV = (BigDecimal)obj[i];
//							int b= setV.intValue();
//							boolean s=true;
//							if (b==0) s=false;//非0为真 
//							PropertyUtils.setSimpleProperty(setObj,strTem , new Boolean(s));
//						}else if ("Byte".equals(PropertyType)){
//							BigDecimal setV = (BigDecimal)obj[i];
//							String s = setV.toEngineeringString();
//							Byte b = new Byte(s);
//							PropertyUtils.setSimpleProperty(setObj,strTem , b);
//						}else if("Date".equals(PropertyType)){
//							PropertyUtils.setSimpleProperty(setObj,strTem , (Date)obj[i]);
//						}else{
//							PropertyUtils.setSimpleProperty(setObj,strTem , obj[i]);//先赋值,再找问题
//						}
//					}catch(Exception e){
//						logger.error("[AbstractFailDaoHibernate.setRestl] 对象反射赋值出错:"+e.getMessage());
//					}//try
//				}//for
//				rtn.add(setObj);
//			}//while
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			logger.error("[AbstractFailDaoHibernate.setRestl]对象反射出错:"+e.getMessage());
//		}
//		return rtn;
//	};
	
	/**
	 * 史晓龙 2011-10-14
	 * 使用SQL查询
	 * HQL实现的多表连接查询很不方便，复杂查询使用SQL更加便捷
	 * 提取SQL的总记录数--SQL语句和HQL语句共同存在于Parameter类中
	 * @param processor 使用DefaultHqlQueryProcessor的子类提取SQL的操作
	 * @param parameter 查询参数
	 * 重载BaseDao
	 */
	public int getAllRowsSQL(QueryParameterProcessor processor, QueryParameter parameter) {		
		DefaultHqlQueryProcessor hqlProc =  (DefaultHqlQueryProcessor) processor;//参数处理器转换
		//保证HQL没有出错
		String hql = hqlProc.getCntHql(parameter);//构造SQL，查询记录总条数
		
		//hql.matches("group\\s*by");
		Pattern p = Pattern.compile("group\\s*by[\\w|\\W|\\s|\\S]*",
				Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(hql);	
		if(m.find()){
			//如果查询语句中包含group by则加入下面一行代码
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
	 * 史晓龙 2011-10-14
	 * 使用SQL查询
	 * HQL实现的多表连接查询很不方便，复杂查询使用SQL更加便捷
	 * @param processor 使用DefaultHqlQueryProcessor的子类提取SQL的操作
	 * @param parameter 查询参数
	 * 重载BaseDao
	 */
	public QueryResult getAllSQL(QueryParameterProcessor processor, QueryParameter parameter) {

//		Assert.isTrue(QueryParameterProcessor.class.isAssignableFrom(processor.getClass()), 
//				ServiceConditionCode.ASSIGNABLE_FROM, processor.getClass().getName()
//				+ " 不是 " + QueryParameterProcessor.class.getName() + " 的实现类！");
		
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
			query.setMaxResults(page.getSize());
			query.setFetchSize(page.getSize());
		} else {
			throw new RuntimeException("非法查询");
		}
		List rtn = query.list();
		//使用参数封装
//		if (hqlProc.isParamEnclose()){
//			Iterator list = rtn.iterator();
//			List newRtn = new ArrayList();
//			String[] setParm = hqlProc.getParamEncloseName();//提取封装名,数组个数一定和查询出来的个数相等
//			while (list.hasNext()){
//				Object[] objAll = (Object[]) list.next();//如果不是对象数组,由系统报错
//				Object obj = objAll[0];
//				Assert.isTrue(BaseModel.class.isAssignableFrom(obj.getClass()),ServiceConditionCode.ASSIGNABLE_FROM, 
//						"[BaseHqlQueryDao]参数封装出错:"+ obj.getClass().getName()+ " 不是 " + BaseModel.class.getName() + " 的继承！");
//				//开始封装
//				BaseModel newMdl = (BaseModel)obj;
//				for (int i =1;i<objAll.length;i++){
//					newMdl.add(setParm[i-1], objAll[i]);
//				}
//				newRtn.add(newMdl);
//			}//遍列
//			rtn = newRtn;
//		}
		QueryResult result = new QueryResult(page, rtn);
		return result;
	}
}

package com.gmcc.pboss.common.support;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.util.Assert;

public abstract class DefaultHqlQueryProcessor implements QueryParameterProcessor {
	/**
	 * hql语句
	 */
	protected String hql;
	/**
	 * 是否使用参数封装
	 */
	protected boolean paramEnclose = false;
	
	/**
	 * 继承父类,本类不处理Criteria查询
	 * 
	 */
	public void process(Criteria criteria, QueryParameter parameter) {
		throw new RuntimeException("[DefaultHqlQueryProcessor:]不允许使用Ctriteria查询!");
	}
	
	/**
	 * 由子类实现process查询封装
	 * @param query Hibernate Query对象
	 * @param parameter 查询参数对象
	 */
	public abstract void process(Query query, QueryParameter parameter);
	/**
	 * 提取封装的名称
	 */
	public abstract String[] getParamEncloseName();
	
	/**
	 * 返回HQL
	 * @return the hql
	 */
	public abstract String getHql(QueryParameter parameter);

	/**
	 * 返回总计数的HQL : 注意,使用HQL做统计不能带有order by !
	 * @return the hql
	 */
	public String getCntHql(QueryParameter parameter){
		String countQueryString = " select count (*) "
			+ removeSelect(removeOrders(this.getHql(parameter)));
		return countQueryString;
	}
	/**
	 * @param hql the hql to set
	 */
	public void setHql(String hql) {
		this.hql = hql;
	}

	/**
	 * @return the paramEnclose
	 */
	public boolean isParamEnclose() {
		return paramEnclose;
	}

	/**
	 * @param paramEnclose the paramEnclose to set
	 */
	public void setParamEnclose(boolean paramEnclose) {
		this.paramEnclose = paramEnclose;
	}  
	/**
	 * 删除自动生成的HQL中Select下所有
	 * @param hql
	 * @return
	 */
	protected static String removeSelect(String hql) {
		Assert.hasText(hql);
		int beginPos = hql.toLowerCase().indexOf("from");
		Assert.isTrue(beginPos != -1, " hql : " + hql
				+ " must has a keyword 'from'");
		return hql.substring(beginPos);
	}
	/**
	 * 删除自动生成的HQL中Order的东西
	 * @param hql
	 * @return
	 */
	protected static String removeOrders(String hql) {
		Assert.hasText(hql);
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*",
				Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(hql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}
}

package com.gmcc.pboss.common.support;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.util.Assert;

public abstract class DefaultHqlQueryProcessor implements QueryParameterProcessor {
	/**
	 * hql���
	 */
	protected String hql;
	/**
	 * �Ƿ�ʹ�ò�����װ
	 */
	protected boolean paramEnclose = false;
	
	/**
	 * �̳и���,���಻����Criteria��ѯ
	 * 
	 */
	public void process(Criteria criteria, QueryParameter parameter) {
		throw new RuntimeException("[DefaultHqlQueryProcessor:]������ʹ��Ctriteria��ѯ!");
	}
	
	/**
	 * ������ʵ��process��ѯ��װ
	 * @param query Hibernate Query����
	 * @param parameter ��ѯ��������
	 */
	public abstract void process(Query query, QueryParameter parameter);
	/**
	 * ��ȡ��װ������
	 */
	public abstract String[] getParamEncloseName();
	
	/**
	 * ����HQL
	 * @return the hql
	 */
	public abstract String getHql(QueryParameter parameter);

	/**
	 * �����ܼ�����HQL : ע��,ʹ��HQL��ͳ�Ʋ��ܴ���order by !
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
	 * ɾ���Զ����ɵ�HQL��Select������
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
	 * ɾ���Զ����ɵ�HQL��Order�Ķ���
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

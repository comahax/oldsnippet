package com.asisinfo.common.hibernate;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.asisinfo.common.pager.IPage;

/**
 * ��װ��ѯѡ���Ϊ��ҳ��ѯ��ѡ��ʹ��
 * @author johnson
 */
public class QueryOption {
	
	/** ��ҳ��ʽ���ڴ��ҳ��ͨ��list.size()�����¼��*/
	public static final String PAGE_LIST = "PAGE_LIST";
	
	/**��ҳ��ʽ�����ݿ��ҳ��ͨ��select count(*) from (sql)����ʽ�������¼����Ŀǰֻ֧��informix10��oracle*/
	public static final String PAGE_NEST = "PAGE_NEST";
	
	/**��ҳ��ʽ�����ݿ��ҳ��ͨ�� ��fromǰ����任��select count(*)�������¼��*/
	public static final String PAGE_AUTO = "PAGE_AUTO";
	
	/** ����ҳ����ѯ���м�¼*/
	public static final String PAGE_NONE = "PAGE_NONE";
	
	/** ��Ҫ��ѯ��ҳ�� */
	private int pageNo = 1;
	
	/** ÿҳ�ļ�¼��*/
	private int pageSize = 20;
	
	/** ��ҳ���ͣ�Ĭ��ΪPAGE_AUTO*/
	private String pagingType = PAGE_AUTO;
	
	private Map dynamicBeanConfig;
	
	public int getPageNo() {
		return pageNo;
	}
	/**
	 * ���ò�ѯ��ҳ��
	 * @param pageNo
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * ����ÿҳ��¼��
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getPagingType() {
		return pagingType;
	}
	/**
	 * ���ò�ѯ�ķ�ҳ����
	 * @param pagingType
	 * @see QueryOption#PAGE_AUTO
	 * @see QueryOption#PAGE_NEST
	 * @see QueryOption#PAGE_LIST
	 * @see QueryOption#PAGE_NONE
	 */
	public void setPagingType(String pagingType) {
		this.pagingType = pagingType;
	}

	/**
	 * ��ȡĬ�ϵĲ�ѯѡ��
	 * @return Ĭ�ϵ�QueryOption����
	 */
	public static QueryOption getInstance(){
		return new QueryOption();
	}

	/**
	 * ͨ��request����Ĭ�ϵĲ�ѯѡ��÷����������л�ȡ��ǰ��ѯ��Ӧ��ҳ��pageNo�Լ�ÿҳ��СpageSize
	 * @param request
	 * @return Ĭ�ϵ�QueryOption����
	 */
	public static QueryOption getInstance(HttpServletRequest request){
		QueryOption opt = new QueryOption();
		String pageNoStr = request.getParameter(IPage.PAGE_NO);
		String pageSizeStr = request.getParameter(IPage.PAGE_SIZE);
		if(StringUtils.isEmpty(pageNoStr)||StringUtils.isEmpty(pageSizeStr))
			return opt;
		try {
			opt.setPageNo(Integer.parseInt(pageNoStr));
			opt.setPageSize(Integer.parseInt(pageSizeStr));
		} catch (NumberFormatException e) {
		}
		return opt;
	}
	public Map getDynamicBeanConfig() {
		return dynamicBeanConfig;
	}
	public void setDynamicBeanConfig(Map dynamicBeanConfig) {
		this.dynamicBeanConfig = dynamicBeanConfig;
	}
	
}	

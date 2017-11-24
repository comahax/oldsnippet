package com.asisinfo.common.pager;

import java.util.List;

public interface IPage {
	
	public final static String PAGE_NO="pageNo";
	public final static String PAGE_SIZE="pageSize";
	public final static String ROWS="rows";
	public final static String TOTAL="total";
	public final static String PAGE_COUNT="pageCount";
	
	/**
	 * �Ƿ�Ϊ��һҳ
	 */
	public boolean isFirstPage();

	/**
	 * <p>
	 * �Ƿ�Ϊ���һҳ
	 */
	public boolean isLastPage();

	/**
	 * ��û����һҳ
	 */
	public boolean hasNextPage();

	/**
	 * ��û��ǰһҳ
	 */
	public boolean hasPreviousPage();

	/**
	 * �õ��趨��ҳ��С,��������ʵ���Ա��ж��Ƿ�
	 */
	public int getPageSize();

	/**
	 * �õ����һҳ��ҳ��
	 */
	public int getLastPageNo();

	/**
	 * �õ���һҳ��ҳ��
	 */
	public int getNextPageNo();

	/**
	 * �õ�ǰһҳ��ҳ��
	 */
	public int getPreviousPageNo();

	/**
	 * �õ���ҳ��ҳ��
	 */
	public int getThisPageNo();

	/**
	 * �õ���ҳ��һ��Ԫ�������Ԫ���еı��
	 */
	public int getThisPageFirstElementNo();

	/**
	 * �õ���ҳ���һ��Ԫ�������Ԫ���еı��
	 */
	public int getThisPageLastElementNo();

	/**
	 * �õ�����Ԫ�ظ���
	 */
	public int getTotalNumberOfElements();

	/**
	 * �õ���ҳ�а��Ԫ��
	 */
	public List<?> getThisPageElements();
	
	
	public int getTotalNumberOfPages();
	/**
	 * ���ô�ҳ���Ԫ��
	 */
	public void setThisPageElements(List<?> list);
	
	/**
	 * ����ҳ��
	 */
	public void setPageNo(int pageNumber);

	/**
	 * ����ÿҳ��¼��
	 */
	public void setPageSize(int pageSize);

	/**
	 * ���ü�¼����
	 */
	public void setTotal(int total);
	
}

package com.asisinfo.common.jdbc;

import java.sql.ResultSetMetaData;
import java.util.List;

public interface IPage {

	/**
	 * <p>
	 * �Ƿ�Ϊ��һҳ
	 * 
	 * @return
	 */
	public boolean isFirstPage();

	/**
	 * <p>
	 * �Ƿ�Ϊ���һҳ
	 * 
	 * @return
	 */
	public boolean isLastPage();

	/**
	 * <p>
	 * ��û����һҳ
	 * 
	 * @return
	 */
	public boolean hasNextPage();

	/**
	 * <p>
	 * ��û��ǰһҳ
	 * 
	 * @return
	 */
	public boolean hasPreviousPage();

	/**
	 * <p>
	 * �õ��趨��ҳ��С,��������ʵ���Ա��ж��Ƿ�
	 * 
	 * @return
	 */
	public int getPageSize();

	/**
	 * <p>
	 * �õ����һҳ��ҳ��
	 * 
	 * @return
	 */
	public int getLastPageNumber();

	/**
	 * <p>
	 * �õ���һҳ��ҳ��
	 * 
	 * @return
	 */
	public int getNextPageNumber();

	/**
	 * <p>
	 * �õ�ǰһҳ��ҳ��
	 * 
	 * @return
	 */
	public int getPreviousPageNubmer();

	/**
	 * <p>
	 * �õ���ҳ��ҳ��
	 * 
	 * @return
	 */
	public int getThisPageNumber();

	/**
	 * <p>
	 * �õ���ҳ��һ��Ԫ��������Ԫ���еı��
	 * 
	 * @return
	 */
	public int getThisPageFirstElementNumber();

	/**
	 * <p>
	 * �õ���ҳ���һ��Ԫ��������Ԫ���еı��
	 * 
	 * @return
	 */
	public int getThisPageLastElementNumber();

	/**
	 * <p>
	 * �õ�����Ԫ�ظ���
	 * 
	 * @return
	 */
	public int getTotalNumberOfElements();

	/**
	 * <p>
	 * �õ���ҳ�а�����Ԫ��
	 * 
	 * @return
	 */
	public List getThisPageElements();
	
	/**
	 * ���ô�ҳ������Ԫ��
	 */
	public void setThisPageElements(List list);
	
	/**
	 * �Ƿ��ȡ�������Ԫ���ݣ�Ĭ�ϲ���ȡ
	 * @param extractMetaData
	 */
	public void setExtractMetaData(boolean extractMetaData);
	
	/**
	 * ��ȡ�������Ԫ����
	 * @return
	 */
	public ResultSetMetaData getMetaData();
}

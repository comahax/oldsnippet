package com.gmcc.pboss.common.jqTable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Page {

	public static final Page EMPTY = new Page(-1, -1, -1);
	
	/**
	 * �ܼ�¼��
	 */
	private int rows;
	
	/**
	 * ҳ����ʾ��¼��(����)
	 */
	private int size;
	
	/**
	 * ��ǰҳ��
	 */
	private int current;
	
	/**
	 * ��ҳ��
	 */
	private int numbers;

	private final int first = 1;
	/**
	 * ҳ���ö���
	 * @param rows ���м�¼����
	 * @param size ҳ�ڼ�¼��
	 * @param current ��Ȼҳ��
	 */
	public Page(int rows, int size, int current) {
		this.rows = rows;
		this.size = size;
		this.current = current;

		init();
	}

	private void init() {
		initNumbers();
		rangeOfCurrent();
	}

	private void initNumbers() {
		numbers = (int) Math.ceil((double) rows / size);
	}

	private void rangeOfCurrent() {
		current = current < first ? first : current > numbers ? numbers : current;
	}

	/**
	 * �����ܼ�¼��
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * ����ҳ����ʾ��¼��
	 */
	public int getSize() {
		return size;
	}

	/**
	 * ���ص�ǰҳ��
	 */
	public int getCurrent() {
		return current;
	}

	/**
	 * ������ҳ��
	 */
	public int getNumbers() {
		return numbers;
	}

	/**
	 * ���ص�һҳ
	 */
	public int getFirst() {
		return first;
	}

	/**
	 * �������ҳ,�ο� {@link #getNumbers()}����
	 */
	public int getLast() {
		return getNumbers();
	}

	/**
	 * �Ƿ�����һҳ
	 */
	public boolean isNext() {
		return getCurrent() < getLast();
	}

	/**
	 * �Ƿ�����һҳ
	 */
	public boolean isPrevious() {
		return getCurrent() > getFirst();
	}

	/**
	 * ȡ��ѯ���ݿ�ʱ�� org.hibernate.Query.setFirstResult() �����Ĳ���
	 */
	public int getFirstResult() {
		return (current - 1) * size;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @param current the current to set
	 */
	public void setCurrent(int current) {
		this.current = current;
	}

}

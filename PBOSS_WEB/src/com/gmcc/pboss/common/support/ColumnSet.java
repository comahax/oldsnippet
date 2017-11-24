package com.gmcc.pboss.common.support;

/**
 * jQuery QueryTable��������
 * @author yuwenjun
 *
 */
public class ColumnSet {
	/**
	 * ��ID
	 */
	private String key;
	
	/**
	 * ��������ID
	 */
	private String dataKey;
	/**
	 * ����
	 */
	private String name;
	/**
	 * ���
	 */
	private String width;
	/**
	 * ���������ݵ���
	 */
	private boolean nonData = false;
	/**
	 * ֻ�����ݣ�����ʾ�ڱ����
	 */
	private boolean nonShow = false;
	/**
	 * ���췽��
	 * @param key
	 * @param dataKey
	 * @param name
	 * @param width
	 */
	public ColumnSet(String key, String dataKey, String name, String width) {
		super();
		this.key = key;
		this.dataKey = dataKey;
		this.name = name;
		this.width = width;
	}
	/**
	 * ���췽��
	 * @param key
	 * @param dataKey
	 * @param name
	 * @param width
	 */
	public ColumnSet(String key, String dataKey, String name, String width,boolean nonData,boolean nonShow) {
		super();
		this.key = key;
		this.dataKey = dataKey;
		this.name = name;
		this.width = width;
		this.nonData = nonData;
		this.nonShow = nonShow;
	}
	/**
	 * ���췽��
	 * @param key
	 * @param dataKey
	 * @param name
	 * @param width
	 */
	public ColumnSet(String key, String name, String width) {
		super();
		this.key = key;
		this.dataKey = key;
		this.name = name;
		this.width = width;
	}
	/**
	 * ���췽��
	 * @param key
	 * @param name
	 */
	public ColumnSet(String key, String name) {
		super();
		this.key = key;
		this.dataKey = key;
		this.name = name;
		this.width = "";//-1Ϊ���Զ�ƥ����
	}
	/**
	 * ���췽��
	 * @param key
	 * @param name
	 */
	public ColumnSet(String key, String name,boolean nonData) {
		super();
		this.key = key;
		this.dataKey = key;
		this.name = name;
		this.width = "";//-1Ϊ���Զ�ƥ����
		this.nonData=nonData;
	}
	/**
	 * ���췽��
	 * @param key
	 * @param name
	 */
	public ColumnSet(String key, String name,boolean nonData,String width) {
		super();
		this.key = key;
		this.dataKey = key;
		this.name = name;
		this.width = width;//-1Ϊ���Զ�ƥ����
		this.nonData=nonData;
	}
	/**
	 * ���췽��
	 * @param key
	 * @param name
	 */
	public ColumnSet(String key, String name,boolean nonData,boolean nonShow) {
		super();
		this.key = key;
		this.dataKey = key;
		this.name = name;
		this.width = "";//-1Ϊ���Զ�ƥ����
		this.nonData=nonData;
		this.nonShow = nonShow;
	}
	/**
	 * ���췽��
	 * @param key
	 * @param name
	 */
	public ColumnSet(String key){
		super();
		this.key = key;
		this.dataKey = key;
		this.name = "NoShow";
		this.width = "";//-1Ϊ���Զ�ƥ����
		this.nonData=nonData;
		this.nonShow = true;
	}
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return the dataKey
	 */
	public String getDataKey() {
		return dataKey;
	}
	/**
	 * @param dataKey the dataKey to set
	 */
	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the width
	 */
	public String getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(String width) {
		this.width = width;
	}
	/**
	 * @return the nonData
	 */
	public boolean isNonData() {
		return nonData;
	}
	/**
	 * @param nonData the nonData to set
	 */
	public void setNonData(boolean nonData) {
		this.nonData = nonData;
	}
	/**
	 * @return the nonShow
	 */
	public boolean isNonShow() {
		return nonShow;
	}
	/**
	 * @param nonShow the nonShow to set
	 */
	public void setNonShow(boolean nonShow) {
		this.nonShow = nonShow;
	}
	
	
}

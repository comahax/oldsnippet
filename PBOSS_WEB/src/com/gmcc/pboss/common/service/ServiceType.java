package com.gmcc.pboss.common.service;
/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-7-29
 * ������Ŀ��
 * ����ģ�飺
 * ������
 */
public class ServiceType {
	/**
	 * ��ѯ
	 * ��Ӧҵ��Service��query���� 
	 */
	public static final short QUERY = 0x00;
	
	/**
	 * ��ѯ��������
	 * ��Ӧҵ��Service��queryForOne���� 
	 */
	public static final short QUERY_ONE = 0x01;
	
	/**
	 * ����/��ͨ 
	 * ��Ӧҵ��Service��initiate����
	 * */
	public static final short INITIATE = 0x03;
	
	/**
	 * �޸� 
	 * ��Ӧҵ��Service��modify����
	 */
	public static final short MODIFY = 0x04;
	
	/**
	 * ȡ��
	 * ��Ӧҵ��Service��cancel����
	 */
	public static final short CANCEL = 0x05;
	
	/**
	 * ����
	 * ��Ӧҵ��Service��other����
	 */
	public static final short OTHER = 0x06;
	
}

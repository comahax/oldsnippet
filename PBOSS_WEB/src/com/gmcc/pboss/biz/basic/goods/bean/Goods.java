package com.gmcc.pboss.biz.basic.goods.bean;


/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-9-16
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ��������Ʒ����������Ʒ
 */
public class Goods {
	/**�׿�*/
	public static final int SUIT_CARD = 1;
	/**�׿���*/
	public static final int SUIT_CARD_PACAKAGE = 2;
	/**��ֵ��*/
	public static final int ABOUND_VALUE_CARD = 3;
	
	/**��Ʒ����*/
	private String type;
	/**��Ʒ���κ�*/
	private String id = "";
	/**��Ʒ����*/
	private String name;
	/**��Ʒ�ۼ�*/
	private String price;
	/** ������ϸ */
	private String mobiles;
	//�ύ����
	/** ��Ʒ����(����) */
	private String comType = "";
	/** �������� */
	private int orderCount=0;
	/** ����KEY */
	private String key = "";
	/**
	 * �Ƿ��Ѿ��ڹ��ﳵ��
	 */
	private boolean inCar = false;
	
	/**��Ʒ����(����) */
	public String getName() {
		return name;
	}
	/**��Ʒ����*/
	public void setName(String name) {
		this.name = name;
	}
	
	/**��Ʒ����*/
	public String getPrice() {
		return price;
	}
	/**��Ʒ����*/
	public void setPrice(String price) {
		this.price = price;
	}
	
	/**��Ʒ����*/
	public String getType() {
		return type;
	}
	/**��Ʒ����*/
	public void setType(String type) {
		this.type = type;
	}
	
	/**��Ʒ��ʶ(���κ�)*/
	public String getId() {
		return id;
	}
	/**��Ʒ��ʶ*/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the mobiles
	 */
	public String getMobiles() {
		return mobiles;
	}
	/**
	 * @param mobiles the mobiles to set
	 */
	public void setMobiles(String mobiles) {
		this.mobiles = mobiles;
	}
	/**
	 * ��Ʒ���ࣨ���룩
	 */
	public String getComType() {
		return comType;
	}
	/**
	 * @param comType the comType to set
	 */
	public void setComType(String comType) {
		this.comType = comType;
	}
	/**
	 * @return the orderCount
	 */
	public int getOrderCount() {
		return orderCount;
	}
	/**
	 * @param orderCount the orderCount to set
	 */
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
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
	 * @return the inCar
	 */
	public boolean isInCar() {
		return inCar;
	}
	/**
	 * @param inCar the inCar to set
	 */
	public void setInCar(boolean inCar) {
		this.inCar = inCar;
	}
	
}

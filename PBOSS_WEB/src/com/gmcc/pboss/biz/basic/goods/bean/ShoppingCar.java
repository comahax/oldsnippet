package com.gmcc.pboss.biz.basic.goods.bean;

import java.util.LinkedHashMap;
import java.util.Map;

import com.gmcc.pboss.biz.basic.dictItem.service.DictItemService;


/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-9-16
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ��������Ʒ�����������ﳵ
 */
public class ShoppingCar {
	/**���ﳵ�����û�*/
	private String customer;
	/**���ﳵ����ʱ��*/
	private long createTime;

	/**
	 * ��Ʒ�����ѯ
	 */
	private DictItemService dictItemService;
	
	/**��Ʒ�����б�*/
	private Map<String,Goods> goodsMark = new LinkedHashMap<String,Goods>();
	/** ��¼������Ϣ  */
	private Map<String,GoodsStat> goodsStat = new LinkedHashMap<String,GoodsStat>();
	

	/** ��¼������Ʒ  */
	private Map<String,Goods> allGoods = new LinkedHashMap<String,Goods>();
	
	public ShoppingCar(String customer) {
		this.customer = customer;
		this.createTime = System.currentTimeMillis();
	}
	
	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * @return the createTime
	 */
	public long getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}


	/**
	 * @return the dictItemService
	 */
	public DictItemService getDictItemService() {
		return dictItemService;
	}

	/**
	 * @param dictItemService the dictItemService to set
	 */
	public void setDictItemService(DictItemService dictItemService) {
		this.dictItemService = dictItemService;
	}
	
	/**
	 * @return the allGoods
	 */
	public Map<String, Goods> getAllGoods() {
		return allGoods;
	}

	/**
	 * @param allGoods the allGoods to set
	 */
	public void setAllGoods(Map<String, Goods> allGoods) {
		this.allGoods = allGoods;
	}

	/**
	 * ��Ʒ�Ƿ��ڹ��ﳵ��
	 */
	public boolean isInCar(Goods goods){
		String mark = getCarMark(goods);//��ȡ��ʶ
		return goodsMark.containsKey(mark);
	}
	/***
	 * �����Ʒ
	 * @param goods
	 */
	public void addGoods(Goods goods,boolean isQuery,boolean isComrescard){
		//�����µ��б�
		GoodsStat gs;
		String mark = getCarMark(goods);//��ȡ��ʶ
		if (!goodsMark.containsKey(mark)){//���ﳵ���޴����׿� ���� ��ֵ��
			//�����ж�
			goods.setKey(mark);
			this.goodsMark.put(mark, goods);
			//�������
			gs = this.goodsStat.get(goods.getComType());//����Ʒ���ౣ��
			if (gs == null){ 
				gs = new GoodsStat();
				gs.setComType(goods.getComType());
				gs.setType(goods.getType());
			}//if
			gs.addNew(1,goods.getOrderCount());
			//�����µ���Ϣ
			this.goodsStat.put(goods.getComType(), gs);
		}else{//���ﳵ�����д����׿� ���� ��ֵ��
			if (!isQuery || isComrescard ){
				//û�в�ѯ�Ĵ���:��ȡ�Ѿ�ѡ����������  ���� ���׿�ʱ
				Goods saveGoods = this.goodsMark.get(mark); 
				//��ȡ�Ѿ�ѡ����������
				saveGoods.setOrderCount(saveGoods.getOrderCount()+goods.getOrderCount());
				this.goodsMark.put(mark, saveGoods);
				//�������
				gs = this.goodsStat.get(saveGoods.getComType());
				if (gs == null){ 
					gs = new GoodsStat();
					gs.setComType(goods.getComType());
					gs.setType(goods.getType());
				}//if
				gs.addNew(0,goods.getOrderCount());
			}
		}
	}
	
	/**
	 * ɾ����Ʒ
	 * @param good
	 */
	public void deleteGoods(Goods goods){

		String mark = goods.getKey();//��ȡ��KeyΪ�����ļ�¼
		Goods t =this.goodsMark.get(mark); 
		this.goodsMark.remove(mark);
		//������Ϣ��ȡ
		GoodsStat gs = this.goodsStat.get(t.getComType());//����Ʒ���ౣ��
		if (gs != null){
			gs.delOne(t);
			if (gs.getPckgCnt()<=0 && gs.getDtlCnt()<=0){//������ķ���Ϊ��ʱ
				this.goodsStat.remove(t.getComType());
			}//if
		}//if
	}

	public void addAllGoods(Goods goods){
		String mark = getCarMark(goods);//��ȡ��ʶ
		this.allGoods.put(mark, goods);
		
	}
	
	public Goods getGoods(String key){
		return this.allGoods.get(key);
	}
	/**
	 * @return the goodsMark
	 */
	public Map<String, Goods> getGoodsMark() {
		return goodsMark;
	}

	/**
	 * @param goodsMark the goodsMark to set
	 */
	public void setGoodsMark(Map<String, Goods> goodsMark) {
		this.goodsMark = goodsMark;
	}

	/**
	 * @return the goodsStat
	 */
	public Map<String, GoodsStat> getGoodsStat() {
		return goodsStat;
	}

	/**
	 * @param goodsStat the goodsStat to set
	 */
	public void setGoodsStat(Map<String, GoodsStat> goodsStat) {
		this.goodsStat = goodsStat;
	}

	private String getCarMark(Goods goods){

		return goods.getId()+"-"+ goods.getName() +"-"+ goods.getComType();//�����κ�+����+��Ʒ������Ϊ��ʶ
	}
}

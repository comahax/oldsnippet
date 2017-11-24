package com.gmcc.pboss.service.result.goods;

import java.util.List;

import com.gmcc.pboss.service.result.RetResult;

/**
 * �û���Ϣ��
 * 
 * @author hbm
 */
public class BookBasicInfo extends RetResult {
	private List bookInfos; // ������Ϣ:List�����Ԫ����<BookInfo>����
	private List stockInfos; // �����Ϣ:List�����Ԫ����<StockInfo>����
	private List activeInfos;// ������Ϣ:List�����Ԫ����<ActiveInfo>����
	private List stockAlarmInfos;//Ԥ�������Ϣ:List�����Ԫ����<StockalarmInfo>����
	private List comresscardOrderInfos;//��ֵ��������Ϣ
	private String overTime; // ��ʱʱ��
	/**�����鲻ͨ��ʱ��ͳһ������*/
	static final public int NOT_PASS = 3;
	
	private List mondaystockInfos;//���¿�������Ϣ�����MondaystockInfo

	public List getBookInfos() {
		return bookInfos;
	}

	public void setBookInfos(List bookInfos) {
		this.bookInfos = bookInfos;
	}

	public List getStockInfos() {
		return stockInfos;
	}

	public void setStockInfos(List stockInfos) {
		this.stockInfos = stockInfos;
	}

	public List getActiveInfos() {
		return activeInfos;
	}

	public void setActiveInfos(List activeInfos) {
		this.activeInfos = activeInfos;
	}
	
	public String getOverTime() {
		return overTime;
	}

	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}

	public List getStockAlarmInfos() {
		return stockAlarmInfos;
	}

	public void setStockAlarmInfos(List stockAlarmInfos) {
		this.stockAlarmInfos = stockAlarmInfos;
	}

	public List getComresscardOrderInfos() {
		return comresscardOrderInfos;
	}

	public void setComresscardOrderInfos(List comresscardOrderInfos) {
		this.comresscardOrderInfos = comresscardOrderInfos;
	}

	public List getMondaystockInfos() {
		return mondaystockInfos;
	}

	public void setMondaystockInfos(List mondaystockInfos) {
		this.mondaystockInfos = mondaystockInfos;
	}
	
}

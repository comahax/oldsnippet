package com.gmcc.pboss.service.result.goods;

import java.util.List;

import com.gmcc.pboss.service.result.RetResult;

/**
 * 用户信息类
 * 
 * @author hbm
 */
public class BookBasicInfo extends RetResult {
	private List bookInfos; // 订购信息:List里面的元素是<BookInfo>类型
	private List stockInfos; // 库存信息:List里面的元素是<StockInfo>类型
	private List activeInfos;// 激活信息:List里面的元素是<ActiveInfo>类型
	private List stockAlarmInfos;//预警库存信息:List里面的元素是<StockalarmInfo>类型
	private List comresscardOrderInfos;//充值卡订购信息
	private String overTime; // 超时时间
	/**各类检查不通过时的统一返回码*/
	static final public int NOT_PASS = 3;
	
	private List mondaystockInfos;//日月库存组合信息，存放MondaystockInfo

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

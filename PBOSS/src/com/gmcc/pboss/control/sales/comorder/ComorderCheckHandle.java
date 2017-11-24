package com.gmcc.pboss.control.sales.comorder;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gmcc.pboss.business.sales.comorder.OrderEmptyCardVO;

/**
 * 商品订购辅助类
 * @author Linli
 *
 */
public class ComorderCheckHandle {
	
	//获取促销方案品牌集合
	private Set<String> brandSet = new HashSet<String>();

	//套卡是否区分品牌
	private String paramvalue_1;
	
	//获取当月可订购量
	private String paramvalue_4;
	
	//获取日/月订购量上限
	private String paramvalue_5;
	
	//获取基准库存上限
	private String paramvalue_6;
	
	//获取套卡激活率
	private Map<String, Short> activemap;
	private Map<String, Double> activemap2;

	//获取实时订购量
	private Map<String, Long> monorderedmap;
	private Map<String, Long> dayorderedmap;
	private Map<String, Long> nowstockmap;
	
	//获取当月可订购量
	private Map<String,Long> topamtmap;
	
	//获取日/月订购量上限
	private Map<String, Long> monlimitmap;
	private Map<String, Long> daylimitmap;
	
	//获取基准库存上限
	private Map<String, Long> stocklimitmap;
	
	//获取预警阀值信息
	private Map<String, Long> stockalarmmap;
	
	//充值卡日/月订购量上限
	private Map<String, Long> monlimitcardmap;
	private Map<String, Long> daylimitcardmap;
	
	//充值卡实时订购量
	private Map<String, Long> monorderedcardmap;
	private Map<String, Long> dayorderedcardmap;
	
	//空白SIM卡信息
	private List<OrderEmptyCardVO> orderEmptyCardVOList;
	
	public String getParamvalue_5() {
		return paramvalue_5;
	}

	public void setParamvalue_5(String paramvalue_5) {
		this.paramvalue_5 = paramvalue_5;
	}

	public Map<String, Long> getMonlimitmap() {
		return monlimitmap;
	}

	public void setMonlimitmap(Map<String, Long> monlimitmap) {
		this.monlimitmap = monlimitmap;
	}

	public Map<String, Long> getDaylimitmap() {
		return daylimitmap;
	}

	public void setDaylimitmap(Map<String, Long> daylimitmap) {
		this.daylimitmap = daylimitmap;
	}

	public String getParamvalue_4() {
		return paramvalue_4;
	}

	public void setParamvalue_4(String paramvalue_4) {
		this.paramvalue_4 = paramvalue_4;
	}

	public Map<String, Long> getTopamtmap() {
		return topamtmap;
	}

	public void setTopamtmap(Map<String, Long> topamtmap) {
		this.topamtmap = topamtmap;
	}

	public Map<String, Long> getMonorderedmap() {
		return monorderedmap;
	}

	public void setMonorderedmap(Map<String, Long> monorderedmap) {
		this.monorderedmap = monorderedmap;
	}

	public Map<String, Long> getDayorderedmap() {
		return dayorderedmap;
	}

	public void setDayorderedmap(Map<String, Long> dayorderedmap) {
		this.dayorderedmap = dayorderedmap;
	}

	public Map<String, Long> getNowstockmap() {
		return nowstockmap;
	}

	public void setNowstockmap(Map<String, Long> nowstockmap) {
		this.nowstockmap = nowstockmap;
	}

	public String getParamvalue_1() {
		return paramvalue_1;
	}

	public void setParamvalue_1(String paramvalue_1) {
		this.paramvalue_1 = paramvalue_1;
	}

	public Map<String, Short> getActivemap() {
		return activemap;
	}

	public void setActivemap(Map<String, Short> activemap) {
		this.activemap = activemap;
	}

	public Map<String, Double> getActivemap2() {
		return activemap2;
	}

	public void setActivemap2(Map<String, Double> activemap2) {
		this.activemap2 = activemap2;
	}

	public String getParamvalue_6() {
		return paramvalue_6;
	}

	public void setParamvalue_6(String paramvalue_6) {
		this.paramvalue_6 = paramvalue_6;
	}

	public Map<String, Long> getStocklimitmap() {
		return stocklimitmap;
	}

	public void setStocklimitmap(Map<String, Long> stocklimitmap) {
		this.stocklimitmap = stocklimitmap;
	}

	public Set<String> getBrandSet() {
		return brandSet;
	}

	public void setBrandSet(Set<String> brandSet) {
		this.brandSet = brandSet;
	}

	public Map<String, Long> getStockalarmmap() {
		return stockalarmmap;
	}

	public void setStockalarmmap(Map<String, Long> stockalarmmap) {
		this.stockalarmmap = stockalarmmap;
	}

	public Map<String, Long> getMonlimitcardmap() {
		return monlimitcardmap;
	}

	public void setMonlimitcardmap(Map<String, Long> monlimitcardmap) {
		this.monlimitcardmap = monlimitcardmap;
	}

	public Map<String, Long> getDaylimitcardmap() {
		return daylimitcardmap;
	}

	public void setDaylimitcardmap(Map<String, Long> daylimitcardmap) {
		this.daylimitcardmap = daylimitcardmap;
	}

	public Map<String, Long> getMonorderedcardmap() {
		return monorderedcardmap;
	}

	public void setMonorderedcardmap(Map<String, Long> monorderedcardmap) {
		this.monorderedcardmap = monorderedcardmap;
	}

	public Map<String, Long> getDayorderedcardmap() {
		return dayorderedcardmap;
	}

	public void setDayorderedcardmap(Map<String, Long> dayorderedcardmap) {
		this.dayorderedcardmap = dayorderedcardmap;
	}

	public List<OrderEmptyCardVO> getOrderEmptyCardVOList() {
		return orderEmptyCardVOList;
	}

	public void setOrderEmptyCardVOList(List<OrderEmptyCardVO> orderEmptyCardVOList) {
		this.orderEmptyCardVOList = orderEmptyCardVOList;
	}
	
}

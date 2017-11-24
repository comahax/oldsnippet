/**
 * auto-generated code
 * Tue Oct 13 09:23:33 CST 2009
 */
package com.gmcc.pboss.web.sales.comorder;

import java.util.List;

import com.gmcc.pboss.business.sales.activerate.ActiverateVO;
import com.gmcc.pboss.business.sales.comorder.ComorderVO;
import com.gmcc.pboss.business.sales.comorder.OrderCardVO;
import com.gmcc.pboss.business.sales.comorder.OrderEmptyCardVO;
import com.gmcc.pboss.business.sales.comorder.OrderMonthdayStockVO;
import com.gmcc.pboss.business.sales.comorder.OrderMonthdayStockalarm;
import com.gmcc.pboss.business.sales.comorder.OrderMonthdayVO;
import com.gmcc.pboss.business.sales.comorder.OrderStdstockVO;
import com.gmcc.pboss.business.sales.comorder.OrderStockalarmVO;
import com.sunrise.jop.infrastructure.db.BaseVO;

/**
 * <p>Title: BaseorderamtForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ComorderForm extends BaseVO {
	private String wayid;
	private String wayname;
	private String custtype;
	private Short starlevel;
	private String comcategory;
	private String comcategory_text;
	private String unitage;
	private String paytype;
	private String delitype;
	
	private String cityid;
	private String countyid;
	private Double unitprice;
	private String hint;
	
	private Integer allamount;
	private Double allprice;
	
	private String orderid;
	
	private List<ActiverateVO> activeList;
	private List<OrderMonthdayVO> orderMonthdayList;
	private List<OrderStdstockVO> orderStdstockList;
	private List<OrderStockalarmVO> orderStockalarmList;
	private List<OrderCardVO> orderCardList;
	private List<ComorderVO> comorderList;
	private List<OrderEmptyCardVO> orderEmptyCardVOList;
	
	//套卡订购信息（日月预警库存组合模式）
	private List<OrderMonthdayStockalarm> orderMonthdayStockalarmList;
	
	//日月库存组合模式----MONDAYSTOCK
	private List<OrderMonthdayStockVO> orderMonthdayStockList;
	
	private String buttonflag;
	
	private Boolean mixOrderEnable;	
	
	private String planCode;

	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	public String getWayname() {
		return wayname;
	}
	public void setWayname(String wayname) {
		this.wayname = wayname;
	}
	public String getCusttype() {
		return custtype;
	}
	public void setCusttype(String custtype) {
		this.custtype = custtype;
	}
	public Short getStarlevel() {
		return starlevel;
	}
	public void setStarlevel(Short starlevel) {
		this.starlevel = starlevel;
	}
	public String getComcategory() {
		return comcategory;
	}
	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
	}
	public String getUnitage() {
		return unitage;
	}
	public void setUnitage(String unitage) {
		this.unitage = unitage;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getCountyid() {
		return countyid;
	}
	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}
	public Double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}
	public List<ActiverateVO> getActiveList() {
		return activeList;
	}
	public void setActiveList(List<ActiverateVO> activeList) {
		this.activeList = activeList;
	}
	public List<OrderMonthdayVO> getOrderMonthdayList() {
		return orderMonthdayList;
	}
	public void setOrderMonthdayList(List<OrderMonthdayVO> orderMonthdayList) {
		this.orderMonthdayList = orderMonthdayList;
	}
	public List<OrderStdstockVO> getOrderStdstockList() {
		return orderStdstockList;
	}
	public void setOrderStdstockList(List<OrderStdstockVO> orderStdstockList) {
		this.orderStdstockList = orderStdstockList;
	}
	public List<ComorderVO> getComorderList() {
		return comorderList;
	}
	public void setComorderList(List<ComorderVO> comorderList) {
		this.comorderList = comorderList;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public String getDelitype() {
		return delitype;
	}
	public void setDelitype(String delitype) {
		this.delitype = delitype;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	public Integer getAllamount() {
		return allamount;
	}
	public void setAllamount(Integer allamount) {
		this.allamount = allamount;
	}
	public Double getAllprice() {
		return allprice;
	}
	public void setAllprice(Double allprice) {
		this.allprice = allprice;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getButtonflag() {
		return buttonflag;
	}
	public void setButtonflag(String buttonflag) {
		this.buttonflag = buttonflag;
	}
	public List<OrderStockalarmVO> getOrderStockalarmList() {
		return orderStockalarmList;
	}
	public void setOrderStockalarmList(List<OrderStockalarmVO> orderStockalarmList) {
		this.orderStockalarmList = orderStockalarmList;
	}
	public List<OrderCardVO> getOrderCardList() {
		return orderCardList;
	}
	public void setOrderCardList(List<OrderCardVO> orderCardList) {
		this.orderCardList = orderCardList;
	}
	public Boolean getMixOrderEnable() {
		return mixOrderEnable;
	}
	public void setMixOrderEnable(Boolean mixOrderEnable) {
		this.mixOrderEnable = mixOrderEnable;
	}
	public List<OrderMonthdayStockVO> getOrderMonthdayStockList() {
		return orderMonthdayStockList;
	}
	public void setOrderMonthdayStockList(
			List<OrderMonthdayStockVO> orderMonthdayStockList) {
		this.orderMonthdayStockList = orderMonthdayStockList;
	}
	public String getPlanCode() {
		return planCode;
	}
	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}
	public List<OrderEmptyCardVO> getOrderEmptyCardVOList() {
		return orderEmptyCardVOList;
	}
	public void setOrderEmptyCardVOList(List<OrderEmptyCardVO> orderEmptyCardVOList) {
		this.orderEmptyCardVOList = orderEmptyCardVOList;
	}
	public List<OrderMonthdayStockalarm> getOrderMonthdayStockalarmList() {
		return orderMonthdayStockalarmList;
	}
	public void setOrderMonthdayStockalarmList(
			List<OrderMonthdayStockalarm> orderMonthdayStockalarmList) {
		this.orderMonthdayStockalarmList = orderMonthdayStockalarmList;
	}
	public String getComcategory_text() {
		return comcategory_text;
	}
	public void setComcategory_text(String comcategory_text) {
		this.comcategory_text = comcategory_text;
	}
	
	
	
}

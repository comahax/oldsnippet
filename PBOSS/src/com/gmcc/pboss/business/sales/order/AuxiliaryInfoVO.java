package com.gmcc.pboss.business.sales.order;

import java.util.ArrayList;
import java.util.List;

public class AuxiliaryInfoVO {
	private String brand;
	private Long countyStock;
	private Long wayStock;
	private List<AuxilaryActalarmVO> auxilaryActalarmList=new ArrayList<AuxilaryActalarmVO>();
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Long getCountyStock() {
		return countyStock;
	}
	public void setCountyStock(Long countyStock) {
		this.countyStock = countyStock;
	}
	public Long getWayStock() {
		return wayStock;
	}
	public void setWayStock(Long wayStock) {
		this.wayStock = wayStock;
	}
	public List<AuxilaryActalarmVO> getAuxilaryActalarmList() {
		return auxilaryActalarmList;
	}
	public void setAuxilaryActalarmList(
			List<AuxilaryActalarmVO> auxilaryActalarmList) {
		this.auxilaryActalarmList = auxilaryActalarmList;
	}
	
}

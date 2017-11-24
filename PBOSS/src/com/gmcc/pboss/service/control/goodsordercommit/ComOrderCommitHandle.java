package com.gmcc.pboss.service.control.goodsordercommit;

import java.util.List;

import com.gmcc.pboss.business.sales.comorder.ComorderVO;

/**
 * 当isQueryDetail为true时的辅助类
 * @author Administrator
 *
 */
public class ComOrderCommitHandle {

	//当isQueryDetail为true时,订购列表重组
	private List<ComorderVO> comorderList;
	//当isQueryDetail为true时,用来记录resid的List,用于搭售
	private List<String> residList;
	//当isQueryDetail为true时,用来记录的资源库区
	private String storea;
	
	public List<ComorderVO> getComorderList() {
		return comorderList;
	}
	public void setComorderList(List<ComorderVO> comorderList) {
		this.comorderList = comorderList;
	}
	public List<String> getResidList() {
		return residList;
	}
	public void setResidList(List<String> residList) {
		this.residList = residList;
	}
	public String getStorea() {
		return storea;
	}
	public void setStorea(String storea) {
		this.storea = storea;
	}
}

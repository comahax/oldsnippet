package com.gmcc.pboss.service.control.goodsordercommit;

import java.util.List;

import com.gmcc.pboss.business.sales.comorder.ComorderVO;

/**
 * ��isQueryDetailΪtrueʱ�ĸ�����
 * @author Administrator
 *
 */
public class ComOrderCommitHandle {

	//��isQueryDetailΪtrueʱ,�����б�����
	private List<ComorderVO> comorderList;
	//��isQueryDetailΪtrueʱ,������¼resid��List,���ڴ���
	private List<String> residList;
	//��isQueryDetailΪtrueʱ,������¼����Դ����
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

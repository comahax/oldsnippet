package com.gmcc.pboss.web.common.productcategoryselect;

import com.sunrise.jop.infrastructure.db.BaseVO; 
 
/**
 * <p>Title: AdvgroupAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lyl
 * @version 1.0
 */
public class ProductCategorySelectForm extends BaseVO{
	
	//��������ѡ�ַ��������ŷָ�
	private String selectedStr;
	 
	//��ʾ���� 
//	private String dictid;
//	private String dictName;
	
	public String getSelectedStr() {
		return selectedStr;
	}
	public void setSelectedStr(String selectedStr) {
		this.selectedStr = selectedStr;
	}
//	public String getDictid() {
//		return dictid;
//	}
//	public void setDictid(String dictid) {
//		this.dictid = dictid;
//	}
//	public String getDictName() {
//		return dictName;
//	}
//	public void setDictName(String dictName) {
//		this.dictName = dictName;
//	}
}
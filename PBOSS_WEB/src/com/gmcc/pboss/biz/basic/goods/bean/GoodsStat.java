package com.gmcc.pboss.biz.basic.goods.bean;
/**
 * 从兴公司营账部
 * @author yuwenjun
 * @date 2009-10-3
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：商品订购——商品统计信息
 */
public class GoodsStat {
	/**
	 * 商品类型
	 */
	private String type;

	/**
	 * 商品类型编码
	 */
	private String comType;
	/**
	 * 包数 - 对于添加那种没有
	 */
	private int pckgCnt = 0;
	/**
	 * 套数
	 */
	private int dtlCnt = 0;

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the comType
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
	 * @return the pckgCnt
	 */
	public int getPckgCnt() {
		return pckgCnt;
	}

	/**
	 * @param pckgCnt the pckgCnt to set
	 */
	public void setPckgCnt(int pckgCnt) {
		this.pckgCnt = pckgCnt;
	}

	/**
	 * @return the dtlCnt
	 */
	public int getDtlCnt() {
		return dtlCnt;
	}

	/**
	 * @param dtlCnt the dtlCnt to set
	 */
	public void setDtlCnt(int dtlCnt) {
		this.dtlCnt = dtlCnt;
	}
	public void addNew(int packageCnt,int dtl){
		this.pckgCnt += packageCnt;
		this.dtlCnt += dtl;
	}
	public void delOne(Goods goods){
		this.pckgCnt-- ;
		this.dtlCnt -= goods.getOrderCount();
	}
}

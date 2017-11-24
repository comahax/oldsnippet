package com.gmcc.pboss.biz.basic.goods.bean;

import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.service.result.goods.GoodsInfo;
/**
 * 提取商品类型信息
 * @author yuwenjun
 *
 */
public class ComTypeInfo extends GoodsInfo {
	/**
	 * 类型类别
	 */
	private String restype;
	/**
	 * 是否充值卡
	 * @param giObj
	 */
	private boolean comrescard = false;

	public ComTypeInfo(GoodsInfo giObj){
		this.setPrice(giObj.getPrice());
		this.setRadix(giObj.getRadix());
	}
	public ComTypeInfo(GoodsInfo giObj,String type){
		this.setPrice(giObj.getPrice());
		this.setRadix(giObj.getRadix());
		this.setRestype(type);
	}
	public ComTypeInfo(){
		super();
		this.setRestype("");
	}
	/**
	 * @return the restype
	 */
	public String getRestype() {
		return restype;
	}
	/**
	 * @param restype the restype to set
	 */
	public void setRestype(String restype) {
		this.restype = restype;
		comrescard = ConstantsType.COMRESCARD.equals(restype);
	}
	/**
	 * @return the comrescard
	 */
	public boolean isComrescard() {
		return comrescard;
	}
	/**
	 * @param comrescard the comrescard to set
	 */
	public void setComrescard(boolean comrescard) {
		this.comrescard = comrescard;
	}
	
}

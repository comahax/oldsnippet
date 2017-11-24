package com.gmcc.pboss.business.resource.compack;

import java.text.DecimalFormat;

public class NumberTypeInfo {

	private static final DecimalFormat doubleFormat = new DecimalFormat("###.00");
	private String type;	//号码类型
	private Long quantity = 0L;	//数量
	private Double scale = 0.0;	//所占比例	格式###.00
	private Double adjustScale = 0.0;//调整后比例	格式###.00
	
	private long remain;//余数
	
	public long getRemain() {
		return remain;
	}
	public void setRemain(long remain) {
		this.remain = remain;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	public Double getScale() {
		if( null != this.scale ){
			scale = new Double(doubleFormat.format(this.scale));
		}
		return scale;
	}
	public void setScale(Double scale) {
		if( null != scale )
			scale = new Double(doubleFormat.format(scale));//保证保存的什最多只有两位小数
		this.scale = scale;
	}
	public Double getAdjustScale() {
		if( null != this.adjustScale ){
			adjustScale = new Double(doubleFormat.format(this.adjustScale));
		}
		return adjustScale;
	}
	public void setAdjustScale(Double adjustScale) {
		if( null != adjustScale )
			adjustScale = new Double(doubleFormat.format(adjustScale));//保证保存的什最多只有两位小数
		this.adjustScale = adjustScale;
	}
	
	/*
	 * 检查調整後的比例是否整數
	 */
	public boolean isIntegerAdjuestScale(){
		return doubleFormat.format(this.adjustScale).endsWith(".00");
	}
	
}

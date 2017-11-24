package com.gmcc.pboss.business.resource.compack;

import java.text.DecimalFormat;

public class NumberTypeInfo {

	private static final DecimalFormat doubleFormat = new DecimalFormat("###.00");
	private String type;	//��������
	private Long quantity = 0L;	//����
	private Double scale = 0.0;	//��ռ����	��ʽ###.00
	private Double adjustScale = 0.0;//���������	��ʽ###.00
	
	private long remain;//����
	
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
			scale = new Double(doubleFormat.format(scale));//��֤�����ʲ���ֻ����λС��
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
			adjustScale = new Double(doubleFormat.format(adjustScale));//��֤�����ʲ���ֻ����λС��
		this.adjustScale = adjustScale;
	}
	
	/*
	 * ����{����ı����Ƿ�����
	 */
	public boolean isIntegerAdjuestScale(){
		return doubleFormat.format(this.adjustScale).endsWith(".00");
	}
	
}

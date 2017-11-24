package com.gmcc.pboss.biz.info.regactInfo.support;

import org.apache.commons.lang.builder.ToStringBuilder;

public class RegactStatistics {

	// ʵ�ʼ�����
	private int actualActived;
	// ��Ч������
	private int validActived;
	// ���ϼƳ꼤����
	private int rewardActived;

	public RegactStatistics() {
		super();
	}

	/**
	 * 
	 * @param actualActived ʵ�ʼ�����
	 * @param validActived ��Ч������
	 * @param rewardActived ���ϼƳ꼤����
	 */
	public RegactStatistics(int actualActived, int validActived, int rewardActived) {
		super();
		this.actualActived = actualActived;
		this.validActived = validActived;
		this.rewardActived = rewardActived;
	}

	public int getActualActived() {
		return actualActived;
	}

	public void setActualActived(int actualActived) {
		this.actualActived = actualActived;
	}

	public int getValidActived() {
		return validActived;
	}

	public void setValidActived(int validActived) {
		this.validActived = validActived;
	}

	public int getRewardActived() {
		return rewardActived;
	}

	public void setRewardActived(int rewardActived) {
		this.rewardActived = rewardActived;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	
}

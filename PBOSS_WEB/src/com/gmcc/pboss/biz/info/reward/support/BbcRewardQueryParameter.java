package com.gmcc.pboss.biz.info.reward.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class BbcRewardQueryParameter extends QueryParameter {

	// ������ʶ
	private String wayid;
	// ҵ�����
	private String opnid;
	// �������--��ϸ��ѯ��һ��ѡ��������
	private String rewardtype;
	// �����·� /�����·�yyyyMM
	private String month;
	
	// �Ƿ����
	private boolean group = false;
	
	//��վ������ࣺB2M or UNPB(��������)
	String rewardKind;
	public String getRewardKind() {
		return rewardKind;
	}
	public void setRewardKind(String rewardKind) {
		this.rewardKind = rewardKind;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(String rewardtype) {
		this.rewardtype = rewardtype;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
	public boolean isGroup() {
		return group;
	}
	public void setGroup(boolean group) {
		this.group = group;
	}
}

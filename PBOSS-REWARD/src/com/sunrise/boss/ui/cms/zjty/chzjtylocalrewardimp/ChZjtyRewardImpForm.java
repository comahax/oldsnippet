package com.sunrise.boss.ui.cms.zjty.chzjtylocalrewardimp;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class ChZjtyRewardImpForm extends UploadFileForm {
	private String rewardreporttime;

	private String rewardzjtyreport;

	public ChZjtyRewardImpForm() {
		super.setCheckFormat(new ChZjtyRewardImpCheck());
	}

	public String getRewardreporttime() {
		return rewardreporttime;
	}

	public void setRewardreporttime(String rewardreporttime) {
		this.rewardreporttime = rewardreporttime;
	}

	public String getRewardzjtyreport() {
		return rewardzjtyreport;
	}

	public void setRewardzjtyreport(String rewardzjtyreport) {
		this.rewardzjtyreport = rewardzjtyreport;
	}

}

package com.sunrise.boss.ui.cms.rewardadjust;


import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class RewardadjustbatchForm extends UploadFileForm {

	public RewardadjustbatchForm() throws Exception {
		// TODO Auto-generated constructor stub
		super.setCheckFormat(new RewardadjustbatchCheck());
	}

}

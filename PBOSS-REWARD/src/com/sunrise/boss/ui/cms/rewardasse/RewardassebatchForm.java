package com.sunrise.boss.ui.cms.rewardasse;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class RewardassebatchForm extends UploadFileForm {

	public RewardassebatchForm() throws Exception {
		// TODO Auto-generated constructor stub
		super.setCheckFormat(new RewardassebatchCheck());
	}

}

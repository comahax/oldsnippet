package com.sunrise.boss.ui.cms.reward.chadtbaseprodid;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class ChAdtBaseprodidbatchForm extends UploadFileForm {

	public ChAdtBaseprodidbatchForm() { 
		super.setCheckFormat(new ChAdtBaseprodidCheck());
		 
	}

}

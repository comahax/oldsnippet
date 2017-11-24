package com.sunrise.boss.ui.cms.bbc.subtractb;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class SubtractbbatchForm extends UploadFileForm {
	
	public SubtractbbatchForm(){
		super.setCheckFormat(new SubtractbCheck());
	}
	
}

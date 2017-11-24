package com.sunrise.boss.ui.cms.bbc.subtracti;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class SubtractibatchForm extends UploadFileForm {
	
	public SubtractibatchForm(){
		super.setCheckFormat(new SubtractiCheck());
	}
	
}

package com.sunrise.boss.ui.cms.bbc.subtract;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class SubtractbatchForm extends UploadFileForm {
	
	public SubtractbatchForm(){
		super.setCheckFormat(new SubtractCheck());
	}
	
}

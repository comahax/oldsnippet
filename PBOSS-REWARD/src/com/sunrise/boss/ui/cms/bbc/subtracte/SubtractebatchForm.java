package com.sunrise.boss.ui.cms.bbc.subtracte;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class SubtractebatchForm extends UploadFileForm {
	
	public SubtractebatchForm(){
		super.setCheckFormat(new SubtracteCheck());
	}
	
}

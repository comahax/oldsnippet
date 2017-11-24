package com.sunrise.boss.ui.cms.bbc.service;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class ServicebatchForm extends UploadFileForm {
	
	public ServicebatchForm(){
		super.setCheckFormat(new ServiceCheck());
	}
	
}

package com.sunrise.boss.ui.cms.bbc.blacklist;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BlacklistbatchForm extends UploadFileForm {

	public BlacklistbatchForm(){
		super.setCheckFormat(new BlacklistCheck());
	}
	
}

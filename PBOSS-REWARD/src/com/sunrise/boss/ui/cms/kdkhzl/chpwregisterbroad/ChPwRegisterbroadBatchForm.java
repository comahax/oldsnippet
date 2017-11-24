package com.sunrise.boss.ui.cms.kdkhzl.chpwregisterbroad;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class ChPwRegisterbroadBatchForm extends UploadFileForm {
	
	public ChPwRegisterbroadBatchForm() throws Exception {
		// TODO Auto-generated constructor stub
		super.setCheckFormat(new ChPwRegisterbroadBatchCheck());
	}
}

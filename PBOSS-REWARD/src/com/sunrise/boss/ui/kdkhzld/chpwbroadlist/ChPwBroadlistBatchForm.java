package com.sunrise.boss.ui.kdkhzld.chpwbroadlist;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class ChPwBroadlistBatchForm extends UploadFileForm {
	
	public ChPwBroadlistBatchForm() throws Exception {
		// TODO Auto-generated constructor stub
		super.setCheckFormat(new ChPwBroadlistBatchCheck());
	}
}

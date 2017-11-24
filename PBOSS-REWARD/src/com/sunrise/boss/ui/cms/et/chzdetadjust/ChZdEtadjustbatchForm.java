package com.sunrise.boss.ui.cms.et.chzdetadjust;



import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class ChZdEtadjustbatchForm extends UploadFileForm {

	public ChZdEtadjustbatchForm() {
		// TODO Auto-generated constructor stub
		super.setCheckFormat(new ChZdEtadjustCheck());
	}

}

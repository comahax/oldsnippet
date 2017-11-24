package com.sunrise.boss.ui.cms.zjty.zjtyassess;



import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class ZjtyAssessbatchForm extends UploadFileForm {

	public ZjtyAssessbatchForm() {
		// TODO Auto-generated constructor stub
		super.setCheckFormat(new ZjtyAssessCheck());
	}

}

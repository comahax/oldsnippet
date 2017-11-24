package com.sunrise.boss.ui.cms.reward.assess;



import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class AssessbatchForm extends UploadFileForm {

	public AssessbatchForm() {
		// TODO Auto-generated constructor stub
		super.setCheckFormat(new AssessCheck());
	}

}

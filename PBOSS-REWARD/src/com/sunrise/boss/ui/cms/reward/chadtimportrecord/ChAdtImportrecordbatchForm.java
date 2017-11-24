package com.sunrise.boss.ui.cms.reward.chadtimportrecord;



import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class ChAdtImportrecordbatchForm extends UploadFileForm {

	public ChAdtImportrecordbatchForm() {
		// TODO Auto-generated constructor stub
		super.setCheckFormat(new ChAdtImportrecordCheck());
	}

}

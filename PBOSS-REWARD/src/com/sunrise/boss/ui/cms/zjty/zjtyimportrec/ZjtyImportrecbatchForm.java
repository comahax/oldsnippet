package com.sunrise.boss.ui.cms.zjty.zjtyimportrec;



import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class ZjtyImportrecbatchForm extends UploadFileForm {

	public ZjtyImportrecbatchForm() {
		// TODO Auto-generated constructor stub
		super.setCheckFormat(new ZjtyImportrecCheck());
	}

}

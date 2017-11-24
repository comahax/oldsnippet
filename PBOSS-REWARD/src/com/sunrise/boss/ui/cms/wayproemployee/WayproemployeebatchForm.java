package com.sunrise.boss.ui.cms.wayproemployee;



import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class WayproemployeebatchForm extends UploadFileForm {

	public WayproemployeebatchForm() {
		// TODO Auto-generated constructor stub
		super.setCheckFormat(new WayproemployeebatchCheck());
	}

}

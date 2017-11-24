package com.sunrise.boss.ui.cms.waystrarewardstd;



import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class WaystrarewardstdbatchForm extends UploadFileForm {

	public WaystrarewardstdbatchForm() {
		// TODO Auto-generated constructor stub
		super.setCheckFormat(new WaystrarewardstdCheck());
	}

}

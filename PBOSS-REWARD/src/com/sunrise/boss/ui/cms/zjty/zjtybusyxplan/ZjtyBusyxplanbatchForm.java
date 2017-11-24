package com.sunrise.boss.ui.cms.zjty.zjtybusyxplan;



import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class ZjtyBusyxplanbatchForm extends UploadFileForm {

	public ZjtyBusyxplanbatchForm() {
		// TODO Auto-generated constructor stub
		super.setCheckFormat(new ZjtyBusyxplanCheck());
	}

}

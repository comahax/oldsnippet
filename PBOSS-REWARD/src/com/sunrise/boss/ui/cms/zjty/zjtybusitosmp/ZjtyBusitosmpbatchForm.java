package com.sunrise.boss.ui.cms.zjty.zjtybusitosmp;



import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class ZjtyBusitosmpbatchForm extends UploadFileForm {

	public ZjtyBusitosmpbatchForm() {
		// TODO Auto-generated constructor stub
		super.setCheckFormat(new ZjtyBusitosmpCheck());
	}

}

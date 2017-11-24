package com.sunrise.boss.ui.cms.cityrecord;



import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class CityrecordbatchForm extends UploadFileForm {

	public CityrecordbatchForm() {
		// TODO Auto-generated constructor stub
		super.setCheckFormat(new CityrecordCheck());
	}

}

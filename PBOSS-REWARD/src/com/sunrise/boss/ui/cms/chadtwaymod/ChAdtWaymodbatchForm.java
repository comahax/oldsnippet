package com.sunrise.boss.ui.cms.chadtwaymod;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class ChAdtWaymodbatchForm extends UploadFileForm {

	public ChAdtWaymodbatchForm() {
		super.setCheckFormat(new ChAdtWaymodCheck());
	}

}

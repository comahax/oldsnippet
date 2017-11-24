package com.sunrise.boss.ui.cms.wayhznx;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class WayhznxBatchForm extends UploadFileForm{
	
	public WayhznxBatchForm() {
		super.setCheckFormat(new WayhznxBatchCheck());
	}
	
}

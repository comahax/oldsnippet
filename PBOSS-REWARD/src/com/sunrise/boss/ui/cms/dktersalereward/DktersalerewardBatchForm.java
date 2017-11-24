package com.sunrise.boss.ui.cms.dktersalereward;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class DktersalerewardBatchForm extends UploadFileForm {

	public DktersalerewardBatchForm() {
		super.setCheckFormat(new DktersalerewardCheck());
	}

}

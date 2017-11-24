package com.sunrise.boss.ui.cms.reward.chadtwayspecialreward;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class ChAdtWayspecialrewardBatchForm extends UploadFileForm {

	public ChAdtWayspecialrewardBatchForm() {
		super.setCheckFormat(new ChAdtWayspecialrewardCheck());
	}

}

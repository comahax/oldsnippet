package com.sunrise.boss.ui.cms.reward.busyxplan;
import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchBusyxplanForm extends UploadFileForm {

	public BatchBusyxplanForm() throws Exception {
		// TODO Auto-generated constructor stub
		super.setCheckFormat(new BatchBusyxplanCheck());
	}

}

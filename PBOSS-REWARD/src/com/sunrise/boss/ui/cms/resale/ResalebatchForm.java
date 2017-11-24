package com.sunrise.boss.ui.cms.resale;
import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;
public class ResalebatchForm extends UploadFileForm{
	public ResalebatchForm() {
		super.setCheckFormat(new BatchResaleCheck());
	}

}

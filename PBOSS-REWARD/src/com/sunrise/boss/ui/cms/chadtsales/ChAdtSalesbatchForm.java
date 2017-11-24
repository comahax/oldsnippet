package com.sunrise.boss.ui.cms.chadtsales;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class ChAdtSalesbatchForm extends UploadFileForm {

	public ChAdtSalesbatchForm() {
		super.setCheckFormat(new ChAdtSalesCheck());
	}

}

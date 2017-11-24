package com.sunrise.boss.ui.cms.cardsalebusi;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchCardsalebusiForm extends UploadFileForm {
	public BatchCardsalebusiForm() {
		setCheckFormat(new BatchCardsalebusiCheck());
	}
}

package com.sunrise.boss.ui.cms.reward.busitocom;


import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BusitocomBatchForm extends UploadFileForm {

	private String oprtype;

	public BusitocomBatchForm() {
		this.setCheckFormat(new AddBusitocomBatchCheck());
	}

	public String getOprtype() {
		return oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
		if (oprtype.equals("0")) {
			this.setCheckFormat(new AddBusitocomBatchCheck());
		} else if (oprtype.equals("1")) {
			this.setCheckFormat(new DelBusitocomBatchCheck());
		}
	}

}

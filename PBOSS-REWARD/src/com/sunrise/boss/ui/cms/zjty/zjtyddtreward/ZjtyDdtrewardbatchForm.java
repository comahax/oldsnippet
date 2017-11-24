package com.sunrise.boss.ui.cms.zjty.zjtyddtreward;

import com.sunrise.boss.ui.cms.zjty.zjtyddtreward.upload.AddZjtyDdtrewardCheck;


import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class ZjtyDdtrewardbatchForm extends UploadFileForm {

	private String oprtype;

	public ZjtyDdtrewardbatchForm() {
		this.setCheckFormat(new AddZjtyDdtrewardCheck());
	}

	public String getOprtype() {
		return oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
		if (oprtype.equals("0")) {
			this.setCheckFormat(new AddZjtyDdtrewardCheck());
		}
	}
}
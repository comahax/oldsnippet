package com.sunrise.boss.ui.cms.zjty.zjtyrewarddetail;

import com.sunrise.boss.ui.cms.zjty.zjtyrewarddetail.upload.AddZjtyRewarddetailCheck;


import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class ZjtyRewarddetailbatchForm extends UploadFileForm {

	private String oprtype;

	public ZjtyRewarddetailbatchForm() {
		this.setCheckFormat(new AddZjtyRewarddetailCheck());
	}

	public String getOprtype() {
		return oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
		if (oprtype.equals("0")) {
			this.setCheckFormat(new AddZjtyRewarddetailCheck());
		}
	}
}
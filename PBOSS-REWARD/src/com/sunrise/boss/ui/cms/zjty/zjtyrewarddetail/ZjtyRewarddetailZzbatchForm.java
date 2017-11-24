package com.sunrise.boss.ui.cms.zjty.zjtyrewarddetail;

import com.sunrise.boss.ui.cms.zjty.zjtyrewarddetail.upload.AddZjtyRewarddetailZzCheck;


import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class ZjtyRewarddetailZzbatchForm extends UploadFileForm {

	private String oprtype;

	public ZjtyRewarddetailZzbatchForm() {
		this.setCheckFormat(new AddZjtyRewarddetailZzCheck());
	}

	public String getOprtype() {
		return oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
		if (oprtype.equals("0")) {
			this.setCheckFormat(new AddZjtyRewarddetailZzCheck());
		}
	}
}
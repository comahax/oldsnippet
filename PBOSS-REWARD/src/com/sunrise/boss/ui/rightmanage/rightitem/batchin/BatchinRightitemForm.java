package com.sunrise.boss.ui.rightmanage.rightitem.batchin;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchinRightitemForm extends UploadFileForm {
	private String createdate;

	private String statusdate;

	private Byte status;

	private String rightgroup;

	private Byte ispublic;

	private String notes;

	public String getRightgroup() {
		return rightgroup;
	}

	public void setRightgroup(String rightgroup) {
		this.rightgroup = rightgroup;
	}

	public BatchinRightitemForm() {
		this.setCheckFormat(new BatchinRightitemCheck());
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getStatusdate() {
		return statusdate;
	}

	public void setStatusdate(String statusdate) {
		this.statusdate = statusdate;
	}

	public Byte getIspublic() {
		return ispublic;
	}

	public void setIspublic(Byte ispublic) {
		this.ispublic = ispublic;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}

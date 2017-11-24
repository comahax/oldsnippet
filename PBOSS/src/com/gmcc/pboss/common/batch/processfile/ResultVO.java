package com.gmcc.pboss.common.batch.processfile;

import java.io.*;

public class ResultVO implements Serializable {
	private String info;

	private boolean ok;

	public ResultVO() {
		super();
	}

	public void setInfo(String info) {

		this.info = info;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public String getInfo() {
		return info;
	}

	public boolean isOk() {
		return ok;
	}

}

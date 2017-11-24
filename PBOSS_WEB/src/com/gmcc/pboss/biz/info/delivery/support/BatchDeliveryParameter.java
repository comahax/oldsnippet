package com.gmcc.pboss.biz.info.delivery.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class BatchDeliveryParameter extends QueryParameter {
	private String content;	
	private String type;//业务类型：1-批量完成配送，2-批量补发签收短信

	public BatchDeliveryParameter() {
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}

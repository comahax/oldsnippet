package com.gmcc.pboss.biz.info.delivery.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class BatchDeliveryParameter extends QueryParameter {
	private String content;	
	private String type;//ҵ�����ͣ�1-����������ͣ�2-��������ǩ�ն���

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

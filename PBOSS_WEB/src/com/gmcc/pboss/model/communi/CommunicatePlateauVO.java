package com.gmcc.pboss.model.communi;

import java.io.Serializable;
import java.util.List;
/**
 * 沟通平台VO,用于装载公告信息,公告附件等不需要分页显示的内容
 * @author zhangsiwei
 *
 */
public class CommunicatePlateauVO implements Serializable {

	private ChPwAdvinfo advinfo;
	private List<ChPwAdvaffix> advaffixs;
	
	public ChPwAdvinfo getAdvinfo() {
		return advinfo;
	}
	public void setAdvinfo(ChPwAdvinfo advinfo) {
		this.advinfo = advinfo;
	}
	public List<ChPwAdvaffix> getAdvaffixs() {
		return advaffixs;
	}
	public void setAdvaffixs(List<ChPwAdvaffix> advaffixs) {
		this.advaffixs = advaffixs;
	}
	
}

package com.gmcc.pboss.model.communi;

import java.io.Serializable;
import java.util.List;
/**
 * ��ͨƽ̨VO,����װ�ع�����Ϣ,���渽���Ȳ���Ҫ��ҳ��ʾ������
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

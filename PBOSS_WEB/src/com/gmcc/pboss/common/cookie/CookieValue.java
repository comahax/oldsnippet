package com.gmcc.pboss.common.cookie;
/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-11-4
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������Cookie��ֵ
 */
public class CookieValue {
	/**�û���*/
	private String user;
	
	/**ֵ*/
	private String value;
	
	/**����ʱ�䣺��λs*/
	private int saveTime;
	
	/**����·��*/
	private String savePath;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getSaveTime() {
		return saveTime;
	}

	public void setSaveTime(int saveTime) {
		this.saveTime = saveTime;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	
	
}

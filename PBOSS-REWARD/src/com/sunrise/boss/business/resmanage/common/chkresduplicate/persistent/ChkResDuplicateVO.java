package com.sunrise.boss.business.resmanage.common.chkresduplicate.persistent;

/**
 * 2.2.3.17	��Դ���������ظ��Լ��ģ��
 * ��VOΪ���⹹�죬��ʵ�����ݿ���Ӧ
 * @author David
 */
public class ChkResDuplicateVO {

	private Class resreqvo;

	private String resno;

	private Long comid;

	private Long resoprtype;

	private String inwayid;

	private String outwayid;

	public Long getComid() {
		return comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public String getInwayid() {
		return inwayid;
	}

	public void setInwayid(String inwayid) {
		this.inwayid = inwayid;
	}

	public String getOutwayid() {
		return outwayid;
	}

	public void setOutwayid(String outwayid) {
		this.outwayid = outwayid;
	}

	public String getResno() {
		return resno;
	}

	public void setResno(String resno) {
		this.resno = resno;
	}

	public Long getResoprtype() {
		return resoprtype;
	}

	public void setResoprtype(Long resoprtype) {
		this.resoprtype = resoprtype;
	}

	public Class getResreqvo() {
		return resreqvo;
	}

	public void setResreqvo(Class resreqvo) {
		this.resreqvo = resreqvo;
	}

}

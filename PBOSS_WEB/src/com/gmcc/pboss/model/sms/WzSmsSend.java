package com.gmcc.pboss.model.sms;

/**
 * WzSmsSend entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class WzSmsSend extends SMS implements java.io.Serializable {

	private static final long serialVersionUID = -6591999891588007941L;
	
	/**����*/
	private Long id;
	/**����״̬*/
	private Long state;
	/**�ʷ�����*/
	private Long feetype;
	/**���ż���*/
	private Long level;
	
	// Constructors

	/** default constructor */
	public WzSmsSend() {
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**����״̬*/
	public Long getState() {
		return this.state;
	}
	/**����״̬*/
	public void setState(Long state) {
		this.state = state;
	}
	/**�ʷ�����*/
	public Long getFeetype() {
		return this.feetype;
	}
	/**�ʷ�����*/
	public void setFeetype(Long feetype) {
		this.feetype = feetype;
	}
	/**���ż���*/
	public Long getLevel() {
		return this.level;
	}
	/**���ż���*/
	public void setLevel(Long level) {
		this.level = level;
	}
	
}
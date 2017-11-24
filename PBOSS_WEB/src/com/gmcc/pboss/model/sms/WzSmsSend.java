package com.gmcc.pboss.model.sms;

/**
 * WzSmsSend entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class WzSmsSend extends SMS implements java.io.Serializable {

	private static final long serialVersionUID = -6591999891588007941L;
	
	/**主键*/
	private Long id;
	/**短信状态*/
	private Long state;
	/**资费类型*/
	private Long feetype;
	/**短信级别*/
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
	/**短信状态*/
	public Long getState() {
		return this.state;
	}
	/**短信状态*/
	public void setState(Long state) {
		this.state = state;
	}
	/**资费类型*/
	public Long getFeetype() {
		return this.feetype;
	}
	/**资费类型*/
	public void setFeetype(Long feetype) {
		this.feetype = feetype;
	}
	/**短信级别*/
	public Long getLevel() {
		return this.level;
	}
	/**短信级别*/
	public void setLevel(Long level) {
		this.level = level;
	}
	
}
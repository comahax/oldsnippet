package com.sunrise.boss.business.resmanage.common.hlrinfo.persistent;

/**
 * 
 * 
 * Title: HlrinfoVO<br>
 * Description: <br>
 * Company: sunrise,Guangzhou</br>
 * 
 * @author Cao Wei
 * @version 1.0
 */
public class HlrinfoVO implements java.io.Serializable {

	private static final long serialVersionUID = 5065028686721130455L;

	private Long id;

	private String name;

	private String ip;

	private String port;

	private Long type;

	private String region;

	private String address;

	// Constructors

	/** default constructor */
	public HlrinfoVO() {
	}

	/** minimal constructor */
	public HlrinfoVO(Long id) {
		this.id = id;
	}

	/** full constructor */
	public HlrinfoVO(Long id, String name, String ip, String port, Long type,
			String region, String address) {
		this.id = id;
		this.name = name;
		this.ip = ip;
		this.port = port;
		this.type = type;
		this.region = region;
		this.address = address;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return this.port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public Long getType() {
		return this.type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
package net.gmcc.pboss.domain.model.orderresdet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * OrderresdetVO entity. @author MyEclipse Persistence Tools
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name = "FX_SW_ORDERRESDET")
public class OrderresdetVO implements java.io.Serializable {

	// Fields

	private Long detid;
	private String orderid;
	private String ordercomtype;
	private String comcategory;
	private String restype;
	private Long comid;
	private String batchno;
	private String boxnum;
	private String comresid;
	private String brand;
	private String wayid;
	private Double comprice;
	private Double actprice;

	// Constructors

	/** default constructor */
	public OrderresdetVO() {
	}

	/** minimal constructor */
	public OrderresdetVO(String orderid) {
		this.orderid = orderid;
	}

	/** full constructor */
	public OrderresdetVO(String orderid, String ordercomtype,
			String comcategory, String restype, Long comid, String batchno,
			String boxnum, String comresid, String brand, String wayid,
			Double comprice, Double actprice) {
		this.orderid = orderid;
		this.ordercomtype = ordercomtype;
		this.comcategory = comcategory;
		this.restype = restype;
		this.comid = comid;
		this.batchno = batchno;
		this.boxnum = boxnum;
		this.comresid = comresid;
		this.brand = brand;
		this.wayid = wayid;
		this.comprice = comprice;
		this.actprice = actprice;
	}

	// Property accessors
	//@SequenceGenerator(name = "generator")
	@Id
	//@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	//@Column(name = "DETID", unique = true, nullable = false, precision = 14, scale = 0)
	@GeneratedValue(strategy = SEQUENCE, generator = "SeqGenerator")
	@SequenceGenerator(name = "SeqGenerator", sequenceName = "FX_SW_ORDERRESDET_SEQ", allocationSize=1)
	@Column(name = "DETID", unique = true, nullable = false, precision = 14, scale = 0)
	public Long getDetid() {
		return this.detid;
	}

	public void setDetid(Long detid) {
		this.detid = detid;
	}

	@Column(name = "ORDERID", nullable = false, length = 18)
	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	@Column(name = "ORDERCOMTYPE", length = 16)
	public String getOrdercomtype() {
		return this.ordercomtype;
	}

	public void setOrdercomtype(String ordercomtype) {
		this.ordercomtype = ordercomtype;
	}

	@Column(name = "COMCATEGORY", length = 20)
	public String getComcategory() {
		return this.comcategory;
	}

	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
	}

	@Column(name = "RESTYPE", length = 32)
	public String getRestype() {
		return this.restype;
	}

	public void setRestype(String restype) {
		this.restype = restype;
	}

	@Column(name = "COMID", precision = 18, scale = 0)
	public Long getComid() {
		return this.comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	@Column(name = "BATCHNO", length = 30)
	public String getBatchno() {
		return this.batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	@Column(name = "BOXNUM", length = 100)
	public String getBoxnum() {
		return this.boxnum;
	}

	public void setBoxnum(String boxnum) {
		this.boxnum = boxnum;
	}

	@Column(name = "COMRESID", length = 20)
	public String getComresid() {
		return this.comresid;
	}

	public void setComresid(String comresid) {
		this.comresid = comresid;
	}

	@Column(name = "BRAND", length = 16)
	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column(name = "WAYID", length = 18)
	public String getWayid() {
		return this.wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	@Column(name = "COMPRICE", precision = 16)
	public Double getComprice() {
		return this.comprice;
	}

	public void setComprice(Double comprice) {
		this.comprice = comprice;
	}

	@Column(name = "ACTPRICE", precision = 16)
	public Double getActprice() {
		return this.actprice;
	}

	public void setActprice(Double actprice) {
		this.actprice = actprice;
	}

}
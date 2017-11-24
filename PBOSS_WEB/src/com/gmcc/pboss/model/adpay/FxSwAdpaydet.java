package com.gmcc.pboss.model.adpay;

/**
 * FxSwDisform entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class FxSwAdpaydet extends com.gmcc.pboss.common.bean.CodeReverse
		implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 2007975201092659618L;
	private Long sumid;
	private String orderid;

	public Long getSumid() {
		return sumid;
	}

	public void setSumid(Long sumid) {
		this.sumid = sumid;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());
		result = prime * result + ((sumid == null) ? 0 : sumid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final FxSwAdpaydet other = (FxSwAdpaydet) obj;
		if (orderid == null) {
			if (other.orderid != null)
				return false;
		} else if (!orderid.equals(other.orderid))
			return false;
		if (sumid == null) {
			if (other.sumid != null)
				return false;
		} else if (!sumid.equals(other.sumid))
			return false;
		return true;
	}

}
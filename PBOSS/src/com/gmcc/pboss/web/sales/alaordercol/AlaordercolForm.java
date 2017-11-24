/**
 * auto-generated code
 * Fri Jun 25 10:41:22 CST 2010
 */
package com.gmcc.pboss.web.sales.alaordercol;

import com.gmcc.pboss.business.sales.alaordercol.AlaordercolVO;

/**
 * <p>Title: AlaordercolForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class AlaordercolForm extends AlaordercolVO {
	
	private Long totalAmount;
	
	private Integer totalOrderamt;
	
	private Integer totalCancelamt;
	
	private Integer totalOveramt;
		
	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getTotalOrderamt() {
		return totalOrderamt;
	}

	public void setTotalOrderamt(Integer totalOrderamt) {
		this.totalOrderamt = totalOrderamt;
	}

	public Integer getTotalCancelamt() {
		return totalCancelamt;
	}

	public void setTotalCancelamt(Integer totalCancelamt) {
		this.totalCancelamt = totalCancelamt;
	}

	public Integer getTotalOveramt() {
		return totalOveramt;
	}

	public void setTotalOveramt(Integer totalOveramt) {
		this.totalOveramt = totalOveramt;
	}
	
}

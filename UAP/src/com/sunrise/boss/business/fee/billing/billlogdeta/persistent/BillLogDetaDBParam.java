/**
 * 
 */
package com.sunrise.boss.business.fee.billing.billlogdeta.persistent;

import java.util.List;

import com.sunrise.jop.infrastructure.db.DBQueryParam;


/**
 * <p>
 * Title: CompanyDelegate
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Hanny Yeung
 * @version 1.0
 */
public class BillLogDetaDBParam extends DBQueryParam {
	private String _ne_validbillcyc;

	private String _sk_subphase;
	private List _sin_subphase;
	
	private String startindex;
	private String endindex;

	public String get_sk_subphase() {
		return _sk_subphase;
	}

	public void set_sk_subphase(String _sk_subphase) {
		this._sk_subphase = _sk_subphase;
	}

	public List get_sin_subphase() {
		return _sin_subphase;
	}

	public void set_sin_subphase(List sinSubphase) {
		_sin_subphase = sinSubphase;
	}

	public String get_ne_validbillcyc() {
		return _ne_validbillcyc;
	}

	public void set_ne_validbillcyc(String _ne_validbillcyc) {
		this._ne_validbillcyc = _ne_validbillcyc;
	}

	public String getEndindex() {
		return endindex;
	}

	public void setEndindex(String endindex) {
		this.endindex = endindex;
	}

	public String getStartindex() {
		return startindex;
	}

	public void setStartindex(String startindex) {
		this.startindex = startindex;
	}
	

}

package com.sunrise.boss.web.fee.billing.billlogdeta;

import com.sunrise.boss.business.fee.billing.billlogdeta.persistent.BillLogDetaVO;

public class BillLogDetaForm extends BillLogDetaVO{

	private static final long serialVersionUID = 1L;
	
	private String _ne_validbillcyc;
	
	private String _sk_subphase;
	
	public String get_ne_validbillcyc() {
		return _ne_validbillcyc;
	}
	
	public void set_ne_validbillcyc(String neValidbillcyc) {
		_ne_validbillcyc = neValidbillcyc;
	}
	
	public String get_sk_subphase() {
		return _sk_subphase;
	}
	
	public void set_sk_subphase(String seSubphase) {
		_sk_subphase = seSubphase;
	}
	
	
}

package com.gmcc.pboss.business.sales.bankrecord;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class VBankrecordDAO extends AbstractDAO{
	public VBankrecordDAO(){
        super(VBankrecordVO.class);
    }
    public DataPackage doDetail(BankrecordDBParam param) throws Exception {
    	param.setSelectFieldsString("deductid,shopnum,acctnum,acctname,statechgtime,countyid,amount,completetime,recordstate,retcode,errmsg,recordinfo,aaa_deductid");
		return queryByNamedSqlQuery("com.gmcc.pboss.business.sales.bankrecord.detail", param);
    }
}

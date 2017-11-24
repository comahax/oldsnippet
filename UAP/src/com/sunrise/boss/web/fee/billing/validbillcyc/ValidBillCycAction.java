/**
 * 
 */
package com.sunrise.boss.web.fee.billing.validbillcyc;

import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.db.DBConstant;
import com.sunrise.jop.ui.struts2.BaseAction;

import com.sunrise.boss.business.fee.billing.validbillcyc.control.ValidBillCyc;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycDBParam;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycVO;

public class ValidBillCycAction extends BaseAction {
	
	public ValidBillCycAction() {	
		setForm(new ValidBillCycForm());
	    setParam(new ValidBillCycDBParam());

	    setClsVO(ValidBillCycVO.class);

	    this.pkNameArray = new String[] { "validbillcyc", "region" };
	    setClsControl(ValidBillCyc.class);
	    setClsQueryParam(ValidBillCycDBParam.class);
	    setDbFlag(DBConstant.DB_FLAG_BILL);
	}
	
	
	/*
	public void setParam(DBQueryParam param) {
		
		try {
			DBQueryParam tmp = (DBQueryParam) param;
			if (tmp.get_orderby() == null || tmp.get_orderby().trim().equals("")) {
				tmp.set_orderby("validbillcyc");
				if (tmp.get_desc() == null || tmp.get_desc().trim().equals("")) {
					tmp.set_desc("1");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
    /**
     * �༭
     */
	public String doEdit() throws Exception{   	
        
        setMonthAndYear(getForm()); 
        return super.doEdit();
    }
    
   
	
    protected void setMonthAndYear(BaseVO form){
    	ValidBillCycForm vform = (ValidBillCycForm)form;
    	if(null != form){
    		if(null != vform.getValidbillcyc() && !"".equals(vform.getValidbillcyc())){
    			if(vform.getValidbillcyc().toString().length() == 8){
    //				vform.setYear(vform.getValidbillcyc().toString().substring(0, 4));
    //				vform.setMonth(vform.getValidbillcyc().toString().substring(4, 8));
    			}   			    			
    		}    		
    	}   	    	
    }
    
   
}

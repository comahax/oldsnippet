package com.sunrise.boss.business.fee.hangbill.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.business.fee.hangbill.persistent.HangbillVO;
import com.sunrise.boss.business.fee.hangbill.persistent.HangbillListVO;
import com.sunrise.boss.ui.commons.User;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: HangbillControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface HangbillControl extends AbstractControl {
    public HangbillVO doCreate(HangbillVO vo, User user)
        throws Exception;

    public void doRemove(HangbillVO vo, User user)
        throws Exception;

    public HangbillVO doUpdate(HangbillVO vo, User user)
        throws Exception;

    public HangbillVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(HangbillListVO params, User user)
        throws Exception;
    public HangbillVO delete(HangBillEntity entity,User user)
    	throws Exception;
    public void batchdelete(HangBillEntity entity,User user) throws Exception;
    public DataPackage doQuery(BillEntity params, User user) throws Exception;
    public void backbill(Long hangid,User user) throws Exception;
    public void adjbill(HangbillVO vo,User user) throws Exception;
    public void backadj(HangbillVO vo,User user) throws Exception;
    public void batchback(HangBillEntity entity,User user) throws Exception;
    public void batchadj(BillEntity entity,User user) throws Exception;
    public void batchbackadj(BillEntity entity,User user) throws Exception;
    public void go(String line,User user) throws Exception;
    public List getMWBusType(String portid,User user) throws Exception;
    
    public void batchPaidAdj(BillEntity entity,User user) throws Exception;
    
    public void batchPaidHang(HangBillEntity entity,User user) throws Exception;
    

}

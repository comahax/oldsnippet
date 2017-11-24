/**
 * auto-generated code
 * Thu Feb 24 16:50:49 CST 2011
 */
package com.gmcc.pboss.control.channel.smsloghis;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.smsloghis.SmsloghisDBParam;
import com.gmcc.pboss.business.channel.smsloghis.SmsloghisVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Smsloghis </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public interface Smsloghis extends AbstractControl {
    public SmsloghisVO doCreate(SmsloghisVO vo) throws Exception;

    public void doRemoveByVO(SmsloghisVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SmsloghisVO doUpdate(SmsloghisVO vo) throws Exception;

    public SmsloghisVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SmsloghisDBParam params) throws Exception;

}

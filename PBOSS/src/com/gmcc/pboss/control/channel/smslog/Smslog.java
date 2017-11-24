/**
 * auto-generated code
 * Thu Feb 24 16:49:38 CST 2011
 */
package com.gmcc.pboss.control.channel.smslog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.smslog.SmslogDBParam;
import com.gmcc.pboss.business.channel.smslog.SmslogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Smslog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public interface Smslog extends AbstractControl {
    public SmslogVO doCreate(SmslogVO vo) throws Exception;

    public void doRemoveByVO(SmslogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SmslogVO doUpdate(SmslogVO vo) throws Exception;

    public SmslogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SmslogDBParam params) throws Exception;

}

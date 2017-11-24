/**
 * auto-generated code
 * Tue Sep 29 10:19:40 CST 2009
 */
package com.gmcc.pboss.control.communication.reply;

import java.io.Serializable;

import com.gmcc.pboss.business.communication.reply.ReplyDBParam;
import com.gmcc.pboss.business.communication.reply.ReplyVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Reply </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Reply extends AbstractControl {
    public ReplyVO doCreate(ReplyVO vo) throws Exception;

    public void doRemoveByVO(ReplyVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ReplyVO doUpdate(ReplyVO vo) throws Exception;

    public ReplyVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ReplyDBParam params) throws Exception;
    
    public DataPackage doQueryReplyInfo(ReplyDBParam params) throws Exception;

}

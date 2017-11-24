/**
 * auto-generated code
 * Tue Sep 29 10:19:40 CST 2009
 */
package com.gmcc.pboss.business.communication.reply;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ReplyDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ReplyDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public ReplyDAO(){
        super(ReplyVO.class);
    }
    
    public DataPackage doQueryReplyInfo(ReplyDBParam params) throws Exception {
    	params.setSelectFieldsString("advinfoid,replytime,oid,replycontent,wayid,employeename");
    	return queryByNamedSqlQuery("com.gmcc.pboss.business.communication.reply.queryReplyInfo",params);
    }
}

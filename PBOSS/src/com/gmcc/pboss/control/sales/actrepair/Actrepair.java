/**
 * auto-generated code
 * Fri Oct 23 15:56:45 CST 2009
 */
package com.gmcc.pboss.control.sales.actrepair;

import java.io.Serializable;
import java.util.Date;

import com.gmcc.pboss.business.sales.actrepair.ActrepairDBParam;
import com.gmcc.pboss.business.sales.actrepair.ActrepairVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Actrepair </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Actrepair extends AbstractControl {
    public ActrepairVO doCreate(ActrepairVO vo) throws Exception;

    public void doRemoveByVO(ActrepairVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ActrepairVO doUpdate(ActrepairVO vo) throws Exception;

    public ActrepairVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ActrepairDBParam params) throws Exception;
	/**
	 * 对导入的激活号码进行时间检查
	 * @param mobile
	 * @param activedate
	 * @return
	 * @throws Exception
	 */
	
	public boolean doCheckDate(String mobile,Date activedate,String day) throws Exception;

}

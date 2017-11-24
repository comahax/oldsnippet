/**
* auto-generated code
* Sat Jul 29 16:54:43 CST 2006
*/
package com.sunrise.boss.business.admin.purview.persistent;

import com.sunrise.boss.business.admin.acl.persistent.ACLDAO;
/**
 * <p>Title: CompanyDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class PurviewDAO  {
	/**
	 * 
	 * @param opercode
	 *            Operator Id get From Session
	 * @param pageId
	 *            pageId eg:1A2B3C4D
	 * @return
	 */
	public boolean checkPurview(String opercode, String pageId) {
		ACLDAO dao=new ACLDAO();
		return dao.checkPermission(opercode, pageId);
	}

}
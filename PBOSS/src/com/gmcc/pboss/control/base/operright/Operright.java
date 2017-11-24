/**
 * auto-generated code
 * Mon Jul 13 10:33:51 CST 2009
 */
package com.gmcc.pboss.control.base.operright;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.base.operright.OperrightDBParam;
import com.gmcc.pboss.business.base.operright.OperrightVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Operright </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Lee
 * @version 1.0
 */
public interface Operright extends AbstractControl {
    public OperrightVO doCreate(OperrightVO vo) throws Exception;

    public void doRemoveByVO(OperrightVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OperrightVO doUpdate(OperrightVO vo) throws Exception;

    public OperrightVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OperrightDBParam params) throws Exception;
    
	/**
	 * 检查指定工号对权限点 permissionId 是否有访问权限
	 * @param oprcode
	 * @param permissionId
	 * @return
	 * @throws Exception
	 */
	public boolean doCheckPermission(String oprcode, String permissionId) throws Exception;
	
	/**
	 * 检查指定工号对 web请求 uri是否有权限。
	 * @param oprcode
	 * @param currentURI
	 * @return
	 * @throws Exception
	 */
	public boolean doCheckURIPermission(String oprcode, String currentURI) throws Exception ;
	
	public void doBatchSave(List rightList, List operList) throws Exception;

}

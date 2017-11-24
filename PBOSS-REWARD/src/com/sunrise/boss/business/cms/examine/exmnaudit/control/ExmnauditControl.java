/**
* auto-generated code
* Sat Nov 28 17:57:55 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnaudit.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.ExmnauditDAO;
import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.ExmnauditVO;
import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.ExmnauditListVO;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: ExmnauditControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ExmnauditControl extends AbstractControl {
    public ExmnauditVO doCreate(ExmnauditVO vo, User user)
        throws Exception;

    public void doRemove(ExmnauditVO vo, User user)
        throws Exception;

    public ExmnauditVO doUpdate(ExmnauditVO vo, User user)
        throws Exception;

    public ExmnauditVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ExmnauditListVO params, User user)
        throws Exception;
    /**
     * 根据考核登记ID数组查询验证能否被收回
     * @param itemgradeds
     * @return 不能被回收的考核登记标识集合
     * @throws Exception
     */
	 public List doValidateCallbackInfo(String[] itemgradeds,User user) throws Exception;
	 /**
     * 删除回收的考核信息审核信息
     * @param itemgradeds
     * @param oprcode
     * @throws Exception
     */
    public void doRemoveCallbackInfo(String[] itemgradeds,String oprcode,User user) throws Exception;
    /**
	  * 查找所有可提交的考核项评分标识信息
	  */
	 public List doFindAllCallbackItemgradeds(User user)throws Exception;
	 /**
	 * 查找考核信息审核和考核相关信息列表
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryExmnauditList(ExmnauditListVO params,User user) throws Exception;
	/**
     * 查找所有可提交考核信息审核的ID集合
     * @return
     * @throws Exception
     */
    public List doFindAllSubmitSeqid(User user)throws Exception;
    /**
     * 验证最新审核人
     * @param itemgradeds
     * @param oprcode
     * @return 
     * @throws Exception
     */
    public List doValidateNewAuditor(String[] reqids,String[] itemgradeds,User user) throws Exception;
  
		 
	 /**
	  * 查找所有可审核的考核信息审核标识信息
	  */
	 public List doFindAllAuditExmnaudits(User user)throws Exception;
	 /**
     * 删除回收的考核信息审核信息
     * @param itemgradeds
     * @param oprcode
     * @throws Exception
     */
    public void doRemoveCallbackInfo(String[] itemgradeds,User user) throws Exception;
	 /**
	  * 执行回收相关操作(删除相关考核信息审核信息,更新考核项评分信息)--考核信息审核功能
	  */
	 public void doCallbackInfo(String[] selectArray,User user)throws Exception;
	 /**
	  * 执行审核相关操作(更新考核项评分表和考核信息表中的状态为所选的状态,和保存审核意见)
	  * @param selectArray
	  * @throws Exception
	  */
	 public void doAuditInfo(String[] selectArray,String state,String auditopinion,User user)throws Exception;
}

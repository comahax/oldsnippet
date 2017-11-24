/**
* auto-generated code
* Fri Aug 18 11:29:20 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplangroup.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.business.zifee.yxplangroup.persistent.YxPlanGroupVO;
import com.sunrise.boss.business.zifee.yxplangroup.persistent.YxPlanGroupListVO;
import com.sunrise.boss.ui.commons.User;
import java.io.Serializable;
/**
 * <p>Title: YxPlanGroupControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public interface YxPlanGroupControl extends AbstractControl {
    public YxPlanGroupVO doCreate(YxPlanGroupVO vo, User user)
        throws Exception;

    public YxPlanGroupVO doUpdate(YxPlanGroupVO vo, User user)
        throws Exception;

    public YxPlanGroupVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(YxPlanGroupListVO params, User user)
        throws Exception;
    
    public void doRemoveByVO(YxPlanGroupVO vo, User user) throws Exception;

    public void doRemoveByPK(Serializable pk, User user) throws Exception;

    public DataPackage doQueryByGroup(YxPlanGroupListVO params, User user)
       throws Exception ;
    public void deleteByGroupid(Long groupid, User user) throws Exception ;
    /**
     * 批量新增营销方案组的成员
     * @param vo
     * @param user
     * @return
     * @throws Exception
     */
    public YxPlanGroupVO doBatchCreate(YxPlanGroupVO vo, User user) throws Exception;
    
    /**
     * 批量删除营销方案组的成员
     * @param vo
     * @param user
     * @return
     * @throws Exception
     */
    public void doBatchDelete(YxPlanGroupVO vo, User user) throws Exception;
    /**
     * 批量查询营销方案组(根据营销方案组标识)的成员
     * @param vo
     * @param user
     * @return
     * @throws Exception
     * @author Linli
     */
    public DataPackage doBatchQueryGroup(String queryItems, User user) throws Exception;
    /**
     * 批量查询营销方案(根据营销方案标识)的成员
     * @param vo
     * @param user
     * @return
     * @throws Exception
     * @author Linli
     */
    public DataPackage doBatchQueryMem(String queryItems, User user) throws Exception;
    /**
     * 全量查询营销方案的成员
     * @param vo
     * @param user
     * @return
     * @throws Exception
     * @author Linli
     */
    public DataPackage doBatchQueryAll(String queryItems, User user) throws Exception;
    
}

/**
* auto-generated code
* Fri Aug 18 11:29:20 CST 2006
*/
package com.sunrise.boss.delegate.zifee.yxplangroup;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.business.zifee.yxplangroup.persistent.YxPlanGroupVO;
import com.sunrise.boss.business.zifee.yxplangroup.persistent.YxPlanGroupListVO;
import com.sunrise.boss.business.zifee.yxplangroup.control.YxPlanGroupControl;
import com.sunrise.boss.business.zifee.yxplangroup.control.YxPlanGroupControlBean;
import com.sunrise.boss.ui.commons.User;
import java.io.Serializable;

/**
 * <p>Title: YxPlanGroupDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class YxPlanGroupDelegate {

	private YxPlanGroupControl control;

    public YxPlanGroupDelegate() throws Exception {
        control = (YxPlanGroupControl) ControlFactory.build(YxPlanGroupControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public YxPlanGroupVO doCreate(YxPlanGroupVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public YxPlanGroupVO doUpdate(YxPlanGroupVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public void doRemoveByPK(Serializable pk, User user) throws Exception {
        if (null == pk || null == user) {
            throw new IllegalArgumentException();
        } else {
            control.doRemoveByPK(pk, user);
        }
    }
    
    public YxPlanGroupVO doFindByPk(Serializable pk, User user) throws Exception{
        if (null == pk || null == user) {
            throw new IllegalArgumentException();
        } else {
            return control.doFindByPk(pk, user);
        }	
    }

    public void doRemove(YxPlanGroupVO vo, User user) throws Exception {
        if (null == vo || null == user) {
            throw new IllegalArgumentException();
        } else {
            control.doRemoveByVO(vo, user);
        }
    }
    public DataPackage doQuery(YxPlanGroupListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public DataPackage doQueryByGroup(YxPlanGroupListVO params, User user)
    throws Exception{
        return control.doQueryByGroup(params, user);
    }
    public void deleteByGroupid(Long groupid, User user) throws Exception{
    	control.deleteByGroupid(groupid,user);
    }
    /**
     * 批量新增营销方案组的成员
     * @param vo
     * @param user
     * @throws Exception
     */
    public void doBatchCreate(YxPlanGroupVO vo, User user) throws Exception{
    	control.doBatchCreate(vo,user);
    }
    
    /**
     * 批量删除营销方案组的成员
     * @param vo
     * @param user
     * @throws Exception
     */
    public void doBatchDelete(YxPlanGroupVO vo, User user) throws Exception{
    	control.doBatchDelete(vo,user);
    }
    /**
     * 批量查询营销方案组的成员
     * @param vo
     * @param user
     * @throws Exception
     */
    public DataPackage doBatchQueryGroup(String queryItems, User user) throws Exception{
    	return control.doBatchQueryGroup(queryItems, user);
    }
    /**
     * 批量查询营销方案组的成员
     * @param vo
     * @param user
     * @throws Exception
     */
    public DataPackage doBatchQueryMem(String queryItems, User user) throws Exception{
    	return control.doBatchQueryMem(queryItems, user);
    }
    /**
     * 批量查询营销方案组的成员
     * @param vo
     * @param user
     * @throws Exception
     */
    public DataPackage doBatchQueryAll(String queryItems, User user) throws Exception{
    	return control.doBatchQueryAll(queryItems, user);
    }
}

/**
* auto-generated code
* Thu Jul 26 16:12:39 CST 2007
*/
package com.sunrise.boss.delegate.cms.fdaudit;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.fdaudit.control.FdauditControl;
import com.sunrise.boss.business.cms.fdaudit.control.FdauditControlBean;
import com.sunrise.boss.business.cms.fdaudit.persistent.FdauditVO;
import com.sunrise.boss.business.cms.fdaudit.persistent.FdauditListVO;
import com.sunrise.boss.business.cms.fdauditdef.persistent.FdauditdefVO;

import java.io.Serializable;

/**
 * <p>Title: FdauditDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yuanweihai
 * @version 1.0
 */
public class FdauditDelegate {

    private static FdauditControl control;

    public FdauditDelegate() throws Exception {
        control = (FdauditControl) ControlFactory.build(FdauditControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public FdauditVO doCreate(FdauditVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(FdauditVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public FdauditVO doUpdate(FdauditVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public FdauditVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (FdauditVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(FdauditListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
    
    //CH_PW_WAY	CH_PW_SVWAY	自营渠道管理
    //ch_pw_wayseatdet	CH_PW_SVWAY	自营渠道管理
    //CH_pw_waybussarea	CH_PW_SVWAY	自营渠道管理
    //…	CH_PW_SVWAY	自营渠道管理
    //CH_PW_WAY	CH_PW_DISWAY	合作商管理
    //CH_PW_WAY	CH_PW_STRBWAY	经销商管理
    //CH_PW_WAY	CH_PW_SALEWAY	零售渠道管理

    /**
     * 未审核字段查询
     * @param typename
     * @param pkvalue
     * @param user
     * @return
     */
    public DataPackage queryUnauditedFields(String typename,Object pkvalue, User user)throws Exception{
    	FdauditListVO listvo=new FdauditListVO();
    	listvo.set_se_typename(typename);
    	listvo.set_se_pkvalue(pkvalue.toString());
    	listvo.set_ne_auditstatus("0");
    	return doQuery(listvo,user);
    } 
    /**
     * 未审核字段查询
     * @param tablename
     * @param typename
     * @param pkvalue
     * @param user
     * @return
     */
    public DataPackage queryUnauditedFields(String tablename ,String typename,Object pkvalue, User user)throws Exception{
    	FdauditListVO listvo=new FdauditListVO();
    	listvo.set_se_tablename(tablename);
    	listvo.set_se_typename(typename);
    	listvo.set_se_pkvalue(pkvalue.toString());
    	listvo.set_ne_auditstatus("0");
    	return doQuery(listvo,user);
    	
    }
    /**
     * 是否有未审核字段查询
     * @param typename
     * @param pkvalue
     * @param user
     * @return true--有未审核 false 没有未审核  
     */
    public boolean hasUnauditedFields(String tablename,String typename,Object pkvalue, User user)throws Exception{
    	FdauditListVO listvo=new FdauditListVO();
    	listvo.set_se_tablename(tablename);
    	listvo.set_se_typename(typename);
    	listvo.set_se_pkvalue(pkvalue.toString());
    	listvo.set_ne_auditstatus("0");
    	DataPackage datapackage=doQuery(listvo,user);
    	return !datapackage.getDatas().isEmpty();
    }
    /**
     * 自营渠道管理，零售渠道管理等，相应的要设置字段审批令牌控制
     */
    public boolean businessPurview(String purview,User user)throws Exception{
    	return control.businessPurview(purview,user);
    }
    /**
     * 字段回填
     * @param purview
     * @param user
     * @return
     * @throws Exception
     */
    public boolean fieldBackfill(FdauditVO vo,FdauditdefVO fdauditdefvo,User user)throws Exception{
    	return control.fieldBackfill(vo,fdauditdefvo,user);
    }
    
    public Object doGetorgVO(Object vo, User user) throws Exception{
    	return control.doGetorgVO(vo, user);
    }
}

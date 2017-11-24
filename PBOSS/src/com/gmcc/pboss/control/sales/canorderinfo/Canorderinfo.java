/**
 * auto-generated code
 * Wed Aug 10 10:50:17 CST 2011
 */
package com.gmcc.pboss.control.sales.canorderinfo;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.canorderinfo.CanorderinfoDBParam;
import com.gmcc.pboss.business.sales.canorderinfo.CanorderinfoVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: canorderinfo </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public interface Canorderinfo extends AbstractControl {
    public CanorderinfoVO doCreate(CanorderinfoVO vo) throws Exception;

    public void doRemoveByVO(CanorderinfoVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CanorderinfoVO doUpdate(CanorderinfoVO vo) throws Exception;

    public CanorderinfoVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CanorderinfoDBParam params) throws Exception;
    
    public List doStatPartnerres(CanorderinfoDBParam params) throws Exception;
        
    /**
     * 单个合作商短信通知
     * @param user	当前用户信息
     * @param wayvo	合作商相关信息
     * @param isReturn	1：返回页面单个处理；0：批量处理
     * @throws Exception
     */
    public CanorderinfoVO doNotceOne(DBAccessUser user,WayVO wayvo) throws Exception;
    
    /**
     * 获取套卡品牌集合
     * @param brandList 套卡品牌集合
     * @param user	当前用户信息
     * @param wayvo	合作商相关信息
     * @throws Exception
     */
    public List doQueryBrand(List brandList, DBAccessUser user, WayVO wayvo) throws Exception;
    
    /**
     * 获取充值卡订购信息
     * @param cardList	充值卡订购信息
     * @param user	当前用户信息
     * @param wayvo	合作商相关信息
     * @throws Exception
     */
    public List doQueryStock(List cardList, DBAccessUser user, WayVO wayvo) throws Exception;
    
    /**
     * 获取空白SIM卡订购信息
     * @param emptyList	空白SIM卡订购信息
     * @param user	当前用户信息
     * @param wayvo	合作商相关信息
     * @throws Exception
     */
    public List doQueryEmpty(List emptyList, DBAccessUser user, WayVO wayvo) throws Exception;
    
    /**
     * 合作商检查、订购量约束模式检查
     * @param user	当前用户信息
     * @param wayvo 合作商相关信息
     * @param wayid
     * @param isReturn 1：返回页面单个处理；0：批量处理
     * @return
     * @throws Exception
     */
    public String doCheckWayAndModel(DBAccessUser user, WayVO wayvo, String wayid) throws Exception;

}

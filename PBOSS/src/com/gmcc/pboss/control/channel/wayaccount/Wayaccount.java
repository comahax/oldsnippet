/**
 * auto-generated code
 * Wed Jul 01 17:30:39 CST 2009
 */
package com.gmcc.pboss.control.channel.wayaccount;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.wayaccount.WayaccountDBParam;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Wayaccount </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface Wayaccount extends AbstractControl {
    public WayaccountVO doCreate(WayaccountVO vo) throws Exception;

    public void doRemoveByVO(WayaccountVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WayaccountVO doUpdate(WayaccountVO vo) throws Exception;

    public WayaccountVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WayaccountDBParam params) throws Exception;
    /**
	 * <pre>
	 * 查询指定渠道及其下级渠道的详细信息
	 * (包括渠道信息，店员信息，渠道网点联系资料，渠道合同协议资料，渠道帐户资料，分销合作商资料表)
	 * </pre>
	 * @param params
	 * @param wayid
	 * @return DataPackage 里面的元素是AGWayVO
	 * @throws Exception
	 */
    public DataPackage doQueryWayAndSubwayDetailInfo(WayaccountDBParam params,String wayid) 
		throws Exception;

}

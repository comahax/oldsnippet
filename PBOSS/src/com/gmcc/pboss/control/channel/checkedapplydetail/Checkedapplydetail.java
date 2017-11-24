/**
 * auto-generated code
 * Tue Jun 05 08:33:24 CST 2012
 */
package com.gmcc.pboss.control.channel.checkedapplydetail;

import java.io.Serializable;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailDBParam;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Checkedapplydetail </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public interface Checkedapplydetail extends AbstractControl {
    public CheckedapplydetailVO doCreate(CheckedapplydetailVO vo) throws Exception;

    public void doRemoveByVO(CheckedapplydetailVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CheckedapplydetailVO doUpdate(CheckedapplydetailVO vo) throws Exception;

    public CheckedapplydetailVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CheckedapplydetailDBParam params) throws Exception;
    
    public DataPackage doQueryCheckedapplydetail(CheckedapplydetailDBParam params) throws Exception;
    
   //更新查询授权网点申请明细表 
    public DataPackage doQueryInfoForUpdate(CheckedapplydetailDBParam params) throws Exception; 
    
    // 新增查询授权网点申请明细表 
    public DataPackage doQueryInfoForInsert(CheckedapplydetailDBParam params) throws Exception;
    
	// 分公司新增查询授权网点申请明细表
    public DataPackage doQueryInfoForInsert_COUNTY(CheckedapplydetailDBParam params) throws Exception; 
    
	// 市公司初审人新增查询授权网点申请明细表
    public DataPackage doQueryInfoForInsert_MIDCITY(CheckedapplydetailDBParam params) throws Exception;
    
	//授权网点申请管理选择申请网点，申请类型为准入申请的时候，查询渠道表限制条件
	public DataPackage doQueryWayinfoForapplyway(WayDBParam params) throws Exception;
	
	//授权网点申请管理选择申请网点，申请类型为退出申请的时候，查询渠道表的限制条件
	public DataPackage doQueryWayinfoForExitway(WayDBParam params) throws Exception;

}

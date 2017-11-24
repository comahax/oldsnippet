/**
 * auto-generated code
 * Tue Jun 05 08:32:39 CST 2012
 */
package com.gmcc.pboss.control.channel.checkedapply;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.checkedapply.CheckedapplyDBParam;
import com.gmcc.pboss.business.channel.checkedapply.CheckedapplyVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Checkedapply </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public interface Checkedapply extends AbstractControl {
    public CheckedapplyVO doCreate(CheckedapplyVO vo) throws Exception;

    public void doRemoveByVO(CheckedapplyVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CheckedapplyVO doUpdate(CheckedapplyVO vo) throws Exception;

    public CheckedapplyVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CheckedapplyDBParam params) throws Exception;
    
    public DataPackage doQueryCheckedapplyStat(CheckedapplyDBParam params) throws Exception; 
    
    public CheckedapplyVO doAddCheckedapply(CheckedapplyVO vo) throws Exception;
    
	public CheckedapplyVO doAddCheckedapply(CheckedapplyVO vo, boolean ch_checked_county, boolean ch_checked_midcity) throws Exception;
    
    public void doUpdateCheckedapply(CheckedapplyVO vo) throws Exception;
    
    public DataPackage doQueryByNamedSqlQuery(String name, Object param) throws Exception;
    
    public DataPackage doQueryByNamedSqlQueryWay(String name, Object param) throws Exception;
    
    public DataPackage doQueryCheckedapplyDetail(CheckedapplyDBParam params) throws Exception;
    
}

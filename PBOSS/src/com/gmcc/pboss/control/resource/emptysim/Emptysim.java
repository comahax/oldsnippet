/**
 * auto-generated code
 * Wed Sep 02 13:59:59 CST 2009
 */
package com.gmcc.pboss.control.resource.emptysim;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.comrescard.ComrescardDBParam;
import com.gmcc.pboss.business.resource.emptysim.EmptysimDBParam;
import com.gmcc.pboss.business.resource.emptysim.EmptysimVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Emptysim </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Emptysim extends AbstractControl {
    public EmptysimVO doCreate(EmptysimVO vo) throws Exception;

    public void doRemoveByVO(EmptysimVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public EmptysimVO doUpdate(EmptysimVO vo) throws Exception;

    public EmptysimVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(EmptysimDBParam params) throws Exception;
    
    public DataPackage doQueryBySqlName(String sqlName,DBQueryParam param) throws Exception;

    /**
	 * 根据商品种类查询充值卡资源与商品种类组合集合
	 * @param param
	 * @param comcategory
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryByComcategory(EmptysimDBParam param,String countyid,String svccode,String mareacode)
	throws Exception ;

    
    public DataPackage doStat( EmptysimDBParam params) throws Exception;  //空白SIM卡库存统计
    
    public DataPackage doResQuery( EmptysimDBParam params) throws Exception;
 

}

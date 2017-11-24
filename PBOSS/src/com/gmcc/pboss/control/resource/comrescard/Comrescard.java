/**
 * auto-generated code
 * Tue Sep 01 14:54:44 CST 2009
 */
package com.gmcc.pboss.control.resource.comrescard;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.comrescard.ComrescardDBParam;
import com.gmcc.pboss.business.resource.comrescard.ComrescardVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Comrescard </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Comrescard extends AbstractControl {
    public ComrescardVO doCreate(ComrescardVO vo) throws Exception;

    public void doRemoveByVO(ComrescardVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ComrescardVO doUpdate(ComrescardVO vo) throws Exception;

    public ComrescardVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ComrescardDBParam params) throws Exception;
    
    public DataPackage doStat(ComrescardDBParam params) throws Exception;
	/**
	 * 根据商品种类查询充值卡资源与商品种类组合集合
	 * @param param
	 * @param comcategory
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryByComcategory(ComrescardDBParam param,String comcategory,String countyid,String svccode,String mareacode)
	throws Exception;
	
	public DataPackage doUnionQuery(Object[] params,Class[] classvo,String[][] joins)
	throws Exception ;
	public Integer doStatCardStock(String countyid,String comcategory) throws Exception;
	
	public DataPackage doQueryBySqlName(String sqlName,DBQueryParam param) throws Exception;
}

/**
 * auto-generated code
 * Tue Oct 19 15:41:02 CST 2010
 */
package com.gmcc.pboss.control.sales.waystockrecord;

import java.io.Serializable;
import java.util.Map;

import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.sales.waystockrecord.WaystockrecordDBParam;
import com.gmcc.pboss.business.sales.waystockrecord.WaystockrecordVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Waystockrecord </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface Waystockrecord extends AbstractControl {
    public WaystockrecordVO doCreate(WaystockrecordVO vo) throws Exception;

    public void doRemoveByVO(WaystockrecordVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WaystockrecordVO doUpdate(WaystockrecordVO vo) throws Exception;

    public WaystockrecordVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WaystockrecordDBParam params) throws Exception;
    
    public DataPackage queryRestypeToComcategory(WaystockrecordDBParam params, String name)throws Exception;

    public Map doLoadComCateAndBrand(ComcategoryrelaDBParam params) throws Exception;
    
    public Long getComcategoryCount() throws Exception;
}

/**
 * auto-generated code
 * Sat Sep 05 15:14:44 CST 2009
 */
package com.gmcc.pboss.control.resource.comcategoryrela;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.sales.waystockrecord.WaystockrecordDBParam;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Comcategoryrela </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Comcategoryrela extends AbstractControl {
    public ComcategoryrelaVO doCreate(ComcategoryrelaVO vo) throws Exception;

    public void doRemoveByVO(ComcategoryrelaVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ComcategoryrelaVO doUpdate(ComcategoryrelaVO vo) throws Exception;

    public ComcategoryrelaVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ComcategoryrelaDBParam params) throws Exception;

    /**
     * 根据品牌标识查询商品种类
     * @param brand
     * @return
     * @throws Exception
     */
    public List<String> doQueryComcategoryByBrand(String brand) throws Exception;
    
    public DataPackage doLoadComCateAndResType(ComcategoryrelaDBParam params) throws Exception;
    
    public DataPackage doLoadComCateAndBrand(ComcategoryrelaDBParam params)	throws Exception ;
    public DataPackage doQueryDistinctComcategory(ComcategoryrelaDBParam param)throws Exception ;
    
    public DataPackage doQueryRestypeToComcategory(ComcategoryrelaDBParam params)throws Exception;
}

/**
 * auto-generated code
 * Tue Oct 13 09:30:24 CST 2009
 */
package com.gmcc.pboss.control.sales.comprice;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO;
import com.gmcc.pboss.business.sales.comprice.CompriceDBParam;
import com.gmcc.pboss.business.sales.comprice.CompriceVO;
import com.gmcc.pboss.business.sales.comprice.CompriceVOHelper;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Comprice </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Comprice extends AbstractControl {
    public CompriceVO doCreate(CompriceVO vo) throws Exception;

    public void doRemoveByVO(CompriceVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CompriceVO doUpdate(CompriceVO vo) throws Exception;

    public CompriceVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CompriceDBParam params) throws Exception;

    //保存
    public Long doCompriceSave(CompriceVOHelper helper) throws Exception;
    
    //获取合作类型列表
    public List<CustwaytypeVO> doGetCustwaytypeList() throws Exception;
    
    //商品销售价格设置批量导入
    public void  doCompriceImport(String[] item) throws Exception;
 
}

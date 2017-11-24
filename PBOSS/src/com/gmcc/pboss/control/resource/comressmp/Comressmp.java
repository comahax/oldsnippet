/**
 * auto-generated code
 * Tue Sep 01 14:28:15 CST 2009
 */
package com.gmcc.pboss.control.resource.comressmp;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>Title: Comressmp </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Comressmp extends AbstractControl {
    public ComressmpVO doCreate(ComressmpVO vo) throws Exception;

    public void doRemoveByVO(ComressmpVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ComressmpVO doUpdate(ComressmpVO vo) throws Exception;

    public ComressmpVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ComressmpDBParam params) throws Exception;

    public DataPackage doStat(ComressmpDBParam params) throws Exception;
    public void doUpdateBatchResuse(String comresid,String resuse)throws Exception ;
    public void doUpdateBatchStorarea(String comresid,String storarea)throws Exception ;
    public void doUpdateBatchBoxnum(String[] items)throws Exception ;
    
    public DataPackage doQueryBySqlName(String sqlName,DBQueryParam param) throws Exception;
    
    /**
	 * 根据商品批次获取【箱号打印】或【盒号打印】中所需的打印数据
	 * @param param 
	 * @param mode     mode=box 时 为盒号打印，mode=trunk 时为箱号打印
	 * @return
	 * @throws Exception
	 */
	public DataPackage doGetTrunksOrBoxesForPrint(ComressmpDBParam param,String mode) throws Exception;
	
	/**
	 * 根据商品批次获取【包号打印】中所需的打印数据
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public DataPackage doGetPackagesForPrint(ComressmpDBParam param) throws Exception;
	 /**
     * 根据批次和包号查询套卡资源表获取最大包内序号
     * @param param
     * @return
     * @throws Exception
     */
    public Integer doMaxInsideseq(ComressmpDBParam param)throws Exception;
    
    public Integer doStatSMPStock(String countyid,String comcategory) throws Exception;
    
    /**
     * 按分公司，品牌统计该分公司下所有网点中非"已售"的套卡库存量
     * @return
     * @throws Exception
     */
    public DataPackage doStatCountyQty() throws Exception;
    
    
    /**
     * 包号更新
     */
    public ResultVO doBoxNumUpdate(String line,User user,int rowCount) throws Exception;
   
    
}

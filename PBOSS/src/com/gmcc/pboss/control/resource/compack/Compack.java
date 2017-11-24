/**
 * auto-generated code
 * Fri Sep 25 15:08:39 CST 2009
 */
package com.gmcc.pboss.control.resource.compack;

import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.business.resource.compack.ComcategoryInfo;
import com.gmcc.pboss.business.resource.compack.CompackDBParam;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.compack.PackResourceInfo;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: Compack </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Compack extends AbstractControl {
    public CompackVO doCreate(CompackVO vo) throws Exception;

    public void doRemoveByVO(CompackVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CompackVO doUpdate(CompackVO vo) throws Exception;

    public CompackVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CompackDBParam params) throws Exception;
    
    public DataPackage doQueryBynameSql(String sqlName,DBQueryParam params)throws Exception;
    
    /**
	 * 获取商品包抽取功能的商品包(对渠道表的关联以获取商品包归属分公司)
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryCompackResdraw(CompackDBParam param,String countyid,String svccode,String mareacode)throws Exception ;
	/**
	 * 确实资源目标
	 * @param wayid 归属渠道
	 * @param batchno	商品批次
	 * @throws Exception
	 */
	public DataPackage doConfirmResource(String wayid,String batchno) throws Exception;
	
	public void packResource(List<ComcategoryInfo> comcateList,String wayid,String batchno,PackResourceInfo packInfo,OutputStream os) throws Exception;
	
	public DataPackage doPackToolConfirmResource(Map<String,List<ComressmpVO>> resourceMap,String comcategory) throws Exception;
	
	public void packToolResource(ComcategoryInfo comcategoryInfo,Map<String,List<ComressmpVO>> resourceMap,PackResourceInfo packInfo,OutputStream os) throws Exception;
	
	/**
	 * 套卡批量调拨
	 * 根据商品包更新套卡表，依据商品包的批次和包号，修改相关套卡表
	 * 将商品包和其中对应的套卡记录的渠道编码字段改成新的渠道编码
	 * @param compackVO 商品包
	 * @param newWayid	新渠道编码
	 */
	public void doUpdateComressmp(CompackVO compackVO, String newWayid);
}

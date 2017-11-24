package com.gmcc.pboss.business.cms.examine.exmnstddetail.control;


import java.io.Serializable;


import com.gmcc.pboss.business.cms.examine.exmnstddetail.persistent.ExmnstddetailDBParam;
import com.gmcc.pboss.business.cms.examine.exmnstddetail.persistent.ExmnstddetailVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Exmnstddetail </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Exmnstddetail extends AbstractControl {
    public ExmnstddetailVO doCreate(ExmnstddetailVO vo) throws Exception;

    public void doRemoveByVO(ExmnstddetailVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ExmnstddetailVO doUpdate(ExmnstddetailVO vo) throws Exception;

    public ExmnstddetailVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ExmnstddetailDBParam params) throws Exception;
    /**
     * 按“渠道代码[WAYID]”、“考核标识[EXMNID]”、“考核周期[EXMNPERIOD]
     * 分组统计指标得分明细的“考核分数[EXMNMARK]”，得到“考核总分”及相关信息
     * @return
     * @throws Exception
     */
    public DataPackage doSumGroupExmnmarkInfo(String exmnperiod) throws Exception ;
    /**
     * 根据“渠道代码[WAYID]”、“考核标识[EXMNID]”、“考核周期”判断
     * 指标得分明细表中是否存在“否决项[ISVOTED]”为“是[1]”的是指标
     * @param wayid
     * @param exmnid
     * @param exmnperiod
     * @return
     * @throws Exception
     */
    public boolean doHasIsvotedExmnstddetail(String wayid,Integer exmnid,String exmnperiod)throws Exception;
    /**
	 * 根据考核周期删除已存在的指标得分明细信息
	 * @param exmnperiod
	 * @throws Exception
	 */
	public void doDelBeingExmnstddetail(String exmnperiod)throws Exception;

}

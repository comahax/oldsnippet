/**
 * auto-generated code
 * Tue Sep 15 10:39:05 CST 2009
 */
package com.gmcc.pboss.control.promotion.promotingwayid;

import java.io.Serializable;
import java.util.Map;

import open.tool.rule.data.VO;

import com.gmcc.pboss.business.promotion.promotingwayid.PromotingwayidDBParam;
import com.gmcc.pboss.business.promotion.promotingwayid.PromotingwayidVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Promotingwayid </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Promotingwayid extends AbstractControl {
    public PromotingwayidVO doCreate(PromotingwayidVO vo) throws Exception;

    public void doRemoveByVO(PromotingwayidVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PromotingwayidVO doUpdate(PromotingwayidVO vo) throws Exception;

    public PromotingwayidVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PromotingwayidDBParam params) throws Exception;

    /**
	 * 剔除源数据中的已促销渠道记录
	 * 
	 * @param srcData
	 * @param pfrtMode
	 * @param pid
	 * @param ruleid
	 * @param cityid
	 * @return
	 * @throws Exception
	 */
	public Map<VO, Object> filterDataByPfrtMode(Map<VO, Object> srcData,
			String pfrtMode, long pid, long ruleid)
			throws Exception;
}

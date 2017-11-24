/**
 * auto-generated code
 * Thu Sep 17 15:12:35 CST 2009
 */
package com.gmcc.pboss.control.promotion.ppzlnrule;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.promotion.ppzlnrule.PpzlnruleDBParam;
import com.gmcc.pboss.business.promotion.ppzlnrule.PpzlnruleVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Ppzlnrule </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Ppzlnrule extends AbstractControl {
    public PpzlnruleVO doCreate(PpzlnruleVO vo) throws Exception;

    public void doRemoveByVO(PpzlnruleVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PpzlnruleVO doUpdate(PpzlnruleVO vo) throws Exception;

    public PpzlnruleVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PpzlnruleDBParam params) throws Exception;
    
    public void doBatchSave(String rulename, String pri, String memo, Long pid)
	throws Exception;

    public void doDeleteRule(Long ruleid, Long pid, List<Long> itemidlist) throws Exception;
    
    /**
     *  根据方案标识pid获取规则列表，orderBy决定是否按优先级升序排序
     * @param pid
     * @return
     * @throws Exception
     */
    public DataPackage doQueryRulesByPid(long pid,boolean orderBy) throws Exception;
    
}

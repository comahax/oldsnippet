/**
 * auto-generated code
 * Mon Sep 14 14:51:11 CST 2009
 */
package com.gmcc.pboss.control.promotion.spproposal;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import open.tool.rule.data.VO;

import com.gmcc.pboss.business.promotion.spproposal.SpproposalDBParam;
import com.gmcc.pboss.business.promotion.spproposal.SpproposalVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Spproposal </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Spproposal extends AbstractControl {
    public SpproposalVO doCreate(SpproposalVO vo) throws Exception;

    public void doRemoveByVO(SpproposalVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SpproposalVO doUpdate(SpproposalVO vo) throws Exception;

    public SpproposalVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SpproposalDBParam params) throws Exception;

    public void doBatchCreate(SpproposalVO vo, List deamonList) throws Exception;
    
    public void doBatchEdit(SpproposalVO vo, List deamonList) throws Exception;
    
    public void doBatchDelete(Long pid) throws Exception;
    
    public void doBatchRuleDelete(Long ruleid) throws Exception;
    
    public void doBatchCxDelete(Long pid) throws Exception;
    
    /**
     * ���ء������ߡ�������Ʒ���ࡱ����������Դ���ĵѿ�����
     * @return
     * @throws Exception
     */
    public Map<VO,Object> doGetDescartesMap() throws Exception;
    /**
     * ���������ɴ��۵���Ʒ���༰����
     * @param wayId
     * @param comCategory
     * @param resids
     * @return
     * @throws Exception
     */
    public List doTieInSale(String wayId, String comCategory, List resids) throws Exception;
    
    /**
	 * ���ͣ���ǰ����������ģ��
	 * �������͵���Ʒ���������
	 * @param wayId
	 * @param comCategory
	 * @param resids
	 * @return
	 * @throws Exception
	 */
	public List doPresentingB(String wayId, String comCategory,List resids) throws Exception;
    
}

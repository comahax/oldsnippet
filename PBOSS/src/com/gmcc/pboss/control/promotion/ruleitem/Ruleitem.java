/**
 * auto-generated code
 * Fri Sep 18 18:06:45 CST 2009
 */
package com.gmcc.pboss.control.promotion.ruleitem;

import java.io.Serializable;
import java.util.Map;

import open.tool.rule.data.VO;

import com.gmcc.pboss.business.promotion.ruleitem.RuleitemDBParam;
import com.gmcc.pboss.business.promotion.ruleitem.RuleitemVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Ruleitem </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Ruleitem extends AbstractControl {
    public RuleitemVO doCreate(RuleitemVO vo) throws Exception;

    public void doRemoveByVO(RuleitemVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RuleitemVO doUpdate(RuleitemVO vo) throws Exception;

    public RuleitemVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RuleitemDBParam params) throws Exception;
    
    public String doGetInstid(String expression) throws Exception;
    
    /**
	 * ���� �������(����)����Ʒ���࣬��Դ ����Դ����
	 * @param pId ������ʶ
	 * @param ruleId  �����ʶ
	 * @return
	 * @throws Exception
	 */
    public Map<VO,Object> doSrcDataFiltering(long pId,long ruleId)throws Exception;
    /**
	 * ��׼����У��
	 * @param srcData 	��У���Դ����
	 * @param ruleId	����ID
	 * @return			����׼����У����Դ����
	 * @throws Exception
	 */
	public Map<VO,Object> doBenchmarkDataValidating(Map<VO, Object> srcData, long ruleId) throws Exception;
}

/**
 * auto-generated code
 * Mon Sep 14 14:47:12 CST 2009
 */
package com.gmcc.pboss.control.promotion.elmtinst;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import open.tool.rule.data.VO;

import com.gmcc.pboss.business.promotion.elmtinst.ElmtinstDBParam;
import com.gmcc.pboss.business.promotion.elmtinst.ElmtinstVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Elmtinst </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Elmtinst extends AbstractControl {
    public ElmtinstVO doCreate(ElmtinstVO vo) throws Exception;

    public void doRemoveByVO(ElmtinstVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ElmtinstVO doUpdate(ElmtinstVO vo) throws Exception;

    public ElmtinstVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ElmtinstDBParam params) throws Exception;
    
    /**
	 * 根据运算表达式expression 返回数据结果集
	 * 
	 * @param expression
	 * @return
	 * @throws Exception
	 */
	public Map doGetDataSet(String expression) throws Exception;
	/**
	 * 根据元素实例ID获取其所属的元素模板的相关信息
	 * @param instId
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryElmttmplByInstId(String instId) throws Exception;

	//根据模板标识获取参数信息
	public Object[] doGetParamInfo(String tmplid) throws Exception;
	
	/**
	 * 通过SQL采集方式采集数据
	 * @param sqlString
	 * @return
	 * @throws Exception
	 */
	public List<VO> doGartherDataBySQLMode(String sqlString) throws Exception;
	
	/**
	 * 通过程序采集方式采集数据
	 * @param clazzName
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<VO> doGatherDataByPGMMode(String clazzName, Object params) throws Exception;
}

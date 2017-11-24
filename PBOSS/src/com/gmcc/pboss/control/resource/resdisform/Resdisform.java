/**
 * auto-generated code
 * Fri Oct 02 10:38:11 CST 2009
 */
package com.gmcc.pboss.control.resource.resdisform;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.resdisform.ResdisformDBParam;
import com.gmcc.pboss.business.resource.resdisform.ResdisformVO;
import com.gmcc.pboss.business.resource.resdisform.ResdisformVOHelper;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Resdisform </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Resdisform extends AbstractControl {
    public ResdisformVO doCreate(ResdisformVO vo) throws Exception;

    public void doRemoveByVO(ResdisformVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ResdisformVO doUpdate(ResdisformVO vo) throws Exception;

    public ResdisformVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ResdisformDBParam params) throws Exception;
    

    /**查看商品明细
     * @param discomcode 配送商编号
     * @param disi	分配单号
     */
    public DataPackage doQueryProductDetail(String discomcode,String disi,ResdisformDBParam params) throws Exception;
    
    public String batchUpdate(String[] pk,ResdisformVOHelper voHelper,List<String> employeeID) throws Exception ;
    
    /**
     * 批量分配
     * @param item item[0]:配送商编码 item[1]:批次 item[2]:包号
     * @param ways 渠道列表
     * @param disid 分配单号
     * @param storarea 资源库区
     */
    public Map<String,String> doUpdate(String[] item,List<WayVO> ways,String disid,String storarea) throws Exception;
    
  //取得查询渠道表（CH_PW_WAY），获取渠道集合，根据渠道编码查询渠道人员基本信息表(CH_PW_EMPLOYEE)
    // 匹配是否为店主字段为是（即ISNET=1），匹配用工状态为在岗（即EMPSTATUS=0），获取店主姓名（即姓名），手机号码（即公务机号码）
    public DataPackage doQueryEmployee(ResdisformDBParam params) throws Exception;
}

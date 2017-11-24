/**
 * auto-generated code
 * Tue Sep 29 10:11:13 CST 2009
 */
package com.gmcc.pboss.control.communication.advinfo;

import java.io.File;
import java.io.Serializable;

import com.gmcc.pboss.business.communication.advinfo.AdvinfoDBParam;
import com.gmcc.pboss.business.communication.advinfo.AdvinfoVO;
import com.gmcc.pboss.business.communication.advinfo.AdvinfoVOHelper;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Advinfo </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Advinfo extends AbstractControl {
    public AdvinfoVO doCreate(AdvinfoVO vo) throws Exception;

    public void doRemoveByVO(AdvinfoVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public AdvinfoVO doUpdate(AdvinfoVO vo) throws Exception;

    public AdvinfoVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(AdvinfoDBParam params) throws Exception;
    
    public AdvinfoVO doAdvSave(AdvinfoVOHelper avHelper, File[] docs,
			String[] docFileNames, File logoFile, String logoFileName,
			String delAffixs) throws Exception;
    public void doApprovalSave(AdvinfoVOHelper avHelper) throws Exception ;
    public DataPackage doPendTaskQuery(AdvinfoDBParam params, String oprcode) throws Exception ;
    /**
     * 查找在线问答相关信息
     * @param params
     * @return
     * @throws Exception
     */
    public DataPackage doQAOnlineQuery(AdvinfoDBParam params) throws Exception ;
    public AdvinfoVO doKrSave(AdvinfoVOHelper avHelper,File[] docs,String[] docFileNames,String delAffixs,boolean createFlag) throws Exception ;
    /**
     * 根据主键删除在线学习(知识库)记录，并删除属于该在线问答(知识库)的附件
     * @param advinfoid
     * @throws Exception
     */
    public void doRemoveKrByAdvinfoid(Long advinfoid) throws Exception;
    /**
     * 删除公告信息
     * @param ids
     * @throws Exception
     */
    public void doRemoveAdvByIds(String[] ids)throws Exception;
    /**
     * 获取对象信息
     * @param form
     * @return
     * @throws Exception
     */
    public String doGetObjinfo(Long advinfoid, String desttype)throws Exception;
    
    /**
     *  
	 * 根据待办(公告信息表CH_PW_ADVINFO)的URL字段查找待办，并将该待办关联的接收对象的状态改为"已关闭"
	 * URL like '/channel/wayapply_edit.do%param._pk=xxx&form.seqid=xxx'
	 * 只有加上form.seqid=xxx的条件才能唯一确定一条待办。
     * @param pk_applyno
     * @param seqid
     * @param isWay
     * @return
     * @throws Exception
     */
    public AdvinfoVO doFinishadvinfo(Long pk_applyno,Long seqid,boolean isWay) throws Exception ;
    
    
}

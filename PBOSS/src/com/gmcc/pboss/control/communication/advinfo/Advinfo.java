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
     * ���������ʴ������Ϣ
     * @param params
     * @return
     * @throws Exception
     */
    public DataPackage doQAOnlineQuery(AdvinfoDBParam params) throws Exception ;
    public AdvinfoVO doKrSave(AdvinfoVOHelper avHelper,File[] docs,String[] docFileNames,String delAffixs,boolean createFlag) throws Exception ;
    /**
     * ��������ɾ������ѧϰ(֪ʶ��)��¼����ɾ�����ڸ������ʴ�(֪ʶ��)�ĸ���
     * @param advinfoid
     * @throws Exception
     */
    public void doRemoveKrByAdvinfoid(Long advinfoid) throws Exception;
    /**
     * ɾ��������Ϣ
     * @param ids
     * @throws Exception
     */
    public void doRemoveAdvByIds(String[] ids)throws Exception;
    /**
     * ��ȡ������Ϣ
     * @param form
     * @return
     * @throws Exception
     */
    public String doGetObjinfo(Long advinfoid, String desttype)throws Exception;
    
    /**
     *  
	 * ���ݴ���(������Ϣ��CH_PW_ADVINFO)��URL�ֶβ��Ҵ��죬�����ô�������Ľ��ն����״̬��Ϊ"�ѹر�"
	 * URL like '/channel/wayapply_edit.do%param._pk=xxx&form.seqid=xxx'
	 * ֻ�м���form.seqid=xxx����������Ψһȷ��һ�����졣
     * @param pk_applyno
     * @param seqid
     * @param isWay
     * @return
     * @throws Exception
     */
    public AdvinfoVO doFinishadvinfo(Long pk_applyno,Long seqid,boolean isWay) throws Exception ;
    
    
}

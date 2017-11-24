/**
 * auto-generated code
 * Tue Sep 29 10:26:16 CST 2009
 */
package com.gmcc.pboss.control.communication.advaffix;

import java.io.File;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.gmcc.pboss.business.communication.advaffix.AdvaffixDBParam;
import com.gmcc.pboss.business.communication.advaffix.AdvaffixVO;
import com.gmcc.pboss.business.communication.advinfo.AdvinfoVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Advaffix </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Advaffix extends AbstractControl {
    public AdvaffixVO doCreate(AdvaffixVO vo) throws Exception;

    public void doRemoveByVO(AdvaffixVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public AdvaffixVO doUpdate(AdvaffixVO vo) throws Exception;

    public AdvaffixVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(AdvaffixDBParam params) throws Exception;
    
    /**
     * ���ǹ���LOGO�����ϴ����ļ�������,���Ѹ�����Ϣ���뵽 ���渽����Ϣ��(CH_PW_ADVAFFIX)
     * @param avId
     * @param docs
     * @param docFileNames
     * @throws Exception
     */
	public void doUploadAffixs(Long avId,File[] docs,String[] docFileNames) throws Exception;
	/**
	 * �������ϴ����ļ�������,���Ѹ�����Ϣ���뵽 ���渽����Ϣ��(CH_PW_ADVAFFIX)
	 * @param aiVo
	 * @param docs
	 * @param docFileNames
	 * @param logoFile
	 * @param logoFileName
	 * @param ftpLogoFilePath
	 * @throws Exception
	 */
	public void doUploadAffixs(Long avId, File[] docs,
			String[] docFileNames, File logoFile, String logoFileName,String ftpLogoFilePath)
			throws Exception;
	
	/**
	 * ������չʾLOGO�ϴ������ط�������FTP������ ���� LOGO������Ϣ���뵽 ���渽����Ϣ��(CH_PW_ADVAFFIX)
	 * @param avId
	 * @param logoFile
	 * @param logoFileName
	 * @throws Exception
	 */
	public void doUploadLogo(Long avId,File logoFile,String logoFileName) throws Exception;
	
	/**
	 *  ���ļ������������ظ���
	 * @param filename   �����ļ���
	 * @param response
	 * @throws Exception
	 */
	public void doDownloadAffixs(String filename, HttpServletResponse response) throws Exception;
	
	//ɾ���ļ��������еĸ���,��ɾ���ļ��������еĸ���(CH_PW_ADVAFFIX)
	public void doRemoveAffixs(List<AdvaffixVO> affixsList) throws Exception;
	
    /**
     * ����advinfoid ����ɾ������
     * @param advinfoid
     * @throws Exception
     */
    public void doRemoveAffixsByAdvinfoId(Long advinfoid) throws Exception;
    
    public Collection<String> doGetTooLargerMsg(Collection<String> actionMessages) throws Exception;
}

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
     * 将非公告LOGO附件上传到文件服务器,并把附件信息插入到 公告附件信息表(CH_PW_ADVAFFIX)
     * @param avId
     * @param docs
     * @param docFileNames
     * @throws Exception
     */
	public void doUploadAffixs(Long avId,File[] docs,String[] docFileNames) throws Exception;
	/**
	 * 将附件上传到文件服务器,并把附件信息插入到 公告附件信息表(CH_PW_ADVAFFIX)
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
	 * 将公告展示LOGO上传到本地服务器和FTP服务器 并把 LOGO附件信息插入到 公告附件信息表(CH_PW_ADVAFFIX)
	 * @param avId
	 * @param logoFile
	 * @param logoFileName
	 * @throws Exception
	 */
	public void doUploadLogo(Long avId,File logoFile,String logoFileName) throws Exception;
	
	/**
	 *  从文件服务器中下载附件
	 * @param filename   下载文件名
	 * @param response
	 * @throws Exception
	 */
	public void doDownloadAffixs(String filename, HttpServletResponse response) throws Exception;
	
	//删除文件服务器中的附件,并删除文件服务器中的附件(CH_PW_ADVAFFIX)
	public void doRemoveAffixs(List<AdvaffixVO> affixsList) throws Exception;
	
    /**
     * 根据advinfoid 批量删除附件
     * @param advinfoid
     * @throws Exception
     */
    public void doRemoveAffixsByAdvinfoId(Long advinfoid) throws Exception;
    
    public Collection<String> doGetTooLargerMsg(Collection<String> actionMessages) throws Exception;
}

/**
 * auto-generated code
 * Tue Sep 29 10:26:16 CST 2009
 */
package com.gmcc.pboss.control.communication.advaffix;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.gmcc.pboss.business.communication.advaffix.AdvaffixDAO;
import com.gmcc.pboss.business.communication.advaffix.AdvaffixDBParam;
import com.gmcc.pboss.business.communication.advaffix.AdvaffixVO;
import com.gmcc.pboss.common.ftp.FtpAccess;
import com.gmcc.pboss.common.ftp.FtpInfo;
import com.gmcc.pboss.common.utils.tools.FileUtil;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: AdvaffixBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/communication/advaffix/control/AdvaffixBO"
*    name="Advaffix"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class AdvaffixBO extends AbstractControlBean implements
		Advaffix {

	public AdvaffixVO doCreate(AdvaffixVO vo) throws Exception {
		try {
			AdvaffixDAO dao = (AdvaffixDAO) DAOFactory.build(AdvaffixDAO.class, user);
			// TODO set the pk */
			return (AdvaffixVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(AdvaffixVO vo) throws Exception {
		try {
			AdvaffixDAO dao = (AdvaffixDAO) DAOFactory.build(AdvaffixDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			AdvaffixDAO dao = (AdvaffixDAO) DAOFactory.build(AdvaffixDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AdvaffixVO doUpdate(AdvaffixVO vo) throws Exception {
		try {
			AdvaffixDAO dao = (AdvaffixDAO) DAOFactory.build(AdvaffixDAO.class,user);
			return (AdvaffixVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AdvaffixVO doFindByPk(Serializable pk) throws Exception {
		AdvaffixDAO dao = (AdvaffixDAO) DAOFactory.build(AdvaffixDAO.class,user);
		return (AdvaffixVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(AdvaffixDBParam params)
			throws Exception {
		AdvaffixDAO dao = (AdvaffixDAO) DAOFactory.build(AdvaffixDAO.class,user);
		return dao.query(params);
	}
	
	/**
	 * <p>将非公告LOGO附件上传到文件服务器,并把附件信息插入到公告附件信息表(CH_PW_ADVAFFIX)</p>
	 * @since 2010-01-14  修改为：上传到FTP服务器
	 */
	public void doUploadAffixs(Long avId,File[] docs,String[] docFileNames) throws Exception{
		this.doUploadAffixs(avId, docs, docFileNames, null, null,null);
	}
	
	public void doUploadAffixs(Long avId, File[] docs, String[] docFileNames,
			File logo, String logoFileName,String ftpLogoFilePath) throws Exception {
		
		if(docs == null && logo == null)
			return;
		
		FtpInfo fi = FtpInfo.getInstance();
		FtpAccess fa = null;
		try {
			fa = new FtpAccess(fi);
			// 上传非公告LOGO附件
			for(int i=0;docs!=null && i<docs.length;i++) {
				try {
					String destFilePath = FileUtil.genFileName(docFileNames[i]);
					
					// 向 公告附件信息表（CH_PW_ADVAFFIX）插入信息
					AdvaffixVO afVo = new AdvaffixVO();
					afVo.setAdvinfoid(avId);
					String affixName = docFileNames[i];
					afVo.setAffixname(affixName);
					afVo.setAffixpath(destFilePath);
					doCreate(afVo);
					
					fa.doUploadFile(docs[i],destFilePath, "");
					
				}catch(Exception ex) {
					throw ex;
				}
			}
			// 上传公告LOGO附件
			if(logo != null) {
				try {
					String httpDestFilePath = FileUtil.createFilename(ftpLogoFilePath,false);
					File httpDestFile = new File(httpDestFilePath);
					
					// 向 公告附件信息表（CH_PW_ADVAFFIX）插入信息
					AdvaffixVO afVo = new AdvaffixVO();
					afVo.setAdvinfoid(avId);
					String affixName = logoFileName;
					afVo.setAffixname(affixName);
					afVo.setAffixpath(ftpLogoFilePath);
					doCreate(afVo);
					
					// 上传到本地http服务器
					FileUtil.copy(logo, httpDestFile);
					// 上传到FTP服务器
					fa.doUploadFile(logo,ftpLogoFilePath, "");
					
				}catch(Exception ex) {
					throw ex;
				}
			}
			
		}catch(Exception ex) {
			throw new JOPException(ex.getMessage());
		}finally {
			try {
				if (fa != null && fa.ftp != null) {
					fa.ftp.logout();
					fa.ftp.disconnect();
		        }
			}catch(Exception ex) {
                 throw new JOPException("[FTP-MSG]\t断开ftp服务器连接失败:" + ex.getMessage());
			}
		}
	}
	
	public void doUploadLogo(Long avId, File logoFile, String logoFileName)
			throws Exception {
		if(logoFile == null || logoFileName == null || "".equals(logoFileName)) 
			return;
		FtpInfo fi = FtpInfo.getInstance();
		FtpAccess fa = null;
		try {
			fa = new FtpAccess(fi);
			try {
				String ftpDestFilePath = FileUtil.genFileName(logoFileName);
				String httpDestFilePath = FileUtil.createFilename(ftpDestFilePath,false);
				File httpDestFile = new File(httpDestFilePath);
				
				// 向 公告附件信息表（CH_PW_ADVAFFIX）插入信息
				AdvaffixVO afVo = new AdvaffixVO();
				afVo.setAdvinfoid(avId);
				String affixName = logoFileName;
				afVo.setAffixname(affixName);
				afVo.setAffixpath(ftpDestFilePath);
				doCreate(afVo);
				
				// 上传到本地http服务器
				FileUtil.copy(logoFile, httpDestFile);
				// 上传到FTP服务器
				fa.doUploadFile(logoFile,ftpDestFilePath, "");
				
			}catch(Exception ex) {
				throw ex;
			}
			
		}catch(Exception ex) {
			throw new JOPException(ex.getMessage());
		}finally {
			try {
				if (fa != null && fa.ftp != null) {
					fa.ftp.logout();
					fa.ftp.disconnect();
		        }
			}catch(Exception ex) {
                 throw new JOPException("[FTP-MSG]\t断开ftp服务器连接失败:" + ex.getMessage());
			}
		}
	}

	public void doDownloadAffixs(String filename,
			HttpServletResponse response) throws Exception {
		try {
			FtpInfo ftpInfo = FtpInfo.getInstance();
			FtpAccess.doDownloadFile(ftpInfo, filename, response);
		}catch(Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}

	//删除文件服务器中的附件,并删除库表中的附件记录(CH_PW_ADVAFFIX)
	public void doRemoveAffixs(List<AdvaffixVO> affixsList) throws Exception {
		
		if(affixsList == null || affixsList.size() <= 0) return;
		FtpInfo fi = FtpInfo.getInstance();
		FtpAccess fa = null;
		try {
			fa = new FtpAccess(fi);
			for(AdvaffixVO advaffixVO : affixsList) {
				//删除附件表中的附件信息
				doRemoveByPK(advaffixVO.getAffixid());
				
				//删除文件服务器中的附件
				String affixpath = advaffixVO.getAffixpath();
				fa.deleteFilename(affixpath);
			}
		}catch(Exception ex) {
			throw new JOPException(ex);
		}finally {
			try {
				if (fa.ftp != null) {
					fa.ftp.logout();
					fa.ftp.disconnect();
		        }
			}catch(Exception ex) {
                 throw new JOPException("[FTP-MSG]\t断开ftp服务器连接失败:" + ex.getMessage());
			}
		}
	}

	public void doRemoveAffixsByAdvinfoId(Long advinfoid) throws Exception {
		try {
			AdvaffixDAO dao = (AdvaffixDAO) DAOFactory.build(AdvaffixDAO.class,user);
			dao.deleteAffixsByAdvinfoId(advinfoid);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
	
	//获取附件超出大小提示信息
	public Collection<String> doGetTooLargerMsg(Collection<String> actionMessages) throws Exception{
		Iterator<String> iter = actionMessages.iterator();
		String msg = iter.next();
		if(msg.startsWith("@"))
		{
			String msgInfo = msg.substring(1,msg.length());
			String[] msgArray = msgInfo.split("\\|");
			String actionMessage= "上传文件：《" + msgArray[0] + "》大小不得超过" + Math.floor(Double.valueOf(msgArray[3])/1048576) + "M";
			List<String> actionMessagesTrans = new ArrayList<String>();
			actionMessagesTrans.add(actionMessage);
			return actionMessagesTrans;
		}
		return actionMessages;
	}
	
}

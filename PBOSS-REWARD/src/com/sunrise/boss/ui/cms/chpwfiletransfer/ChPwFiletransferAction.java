/**
* auto-generated code
* Thu Jul 03 15:10:27 CST 2014
*/
package com.sunrise.boss.ui.cms.chpwfiletransfer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.beans.BeanUtils;

import com.sunrise.boss.business.cms.chpwfiletransfer.persistent.ChPwFiletransferListVO;
import com.sunrise.boss.business.cms.chpwfiletransfer.persistent.ChPwFiletransferVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.cms.chpwfiletransfer.ChPwFiletransferDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.ftp.FtpAccess;
import com.sunrise.boss.ui.commons.ftp.FtpBusUtils;
import com.sunrise.boss.ui.commons.ftp.FtpInfo;
import com.sunrise.boss.ui.resmanage.common.ResPubUtil;

/**
 * <p>Title: ChPwFiletransferAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPwFiletransferAction   extends BaseAction {
    public ChPwFiletransferAction() {
            setVoClass(ChPwFiletransferVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
    
    //��ѯ
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception { 
    	ChPwFiletransferForm tform=(ChPwFiletransferForm)actionForm;
    	//Ĭ��Ϊϵͳ��ǰʱ��ǰһ��
    	Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//yyyy-mm-dd hh:mm:ss
    	if (tform.get_dnl_datadate() == null || "".equals(tform.get_dnl_datadate())) {
    		
    		tform.set_dnl_datadate(df.format(calendar.getTime()));
    	}
    	//Ĭ��Ϊϵͳ��ǰʱ��ǰһ��
    	if (tform.get_dnm_datadate() == null || "".equals(tform.get_dnm_datadate())) {
    		tform.set_dnm_datadate(df.format(calendar.getTime()));
    	}
    	//������ѯstats=1
    	ChPwFiletransferListVO listVO = new ChPwFiletransferListVO ();
    	ArrayList list = new ArrayList();
//		list.add(SessionFactoryRouter.conversionCityid(user.getCityid()));
//		list.add("GD");
//    	listVO.set_sin_cityid(list);
    	setListVO(listVO, tform);
    	listVO.set_ne_state("1");
    	ChPwFiletransferDelegate delegate = new ChPwFiletransferDelegate();
    	DataPackage dp = delegate.doQuery(listVO, user);
    	 List  data = (List)dp.getDatas();
//    	 ChPwFiletransferVO vo = null;
//    	for (int i = 0; i < data.size() ;) {
//			vo = (ChPwFiletransferVO)data.get(i);
//			//��·���е�@cityid@/@yyymm@�滻�ųɵ�ǰ��¼���Ŷ�Ӧ�ĵ��м�ҳ����������·ݡ�
//			String filepath = vo.getFilepath();
//			filepath = filepath.replace("@CITYID@", vo.getCityid());
//			filepath = filepath.replace("@cityid@", vo.getCityid().toLowerCase());
//			filepath = filepath.replace("@CITYCODE@", SessionFactoryRouter.conversionCityid2Num(vo.getCityid()));
//			
//			FtpInfo ftpInfo =null;
//			User user1= new User();
//	    	user1 = user;
////	    	BeanUtils.copyProperties(user1, user);
//	    	
//	    	user1.setCityid(SessionFactoryRouter.conversionCityid2Num(vo.getCityid()));
//	    	
//			ftpInfo = ResPubUtil.getFtpInfo(user1); 
//			FtpAccess ftp = new FtpAccess(ftpInfo);
//	    	String localPath = FtpBusUtils.getDownloadRealPath(servlet);
//			ftp.ftp.setFileType(ftp.ftp.BINARY_FILE_TYPE);
//			localPath = ftp.downloadFile(localPath, filepath);
//			if (localPath == null) {
//				dp.getDatas().remove(vo);
//			} else{
//				i++;
//			}
//		} 
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp); 
		return actionMapping.findForward("list");
	
	
	}
    //�������� 
    public ActionForward doDownload(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception { 
		 
		ChPwFiletransferForm tform=(ChPwFiletransferForm)actionForm;  
		ChPwFiletransferDelegate delegate = new ChPwFiletransferDelegate();
		ChPwFiletransferVO vo = new ChPwFiletransferVO();
		try { 
			//ͨ��������ѯ�����������ص��ļ�·��
			vo = delegate.doFindByPk(tform.getSeq(), user);
			if( null != vo.getFilepath() || !("").equals(vo.getFilename())){ 
			//��·���е�@cityid@/@yyymm@�滻�ųɵ�ǰ��¼���Ŷ�Ӧ�ĵ��м�ҳ����������·ݡ�
			String filepath = vo.getFilepath();
			filepath = filepath.replace("@CITYID@", vo.getCityid());
			filepath = filepath.replace("@cityid@", vo.getCityid().toLowerCase());
			filepath = filepath.replace("@CITYCODE@", SessionFactoryRouter.conversionCityid2Num(vo.getCityid()));
			
			FtpInfo ftpInfo =null;
			User user1= new User();
	    	user1 = user;
//	    	BeanUtils.copyProperties(user1, user);
	    	
	    	user1.setCityid(SessionFactoryRouter.conversionCityid2Num(vo.getCityid()));
	    	
			ftpInfo = ResPubUtil.getFtpInfo(user1); 
			FtpAccess ftp = new FtpAccess(ftpInfo);
			String localPath = FtpBusUtils.getDownloadRealPath(servlet);
			ftp.ftp.setFileType(ftp.ftp.BINARY_FILE_TYPE);
			localPath = ftp.downloadFile(localPath, filepath);
			if (localPath == null) {
				throw new Exception("�������ļ������ڣ�����ʧ�ܣ�" + ftp.ftp.getReplyString());
			}
			request.setAttribute("filename", FtpBusUtils.getDownloadFilename(
					servlet, filepath.trim()));
			}
		}catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
			return doList(actionMapping, actionForm, request, response, user);
		}
		return actionMapping.findForward("down");
	}
	
    //�����������           
    public ActionForward doDownloadall(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception { 
		 
		ChPwFiletransferForm tform=(ChPwFiletransferForm)actionForm;  
		ChPwFiletransferDelegate delegate = new ChPwFiletransferDelegate();
		ChPwFiletransferVO vo = new ChPwFiletransferVO();
    	
		try { 
			String[] str = tform.get_selectitem();
			List fileArray = new ArrayList();
			for (int i=0;i<str.length;i++){
				vo = delegate.doFindByPk(getDeletePK(str[i]), user);
				//ѭ��ͨ��������ѯ�����������ص��ļ�·�� 
				if( null != vo.getFilepath() || !("").equals(vo.getFilename())){ 
					//��·���е�@cityid@/@yyymm@�滻�ųɵ�ǰ��¼���Ŷ�Ӧ�ĵ��м�ҳ����������·ݡ�
					String filepath = vo.getFilepath();
					filepath = filepath.replace("@CITYID@", vo.getCityid());
					filepath = filepath.replace("@cityid@", vo.getCityid().toLowerCase());
					filepath = filepath.replace("@CITYCODE@", SessionFactoryRouter.conversionCityid2Num(vo.getCityid()));
					
					FtpInfo ftpInfo =null;
					User user1= new User();
			    	user1 = user;
//			    	BeanUtils.copyProperties(user1, user);
			    	
			    	user1.setCityid(SessionFactoryRouter.conversionCityid2Num(vo.getCityid()));
			    	
					ftpInfo = ResPubUtil.getFtpInfo(user1); 
					FtpAccess ftp = new FtpAccess(ftpInfo);
					String localPath = FtpBusUtils.getDownloadRealPath(servlet);
					ftp.ftp.setFileType(ftp.ftp.BINARY_FILE_TYPE);
					localPath = ftp.downloadFile(localPath, filepath);
					if (localPath == null) {
						throw new Exception("�������ļ������ڣ�����ʧ�ܣ�" + ftp.ftp.getReplyString());
					}
					fileArray.add(new File(localPath));
				}
			}
			DateFormat df = new SimpleDateFormat("yyyyMMdd");
	    	
			String zipPath = FtpBusUtils.getDownloadRealPath(servlet);
			String zipName = zipPath + "�ļ���ת_"+df.format(new Date())+".zip";
			zipFile(fileArray, zipName);
			request.setAttribute("filename", zipName);
		}catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
			return doList(actionMapping, actionForm, request, response, user);
		}
		return actionMapping.findForward("down");
	}
    
    public void zipFile(List fileArray, String zipName) throws Exception {
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipName));
		ZipEntry zipEntry = null;
		byte[] buf = new byte[1024];
		int readLen = 0;
		for (int i = 0; i < fileArray.size(); i++) {
			File file = (File) fileArray.get(i);
			zipEntry = new ZipEntry(file.getName());
			zos.putNextEntry(zipEntry);
			InputStream is = new BufferedInputStream(new FileInputStream(file));
			while ((readLen = is.read(buf, 0, 1024)) != -1) {
				zos.write(buf, 0, readLen);
			}
			zos.setEncoding("GBK");
			is.close();
			file.delete();
		}
		zos.close();
	}
}

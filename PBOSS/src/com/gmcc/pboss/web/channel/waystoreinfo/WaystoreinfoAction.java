package com.gmcc.pboss.web.channel.waystoreinfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.channel.waystoreinfo.VwaystoreinfoVo;
import com.gmcc.pboss.business.channel.waystoreinfo.WaystoreinfoDBParam;
import com.gmcc.pboss.business.channel.waystoreinfo.WaystoreinfoVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.ftp.FtpAccess;
import com.gmcc.pboss.common.ftp.FtpBusUtils;
import com.gmcc.pboss.common.ftp.FtpInfo;
import com.gmcc.pboss.control.channel.waystoreinfo.Waystoreinfo;
import com.gmcc.pboss.control.channel.waystoreinfo.WaystoreinfoBO;
import com.sunrise.jop.common.utils.lang.InterfaceUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.filter.PermissionChecker;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: WaystoreinfoAction </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class WaystoreinfoAction extends BaseAction{
	
	private String remotepath = "waystoreinfo";
	private String CH_WAYSTORE_PRO = "CH_WAYSTORE_PRO";//���в�ѯʡ��˾Ȩ������
	private String CH_WAYSTORE_CITY = "CH_WAYSTORE_CITY";//���в�ѯ�й�˾Ȩ������
	public boolean hasFlag;// �жϵ��й�˾��ѯȨ�� 
	private boolean isQuery;//�Ƿ�ͳ�Ʊ�ʶ��Ĭ�ϲ���ѯ
	
	private File zqPic;
	private File doorPic;
	private String zqPicFileName;
	private String doorPicFileName;
	private String zqPicType;
	private String doorPicType;
	private File[] doc;
	private String[] docFileName;

	
	public WaystoreinfoAction() {
		super();

		this.setForm(new WaystoreinfoForm());
		this.setParam(new WaystoreinfoDBParam());

        setClsVO(WaystoreinfoVO.class);
        this.pkNameArray=new String[]{"wayid"};
		this.setClsControl(Waystoreinfo.class);
		this.setClsQueryParam(WaystoreinfoDBParam.class) ;

	} 
	
	//��ѯ
	public String doList() throws Exception{
		
		DBAccessUser user = this.getDBAccessUser();
		PermissionChecker checker = (PermissionChecker) InterfaceUtils.getInstance().createImplObject(PermissionChecker.class);
		hasFlag = checker.checkPermission(user.getOprcode(), CH_WAYSTORE_PRO);
		WaystoreinfoDBParam waystoreinfoDBParam = (WaystoreinfoDBParam) getParam();
		Waystoreinfo waystoreinfo = (Waystoreinfo) BOFactory.build(WaystoreinfoBO.class, user);
		if (hasFlag) {
			String cityid = waystoreinfoDBParam.get_se_cityid();
			if (null != cityid || !("").equals(cityid)) {
				if (("GD").equals(cityid) || ("DB_COMMON").equals(cityid)) {
					waystoreinfoDBParam.set_se_cityid("");
				}
			}
		}else{
			waystoreinfoDBParam.set_se_cityid(user.getCityid());
		}
		DataPackage dP = waystoreinfo.doWaystoreinfoList(waystoreinfoDBParam);
		this.setDp(dP);
		return WEB_RESULT_LIST;
	}

	// ����
	public String doSave() throws Exception {  
		
		 HttpServletResponse response = ServletActionContext.getResponse();
		 HttpServletRequest request = ServletActionContext.getRequest();
		 response.setCharacterEncoding("UTF-8");
		 request.setCharacterEncoding("UTF-8");
		 String path =request.getSession().getServletContext().getRealPath("\\")+ "upload\\";
		 String path1 =request.getSession().getServletContext().getRealPath("\\")+ "upload\\";
		 WaystoreinfoForm form = (WaystoreinfoForm) getForm();
		 Waystoreinfo  waystoreinfo = ( Waystoreinfo) BOFactory.build( WaystoreinfoBO.class, getDBAccessUser());
		 DBAccessUser user = this.getDBAccessUser();
		 
		 WaystoreinfoVO waystoreinfoVO = waystoreinfo.doFindByPk(getSelectedPK(form.getWayid()));
			form.setCityid(user.getCityid());
			form.setCreatetime(new Date()); 
			if(zqPicFileName == null){
				if(waystoreinfoVO.getZqpic()==null || "".equals(waystoreinfoVO.getZqpic())){
					setActionMessage("ר����Ƭ����Ϊ�գ���ѡ��");
					form.setDoorpic(null);
					form.setDoorpicpath(null);
					return WEB_RESULT_CONTENT;
				}else{
					form.setZqpic(waystoreinfoVO.getZqpic());
					form.setZqpicpath(waystoreinfoVO.getZqpicpath());
				}
			}else{
				form.setZqpic(zqPicFileName);
			}
			if(doorPicFileName == null){
				if(waystoreinfoVO.getDoorpic()==null || "".equals(waystoreinfoVO.getDoorpic())){
					setActionMessage("��ͷ��Ƭ����Ϊ�գ���ѡ��");
					form.setZqpic(null);
					form.setZqpicpath(null);
					 return WEB_RESULT_CONTENT;
				}else{
					form.setDoorpic(waystoreinfoVO.getDoorpic());
					form.setDoorpicpath(waystoreinfoVO.getDoorpicpath());
					
				}
			}else{
				form.setDoorpic(doorPicFileName);
			}
			
		 if(zqPic==null){
		 }else{
			 try {
				 // �µ��ϴ��ļ���·��
				 
				 String [] arr =zqPicFileName.split("\\.");
				 String wayid=form.getWayid();
//				 �޸���Ƭ�����֣���������+zqPic
				 zqPicFileName = wayid+"_ZQ."+arr[1];
				 path = createFilename(arr[0], "."+arr[1]);
				 if("jpg".equals(arr[1])||"JPG".equals(arr[1])){
					 
					 FileInputStream stream = new FileInputStream(zqPic);
					 int i=stream.available();
					 if(i>3*1024*1024){
						 setActionMessage("ר����Ƭ��С���ܳ���3M��������ѡ��");
						 return WEB_RESULT_CONTENT;
					 }else{
							FtpInfo ftpInfo = FtpInfo.getInstance();
							FtpAccess ftp = new FtpAccess(ftpInfo);
							String compact = ftp.uploadFile2(this.zqPic,
									remotepath, true,zqPicFileName);
							form.setZqpicpath(compact);
/*						 OutputStream bos = new FileOutputStream(path);
						 int bytesRead = 0;
						 byte[] buffer = new byte[8192];
						 while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
							 bos.write(buffer, 0, bytesRead);
						 }
						 bos.close();*/
						 stream.close();
					 }
				 }else{
					 setActionMessage("ר����Ƭ����ֻ��Ϊjpg��������ѡ��");
					 return WEB_RESULT_CONTENT;
				 }
			 } catch (FileNotFoundException fnfe) {
				 throw new Exception("�ϴ��ļ�����Ϊ��!");
			 } catch (IOException ioe) {
				 throw new Exception("�ļ���д����!");
			 } catch (Exception e) {
				 throw e;
			 }
		 }
			
		if(doorPic==null){
		}else{
			try {
				// �µ��ϴ��ļ���·��
				String [] arr =doorPicFileName.split("\\.");
				String wayid=form.getWayid();
//				�޸���Ƭ�����֣���������+doorPic
				doorPicFileName = wayid+"_MT."+arr[1];
				path1 = createFilename(arr[0], "."+arr[1]);
				if("jpg".equals(arr[1])||"JPG".equals(arr[1])){
					FileInputStream stream = new FileInputStream(doorPic);
					int i=stream.available();
					if(i>3*1024*1024){
						 setActionMessage("��ͷ��Ƭ��С���ܳ���3M��������ѡ��");
						 return WEB_RESULT_CONTENT;
					 }else{
							FtpInfo ftpInfo = FtpInfo.getInstance();
							FtpAccess ftp = new FtpAccess(ftpInfo);
							String compact = ftp.uploadFile2(this.doorPic,
									remotepath, true,doorPicFileName);
							form.setDoorpicpath(compact);
						 
/*						 OutputStream bos = new FileOutputStream(path1);
						 int bytesRead = 0;
						 byte[] buffer = new byte[8192];
						 while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
							 bos.write(buffer, 0, bytesRead);
						 }
						 bos.close();*/
						 stream.close();
					 }
				}else{
					 setActionMessage("��ͷ��Ƭ����ֻ��Ϊjpg��������ѡ��");
					 return WEB_RESULT_CONTENT;
				}
			} catch (FileNotFoundException fnfe) {
				throw new Exception("�ϴ��ļ�����Ϊ��!");
			} catch (IOException ioe) {
				throw new Exception("�ļ���д����!");
			} catch (Exception e) {
				throw e;
			}
		}

			super.doSave();
		
		return WEB_RESULT_CONTENT;
	}
	
	
	 protected String createFilename(String opercode, String contentType) throws Exception {
			String type = contentType;
			/*if ("application/vnd.ms-excel".equals(contentType)) {
				type = ".xls";
			}*/
			String location = FtpInfo.getUpload();
			if (location == null || location.equals("")) {
				throw new Exception("����ļ�·������,�����coreconfiginfo.properties��uploadlocation������!");
			}
			String head = opercode;
			Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
			calendar.setTime(new Date());
			if (head == null || head.equals("")) {
				head = "pboss_";
			} else {
				head += "_";
			}
			String filename = opercode ;//+ (calendar.get(Calendar.YEAR) + 1900) + calendar.get(Calendar.MARCH) + calendar.get(Calendar.DATE) + calendar.get(Calendar.HOUR)
					//+ calendar.get(Calendar.MINUTE) + calendar.get(Calendar.SECOND) + (new java.util.Random()).nextInt(99);

			// String webappPath = getServlet().getInitParameter("uplocation");
			int strLength = location.length();
			String pathSeperator = location.substring(strLength - 1, strLength);
			location = ServletActionContext.getServletContext().getRealPath(location);
			if (!location.endsWith(pathSeperator)) {
				location = location + pathSeperator;
			}
			location = location.replace('\\', '/');
			String file = location + filename + type;
			java.io.File f = new java.io.File(location);
			if (f.exists()) {
				return file;
			} else {
				throw new Exception("����ļ�·������,�����coreconfiginfo.properties��uploadlocation������!");
			}
		}
	 
	//����
	public String doNew() throws Exception{ 
		this.CMD = WEB_CMD_NEW;
		return WEB_RESULT_CONTENT;
	};
	
	 //ɾ��
	public String doDelete() throws Exception{
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		Waystoreinfo waystoreinfo = (Waystoreinfo) BOFactory.build(WaystoreinfoBO.class, getDBAccessUser());
		for (int i = 0; i < selectArray.length; i++) { 
			waystoreinfo.doRemoveByPK(selectArray[i]);
		}
		return doList();
	}
	
 
	//����
	public String doExportExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		export.setFileName("�ŵ�������Ϣ����"); 
		export.addOutputProperty("wayid", "�ŵ����");
		export.addOutputProperty("wayid", "�ŵ�����",export.CODE2NAME,"#WAY");
		export.addOutputProperty("latitude", "������");
		export.addOutputProperty("longtitude", "����γ��");
		export.addOutputProperty("cityid", "���й�˾",export.CODE2NAME, "#CITYCOMPANY");
		export.addOutputProperty("area", "���(ƽ��)");
		export.addOutputProperty("zqtype", "ר������",export.CODE2NAME,"$CH_WAYSTORETYPE");
		
		
		export.addOutputProperty("zqarea", "ר�����");
		export.addOutputProperty("zqpanel", "ר������",export.CODE2NAME,"$CH_YESORNO1");
		export.addOutputProperty("zqcupboard", "ר��ר�񣨸���");
		export.addOutputProperty("zqcards", "ר�����ƣ�����");
		export.addOutputProperty("zqpricetag", "ר����ǩ������");
		export.addOutputProperty("zqrack", "ר��չ�ܣ�����");
       
		export.addOutputProperty("zqinad", "ר�����ں��",export.CODE2NAME,"$CH_YESORNO1");
		export.addOutputProperty("zqoutad", "ר��������",export.CODE2NAME,"$CH_YESORNO1");
		export.addOutputProperty("zqhead", "ר����ͷ",export.CODE2NAME,"$CH_YESORNO1");
		export.addOutputProperty("zqpaste", "ר������",export.CODE2NAME,"$CH_YESORNO1");
		export.addOutputProperty("zqtablecard", "ר������̨�Ƶ�λ������");
		export.addOutputProperty("zqdecca", "ר������̨����λ������");
		
		export.addOutputProperty("zqbill", "ר������");
		export.addOutputProperty("doorpic", "��ͷ��Ƭ");
		export.addOutputProperty("doortype", "��ͷ����",export.CODE2NAME,"$CH_DOORTYPE");
		export.addOutputProperty("outwallad", "��ǽ��������С��ƽ�ף�");
		export.addOutputProperty("outwallpic", "��ǽ��������������λ������");
		export.addOutputProperty("tdmonopoly", "�ն�רӪ",export.CODE2NAME,"$CH_YESORNO2");
		export.addOutputProperty("busimonopoly", "ҵ��רӪ",export.CODE2NAME,"$CH_YESORNO2");
		export.addOutputProperty("storeconduct", "����λ������1ƽ�����ϣ�������");
		export.addOutputProperty("modulus", "ϵ��");  
		
		// ����VO��
		export.voClassArray = new Class[] { VwaystoreinfoVo.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doList";
		WaystoreinfoDBParam params = (WaystoreinfoDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	// Picbatch
	public String doPicbatch() throws Exception {  
		
		 HttpServletResponse response = ServletActionContext.getResponse();
		 HttpServletRequest request = ServletActionContext.getRequest();
		 response.setCharacterEncoding("UTF-8");
		 request.setCharacterEncoding("UTF-8");
		 String path =request.getSession().getServletContext().getRealPath("\\")+ "upload\\";
		 DBAccessUser user = this.getDBAccessUser();
		 Waystoreinfo waystoreinfo = (Waystoreinfo) BOFactory.build(WaystoreinfoBO.class, user);
		 
		 for(int i=0;i<doc.length;i++){
			 try {
					// �µ��ϴ��ļ���·��
				 	String [] arr =docFileName[i].split("\\.");
				 	path = createFilename(arr[0], "."+arr[1]);
				 	
				 	if("jpg".equals(arr[1])||"JPG".equals(arr[1])){
				 		String [] arr1 = arr[0].split("_");
				 		if(arr1.length!=2){
							 setActionMessage(docFileName[i]+"��Ƭ��ʽ����ȷ��������ѡ��");
							 return "error";
				 		}
				 		
				 		WaystoreinfoVO fvo =waystoreinfo.doFindByPk(arr1[0]);
				 		if(fvo==null){
							 setActionMessage(docFileName[i]+"�ŵ���벻��ȷ��������ѡ��");
							 return "error";
				 		}
				 		if(arr1[1].equals("ר����Ƭ")){
				 			fvo.setZqpic(docFileName[i]);
				 		}else if(arr1[1].equals("��ͷ��Ƭ")){
				 			fvo.setDoorpic(docFileName[i]);
				 		}else{
							 setActionMessage(docFileName[i]+"��Ƭ��׺����ȷ��������ѡ��");
							 return "error";
				 		}
				 		
				 		FileInputStream stream = new FileInputStream(doc[i]);
				 		int ii=stream.available();
						if(ii>3*1024*1024){
							 setActionMessage(docFileName[i]+"��Ƭ��С���ܳ���3M��������ѡ��");
							 return "error";
						 }else{
							 if(arr1[1].equals("ר����Ƭ")){
							 docFileName[i]=arr1[0]+"_ZQ."+arr[1];
							 }else if(arr1[1].equals("��ͷ��Ƭ")){
								 docFileName[i]=arr1[0]+"_MT."+arr[1];
								 //System.out.println("eeeeee==:"+arr[1]);
								 //System.out.println("---- docFileName:"+ docFileName[i]);
						 		}
								FtpInfo ftpInfo = FtpInfo.getInstance();
								FtpAccess ftp = new FtpAccess(ftpInfo);
								String compact = ftp.uploadFile2(this.doc[i],
										remotepath, true, docFileName[i]);
						 		if(arr1[1].equals("ר����Ƭ")){
						 			fvo.setZqpicpath(compact);
						 		}else if(arr1[1].equals("��ͷ��Ƭ")){
						 			fvo.setDoorpicpath(compact);
						 		}
						 		waystoreinfo.doUpdate(fvo);
						 		
/*							 OutputStream bos = new FileOutputStream(path);
							 int bytesRead = 0;
							 byte[] buffer = new byte[8192];
							 while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
								 bos.write(buffer, 0, bytesRead);
							 }
							 bos.close();*/
							 stream.close();
						 }
				 	}else{
						setActionMessage("��Ƭ����ֻ��Ϊjpg��������ѡ��");
						return "error";
				 	}
				} catch (FileNotFoundException fnfe) {
					throw new Exception("�ϴ��ļ�����Ϊ��!");
				} catch (IOException ioe) {
					throw new Exception("�ļ���д����!");
				} catch (Exception e) {
					throw e;
				}
			 
		 }
		 setActionMessage("�����ɹ���");
		return "error";
	}

	//�����ļ��ϴ�
	public String doDownload() throws Exception{
			try {
				HttpServletRequest request=ServletActionContext.getRequest(); 
				String url = request.getParameter("file");
				// �ļ�����������ת��
				String result = new String(url.getBytes("iso-8859-1"), "gb2312");
				url = result;
				FtpAccess ftpAccess = new FtpAccess(FtpInfo.getInstance());
				String localPath =ServletActionContext.getServletContext().getRealPath("/") ;
				System.out.println("----->localPath��" + localPath + "\n" + "----->url��" + url);
				//localPath="D:\\yl\\123";
				String file = ftpAccess.downloadFile(localPath, url);
				if (file == null) {
					throw new Exception("����ʧ�ܣ�");
				}
				request.setAttribute("filename", FtpBusUtils.getFilenameFromPath(url));
			} catch (Exception ex) {
				ex.printStackTrace();
				super.addActionError(ex.getMessage());
			}
			return "download";
	}
	
	public boolean getHasFlag() {
		return hasFlag;
	}

	public void setHasFlag(boolean hasFlag) {
		this.hasFlag = hasFlag;
	}

	public boolean getIsQuery() {
		return isQuery;
	}

	public void setIsQuery(boolean isQuery) {
		this.isQuery = isQuery;
	}

	public File getZqPic() {
		return zqPic;
	}

	public void setZqPic(File zqPic) {
		this.zqPic = zqPic;
	}

	public File getDoorPic() {
		return doorPic;
	}

	public void setDoorPic(File doorPic) {
		this.doorPic = doorPic;
	}

	public String getZqPicFileName() {
		return zqPicFileName;
	}

	public void setZqPicFileName(String zqPicFileName) {
		this.zqPicFileName = zqPicFileName;
	}

	public String getDoorPicFileName() {
		return doorPicFileName;
	}

	public void setDoorPicFileName(String doorPicFileName) {
		this.doorPicFileName = doorPicFileName;
	}

	public String getZqPicType() {
		return zqPicType;
	}

	public void setZqPicType(String zqPicType) {
		this.zqPicType = zqPicType;
	}

	public String getDoorPicType() {
		return doorPicType;
	}

	public void setDoorPicType(String doorPicType) {
		this.doorPicType = doorPicType;
	}

	public File[] getDoc() {
		return doc;
	}

	public void setDoc(File[] doc) {
		this.doc = doc;
	}

	public String[] getDocFileName() {
		return docFileName;
	}

	public void setDocFileName(String[] docFileName) {
		this.docFileName = docFileName;
	}

	
}
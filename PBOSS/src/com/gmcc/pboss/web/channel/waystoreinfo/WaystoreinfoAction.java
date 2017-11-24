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
	private String CH_WAYSTORE_PRO = "CH_WAYSTORE_PRO";//地市查询省公司权限令牌
	private String CH_WAYSTORE_CITY = "CH_WAYSTORE_CITY";//地市查询市公司权限令牌
	public boolean hasFlag;// 判断地市公司查询权限 
	private boolean isQuery;//是否统计标识，默认不查询
	
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
	
	//查询
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

	// 保存
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
					setActionMessage("专区照片不能为空，请选择！");
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
					setActionMessage("门头照片不能为空，请选择！");
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
				 // 新的上传文件名路径
				 
				 String [] arr =zqPicFileName.split("\\.");
				 String wayid=form.getWayid();
//				 修改相片的名字：渠道名称+zqPic
				 zqPicFileName = wayid+"_ZQ."+arr[1];
				 path = createFilename(arr[0], "."+arr[1]);
				 if("jpg".equals(arr[1])||"JPG".equals(arr[1])){
					 
					 FileInputStream stream = new FileInputStream(zqPic);
					 int i=stream.available();
					 if(i>3*1024*1024){
						 setActionMessage("专区照片大小不能超过3M，请重新选择！");
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
					 setActionMessage("专区照片类型只能为jpg，请重新选择！");
					 return WEB_RESULT_CONTENT;
				 }
			 } catch (FileNotFoundException fnfe) {
				 throw new Exception("上传文件不能为空!");
			 } catch (IOException ioe) {
				 throw new Exception("文件读写错误!");
			 } catch (Exception e) {
				 throw e;
			 }
		 }
			
		if(doorPic==null){
		}else{
			try {
				// 新的上传文件名路径
				String [] arr =doorPicFileName.split("\\.");
				String wayid=form.getWayid();
//				修改相片的名字：渠道名称+doorPic
				doorPicFileName = wayid+"_MT."+arr[1];
				path1 = createFilename(arr[0], "."+arr[1]);
				if("jpg".equals(arr[1])||"JPG".equals(arr[1])){
					FileInputStream stream = new FileInputStream(doorPic);
					int i=stream.available();
					if(i>3*1024*1024){
						 setActionMessage("门头照片大小不能超过3M，请重新选择！");
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
					 setActionMessage("门头照片类型只能为jpg，请重新选择！");
					 return WEB_RESULT_CONTENT;
				}
			} catch (FileNotFoundException fnfe) {
				throw new Exception("上传文件不能为空!");
			} catch (IOException ioe) {
				throw new Exception("文件读写错误!");
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
				throw new Exception("存放文件路径错误,请检阅coreconfiginfo.properties中uploadlocation的配置!");
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
				throw new Exception("存放文件路径错误,请检阅coreconfiginfo.properties中uploadlocation的配置!");
			}
		}
	 
	//新增
	public String doNew() throws Exception{ 
		this.CMD = WEB_CMD_NEW;
		return WEB_RESULT_CONTENT;
	};
	
	 //删除
	public String doDelete() throws Exception{
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		Waystoreinfo waystoreinfo = (Waystoreinfo) BOFactory.build(WaystoreinfoBO.class, getDBAccessUser());
		for (int i = 0; i < selectArray.length; i++) { 
			waystoreinfo.doRemoveByPK(selectArray[i]);
		}
		return doList();
	}
	
 
	//导出
	public String doExportExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		export.setFileName("门店宣传信息管理"); 
		export.addOutputProperty("wayid", "门店编码");
		export.addOutputProperty("wayid", "门店名称",export.CODE2NAME,"#WAY");
		export.addOutputProperty("latitude", "地理经度");
		export.addOutputProperty("longtitude", "地理纬度");
		export.addOutputProperty("cityid", "地市公司",export.CODE2NAME, "#CITYCOMPANY");
		export.addOutputProperty("area", "面积(平方)");
		export.addOutputProperty("zqtype", "专区类型",export.CODE2NAME,"$CH_WAYSTORETYPE");
		
		
		export.addOutputProperty("zqarea", "专区面积");
		export.addOutputProperty("zqpanel", "专区背板",export.CODE2NAME,"$CH_YESORNO1");
		export.addOutputProperty("zqcupboard", "专区专柜（个）");
		export.addOutputProperty("zqcards", "专区立牌（个）");
		export.addOutputProperty("zqpricetag", "专区价签（个）");
		export.addOutputProperty("zqrack", "专区展架（个）");
       
		export.addOutputProperty("zqinad", "专区店内横幅",export.CODE2NAME,"$CH_YESORNO1");
		export.addOutputProperty("zqoutad", "专区店外横幅",export.CODE2NAME,"$CH_YESORNO1");
		export.addOutputProperty("zqhead", "专区堆头",export.CODE2NAME,"$CH_YESORNO1");
		export.addOutputProperty("zqpaste", "专区地贴",export.CODE2NAME,"$CH_YESORNO1");
		export.addOutputProperty("zqtablecard", "专区桌面台牌点位（个）");
		export.addOutputProperty("zqdecca", "专区桌面台卡点位（个）");
		
		export.addOutputProperty("zqbill", "专区海报");
		export.addOutputProperty("doorpic", "门头照片");
		export.addOutputProperty("doortype", "门头类型",export.CODE2NAME,"$CH_DOORTYPE");
		export.addOutputProperty("outwallad", "外墙广告面积大小（平米）");
		export.addOutputProperty("outwallpic", "外墙广告大幅宣传画面点位（个）");
		export.addOutputProperty("tdmonopoly", "终端专营",export.CODE2NAME,"$CH_YESORNO2");
		export.addOutputProperty("busimonopoly", "业务专营",export.CODE2NAME,"$CH_YESORNO2");
		export.addOutputProperty("storeconduct", "宣传位数量（1平米以上）（个）");
		export.addOutputProperty("modulus", "系数");  
		
		// 设置VO类
		export.voClassArray = new Class[] { VwaystoreinfoVo.class };
		
		// 设置查询方法
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
					// 新的上传文件名路径
				 	String [] arr =docFileName[i].split("\\.");
				 	path = createFilename(arr[0], "."+arr[1]);
				 	
				 	if("jpg".equals(arr[1])||"JPG".equals(arr[1])){
				 		String [] arr1 = arr[0].split("_");
				 		if(arr1.length!=2){
							 setActionMessage(docFileName[i]+"照片格式不正确，请重新选择！");
							 return "error";
				 		}
				 		
				 		WaystoreinfoVO fvo =waystoreinfo.doFindByPk(arr1[0]);
				 		if(fvo==null){
							 setActionMessage(docFileName[i]+"门店编码不正确，请重新选择！");
							 return "error";
				 		}
				 		if(arr1[1].equals("专区照片")){
				 			fvo.setZqpic(docFileName[i]);
				 		}else if(arr1[1].equals("门头照片")){
				 			fvo.setDoorpic(docFileName[i]);
				 		}else{
							 setActionMessage(docFileName[i]+"照片后缀不正确，请重新选择！");
							 return "error";
				 		}
				 		
				 		FileInputStream stream = new FileInputStream(doc[i]);
				 		int ii=stream.available();
						if(ii>3*1024*1024){
							 setActionMessage(docFileName[i]+"照片大小不能超过3M，请重新选择！");
							 return "error";
						 }else{
							 if(arr1[1].equals("专区照片")){
							 docFileName[i]=arr1[0]+"_ZQ."+arr[1];
							 }else if(arr1[1].equals("门头照片")){
								 docFileName[i]=arr1[0]+"_MT."+arr[1];
								 //System.out.println("eeeeee==:"+arr[1]);
								 //System.out.println("---- docFileName:"+ docFileName[i]);
						 		}
								FtpInfo ftpInfo = FtpInfo.getInstance();
								FtpAccess ftp = new FtpAccess(ftpInfo);
								String compact = ftp.uploadFile2(this.doc[i],
										remotepath, true, docFileName[i]);
						 		if(arr1[1].equals("专区照片")){
						 			fvo.setZqpicpath(compact);
						 		}else if(arr1[1].equals("门头照片")){
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
						setActionMessage("照片类型只能为jpg，请重新选择！");
						return "error";
				 	}
				} catch (FileNotFoundException fnfe) {
					throw new Exception("上传文件不能为空!");
				} catch (IOException ioe) {
					throw new Exception("文件读写错误!");
				} catch (Exception e) {
					throw e;
				}
			 
		 }
		 setActionMessage("操作成功！");
		return "error";
	}

	//申请文件上传
	public String doDownload() throws Exception{
			try {
				HttpServletRequest request=ServletActionContext.getRequest(); 
				String url = request.getParameter("file");
				// 文件名中文乱码转换
				String result = new String(url.getBytes("iso-8859-1"), "gb2312");
				url = result;
				FtpAccess ftpAccess = new FtpAccess(FtpInfo.getInstance());
				String localPath =ServletActionContext.getServletContext().getRealPath("/") ;
				System.out.println("----->localPath：" + localPath + "\n" + "----->url：" + url);
				//localPath="D:\\yl\\123";
				String file = ftpAccess.downloadFile(localPath, url);
				if (file == null) {
					throw new Exception("下载失败！");
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
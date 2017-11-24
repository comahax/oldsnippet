package com.sunrise.boss.ui.cms.bbc.bbcadjust;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.*;

import org.apache.struts.action.*;
import org.apache.struts.upload.*;

import com.sunrise.boss.business.cms.waitaudit.persistent.WaitauditVO;
import com.sunrise.boss.business.resmanage.common.pubdef.ResConstant;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.cms.waitaudit.WaitauditDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.boss.ui.commons.batch.upload.ICheckFormat;
import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;
import com.sunrise.boss.ui.commons.ftp.FtpAccess;
import com.sunrise.boss.ui.commons.ftp.FtpInfo;
import com.sunrise.boss.ui.resmanage.common.ResPubUtil;

/**
 * 文件上传处理类
 */

public class UnpbUploadFileAction extends Action {
	static final private String CONTENT_TYPE = "text/html; charset=GBK";

	private User user;

	static final public String PARAMETER = "_parameter";// 将表单数据写到另一文件名前缀

	public ActionForward execute(ActionMapping actionMapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BbcadjustunpbbatchForm bform = (BbcadjustunpbbatchForm) form;
		String oprtype = bform.getOprType();
		response.setContentType(CONTENT_TYPE);
		HttpSession session = request.getSession();
		user = (User) session.getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		String opercode;
		String wayid;
		if (user != null) {
			opercode = user.getOpercode();
			wayid = user.getWayid();
		} else {
			opercode = "";
			wayid = "";
		}
		String file = "";
		try {
			
			UploadFileForm uploadFileForm = (UploadFileForm) form;
			FormFile formFile = uploadFileForm.getTheFile();
			if (formFile.getFileSize() == 0) {
				throw new Exception("请选择正确格式的文件上传!");
			}
			ICheckFormat iCheckFormat = uploadFileForm.getCheckFormat();
			file = getFile(formFile, request, opercode);// 获得新文件名
			// 将表单数据写到parameterMap和表单文件当中
			HashMap parameterMap = serializeParameter(file, request, form);
			parameterMap.put("user", user);
			// 检查文件类型大小等,表单数据
			iCheckFormat.checkFile(formFile, parameterMap);
			int count = checkFile(file, iCheckFormat);// 检查文件每行格式并得到文件行数
			// 上传文件到FTP.
			String newFile = ftpFile(file, user);
			WaitauditVO vo=new WaitauditVO();
			if("0".equals(oprtype)){
				vo.setSubsystem(new Short("7"));
				vo.setLogfile(newFile);
				vo.setTaskstate(new Byte("0"));
				vo.setOprcode(user.getOpercode());
				vo.setWayid(user.getWayid());
				vo.setCreatetime(new Date());
				new WaitauditDelegate().doCreate(vo, user);
			}else{
				vo.setSubsystem(new Short("8"));
				vo.setLogfile(newFile);
				vo.setTaskstate(new Byte("0"));
				vo.setOprcode(user.getOpercode());
				vo.setWayid(user.getWayid());
				vo.setCreatetime(new Date());
				new WaitauditDelegate().doCreate(vo, user);
			}
			formFile.destroy();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"文件已上传成功，需要审核通过才被处理");
			return actionMapping.findForward("success");
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
			return (actionMapping.findForward("error"));
		}
	}

	/**
	 * 检查文件格式并返回文件行数
	 */
	public int checkFile(String fileName, ICheckFormat iCheckFormat)
			throws Exception {
		// RandomAccessFile rin = new RandomAccessFile(fileName, "r");
		FileInputStream fileInputStream = new FileInputStream(fileName);
		InputStreamReader read = new InputStreamReader(fileInputStream, "gbk");
		BufferedReader rin = new BufferedReader(read);
		String line;
		int count = 0;// 记录当前检查到的行数
		try {
			while ((line = rin.readLine()) != null) {
				if (line.trim().length() > 0) {
					++count;
					iCheckFormat.checkLine(line, count);
					if (BaseCheckFormat.class.isAssignableFrom(iCheckFormat
							.getClass())) {
						((BaseCheckFormat) iCheckFormat).checkLine(line, count,
								user);// 增加了一行调用代码
					}
				}
			}
		} catch (Exception ex) {
			throw new Exception("第" + count + "行记录格式不正确：" + ex.getMessage());
		} finally {
			rin.close();
			read.close();
			fileInputStream.close();
		}
		return count;
	}

	protected String getFile(FormFile file, HttpServletRequest request,
			String opercode) throws Exception {
		String contentType = file.getContentType();
		String newfile = "";

		try {
			// 新的上传文件名路径
			newfile = createFilename(opercode, contentType);
			InputStream stream = file.getInputStream();
			OutputStream bos = new FileOutputStream(newfile);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
				bos.write(buffer, 0, bytesRead);
			}
			bos.close();
			stream.close();
		} catch (FileNotFoundException fnfe) {
			throw new Exception("源文件没找到!");
		} catch (IOException ioe) {
			throw new Exception("文件读写错误");
		} catch (Exception e) {
			throw e;
		}
		// file.destroy();
		return newfile;
	}

	protected HashMap serializeParameter(String fileName,
			HttpServletRequest request, ActionForm form) throws Exception {
		String parameterFileName = fileName.replaceFirst("\\.txt$", PARAMETER
				+ ".txt");
		parameterFileName = parameterFileName.replaceFirst("\\.xls$", PARAMETER
				+ ".txt");
		Enumeration e = request.getParameterNames();
		HashMap map = new HashMap();
		while (e.hasMoreElements()) {
			String key = e.nextElement().toString();
			String value = request.getParameter(key);
			map.put(key, value);
		}
		FileOutputStream out = new FileOutputStream(parameterFileName);
		ObjectOutputStream oo = new ObjectOutputStream(out);
		oo.writeObject(map);
		oo.close();
		out.close();
		return map;
	}

	/**
	 * 建立文件，
	 */
	protected String createFilename(String opercode) throws Exception {
		String location = servlet.getServletConfig().getInitParameter(
				"uploadlocation");
		if (location == null || location.equals("")) {
			throw new Exception("文件路径没有设置，请检阅web.xml中uploadlocation的配置!");
		}
		String head = opercode;
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		calendar.setTime(new Date());
		if (head == null || head.equals("")) {
			head = "sunrise_";
		} else {
			head += "_";
		}
		String filename = head + (calendar.get(Calendar.YEAR) + 1900)
				+ (calendar.get(Calendar.MONTH) + 1)
				+ calendar.get(Calendar.DATE)
				+ calendar.get(Calendar.HOUR_OF_DAY)
				+ calendar.get(Calendar.MINUTE) + calendar.get(Calendar.SECOND)
				+ (new java.util.Random()).nextInt(99);

		int strLength = location.length();
		String pathSeperator = location.substring(strLength - 1, strLength);
		location = getServlet().getServletConfig().getServletContext()
				.getRealPath(location);
		if (!location.endsWith(pathSeperator)) {
			location = location + pathSeperator;
		}
		location = location.replace('\\', '/');
		String file = location + filename + ".txt";
		java.io.File f = new java.io.File(location);
		if (f.exists()) {
			return file;
		} else {
			throw new Exception(
					"存放文件路径错误,请检阅web.xml中uploadlocation的配置(请在web目录下面新建upload文件夹)!");
		}
	}

	/**
	 * 建立文件，
	 */
	protected String createFilename(String opercode, String contentType)
			throws Exception {
		String type = ".txt";
		if ("application/vnd.ms-excel".equals(contentType)) {
			type = ".xls";
		}

		String location = servlet.getServletConfig().getInitParameter(
				"uploadlocation");
		if (location == null || location.equals("")) {
			throw new Exception("文件路径没有设置，请检阅web.xml中uploadlocation的配置!");
		}
		String head = opercode;
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		calendar.setTime(new Date());
		if (head == null || head.equals("")) {
			head = "sunrise_";
		} else {
			head += "_";
		}
		String filename = head + (calendar.get(Calendar.YEAR) + 1900)
				+ calendar.get(Calendar.MARCH) + calendar.get(Calendar.DATE)
				+ calendar.get(Calendar.HOUR) + calendar.get(Calendar.MINUTE)
				+ calendar.get(Calendar.SECOND)
				+ (new java.util.Random()).nextInt(99);

		int strLength = location.length();
		String pathSeperator = location.substring(strLength - 1, strLength);
		location = getServlet().getServletConfig().getServletContext()
				.getRealPath(location);
		if (!location.endsWith(pathSeperator)) {
			location = location + pathSeperator;
		}
		location = location.replace('\\', '/');
		String file = location + filename + type;
		java.io.File f = new java.io.File(location);
		if (f.exists()) {
			return file;
		} else {
			throw new Exception(
					"存放文件路径错误,请检阅web.xml中uploadlocation的配置(请在web目录下面新建upload文件夹)!");
		}
	}

	/**
	 * 上传文件到系统参数指定的主机及目录，返回文件名
	 * 
	 * @param filename
	 * @param user
	 * @return
	 * @throws Exception
	 */
	protected String ftpFile(String filename, User user) throws Exception {
		FtpInfo fi = ResPubUtil.getFtpInfo(user);
		String dir = ResPubUtil.getSysparamVO(
				ResConstant.SysParam_BatchFileDir, user).getParamvalue();
		if (dir == null || "".equals(dir)) {
			throw new Exception("资源系统参数没有设置，无法取得批量文件存放目录");
		}
		FtpAccess fa = new FtpAccess(fi);

		DateFormat format = new SimpleDateFormat("yyyyMM");
		String dateDir = format.format(new Date(System.currentTimeMillis()));
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
		StringBuffer dirBuffer = new StringBuffer(dir);

		// 进入日期目录
		dirBuffer.append("/").append(dateDir);
		if (fa.ftp.changeWorkingDirectory(dirBuffer.toString()) == false)
			if (fa.ftp.makeDirectory(dirBuffer.toString()) == false)
				throw new Exception("进入目录：" + dirBuffer.toString() + "出错！");

		// 进入市公司标识目录
		dirBuffer.append("/").append(cityid);
		if (fa.ftp.changeWorkingDirectory(dirBuffer.toString()) == false)
			if (fa.ftp.makeDirectory(dirBuffer.toString()) == false)
				throw new Exception("进入目录：" + dirBuffer.toString() + "出错！");

		// 进入渠道目录
		dirBuffer.append("/").append(user.getWayid());
		if (fa.ftp.changeWorkingDirectory(dirBuffer.toString()) == false)
			if (fa.ftp.makeDirectory(dirBuffer.toString()) == false)
				throw new Exception("进入目录：" + dirBuffer.toString() + "出错！");

		// 进入工号目录
		dirBuffer.append("/").append(user.getOpercode());
		if (fa.ftp.changeWorkingDirectory(dirBuffer.toString()) == false)
			if (fa.ftp.makeDirectory(dirBuffer.toString()) == false)
				throw new Exception("进入目录：" + dirBuffer.toString() + "出错！");

		fa.ftp.sendCommand("site chmod 777 " + dirBuffer.toString());// 修改目录使用模式，赋权

		// FTP传送文件
		String newfile = fa.uploadFile(filename, dirBuffer.toString(), false);

		return newfile;

	}
}

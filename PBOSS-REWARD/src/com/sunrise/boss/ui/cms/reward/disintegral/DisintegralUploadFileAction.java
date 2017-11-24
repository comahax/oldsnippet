package com.sunrise.boss.ui.cms.reward.disintegral;

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
 * �ļ��ϴ�������
 */

public class DisintegralUploadFileAction extends Action {
	static final private String CONTENT_TYPE = "text/html; charset=GBK";

	private User user;

	static final public String PARAMETER = "_parameter";// ��������д����һ�ļ���ǰ׺

	public ActionForward execute(ActionMapping actionMapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType(CONTENT_TYPE);
		HttpSession session = request.getSession();
		user = (User) session.getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		String opercode;
		if (user != null) {
			opercode = user.getOpercode();
		} else {
			opercode = "";
		}
		String file = "";
		try {

			UploadFileForm uploadFileForm = (UploadFileForm) form;
			FormFile formFile = uploadFileForm.getTheFile();
			if (formFile.getFileSize() == 0) {
				throw new Exception("��ѡ����ȷ��ʽ���ļ��ϴ�!");
			}
			ICheckFormat iCheckFormat = uploadFileForm.getCheckFormat();
			file = getFile(formFile, request, opercode);// ������ļ���
			// ��������д��parameterMap�ͱ��ļ�����
			HashMap parameterMap = serializeParameter(file, request, form);
			parameterMap.put("user", user);
			// ����ļ����ʹ�С��,������
			iCheckFormat.checkFile(formFile, parameterMap);
			int count = checkFile(file, iCheckFormat);// ����ļ�ÿ�и�ʽ���õ��ļ�����
			// �ϴ��ļ���FTP.
			String newFile = ftpFile(file, user);
			WaitauditVO vo=new WaitauditVO();
			vo.setSubsystem(new Short("6"));
			vo.setLogfile(newFile);
			vo.setTaskstate(new Byte("0"));
			vo.setOprcode(user.getOpercode());
			vo.setWayid(user.getWayid());
			vo.setCreatetime(new Date());
			new WaitauditDelegate().doCreate(vo, user);
			formFile.destroy();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"�ļ����ϴ��ɹ�����Ҫ���ͨ���ű�����");
			return actionMapping.findForward("success");
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
			return (actionMapping.findForward("error"));
		}
	}

	/**
	 * ����ļ���ʽ�������ļ�����
	 */
	public int checkFile(String fileName, ICheckFormat iCheckFormat)
			throws Exception {
		// RandomAccessFile rin = new RandomAccessFile(fileName, "r");
		FileInputStream fileInputStream = new FileInputStream(fileName);
		InputStreamReader read = new InputStreamReader(fileInputStream, "gbk");
		BufferedReader rin = new BufferedReader(read);
		String line;
		int count = 0;// ��¼��ǰ��鵽������
		try {
			while ((line = rin.readLine()) != null) {
				if (line.trim().length() > 0) {
					++count;
					iCheckFormat.checkLine(line, count);
					if (BaseCheckFormat.class.isAssignableFrom(iCheckFormat
							.getClass())) {
						((BaseCheckFormat) iCheckFormat).checkLine(line, count,
								user);// ������һ�е��ô���
					}
				}
			}
		} catch (Exception ex) {
			throw new Exception("��" + count + "�м�¼��ʽ����ȷ��" + ex.getMessage());
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
			// �µ��ϴ��ļ���·��
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
			throw new Exception("Դ�ļ�û�ҵ�!");
		} catch (IOException ioe) {
			throw new Exception("�ļ���д����");
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
	 * �����ļ���
	 */
	protected String createFilename(String opercode) throws Exception {
		String location = servlet.getServletConfig().getInitParameter(
				"uploadlocation");
		if (location == null || location.equals("")) {
			throw new Exception("�ļ�·��û�����ã������web.xml��uploadlocation������!");
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
					"����ļ�·������,�����web.xml��uploadlocation������(����webĿ¼�����½�upload�ļ���)!");
		}
	}

	/**
	 * �����ļ���
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
			throw new Exception("�ļ�·��û�����ã������web.xml��uploadlocation������!");
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
					"����ļ�·������,�����web.xml��uploadlocation������(����webĿ¼�����½�upload�ļ���)!");
		}
	}

	/**
	 * �ϴ��ļ���ϵͳ����ָ����������Ŀ¼�������ļ���
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
			throw new Exception("��Դϵͳ����û�����ã��޷�ȡ�������ļ����Ŀ¼");
		}
		FtpAccess fa = new FtpAccess(fi);

		DateFormat format = new SimpleDateFormat("yyyyMM");
		String dateDir = format.format(new Date(System.currentTimeMillis()));
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
		StringBuffer dirBuffer = new StringBuffer(dir);

		// ��������Ŀ¼
		dirBuffer.append("/").append(dateDir);
		if (fa.ftp.changeWorkingDirectory(dirBuffer.toString()) == false)
			if (fa.ftp.makeDirectory(dirBuffer.toString()) == false)
				throw new Exception("����Ŀ¼��" + dirBuffer.toString() + "����");

		// �����й�˾��ʶĿ¼
		dirBuffer.append("/").append(cityid);
		if (fa.ftp.changeWorkingDirectory(dirBuffer.toString()) == false)
			if (fa.ftp.makeDirectory(dirBuffer.toString()) == false)
				throw new Exception("����Ŀ¼��" + dirBuffer.toString() + "����");

		// ��������Ŀ¼
		dirBuffer.append("/").append(user.getWayid());
		if (fa.ftp.changeWorkingDirectory(dirBuffer.toString()) == false)
			if (fa.ftp.makeDirectory(dirBuffer.toString()) == false)
				throw new Exception("����Ŀ¼��" + dirBuffer.toString() + "����");

		// ���빤��Ŀ¼
		dirBuffer.append("/").append(user.getOpercode());
		if (fa.ftp.changeWorkingDirectory(dirBuffer.toString()) == false)
			if (fa.ftp.makeDirectory(dirBuffer.toString()) == false)
				throw new Exception("����Ŀ¼��" + dirBuffer.toString() + "����");

		fa.ftp.sendCommand("site chmod 777 " + dirBuffer.toString());// �޸�Ŀ¼ʹ��ģʽ����Ȩ

		// FTP�����ļ�
		String newfile = fa.uploadFile(filename, dirBuffer.toString(), false);

		return newfile;

	}
}

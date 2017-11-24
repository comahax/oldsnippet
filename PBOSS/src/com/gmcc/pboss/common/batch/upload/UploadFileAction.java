package com.gmcc.pboss.common.batch.upload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;

import com.gmcc.pboss.common.ftp.FtpInfo;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.control.communication.advaffix.Advaffix;
import com.gmcc.pboss.control.communication.advaffix.AdvaffixBO;
import com.gmcc.pboss.web.reward.payment.PaymentCheck;
import com.opensymphony.xwork2.ActionSupport;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * �ļ��ϴ�������
 */

public class UploadFileAction extends ActionSupport implements ServletContextAware {

	private static final String EXCEPTION_MESSAGE = "����ļ�·������,�����coreconfiginfo.properties��uploadlocation������!";
	
	static final private String CONTENT_TYPE = "text/html; charset=GBK";
	private User user;
	private ICheckFormat checkFormat;
	private File doc;
	private String fileName;
	private String filepath;
	private String opername;
	private String wayid;
	private int rowCont;
	private String iCheckFormat;
	private Map paramMap;				//���STRUTS2����һ������ҳ�涯̬�����ĳ�Ա��ҳ��ʹparamMap.XXX);

	public String getICheckFormat() {
		return iCheckFormat;
	}

	public void setICheckFormat(String checkFormat) {
		iCheckFormat = checkFormat;
	}

	public int getRowCont() {
		return rowCont;
	}

	public void setRowCont(int rowCont) {
		this.rowCont = rowCont;
	}

	public static String getPARAMETER() {
		return PARAMETER;
	}

	public String getOpername() {
		return opername;
	}

	public void setOpername(String opername) {
		this.opername = opername;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public HashMap getFormMap() {
		return formMap;
	}

	public void setFormMap(HashMap formMap) {
		this.formMap = formMap;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	private String contentType;
	private ServletContext context;
	private UploadFileForm uploadFileForm;
	private File upload;
	private HashMap formMap;

	public ICheckFormat getCheckFormat() {
		return checkFormat;
	}

	public void setCheckFormat(ICheckFormat checkFormat) {
		this.checkFormat = checkFormat;
	}

	public File getDoc() {
		return doc;
	}

	public void setDoc(File doc) {
		this.doc = doc;
	}

	public String getFileName() {
		return fileName;
	}

	public void setDocFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setDocContentType(String contentType) {
		this.contentType = contentType;
	}

	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	public HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}

	public ServletContext getContext() {
		return context;
	}

	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	public UploadFileForm getUploadFileForm() {
		return uploadFileForm;
	}

	public void setUploadFileForm(UploadFileForm uploadFileForm) {
		this.uploadFileForm = uploadFileForm;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Map getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map paramMap) {
		this.paramMap = paramMap;
	}

	static final public String PARAMETER = "_parameter";// ��������д����һ�ļ���ǰ׺

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String execute() throws Exception {
		ServletActionContext.getResponse().setContentType(CONTENT_TYPE);
		// ServletConfig config =
		// ServletActionContext.getPageContext().getServletConfig();
		HttpSession session = ServletActionContext.getRequest().getSession();
		user = (User) session.getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		
		try{
			Collection<String> actionMessages = this.getActionMessages();
			if(actionMessages != null && actionMessages.size() > 0) {
				Advaffix advaffix = (AdvaffixBO) BOFactory.build(AdvaffixBO.class, user);
				Collection<String> actionMessagesTrans = advaffix.doGetTooLargerMsg(actionMessages);
				this.setActionMessages(actionMessagesTrans);
				return ERROR;
			}
		}catch(Exception e){
			super.addActionError(e.getMessage());
			return ERROR;
		}
		if (user != null) {
			this.opername = user.getOpername();
			this.wayid = user.getWayid();
		} else {
			this.opername = "";
			this.wayid = "";
		}
		try {
			String beginTime = DateUtil.getNowTime();

			String dstPath = ServletActionContext.getServletContext().getRealPath("/upload") + "\\" + fileName;
			System.out.println(dstPath);
			System.out.println("�ϴ����ļ������ͣ�" + contentType);
			// java.io.File file = uploadFileForm.getTheFile();
			// if (formfile.getBytes().length == 0) {
			// throw new Exception("��ѡ����ȷ��ʽ���ļ��ϴ�!");
			// }
			ICheckFormat checkFormat = (BaseCheckFormat) Class.forName(iCheckFormat).newInstance();
			filepath = getFile(doc, this.opername);// ������ļ���
			// ��������д��parameterMap�ͱ��ļ�����
			HashMap parameterMap = serializeParameter(filepath);
			parameterMap.put("user", user);
			// ����ļ����ʹ�С��,������
			checkFormat.checkFile(doc, parameterMap, contentType);
			
			// ����ļ�ÿ�и�ʽ���õ��ļ�����
			int count = checkFile(filepath, checkFormat);
			
			String endTime = DateUtil.getNowTime();
			String diff = "";
			try {
				diff = DateUtil.getSubDayNum(beginTime, endTime);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			StringBuilder strb = new StringBuilder();
			strb.append("�ɹ��ϴ� ");
			strb.append(count);
			strb.append(" �����ݣ���ʱ��");
			strb.append(diff);
			
			addActionError(strb.toString());
			System.out.println(strb.toString());
			setFormMap(parameterMap);
		} catch (Exception ex) {
			setFileName("");
			//���ļ�·��ȥ��
			setFilepath(null);
			ex.printStackTrace();
			addActionError(ex.getMessage());
			// return (actionMapping.findForward("error"));
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * ����ļ���ʽ�������ļ�����
	 */
	public int checkFile(String fileName, ICheckFormat iCheckFormat) throws Exception {
		// RandomAccessFile rin = new RandomAccessFile(fileName, "r");
		FileInputStream fileInputStream = new FileInputStream(fileName);
		InputStreamReader read = new InputStreamReader(fileInputStream, "gbk");
		BufferedReader rin = new BufferedReader(read);
		// long length = rin.length(); // �ļ�����
		// long filePointer = rin.getFilePointer(); // �ļ��α�
		String line;
		int count = 0;// ��¼��ǰ��鵽������
		try {
			// if (length <= 0) {
			// throw new Exception("�ϴ�����Ϊ��!");
			// }
			// while (filePointer < length) {
			// ++count;
			// line = rin.readLine();
			// iCheckFormat.checkLine(line, count);
			// filePointer = rin.getFilePointer();
			// }
			while ((line = rin.readLine()) != null) {
				if (line.trim().length() > 0) {
					++count;
					iCheckFormat.checkLine(line, count);
					if (BaseCheckFormat.class.isAssignableFrom(iCheckFormat.getClass())) {
						((BaseCheckFormat) iCheckFormat).checkLine(line, count, user);// ������һ�е��ô���
					}
				}
			}
			
			System.out.println("�ϴ���ɣ�" + fileName);
		} catch (Exception ex) {
			throw new Exception("��" + count + "�м�¼��ʽ����ȷ��" + ex.getMessage());
		} finally {
			rin.close();
			read.close();
			fileInputStream.close();
		}
		return count;
	}

	protected String getFile(File file, String opercode) throws Exception {
		// String contentType = file.getContentType();
		String newfile = "";

		try {
			// �µ��ϴ��ļ���·��
			newfile = createFilename(opercode, ".txt");
			FileInputStream stream = new FileInputStream(doc);
			// InputStream stream = file.getInputStream();
			OutputStream bos = new FileOutputStream(newfile);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
				bos.write(buffer, 0, bytesRead);
			}
			bos.close();
			stream.close();
		} catch (FileNotFoundException fnfe) {
			if(doc.exists())//STRUTS �ļ��ϴ���Ϊ��СΪ0Kʱ������Ҳ����ļ��Ĵ���(���ļ���ʱ)
				throw new Exception("");
			throw new Exception("Դ�ļ�Ϊ��!");
		} catch (IOException ioe) {
			throw new Exception("�ļ���д����");
		} catch (Exception e) {
			throw e;
		}
		// file.destroy();
		return newfile;
	}

	protected HashMap serializeParameter(String fileName) throws Exception {
		String parameterFileName = fileName.replaceFirst("\\.txt$", PARAMETER + ".txt");
		parameterFileName = parameterFileName.replaceFirst("\\.xls$", PARAMETER + ".txt");
		Enumeration e = ServletActionContext.getRequest().getParameterNames();
		HashMap map = new HashMap();
		while (e.hasMoreElements()) {
			String key = e.nextElement().toString();
			String value = ServletActionContext.getRequest().getParameter(key);
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
		String location = ServletActionContext.getServletContext().getInitParameter("uploadlocation");
		if (location == null || location.equals("")) {
			throw new Exception(EXCEPTION_MESSAGE);
		}
		String head = opercode;
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		calendar.setTime(new Date());
		if (head == null || head.equals("")) {
			head = "pboss_";
		} else {
			head += "_";
		}
		String filename = head + (calendar.get(Calendar.YEAR) + 1900) + (calendar.get(Calendar.MONTH) + 1) + calendar.get(Calendar.DATE) + calendar.get(Calendar.HOUR_OF_DAY)
				+ calendar.get(Calendar.MINUTE) + calendar.get(Calendar.SECOND) + (new java.util.Random()).nextInt(99);

		// String webappPath = getServlet().getInitParameter("uplocation");
		int strLength = location.length();
		String pathSeperator = location.substring(strLength - 1, strLength);
		location = ServletActionContext.getServletContext().getRealPath(location);
		if (!location.endsWith(pathSeperator)) {
			location = location + pathSeperator;
		}
		location = location.replace('\\', '/');
		String file = location + filename + ".txt";
		java.io.File f = new java.io.File(location);
		if (f.exists()) {
			return file;
		} else {
			throw new Exception(EXCEPTION_MESSAGE);
		}
	}

	/**
	 * �����ļ���
	 */
	protected String createFilename(String opercode, String contentType) throws Exception {
		String type = ".txt";
		if ("application/vnd.ms-excel".equals(contentType)) {
			type = ".xls";
		}
		// String location =
		// ServletActionContext.getServletContext().getInitParameter("uploadlocation");
		String location = FtpInfo.getUpload();
		if (location == null || location.equals("")) {
			throw new Exception(EXCEPTION_MESSAGE);
		}
		String head = opercode;
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		calendar.setTime(new Date());
		if (head == null || head.equals("")) {
			head = "pboss_";
		} else {
			head += "_";
		}
		String filename = head + (calendar.get(Calendar.YEAR) + 1900) + calendar.get(Calendar.MARCH) + calendar.get(Calendar.DATE) + calendar.get(Calendar.HOUR)
				+ calendar.get(Calendar.MINUTE) + calendar.get(Calendar.SECOND) + (new java.util.Random()).nextInt(99);

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
			throw new Exception(EXCEPTION_MESSAGE);
		}
	}

	// �Լ���װ��һ����Դ�ļ������Ƴ�Ŀ���ļ�����
	// private static void copy(File src, File dst) {
	// InputStream in = null;
	// OutputStream out = null;
	// try {
	// in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
	// out = new BufferedOutputStream(new FileOutputStream(dst),
	// BUFFER_SIZE);
	// byte[] buffer = new byte[BUFFER_SIZE];
	// int len = 0;
	// while ((len = in.read(buffer)) > 0) {
	// out.write(buffer, 0, len);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// if (null != in) {
	// try {
	// in.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// if (null != out) {
	// try {
	// out.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// }
	// }
}

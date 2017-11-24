package com.sunrise.boss.ui.cms.terminalrewardstd;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;

import org.apache.struts.action.*;
import org.apache.struts.upload.*;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.boss.ui.commons.batch.upload.BatchResultForm;
import com.sunrise.boss.ui.commons.batch.upload.ICheckFormat;
import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

/**
 * �ļ��ϴ�������
 */

public class UploadFileAction extends Action {
	static final private String CONTENT_TYPE = "text/html; charset=GBK";
    private User user;
	static final public String PARAMETER="_parameter";//��������д����һ�ļ���ǰ׺
	
	public ActionForward execute(ActionMapping actionMapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType(CONTENT_TYPE);
		HttpSession session = request.getSession();
		BatchResultForm resultForm = new BatchResultForm();
			user = (User) session
				.getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
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
			FormFile formFile=uploadFileForm.getTheFile();
			if (formFile.getFileSize() == 0) {
			      throw new Exception("��ѡ����ȷ��ʽ���ļ��ϴ�!");
			}
			ICheckFormat iCheckFormat = uploadFileForm.getCheckFormat();
			file = getFile(formFile, request, opercode);// ������ļ���
			//��������д��parameterMap�ͱ��ļ�����
			HashMap parameterMap=serializeParameter(file,request,form);
			parameterMap.put("user", user);
			//����ļ����ʹ�С��,������
			iCheckFormat.checkFile(formFile,parameterMap);
			int count = checkFile(file, iCheckFormat);// ����ļ�ÿ�и�ʽ���õ��ļ�����
			request.getSession().setAttribute("fileline", new Integer(count));
			request.setAttribute("parameterMap", parameterMap);
			resultForm.setInFile(file);
			resultForm.setFileName(formFile.getFileName());
			resultForm.setOpercode(opercode);
			resultForm.setWayid(wayid);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_ITEM, resultForm);
			formFile.destroy();
			return actionMapping.findForward("success");
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
			return (actionMapping.findForward("error"));
		}
	}

	/**
	 * ����ļ���ʽ�������ļ�����
	 */
	public int checkFile(String fileName, ICheckFormat iCheckFormat)
			throws Exception {
//		RandomAccessFile rin = new RandomAccessFile(fileName, "r");
		FileInputStream fileInputStream = new FileInputStream(fileName);
		InputStreamReader read = new InputStreamReader (fileInputStream, "gbk");
		BufferedReader rin=new BufferedReader(read);
//		long length = rin.length(); // �ļ�����
//		long filePointer = rin.getFilePointer(); // �ļ��α�
		String line;
		int count = 0;// ��¼��ǰ��鵽������
		try {
//			if (length <= 0) {
//				throw new Exception("�ϴ�����Ϊ��!");
//			}
//			while (filePointer < length) {
//				++count;
//				line = rin.readLine();
//				iCheckFormat.checkLine(line, count);
//				filePointer = rin.getFilePointer();
//			}
			while ((line = rin.readLine()) != null) {
				if (line.trim().length() > 0) {
					++count;
					iCheckFormat.checkLine(line, count);
					if(BaseCheckFormat.class.isAssignableFrom(iCheckFormat.getClass())){
					((BaseCheckFormat)iCheckFormat).checkLine(line, count, user);//������һ�е��ô���
					}
				}
			}
		} catch (Exception ex) {
			throw new Exception("��" + count + "�м�¼��ʽ����ȷ��"
					+ ex.getMessage());
		}finally{
			rin.close();
			read.close();
			fileInputStream.close();
		}
		return count;
	}

	protected String getFile(FormFile file, HttpServletRequest request,
			String opercode) throws Exception {
		String contentType=file.getContentType();
		String newfile = "";
		
		try {
			//�µ��ϴ��ļ���·��
			newfile = createFilename(opercode,contentType);
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
//		file.destroy();
		return newfile;
	}

	protected HashMap serializeParameter(String fileName,HttpServletRequest request,ActionForm form) throws Exception {
		String parameterFileName=fileName.replaceFirst("\\.txt$",PARAMETER+".txt");
		parameterFileName=parameterFileName.replaceFirst("\\.xls$",PARAMETER+".txt");
		Enumeration e = request.getParameterNames();
		HashMap map=new HashMap();
		while(e.hasMoreElements()){
			String key=e.nextElement().toString();
			String value=request.getParameter(key);
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
				+ (calendar.get(Calendar.MONTH)+1) + calendar.get(Calendar.DATE)
				+ calendar.get(Calendar.HOUR_OF_DAY) + calendar.get(Calendar.MINUTE)
				+ calendar.get(Calendar.SECOND)
				+ (new java.util.Random()).nextInt(99);

		// String webappPath = getServlet().getInitParameter("uplocation");
		int strLength = location.length();
		String pathSeperator = location.substring(strLength - 1, strLength);
		location = getServlet().getServletConfig().getServletContext()
				.getRealPath(location);
		if(!location.endsWith(pathSeperator)){
			location = location + pathSeperator;
		}
		location=location.replace('\\', '/');
		String file = location + filename + ".txt";
		java.io.File f = new java.io.File(location);
		if (f.exists()) {
			return file;
		} else {
			throw new Exception("����ļ�·������,�����web.xml��uploadlocation������(����webĿ¼�����½�upload�ļ���)!");
		}
	}
	/**
	 * �����ļ���
	 */
	protected String createFilename(String opercode,String contentType) throws Exception {
		String type=".txt";
		if("application/vnd.ms-excel".equals(contentType)){
			type=".xls";
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

		// String webappPath = getServlet().getInitParameter("uplocation");
		int strLength = location.length();
		String pathSeperator = location.substring(strLength - 1, strLength);
		location = getServlet().getServletConfig().getServletContext()
				.getRealPath(location);
		if(!location.endsWith(pathSeperator)){
			location = location + pathSeperator;
		}
		location=location.replace('\\', '/');
		String file = location + filename + type;
		java.io.File f = new java.io.File(location);
		if (f.exists()) {
			return file;
		} else {
			throw new Exception("����ļ�·������,�����web.xml��uploadlocation������(����webĿ¼�����½�upload�ļ���)!");
		}
	}


}

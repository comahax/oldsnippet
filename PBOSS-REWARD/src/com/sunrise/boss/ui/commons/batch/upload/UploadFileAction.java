package com.sunrise.boss.ui.commons.batch.upload;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.struts.action.*;
import org.apache.struts.upload.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * 文件上传处理类
 */

public class UploadFileAction extends Action {
	static final private String CONTENT_TYPE = "text/html; charset=GBK";
    private User user;
	static final public String PARAMETER="_parameter";//将表单数据写到另一文件名前缀
	
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
			      throw new Exception("请选择正确格式的文件上传!");
			}
			ICheckFormat iCheckFormat = uploadFileForm.getCheckFormat();
			file = getFile(formFile, request, opercode);// 获得新文件名
			//将表单数据写到parameterMap和表单文件当中
			HashMap parameterMap=serializeParameter(file,request,form);
			parameterMap.put("user", user);
			//检查文件类型大小等,表单数据
			iCheckFormat.checkFile(formFile,parameterMap);
			int count = checkFile(formFile, file, iCheckFormat);// 检查文件每行格式并得到文件行数
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
	 * 检查文件格式并返回文件行数
	 */
	public int checkFile(FormFile formFile, String fileName, ICheckFormat iCheckFormat)
			throws Exception {
		if ("text/plain".equalsIgnoreCase(formFile.getContentType())
				|| "text/xml".equalsIgnoreCase(formFile.getContentType())) {
			return checkTxtFile(fileName, iCheckFormat);
		} else if ("application/vnd.ms-excel".equalsIgnoreCase(formFile.getContentType())) {
			return checkExcelFile(fileName, iCheckFormat);
		} else {
			throw new Exception("上传的文件类型不正确！");
		}
	}

	/**
	 * 检查TXT文本文件格式并返回文件行数
	 */
	public int checkTxtFile(String fileName, ICheckFormat iCheckFormat)
			throws Exception {
//		RandomAccessFile rin = new RandomAccessFile(fileName, "r");
		FileInputStream fileInputStream = new FileInputStream(fileName);
		InputStreamReader read = new InputStreamReader (fileInputStream, "gbk");
		BufferedReader rin=new BufferedReader(read);
//		long length = rin.length(); // 文件长度
//		long filePointer = rin.getFilePointer(); // 文件游标
		String line;
		int count = 0;// 记录当前检查到的行数
		try {
//			if (length <= 0) {
//				throw new Exception("上传数据为空!");
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
					((BaseCheckFormat)iCheckFormat).checkLine(line, count, user);//增加了一行调用代码
					}
				}
			}
		} catch (Exception ex) {
			throw new Exception("第" + count + "行记录格式不正确："
					+ ex.getMessage());
		}finally{
			rin.close();
			read.close();
			fileInputStream.close();
		}
		return count;
	}

	/**
	 * 检查EXCEL文件格式并返回文件行数
	 */
	public int checkExcelFile(String fileName, ICheckFormat iCheckFormat)
			throws Exception {
		InputStream inputStream = null;
		Workbook workbook = null;
		int count = 0;// 记录当前检查到的行数
		try {
			inputStream = new FileInputStream(fileName);
			workbook = Workbook.getWorkbook(inputStream);
			Sheet sheet = workbook.getSheet(0);
			for (int i = 0; i < sheet.getRows(); i++) {
				Cell[] cells = sheet.getRow(i);
				if (cells != null && cells.length > 0) {
					++count;
					if (BaseCheckFormat.class.isAssignableFrom(iCheckFormat.getClass())) {
						((BaseCheckFormat) iCheckFormat).checkLine(cells, count);
					}
				}
			}
		} catch (RuntimeException ex) {
			throw new Exception("第" + count + "行记录格式不正确：" + ex.getMessage());
		} finally {
			if (workbook != null) {
				workbook.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
		}
		return count;
	}

	protected String getFile(FormFile file, HttpServletRequest request,
			String opercode) throws Exception {
		String contentType=file.getContentType();
		String newfile = "";
		
		try {
			//新的上传文件名路径
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
			throw new Exception("源文件没找到!");
		} catch (IOException ioe) {
			throw new Exception("文件读写错误");
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
			throw new Exception("存放文件路径错误,请检阅web.xml中uploadlocation的配置(请在web目录下面新建upload文件夹)!");
		}
	}
	/**
	 * 建立文件，
	 */
	protected String createFilename(String opercode,String contentType) throws Exception {
		String type=".txt";
		if("application/vnd.ms-excel".equals(contentType)){
			type=".xls";
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
			throw new Exception("存放文件路径错误,请检阅web.xml中uploadlocation的配置(请在web目录下面新建upload文件夹)!");
		}
	}


}

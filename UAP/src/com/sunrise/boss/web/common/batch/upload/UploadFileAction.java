package com.sunrise.boss.web.common.batch.upload;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;

import org.apache.struts2.ServletActionContext;

import com.sunrise.boss.web.fee.billing.uapreq.UapReqForm;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;



/**
 * 文件上传处理类
 */

public class UploadFileAction extends BaseAction{
	
	static final public String PARAMETER="_parameter";//将表单数据写到另一文件名前缀
	
	private String location = CoreConfigInfo.UPLOAD_LOCATION;
	private User user;
	private String opercode = "";
	
    private File upload; //上传文件
    
    private String filename; //上传文件路径
	
	private String uploadFileName; //原来的文件名
	
	private String uploadContentType; //文件类型
	
	private ICheckFormat checkFormat; //格式检查类
	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}
	
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public ICheckFormat getCheckFormat() {
		return checkFormat;
	}

	public void setCheckFormat(ICheckFormat checkFormat) {
		this.checkFormat = checkFormat;
	}
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public BatchResultForm checkFile() throws Exception {

		
	    user = (User) getDBAccessUser();
	    opercode = user.getOprcode();
		
		String file = "";
		try {
			FormFile formFile = new FormFile(getUpload(),getUploadFileName(),getUploadContentType());
			if (formFile == null) {
			      throw new Exception("请选择正确格式的文件上传!");
			}
			ICheckFormat iCheckFormat = getCheckFormat();
			file = getFile(formFile);// 获得新文件名

			//检查文件类型大小等,表单数据
			iCheckFormat.checkFile(formFile);
			int count = checkFile(file, iCheckFormat);// 检查文件每行格式并得到文件行数
			
			BatchResultForm resultForm = new BatchResultForm();
			resultForm.setInFile(file);
			resultForm.setFileName(formFile.getFileName());
			resultForm.setOpercode(opercode);
			resultForm.setTotal(count);

			formFile.delete();
			return resultForm;
		} catch (Exception ex) {
			this.setActionMessage(ex.getMessage());
		}
		return null;
	}

	/**
	 * 检查文件格式并返回文件行数
	 */
	public int checkFile(String fileName, ICheckFormat iCheckFormat)
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

	protected String getFile(FormFile file) throws Exception {
		if (file == null) {
		      throw new Exception("请选择正确格式的文件上传!");
		}
		String contentType=file.getContentType();
		String newfile = "";
		
		try {
			//新的上传文件名路径
			newfile = createFilename(contentType);
			InputStream stream = new FileInputStream(file.getFile());
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

	protected HashMap serializeParameter(String fileName,HttpServletRequest request) throws Exception {
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
	protected String createFilename() throws Exception {
		if (location == null || location.equals("")) {
			throw new Exception("文件路径没有设置，请检阅coreconfiginfo.properties中upload.location的配置!");
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

		
		int strLength = location.length();
		String pathSeperator = location.substring(strLength - 1, strLength);

        location = ServletActionContext.getServletContext().getRealPath(location);  

		if(!location.endsWith(pathSeperator)){
			location = location + pathSeperator;
		}
		location=location.replace('\\', '/');
		String file = location + filename + ".txt";
		java.io.File f = new java.io.File(location);
		if (f.exists()) {
			return file;
		} else {
			throw new Exception("存放文件路径错误,请检阅coreconfiginfo.properties中upload.location的配置(请在web目录下面新建upload文件夹)!");
		}
	}
	/**
	 * 建立文件，
	 */
	protected String createFilename(String contentType) throws Exception {
		String type=".txt";
		if("application/vnd.ms-excel".equals(contentType)){
			type=".xls";
		}
		
		
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
		location = ServletActionContext.getServletContext().getRealPath(location); 
		
		if(!location.endsWith(pathSeperator)){
			location = location + pathSeperator;
		}
		location=location.replace('\\', '/');
		String file = location + filename + type;
		java.io.File f = new java.io.File(location);
		if (f.exists()) {
			return file;
		} else {
			throw new Exception("存放文件路径错误,请检阅coreconfiginfo.properties中upload.location的配置(请在web目录下面新建upload文件夹)!");
		}
	}


    
}

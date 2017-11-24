package com.gmcc.pboss.common.batch.processfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.business.base.batchlog.BatchlogVO;
import com.gmcc.pboss.common.batch.upload.ActionForm;
import com.gmcc.pboss.common.ftp.FtpAccess;
import com.gmcc.pboss.common.ftp.FtpInfo;
import com.gmcc.pboss.control.base.batchlog.Batchlog;
import com.gmcc.pboss.control.base.batchlog.BatchlogBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * 文件处理的基类,子类可以重装 doStart(),processLine(String line, int rowCount),doEnd()
 * 
 * @author liminghao
 * 
 */
public abstract class BaseBatchTaskBean implements Runnable, Serializable {

	public static final Log log = LogFactory.getLog(BaseBatchTaskBean.class);

	protected int countrecord;

	protected boolean started = false;

	protected boolean running = false;

	protected boolean start_end; // 进度条辅助标志

	protected String filename;
	
	protected String filesourcename; //源上传本地文件名

	protected User user;

	protected String resultFile;

	protected String checkFile;

	protected int currentrecord = 0;

	protected int fail;

	protected int ok;

	protected boolean isComplete = false;

	protected HashMap parameterMap;// 存放表单数据
	
	private boolean hasTitle = false;//是否有标题行

	public ActionForm getForm() {
		return form;
	}

	public void setForm(ActionForm form) {
		this.form = form;
	}

	protected ActionForm form; // 与表单对应的form

	protected boolean isWriteLog = false;// 是否写日志信息

	protected String batchName = this.getClass().getName();// 写日志时记录何种批量处理(菜单标题名字),默认处理的类名

	protected String optype = "导入";// 写日志时记录何种批量处理,暂时保留
	                                 //基类默认值为“导入”，子类可以重新赋值

	protected FtpAccess ftp;

	public BaseBatchTaskBean() throws Exception{
	}

	/**
	 * 记录数
	 */
	public void setCountRecord() {
		countrecord = getRecordNumber(filename);
	}

	/**
	 * 入口
	 */
	public void work() {
		this.start_end = true; // 设进度条标志位
		try {
			String fileInPath = filename;
			String fileOutPath = fileInPath.replaceFirst("\\.txt$",
					"_result.txt");
			doPreProcess(fileInPath); //预处理操作
			doProcessFile(fileInPath, fileOutPath);
		} catch (Exception ex) {
			setRunning(false);
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
		}
	}

	/**
	 * 处理文件
	 */
	public void doProcessFile(String fileInPath, String fileOutPath)
			throws Exception {
		File resultFile = new File(fileOutPath);
		this.resultFile = fileOutPath;
		FileInputStream fileInputStream = new FileInputStream(fileInPath);
		InputStreamReader read = new InputStreamReader(fileInputStream, "gbk");
		BufferedReader rin = new BufferedReader(read);
		FileOutputStream fileOutputStream = new FileOutputStream(resultFile);
		OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream,
				"gbk");
		BufferedWriter fos = new BufferedWriter(writer);
		try {
			// 文件处理开始,写标题等
			fos.write(doStart());
			String line;
			ResultVO resultVO = new ResultVO();
			int count = 0;
			if(hasTitle){//如果有标题行,标题行不处理
				line = rin.readLine();
				fos.write(line + "\r\n");
			}
			while ((line = rin.readLine()) != null) {
				if (null != line && line.trim().length() > 0) {
					++count;
					try {
						resultVO = processLine(line.trim(), count); // 关键处理，处理一条记录
						// 写处理结果
						fos.write(resultVO.getInfo() + "\r\n");
					} catch (Exception e) {
						fos.write(count + "|" + line + "|失败|" + e.getMessage()
								+ "\r\n");
					}
					if (resultVO.isOk()) {
						++ok;
						// 组合字段
					} else {
						++fail;
					}
					currentrecord++;
				}
			}
			// 文件处理结束
			fos.write(doEnd());
		} catch (Exception ex) {
			fos.write(ex.getMessage());
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			fail = countrecord;
		} finally {
			rin.close();
			read.close();
			fos.close();
			writer.close();
			this.resultFile = fileOutPath;
			currentrecord = countrecord;
			isComplete = true;
			if (isWriteLog) {
				if (ok == currentrecord) {
					writeLog(batchName, optype, "0");// 成功
				} else if (fail == currentrecord) {
					writeLog(batchName, optype, "1");// 失败
				} else {
					writeLog(batchName, optype, "2");// 部分成功
				}
			} else {
				// deleteFile_(fileInPath);
			}
		}
	}

	// ----以下方法可以由子类覆盖--------
	
	/**
	 * 预处理操作，适用于处理文件前执行预定操作 add by ZhangFengchao 2010-06-17
	 */
	protected void  doPreProcess(String fileInPath) throws Exception {
		FileInputStream fileInputStream = new FileInputStream(fileInPath);
		InputStreamReader read = new InputStreamReader(fileInputStream, "gbk");
		BufferedReader rin = new BufferedReader(read);
		try {
			String line;
			int count = 0;
			while ((line = rin.readLine()) != null) {
				if (null != line && line.trim().length() > 0) {
					++count;
					preProcessLine(line.trim(), count); // 关键处理，处理一条记录
				}
			}
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			throw new Exception(ex);
		} finally {
			rin.close();
			read.close();
		}
	}
	/**
	 * 逐行处理文件前执行预定操作 
	 * @param line
	 * @param rowCount
	 * @return
	 */
	protected String preProcessLine(String line, int rowCount) throws Exception {
		return null;
	}
	
	/**
	 * 处理文件开始进行的操作,比如写结果文件的标题
	 */
	protected String doStart() {
		return "";
	}

	/**
	 * 处理一条记录
	 */
	protected ResultVO processLine(String line, int rowCount) {
		return null;
	}

	/**
	 * 处理文件完毕进行的操作
	 * 
	 * @throws Exception
	 */
	protected String doEnd() throws Exception {
		return "";
	}

	protected void writeLog(String batchName, String oprtype, String success)
			throws Exception {
		// 写历史记录信息
		if (isWriteLog) {
			Batchlog batchlog = (Batchlog) BOFactory.build(BatchlogBO.class,
					user);
			BatchlogVO batchlogVO = new BatchlogVO();
			batchlogVO.setOprcode(user.getOprcode());
			batchlogVO.setOprwayid(user.getWayid());
			batchlogVO.setOptime(new Date());
			batchlogVO.setOprtype(oprtype);
			batchlogVO.setBatchname(batchName);
			try {// 以防ftp服务出错影响记录日志
				ftp = new FtpAccess(FtpInfo.getInstance());
				batchlogVO
						.setUploadpath(uploadFile(filename, user.getOprcode()));
				batchlogVO.setResultpath(uploadFile(resultFile, user
						.getOprcode()));
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			// batchlogVO.setUploadpath(filename);
			// batchlogVO.setResultpath(resultFile);
			batchlogVO.setSuccess(success);
			batchlog.doCreate(batchlogVO);
		}
	}

	public String uploadFile(String filename, String oprcode) throws Exception {
		String result = ftp.uploadFile(filename, oprcode, false);
		if (result == null) {
			log.error(("上传文件失败：" + filename));
		}
		return result;
	}

	/**
	 * 删除文件
	 */
	private void deleteFile_(String filename) {
		File file = new File(filename);
		if (file.exists()) {
			file.delete();
		}
	}

	/**
	 * 读取文件中条数
	 */
	private int getRecordNumber(String filename) {
		int numbers = 0;
		try {
			RandomAccessFile rin = new RandomAccessFile(filename, "r");
			long length = rin.length();
			long filePointer = rin.getFilePointer();
			String line;

			while (filePointer < length) {
				line = rin.readLine();
				filePointer = rin.getFilePointer();
				if (null != line && line.trim().length() > 0) {
					numbers++;
				}
			}
			if(hasTitle){//如果有标题行如总记录数计数-1;(标题行不处理，所以不计数）
				numbers--;
			}
			rin.close();
		} catch (Exception ex) {
			return 0;
		}
		return numbers;
	}

	// **************************** start **********************
	public synchronized int getPercent() {
		if (countrecord == 0) {
			return 0;
		}
		int res = (currentrecord * 100) / countrecord;
		if (res == 100) {
			this.setStart_end();
		}
		if (isComplete) {
			res = 100;
		}
		return res;
	}

	public synchronized boolean isStarted() {
		return started;
	}

	/**
	 * 游标判断
	 */
	public synchronized boolean isCompleted() {
		// if (countrecord == 0) {
		// return true;
		// }
		// return currentrecord == countrecord;
		return isComplete;
	}

	public synchronized boolean isRunning() {
		return running;
	}

	public synchronized void setRunning(boolean running) {
		this.running = running;
		if (running) {
			started = true;
		}
	}

	/**
	 * 线程运行
	 */
	public void run() {
		try {
			setRunning(true);
			setCountRecord();
			while (isRunning() && !isCompleted()) {
				work();
			}
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
		} finally {
			setRunning(false);
		}
	}

	/**
	 * 异常翻译
	 * 
	 */
	public static String transException(Exception ex) {
		String message = ex.getMessage();
		// if (ex.getMessage().indexOf(
		// "java.sql.BatchUpdateException: Unique constraint") >= 0) {
		// message = "主键重复";
		// }
		return message;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setUser(User user) {

		this.user = user;
	}

	public int getFail() {
		return fail;
	}

	public String getResultFile() {
		return resultFile;
	}

	public int getOk() {
		return ok;
	}

	public int getCountrecord() {
		return countrecord;
	}

	public void setCountrecord(int countrecord) {
		this.countrecord = countrecord;
	}

	public boolean isStart_end() {
		return start_end;
	}

	public void setStart_end() {
		this.start_end = false;
	}

	public HashMap getParameterMap() {
		return parameterMap;
	}

	public void setParameterMap(HashMap parameterMap) {
		this.parameterMap = parameterMap;
	}

	public boolean isWriteLog() {
		return isWriteLog;
	}

	public void setWriteLog(boolean isWriteLog) {
		this.isWriteLog = isWriteLog;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getOptype() {
		return optype;
	}

	public void setOprtype(String optype) {
		this.optype = optype;
	}

	public String getCheckFile() {
		return checkFile;
	}

	public void setCheckFile(String checkFile) {
		this.checkFile = checkFile;
	}

	public boolean isHasTitle() {
		return hasTitle;
	}

	public void setHasTitle(boolean hasTitle) {
		this.hasTitle = hasTitle;
	}

	public String getFilesourcename() {
		return filesourcename;
	}

	public void setFilesourcename(String filesourcename) {
		this.filesourcename = filesourcename;
	}
	
}
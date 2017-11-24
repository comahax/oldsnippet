package com.sunrise.boss.ui.commons.batch.processfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import com.sunrise.boss.business.common.batchlog.persistent.BatchlogVO;
import com.sunrise.boss.delegate.common.batchlog.BatchlogDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.ftp.FtpAccess;
import com.sunrise.boss.ui.commons.ftp.FtpInfo;

/**
 * �ļ�����Ļ���,���������װ doStart(),processLine(String line, int rowCount),doEnd()
 *
 * @author liminghao
 *
 */
public abstract class BaseBatchTaskBean implements Runnable, Serializable {
	
	public static final Log log = LogFactory.getLog(BaseBatchTaskBean.class);
	
	protected int countrecord;

    protected boolean started = false;

    protected boolean running = false;

    protected boolean start_end; // ������������־

    protected String filename;

    protected User user;

    protected String resultFile;
    
    protected String checkFile;
	
    protected int currentrecord = 0;

    protected int fail;

    protected int ok;

    protected boolean isComplete=false;

    protected HashMap parameterMap;// ��ű�����

    protected ActionForm form; //�����Ӧ��form

    protected boolean isWriteLog=false;//�Ƿ�д��־��Ϣ

    protected String batchName=this.getClass().getName();//д��־ʱ��¼������������(�˵���������),Ĭ�ϴ��������

    protected String optype;//д��־ʱ��¼������������,��ʱ����

    protected FtpAccess ftp;

    public BaseBatchTaskBean() {
    }

    /**
     * ��¼��
     */
    public void setCountRecord() {
        countrecord = getRecordNumber(filename);
    }

    /**
     * ���
     */
    public void work() {
        this.start_end = true; // ���������־λ
        try {
            String fileInPath = filename;
            String fileOutPath = fileInPath.replaceFirst("\\.txt$",
                    "_result.txt");
            fileOutPath = fileOutPath.replaceFirst("\\.xls$",
            		"_result.txt");
            doProcessFile(fileInPath, fileOutPath);
        }catch (Exception ex) {
            setRunning(false);
            if(log.isErrorEnabled()){log.error(ex.getMessage());}
        }
    }

    /**
     * �����ļ�
     */
    public void doProcessFile(String fileInPath, String fileOutPath)
            throws Exception {
    	String ext = filename.substring(filename.lastIndexOf("."));
    	if (".xls".equalsIgnoreCase(ext)) {
    		doXlsProcessFile(fileInPath, fileOutPath);
    	} else {
    		doTxtProcessFile(fileInPath, fileOutPath);
    	}
    }

    /**
     * ����TXT�ļ�
     */
    public void doTxtProcessFile(String fileInPath, String fileOutPath)
            throws Exception {
        File resultFile = new File(fileOutPath);
        this.resultFile = fileOutPath;
        FileInputStream fileInputStream = new FileInputStream(fileInPath);
        InputStreamReader read = new InputStreamReader (fileInputStream, "gbk");
        BufferedReader rin=new BufferedReader(read);
        FileOutputStream fileOutputStream = new FileOutputStream(resultFile);
        OutputStreamWriter writer = new OutputStreamWriter (fileOutputStream, "gbk");
        BufferedWriter fos =new BufferedWriter(writer);
        try {
            // �ļ�����ʼ,д�����
            fos.write(doStart());
            String line;
            ResultVO resultVO = new ResultVO();
            int count = 0;
            while ((line = rin.readLine()) != null) {
                if (null != line && line.trim().length() > 0) {
                    ++count;
                    try{
                        resultVO = processLine(line.trim(), count); // �ؼ���������һ����¼
                        // д������
                        fos.write(resultVO.getInfo()+"\r\n");
                    }catch(Exception e){
                        fos.write(count+"|"+line +"|ʧ��|"+e.getMessage()+"\r\n");
                    }
                    if (resultVO.isOk()) {
                        ++ok;
                        // ����ֶ�
                    } else {
                        ++fail;
                    }
                    currentrecord++;
                }
            }
            // �ļ��������
            fos.write(doEnd());
        } catch (Exception ex) {
            fos.write(ex.getMessage());
            if(log.isErrorEnabled()){log.error(ex.getMessage());}
            fail=countrecord;
        }finally{
        	rin.close();
            read.close();
            fos.close();
            writer.close();
            this.resultFile = fileOutPath;
            currentrecord=countrecord;
            isComplete=true;
            if(isWriteLog){
	            if(ok==currentrecord){
	                writeLog(batchName,optype,"0");//�ɹ�
	            }else if(fail==currentrecord){
	                writeLog(batchName,optype,"1");//ʧ��
	            }else{
	                writeLog(batchName,optype,"2");//���ֳɹ�
	            }
            }else{
            	//deleteFile_(fileInPath);
            }
        }
    }

    /**
     * ����EXCEL�ļ�
     */
    public void doXlsProcessFile(String fileInPath, String fileOutPath)
            throws Exception {
        File resultFile = new File(fileOutPath);
        this.resultFile = fileOutPath;
        
        InputStream inputStream = null;
		Workbook workbook = null;
        
        FileOutputStream fileOutputStream = new FileOutputStream(resultFile);
        OutputStreamWriter writer = new OutputStreamWriter (fileOutputStream, "gbk");
        BufferedWriter fos =new BufferedWriter(writer);
        try {
        	inputStream = new FileInputStream(fileInPath);
			workbook = Workbook.getWorkbook(inputStream);
			Sheet sheet = workbook.getSheet(0);
            // �ļ�����ʼ,д�����
            fos.write(doStart());
            ResultVO resultVO = new ResultVO();
            int count = 0;
			for (int i = 0; i < sheet.getRows(); i++) {
				++count;
				Cell[] cells = sheet.getRow(i);
				StringBuffer stringBuffer = new StringBuffer();
				for (int j = 0; j < cells.length; j++) {
					String str = "";
					if (cells[j] != null && !"".equals(cells[j].getContents())) {
						str = cells[j].getContents().trim();
					}
					stringBuffer.append(str).append("|");
				}
                try{
                    resultVO = processLine(stringBuffer.toString(), count); // �ؼ���������һ����¼
                    // д������
                    fos.write(resultVO.getInfo()+"\r\n");
                }catch(Exception e){
                    fos.write(count+"|"+stringBuffer.toString() +"|ʧ��|"+e.getMessage()+"\r\n");
                }
                if (resultVO.isOk()) {
                    ++ok;
                    // ����ֶ�
                } else {
                    ++fail;
                }
                currentrecord++;
			}
            // �ļ��������
            fos.write(doEnd());
        } catch (Exception ex) {
            fos.write(ex.getMessage());
            if(log.isErrorEnabled()){log.error(ex.getMessage());}
            fail=countrecord;
        }finally{
        	if (workbook != null) {
				workbook.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
            fos.close();
            writer.close();
            this.resultFile = fileOutPath;
            currentrecord=countrecord;
            isComplete=true;
            if(isWriteLog){
	            if(ok==currentrecord){
	                writeLog(batchName,optype,"0");//�ɹ�
	            }else if(fail==currentrecord){
	                writeLog(batchName,optype,"1");//ʧ��
	            }else{
	                writeLog(batchName,optype,"2");//���ֳɹ�
	            }
            }else{
            	//deleteFile_(fileInPath);
            }
        }
    }

    // ----���������������������า��--------
    /**
     * �����ļ���ʼ���еĲ���,����д����ļ��ı���
     */
    protected String doStart() {
        return "";
    }

    /**
     * ����һ����¼
     */
    protected ResultVO processLine(String line, int rowCount) {
        return null;
    }

    /**
     * �����ļ���Ͻ��еĲ���
     * @throws Exception
     */
    protected String doEnd() throws Exception {
        return "";
    }

    protected void writeLog(String batchName,String oprtype,String success) throws Exception {
        //д��ʷ��¼��Ϣ
        if(isWriteLog){
            BatchlogDelegate batchlogDelegate=new BatchlogDelegate();
            BatchlogVO batchlogVO=new BatchlogVO();
            batchlogVO.setOprcode(user.getOpercode());
            batchlogVO.setOprwayid(user.getWayid());
            batchlogVO.setOptime(new Date());
            batchlogVO.setOprtype(oprtype);
            batchlogVO.setBatchname(batchName);
            try{//�Է�ftp�������Ӱ���¼��־
            	ftp = new FtpAccess(FtpInfo.getInstance());
            	batchlogVO.setUploadpath(uploadFile(filename, user.getOpercode()));
            	batchlogVO.setResultpath(uploadFile(resultFile, user.getOpercode()));
            }catch(Exception e){
            	log.error(e.getMessage());
            }
//            batchlogVO.setUploadpath(filename);
//            batchlogVO.setResultpath(resultFile);
            batchlogVO.setSuccess(success);
            batchlogDelegate.doCreate(batchlogVO, user);
        }
    }

    public String uploadFile(String filename, String oprcode) throws Exception {
    	String result = ftp.uploadFile(filename, oprcode, false);
        if (result == null) {
        	log.error(("�ϴ��ļ�ʧ�ܣ�" + filename));
		}
        return result;
    }

    /**
     * ɾ���ļ�
     */
    private void deleteFile_(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * ��ȡ�ļ�������
     */
    private int getRecordNumber(String filename) {
    	String ext = filename.substring(filename.lastIndexOf("."));
    	if (".xls".equalsIgnoreCase(ext)) {
    		return getXlsRecordNumber(filename);
    	} else {
    		return getTxtRecordNumber(filename);
    	}
    }

    /**
     * ��ȡTXT�ļ�������
     */
    private int getTxtRecordNumber(String filename) {
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
            rin.close();
        } catch (Exception ex) {
            return 0;
        }
        return numbers;
    }

    /**
     * ��ȡEXCEL�ļ�������
     */
    private int getXlsRecordNumber(String filename) {
    	int numbers = 0;
    	try {
    		InputStream inputStream = new FileInputStream(filename);
    		Workbook workbook = Workbook.getWorkbook(inputStream);
			Sheet sheet = workbook.getSheet(0);
			numbers = sheet.getRows();
			workbook.close();
			inputStream.close();
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
        if(isComplete){
            res = 100;
        }
        return res;
    }

    public synchronized boolean isStarted() {
        return started;
    }

    /**
     * �α��ж�
     */
    public synchronized boolean isCompleted() {
//		if (countrecord == 0) {
//			return true;
//		}
//		return currentrecord == countrecord;
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
     * �߳�����
     */
    public void run() {
        try {
            setRunning(true);
            setCountRecord();
            while (isRunning() && !isCompleted()) {
                work();
            }
        } catch(Exception ex){
        	if(log.isErrorEnabled()){log.error(ex.getMessage());}
        }
        finally {
            setRunning(false);
        }
    }

    /**
     * �쳣����
     *
     */
    public static String transException(Exception ex) {
        String message = ex.getMessage();
//		if (ex.getMessage().indexOf(
//				"java.sql.BatchUpdateException: Unique constraint") >= 0) {
//			message = "�����ظ�";
//		}
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

    public ActionForm getForm() {
        return form;
    }

    public void setForm(ActionForm form) {
        this.form = form;
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
}
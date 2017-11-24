package com.gmcc.pboss.common.ftp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.log4j.Logger;
import com.gmcc.pboss.common.utils.tools.FileUtil;
import com.gmcc.pboss.common.utils.tools.Sequence;
import com.sunrise.jop.ui.User;

public class FtpAccess {
    private static final Logger log = Logger.getRootLogger();
    private FtpInfo ftpinfo;
    public FTPClient ftp = null;
    public final static String PATH_SPLIT_STR = File.separator;
    public final static char PATH_SPLIT_CH = File.separatorChar;

    public FtpAccess(FtpInfo ftpInfo, User user)
            throws Exception {
        new FtpAccess(ftpInfo);
    }

    public FtpAccess(FtpInfo ftpInfo) throws Exception {

        this.ftpinfo = ftpInfo;
        try {
            ftp = new FTPClient();
            ftp.setControlEncoding("GBK");
            if(log.isInfoEnabled()){
            	log.info("ftpServer="+ftpInfo.ftpServer+" ftpPort="+ftpInfo.ftpPort+" ftpUser="+ftpInfo.ftpUser+" ftpPwd="+ftpInfo.ftpPwd);
            }
            try {//Ϊ��ֹ���õ�ftp���ӳ���������������ftp��ַ�ٴ�����
				ftp.connect(ftpInfo.ftpServer, ftpInfo.ftpPort);
				if(!ftp.login(ftpInfo.ftpUser, ftpInfo.ftpPwd)){
					throw new Exception("User or password error!");
				}
				ftp.setFileType(FTP.BINARY_FILE_TYPE);
			} catch (Exception e) {
				throw e;
			}
            String curpath = ftpInfo.curSerPath;
            if (curpath != null && !"".equals(curpath)) {
                boolean ok = ftp.changeWorkingDirectory(curpath);
                if(ok) {
                	log.info("��ǰĿ¼Ϊ"+curpath);
                }else {
                	boolean mkok = ftp.makeDirectory(curpath);
                	if(mkok) {
                		log.info("�½�Ŀ¼��"+curpath);
                	}
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("[FTP-MSG]\t�޷�����ftp������������ϵ����Ա");
        }
    }

    /**
     * �ϴ��ļ���ftp������
     *
     * @param localFileName �����ļ�����
     * @param remotePath    FTP�ϵ�·����ע�ⲻ�ܴ�����
     * @param genFileName   �Ƿ����Ψһ���ļ����ơ�����ԭ�ļ�����+���к�
     * @return �ɹ����ر��������ƣ����ɹ�����null
     */
    public String uploadFile(String localFileName, String remotePath, boolean genFileName) {
        File file = new File(localFileName);
        String result = null;
        if (file.exists()) {
            try {
            	String remoteFilePath=remotePath;
                if (remotePath == null) remotePath = "";
                String filename = file.getName();
                ftp.makeDirectory(remotePath);
                if (genFileName) { 
                    filename = changeFilename(filename, String.valueOf(Sequence.getSequence()));
                }
                if (!"".equals(remotePath)){ 
                	remoteFilePath = remotePath + "/" + filename;
                }
                else{
                	remoteFilePath = filename;
                }
                FileInputStream fis=new FileInputStream(file);
                boolean rlt = ftp.storeFile(remoteFilePath,fis );
                fis.close();
                if (rlt){
                	result = remoteFilePath;
                }
                else{
                	log.error("upload file failed��"+ftp.getReplyString() + ":" +ftp.getReplyCode());
                }
            } catch (Exception e) {
                log.error("upload file failed��"+ftp.getReplyString() + ":" +ftp.getReplyCode());
                log.error(e.getMessage());
            }
        }
        return result;
    }
    /**
     * �ϴ��ļ���ftp������
     *
     * @param file �����ļ�
     * @param remotePath    FTP�ϵ�·����ע�ⲻ�ܴ�����
     * @param genFileName   �Ƿ����Ψһ���ļ����ơ�����ԭ�ļ�����+���к�
     * @return �ɹ����ر��������ƣ����ɹ�����null
     */
    public String uploadFile(File file , String remotePath, boolean genFileName) {
        String result = null;
        if (file.exists()) {
            try {
            	String remoteFilePath=remotePath;
                if (remotePath == null) remotePath = "";
                String filename = file.getName();
                ftp.makeDirectory(remotePath);
                if (genFileName) { 
                    filename = changeFilename(filename, String.valueOf(Sequence.getSequence()));
                }
                if (!"".equals(remotePath)){ 
                	remoteFilePath = remotePath + "/" + filename;
                }
                else{
                	remoteFilePath = filename;
                }
                FileInputStream fis=new FileInputStream(file);
                boolean rlt = ftp.storeFile(remoteFilePath,fis );
                fis.close();
                if (rlt){
                	result = remoteFilePath;
                }
                else{
                	log.error("upload file failed��"+ftp.getReplyString() + ":" +ftp.getReplyCode());
                }
            } catch (Exception e) {
                log.error("upload file failed��"+ftp.getReplyString() + ":" +ftp.getReplyCode());
                log.error(e.getMessage());
            }
        }
        return result;
    }
    /**
     * �ϴ��ļ���ftp������
     * ��Ȩ��������ר���ϴ�����
     * @param file �����ļ�
     * @param remotePath    FTP�ϵ�·����ע�ⲻ�ܴ�����
     * @param genFileName   �Ƿ����Ψһ���ļ����ơ�����ԭ�ļ�����+���к�
     * @param localfilename �����ļ�����
     * @return �ɹ����ر��������ƣ����ɹ�����null
     * @author yangdaren
     */
    public String uploadFile(File file , String remotePath, boolean genFileName, String localfilename) {
        String result = null;
        if (file.exists()) {
            try {
            	String remoteFilePath=remotePath;
                if (remotePath == null) remotePath = "";
                String filename = localfilename;//file.getName();ʹ�ñ����ļ�����
                ftp.makeDirectory(remotePath);
                if (genFileName) { 
                    filename = changeFilename(filename, String.valueOf(Sequence.getSequence()));
                }
                if (!"".equals(remotePath)){ 
                	remoteFilePath = remotePath + "/" + filename;
                }
                else{
                	remoteFilePath = filename;
                }
                FileInputStream fis=new FileInputStream(file);
                boolean rlt = ftp.storeFile(remoteFilePath,fis );
                fis.close();
                if (rlt){
                	result = remoteFilePath;
                }
                else{
                	log.error("upload file failed��"+ftp.getReplyString() + ":" +ftp.getReplyCode());
                }
            } catch (Exception e) {
                log.error("upload file failed��"+ftp.getReplyString() + ":" +ftp.getReplyCode());
                log.error(e.getMessage());
            }
        }
        return result;
    }
    
    /**
     * �ϴ�ͼƬ��ftp������
     * ��Ȩ��������ר���ϴ�����
     * @param file �����ļ�
     * @param remotePath    FTP�ϵ�·����ע�ⲻ�ܴ�����
     * @param genFileName   �Ƿ����Ψһ���ļ����ơ�����ԭ�ļ�����+���к�
     * @param localfilename �����ļ�����
     * @return �ɹ����ر��������ƣ����ɹ�����null
     * @author a-biao
     */
    public String uploadFile2(File file , String remotePath, boolean genFileName, String localfilename) {
        String result = null;
        if (file.exists()) {
            try {
            	String remoteFilePath=remotePath;
                if (remotePath == null) remotePath = "";
                String filename = localfilename;//file.getName();ʹ�ñ����ļ�����
                ftp.makeDirectory(remotePath);
                //Ʒ���Ǳ�˵����Ҫ������������ע���������д���
//                if (genFileName) { 
//                    filename = changeFilename(filename, String.valueOf(Sequence.getSequence()));
//                }
                if (!"".equals(remotePath)){ 
                	remoteFilePath = remotePath + "/" + filename;
                }
                else{
                	remoteFilePath = filename;
                }
                FileInputStream fis=new FileInputStream(file);
                boolean rlt = ftp.storeFile(remoteFilePath,fis );
                fis.close();
                if (rlt){
                	result = remoteFilePath;
                }
                else{
                	log.error("upload file failed��"+ftp.getReplyString() + ":" +ftp.getReplyCode());
                }
            } catch (Exception e) {
                log.error("upload file failed��"+ftp.getReplyString() + ":" +ftp.getReplyCode());
                log.error(e.getMessage());
            }
        }
        return result;
    }
    /**
     * �ϴ��ļ���ftp������
     * @param tempFile 		Struts2���ɵı�����ʱ�ļ�
     * @param realFileName  ��ʵ�ļ��� �������ļ���ǰ����ǰ׺:yyyyMMddHHmmssXXXX_(XXXXΪ��λ�����)
     * @param remotePath    FTP�ϵ�Ŀ¼·��(�������ļ���)����ֵΪ���ַ���""ʱ����ʾ��ǰĿ¼
     * @return �ɹ����ر��������ƣ����ɹ�����null
     * @throws Exception
     */
    public void doUploadFile(File tempFile , String realFileName, String remotePath) throws Exception{
        if (tempFile.exists()) {
        	InputStream fis = null;
            try {
            	if(remotePath != null && !"".equals(remotePath)) {
            		if(!remotePath.startsWith("/")) {
            			// ���·��
            			remotePath = ftpinfo.curSerPath+"/"+remotePath;
            		}
            		boolean changeDir = ftp.changeWorkingDirectory(remotePath);
            		if(!changeDir) {
            			// ��Ŀ¼������ʱ����Ŀ¼
            			boolean makeDir = ftp.makeDirectory(remotePath);
            			if(makeDir) {
            				// �����ɹ��򽫸�Ŀ¼��Ϊ����Ŀ¼
            				ftp.changeWorkingDirectory(remotePath);
            			}else {
            				throw new Exception("����Ŀ¼  "+remotePath+" ʧ��");
            			}
            		}
            	}
                
                fis=new BufferedInputStream(new FileInputStream(tempFile));
                boolean rlt = ftp.storeFile(realFileName,fis );
               
                if(!rlt){
                	log.error("upload file failed��"+ftp.getReplyString() + ":" +ftp.getReplyCode());
                	throw new Exception("[FTP-MSG]\t�ϴ��ļ�ʧ��,���ܵ�ԭ��"+ftp.getReplyString());
                }
            } catch (Exception e) {
                log.error("upload file failed��"+ftp.getReplyString() + ":" +ftp.getReplyCode());
                log.error(e.getMessage());
                throw e;
            } finally {
            	if(fis != null) {
            		try {
            			fis.close();
            		}catch(IOException ex) {
            			ex.printStackTrace();
            		}
            	}
            }
        }
    }


    /**
     * �ϴ��ļ���ftp���������������ͬ����������һ����������ڱ����ļ����������Ͳ�ͬ
     *
     * @param localFileName �����ļ����ƣ�ҳ����󣬷��ַ���
     * @param remotePath    FTP�ϵ�·����ע�ⲻ�ܴ�����
     * @param genFileName   �Ƿ����Ψһ���ļ����ơ�����ԭ�ļ�����+���к�
     * @return �ɹ����ر��������ƣ����ɹ�����null
     */
//    public String uploadFile(FormFile localFileName, String remotePath, boolean genFileName) {
//        String result = null;
//        if (localFileName!=null) {
//            try {
//                if (remotePath == null) remotePath = "";
//                String filename = localFileName.getFileName();
//                ftp.makeDirectory(remotePath);
//                if (genFileName) {
//                    filename = changeFilename(filename, String.valueOf(Sequence.getSequence()));
//                }
//                if (!remotePath.equals("")) remotePath = remotePath + "/" + filename;
//                else remotePath = filename;
//                ftp.setFileType(ftp.BINARY_FILE_TYPE);//�����ϴ�ģʽΪ������ģʽ
//                boolean rlt = ftp.storeFile(remotePath, new BufferedInputStream(localFileName.getInputStream()));
//
//                if (rlt) result = remotePath;
//            } catch (Exception e) {
//                log.error("upload file failed��"+ftp.getReplyString() + ":" +ftp.getReplyCode());
//                e.printStackTrace();
//            }
//        }
//        return result;
//    }

    /**
     * ���ļ��� filename.xxx ����Ϊ filename_extname.xxx
     * @param filename ԭ�ļ�����
     * @param extname �ļ������ϵĺ�׺��
     * @return ���ļ�����
     */
    public String changeFilename(String filename, String extname){
        if (filename == null || filename.equals("")) return filename;
        int pos = filename.indexOf(".");
        if (pos < 0) return filename + "_" + extname;
        else{
            String name = filename.substring(0, pos);
            return name + "_" + extname + filename.substring(pos);
        }
    }

    /**
     * ɾFTP�ϵ��ļ�
     * @param filename �ļ�����
     * @return �Ƿ�ɹ�
     * @throws IOException �쳣
     */
    public boolean deleteFilename(String filename) throws IOException {
        if (filename == null || filename.equals("")) return true;
        return ftp.deleteFile(filename);
    }

    /**
     * �����ļ�������Ŀ¼
     *
     * @param localPath ���ص����ص�·��
     * @param remoteFilePath FTP�ϵ�Զ���ļ�����
     * @return ���غ���ļ�·��
     */
    public String downloadFile(String localPath, String remoteFilePath) {
        if (localPath == null || localPath.equals("") || remoteFilePath == null || remoteFilePath.equals("")) return null;
        String result = null;

        String filename = getFilenameFromPath(remoteFilePath);
        if (filename != null) localPath = localPath + File.separator + filename;
        File file = new File(localPath);
        if (file.exists()) file.delete();
        try {
            FileOutputStream fio = new FileOutputStream(file);
            boolean rlt = ftp.retrieveFile(remoteFilePath, fio);
            if (rlt){
            	result = localPath;
            }else{
            	log.error("download file failed"+ftp.getReplyString());
            }
            fio.close();
        } catch (IOException e) {
            log.error("download file failed��"+ftp.getReplyString() + ":" +ftp.getReplyCode());
            e.printStackTrace();
        }
        return result;
    }

    private String getFilenameFromPath(String remoteFilePath) {
        int pos = remoteFilePath.lastIndexOf("/");
        if (pos >=0) {
            return remoteFilePath.substring(pos + 1);
        } else {
        	return remoteFilePath;
        }
    }

    /**
     * �ϴ��ļ���ftp������(֧�ֶ��ļ��ϴ�)
     *
     * @return
     */
//    public String[] putFiles(List filelist)
//            throws Exception {
//        if ((filelist == null) || (filelist.size() == 0)) {
//            return new String[]{"[FTP-MSG]\t�ϴ��ļ��б�Ϊ��"};
//        }
//
//        int allCount = filelist.size();
//        int errCount = 0;
//        int susCount = 0;
//
//        String dealmsg[] = new String[allCount];
//        InputStream inStream = null;
//        FormFile file = null;
//        String filename = null;
//
//        for (int i = 0; i < allCount; i++) {
//            try {
//                file = (FormFile) filelist.get(i);
//                if (file == null) {
//                    throw new Exception("�ϴ��ļ�Ϊ��");
//                }
//
//                filename = file.getFileName();
//                inStream = file.getInputStream();
//                if (ftp != null) {
//                    ftp.storeFile(filename, inStream);
//                    susCount ++;
//                    dealmsg[i] = "[FTP-MSG]\t�ļ�[" + filename + "]" + "�ϴ��ɹ�";
//                    log.info("[FTP-MSG]\t�ļ�[" + filename + "]" + "�ϴ��ɹ�");
//                } else {
//                	errCount ++;
//                    dealmsg[i] = "[FTP-MSG]\t�ļ�[" + filename + "]" + "�ϴ�ʧ�� : ftp�����쳣";
//                    log.info("[FTP-MSG]\t�ļ�[" + filename + "]" + "�ϴ�ʧ�� : ftp�����쳣");
//                }
//            } catch (Exception ex) {
//                errCount ++;
//                dealmsg[i] = "[FTP-MSG]\t�ļ�[" + filename + "]" + "�ϴ�ʧ�� : " + ex.getMessage();
//                log.info("[FTP-MSG]\t�ļ�[" + filename + "]" + "�ϴ�ʧ�� : " + ex.getMessage());
//                log.error("ftp error code��"+ftp.getReplyString() + ":" +ftp.getReplyCode());
//            }
//        }
//
//        if (ftp != null) {
//            ftp.logout();
//            ftp.disconnect();
//        }
//
//        return dealmsg;
//    }

    public String getFileName(String local) {
        int last = local.lastIndexOf("\\");
        String filename = local.substring(last + 1, local.length());
        return filename;
    }
    
    public static void doDownloadFile(FtpInfo ftpInfo,  String filename, HttpServletResponse response)
            throws Exception {
        if ((filename == null) || "".equals(filename)) {
            throw new Exception("[FTP-MSG]\t�����ļ��б�Ϊ��");
        }

        FTPClient ftpclient = null;
        try {
            //����ftp
            ftpclient = new FTPClient();
            ftpclient.setControlEncoding("GBK"); // ����ļ�����������ʱ�Ҳ����ļ���bug
            ftpclient.connect(ftpInfo.ftpServer, ftpInfo.ftpPort);
            ftpclient.login(ftpInfo.ftpUser, ftpInfo.ftpPwd);
            ftpclient.setFileType(FTP.BINARY_FILE_TYPE);
        } catch (Exception ex) {
            log.error("ftp error code��"+ftpclient.getReplyString() + ":" +ftpclient.getReplyCode());
            throw new Exception("[FTP-MSG]\t�޷�����ftp������������ϵ����Ա");
        }

        //�ı�ftp·��
        String curpath = ftpInfo.curSerPath;
        if (curpath != null && !"".equals(curpath)) {
            ftpclient.changeWorkingDirectory(curpath);
        }

        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-control", "public");
        response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
        String fn = null;

        InputStream in = null;
        OutputStream out = null;
        byte[] buffer = new byte[1024];
        int len = 0;

        try {       	
        	in = ftpclient.retrieveFileStream(filename);
            
            if(in == null) 
            	throw new Exception("[FTP-MSG]\t�������ļ�������");
            
            fn = "attachment; filename=" + FileUtil.toUtf8String(filename);
            
    		response.setCharacterEncoding("GBK");
            response.setHeader("Content-Disposition", fn);
            response.setContentType("application/x-msdownload");

            len = 0;
            
            if (out == null) {
                out = response.getOutputStream();
            }

            while ((len = in.read(buffer, 0, buffer.length)) > 0) {
                out.write(buffer, 0, len);
            }

            log.info("[FTP-MSG]\t�ɹ�������Ϊ[" + filename + "]���ļ�");
            
        } catch (Exception ex) {
            log.error("ftp error code��"+ftpclient.getReplyString() + ":" +ftpclient.getReplyCode());
            ex.printStackTrace();
            throw ex;
        } finally {
            if (in != null) {
            	try {
            		in.close();
            	}catch(IOException ex) {
            		log.error("���ر�ʧ��");
            	}
            }
            if (out != null) {
            	try {
            		out.close();
            	}catch(Exception ex) {
            		log.error("���ر�ʧ��");
            	}
            }
            if (ftpclient != null) {
                try {
                    ftpclient.logout();
                    ftpclient.disconnect();
                } catch (Exception ex) {
                    log.error("ftp error code��"+ftpclient.getReplyString() + ":" +ftpclient.getReplyCode());
                    throw new Exception("[FTP-MSG]\t�Ͽ�ftp����������ʧ��:" + ex.getMessage());
                }
            }
        }
    }


    /**
     * �����ļ�������Ŀ¼(֧�ֶ��ļ�����)
     *
     * @return
     */
    public String[] getFiles(List filelist, String destpath, String regx[])
            throws Exception {
        if ((filelist == null) || (filelist.size() == 0)) {
            return new String[]{"[FTP-MSG]\t�����ļ��б�Ϊ��"};
        }
        if (destpath == null || "".equals(destpath)) {
            throw new Exception("[FTP-MSG]\t�������ļ�����·��");
        }

        int allCount = filelist.size();
        int errCount = 0;
        int susCount = 0;

        String dealmsg[] = new String[allCount];
        FileOutputStream outStream = null;
        File file = new File(destpath);
        if (!file.exists()) {
            file.mkdir();
        }
        if (!file.isDirectory()) {
            throw new Exception("[FTP-MSG]\t����·��������Ŀ¼,�������ļ����߷Ƿ�·����");
        }

        String filename = null;
        if (destpath.charAt(destpath.length() - 1) != PATH_SPLIT_CH) {
            destpath += PATH_SPLIT_STR;
        }
        for (int i = 0; i < filelist.size(); i++) {
            try {
                filename = (String) filelist.get(i);
                outStream = new FileOutputStream(destpath + filename);
                ftp.retrieveFile(filename, outStream);

                susCount ++;
                dealmsg[i] = "[FTP-MSG]\t�ɹ�������Ϊ[" + filename + "]���ļ�";
                log.info("[FTP-MSG]\t�ɹ�������Ϊ[" + filename + "]���ļ�");
            } catch (Exception ex) {
                log.error("ftp error code��"+ftp.getReplyString() + ":" +ftp.getReplyCode());
                ex.printStackTrace();
                errCount ++;
                dealmsg[i] = "[FTP-MSG]\t�ļ�[" + filename + "]����ʧ��:" + ex.getMessage();
                log.info("[FTP-MSG]\t�ļ�[" + filename + "]����ʧ��:" + ex.getMessage());
            }finally{
            	outStream.close();
            }
        }

        if (ftp != null) {
            ftp.logout();
            ftp.disconnect();
        }

        return dealmsg;
    }

    /**
     * ��ȡָ��Ŀ¼���ļ��б�
     */
    public String[] getFileList(String destpath)
            throws Exception {
        if (destpath == null || "".equals(destpath)) {
            throw new Exception("[FTP-MSG]\tҪ��ʾ�б��Ŀ¼Ϊ��");
        }

        if (ftp != null && ftp.isConnected()) {
            ftp.changeWorkingDirectory(destpath);
            return ftp.listNames();
        } else {
            throw new Exception("[FTP-MSG]\tftp���ӳ�ʱ���߱��ж�");
        }
    }
    
    /**���� ���ⲻҪʹ��
     * 
     * @throws SocketException
     * @throws IOException
     */
    private void connect() throws SocketException, IOException{
    	if( null == ftp )
    		ftp = new FTPClient();
    	if( !ftp.isConnected()){
    		ftp.connect(ftpinfo.ftpServer, ftpinfo.ftpPort);
    	ftp.login(ftpinfo.ftpUser, ftpinfo.ftpPwd); 
    	}
    }
    
    public void diConnect() throws IOException{
    	if(null != ftp && ftp.isConnected()){
    		ftp.logout();
    		ftp.disconnect();
    	}
    }
    /**
     * �ж�Ŀ¼�Ƿ����
     * @param path��Ŀ¼·����������û���¼���ҪĿ¼�����·����
     * @return�����ڣ��ԣңգš����򣺣ƣ��̣ӣ�
     * @throws IOException
     */
    public boolean isExitDir(String path) throws IOException{
		return ftp.changeWorkingDirectory(path);
	}
    
    /**
     * ����Ŀ¼
     * @param pathName	��Ŀ¼·��
     * @param dirName����ǰҪ������Ŀ¼����
     * @return���ɹ������Ѿ����ڸ�Ŀ¼�����ԣңգš����򣺣ƣ��̣ӣ�
     * @throws IOException
     */
    public  boolean createDir(String pathName,String dirName) throws IOException{
//		ftp.changeWorkingDirectory(pathName);
		String[] path = pathName.split("[/\\\\]");
		List<String> pathList = Arrays.asList(path);
		ftp.changeWorkingDirectory("/");
		for(String dir:pathList){
			if(!isExitDir(dir))
			ftp.makeDirectory(dir);
			ftp.changeWorkingDirectory(dir);
		}
		if(!isExitDir(pathName+dirName))
		return ftp.makeDirectory(pathName+dirName);
		return true;
	}
    
    /**
     * �ϴ��ļ�
     * @param path	�ϴ����ļ�����Ŀ¼
     * @param in	�����ļ���
     * @param fileName	�ϴ��ļ�����
     * @return���ϴ��ɹ����ԣңգš����򣺣ƣ��̣ӣ�
     * @throws IOException
     */
    public boolean uploadFile(String path,InputStream in,String fileName) throws IOException {
    	connect();
		String realName = path+fileName;
		return ftp.storeFile(realName, in);
	}
    
    /**
     * ��ȡָ��Ŀ¼�������ļ�������Ŀ¼���б�
     * @param pathname��Ŀ¼����Ը�Ŀ¼������·����
     * @return
     * @throws IOException
     */
    public  FTPFile[] getFiles(String pathname) throws IOException {
		return ftp.listFiles(pathname);
	}
    public static void main(String[] args)throws Exception {
        FtpInfo fi = FtpInfo.getInstance();
        FtpAccess fa = null;
        try {
            fa = new FtpAccess(fi);
            String[] fileList = fa.getFileList("/root/run/java/bin");
            
            String regex = "fl[0-9].sh";
            for(String filename : fileList) {
            	if(filename.matches(regex)) {
            		fa.downloadFile("E:/temp", "/root/run/java/bin/"+filename);
            	}
            }

//            int reply = fa.ftp.getReplyCode();
//            String result = fa.uploadFile("d:/test.txt", "", true);
//
//            if (result != null)
//				System.out.println("success :" + result);
//			else
//				System.out.println("failed :" + result);
//
//            System.out.println("ftp reply = " + reply);
//            String rlt = fa.downloadFile("d:/temp/", result);
//            if (rlt != null)
//				System.out.println("download success");
//			else
//				System.out.println("download failed");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	if (fa !=null && fa.ftp != null) {
                try {
                	fa.ftp.logout();
                	fa.ftp.disconnect();
                } catch (Exception ex) {
                    log.error("ftp error code��"+fa.ftp.getReplyString() + ":" +fa.ftp.getReplyCode());
                    throw new Exception("[FTP-MSG]\t�Ͽ�ftp����������ʧ��:" + ex.getMessage());
                }
            }
        }

    }

}

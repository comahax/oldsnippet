package com.gmcc.pboss.common.file.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Sequence;
import javax.xml.registry.infomodel.User;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;

import com.common.util.file.FileUtil;
import com.gmcc.pboss.common.file.bean.ServerInfoBean;

/**
 * ���˹�˾Ӫ���з���
 * 
 * @author zhangshiwei
 * @date 2010-1-25 ������Ŀ��PBOSS ����ģ�飺���� ������FTP���ʽӿ�
 */
public class FtpAccess {
    private static final Logger log = Logger.getRootLogger();
    private ServerInfoBean ftpinfo;
    public FTPClient ftp = null;
    public final static String PATH_SPLIT_STR = File.separator;
    public final static char PATH_SPLIT_CH = File.separatorChar;

    public FtpAccess(ServerInfoBean ftpInfo, User user)
            throws Exception {
        new FtpAccess(ftpInfo);
    }

    public FtpAccess(ServerInfoBean ftpInfo) throws Exception {

        this.ftpinfo = ftpInfo;
        try {
            ftp = new FTPClient();
            ftp.setControlEncoding("GBK");
            if(log.isInfoEnabled()){
            	log.info("ftpServer="+ftpInfo.getIp()+" ftpPort="+ftpInfo.getPort()+" ftpUser="+ftpInfo.getUsername()+" ftpPwd="+ftpInfo.getPassword());
            }
            try {//Ϊ��ֹ���õ�ftp���ӳ���������������ftp��ַ�ٴ�����
				ftp.connect(ftpInfo.getIp(), ftpInfo.getPort());
				if(!ftp.login(ftpInfo.getUsername(), ftpInfo.getPassword())){
					throw new Exception("User or password error!");
				}
				ftp.setFileType(FTP.BINARY_FILE_TYPE);
			} catch (Exception e) {
				//����ftp���ӵ�ַ,��ǿ�ݴ���
				if(!"10.243.212.40".equals(ftpInfo.getIp())){
					ftpInfo.setIp("10.243.212.40");
					ftpInfo.setPort(21);
//					ftpInfo.setUsername("cxbak");
//					ftpInfo.setPassword("cxbak123");
					ftpInfo.setWorkdir("cxbak");
					//�ٴ�����
					ftp.connect(ftpInfo.getIp(), ftpInfo.getPort());
					if(!ftp.login(ftpInfo.getUsername(), ftpInfo.getPassword())){
						throw new Exception("User or password error!");
					}
				}else{
					throw e;
				}
			}
            String curpath = ftpInfo.getWorkdir();
            if (curpath != null && !"".equals(curpath)) {
                ftp.changeWorkingDirectory(curpath);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("[FTP-MSG]\t�޷�����ftp������������ϵ����Ա");
        }
    }

    
    /**
     * �ϴ��ļ���ftp������
     *
     * @param tempFile 		Struts2���ɵı�����ʱ�ļ�
     * @param realFileName  ��ʵ�ļ���
     * @param remotePath    FTP�ϵ�·����ע�ⲻ�ܴ�����
     * @return �ɹ����ر��������ƣ����ɹ�����null
     */
    public String doUploadFile(File tempFile , String realFileName, String remotePath) {
        String result = null;
        if (tempFile.exists()) {
        	InputStream fis = null;
            try {
            	String remoteFilePath=remotePath;
                if (remotePath == null) remotePath = "";
                ftp.makeDirectory(remotePath);
                if (!"".equals(remotePath)){ 
                	remoteFilePath = remotePath + "/" + realFileName;
                }
                else{
                	remoteFilePath = realFileName;
                }
                fis=new BufferedInputStream(new FileInputStream(tempFile));
                boolean rlt = ftp.storeFile(remoteFilePath,fis );
               
                if (rlt){
                	result = remoteFilePath;
                }
                else{
                	log.error("upload file failed��"+ftp.getReplyString() + ":" +ftp.getReplyCode());
                }
            } catch (Exception e) {
                log.error("upload file failed��"+ftp.getReplyString() + ":" +ftp.getReplyCode());
                log.error(e.getMessage());
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
        return result;
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
        if (filename != null) localPath = localPath + "/" + filename;
        File file = new File(localPath);
        if (file.exists()) file.delete();
        try {
            FileOutputStream fio = new FileOutputStream(file);
            boolean rlt = ftp.retrieveFile(remoteFilePath, fio);
            if (rlt){
            	result = localPath;
            }else{
            	log.error("download file failed:"+ftp.getReplyString()+"[localPath:"+localPath+"] [remoteFilePath:"+ remoteFilePath +"]");
            }
            fio.close();
        } catch (IOException e) {
            log.error("download file I/O failed��"+ftp.getReplyString() + ":" +ftp.getReplyCode()+"[localPath:"+localPath+"] [remoteFilePath:"+ remoteFilePath +"]");
            e.printStackTrace();
        }
        return result;
    }
    
    public String downloadFileWithFileName(String localPath, String remoteFilePath) {
        if (localPath == null || localPath.equals("") || remoteFilePath == null || remoteFilePath.equals("")) return null;
        String result = null;

        File file = new File(localPath);
        if (file.exists()) file.delete();
        try {
            FileOutputStream fio = new FileOutputStream(file);
            boolean rlt = ftp.retrieveFile(remoteFilePath, fio);
            if (rlt){
            	result = localPath;
            }else{
            	log.error("download file failed:"+ftp.getReplyString()+"[localPath:"+localPath+"] [remoteFilePath:"+ remoteFilePath +"]");
            }
            fio.close();
        } catch (IOException e) {
            log.error("download file I/O failed��"+ftp.getReplyString() + ":" +ftp.getReplyCode()+"[localPath:"+localPath+"] [remoteFilePath:"+ remoteFilePath +"]");
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
    
    public static void doDownloadFile(ServerInfoBean ftpInfo,  String filename, HttpServletResponse response)
            throws Exception {
        if ((filename == null) || "".equals(filename)) {
            throw new Exception("[FTP-MSG]\t�����ļ��б�Ϊ��");
        }

        FTPClient ftpclient = null;
        try {
            //����ftp
            ftpclient = new FTPClient();
            ftpclient.setControlEncoding("GBK"); // ����ļ�����������ʱ�Ҳ����ļ���bug
            ftpclient.connect(ftpInfo.getIp(), ftpInfo.getPort());
            ftpclient.login(ftpInfo.getUsername(), ftpInfo.getPassword());
            ftpclient.setFileType(FTP.BINARY_FILE_TYPE);
        } catch (Exception ex) {
            log.error("ftp error code��"+ftpclient.getReplyString() + ":" +ftpclient.getReplyCode());
            throw new Exception("[FTP-MSG]\t�޷�����ftp������������ϵ����Ա");
        }

        //�ı�ftp·��
        String curpath = ftpInfo.getWorkdir();
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
            
            fn = "attachment; filename=" + FileHandleUtil.toUtf8String(filename);
            
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

}

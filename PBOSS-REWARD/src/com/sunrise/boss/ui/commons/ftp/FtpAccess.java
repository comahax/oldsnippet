package com.sunrise.boss.ui.commons.ftp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.pub.tools.Sequence;

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
			} catch (Exception e) {
				//����ftp���ӵ�ַ,��ǿ�ݴ���
				if(!"10.243.212.40".equals(ftpInfo.ftpServer)){
					ftpInfo.ftpServer="10.243.212.40";
					ftpInfo.ftpPort=21;
					ftpInfo.ftpUser="cxbak";
					ftpInfo.ftpPwd="cxbak123";
					ftpInfo.curSerPath="cxbak";
					//�ٴ�����
					ftp.connect(ftpInfo.ftpServer, ftpInfo.ftpPort);
					if(!ftp.login(ftpInfo.ftpUser, ftpInfo.ftpPwd)){
						throw new Exception("User or password error!");
					}
				}else{
					throw e;
				}
			}
            String curpath = ftpInfo.curSerPath;
            if (curpath != null && !"".equals(curpath)) {
                ftp.changeWorkingDirectory(curpath);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("[FTP-MSG]\t" + ftp.getReplyCode() + " connect ftp error!:" + ex.getMessage());
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
                if (!remotePath.equals("")){ 
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
     * �ϴ��ļ���ftp���������������ͬ����������һ����������ڱ����ļ����������Ͳ�ͬ
     *
     * @param localFileName �����ļ����ƣ�ҳ����󣬷��ַ���
     * @param remotePath    FTP�ϵ�·����ע�ⲻ�ܴ�����
     * @param genFileName   �Ƿ����Ψһ���ļ����ơ�����ԭ�ļ�����+���к�
     * @return �ɹ����ر��������ƣ����ɹ�����null
     */
    public String uploadFile(FormFile localFileName, String remotePath, boolean genFileName) {
        String result = null;
        if (localFileName!=null) {
            try {
                if (remotePath == null) remotePath = "";
                String filename = localFileName.getFileName();
                ftp.makeDirectory(remotePath);
                if (genFileName) {
                    filename = changeFilename(filename, String.valueOf(Sequence.getSequence()));
                }
                if (!remotePath.equals("")) remotePath = remotePath + "/" + filename;
                else remotePath = filename;
                ftp.setFileType(ftp.BINARY_FILE_TYPE);//�����ϴ�ģʽΪ������ģʽ
                boolean rlt = ftp.storeFile(remotePath, new BufferedInputStream(localFileName.getInputStream()));

                if (rlt) result = remotePath;
            } catch (Exception e) {
                log.error("upload file failed��"+ftp.getReplyString() + ":" +ftp.getReplyCode());
                e.printStackTrace();
            }
        }
        return result;
    }

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
    public String[] putFiles(List filelist)
            throws Exception {
        if ((filelist == null) || (filelist.size() == 0)) {
            return new String[]{"[FTP-MSG]\t�ϴ��ļ��б�Ϊ��"};
        }

        int allCount = filelist.size();
        int errCount = 0;
        int susCount = 0;

        String dealmsg[] = new String[allCount];
        InputStream inStream = null;
        FormFile file = null;
        String filename = null;

        for (int i = 0; i < allCount; i++) {
            try {
                file = (FormFile) filelist.get(i);
                if (file == null) {
                    throw new Exception("�ϴ��ļ�Ϊ��");
                }

                filename = file.getFileName();
                inStream = file.getInputStream();
                if (ftp != null) {
                    ftp.storeFile(filename, inStream);
                    susCount ++;
                    dealmsg[i] = "[FTP-MSG]\t�ļ�[" + filename + "]" + "�ϴ��ɹ�";
                    log.info("[FTP-MSG]\t�ļ�[" + filename + "]" + "�ϴ��ɹ�");
                } else {
                	errCount ++;
                    dealmsg[i] = "[FTP-MSG]\t�ļ�[" + filename + "]" + "�ϴ�ʧ�� : ftp�����쳣";
                    log.info("[FTP-MSG]\t�ļ�[" + filename + "]" + "�ϴ�ʧ�� : ftp�����쳣");
                }
            } catch (Exception ex) {
                errCount ++;
                dealmsg[i] = "[FTP-MSG]\t�ļ�[" + filename + "]" + "�ϴ�ʧ�� : " + ex.getMessage();
                log.info("[FTP-MSG]\t�ļ�[" + filename + "]" + "�ϴ�ʧ�� : " + ex.getMessage());
                log.error("ftp error code��"+ftp.getReplyString() + ":" +ftp.getReplyCode());
            }
        }

        if (ftp != null) {
            ftp.logout();
            ftp.disconnect();
        }

        return dealmsg;
    }

    public String getFileName(String local) {
        int last = local.lastIndexOf("\\");
        String filename = local.substring(last + 1, local.length());
        return filename;
    }

    public static void getFiles(FtpInfo ftpInfo, User user, List filelist, HttpServletResponse response)
            throws Exception {
        if ((filelist == null) || (filelist.size() == 0)) {
            throw new Exception("[FTP-MSG]\t�����ļ��б�Ϊ��");
        }

        FTPClient ftpclient = null;
        try {
            //����ftp
            ftpclient = new FTPClient();
            ftpclient.connect(ftpInfo.ftpServer, ftpInfo.ftpPort);
            ftpclient.login(ftpInfo.ftpUser, ftpInfo.ftpPwd);
        } catch (Exception ex) {
            log.error("ftp error code��"+ftpclient.getReplyString() + ":" +ftpclient.getReplyCode());
            throw new Exception("[FTP-MSG]\t����ftp������ʧ��:" + ex.getMessage());
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

        String filename = null;
        InputStream in = null;
        OutputStream out = null;
        byte[] buffer = new byte[1024];
        int len = 0;

        try {
            for (int i = 0; i < filelist.size(); i++) {
                filename = (String) filelist.get(i);

                fn = "attachment; filename=" + filename;
                response.setHeader("Content-Disposition", new String(fn.getBytes("GB2312"), "ISO-8859-1"));
                response.setContentType("application/x-msdownload");

                len = 0;
                in = ftpclient.retrieveFileStream(filename);
                if (out == null) {
                    out = response.getOutputStream();
                }

                while ((len = in.read(buffer, 0, buffer.length)) > 0) {
                    out.write(buffer, 0, len);
                }

                log.info("[FTP-MSG]\t�ɹ�������Ϊ[" + filename + "]���ļ�");
            }
        } catch (Exception ex) {
            log.error("ftp error code��"+ftpclient.getReplyString() + ":" +ftpclient.getReplyCode());
            ex.printStackTrace();
            throw ex;
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
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

    public static void main(String[] args) {
        FtpInfo fi = new FtpInfo();
        fi.ftpServer = "10.200.30.24";
        fi.ftpPort = 21;
        fi.curSerPath = "test";
        fi.ftpUser = "anonymous";
        fi.ftpPwd = "anonymous@anonymous.com";
        try {
            FtpAccess fa = new FtpAccess(fi);

            int reply = fa.ftp.getReplyCode();
            String result = fa.uploadFile("c:\\temp\\SMS_SIJM070314.004", "aaa", true);

            if (result != null) System.out.println("success :" + result);
            else System.out.println("failed :" + result);

            System.out.println("ftp reply = " + reply);


            String rlt = fa.downloadFile("c:/temp/", result);
            if (rlt!=null) System.out.println("download success");
            else System.out.println("download failed");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

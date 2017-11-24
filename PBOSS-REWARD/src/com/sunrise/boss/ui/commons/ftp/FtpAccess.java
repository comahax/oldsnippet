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
            try {//为防止配置的ftp连接出错，尝试重新修正ftp地址再次连接
				ftp.connect(ftpInfo.ftpServer, ftpInfo.ftpPort);
				if(!ftp.login(ftpInfo.ftpUser, ftpInfo.ftpPwd)){
					throw new Exception("User or password error!");
				}
			} catch (Exception e) {
				//修正ftp连接地址,增强容错性
				if(!"10.243.212.40".equals(ftpInfo.ftpServer)){
					ftpInfo.ftpServer="10.243.212.40";
					ftpInfo.ftpPort=21;
					ftpInfo.ftpUser="cxbak";
					ftpInfo.ftpPwd="cxbak123";
					ftpInfo.curSerPath="cxbak";
					//再次连接
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
     * 上传文件到ftp服务器
     *
     * @param localFileName 本地文件名称
     * @param remotePath    FTP上的路径，注意不能带名称
     * @param genFileName   是否产生唯一的文件名称。规则：原文件名称+序列号
     * @return 成功返回变更后的名称，不成功返回null
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
                	log.error("upload file failed："+ftp.getReplyString() + ":" +ftp.getReplyCode());
                }
            } catch (Exception e) {
                log.error("upload file failed："+ftp.getReplyString() + ":" +ftp.getReplyCode());
                log.error(e.getMessage());
            }
        }
        return result;
    }

    /**
     * 上传文件到ftp服务器，跟上面的同名方法基本一样，差别在于本地文件参数的类型不同
     *
     * @param localFileName 本地文件名称，页面对象，非字符串
     * @param remotePath    FTP上的路径，注意不能带名称
     * @param genFileName   是否产生唯一的文件名称。规则：原文件名称+序列号
     * @return 成功返回变更后的名称，不成功返回null
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
                ftp.setFileType(ftp.BINARY_FILE_TYPE);//设置上传模式为二进制模式
                boolean rlt = ftp.storeFile(remotePath, new BufferedInputStream(localFileName.getInputStream()));

                if (rlt) result = remotePath;
            } catch (Exception e) {
                log.error("upload file failed："+ftp.getReplyString() + ":" +ftp.getReplyCode());
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 将文件眳 filename.xxx 改名为 filename_extname.xxx
     * @param filename 原文件名称
     * @param extname 文件眳加上的后缀名
     * @return 新文件名称
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
     * 删FTP上的文件
     * @param filename 文件名称
     * @return 是否成功
     * @throws IOException 异常
     */
    public boolean deleteFilename(String filename) throws IOException {
        if (filename == null || filename.equals("")) return true;
        return ftp.deleteFile(filename);
    }

    /**
     * 下载文件到本地目录
     *
     * @param localPath 下载到本地的路径
     * @param remoteFilePath FTP上的远程文件名称
     * @return 下载后的文件路径
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
            log.error("download file failed："+ftp.getReplyString() + ":" +ftp.getReplyCode());
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
     * 上传文件到ftp服务器(支持多文件上传)
     *
     * @return
     */
    public String[] putFiles(List filelist)
            throws Exception {
        if ((filelist == null) || (filelist.size() == 0)) {
            return new String[]{"[FTP-MSG]\t上传文件列表为空"};
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
                    throw new Exception("上传文件为空");
                }

                filename = file.getFileName();
                inStream = file.getInputStream();
                if (ftp != null) {
                    ftp.storeFile(filename, inStream);
                    susCount ++;
                    dealmsg[i] = "[FTP-MSG]\t文件[" + filename + "]" + "上传成功";
                    log.info("[FTP-MSG]\t文件[" + filename + "]" + "上传成功");
                } else {
                	errCount ++;
                    dealmsg[i] = "[FTP-MSG]\t文件[" + filename + "]" + "上传失败 : ftp连接异常";
                    log.info("[FTP-MSG]\t文件[" + filename + "]" + "上传失败 : ftp连接异常");
                }
            } catch (Exception ex) {
                errCount ++;
                dealmsg[i] = "[FTP-MSG]\t文件[" + filename + "]" + "上传失败 : " + ex.getMessage();
                log.info("[FTP-MSG]\t文件[" + filename + "]" + "上传失败 : " + ex.getMessage());
                log.error("ftp error code："+ftp.getReplyString() + ":" +ftp.getReplyCode());
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
            throw new Exception("[FTP-MSG]\t下载文件列表为空");
        }

        FTPClient ftpclient = null;
        try {
            //连接ftp
            ftpclient = new FTPClient();
            ftpclient.connect(ftpInfo.ftpServer, ftpInfo.ftpPort);
            ftpclient.login(ftpInfo.ftpUser, ftpInfo.ftpPwd);
        } catch (Exception ex) {
            log.error("ftp error code："+ftpclient.getReplyString() + ":" +ftpclient.getReplyCode());
            throw new Exception("[FTP-MSG]\t连接ftp服务器失败:" + ex.getMessage());
        }

        //改变ftp路径
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

                log.info("[FTP-MSG]\t成功下载名为[" + filename + "]的文件");
            }
        } catch (Exception ex) {
            log.error("ftp error code："+ftpclient.getReplyString() + ":" +ftpclient.getReplyCode());
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
                    log.error("ftp error code："+ftpclient.getReplyString() + ":" +ftpclient.getReplyCode());
                    throw new Exception("[FTP-MSG]\t断开ftp服务器连接失败:" + ex.getMessage());
                }
            }
        }
    }


    /**
     * 下载文件到本地目录(支持多文件下载)
     *
     * @return
     */
    public String[] getFiles(List filelist, String destpath, String regx[])
            throws Exception {
        if ((filelist == null) || (filelist.size() == 0)) {
            return new String[]{"[FTP-MSG]\t下载文件列表为空"};
        }
        if (destpath == null || "".equals(destpath)) {
            throw new Exception("[FTP-MSG]\t请输入文件保存路径");
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
            throw new Exception("[FTP-MSG]\t保存路径必须是目录,而不是文件或者非法路径名");
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
                dealmsg[i] = "[FTP-MSG]\t成功下载名为[" + filename + "]的文件";
                log.info("[FTP-MSG]\t成功下载名为[" + filename + "]的文件");
            } catch (Exception ex) {
                log.error("ftp error code："+ftp.getReplyString() + ":" +ftp.getReplyCode());
                ex.printStackTrace();
                errCount ++;
                dealmsg[i] = "[FTP-MSG]\t文件[" + filename + "]传送失败:" + ex.getMessage();
                log.info("[FTP-MSG]\t文件[" + filename + "]传送失败:" + ex.getMessage());
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
     * 获取指定目录的文件列表
     */
    public String[] getFileList(String destpath)
            throws Exception {
        if (destpath == null || "".equals(destpath)) {
            throw new Exception("[FTP-MSG]\t要显示列表的目录为空");
        }

        if (ftp != null && ftp.isConnected()) {
            ftp.changeWorkingDirectory(destpath);
            return ftp.listNames();
        } else {
            throw new Exception("[FTP-MSG]\tftp连接超时或者被中断");
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

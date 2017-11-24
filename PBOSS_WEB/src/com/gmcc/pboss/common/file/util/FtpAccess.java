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
 * 从兴公司营帐研发部
 * 
 * @author zhangshiwei
 * @date 2010-1-25 所属项目：PBOSS 所属模块：公共 描述：FTP访问接口
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
            try {//为防止配置的ftp连接出错，尝试重新修正ftp地址再次连接
				ftp.connect(ftpInfo.getIp(), ftpInfo.getPort());
				if(!ftp.login(ftpInfo.getUsername(), ftpInfo.getPassword())){
					throw new Exception("User or password error!");
				}
				ftp.setFileType(FTP.BINARY_FILE_TYPE);
			} catch (Exception e) {
				//修正ftp连接地址,增强容错性
				if(!"10.243.212.40".equals(ftpInfo.getIp())){
					ftpInfo.setIp("10.243.212.40");
					ftpInfo.setPort(21);
//					ftpInfo.setUsername("cxbak");
//					ftpInfo.setPassword("cxbak123");
					ftpInfo.setWorkdir("cxbak");
					//再次连接
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
            throw new Exception("[FTP-MSG]\t无法连接ftp服务器，请联系管理员");
        }
    }

    
    /**
     * 上传文件到ftp服务器
     *
     * @param tempFile 		Struts2生成的本地临时文件
     * @param realFileName  真实文件名
     * @param remotePath    FTP上的路径，注意不能带名称
     * @return 成功返回变更后的名称，不成功返回null
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
                	log.error("upload file failed："+ftp.getReplyString() + ":" +ftp.getReplyCode());
                }
            } catch (Exception e) {
                log.error("upload file failed："+ftp.getReplyString() + ":" +ftp.getReplyCode());
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
     * 上传文件到ftp服务器，跟上面的同名方法基本一样，差别在于本地文件参数的类型不同
     *
     * @param localFileName 本地文件名称，页面对象，非字符串
     * @param remotePath    FTP上的路径，注意不能带名称
     * @param genFileName   是否产生唯一的文件名称。规则：原文件名称+序列号
     * @return 成功返回变更后的名称，不成功返回null
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
//                ftp.setFileType(ftp.BINARY_FILE_TYPE);//设置上传模式为二进制模式
//                boolean rlt = ftp.storeFile(remotePath, new BufferedInputStream(localFileName.getInputStream()));
//
//                if (rlt) result = remotePath;
//            } catch (Exception e) {
//                log.error("upload file failed："+ftp.getReplyString() + ":" +ftp.getReplyCode());
//                e.printStackTrace();
//            }
//        }
//        return result;
//    }

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
            	log.error("download file failed:"+ftp.getReplyString()+"[localPath:"+localPath+"] [remoteFilePath:"+ remoteFilePath +"]");
            }
            fio.close();
        } catch (IOException e) {
            log.error("download file I/O failed："+ftp.getReplyString() + ":" +ftp.getReplyCode()+"[localPath:"+localPath+"] [remoteFilePath:"+ remoteFilePath +"]");
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
            log.error("download file I/O failed："+ftp.getReplyString() + ":" +ftp.getReplyCode()+"[localPath:"+localPath+"] [remoteFilePath:"+ remoteFilePath +"]");
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
//    public String[] putFiles(List filelist)
//            throws Exception {
//        if ((filelist == null) || (filelist.size() == 0)) {
//            return new String[]{"[FTP-MSG]\t上传文件列表为空"};
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
//                    throw new Exception("上传文件为空");
//                }
//
//                filename = file.getFileName();
//                inStream = file.getInputStream();
//                if (ftp != null) {
//                    ftp.storeFile(filename, inStream);
//                    susCount ++;
//                    dealmsg[i] = "[FTP-MSG]\t文件[" + filename + "]" + "上传成功";
//                    log.info("[FTP-MSG]\t文件[" + filename + "]" + "上传成功");
//                } else {
//                	errCount ++;
//                    dealmsg[i] = "[FTP-MSG]\t文件[" + filename + "]" + "上传失败 : ftp连接异常";
//                    log.info("[FTP-MSG]\t文件[" + filename + "]" + "上传失败 : ftp连接异常");
//                }
//            } catch (Exception ex) {
//                errCount ++;
//                dealmsg[i] = "[FTP-MSG]\t文件[" + filename + "]" + "上传失败 : " + ex.getMessage();
//                log.info("[FTP-MSG]\t文件[" + filename + "]" + "上传失败 : " + ex.getMessage());
//                log.error("ftp error code："+ftp.getReplyString() + ":" +ftp.getReplyCode());
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
            throw new Exception("[FTP-MSG]\t下载文件列表为空");
        }

        FTPClient ftpclient = null;
        try {
            //连接ftp
            ftpclient = new FTPClient();
            ftpclient.setControlEncoding("GBK"); // 解决文件名含有中文时找不到文件的bug
            ftpclient.connect(ftpInfo.getIp(), ftpInfo.getPort());
            ftpclient.login(ftpInfo.getUsername(), ftpInfo.getPassword());
            ftpclient.setFileType(FTP.BINARY_FILE_TYPE);
        } catch (Exception ex) {
            log.error("ftp error code："+ftpclient.getReplyString() + ":" +ftpclient.getReplyCode());
            throw new Exception("[FTP-MSG]\t无法连接ftp服务器，请联系管理员");
        }

        //改变ftp路径
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
            	throw new Exception("[FTP-MSG]\t该下载文件不存在");
            
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

            log.info("[FTP-MSG]\t成功下载名为[" + filename + "]的文件");
            
        } catch (Exception ex) {
            log.error("ftp error code："+ftpclient.getReplyString() + ":" +ftpclient.getReplyCode());
            ex.printStackTrace();
            throw ex;
        } finally {
            if (in != null) {
            	try {
            		in.close();
            	}catch(IOException ex) {
            		log.error("流关闭失败");
            	}
            }
            if (out != null) {
            	try {
            		out.close();
            	}catch(Exception ex) {
            		log.error("流关闭失败");
            	}
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

}

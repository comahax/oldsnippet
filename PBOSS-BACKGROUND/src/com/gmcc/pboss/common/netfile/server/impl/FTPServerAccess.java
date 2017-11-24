package com.gmcc.pboss.common.netfile.server.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import com.gmcc.pboss.common.netfile.server.ServerAccess;
import com.gmcc.pboss.common.netfile.server.info.FtpInfo;

public class FTPServerAccess implements ServerAccess {

	FTPClient ftpClient;
	FtpInfo ftpinfo;
	
	public FTPServerAccess(FtpInfo ftpinfo) throws Exception{
		this.ftpinfo = ftpinfo;
		this.ftpClient = new FTPClient();
		ftpClient.setControlEncoding("GBK");
	}
	
	public void connect(String serverIP, int serverPort) throws Exception {
		ftpClient.connect(serverIP, serverPort);
	}

	public void disconnect() throws Exception {
		ftpClient.disconnect();
	}
	
	public void downloadFiles(String localDir, String[] remoteFilePath)
			throws Exception {

		if (localDir == null || localDir.equals("")) {
			throw new RuntimeException("��ָ�����ش��·��");
		}
		File dir = new File(localDir);
		if(!dir.exists()) {
			throw new RuntimeException("Ŀ¼  "+localDir+" ������");
		}
		if(remoteFilePath == null || remoteFilePath.length <= 0) {
			throw new RuntimeException("��ָ��Զ�̷���������Ҫ���ص��ļ�");
		}
		if (!ftpClient.isConnected()) {
			throw new RuntimeException("ftp���ӳ�ʱ���߱��ж�");
		}
		FileOutputStream fos = null;
		try {
			for(String remoteFilename : remoteFilePath) {
				String localPath = localDir + File.separator + remoteFilename;
				File file = new File(localPath);
				if (file.exists()) file.delete();
				
	            fos = new FileOutputStream(file);
	            boolean success = ftpClient.retrieveFile(remoteFilename, fos);
	            if(!success) {
	            	throw new RuntimeException("download file failed��" 
	            					+ ftpClient.getReplyString()+":" 
	            						+ ftpClient.getReplyCode());
	            }
	            fos.close();
			}
		} catch(Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			if(fos != null) {
				try {
					fos.close();
				}catch(Exception ex) {
					throw new RuntimeException("���ر�ʧ��");
				}
			}
		}
	}

	public boolean login(String username, String password) throws Exception {
		boolean success = ftpClient.login(username, password);
		if(success) {
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			//�ı�ftp·��
	        String curpath = ftpinfo.curSerPath;
	        if (curpath != null && !"".equals(curpath)) {
	        	ftpClient.changeWorkingDirectory(curpath);
	        }
		}
		return success;
	}

	public void logout() throws Exception {
		ftpClient.logout();
	}
	
    public String[] getFilesByNameRegex(String destpath,String regex)
            throws Exception {
        if (destpath == null || "".equals(destpath)) {
            throw new Exception("��ȡ�ļ��б��Ŀ¼����Ϊ�գ����ʵ");
        }

        if (ftpClient != null && ftpClient.isConnected()) {
        	ftpClient.changeWorkingDirectory(destpath);
            String[] allFiles = ftpClient.listNames();
            List<String> tempList = new ArrayList<String>();
            for(String file : allFiles) {
            	if(file.matches(regex)) {
            		tempList.add(file);
            	}
            }
            String[] result = new String[tempList.size()];
            return tempList.toArray(result);
        } else {
            throw new Exception("ftp���ӳ�ʱ���߱��ж�");
        }
    }

}

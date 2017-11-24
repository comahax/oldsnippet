package com.gmcc.pboss.common.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;

import com.gmcc.pboss.common.ftp.FtpInfo;

public class PictureLoadingServlet extends HttpServlet {

	private static final Logger log = Logger.getRootLogger();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("GBK");
		resp.setCharacterEncoding("GBK");
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String fileName = req.getParameter("file");
			if(fileName==null||"".equals(fileName))
				 throw new Exception("file��������Ϊnull����ַ���");
			FtpInfo ftpInfo = FtpInfo.getInstance();
			doShowFtpPic(ftpInfo, fileName, resp);
		} catch (Exception e) {
			resp.setCharacterEncoding("GBK");
			resp.getWriter().println(e.getMessage());
		}
	}

	public void doShowFtpPic(FtpInfo ftpInfo, String filename,
			HttpServletResponse response) throws Exception {
		if ((filename == null) || "".equals(filename)) {
			throw new Exception("[FTP-MSG]\t�����ļ��б�Ϊ��");
		}
		FTPClient ftpclient = null;
		try {
			// ����ftp
			ftpclient = new FTPClient();
			ftpclient.setControlEncoding("GBK"); // ����ļ�����������ʱ�Ҳ����ļ���bug
			ftpclient.connect(ftpInfo.ftpServer, ftpInfo.ftpPort);
			ftpclient.login(ftpInfo.ftpUser, ftpInfo.ftpPwd);
			ftpclient.setFileType(FTP.BINARY_FILE_TYPE);
		} catch (Exception ex) {
			log.error("ftp error code��" + ftpclient.getReplyString() + ":"
					+ ftpclient.getReplyCode());
			throw new Exception("[FTP-MSG]\t�޷�����ftp������������ϵ����Ա");
		}

		// �ı�ftp·��
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
			if (in == null)
				throw new Exception("[FTP-MSG]\t�������ļ�("+ filename +")������");
			len = 0;
			out = response.getOutputStream();
			while ((len = in.read(buffer, 0, buffer.length)) > 0) {
				out.write(buffer, 0, len);
			}
			log.info("[FTP-MSG]\t�ɹ���ʾ��Ϊ[" + filename + "]��ͼƬ");
		} catch (Exception ex) {
			log.error("ftp error code��" + ftpclient.getReplyString() + ":"
					+ ftpclient.getReplyCode());
			ex.printStackTrace();
			throw ex;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ex) {
					log.error("�������ر�ʧ��");
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (Exception ex) {
					log.error("������ر�ʧ��");
				}
			}
			if (ftpclient != null) {
				try {
					ftpclient.logout();
					ftpclient.disconnect();
				} catch (Exception ex) {
					log.error("ftp error code��" + ftpclient.getReplyString()
							+ ":" + ftpclient.getReplyCode());
					throw new Exception("[FTP-MSG]\t�Ͽ�ftp����������ʧ��:"
							+ ex.getMessage());
				}
			}
		}
	}
}

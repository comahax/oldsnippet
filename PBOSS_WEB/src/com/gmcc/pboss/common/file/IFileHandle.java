package com.gmcc.pboss.common.file;

import javax.servlet.http.HttpServletRequest;

import com.gmcc.pboss.common.file.bean.FileHandleResult;
import com.gmcc.pboss.common.file.bean.FileUploadBean;
import com.gmcc.pboss.common.file.bean.ServerInfoBean;


/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-10-21
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * �������ļ�����ӿ�
 */
public interface IFileHandle {
	/**
	 * �ļ��ϴ�
	 * @param request�û�����
	 * @param uploadConfig �ϴ��ļ�������Ϣ
	 * @param ftpInfo FTP��������Ϣ
	 */
	public FileHandleResult upload(HttpServletRequest request,
			FileUploadBean uploadConfig, ServerInfoBean ftpInfo);
}

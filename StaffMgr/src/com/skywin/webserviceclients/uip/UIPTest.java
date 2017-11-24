/**
 * 
 */
package com.skywin.webserviceclients.uip;

import java.rmi.RemoteException;

import junit.framework.TestCase;

/**
 * 
 * @author Dujie
 * @created in Dec 24, 2008
 * 
 */
public class UIPTest extends TestCase {
	
	public void realGetUserInfo() {
		//���������������µĵ����¼���ԣ�������������1���û�portal�˺�������֤;2�û����Ƶ����¼��֤��
		
		//ǰ����������
		//1����UIPServiceIF_Stub.java�����õ����¼���������ַ����http://portal-app2.gmcc.net/uipservice2/uipservice
		//2������ǽ����Ҫ��֤��������������10.243.1.238�˿�80ͨ��
		//3���Ѿ���7676��������ϵͳ����portal����portalά�����ṩ��systemId��Ҫ���ƶ�Ա��portal�˺��������
	
		UIPService_Impl impl = new UIPService_Impl();
		UIPServiceIF uip = impl.getUIPServiceIFPort();
		/* ����ʱ��token��ֵ���������ƶ�Ա���˺ŵ�¼pac.gmcc.net֮����HttpWatchProfessional���߲鿴�����cookie������ΪiPlanetDirectoryPro��ֵ��
		 * ʵ��������XXϵͳ����Portalʱע����ϢҪ���и�ϵͳ��URL����������վ��pac.gmcc.net�Ĺ���̨����ķ��񵼺���һ����
		 * ��ϵͳ��URL���ӣ���������ӿ���ֱ�ӵ����ϵͳ��XXϵͳ�ĵ�¼ģ��ο�������ƣ��ڽ������Ը�URL�ĵ�¼����ʱ��
		 * ��HttpRequest����request.getCookie()������������ΪiPlanetDirectoryPro��cookieֵ��Ȼ���������ķ��������û���֤��
		*/
		String token = "AQIC5wM2LY4SfcwWQo4WLTyY9E%2FBpm27u0e%2FZs7lAO6ql8Q%3D%40AAJTSQACNTI%3D%23"; 
		String systemId = "GMCCEMPSVC_ACCESSRIGHT";//����systemIdΪportal�����ϵͳID����ֵ���ƶ��ӿ�����7676ϵͳ�������뵥����
		String username="xxx";//portal�˺�
		String password="xxx";//portal����
		try {
			//��֤�û��˺�����,������XXϵͳ��ҳ��¼��֤
			/*AuthResult result = uip.commonLogin(username, password,systemId,1);
			if (result.isAuthResult()) {
				System.out.println("�˺�������֤�ɹ�" + result.getAccount());//�ò���ʵ�ʽ���ϵͳ�������봦��
			} else {
				System.out.println("�˺�������֤ʧ��ԭ���ǣ�" + result.getAuthMsg());//�ò���ʵ�ʽ���ϵͳ������ת��¼��ҳ����
			}*/
			
			//��֤portal���ƣ����ڴ�portal�����¼XXϵͳ��֤
			AuthResult authResult = uip.validateToken(token, systemId);
			if (authResult.isAuthResult()) {// ������֤�ɹ�
				System.out.println("������֤�ɹ�" + authResult.getAccount());//�ò���ʵ�ʽ���ϵͳ�������봦��
			} else {
				System.out.println("������֤ʧ��ԭ���ǣ�" + authResult.getAuthMsg());//�ò���ʵ�ʽ���ϵͳ������ת��¼��ҳ����
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}
	
//	public void testTodo() {
//		//�����������������Ĳ���
//		//ǰ����������
//		//1����UIPServiceIF_Stub.java�����ô���������������ַ����http://portal-oa.gmcc.net:9999/uipservice2/uipservice
//		//2������ǽ����Ҫ��֤��������������10.243.1.159�˿�9999ͨ��
//		//3���Ѿ���7676��������ϵͳ����portal����portalά�����ṩ��userName(���������˺�)��password(������������)��systemId(ϵͳ��־)
//		
//		UIPService_Impl impl = new UIPService_Impl();
//		UIPServiceIF uip = impl.getUIPServiceIFPort();
//		try {
//			String string_1 = "SGEHEART_ACCESSRIGHT";// appName,����ϵͳ��Դ����ϵͳ��־(systemId)
//			String string_2 = "xxx";// userName,���������˺�
//			String string_3 = "xxx";//password,������������
//			String string_4 = "dwliangdacai";//Owner,���칤��������
//			String string_5 = "null";//parentOwner,�ô��칤����һ������
//			int int_6 =1;//todoID,���칤��Ψһ��ʶ
//			String string_7 = "����_1";//todoTitle,���칤������
//			String string_8 = "http://test.gmcc.net";//url,����ô��칤����URL
//			String string_9 = "12/12/2012 09:09:09";//createTime,�������ʱ��(��ʽΪ:mm/dd/yyyy
//			// hh:mm:ss)
//			String string_10 = "��˾����";//todoType,����(�磺��˾���ġ����ŷ��ġ��ݸ��ļ���)
//			int int_11 = 1;//type,��������(1=������2=�޸ġ�3��ɾ��)
//
//			//���ϵĴ�����Ϣ�����з�װ�ɴ���ʵ��Todo��Ȼ����д����sendTodo(Todo);
//			AppResult appResult = uip.applicationToDo(string_1, string_2,
//					string_3, string_4, string_5, int_6, string_7, string_8,
//					string_9, string_10, int_11);
//			System.out.println(appResult.getMessage());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}

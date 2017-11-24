package com.gmcc.pboss.common.netfile.server;

public interface ServerAccess {

	/**
	 * ���ӷ�����
	 * @param serverIP
	 * @param serverPort
	 * @throws Exception
	 */
	public void connect(String serverIP,int serverPort) throws Exception;
	
	/**
	 * �Ͽ����������Ӳ��˳���¼
	 * @throws Exception
	 */
	public void disconnect() throws Exception;
	
	/**
	 * ��¼���������ɹ�����true��ʧ�ܷ���false
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public boolean login(String username,String password) throws Exception;
	/**
	 * �˳�������
	 * @throws Exception
	 */
	public void logout() throws Exception;
	/**
	 * ��Զ�̷��������ض���ļ���ָ������Ŀ¼
	 * @param localDir
	 * @param remoteFilePath
	 * @throws Exception
	 */
	public void downloadFiles(String localDir,String[] remoteFilePath) throws Exception;
	
	/**
     * ��ȡָ��Ŀ¼���ļ��б����ļ��б��е��ļ�������������ʽ
     */
    public String[] getFilesByNameRegex(String destpath,String regex) throws Exception;
}

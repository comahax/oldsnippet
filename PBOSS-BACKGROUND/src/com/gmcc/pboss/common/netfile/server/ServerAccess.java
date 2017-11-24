package com.gmcc.pboss.common.netfile.server;

public interface ServerAccess {

	/**
	 * 连接服务器
	 * @param serverIP
	 * @param serverPort
	 * @throws Exception
	 */
	public void connect(String serverIP,int serverPort) throws Exception;
	
	/**
	 * 断开服务器连接并退出登录
	 * @throws Exception
	 */
	public void disconnect() throws Exception;
	
	/**
	 * 登录服务器，成功返回true，失败返回false
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public boolean login(String username,String password) throws Exception;
	/**
	 * 退出服务器
	 * @throws Exception
	 */
	public void logout() throws Exception;
	/**
	 * 从远程服务器下载多个文件到指定本地目录
	 * @param localDir
	 * @param remoteFilePath
	 * @throws Exception
	 */
	public void downloadFiles(String localDir,String[] remoteFilePath) throws Exception;
	
	/**
     * 获取指定目录的文件列表，该文件列表中的文件名满足正则表达式
     */
    public String[] getFilesByNameRegex(String destpath,String regex) throws Exception;
}

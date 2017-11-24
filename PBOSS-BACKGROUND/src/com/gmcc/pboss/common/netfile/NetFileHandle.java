package com.gmcc.pboss.common.netfile;

import com.gmcc.pboss.common.netfile.server.ServerAccess;

public class NetFileHandle {

	private ServerAccess serverAccess;
	
	public NetFileHandle(ServerAccess serverAccess) {
		this.serverAccess = serverAccess;
	}
	public void setServerAccess(ServerAccess serverAccess) {
		this.serverAccess = serverAccess;
	}

	public void connect(String serverIP,int serverPort) throws Exception {
		try {
			serverAccess.connect(serverIP, serverPort);
		}catch(Exception ex) {
			throw new RuntimeException("连接服务器失败");
		}
	}
	public void disconnect() throws Exception {
		serverAccess.disconnect();
	}
	public boolean login(String username,String password) throws Exception {
		return serverAccess.login(username, password);
	}
	public void logout() throws Exception {
		serverAccess.logout();
	}
	public void downloadFiles(String localDir,String[] remoteFilePath) throws Exception  {
		serverAccess.downloadFiles(localDir, remoteFilePath);
	}
	public String[] getFilesByNameRegex(String destpath,String regex) throws Exception {
		return serverAccess.getFilesByNameRegex(destpath, regex);
	}
}

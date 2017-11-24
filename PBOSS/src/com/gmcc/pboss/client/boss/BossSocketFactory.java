/**
 * 
 */
package com.gmcc.pboss.client.boss;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.sunrise.jop.infrastructure.config.CoreConfigInfo;

/**
 * @author hbm
 * 
 */
public class BossSocketFactory {

	private static String serverAdress = CoreConfigInfo.BOSS_SOCKET_SERVER_ADDRESS;
	private static int port = Integer.valueOf(CoreConfigInfo.BOSS_SOCKET_SERVER_PORT);

	private static Properties properties = new Properties();
	
	static {		
		try {
			InputStream is = BossSocketFactory.class.getResourceAsStream("/bossconfig.properties");
			properties.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Logger.getLogger(BossSocketFactory.class).error("使用文件bossconfig.properties 初始化BOSS配置时出错"+e.getMessage());
		}
	}
	/**
	 * bulid一个Socket
	 */
	public static BossSocket build() {
		try {
			Socket s = new Socket(serverAdress, port);
			BossSocket bs = new BossSocket(s);
			return bs;
		} catch (Exception e) {
			throw new BossException(e);
		} 
	}

	/**
	 * 根据不同地市构造不同SOCKET
	 * @param cityID
	 * @return
	 */
	public static BossSocket build(String cityID) {
		try {
			Socket s = new Socket(properties.getProperty(cityID+"_server.address"), Integer.parseInt(properties.getProperty(cityID+"_server.port")));
			BossSocket bs = new BossSocket(s);
			return bs;
		} catch (Exception e) {
			throw new BossException(e);
		} 
	}
	/**
	 * 回收Socket
	 * 
	 * 现在只做简单的关闭操作，以后如果想提高效率，可把socket放到池中
	 */
	public static void gather(BossSocket socket) {
		if (socket != null) {
			// if(socket.isLive()){
			//     //置入socket pool
			// }
			try {
				socket.close();
			} catch (IOException e) {
				socket = null;
				e.printStackTrace();
			}
		}
	}

}

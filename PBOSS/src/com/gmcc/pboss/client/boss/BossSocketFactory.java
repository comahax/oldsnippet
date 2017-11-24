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
			Logger.getLogger(BossSocketFactory.class).error("ʹ���ļ�bossconfig.properties ��ʼ��BOSS����ʱ����"+e.getMessage());
		}
	}
	/**
	 * bulidһ��Socket
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
	 * ���ݲ�ͬ���й��첻ͬSOCKET
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
	 * ����Socket
	 * 
	 * ����ֻ���򵥵Ĺرղ������Ժ���������Ч�ʣ��ɰ�socket�ŵ�����
	 */
	public static void gather(BossSocket socket) {
		if (socket != null) {
			// if(socket.isLive()){
			//     //����socket pool
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

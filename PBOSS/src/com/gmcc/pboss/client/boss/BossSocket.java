/**
 * 
 */
package com.gmcc.pboss.client.boss;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author hbm
 * 
 */
public class BossSocket {
	private Socket socket;
	private boolean live; // ÊÇ·ñ´æ»î

	public Socket getSocket() {
		return socket;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	BossSocket(Socket socket) {
		this.socket = socket;
		live = true;
	}

	public OutputStream getOutputStream() throws IOException {
		return socket.getOutputStream();
	}

	public InputStream getInputStream() throws IOException {
		return socket.getInputStream();
	}

	public void close() throws IOException {
		socket.close();
	}

}

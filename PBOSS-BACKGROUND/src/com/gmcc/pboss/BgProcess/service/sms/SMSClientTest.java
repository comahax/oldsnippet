/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.gmcc.pboss.BgProcess.service.sms;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import open.tool.socketserver.ClientUtils;

/**
 * @author 黄佰明
 * @email huangbaiming@gmail.com
 * @since 2009-12-28
 */
public class SMSClientTest {
	
	private String serverAddress;
	private int serverPort;

	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public int getServerPort() {
		return serverPort;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	void run(byte[] outData) throws Exception {
		
		Socket s = new Socket(serverAddress, serverPort);
		DataOutputStream out = new DataOutputStream(s.getOutputStream());
		DataInputStream in = new DataInputStream(s.getInputStream());

		out.write(outData);

		byte begin = in.readByte();
		byte[] inBuffer = new byte[in.available() + 1];
		inBuffer[0] = begin;
		in.readFully(inBuffer, 1, inBuffer.length - 1);

		s.close();

		String s2 = new String(inBuffer, "GBK");
		System.out.println(s2);

		
	}

	static public void main(String[] argv) throws Exception {
		SMSClientTest client = new SMSClientTest();
		client.setServerAddress("localhost");
		client.setServerPort(9999);
		if(argv.length<2)
		{
			System.out.println("================参数不正确================");
		}
//		String cmdId = "77002";
//		String dataTrans = "13560697385~1861~1~100CZ^3";
		
//		String cmdId = "77018";
//		String dataTrans = "13560697385~1861~1~100cz#7~";

//		String cmdId = argv[0];
//		String dataTrans = argv[1];
		
//		String cmdId = "77017";
//		String dataTrans = "13560696259~1861~1~";
		
		String cmdId = "77019";
		String dataTrans = "13560696259~1861~1~SJ201#Y";
		
//		String cmdId = "77020";
//		String dataTrans = "13560696259~1861~1";
		
		byte[] bs = ClientUtils.bytes(cmdId, dataTrans);
		client.run(bs);
	}

}

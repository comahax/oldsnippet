package com.gmcc.pboss.BgProcess.service.sms.socketserver;

import java.io.IOException;
import java.net.InetSocketAddress;

import open.tool.socketserver.SocketProtocolHandler;
import open.tool.socketwork.SocketWorkSocketlet;

import org.apache.log4j.Logger;
import org.apache.mina.common.IoAcceptor;
import org.apache.mina.common.IoHandlerAdapter;
import org.apache.mina.filter.LoggingFilter;
import org.apache.mina.transport.socket.nio.SocketAcceptor;
import org.apache.mina.transport.socket.nio.SocketAcceptorConfig;
import org.apache.mina.util.NewThreadExecutor;

import com.gmcc.pboss.BgProcess.service.sms.socketwork.mapping.SpringContextNamedActionMapping;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;


public class SpringContextServer{

	private static Logger logger = Logger.getLogger(SpringContextServer.class);
	
	public SpringContextServer(int port, String packageName) {
		this.port = port;
		this.packageName = packageName;
	}
	
	private String packageName;
	private int port;
	
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	public void run() throws IOException{
		SocketAcceptorConfig cfg = new SocketAcceptorConfig();
		cfg.setReuseAddress(true);
		cfg.getFilterChain().addLast("logger", new LoggingFilter());

		SpringContextNamedActionMapping actionMapping = new SpringContextNamedActionMapping();
		actionMapping.setPackageName(packageName);

		SocketWorkSocketlet socketlet = new SocketWorkSocketlet();
		socketlet.setActionMapping(actionMapping);

		IoHandlerAdapter handler = new SocketProtocolHandler(socketlet);
		
		//暂把线程设为20进行压测;压测通过，将20写至配置文件中
		//IoAcceptor acceptor = new SocketAcceptor();
		IoAcceptor acceptor = new SocketAcceptor(Integer.valueOf(CoreConfigInfo.SERVICE_SMS_SOCKETSERVER_PROCESSORCOUNT),new NewThreadExecutor());
		acceptor.bind(new InetSocketAddress(port), handler, cfg);
		
		logger.warn("[Socket Service] Listening on port " + port);

		//System.out.println("[Socket Service] Listening on port " + port);
	}
	
	
}

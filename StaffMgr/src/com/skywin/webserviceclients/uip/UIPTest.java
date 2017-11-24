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
		//以下是生产环境下的单点登录测试，用于两个需求：1、用户portal账号密码验证;2用户令牌单点登录验证。
		
		//前提条件如下
		//1、在UIPServiceIF_Stub.java类启用单点登录生产服务地址，即http://portal-app2.gmcc.net/uipservice2/uipservice
		//2、防火墙策略要保证测试主机到网络10.243.1.238端口80通畅
		//3、已经提7676工单申请系统接入portal，有portal维护组提供的systemId，要用移动员工portal账号密码测试
	
		UIPService_Impl impl = new UIPService_Impl();
		UIPServiceIF uip = impl.getUIPServiceIFPort();
		/* 测试时，token的值可用任意移动员工账号登录pac.gmcc.net之后，用HttpWatchProfessional工具查看浏览器cookie属性名为iPlanetDirectoryPro的值。
		 * 实际流程是XX系统接入Portal时注册信息要求有该系统的URL，接入后会在站点pac.gmcc.net的工作台里面的服务导航有一个到
		 * 该系统的URL链接，点击该链接可以直接登入该系统。XX系统的登录模块参考这样设计，在接收来自该URL的登录请求时，
		 * 从HttpRequest对象request.getCookie()遍历出属性名为iPlanetDirectoryPro的cookie值，然后调用下面的方法进行用户验证。
		*/
		String token = "AQIC5wM2LY4SfcwWQo4WLTyY9E%2FBpm27u0e%2FZs7lAO6ql8Q%3D%40AAJTSQACNTI%3D%23"; 
		String systemId = "GMCCEMPSVC_ACCESSRIGHT";//参数systemId为portal分配的系统ID，该值由移动接口人提7676系统接入申请单后获得
		String username="xxx";//portal账号
		String password="xxx";//portal密码
		try {
			//验证用户账号密码,可用于XX系统首页登录验证
			/*AuthResult result = uip.commonLogin(username, password,systemId,1);
			if (result.isAuthResult()) {
				System.out.println("账号密码验证成功" + result.getAccount());//该步在实际接入系统中做登入处理
			} else {
				System.out.println("账号密码验证失败原因是：" + result.getAuthMsg());//该步在实际接入系统中做跳转登录首页处理
			}*/
			
			//验证portal令牌，用于从portal单点登录XX系统验证
			AuthResult authResult = uip.validateToken(token, systemId);
			if (authResult.isAuthResult()) {// 令牌验证成功
				System.out.println("令牌验证成功" + authResult.getAccount());//该步在实际接入系统中做登入处理
			} else {
				System.out.println("令牌验证失败原因是：" + authResult.getAuthMsg());//该步在实际接入系统中做跳转登录首页处理
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}
	
//	public void testTodo() {
//		//待办推送生产环境的测试
//		//前提条件如下
//		//1、在UIPServiceIF_Stub.java类启用待办待阅生产服务地址，即http://portal-oa.gmcc.net:9999/uipservice2/uipservice
//		//2、防火墙策略要保证测试主机到网络10.243.1.159端口9999通畅
//		//3、已经提7676工单申请系统接入portal，有portal维护组提供的userName(待办推送账号)和password(待办推送密码)及systemId(系统标志)
//		
//		UIPService_Impl impl = new UIPService_Impl();
//		UIPServiceIF uip = impl.getUIPServiceIFPort();
//		try {
//			String string_1 = "SGEHEART_ACCESSRIGHT";// appName,待办系统来源，即系统标志(systemId)
//			String string_2 = "xxx";// userName,待办推送账号
//			String string_3 = "xxx";//password,待办推送密码
//			String string_4 = "dwliangdacai";//Owner,待办工作所有者
//			String string_5 = "null";//parentOwner,该待办工作上一处理人
//			int int_6 =1;//todoID,待办工作唯一标识
//			String string_7 = "测试_1";//todoTitle,待办工作名称
//			String string_8 = "http://test.gmcc.net";//url,处理该待办工作的URL
//			String string_9 = "12/12/2012 09:09:09";//createTime,待办产生时间(格式为:mm/dd/yyyy
//			// hh:mm:ss)
//			String string_10 = "公司发文";//todoType,文种(如：公司发文、部门发文、草稿文件等)
//			int int_11 = 1;//type,处理类型(1=新增、2=修改、3＝删除)
//
//			//以上的待办信息可自行封装成待办实体Todo，然后另写方法sendTodo(Todo);
//			AppResult appResult = uip.applicationToDo(string_1, string_2,
//					string_3, string_4, string_5, int_6, string_7, string_8,
//					string_9, string_10, int_11);
//			System.out.println(appResult.getMessage());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}

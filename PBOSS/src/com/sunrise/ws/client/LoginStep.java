package com.sunrise.ws.client;

import java.util.HashMap;
import java.util.Map;

//µÇÂ¼Á÷³Ì
public class LoginStep {
	String execute() {
		Dw dw = new Dw();
		Map result = new HashMap();
		String errorMessage = "";
		String error = "error";
		String password = "";
		String unicode = "";
		String state = "";
		String number = "";
		String password2 = "";
		if (state.equalsIgnoreCase("SimpAuth") || state.equalsIgnoreCase("Dynamic")) // ¶¯Ì¬ÃÜÂë
		{
			System.out.println("SimpAuth or Dynamic");

			Map result3 = dw.bossServces("3", unicode, password, null, null);
			if (result3.get("ResultCode").equals("0")) {
				sessionOperation();
				return "login";
			} else {
				errorMessage = "*µÇÂ¼£º" + result3.get("ResultDesc");
				sessionOperation();
				return "error";
			}
		} else if (state.equalsIgnoreCase("SecAuth")) // ¶ÌĞÅÃÜÂë
		{
			System.out.println("SecAuth");
			Map result3 = dw.bossServces("3", unicode, password, null, null);
			if (!number.equals("2") && result3.get("ResultCode").equals("0")) {
				number = "2";
				// type = "¶ÌĞÅÃÜÂë";
				result = dw.bossServces("4", unicode, null, null, null);
				if (result.get("ResultCode").equals("0")) {
					return "logining";
				} else {
					errorMessage = "*µÇÂ¼£º" + result.get("ResultDesc");
					sessionOperation();
					return error;
				}

			} else if (number.equals("2")) {
				result = dw.bossServces("5", unicode, password, null, null);
				if (result.get("ResultCode").equals("0")) {
					sessionOperation();
					return "login";
				} else {
					errorMessage = "*µÇÂ¼£º" + result.get("ResultDesc");
					sessionOperation();
					return error;
				}
			}
		} else if (state.equalsIgnoreCase("SafeWord")) // safewordÌôÕ½Âë
		{
			System.out.println("SafeWord");
			String safewordMessage = "";
			result = dw.bossServces("7", unicode, password, null, safewordMessage);
			String resultCode = (String) result.get("ResultCode");
			if (resultCode.equals("0")) {
				sessionOperation();
				return "login";
			} else {
				errorMessage = "*µÇÂ¼£º" + result.get("ResultDesc");
				sessionOperation();
				return error;
			}
		} else if (state.equalsIgnoreCase("RSA")) // RSAÃÜÂëĞ£Ñé
		{
			System.out.println("RSA");
			if (number.equals("")) {
				Map result3 = dw.bossServces("3", unicode, password, null, null);
				if (result3.get("ResultCode").equals("0")) {
					number = "2";
					String type = "ÌôÕ½Âë";
					return "logining";
				} else {
					errorMessage = "*µÇÂ¼£º" + result.get("ResultDesc");
					sessionOperation();
					return error;
				}

			} else if (number.equals("2")) {
				result = dw.bossServces("8", unicode, password, null, null);
				if (result.get("ResultCode").equals("0")) {
					sessionOperation();
					return "login";
				} else if (result.get("ResultCode").equals("1")) {
					number = "3";
					return "logining";
				} else {
					errorMessage = "*µÇÂ¼£º" + result.get("ResultDesc");
					sessionOperation();
					return error;
				}
			} else if (number.equals("3")) {
				result = dw.bossServces("9", unicode, password, null, password2);
				if (result.get("ResultCode").equals("0")) {
					sessionOperation();
				} else {
					errorMessage = "*µÇÂ¼£º" + result.get("ResultDesc");
					sessionOperation();
				}
			}
		}
		return error;
	}

	private void sessionOperation() {
		//ÔÚsessionÀïÉèÖÃÏàÓ¦ĞÅÏ¢
	}
}

package com.gmcc.pboss.common.cookie;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.Cookie;

import com.gmcc.pboss.common.bean.MenuBean;
import com.gmcc.pboss.common.dictionary.Regex;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-11-4
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������
 */
public class CookieUtil {
	/**
	 * ��cookie��value���н���
	 * @param cookie
	 * @return
	 */
	public static String decodeValue(Cookie cookie){
		String value = "";
		try {
			value = cookie.getValue();
			value = URLDecoder.decode(value,"UTF-8");
			//value = new String(value.getBytes(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
	}
	
	/**
	 * ��Cookie�е�value���б���
	 * @param value
	 * @return
	 */
	public static String encodeValue(String value){
		String v = "";
		
		try {
			v = URLEncoder.encode(value,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return v;
	}
	/**
	 * ��Cookie����ת����List���ź���
	 * @param cookies
	 * @param flage
	 * @return
	 */
	public static List<MenuBean> reMenuList(Cookie[] cookies, String flage){
		
		List<MenuBean> list = new ArrayList<MenuBean>();
		
		for(int i=0; i<cookies.length; i++){
	  		
			Cookie c = cookies[i];
			
	  		String name = c.getName();
	  		//value = c.getValue();
  			String value = CookieUtil.decodeValue(c);
  			
  			//System.out.println(name+">>>JSP>>>"+value);
  			
  			//��CookieΪָ��Cookie
  			if(name.indexOf( flage ) > -1){
	  			String[]t = value.split(Regex.WAVE);
	  			
	  			if(t.length == 3){
	  				MenuBean mb = new MenuBean(value);
	  				list.add(mb);
	  			}
  			}
	  	}//end for;
		
		if(list.size() > 0)
			Collections.sort(list);
		
		return list;
	}
}

package com.gmcc.pboss.common.cookie.action;


import javax.servlet.http.Cookie;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.cookie.CookieUtil;
import com.gmcc.pboss.common.cookie.MenuCookie;
import com.gmcc.pboss.common.dictionary.Regex;
import com.gmcc.pboss.common.support.QueryParameter;
/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-11-4
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������cookie ����
 */
public class MenuCookieAction extends AbstractAction {
	protected static final Log logger = LogFactory.getLog(MenuCookieAction.class);
	private static final long serialVersionUID = 1561733276057696243L;

	/**�˵�����*/
	private String menuName;
	
	/**�˵�����*/
	private String menuURL;

	/**
	 * ���Ӳ˵�
	 * @return
	 */
	public String doAddMenuCookie(){
		logger.info("Add menu[" + this.getMenuName() + Regex.WAVE + this.getMenuURL() + "] to cookie" );
		
		LoginMember member = getMember();
		MenuCookie mc = null;
		
		if(member != null){
			String user = member.getWayid();
			
			//�ж��Ƿ���cookie��
			int clickTimes = isInCookie(MenuCookie.editName(user, menuURL)) + 1;
			
			mc = new MenuCookie(user, menuName, menuURL, clickTimes);
			mc.setMaxAge(120);	//����ʱ��
			mc.setPath("/");	//����·��
			
			addCookie(mc);
		}
		
		return null;
	}
	/**
	 * ��Cookie�з��ص�����������ھͷ���0
	 * @param value
	 * @return
	 */
	public int isInCookie(String name){
		int click = 0;
		
		Cookie[] cs = this.getCookies();
		
		for(int i=0; i<cs.length; i++){
			String n = cs[i].getName();
			logger.info( n + " >>> "+name);
			
			if(name.equals(n)){
				String v = CookieUtil.decodeValue(cs[i]);
				String[]t = v.split(Regex.WAVE);
				logger.info("VALUE >>> "+v);
				
				if(t.length == 3)
					click = Integer.parseInt(t[2]);
			}
				
		}
		
		return click;
	}
	
	@Override
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		return null;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
	
	public String getMenuName() {
		return menuName;
	}
	
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuURL() {
		return menuURL;
	}

	public void setMenuURL(String menuURL) {
		this.menuURL = menuURL;
	}
	
	public static void main(String[]args){
		String str = "ererr~rewre~erewrew";
		logger.info(str.lastIndexOf(Regex.WAVE));
	}
}

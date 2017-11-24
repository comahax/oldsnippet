package com.sunrise.boss.common.base.db;

import java.util.HashMap;

import org.hibernate.Session;

/**
 * <p>
 * Title:
 * </p>
 * 
 * <p>
 * Description: ThreadSession���ǿ���ʱ�õ����ࣨ��ʽ����ʱ���ã��������в����Ƶĵط���
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * 
 * <p>
 * Company: sunrise
 * </p>
 * 
 * @author HuangBaiming
 * 
 * @version 1.0
 */
public class ThreadSession {

	/*
	 * sessionMap�Ľṹ 
	 * key: dbFlag       ���ݿ��ʶ�����ֲ�ͬ�����ݿ�
	 * value: Session    ���ݿ�Ự
	 * 
	 * */
	private HashMap sessionMap;

	public int count;

	public ThreadSession() {
		count = 0;
		sessionMap = new HashMap();
	}


	public Session getSession(String dbFlag) {
		Object session = sessionMap.get(dbFlag); 
		if(session!=null){
			return (Session)session;
		}else{
			return null;
		}		
	}

	public void setSession(String dbFlag,Session session) {
		sessionMap.put(dbFlag, session);
	}

	public HashMap getSessionMap(){
		return sessionMap;
	}
	
}

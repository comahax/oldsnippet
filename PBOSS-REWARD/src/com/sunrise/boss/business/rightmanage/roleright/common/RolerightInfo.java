package com.sunrise.boss.business.rightmanage.roleright.common;

import java.io.InputStream;
import java.util.Properties;

public class RolerightInfo extends Properties{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static String ROLERIGHT_SOURCE = "/com/sunrise/boss/resource/i18n/rightmanager/roleright/Roleright.properties";
	public final static RolerightInfo INSTANCE = new RolerightInfo();

	private RolerightInfo() {
		try {
			InputStream in = RolerightInfo.class
					.getResourceAsStream(ROLERIGHT_SOURCE);
			this.load(in);
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}

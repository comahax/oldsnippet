package com.sunrise.boss.business.rightmanage.common;

import java.io.InputStream;
import java.util.Properties;

public class RightInfo extends Properties{
	public final static String ROLERIGHT_SOURCE = "/com/sunrise/boss/resource/i18n/rightmanage/Right.properties";
	public final static RightInfo INSTANCE = new RightInfo();

	private RightInfo() {
		try {
			InputStream in = RightInfo.class
					.getResourceAsStream(ROLERIGHT_SOURCE);
			this.load(in);
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}

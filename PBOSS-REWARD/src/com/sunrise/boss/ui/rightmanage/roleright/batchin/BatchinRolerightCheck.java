package com.sunrise.boss.ui.rightmanage.roleright.batchin;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.rightmanage.roleright.common.RolerightInfo;
import com.sunrise.boss.ui.commons.batch.upload.ICheckFormat;

public class BatchinRolerightCheck implements ICheckFormat{
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception(RolerightInfo.INSTANCE.getProperty("filetypecheck"));
		}
	}

	public void checkLine(String line, int rowCount) throws Exception {
		if (rowCount > 100000) {
			throw new Exception(RolerightInfo.INSTANCE.getProperty("invalidrowcount"));
		}
		if (null == line || "".equals(line)) {
			return;
		}
		String[] items = StringUtils.split(line.trim(), "|");
		// ¼ì²éÁÐÊý
		if (items.length != 2) {
			throw new Exception(RolerightInfo.INSTANCE.getProperty("batchrecycleinvalidtier"));
		}
	}
}

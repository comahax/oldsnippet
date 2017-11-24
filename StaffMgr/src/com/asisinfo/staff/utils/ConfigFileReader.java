package com.asisinfo.staff.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.asisinfo.staff.utils.ConfigFileReader;

public class ConfigFileReader {
	public static String read(String filename) {
		InputStream input = ConfigFileReader.class.getResourceAsStream("/" + filename);
		String content = "";
		try {
			content = IOUtils.toString(input,"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		IOUtils.closeQuietly(input);
		return content;
	}


}

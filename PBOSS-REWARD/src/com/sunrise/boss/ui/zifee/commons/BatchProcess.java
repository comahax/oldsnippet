package com.sunrise.boss.ui.zifee.commons;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.struts.upload.FormFile;


public class BatchProcess {
	
	
	/**
	 * 得到参数文件，解析
	 */
	public static Iterator getData(FormFile inputFile) throws Exception {
		List list = new ArrayList();
		String total = getInputFile(inputFile);
		StringTokenizer rows = null;
		if (total != null) {
			rows = getRows(total);
		}
		if (rows != null) {
			for (; rows.hasMoreTokens();) {
				String row = rows.nextToken();
				list.add(row);
			}
		}
		return list.iterator();
	}

	/**
	 * 拆分字串
	 */
	public static String[] getInResult(String reStr) throws Exception {
		String[] result = null;
		result = reStr.split("\\|"); // 分隔符为竖线
		return result;
	}
	
	/**
	 * 得到上传文件并解析为字串
	 */
	private static String getInputFile(FormFile inputFile) throws Exception {
		InputStream inputstream = null;
		
		try {
			inputstream = inputFile.getInputStream();
		} catch (FileNotFoundException ex1) {
			throw new Exception("找不到指定文件！");
		} catch (IOException ex1) {
			throw new Exception("读写错误:" + ex1.getMessage());
		} catch (NullPointerException ex1) {
			throw new Exception("请指定批处理文件！");
		}
		
		StringBuffer buffer = new StringBuffer("");
		int totalSize = inputFile.getFileSize();
		byte[] bytes = new byte[totalSize];
		try {
			int i = 0;
			int j = 0;
			for (; i < totalSize; i++) {
				try {
					j = inputstream.read(bytes, i, 1);
					if (bytes[i] > 0) {
						byte[] tmp = new byte[1];
						tmp[0] = bytes[i];
						buffer.append(new String(tmp, "US-ASCII"));
					} else {
						i++;
						j = inputstream.read(bytes, i, 1);
						byte[] tmp = new byte[2];
						tmp[0] = bytes[i - 1];
						tmp[1] = bytes[i];
						buffer.append(new String(tmp, "GBK"));
					}
				} catch (Exception ex) {
					throw new Exception("文件上传出现错误! ");
				}
			}
		} catch (Exception ex) {
			throw new Exception("读入文件时出现错误！");
		}
		return buffer.toString();
	}

	/**
	 * 根据分割符拆分字串
	 */
	private static StringTokenizer getRows(String total) throws Exception {
		StringTokenizer rows = null;
		if (total.indexOf("\r\n") != -1) {
			rows = new StringTokenizer(total, "\r\n");
		} else {
			rows = new StringTokenizer(total, "\n");
		}
		return rows;
	}



}

/**
 * Copyright(c)1994-2007 SRE. All rights reserved.<br>
 * Use is subject to license terms.
 */
package com.asisinfo.common.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileUploadException;

/**
 * @author chenhm
 * @created 2007-3-29 ����06:04:20
 * @version 1.0
 */
public class FileItemsUtil {
	public static String getParameter(List items, String name) {
		for (int i = 0; i < items.size(); i++) {
			FileItem item = (FileItem) items.get(i);
			if (item.isFormField() && name.equals(item.getFieldName())) {
				String value = item.getString();
				try {
					return new String(value.getBytes("ISO-8859-1"), "utf8");
				}
				catch (UnsupportedEncodingException e) {
					return FileItemsUtil.class.getName()+"#getParameter[UnsupportedEncodingException]";
				}
			}
		}
		return null;
	}
	
	public static Map getParameterMap(List items) {
		Map m = new HashMap();
		for (int i = 0; i < items.size(); i++) {
			FileItem item = (FileItem) items.get(i);
			if (item.isFormField()) {
				String key = item.getFieldName();
				String value="";
				try {
					value = item.getString("utf8");
					if(value!=null)
						value = value.trim();
				} catch (UnsupportedEncodingException e) {
				}
				m.put(key, value);
			}
		}
		return m;
	}

	public static String getTrimParam(List items, String name) {
		String s = getParameter(items, name);
		return (s == null) ? null : s.trim();
	}

	public static List getFileItems(List items) {
		List result = new LinkedList();
		for (int i = 0; i < items.size(); i++) {
			FileItem item = (FileItem) items.get(i);
			if (!item.isFormField()) {
				result.add(item);
			}
		}
		return result;
	}

	public static FileItem getFileItem(List items, String name) {
		for (int i = 0; i < items.size(); i++) {
			FileItem item = (FileItem) items.get(i);
			if (!item.isFormField() && name.equals(item.getFieldName())) {
				return item;
			}
		}
		return null;
	}

	public static List parseRequest(HttpServletRequest request, String path)
			throws FileUploadException {
		return parseRequest(request, 1024 * 1024, path); // Ĭ��1M���ڵ���ݷ����ڴ�
	}

	/**
	 * ��request�л�ȡFileItem List.
	 * 
	 * @param request
	 * @param sizeThreshold
	 * @param path
	 * @return
	 * @throws FileUploadException
	 */
	public static List parseRequest(HttpServletRequest request,
			int sizeThreshold, String path) throws FileUploadException {
		// Check that we have a file upload request
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			throw new UnsupportedOperationException("����Multipart�����޷������ļ�");
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();

		factory.setSizeThreshold(sizeThreshold);
		factory.setRepository(new File(path));
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf8");
		List /* FileItem */items = upload.parseRequest(request);
		return items;
	}
	
	public static String getFileName(String fullName){
		String fileName = "";
		if(fullName!=null&&(!"".endsWith(fullName))){
			fullName = fullName.replaceAll("\\\\", "/");
			int pos = fullName.lastIndexOf( "/");					 
			fileName = fullName.substring(pos+1);
		}
		return fileName;
	}
	
	public static FileItem getFileItem(HttpServletRequest request, String path)
			throws FileUploadException {
		List<?> list = FileItemsUtil.parseRequest(request,path);
		FileItem fItem = null;
		for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
			FileItem item = (FileItem) iterator.next();
			if(!item.isFormField()){
				fItem = item;
				break;
			}
		}
		return fItem;
	}
}

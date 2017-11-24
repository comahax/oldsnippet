/**
 * Copyright(c)1999-2008 Sunrise Electronics Developmnet Co.,Ltd<br>
 * All rights reserved. Use is subject to license terms.
 */
package com.asisinfo.common.web.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;


/**
 * @author wanhongquan
 * @created at 2010-8-29 …œŒÁ11:38:58
 * @version $Id$
 */
public class FilePathLoader {

	public static FilePathLoader instance = null;
	
	private FilePathLoader() {
		
	}
	
	public static synchronized FilePathLoader getInstance() throws IOException{
        if(instance==null) instance = new FilePathLoader();
        return instance;
    }
	
	private void read(BufferedReader reader,Map<String,String>map) throws IOException {
        String line;
        while ( (line = reader.readLine()) != null) {
            parseLine(line,map);
        }
    }
	
	private Map<String,String> load()throws IOException
	{
		BufferedReader reader =null;
		try{
		Map<String,String> map=new HashMap<String,String>();
		String realPath=java.net.URLDecoder.decode(this.getClass().getResource("FilePath.ini").getPath(),"utf-8");
		reader= new BufferedReader(new FileReader(realPath));
        read(reader,map);
        return map;
		}catch(IOException e)
		{
			throw e;
		}finally
		{
			if(reader!=null)  reader.close();
		}
	}
	
	public String getFilePath(String pathname)throws IOException{
		Map m = load();
		String rootPath = (String)m.get("rootPath");
		if(StringUtils.isEmpty(rootPath)){
			throw new RuntimeException("«Î≈‰÷√rootPath");
		}
		rootPath = rootPath.replace("/", File.separator).replace("\\", File.separator);
		if(!rootPath.endsWith(File.separator)){
			rootPath = rootPath+File.separator;
		}
		
		String path = (String)m.get(pathname);
		if(StringUtils.isEmpty(path))
			return null;
		path = path.replace("/", File.separator).replace("\\", File.separator);
		if(path.startsWith(File.separator)){
			path = path.substring(1);
		}
		
		return rootPath+path;
	}
	
	public String getFilePath(String pathname,String filename)throws IOException{
		String path = getFilePath(pathname);
		if(!path.endsWith(File.separator)){
			path = path+File.separator;
		}
		return path+filename;
	}
	
	private void parseLine(String line,Map<String,String> map) throws IOException {
		line = new String(line.trim().getBytes(),"GBK");
		if (line.matches(".*=.*")&&!line.trim().startsWith("#")) {
            //  JDK  µÕ”⁄  1.4   ±
            //  }  else  if  (line.indexOf('=')  >=  0)  {
            int i = line.indexOf('=');
            String name = line.substring(0, i).trim();
            String value = line.substring(i + 1).trim();
            map.put(name, value);
        }
    }
	
	public static void main(String[] args) throws Exception{
		System.out.println(getInstance().getFilePath("analAttach"));
	}
}

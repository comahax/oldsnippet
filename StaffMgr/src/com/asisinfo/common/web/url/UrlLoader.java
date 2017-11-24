/**
 * Copyright(c)1999-2008 Sunrise Electronics Developmnet Co.,Ltd<br>
 * All rights reserved. Use is subject to license terms.
 */
package com.asisinfo.common.web.url;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * @author wanhongquan
 * @created at 2010-8-29 ÉÏÎç11:38:58
 * @version $Id$
 */
public class UrlLoader {

	public static UrlLoader instance = null;
	
	private UrlLoader() {
		
	}
	
	public static synchronized UrlLoader getInstance() throws IOException{
        if(instance==null) instance = new UrlLoader();
        return instance;
    }
	
	public void read(BufferedReader reader,Map<String,String>map) throws IOException {
        String line;
        while ( (line = reader.readLine()) != null) {
            parseLine(line,map);
        }
        
    }
	
	public Map<String,String> load()throws IOException
	{
		BufferedReader reader =null;
		try{
		Map<String,String> map=new HashMap<String,String>();
		String realPath=java.net.URLDecoder.decode(this.getClass().getResource("url.ini").getPath(),"utf-8");
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
	
	
	public void parseLine(String line,Map<String,String> map) throws IOException {
		line = new String(line.trim().getBytes(),"GBK");
		if (line.matches(".*=.*")&&!line.trim().startsWith("#")) {
            //  JDK  µÍÓÚ  1.4  Ê±
            //  }  else  if  (line.indexOf('=')  >=  0)  {
            int i = line.indexOf('=');
            String name = line.substring(0, i).trim();
            String value = line.substring(i + 1).trim();
            map.put(name, value);
        }
        
    }
	
}

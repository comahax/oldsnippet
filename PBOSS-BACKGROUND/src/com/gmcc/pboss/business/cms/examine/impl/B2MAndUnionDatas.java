package com.gmcc.pboss.business.cms.examine.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.cms.examine.Examine;
/**
 * B2M&创薪联盟业务量统计
 * 功能描述：对网站业务办理数据文件和全员代理数据文件进行扫描，按照渠道进行业务量统计。
 * @author Eric
 *
 */
public class B2MAndUnionDatas implements Examine {

	public List examine(String starttime, String endtime,String cityid) throws Exception{
		Properties conf = new Properties();
		InputStream is = this.getClass().getResourceAsStream("/examine/examine.properties");
		conf.load(is);
		is.close();
		List<File> fileList=doFileDir(conf.getProperty("inc.path"),"inc_allsales_"+endtime.substring(0, 6)+"00_"+cityid.toLowerCase());//B2M业务量统计
		fileList.addAll(doFileDir(conf.getProperty("smsbo.path"),"smsbo_allsales_"+endtime.substring(0, 6)+"00_"+cityid.toLowerCase()));//创新联盟业务量统计,将文件集合与BEM集合合并
		return this.doFiles(fileList);
	}
	public static void main(String[] args)  throws Exception{
		B2MAndUnionDatas o=new B2MAndUnionDatas();
		
		List<Map> mapList=o.examine("", "20110712000000","ZS");
		for(Map map:mapList){
			System.out.println(map.get("WAYID")+"     "+map.get("BUSIVALUE"));
		}
	}
	/**
	 * 根据目录、文件名匹配字符获取符合条件的文件集合
	 * @param path
	 * @param fileStr
	 * @return
	 * @throws Exception
	 */
	public List<File> doFileDir(String path,String fileStr) throws Exception{
		List<File> fileList=new ArrayList<File>();
		File fileDir=new File(path);
		if(fileDir.exists()){//扫描业务办理数据文件所在目录
			File[] files=fileDir.listFiles();
			//System.out.println(fileStr);
			for(File file:files){
				if(file.isFile()){//判断是否文件
					if(file.getName().indexOf(fileStr)>=0){
						//System.out.println(file.getName());
						fileList.add(file);
					}
				}
			}
		}
		return fileList;
	}
	/**
	 * 统计文件记录中渠道出现的次数
	 * @param files
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,String>> doFiles(List<File> files) throws Exception{
		String line=null;
		FileInputStream fileInputStream=null;
		InputStreamReader read =null;
		BufferedReader rin=null;
		String[] items =null;
		Map<String,Long> map=new HashMap<String,Long>();//统计存在MAP<渠道编码，数量>
		long count=0;//文件记录计数器
		for(File file:files){//遍历文件
			try {
				fileInputStream = new FileInputStream(file);
				read = new InputStreamReader(fileInputStream, "gbk");
				rin = new BufferedReader(read);
				rin.readLine();//先读取第一行标题，不做任何处理
				count=0;//计数器清零
				while((line=rin.readLine())!=null){//遍历标题行下的数据
					items = StringUtils.splitPreserveAllTokens(line, "|");//将数据拆分成数组
					if(items.length>1){//数组大于1个
						count++;//计数器加1
						if(items[5]!=null && items[5].length()>0){//判断第6个数据元素（渠道编码）不为空，长度大于0
							if(map.containsKey(items[5])){//判断统计MAP是否存在该渠道的信息
								map.put(items[5], map.get(items[5])+1);//对应渠道数量加1
							}else{
								map.put(items[5], 1l);// 添加渠道MAP元素，数量为1
							}
						}
					}else{//为一列时,判断为尾行
						//将文件尾记录总数与文件总行数进行比较，如果不一致则返回“文件[XXX]格式错误”
						if(items[0].indexOf("HDR2")>=0){
							if(Long.valueOf(items[0].replaceAll("HDR2",""))!=count){
								 throw new Exception("文件["+file.getName()+"]格式错误");
							}
						}
					}
				}
				rin.close();
				read.close();
				fileInputStream.close();
			} catch (Exception e) {
				if(rin!=null)
					rin.close();
				if(read!=null)
					read.close();
				if(fileInputStream!=null)
					fileInputStream.close();
				throw e;
			}
		}
		
		//对统计数据进行封装
		List<Map<String,String>> resultList = new ArrayList<Map<String,String>>();
		Map<String,String> wayBusiValueMap=null;
		Set<String> keys=map.keySet();
		for(String key:keys){
			wayBusiValueMap = new HashMap<String,String> ();
			wayBusiValueMap.put("WAYID", key);
			wayBusiValueMap.put("BUSIVALUE",map.get(key).toString());
			resultList.add(wayBusiValueMap);
		}
		return resultList;
		
	}

}

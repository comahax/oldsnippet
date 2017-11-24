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
 * B2M&��н����ҵ����ͳ��
 * ��������������վҵ����������ļ���ȫԱ���������ļ�����ɨ�裬������������ҵ����ͳ�ơ�
 * @author Eric
 *
 */
public class B2MAndUnionDatas implements Examine {

	public List examine(String starttime, String endtime,String cityid) throws Exception{
		Properties conf = new Properties();
		InputStream is = this.getClass().getResourceAsStream("/examine/examine.properties");
		conf.load(is);
		is.close();
		List<File> fileList=doFileDir(conf.getProperty("inc.path"),"inc_allsales_"+endtime.substring(0, 6)+"00_"+cityid.toLowerCase());//B2Mҵ����ͳ��
		fileList.addAll(doFileDir(conf.getProperty("smsbo.path"),"smsbo_allsales_"+endtime.substring(0, 6)+"00_"+cityid.toLowerCase()));//��������ҵ����ͳ��,���ļ�������BEM���Ϻϲ�
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
	 * ����Ŀ¼���ļ���ƥ���ַ���ȡ�����������ļ�����
	 * @param path
	 * @param fileStr
	 * @return
	 * @throws Exception
	 */
	public List<File> doFileDir(String path,String fileStr) throws Exception{
		List<File> fileList=new ArrayList<File>();
		File fileDir=new File(path);
		if(fileDir.exists()){//ɨ��ҵ����������ļ�����Ŀ¼
			File[] files=fileDir.listFiles();
			//System.out.println(fileStr);
			for(File file:files){
				if(file.isFile()){//�ж��Ƿ��ļ�
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
	 * ͳ���ļ���¼���������ֵĴ���
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
		Map<String,Long> map=new HashMap<String,Long>();//ͳ�ƴ���MAP<�������룬����>
		long count=0;//�ļ���¼������
		for(File file:files){//�����ļ�
			try {
				fileInputStream = new FileInputStream(file);
				read = new InputStreamReader(fileInputStream, "gbk");
				rin = new BufferedReader(read);
				rin.readLine();//�ȶ�ȡ��һ�б��⣬�����κδ���
				count=0;//����������
				while((line=rin.readLine())!=null){//�����������µ�����
					items = StringUtils.splitPreserveAllTokens(line, "|");//�����ݲ�ֳ�����
					if(items.length>1){//�������1��
						count++;//��������1
						if(items[5]!=null && items[5].length()>0){//�жϵ�6������Ԫ�أ��������룩��Ϊ�գ����ȴ���0
							if(map.containsKey(items[5])){//�ж�ͳ��MAP�Ƿ���ڸ���������Ϣ
								map.put(items[5], map.get(items[5])+1);//��Ӧ����������1
							}else{
								map.put(items[5], 1l);// �������MAPԪ�أ�����Ϊ1
							}
						}
					}else{//Ϊһ��ʱ,�ж�Ϊβ��
						//���ļ�β��¼�������ļ����������бȽϣ������һ���򷵻ء��ļ�[XXX]��ʽ����
						if(items[0].indexOf("HDR2")>=0){
							if(Long.valueOf(items[0].replaceAll("HDR2",""))!=count){
								 throw new Exception("�ļ�["+file.getName()+"]��ʽ����");
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
		
		//��ͳ�����ݽ��з�װ
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

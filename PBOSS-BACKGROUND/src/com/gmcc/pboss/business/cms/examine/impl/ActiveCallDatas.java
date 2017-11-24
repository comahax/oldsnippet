package com.gmcc.pboss.business.cms.examine.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.gmcc.pboss.business.cms.examine.Examine;
import com.gmcc.pboss.business.sales.partnerres.PartnerresDBParam;
import com.gmcc.pboss.business.sales.partnerres.PartnerresVO;
import com.gmcc.pboss.control.sales.partnerres.Partnerres;
import com.gmcc.pboss.control.sales.partnerres.PartnerresBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;
/**
 * ����ͨ��ҵ����ͳ��
 * ����������������ͨ�ź����ļ�����ɨ�裬�����������׿�������Ϣ��������������ҵ�����ۼ�
 * @author yde
 *
 */
public class ActiveCallDatas implements Examine {

	private Logger log = Logger.getLogger(ActiveCallDatas.class);
	public List examine(String starttime, String endtime,String cityid) throws Exception{
		Properties conf = new Properties();
		InputStream is = this.getClass().getResourceAsStream("/examine/examine.properties");
		conf.load(is);
		is.close();
		List<File> fileList=doFileDir(conf.getProperty("bi.path"),"bi_zdtx_"+endtime.substring(0, 6)+"00_"+cityid.toUpperCase(),endtime.substring(0, 6),cityid);//����ͨ��ҵ����ͳ��
		//��ȡUser
		User user = this.getUser(cityid);
		return this.doFiles(fileList,endtime.substring(0, 6),conf.getProperty("querycache"),user);
	}
	public static void main(String[] args)  throws Exception{
		ActiveCallDatas o=new ActiveCallDatas();
		
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
	public List<File> doFileDir(String path,String fileStr,String yyyyMM,String cityid) throws Exception{
		List<File> fileList=new ArrayList<File>();
		File fileDir=new File(path);
		if(fileDir.exists()){//ɨ������ͨ�������ļ�����Ŀ¼
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
			if(fileList.size() == 0){
				throw new Exception("ָ������["+cityid.toUpperCase()+"]ָ������["+yyyyMM+"]��Ӧ������ͨ�������ļ�������");
			}
		}else{
			throw new Exception("����ͨ�������ļ��Ĵ��Ŀ¼�����ڣ�Ŀ¼["+path+"]");
		}
		return fileList;
	}
	/**
	 * ͳ���ļ���¼���������ֵĴ���
	 * @param files
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,String>> doFiles(List<File> files,String yyyymm,String querycache,User user) throws Exception{
		String line=null;
		FileInputStream fileInputStream=null;
		InputStreamReader read =null;
		BufferedReader rin=null;
		String[] items =null;
		int cache = 100;//���û�����ã���Ĭ��Ϊ100
		if(com.sunrise.jop.common.utils.lang.StringUtils.isNotBlank(querycache))
			cache = new Integer(querycache);
		Map<String,Long> map=new HashMap<String,Long>();//ͳ�ƴ���MAP<�������룬����>
		long count=0;//�ļ���¼������
		for(File file:files){//�����ļ�
			try {
				fileInputStream = new FileInputStream(file);
				read = new InputStreamReader(fileInputStream, "gbk");
				rin = new BufferedReader(read);
				Partnerres p = (Partnerres)BOFactory.build(PartnerresBO.class, user);
				//count=0;//����������
				String[] comresids=new String[cache];
				while((line=rin.readLine())!=null){//�����������µ�����
					items = StringUtils.splitPreserveAllTokens(line, "|");//�����ݲ�ֳ�����
					int i=0;
					if(items.length>1){//�������1��
						count++;//��������1
						comresids[i] = items[0];
						i++;
					}
					if(count%cache==0){
						PartnerresDBParam param = new PartnerresDBParam();
						List<String> comresidList = Arrays.asList(comresids);
						param.set_sin_comresid(new ArrayList<String>(comresidList));
						param.set_dnl_createtime(yyyymm.substring(0, 4)+"-"+yyyymm.substring(4)+"-01 00:00:00");
						param.set_dnm_createtime(yyyymm.substring(0, 4)+"-"+yyyymm.substring(4)+"-31 23:59:59");
						param.setDataOnly(true);
						List<PartnerresVO> list = p.doQuery(param).getDatas();
						for(PartnerresVO vo:list){
							vo = list.iterator().next();
							if(map.containsKey(vo.getWayid())){//�ж�ͳ��MAP�Ƿ���ڸ���������Ϣ
								map.put(vo.getWayid(), map.get(vo.getWayid())+1);//��Ӧ����������1
							}else{
								map.put(vo.getWayid(), 1L);// �������MAPԪ�أ�����Ϊ1
							}
						}
					}
					if(count%1000==0)
						log.info("����ͨ��ҵ����ͳ���Ѵ���"+count+"����¼");
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
	
	/**
	 * ����user
	 */
	protected User getUser(String cityid) {
		User user = new User();
		user.setCityid(cityid);
		user.setOpername("PBOSS-BG");
		user.setOprcode("PBOSS-BG");
		return user;
	}

}

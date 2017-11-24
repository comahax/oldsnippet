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
 * 主动通话业务量统计
 * 功能描述：对主动通信号码文件进行扫描，结合社会渠道套卡订购信息，按照渠道进行业务量累计
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
		List<File> fileList=doFileDir(conf.getProperty("bi.path"),"bi_zdtx_"+endtime.substring(0, 6)+"00_"+cityid.toUpperCase(),endtime.substring(0, 6),cityid);//主动通话业务量统计
		//获取User
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
	 * 根据目录、文件名匹配字符获取符合条件的文件集合
	 * @param path
	 * @param fileStr
	 * @return
	 * @throws Exception
	 */
	public List<File> doFileDir(String path,String fileStr,String yyyyMM,String cityid) throws Exception{
		List<File> fileList=new ArrayList<File>();
		File fileDir=new File(path);
		if(fileDir.exists()){//扫描主动通信数据文件所在目录
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
			if(fileList.size() == 0){
				throw new Exception("指定地市["+cityid.toUpperCase()+"]指定年月["+yyyyMM+"]对应的主动通信数据文件不存在");
			}
		}else{
			throw new Exception("主动通信数据文件的存放目录不存在，目录["+path+"]");
		}
		return fileList;
	}
	/**
	 * 统计文件记录中渠道出现的次数
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
		int cache = 100;//如果没有设置，则默认为100
		if(com.sunrise.jop.common.utils.lang.StringUtils.isNotBlank(querycache))
			cache = new Integer(querycache);
		Map<String,Long> map=new HashMap<String,Long>();//统计存在MAP<渠道编码，数量>
		long count=0;//文件记录计数器
		for(File file:files){//遍历文件
			try {
				fileInputStream = new FileInputStream(file);
				read = new InputStreamReader(fileInputStream, "gbk");
				rin = new BufferedReader(read);
				Partnerres p = (Partnerres)BOFactory.build(PartnerresBO.class, user);
				//count=0;//计数器清零
				String[] comresids=new String[cache];
				while((line=rin.readLine())!=null){//遍历标题行下的数据
					items = StringUtils.splitPreserveAllTokens(line, "|");//将数据拆分成数组
					int i=0;
					if(items.length>1){//数组大于1个
						count++;//计数器加1
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
							if(map.containsKey(vo.getWayid())){//判断统计MAP是否存在该渠道的信息
								map.put(vo.getWayid(), map.get(vo.getWayid())+1);//对应渠道数量加1
							}else{
								map.put(vo.getWayid(), 1L);// 添加渠道MAP元素，数量为1
							}
						}
					}
					if(count%1000==0)
						log.info("主动通话业务量统计已处理"+count+"条记录");
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
	
	/**
	 * 返回user
	 */
	protected User getUser(String cityid) {
		User user = new User();
		user.setCityid(cityid);
		user.setOpername("PBOSS-BG");
		user.setOprcode("PBOSS-BG");
		return user;
	}

}

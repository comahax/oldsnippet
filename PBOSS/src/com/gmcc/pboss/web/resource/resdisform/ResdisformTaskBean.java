package com.gmcc.pboss.web.resource.resdisform;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.compack.CompackDBParam;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.business.resource.discomres.DiscomresVO;
import com.gmcc.pboss.business.resource.resdisform.ResdisformVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.comressmp.Comressmp;
import com.gmcc.pboss.control.resource.comressmp.ComressmpBO;
import com.gmcc.pboss.control.resource.discomres.Discomres;
import com.gmcc.pboss.control.resource.discomres.DiscomresBO;
import com.gmcc.pboss.control.resource.resdisform.Resdisform;
import com.gmcc.pboss.control.resource.resdisform.ResdisformBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class ResdisformTaskBean extends BaseBatchTaskBean{

	private List<WayVO> ways;
	private Compack compackBO;
	private Discomres discomresB0;
	private Map<String,Map<String,String>> resourceMap = new HashMap<String,Map<String,String>>();
	public ResdisformTaskBean() throws Exception {
		super();
		// TODO Auto-generated constructor stub
		super.setBatchName("套卡资源批量分配");

	}

	
	@Override
	public void doProcessFile(String fileInPath, String fileOutPath)
			throws Exception {
		// TODO Auto-generated method stub
//		配送商信息加载：查询渠道表（CH_PW_WAY），匹配条件为渠道类别等于社会渠道（即WAYTYPE=AG）
//		且渠道子类别等于配送商（即WAYSUBTYPE=LOGS），渠道标识（WAYID）即为配送商编码，将配送商信息加载到内存中，可用MAP保存。
		Way wayBO = (WayBO)BOFactory.build(WayBO.class,user);
		WayDBParam params = new WayDBParam();
		params.setQueryAll(true);
		params.set_se_waytype("AG");
		params.set_se_waysubtype("LOGS");
		DataPackage dp = wayBO.doQuery(params);
		ways = dp.getDatas();
		super.doProcessFile(fileInPath, fileOutPath);
		
//		文件处理完成后，新增数据到资源分配单（IM_PR_RESDISFORM）。分配单号和资源库区取界面数据，
//		分配人工号为当前操作员工号，分配时间为当前时间，分配单状态为“待签收”，
//		配送商编码、资源数量取文件处理过程累计信息，统计信息为文件处理过程累计商品种类及对应数量，
//		格式为“商品种类1-数量 商品种类2-数量”，例如“DG55-15000 DG100-5000”。
//		其他字段包括签收人工号、签收时间、发布人工号、发布时间、发布短信内容、短信通知是否完成留空。
		String disid = (String)super.getParameterMap().get("disid");
		String storarea = (String)super.getParameterMap().get("storarea");
		Resdisform resdisformBO = (ResdisformBO)BOFactory.build(ResdisformBO.class,user);
		long total = 0;//配送商新增资源总量
		StringBuilder detail = new StringBuilder(50);//配送商新增资源统计信息
		if( !resourceMap.isEmpty()){
			Set<String> resourceKeySet = resourceMap.keySet();
			for(String resourceKey : resourceKeySet){
				Map<String,String> categoryMap = resourceMap.get(resourceKey);
				Set<String> categoryKeySet = categoryMap.keySet();
				for(String categoryKey:categoryKeySet){
					total += Long.parseLong(categoryMap.get(categoryKey));
					detail.append(categoryKey).append("-").append(categoryMap.get(categoryKey)).append(" ");
				}
				{
					
					ResdisformVO resdisformVO = new ResdisformVO();
					resdisformVO.setResamt(total);
					resdisformVO.setStatinfo(detail.toString());
					resdisformVO.setDisid(disid);
					resdisformVO.setStorarea(storarea);
					resdisformVO.setDiscode(user.getOprcode());
					resdisformVO.setDistime(new Date());
					resdisformVO.setDisformstate("WAITSIGN");
					resdisformVO.setDiscomcode(resourceKey);
					
					resdisformBO.doCreate(resdisformVO);
				}
			}
		}
		
	}


	@Override
	protected ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub
		ResultVO resultVO = new ResultVO();
		try{
			String disid = (String)super.getParameterMap().get("disid");
			String storarea = (String)super.getParameterMap().get("storarea");
			
			String[] item = StringUtils.splitPreserveAllTokens(line, "|");
			int i = 0;
			for(i = 0;i<ways.size();i++){
				if(ways.get(i).getWayid().equals(item[0]))
					break;
			}
			//查询配送商编码是否在配送商MAP中，如果存在则通过，如果不存在则记录出错原因“配送商不存在”。
			if(i==ways.size()){
				throw new Exception ("配送商["+item[0]+"]不存在");
			}
			
			Resdisform resdisformBO = (ResdisformBO)BOFactory.build(ResdisformBO.class,user);
			Map<String,String> categoryMap = resdisformBO.doUpdate(item, ways, disid, storarea);
			if(!categoryMap.isEmpty()){//新增了一些商品
				Map<String,String> tempMap = resourceMap.get(item[0]);
				if(null == tempMap){//尚未有该配送商的信息
					resourceMap.put(item[0], categoryMap);
				}else{
					Set<String> keySet = categoryMap.keySet();
					for(String key: keySet){
						String count = tempMap.get(key);
						if( null == count){//不存大此种商品种类则加进
							tempMap.put(key, categoryMap.get(key));
						}else{//存在此商品种类的商品则增加此种商品的数量
							tempMap.put(key, Long.parseLong(categoryMap.get(key))+Long.parseLong(tempMap.get(key))+"");
						}
						resourceMap.put(item[0], tempMap);//更新该配送商的新增商品信息
					}
				}
				
			}
				
			line = rowCount + "   " + line + "    成功";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		}catch(Exception e){
			line = rowCount + "   " + line + "    错误信息:" + e.getMessage();
			e.printStackTrace();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
			return resultVO;
	}
}

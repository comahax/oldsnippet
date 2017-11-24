package com.gmcc.pboss.web.sales.stockalarm;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.sales.stockalarm.StockalarmDBParam;
import com.gmcc.pboss.business.sales.stockalarm.StockalarmVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.stockalarm.Stockalarm;
import com.gmcc.pboss.control.sales.stockalarm.StockalarmBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class StockalarmTaskBean extends BaseBatchTaskBean {

	public StockalarmTaskBean() throws Exception {
		super.setBatchName("套卡库存预警设置（渠道)批量导入");
		super.setOprtype("导入");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "套卡库存预警设置（渠道)批量导入结果  \r\n";
	}

	/**
	 * 处理一条记录
	 */
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			Stockalarm stockalarm = (Stockalarm) BOFactory.build(StockalarmBO.class, user);
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			
			Way way = (Way)BOFactory.build(WayBO.class, user);
			WayDBParam param = new WayDBParam();
			param.set_se_wayid(items[0]);
			param.set_se_waytype("AG");
			DataPackage dp = way.doQuery(param);
			if(dp.getRowCount()==0)
			{
				throw new Exception("合作商不存在");
			}
			
			Dictitem dictitem = (Dictitem)BOFactory.build(DictitemBO.class, user);
			DictitemDBParam param2 = new DictitemDBParam();
			DataPackage dp2=null;
			
			Sysparam sysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class,user);
			SysparamVO sysparamVO = new SysparamVO();
			sysparamVO.setParamtype("pboss_fx");
			sysparamVO.setSystemid(new Long(73));
			sysparamVO = sysparamBO.doFindByPk(sysparamVO);
			
			String s [] = items[1].split(",");//"套卡品牌不正确";
			if(!sysparamVO.getParamvalue().toString().equals("1")){
				if(s.length>1){
					throw new Exception("套卡品牌不正确");	
				}
			}		
			
			
			param2.set_se_groupid("FX_SMPBRAND");
			param2.set_se_dictid("");
			 dp2 = dictitem.doQuery(param2);
			List<DictitemVO> dictitemList = dp2.getDatas();
			if(dictitemList.size()>0)
			{
				Set<String> brandSet = new HashSet<String>();
				
				Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, user);
				String paramValue = sysparam.doFindByID("12","pboss_fx");
				if(null!=paramValue)
				{
					if(paramValue.equals("1"))
					{
						for(DictitemVO dictitemVO : dictitemList)
						{
							String brand = dictitemVO.getDictid();
							if(null!=brand&&!brand.equals("AllBrand"))
							{
								brandSet.add(dictitemVO.getDictid());
							}
								
						}
					}
					else
					{
						brandSet.add("AllBrand");
					}
				}
				else{
					throw new Exception("套卡品牌参数未设置");
				}
				
				
				
				for(int i=0;i<s.length;i++){
					if(!brandSet.contains(s[i]))
					{
						throw new Exception("套卡品牌不存在");
					}		
				}
				
				
			}
			else{
				throw new Exception("套卡品牌不存在");
			}
			
			param2.set_se_dictid(items[5]);
			param2.set_se_groupid("FX_UPDATECHANNEL");
			dp2 = dictitem.doQuery(param2);
			if(dp2.getRowCount()==0)
			{
				throw new Exception("更新途径不存在");
			}
			
			//大于零的整数，最大长度10位。 
			try{
			
				Long.valueOf(items[2]);
				if(items[2].length()>10){
					throw new Exception("最高库存数据长度错误");
				}
			
			}catch(Exception e){
				throw new Exception("最高库存数据类型错误");
				
			}
			//大于零的整数，最大长度10位。 
			try{
				
				Long.valueOf(items[3]);
				if(items[3].length()>10){
					throw new Exception("红色预警数据长度错误");
				}
				
			}catch(Exception e){
				throw new Exception("红色预警数据类型错误");
				
			}
			//大于零的整数，最大长度10位。 
			try{
				
				Long.valueOf(items[4]);
				if(items[4].length()>10){
					throw new Exception("黄色预警数据长度错误");
				}
				
			}catch(Exception e){
				throw new Exception("黄色预警数据类型错误");
				
			}
		
			StockalarmVO stockalarmVO = new StockalarmVO();
			stockalarmVO.setWayid(items[0]);
			stockalarmVO.setBrand(items[1]);
			stockalarmVO.setMaxstock(Long.valueOf(items[2]));
			stockalarmVO.setAlarmvalue("REDALARM:" + items[3] + ";YELALARM:" + items[4]);
			stockalarmVO.setUpdatechannel(items[5]);
			stockalarmVO.setChgtime(new Date());
			StockalarmDBParam param3 = new StockalarmDBParam();
			param3.set_se_wayid(stockalarmVO.getWayid());
			param3.set_se_brand(stockalarmVO.getBrand());
			DataPackage dp4 = stockalarm.doQuery(param3);
			if (dp4.getRowCount() == 0) {
				stockalarm.doCreate(stockalarmVO);
			} else {
				StockalarmVO vo = (StockalarmVO)dp4.getDatas().get(0);
				BeanUtils.copyProperties(vo,stockalarmVO);
				stockalarm.doUpdate(vo);
			}
			line = rowCount + "   " + line + "    成功";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) {
			line = rowCount + "   " + line + "    错误信息:" + e.getMessage();
			e.printStackTrace();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
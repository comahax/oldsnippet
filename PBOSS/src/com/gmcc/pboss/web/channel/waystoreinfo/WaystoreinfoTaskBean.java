package com.gmcc.pboss.web.channel.waystoreinfo;

import java.util.Date;
import org.apache.commons.lang.StringUtils; 
import com.gmcc.pboss.business.channel.waystoreinfo.WaystoreinfoVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.channel.waystoreinfo.Waystoreinfo;
import com.gmcc.pboss.control.channel.waystoreinfo.WaystoreinfoBO;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class WaystoreinfoTaskBean extends BaseBatchTaskBean {
	
	public WaystoreinfoTaskBean() throws Exception {
		try {
			super.setBatchName("门店宣传信息管理批量导入");
			super.setOprtype("导入");
			super.setWriteLog(true); 
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		return "行号|门店编码|面积|专区类型|专区面积|专区背板|专区专柜|专区立牌|专区价签|专区展架|专区店内横幅|专区店外横幅|专区堆头|专区地贴|专区桌面台牌点位|专区桌面台卡点位|专区海报|门头类型||外墙广告面积大小|外墙广告大幅宣传画点位|终端专营|业务专营|店内宣传数量|系数|处理结果|  \r\n";
	}
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");  
			Waystoreinfo waystoreinfo = (Waystoreinfo)BOFactory.build(WaystoreinfoBO.class, user) ;
			WaystoreinfoVO vo = waystoreinfo.doFindByPk(items[0].trim());
			if(vo == null){
				vo = new WaystoreinfoVO();
				vo.setWayid(items[0]);
				vo.setArea(Double.parseDouble(items[1]));
				vo.setZqtype(Short.parseShort(items[2]));
				vo.setZqarea(Double.parseDouble(items[3]));
				vo.setZqpanel(Short.parseShort(items[4]));
				vo.setZqcupboard(Short.parseShort(items[5]));
				vo.setZqcards(Short.parseShort(items[6]));
				vo.setZqpricetag(Short.parseShort(items[7]));
				vo.setZqrack(Short.parseShort(items[8]));
				vo.setZqinad(Short.parseShort(items[9]));
				vo.setZqoutad(Short.parseShort(items[10]));
				vo.setZqhead(Short.parseShort(items[11]));
				vo.setZqpaste(Short.parseShort(items[12]));
				vo.setZqtablecard(Short.parseShort(items[13]));
				vo.setZqdecca(Short.parseShort(items[14]));
				vo.setZqbill(Short.parseShort(items[15]));
				vo.setDoortype(Short.parseShort(items[16]));
				vo.setOutwallad(Double.parseDouble(items[17]));
				vo.setOutwallpic(Short.parseShort(items[18]));
				vo.setTdmonopoly(Short.parseShort(items[19]));
				vo.setBusimonopoly(Short.parseShort(items[20]));
				vo.setStoreconduct(Short.parseShort(items[21]));
				vo.setModulus(Float.parseFloat(items[22])); 
				vo.setCityid(user.getCityid()); 
				vo.setCreatetime(new Date()); 
				waystoreinfo.doCreate(vo);
			}else{
				vo.setArea(Double.parseDouble(items[1]));
				vo.setZqtype(Short.parseShort(items[2]));
				vo.setZqarea(Double.parseDouble(items[3]));
				vo.setZqpanel(Short.parseShort(items[4]));
				vo.setZqcupboard(Short.parseShort(items[5]));
				vo.setZqcards(Short.parseShort(items[6]));
				vo.setZqpricetag(Short.parseShort(items[7]));
				vo.setZqrack(Short.parseShort(items[8]));
				vo.setZqinad(Short.parseShort(items[9]));
				vo.setZqoutad(Short.parseShort(items[10]));
				vo.setZqhead(Short.parseShort(items[11]));
				vo.setZqpaste(Short.parseShort(items[12]));
				vo.setZqtablecard(Short.parseShort(items[13]));
				vo.setZqdecca(Short.parseShort(items[14]));
				vo.setZqbill(Short.parseShort(items[15]));
				vo.setDoortype(Short.parseShort(items[16]));
				vo.setOutwallad(Double.parseDouble(items[17]));
				vo.setOutwallpic(Short.parseShort(items[18]));
				vo.setTdmonopoly(Short.parseShort(items[19]));
				vo.setBusimonopoly(Short.parseShort(items[20]));
				vo.setStoreconduct(Short.parseShort(items[21]));
				vo.setModulus(Float.parseFloat(items[22])); 
				waystoreinfo.doUpdate(vo);
			}
			 
 			line = rowCount + "|" + items[0] + "|" + items[1]+ "|"+ "|"+"操作成功"+"|";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) { 
			line = rowCount + "   " + line + "|处理信息:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	} 
}

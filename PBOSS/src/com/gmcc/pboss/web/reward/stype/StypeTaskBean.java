package com.gmcc.pboss.web.reward.stype;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.reward.ltype.LtypeDBParam;
import com.gmcc.pboss.business.reward.ltype.LtypeVO;
import com.gmcc.pboss.business.reward.stype.StypeDBParam;
import com.gmcc.pboss.business.reward.stype.StypeVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.reward.ltype.Ltype;
import com.gmcc.pboss.control.reward.ltype.LtypeBO;
import com.gmcc.pboss.control.reward.stype.Stype;
import com.gmcc.pboss.control.reward.stype.StypeBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class StypeTaskBean extends BaseBatchTaskBean{
	public StypeTaskBean() throws Exception {
		super.setBatchName("地市公司基础资料管理导入"); 
		super.setOprtype("导入");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "业务类型|酬金大类|酬金小类|  \r\n";
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
 		ResultVO resultVO = new ResultVO();
		try {
			String content[] = StringUtils.splitPreserveAllTokens(line, "|");
			Stype stype = (Stype) BOFactory.build(StypeBO.class, user);
			Ltype ltype = (Ltype) BOFactory.build(LtypeBO.class, user);
			
			String cityname = Code2NameUtils.code2Name("CITYNAME", user.getCityid(),user.getCityid());
			String tempLtype = content[1].substring(0,2).trim(); 
			String tempStype = content[2].substring(0,2).trim(); 
			if(!tempLtype.equals(cityname)){
				content[1] = cityname+content[1];//业务大类增加地市前缀，插入
			}
			if(!tempStype.equals(cityname)){
				content[2] = cityname+content[2];//新增业务小类增加地市前缀（比如广州地市的“30元流量卡酬金”，入库STYPE“广州30元流量卡酬金”），
			}
			
			// 业务类型属于“个人业务”，查询酬金大类表（CH_CW_ LTYPE）
			//对应该地市归属CITYID对应的酬金大类是否达到5个，如果达到5个，
			//则保存失败，提示“个人业务地市个性化酬金大类不能超过五个”；
			//LtypeVO vo = null;
			if("个人业务".equals(content[0].trim())){
			    LtypeDBParam params = new LtypeDBParam();
			    //params.set_se_optype(content[0].trim());
			    params.set_se_ltype(content[1].trim());
			    params.set_se_cityid(user.getCityid());
			    DataPackage dp = ltype.doQuery(params);
			    if(dp !=null){
				    if(dp.getDatas().size() >= 5){
					    throw new Exception("个人业务地市个性化酬金大类不能超过五个");
				    }
			    }
			}
			
			//判断是否存在相同的小类
			StypeDBParam stypeparams = new StypeDBParam();
			stypeparams.set_se_stype(content[2].trim());
			stypeparams.set_se_cityid(user.getCityid());
			DataPackage stypedp = stype.doQuery(stypeparams);
			if(stypedp.getDatas().size() > 0){
				StypeVO svo = (StypeVO) stypedp.getDatas().get(0);
				if(svo.getCityid().equals("GD") || svo.getCityid().equals(user.getCityid())){
				    throw new Exception("【" + content[2].trim() + "】已存在该酬金小类");
				}
			}
			
			//判断是否存在相同的大类
			LtypeDBParam ltypeparams = new LtypeDBParam();
			ltypeparams.set_se_optype(content[0].trim());
			ltypeparams.set_se_ltype(content[1].trim());
			ltypeparams.set_se_cityid(user.getCityid());
			DataPackage Ltypedp = ltype.doQuery(ltypeparams);
			//LtypeVO LtypeparamsVo = null;
			if(Ltypedp.getDatas().size() == 0){
				//酬金大类不存在酬金大类表中或者归属其他地市，则插入一条记录到酬金大类表
				LtypeVO ltypeVO = new LtypeVO();
				ltypeVO.setOptype(content[0].trim());
				ltypeVO.setLtype(content[1].trim());
				ltypeVO.setCityid(user.getCityid());
				ltypeVO = ltype.doCreate(ltypeVO);
				//BeanUtils.copyProperties(getForm(), ltypeVO);
			}
			if(stypedp.getDatas().size() == 0){
			    StypeVO stypeVO = new StypeVO();
			    stypeVO.setLtype(content[1].trim());
			    stypeVO.setStype(content[2].trim());
			    stypeVO.setCityid(user.getCityid());
			    stypeVO = stype.doCreate(stypeVO);
			}else{
				throw new Exception("【" + content[2].trim() + "】已存在该酬金小类");
			}
			
			line = rowCount + "|"+line+"|" + "导入成功" + "|";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) {
			line = rowCount + "|" + line + "|" + "出错原因:" + e.getMessage() + "|";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}

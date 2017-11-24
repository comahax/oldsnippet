package com.gmcc.pboss.web.resource.comressmp;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.comrescard.ComrescardVO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.business.resource.emptysim.EmptysimDBParam;
import com.gmcc.pboss.business.resource.emptysim.EmptysimVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.comrescard.Comrescard;
import com.gmcc.pboss.control.resource.comrescard.ComrescardBO;
import com.gmcc.pboss.control.resource.comressmp.Comressmp;
import com.gmcc.pboss.control.resource.comressmp.ComressmpBO;
import com.gmcc.pboss.control.resource.emptysim.Emptysim;
import com.gmcc.pboss.control.resource.emptysim.EmptysimBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class RescallbackTaskBean extends BaseBatchTaskBean{
	
	public RescallbackTaskBean() throws Exception {
		super.setBatchName("资源回收");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub
		ResultVO resultVO = new ResultVO();
		try{
			String rescallback=(String)this.parameterMap.get("callbacktype");
			//商品资源编号|商品标识
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			String codeName = "";
			if("COMRESSMP".equals(rescallback)){ //套卡
				Comressmp csmp = (Comressmp)BOFactory.build(ComressmpBO.class, user);
				Serializable pkVO=new ComressmpVO();
				BeanUtils.setProperty(pkVO, "comid", items[1]);//商品标识
				BeanUtils.setProperty(pkVO, "comresid", items[0]);//商品资源编号
				ComressmpVO csvo = csmp.doFindByPk(pkVO);
				if(csvo == null)
					throw new Exception("套卡数据不存在");
				codeName = Code2NameUtils.code2Name("$FX_COMSTATE",  csvo.getComstate().toString() , user.getCityid());
				String batchno = csvo.getBatchno();
				String boxnum = csvo.getBoxnum();
				if(csvo.getComstate()!=1 && csvo.getComstate()!=30)
					throw new Exception("商品状态错误，只有可售或待分配才允许回收，当前商品状态为"+codeName);
				csmp.doRemoveByVO(csvo);
				
				Compack bo = (Compack) BOFactory.build(CompackBO.class, user);
				Serializable pkVO2 =new CompackVO();
				BeanUtils.setProperty(pkVO2, "batchno", batchno);//商品批次
				BeanUtils.setProperty(pkVO2, "boxnum", boxnum);//包号
				CompackVO compackVO=bo.doFindByPk(pkVO2);
				if(compackVO!=null){
					if(compackVO.getAmount()-1>0){
						compackVO.setAmount((short)(compackVO.getAmount()-1));
						bo.doUpdate(compackVO);
					}else{
						bo.doRemoveByVO(compackVO);
					}
				}
			}else if("EMPTYSIM".equals(rescallback)){  //空白SIM卡
				Emptysim emptySimBO = (Emptysim)BOFactory.build(EmptysimBO.class, user);
				//根据空白卡序列号和商品标识查询空白卡资源表（IM_FX_EMPTYSIM）
				EmptysimDBParam emptysimDBParam = new EmptysimDBParam();
				emptysimDBParam.set_ne_emptyno(Long.parseLong(items[0]));
				emptysimDBParam.set_ne_comid(Long.parseLong(items[1])); 
				DataPackage dp = emptySimBO.doQuery(emptysimDBParam);
				EmptysimVO  vo = null;
				if(dp.getDatas().size()==0){
					throw new Exception("空白卡数据不存在");
				}else {
					//对查询结果的状态进行判断，如果不是“可售--1”或“待分配--30”状态，填写出错原因“空白卡状态不正确”
				    vo = (EmptysimVO) dp.getDatas().get(0);
					codeName = Code2NameUtils.code2Name("$FX_COMSTATE",  vo.getUsestate().toString(), user.getCityid());
					if(vo.getUsestate()!=1 && vo.getUsestate()!=30) 
						throw new Exception("商品状态错误，只有可售或待分配才允许回收，当前商品状态为"+codeName);  
					emptySimBO.doRemoveByPK(vo.getEmptyno());
				}
			}else{   //充值卡
				Comrescard csd = (Comrescard)BOFactory.build(ComrescardBO.class, user);
				Serializable pkVO=new ComrescardVO();
				BeanUtils.setProperty(pkVO, "comid", items[1]);//商品标识
				BeanUtils.setProperty(pkVO, "comresid", items[0]);//商品资源编号
				ComrescardVO csdvo = csd.doFindByPk(pkVO);
				if(csdvo == null)
					throw new Exception("充值卡数据不存在");
				codeName = Code2NameUtils.code2Name("$FX_COMSTATE",  csdvo.getComstate().toString() , user.getCityid());
				if(csdvo.getComstate()!=1 && csdvo.getComstate()!=30)
					throw new Exception("商品状态错误，只有可售或待分配才允许回收，当前商品状态为"+codeName);
				csd.doRemoveByVO(csdvo);
			}
			line = rowCount + "   " + line + "    成功";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		}catch(Exception e){
			line = rowCount + "   " + line + "    错误信息:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
			return resultVO;
	}

}

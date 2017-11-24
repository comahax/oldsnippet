package com.sunrise.boss.ui.cms.reward.busitocom;

import java.util.List;

import com.sunrise.boss.business.cms.operation.persistent.OperationListVO;
import com.sunrise.boss.business.cms.reward.busitocom.persistent.BusitocomListVO;
import com.sunrise.boss.business.cms.reward.busitocom.persistent.BusitocomVO;
import com.sunrise.boss.business.resmanage.com.persistent.ComListVO;
import com.sunrise.boss.business.resmanage.com.persistent.ComVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.reward.busitocom.BusitocomDelegate;
import com.sunrise.boss.delegate.cms.zjty.zjtyrewardcoef.ZjtyRewardcoefDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class BusitocomTaskBean extends BaseBatchTaskBean {

	private ZjtyRewardcoefDelegate delegate;

	public BusitocomTaskBean() throws Exception {
		// TODO Auto-generated constructor stub
		delegate = new ZjtyRewardcoefDelegate();
		super.setBatchName("业务与商品资源关联导入日志查询");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "业务与商品资源关联批量导入结果 \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String[] content = StringSplit.split(line, "|");

		try {
			
			if (content.length == 5) {

				BusitocomVO createvo = new BusitocomVO();
				BusitocomDelegate delegate = new BusitocomDelegate();
				
				CommonDelegate comDele = new CommonDelegate(ComVO.class);
				ComListVO comListVO = new ComListVO();
				comListVO.set_ne_comid(content[0]);
				DataPackage comDp = comDele.doQuery(comListVO, user);
				if(comDp.getDatas().size()==0){
					line = rowCount + "   " + line + "    错误信息:" + "商品标识" + content[0] + "不存在!";
					resultVO.setInfo(line);
					resultVO.setOk(false);
					return resultVO;
				}
				
				OperationDelegate operDele = new OperationDelegate();
				OperationListVO operListVO = new OperationListVO();
				operListVO.set_se_opnid(content[1]);
				operListVO.set_ne_isbusi("1");
				if(operDele.doQuery(operListVO, user).getDatas().size()==0){
					line = rowCount + "   " + line + "    错误信息:" + "业务编码" + content[1] + "不存在!";
					resultVO.setInfo(line);
					resultVO.setOk(false);
					return resultVO;
				}
				
				ComVO comvo = (ComVO) ((List) comDp.getDatas()).get(0);
				if(Long.parseLong(content[2])*100 <= comvo.getComprice().longValue() &&
						comvo.getComprice().longValue() <= (Long.parseLong(content[3])*100)){
					
				}else{
					line = rowCount + "   " + line + "    错误信息:" + "商品标识["+content[0]+"]的商品价格["+comvo.getComprice().longValue()+"]必须在导入的区间内!";
					resultVO.setInfo(line);
					resultVO.setOk(false);
					return resultVO;
				}
				
				BusitocomListVO listvo = new BusitocomListVO();
				listvo.set_ne_comid(comvo.getComid().toString());
				DataPackage dp = delegate.doQuery(listvo, user);
				if(dp.getDatas() != null && dp.getDatas().size() != 0){
					line = rowCount + "   " + line + "    错误信息:" + "商品标识["+content[0]+"]只能对应一个对应一个业务编码!";
					resultVO.setInfo(line);
					resultVO.setOk(false);
					return resultVO;
				}
				
				createvo.setComid(new Long(content[0]));
				createvo.setOpnid(content[1]);
				createvo.setPricelow(Long.parseLong(content[2])*100);
				createvo.setPricetop(Long.parseLong(content[3])*100);
				createvo.setBusitype(content[4]);
				createvo.setCityid(comvo.getCityid());
				createvo.setComclassid(new Integer(comvo.getComclassid().intValue()));
				createvo.setComtype(new Integer(comvo.getComtype().intValue()));
				createvo.setComresid("0");
				
					delegate.doCreate(createvo, user);
					line = rowCount + "   " + line + "    新增成功!";
					resultVO.setInfo(line);
					resultVO.setOk(true);
			}else{
				
				CommonDelegate comDele = new CommonDelegate(ComVO.class);
				ComListVO comListVO = new ComListVO();
				comListVO.set_ne_comid(content[0]);
				DataPackage comDp = comDele.doQuery(comListVO, user);
				if(comDp.getDatas().size()==0){
					line = rowCount + "   " + line + "    错误信息:" + "商品标识" + content[0] + "不存在!";
					resultVO.setInfo(line);
					resultVO.setOk(false);
					return resultVO;
				}
				
				BusitocomVO delvo = new BusitocomVO();
				BusitocomDelegate delegate = new BusitocomDelegate();
				BusitocomListVO listvo = new BusitocomListVO();
				listvo.set_ne_comid(content[0]);
				DataPackage dp = delegate.doQuery(listvo, user);
				
				delvo = (BusitocomVO) ((List) dp.getDatas()).get(0);
				delegate.doRemove(delvo, user);
				
				line = rowCount + "   " + line + "    删除成功!";
				resultVO.setInfo(line);
				resultVO.setOk(true);
			}
			
		} catch (Exception e) {
			line = rowCount + "   " + line + "    错误信息:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}

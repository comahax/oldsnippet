package com.gmcc.pboss.web.sales.canorderinfo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.canorderinfo.CanorderinfoVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.sales.canorderinfo.Canorderinfo;
import com.gmcc.pboss.control.sales.canorderinfo.CanorderinfoBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class CanorderinfoTaskBean extends BaseBatchTaskBean {

	CanorderinfoBO canorderinfoBO = null;

	public CanorderinfoTaskBean() throws Exception {
		super.setBatchName("合作商可订购量查询");
		super.setOprtype("导入");
		super.setWriteLog(true);

		// TODO Auto-generated constructor stub

	}

	protected String doStart() {
		return "合作商编码|合作商名称|分公司|星级|品牌/充值卡|可订购量|最高库存|当前库存|出错原因|  \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub

		ResultVO resultVO = new ResultVO();
		try {
			String[] content = StringUtils.splitPreserveAllTokens(line, "|");
			canorderinfoBO = (CanorderinfoBO) BOFactory.build(
					CanorderinfoBO.class, user);

			List<CanorderinfoVO> brandList = new ArrayList<CanorderinfoVO>();
			List<CanorderinfoVO> cardList = new ArrayList<CanorderinfoVO>();
			
			String wayid = content[0];
			
			if(wayid != null && !"".equals(wayid)){
				Canorderinfo canorderinfo = (Canorderinfo) BOFactory.build(CanorderinfoBO.class,user);
				WayVO wayvo = new WayVO();//合作商信息
				
				canorderinfo.doCheckWayAndModel(user, wayvo, wayid);
				//获取套卡品牌集合			
				canorderinfo.doQueryBrand(brandList, user, wayvo);
				
				//获取充值卡订购信息
				canorderinfo.doQueryStock(cardList, user, wayvo);
				
				StringBuffer sbu = new StringBuffer("");
				if (brandList != null) {
					// 合作商编码|分公司|星级|品牌/充值卡|可订购量|出错原因|
					for (int i = 0; i < brandList.size(); i++) {
						sbu.append(
								wayvo.getWayid()
								+ "|"
								+ Code2NameUtils.code2Name("#WAYIDINFO", wayvo
								 .getWayid(), user.getCityid())
								+ "|"
								+ Code2NameUtils.code2Name("#CNTYCOMPANY",
										wayvo.getCountyid(), user.getCityid())
								+ "|"
								+ wayvo.getStarlevel()
								+ "|"
								+ brandList.get(i).getBrandName()
								+ "|"
								+ brandList.get(i).getCanorder() 
								+ "|"
								+ brandList.get(i).getMaxorder() 
								+ "|"
								+ brandList.get(i).getCurorder() 
								+ "|成功|\r\n");
					}
				}
				if (cardList != null) {
					for (int i = 0; i < cardList.size(); i++) {
						sbu
								.append(
										wayvo.getWayid()
										+ "|"
										+ Code2NameUtils.code2Name("#WAYIDINFO",
												wayvo.getWayid(), user.getCityid())
										+ "|"
										+ Code2NameUtils.code2Name(
												"#CNTYCOMPANY", wayvo
														.getCountyid(), user
														.getCityid())
										+ "|"
										+ wayvo.getStarlevel()
										+ "|"
										+ Code2NameUtils.code2Name(
												"$IM_FXCOMCATEGORY", cardList
														.get(i).getCardtype(),
												user.getCityid())
										+ "|"
										+ cardList.get(i).getCardcanorder()
										+ "|"
										+ "|"
										+ "|成功|\r\n");
					}
				}
				line = sbu.toString();
				if(line.endsWith("\r\n")){
					//最后一个回车换行去掉，因为写行时框架自动完成
					int loc = line.lastIndexOf("\r\n");
					line = line.substring(0, loc);
				}
				resultVO.setInfo(line);
				resultVO.setOk(true);
			}
		} catch (Exception e) {
			line = line + "|||||" + e.getMessage() + "|";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

}

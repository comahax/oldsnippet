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
		super.setBatchName("�����̿ɶ�������ѯ");
		super.setOprtype("����");
		super.setWriteLog(true);

		// TODO Auto-generated constructor stub

	}

	protected String doStart() {
		return "�����̱���|����������|�ֹ�˾|�Ǽ�|Ʒ��/��ֵ��|�ɶ�����|��߿��|��ǰ���|����ԭ��|  \r\n";
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
				WayVO wayvo = new WayVO();//��������Ϣ
				
				canorderinfo.doCheckWayAndModel(user, wayvo, wayid);
				//��ȡ�׿�Ʒ�Ƽ���			
				canorderinfo.doQueryBrand(brandList, user, wayvo);
				
				//��ȡ��ֵ��������Ϣ
				canorderinfo.doQueryStock(cardList, user, wayvo);
				
				StringBuffer sbu = new StringBuffer("");
				if (brandList != null) {
					// �����̱���|�ֹ�˾|�Ǽ�|Ʒ��/��ֵ��|�ɶ�����|����ԭ��|
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
								+ "|�ɹ�|\r\n");
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
										+ "|�ɹ�|\r\n");
					}
				}
				line = sbu.toString();
				if(line.endsWith("\r\n")){
					//���һ���س�����ȥ������Ϊд��ʱ����Զ����
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

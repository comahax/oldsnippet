package com.gmcc.pboss.web.sales.salesstd;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyDBParam;
import com.gmcc.pboss.business.channel.microarea.MicroareaVO;
import com.gmcc.pboss.business.channel.servcent.ServcentDBParam;
import com.gmcc.pboss.business.sales.salesstd.SalesstdDBParam;
import com.gmcc.pboss.business.sales.salesstd.SalesstdVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.channel.cntycompany.Cntycompany;
import com.gmcc.pboss.control.channel.cntycompany.CntycompanyBO;
import com.gmcc.pboss.control.channel.microarea.Microarea;
import com.gmcc.pboss.control.channel.microarea.MicroareaBO;
import com.gmcc.pboss.control.channel.servcent.ServcentBO;
import com.gmcc.pboss.control.sales.salesstd.SalesstdBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class SalesstdTaskBean extends BaseBatchTaskBean {
	public SalesstdTaskBean() throws Exception {
		super.setBatchName("������������ֵ��������");
		super.setOprtype("����");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "���|�ֹ�˾|΢����|�Ǽ�|������ֵ|����ԭ��  \r\n";
	}

	/**
	 * ����һ����¼
	 */
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");

			Cntycompany cntycompany = (Cntycompany) BOFactory.build(
					CntycompanyBO.class, user);
			CntycompanyDBParam param = new CntycompanyDBParam();
			param.set_se_countycompid(items[0]);
			param.set_se_citycompid(user.getCityid());
			DataPackage dp = cntycompany.doQuery(param);
			if (dp.getRowCount() == 0) {
				throw new Exception("�ֹ�˾��Ϣ������");
			}
			
			
			Microarea delegate = (Microarea)BOFactory.build(MicroareaBO.class, user);
			MicroareaVO microareaVO = delegate.doFindByPk(items[1]);
			ServcentBO servcentBO = (ServcentBO) BOFactory.build(
					ServcentBO.class, user);
			
			if (microareaVO == null) {
				throw new Exception("΢������Ϣ������");
			}else{
				ServcentDBParam servcentDBParam = new ServcentDBParam();
				servcentDBParam.set_se_countyid(items[0]);
				servcentDBParam.set_se_svccode(microareaVO.getSvccode());
			
				DataPackage dpp = servcentBO.doQuery(servcentDBParam);
				if(dpp == null || dpp.getDatas() == null || dpp.getDatas().size()==0){
					throw new Exception("΢������Ϣ������");					
				}				
			}

			Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class,
					user);
			DictitemDBParam param2 = new DictitemDBParam();
			param2.set_se_groupid("CH_STARLEVEL");
			param2.set_se_dictid(items[2]);
			DataPackage dp2 = dictitem.doQuery(param2);
			if (dp2.getRowCount() == 0) {
				throw new Exception("�����Ǽ�������");
			} 
			
			
			//���֮ǰ��ѯ�Ƿ����ظ���,����Ѿ��������ݣ�����ʾ����ͬ��¼�Ѿ����ڣ����顣�������ء�
			SalesstdDBParam salesstddbparam = new SalesstdDBParam();
			salesstddbparam.set_se_cityid(user.getCityid());
			salesstddbparam.set_se_countyid(items[0]);
			salesstddbparam.set_se_mareacode(items[1]);
			salesstddbparam.set_ne_starlevel(items[2]);
			 
			
			
			SalesstdVO salesstdvo = new SalesstdVO();
			salesstdvo.setCityid(user.getCityid());
			salesstdvo.setCountyid(items[0]);
			salesstdvo.setMareacode(items[1]);
			salesstdvo.setStarlevel(Short.parseShort(items[2])); 
			salesstdvo.setSalesstd(Long.parseLong(items[3]));
			
			SalesstdBO salesstdbo = (SalesstdBO)BOFactory.build(SalesstdBO.class, user);
			DataPackage dpp = salesstdbo.doQuery(salesstddbparam);
			if(dpp.getDatas()!=null&&dpp.getDatas().size()>0){
				salesstdvo.setRecid(((SalesstdVO)dpp.getDatas().get(0)).getRecid());
				salesstdbo.doUpdate(salesstdvo);
			}else{
				salesstdbo.doCreate(salesstdvo);
			}
			line = rowCount + "   " + line + "    �ɹ�";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) {
			line = rowCount + "   " + line + "    ������Ϣ:" + e.getMessage();
			e.printStackTrace();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}

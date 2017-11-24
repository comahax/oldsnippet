package com.gmcc.pboss.web.sales.comdisscale;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyDBParam;
import com.gmcc.pboss.business.channel.microarea.MicroareaVO;
import com.gmcc.pboss.business.channel.servcent.ServcentDBParam;
import com.gmcc.pboss.business.sales.comdisscale.ComdisscaleVO;
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
import com.gmcc.pboss.control.sales.comdisscale.Comdisscale;
import com.gmcc.pboss.control.sales.comdisscale.ComdisscaleBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class ComdisscaleTaskBean extends BaseBatchTaskBean{
	public ComdisscaleTaskBean() throws Exception {
		super.setBatchName("��Ʒ���������������");
		super.setOprtype("����");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "���|�ֹ�˾|΢����|�Ǽ�|�׿�Ʒ��|��Ʒ����|�������|����ԭ��  \r\n";
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
			param2.set_se_groupid("FX_SMPBRAND");
			param2.set_se_dictid(items[3]);
			
			dp2 = dictitem.doQuery(param2);
			if (dp2.getRowCount() == 0||items[3].equals("AllBrand")) {
				throw new Exception("�׿�Ʒ�Ʋ�����");
			}
//
//			��Ʒ�����飺��ѯ�����ֵ��SA_DB_DICTITEM����ƥ������飨GROUPID=IM_FXCOMCATEGORY����
//			���루DICTID��Ϊ��Ӧ�׿�Ʒ���Ҳ�������CZ����������������¼����ԭ��Ϊ����Ʒ�������ݲ���ȷ�������ش���һ������¼��
			param2.set_se_groupid("IM_FXCOMCATEGORY");
			param2.set_sne_dictid("%CZ");
			param2.set_se_dictid(items[4]);
			dp2 = dictitem.doQuery(param2);
			if (dp2.getRowCount() == 0) {
				throw new Exception("��Ʒ���಻����");
			}
			
			ComdisscaleVO vo = new ComdisscaleVO();
			vo.setCountyid(items[0]);
			vo.setMareacode(items[1]);
			vo.setStarlevel(Short.parseShort(items[2]));
			vo.setBrand(items[3]);
			vo.setComcategory(items[4]);
			vo.setDisscale(Double.parseDouble(items[5]));			
			Comdisscale cds = (Comdisscale)BOFactory.build(ComdisscaleBO.class, user);
			

//			��Ʒ����Ʒ�ƶ�Ӧ��ϵ��飺�����׿�Ʒ�ƺ���Ʒ�����ѯ��Ʒ����Ʒ�ƶ�Ӧ��ϵ��(IM_PR_COMCATEBRAND)��
//			�������������ʾ����Ʒ������׿�Ʒ�ƶ�Ӧ��ϵ�������顣�������أ����������
			boolean bbo = cds.checkRale(vo);			 
			if(bbo == false){
				throw new Exception("��Ʒ������׿�Ʒ�ƶ�Ӧ��ϵ�������顣");				
			}
			
			
//			Ʒ�Ʊ�����飺���ݷֹ�˾��΢�����Ǽ���Ʒ�ƶ���Ʒ����������ñ� (FX_RU_COMDISSCALE)���в�ѯ������ѯ����ķ���������кϼƣ�
//			����ϼ�ֵ�ӵ�ǰֵ����1������ʾ����Ʒ�Ƹ���Ʒ����������֮�ʹ���1�����顣�������ء�
			if(!cds.checkDisscale(vo)){
				throw new Exception("��Ʒ�Ƹ���Ʒ����������֮�ʹ���1�����顣");
			}			

			
//			ΨһԼ����飬���ݷֹ�˾��΢�����Ǽ����׿�Ʒ�ơ���Ʒ�������Ʒ����������ñ� (FX_RU_COMDISSCALE)���в�ѯ��
//			����Ѿ��������ݣ�����ʾ����ͬ��¼�Ѿ����ڣ����顣�������ء�
			DataPackage dpp = cds.isExistb(vo);
			if(dpp != null && dpp.getDatas() != null && dpp.getDatas().size()>0){
				vo.setRecid(((ComdisscaleVO)dpp.getDatas().get(0)).getRecid());
				cds.doUpdate(vo);	
			}
			else{
				cds.doCreate(vo);
			}
			line = rowCount + "   " + line + "    �ɹ�";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) {
			line = rowCount + "   " + line + "    ������Ϣ:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}

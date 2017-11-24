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
		super.setBatchName("商品分配比例批量导入");
		super.setOprtype("导入");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "序号|分公司|微区域|星级|套卡品牌|商品种类|分配比例|出错原因  \r\n";
	}

	/**
	 * 处理一条记录
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
				throw new Exception("分公司信息不存在");
			}
			

			
			Microarea delegate = (Microarea)BOFactory.build(MicroareaBO.class, user);
			MicroareaVO microareaVO = delegate.doFindByPk(items[1]);
			ServcentBO servcentBO = (ServcentBO) BOFactory.build(
					ServcentBO.class, user);
			
			if (microareaVO == null) {
				throw new Exception("微区域信息不存在");
			}else{
				ServcentDBParam servcentDBParam = new ServcentDBParam();
				servcentDBParam.set_se_countyid(items[0]);
				servcentDBParam.set_se_svccode(microareaVO.getSvccode());
			
				DataPackage dpp = servcentBO.doQuery(servcentDBParam);
				if(dpp == null || dpp.getDatas() == null || dpp.getDatas().size()==0){
					throw new Exception("微区域信息不存在");					
				}				
			}
			
			

			Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class,
					user);
			DictitemDBParam param2 = new DictitemDBParam();
			param2.set_se_groupid("CH_STARLEVEL");
			param2.set_se_dictid(items[2]);
			DataPackage dp2 = dictitem.doQuery(param2);
			if (dp2.getRowCount() == 0) {
				throw new Exception("渠道星级不存在");
			}
			param2.set_se_groupid("FX_SMPBRAND");
			param2.set_se_dictid(items[3]);
			
			dp2 = dictitem.doQuery(param2);
			if (dp2.getRowCount() == 0||items[3].equals("AllBrand")) {
				throw new Exception("套卡品牌不存在");
			}
//
//			商品种类检查：查询代码字典表（SA_DB_DICTITEM），匹配代码组（GROUPID=IM_FXCOMCATEGORY）、
//			编码（DICTID）为对应套卡品牌且不包含“CZ”，如果无数据则记录出错原因为“商品种类数据不正确”，返回处理一下条记录；
			param2.set_se_groupid("IM_FXCOMCATEGORY");
			param2.set_sne_dictid("%CZ");
			param2.set_se_dictid(items[4]);
			dp2 = dictitem.doQuery(param2);
			if (dp2.getRowCount() == 0) {
				throw new Exception("商品种类不存在");
			}
			
			ComdisscaleVO vo = new ComdisscaleVO();
			vo.setCountyid(items[0]);
			vo.setMareacode(items[1]);
			vo.setStarlevel(Short.parseShort(items[2]));
			vo.setBrand(items[3]);
			vo.setComcategory(items[4]);
			vo.setDisscale(Double.parseDouble(items[5]));			
			Comdisscale cds = (Comdisscale)BOFactory.build(ComdisscaleBO.class, user);
			

//			商品种类品牌对应关系检查：根据套卡品牌和商品种类查询商品种类品牌对应关系表(IM_PR_COMCATEBRAND)，
//			如果无数据则提示“商品种类和套卡品牌对应关系错误，请检查。”并返回；否则继续。
			boolean bbo = cds.checkRale(vo);			 
			if(bbo == false){
				throw new Exception("商品种类和套卡品牌对应关系错误，请检查。");				
			}
			
			
//			品牌比例检查：根据分公司、微区域、星级、品牌对商品分配比例设置表 (FX_RU_COMDISSCALE)进行查询，将查询结果的分配比例进行合计，
//			如果合计值加当前值大于1，则提示“该品牌各商品种类分配比例之和大于1，请检查。”并返回。
			if(!cds.checkDisscale(vo)){
				throw new Exception("该品牌各商品种类分配比例之和大于1，请检查。");
			}			

			
//			唯一约束检查，根据分公司、微区域、星级、套卡品牌、商品种类对商品分配比例设置表 (FX_RU_COMDISSCALE)进行查询，
//			如果已经存在数据，则提示“相同记录已经存在，请检查。”并返回。
			DataPackage dpp = cds.isExistb(vo);
			if(dpp != null && dpp.getDatas() != null && dpp.getDatas().size()>0){
				vo.setRecid(((ComdisscaleVO)dpp.getDatas().get(0)).getRecid());
				cds.doUpdate(vo);	
			}
			else{
				cds.doCreate(vo);
			}
			line = rowCount + "   " + line + "    成功";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) {
			line = rowCount + "   " + line + "    错误信息:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}

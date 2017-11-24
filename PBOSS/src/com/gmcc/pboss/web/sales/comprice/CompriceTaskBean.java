package com.gmcc.pboss.web.sales.comprice;

import org.apache.commons.lang.StringUtils; 
import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.channel.custwaytype.Custwaytype;
import com.gmcc.pboss.control.channel.custwaytype.CustwaytypeBO;
import com.gmcc.pboss.control.sales.comprice.CompriceBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class CompriceTaskBean extends BaseBatchTaskBean {

	CompriceBO compriceBo = null;

	public CompriceTaskBean() throws Exception {
		super.setBatchName("商品销售价格批量导入");
		super.setOprtype("导入");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub

	}

	protected String doStart() {
		return "行号|市公司|分公司|星级|合作类型|商品种类|售价区分方式|价格(元)|价格(元)|  \r\n";
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub
		// String loginwayid = user.getWayid();
		ResultVO resultVO = new ResultVO();
		try {
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			compriceBo = (CompriceBO) BOFactory.build(CompriceBO.class, user);
			compriceBo.doCompriceImport(items);
			
			//得到合作类型
			Custwaytype custwaytype = (Custwaytype) BOFactory.build(CustwaytypeBO.class,user);
			CustwaytypeVO custwaytypeVO = new CustwaytypeVO();
			custwaytypeVO.setCitycompid(user.getCityid());
			custwaytypeVO.setCustwaytypecode(items[2]);
			CustwaytypeVO custwaytypeVO2 = custwaytype.doFindByPk(custwaytypeVO);
			
	
			
			line = rowCount
					+ "|"
					+ Code2NameUtils.code2Name("#CITYCOMPANY",user.getCityid(), user.getCityid())
					+ "|"
					+ Code2NameUtils.code2Name("#CNTYCOMPANY", items[0], user.getCityid())
					+ "|"
					+ Code2NameUtils.code2Name("$CH_STARLEVEL2", items[1], user.getCityid())
					+ "|"
					+  custwaytypeVO2.getCustwaytypename()
					+ "|"
					+ Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", items[3],user.getCityid())
					+ "|"
					+ Code2NameUtils.code2Name("$FX_PRICEDIFTYPE", items[4],
							user.getCityid()) + "|" + items[5] + "|" + items[6]
					+ "|";
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

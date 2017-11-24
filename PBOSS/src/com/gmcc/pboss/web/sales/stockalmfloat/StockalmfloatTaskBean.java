package com.gmcc.pboss.web.sales.stockalmfloat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.sales.stockalarm.StockalarmDBParam;
import com.gmcc.pboss.business.sales.stockalarm.StockalarmVO;
import com.gmcc.pboss.business.sales.stockalmfloat.StockalmfloatDBParam;
import com.gmcc.pboss.business.sales.stockalmfloat.StockalmfloatVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.stockalarm.Stockalarm;
import com.gmcc.pboss.control.sales.stockalarm.StockalarmBO;
import com.gmcc.pboss.control.sales.stockalmfloat.Stockalmfloat;
import com.gmcc.pboss.control.sales.stockalmfloat.StockalmfloatBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class StockalmfloatTaskBean extends BaseBatchTaskBean {

	public StockalmfloatTaskBean() throws Exception {
		super.setBatchName("�׿����Ԥ������������������");
		super.setOprtype("����");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "�к�|�Ǽ�|�׿�Ʒ��|��߿��ϵ��|������ϵ��|��ɫԤ��ϵ��|��ɫԤ��ϵ��|����ԭ��| \r\n";
	}

	/**
	 * ����һ����¼
	 */
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			Stockalmfloat fxrustockalmfloat = (Stockalmfloat) BOFactory.build(
					StockalmfloatBO.class, user);
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");

			Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class,
					user);
			DictitemDBParam param2 = new DictitemDBParam();
			param2.set_se_groupid("CH_STARLEVEL");
			param2.set_se_dictid(items[0]);
			DataPackage dp2 = dictitem.doQuery(param2);
			if (dp2.getRowCount() == 0) {
				throw new Exception("�����Ǽ�������");
			}

			param2.set_se_groupid("FX_SMPBRAND");
			param2.set_se_dictid(null);
			dp2 = dictitem.doQuery(param2);
			List<DictitemVO> dictitemList = dp2.getDatas();
			if (dictitemList.size() > 0) {
				Set<String> brandSet = new HashSet<String>();
				for (DictitemVO dictitemVO : dictitemList) {
					String brand = dictitemVO.getDictid();
					if (null != brand && !brand.equals("AllBrand")) {
						brandSet.add(dictitemVO.getDictid());
					}

				}
				if (!brandSet.contains(items[1])) {
					throw new Exception("�׿�Ʒ�Ʋ�����");
				}
			} else {
				throw new Exception("�׿�Ʒ�Ʋ�����");
			}

			StockalmfloatVO fxrustockalmfloatVO = new StockalmfloatVO();
			fxrustockalmfloatVO.setStarlevel(Short.parseShort(items[0]));
			fxrustockalmfloatVO.setBrand(items[1]);
			fxrustockalmfloatVO.setMaxstockquotiety(Double.valueOf(items[2]));
			fxrustockalmfloatVO.setActquotiety(Double.valueOf(items[3]));
			fxrustockalmfloatVO.setRedquotiety(Double.valueOf(items[4]));
			fxrustockalmfloatVO.setYellowquotiety(Double.valueOf(items[5]));

			StockalmfloatDBParam fxrustockalmfloatDBParam = new StockalmfloatDBParam();
			fxrustockalmfloatDBParam.set_ne_starlevel(fxrustockalmfloatVO
					.getStarlevel().toString());
			fxrustockalmfloatDBParam.set_se_brand(fxrustockalmfloatVO
					.getBrand());
			DataPackage dp = fxrustockalmfloat
					.doQuery(fxrustockalmfloatDBParam);

			if (dp != null && dp.getRowCount() == 0) {
				fxrustockalmfloat.doCreate(fxrustockalmfloatVO);
			} else {
				fxrustockalmfloatVO.setRecid(((StockalmfloatVO) dp.getDatas()
						.get(0)).getRecid());
				fxrustockalmfloat.doUpdate(fxrustockalmfloatVO);
			}

			line = rowCount
					+ "|"
					+ Code2NameUtils.code2Name("$CH_STARLEVEL",
							fxrustockalmfloatVO.getBrand(), user.getCityid())
					+ "|"
					+ Code2NameUtils.code2Name("$FX_SMPBRAND",
							fxrustockalmfloatVO.getBrand(), user.getCityid())
					+ "|" + fxrustockalmfloatVO.getMaxstockquotiety() + "|"
					+ fxrustockalmfloatVO.getActquotiety() + "|"
					+ fxrustockalmfloatVO.getRedquotiety() + "|"
					+ fxrustockalmfloatVO.getYellowquotiety() + "|" + "    �ɹ�";
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
package com.gmcc.pboss.web.sales.orderuplimit;

import org.apache.commons.lang.StringUtils;
import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyDBParam;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitDBParam;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.channel.cntycompany.Cntycompany;
import com.gmcc.pboss.control.channel.cntycompany.CntycompanyBO;
import com.gmcc.pboss.control.sales.orderuplimit.Orderuplimit;
import com.gmcc.pboss.control.sales.orderuplimit.OrderuplimitBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class OrderuplimitTaskBean extends BaseBatchTaskBean {

	public OrderuplimitTaskBean() throws Exception {
		super.setBatchName("空白SIM卡库存预警设置批量导入");
		super.setOprtype("导入");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "空白SIM卡库存预警设置批量导入结果  \r\n";
	}

	/**
	 * 处理一条记录
	 */
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			Orderuplimit orderuplimit = (Orderuplimit) BOFactory.build(OrderuplimitBO.class, user);
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			
			Cntycompany cntycompany = (Cntycompany)BOFactory.build(CntycompanyBO.class, user);
			CntycompanyDBParam param = new CntycompanyDBParam();
			param.set_se_countycompid(items[0]);
			param.set_se_citycompid(user.getCityid());
			DataPackage dp = cntycompany.doQuery(param);
			if (dp.getRowCount() == 0) {
				throw new Exception("分公司信息不存在");
			}
			
			Dictitem dictitem = (Dictitem)BOFactory.build(DictitemBO.class, user);
			DictitemDBParam param2 = new DictitemDBParam();
			param2.set_se_groupid("CH_STARLEVEL");
			param2.set_se_dictid(items[1]);
			DataPackage dp2 = dictitem.doQuery(param2);
			if (dp2.getRowCount() == 0) {
				throw new Exception("渠道星级不存在");
			}
			
			// 大于零的整数，最大长度10位。
			try {
				Long.valueOf(items[3]);
				if (items[3].length() > 10) {
					throw new Exception("最高库存数据长度错误");
				}
			} catch (Exception e) {
				throw new Exception("最高库存数据类型错误");
			}
			// 大于零的整数，最大长度10位。
			try {
				Long.valueOf(items[4]);
				if (items[4].length() > 10) {
					throw new Exception("红色预警数据长度错误");
				}
			} catch (Exception e) {
				throw new Exception("红色预警数据类型错误");
			}
			// 大于零的整数，最大长度10位。
			try {
				Long.valueOf(items[5]);
				if (items[5].length() > 10) {
					throw new Exception("黄色预警数据长度错误");
				}
			} catch (Exception e) {
				throw new Exception("黄色预警数据类型错误");
			}
			
			OrderuplimitVO orderuplimitVO = new OrderuplimitVO();
			orderuplimitVO.setCityid(user.getCityid());
			orderuplimitVO.setCountyid(items[0]);
			orderuplimitVO.setStarlevel(Short.valueOf(items[1]));
			orderuplimitVO.setComcategory(items[2]);
			orderuplimitVO.setMaxstock(Long.valueOf(items[3]));
			orderuplimitVO.setAlarmvalue("REDALARM:" + items[4] + ";YELALARM:" + items[5]);
			orderuplimitVO.setLimitmode("STOCKALARM");
			orderuplimitVO.setRestype("EMPTYSIM");
			
			OrderuplimitDBParam param3 = new OrderuplimitDBParam();
			param3.set_se_cityid(user.getCityid());
			param3.set_se_countyid(items[0]);
			param3.set_ne_starlevel(items[1]);
			param3.set_se_comcategory(items[2]);
			param3.set_se_limitmode("STOCKALARM");
			param3.set_se_restype("EMPTYSIM");
			DataPackage dp3 = orderuplimit.doQuery(param3);
			if (dp3.getRowCount() == 0) {
				orderuplimit.doCreate(orderuplimitVO);
			} else {
				OrderuplimitVO vo = (OrderuplimitVO) dp3.getDatas().get(0);
				BeanUtils.copyProperties(vo, orderuplimitVO);
				orderuplimit.doUpdate(vo);
			}
			line = rowCount + "   " + line + "    成功";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) {
			line = rowCount + "   " + line + "    错误信息:" + e.getMessage();
			e.printStackTrace();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
package com.gmcc.pboss.web.channel.wayrechargeno;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.channel.nosect.NosectDBParam;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.wayrechargeno.WayrechargenoDBParam;
import com.gmcc.pboss.business.channel.wayrechargeno.WayrechargenoVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.nosect.Nosect;
import com.gmcc.pboss.control.channel.nosect.NosectBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.wayrechargeno.Wayrechargeno;
import com.gmcc.pboss.control.channel.wayrechargeno.WayrechargenoBO;
import com.gmcc.pboss.control.sales.stockalarm.Stockalarm;
import com.gmcc.pboss.control.sales.stockalarm.StockalarmBO;
import com.gmcc.pboss.control.sales.stockalmfloat.Stockalmfloat;
import com.gmcc.pboss.control.sales.stockalmfloat.StockalmfloatBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class WayrechargenoTaskBean extends BaseBatchTaskBean {

	public WayrechargenoTaskBean() throws Exception {
		super.setBatchName("�����ճ���뵼�������������");
		super.setOprtype("����");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "�����ճ���뵼���������������  \r\n";
	}

	/**
	 * ����һ����¼
	 */
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			Wayrechargeno wayrechargeno = (Wayrechargeno) BOFactory.build(WayrechargenoBO.class, user);
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			
			Way way = (Way)BOFactory.build(WayBO.class, user);
			WayDBParam param = new WayDBParam();
			param.set_se_wayid(items[0]);
			param.set_se_waytype("AG");
//			param.set_se_cityid(user.getCityid());
			DataPackage dp = way.doQuery(param);
			if(dp.getRowCount()==0)
			{
				throw new Exception("�������벻����");
			}
			
			Nosect control = (Nosect) BOFactory.build(NosectBO.class, user);
			NosectDBParam params=new NosectDBParam();
			params.set_snm_beginno(items[1]);
			params.set_snl_endno(items[1]);
			DataPackage dp1=control.doQuery(params);
			if(dp1.getRowCount()<=0){
				throw new Exception("�ֻ����벻�����ںŶα�");
			}
			
			WayrechargenoBO bo=(WayrechargenoBO)BOFactory.build(WayrechargenoBO.class,user);
			
			WayrechargenoDBParam param1=new WayrechargenoDBParam();
			param1.set_se_mobile(items[1]);
			param1.set_sne_wayid(items[0]);
			DataPackage dp2 = bo.doQuery(param1);
			if(dp2.getRowCount()>0){
				throw new Exception("���ֻ������Ѿ�������������������,�뻻һ�������ĺ���");
			}
			
			WayrechargenoVO wayrechargenoVO=new WayrechargenoVO();
			wayrechargenoVO.setWayid(items[0]);
			wayrechargenoVO.setMobile(items[1]);
			wayrechargenoVO.setOpercode(user.getOprcode());
			wayrechargenoVO.setOpertime(new Date());
			wayrechargenoVO.setCityid(Short.parseShort(CityMappingUtil.getCityNo(user.getCityid())));
			
			WayrechargenoDBParam wayrechargenoDBParam=new WayrechargenoDBParam();
			wayrechargenoDBParam.set_se_cityid(CityMappingUtil.getCityNo(user.getCityid()));
			wayrechargenoDBParam.set_se_mobile(items[1]);
			wayrechargenoDBParam.set_se_wayid(items[0]);
			if(wayrechargeno.doQuery(wayrechargenoDBParam).getRowCount()==0){
				wayrechargenoVO.setOpertype("I");
				wayrechargeno.doCreate(wayrechargenoVO);
			}else{
				wayrechargenoVO.setOpertype("U");
				wayrechargeno.doUpdate(wayrechargenoVO);
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
package com.sunrise.boss.web.fee.monternet.ibdatabusiinfo;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.fee.monternet.ibdatabusiinfo.persistent.IbDataBusiinfoDBParam;
import com.sunrise.boss.business.fee.monternet.ibdatabusiinfo.persistent.IbDataBusiinfoVO;
import com.sunrise.boss.common.export.ExcelCodeToName;
import com.sunrise.boss.common.export.ExportDataCreator;
import com.sunrise.boss.common.export.PageSetting;
import com.sunrise.jop.common.commoncontrol.CommonBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.i18n.Message;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class ExcelOutIbDataBusiinfo extends ExportDataCreator {

	private final static String RESPATH = "/com/sunrise/boss/web/fee/monternet/ibdatabusiinfo/IbDataBusiinfoAction_zh_CN.properties";
	
	private String[] propertys;

	public ExcelOutIbDataBusiinfo(User user) {
		super(user);
	}
	
	public ExcelOutIbDataBusiinfo(User user,String[] propertys) {
		super(user);
		this.propertys = propertys;
	}

	protected String codeToName(String propertyName, String code, User user) {
		if (StringUtils.equals(propertyName, "chargingtype")) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("UAP_CHARGING_TYPE", code, user.getDbFlag());
		}
		return code;
	}

	protected void queryPages(OutputStream os, Object queryVO, User opr)
			throws Exception {
		regformat();
		HttpServletRequest request = (HttpServletRequest) queryVO;
		IbDataBusiinfoDBParam param = (IbDataBusiinfoDBParam) request
				.getAttribute("LISTVO");
		if (null == param) {
			param = new IbDataBusiinfoDBParam();
		}

		CommonBO cb = (CommonBO) BOFactory.build(CommonBO.class, opr);
		cb.setVoClass(IbDataBusiinfoVO.class);
		param.set_pagesize("100");
		try {
			long startindex = Long.parseLong(param.getStartindex());
			long endindex = Long.parseLong(param.getEndindex());

			PageSetting.checkPageIndex(startindex, endindex,
					Long.parseLong(param.get_pagesize()));
			for (; startindex <= endindex; startindex++) {

				param.set_pageno(String.valueOf(startindex));
				DataPackage dp = null;
				try {
					String[] selectArray = param.get_selectitem();
					if(selectArray == null) {
						dp = cb.doQuery(param);
					}else{
						List<IbDataBusiinfoVO> list  = new ArrayList<IbDataBusiinfoVO>();
						for (int j = 0; j < selectArray.length; j++) {
							IbDataBusiinfoVO vo = getSelectedPkVO(selectArray[j],user);
							list.add(vo);
						}
						dp = new DataPackage();
						dp.setDatas(list);
						startindex = endindex+1;
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				if (dp != null && dp.getDatas() != null
						&& dp.toList(IbDataBusiinfoVO.class).size() > 0) {
					write(os, dp.getDatas().iterator(),
							new Class[] { IbDataBusiinfoVO.class });
				}
				if (dp != null
						&& (dp.toList(IbDataBusiinfoVO.class) == null || dp
								.toList(IbDataBusiinfoVO.class).size() < 100)) {
					break;
				}
				dp = null;

			}
			close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	protected void writeTitle() {
		this.title = new String[propertys.length];
		for (int i = 0; i < propertys.length; i++) {
			this.title[i] = Message.getString(RESPATH, propertys[i]);
		}
	}

	private void regformat() {
		for (int i = 0; i < propertys.length; i++) {
			if("billcycle,acctitemIdlv1,acctitemIdlv2".indexOf(propertys[i])!=-1){
				addOutputProperty(propertys[i], NUMBER, "#");
			}else if("chargingtype".equals(propertys[i])){
				addOutputProperty(propertys[i], CODE2NAME, "#");
			}else if("fee".equals(propertys[i])){
				addOutputProperty(propertys[i], NUMBER, "0.00");
			}else{
				addOutputProperty(propertys[i], null, null);
			}
			
		}
	}
	
	/**
	 * 复合主键，返回主键VO 
	 */
	protected IbDataBusiinfoVO getSelectedPkVO(String pkValue,User opr) throws Exception {
		String[] pkValueArray = pkValue.split("\\|");
		String[] pkNameArray= new String[]{"_ne_billcycle","_se_chargingtype","_se_filetype","_se_opCode","_se_port","_se_spCode"};
		IbDataBusiinfoDBParam param = new IbDataBusiinfoDBParam();
		for (int j = 0; j < pkValueArray.length; j++) {
			BeanUtils.setProperty(param, pkNameArray[j], pkValueArray[j]);
		}
		CommonBO cb = (CommonBO) BOFactory.build(CommonBO.class, opr);
		cb.setVoClass(IbDataBusiinfoVO.class);
		DataPackage dp = cb.doQuery(param);
		IbDataBusiinfoVO vo =(IbDataBusiinfoVO) dp.getDatas().get(0);
		return vo;
	}

}

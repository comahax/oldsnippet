package com.gmcc.pboss.common.ui;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmcc.pboss.common.ui.abstracts.PbossSelector;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.opensymphony.xwork2.util.ValueStack;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
/**
 * 
 * @author zhangsiwei
 *
 */
public class PbossSmpSelector extends PbossSelector {

	private String mode;
	
	public PbossSmpSelector(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
	}

	public String getMode() {
		return mode;
	}


	public void setMode(String mode) {
		this.mode = mode;
	}


	@Override
	public void evaluateParams() {
		// 先计算 list 属性的值，及下拉框的内容，再调用super的evaluateParams方法
		setList(buildMapList());

		super.evaluateParams();
	}


	@Override
	public Map buildMapList() {
		evaluateQueryParams();

		try {
			Map map = new LinkedHashMap();
			if("of".equalsIgnoreCase(mode)) {
				//系统开关
				Sysparam spBO = (Sysparam)BOFactory.build(SysparamBO.class, getDBAccessUser());
				String paramValue = spBO.doFindByID("12", "pboss_fx");
				if(paramValue != null && "1".equals(paramValue.trim())) {
					// 区分品牌
//					map = Code2NameUtils.valueList("$FX_SMPBRAND", "_sne_dictid:AllBrand", dbFlagValue);
					map = Code2NameUtils.valueList("$FX_SMPBRAND",dbFlagValue);
				}else {
					// 不区分品牌
//					map = Code2NameUtils.valueList("$FX_SMPBRAND", "_se_dictid:AllBrand", dbFlagValue);
					map = Code2NameUtils.valueList("$FX_SMPBRAND",dbFlagValue);
				}
			}else if("def".equalsIgnoreCase(mode)) {
				// 区分品牌
//				map = Code2NameUtils.valueList("$FX_SMPBRAND", "_sne_dictid:AllBrand", dbFlagValue);
				map = Code2NameUtils.valueList("$FX_SMPBRAND",dbFlagValue);
			}else if("all".equals(mode)) {
				// 不区分品牌
//				map = Code2NameUtils.valueList("$FX_SMPBRAND", "_se_dictid:AllBrand", dbFlagValue);
				map = Code2NameUtils.valueList("$FX_SMPBRAND",dbFlagValue);
			}
			Map newMap = new LinkedHashMap();
			if (headOption == null) {
				newMap.put(null, null); // 加一个空白项
			} else {
				newMap.put(null, headOption);// 添加一个默认的Option：如，请选择....
			}
			newMap.putAll(map);
			return newMap;
		} catch (Exception e) {
			e.printStackTrace();
			return new HashMap();
		}
	}

}

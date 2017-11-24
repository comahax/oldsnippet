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
		// �ȼ��� list ���Ե�ֵ��������������ݣ��ٵ���super��evaluateParams����
		setList(buildMapList());

		super.evaluateParams();
	}


	@Override
	public Map buildMapList() {
		evaluateQueryParams();

		try {
			Map map = new LinkedHashMap();
			if("of".equalsIgnoreCase(mode)) {
				//ϵͳ����
				Sysparam spBO = (Sysparam)BOFactory.build(SysparamBO.class, getDBAccessUser());
				String paramValue = spBO.doFindByID("12", "pboss_fx");
				if(paramValue != null && "1".equals(paramValue.trim())) {
					// ����Ʒ��
//					map = Code2NameUtils.valueList("$FX_SMPBRAND", "_sne_dictid:AllBrand", dbFlagValue);
					map = Code2NameUtils.valueList("$FX_SMPBRAND",dbFlagValue);
				}else {
					// ������Ʒ��
//					map = Code2NameUtils.valueList("$FX_SMPBRAND", "_se_dictid:AllBrand", dbFlagValue);
					map = Code2NameUtils.valueList("$FX_SMPBRAND",dbFlagValue);
				}
			}else if("def".equalsIgnoreCase(mode)) {
				// ����Ʒ��
//				map = Code2NameUtils.valueList("$FX_SMPBRAND", "_sne_dictid:AllBrand", dbFlagValue);
				map = Code2NameUtils.valueList("$FX_SMPBRAND",dbFlagValue);
			}else if("all".equals(mode)) {
				// ������Ʒ��
//				map = Code2NameUtils.valueList("$FX_SMPBRAND", "_se_dictid:AllBrand", dbFlagValue);
				map = Code2NameUtils.valueList("$FX_SMPBRAND",dbFlagValue);
			}
			Map newMap = new LinkedHashMap();
			if (headOption == null) {
				newMap.put(null, null); // ��һ���հ���
			} else {
				newMap.put(null, headOption);// ���һ��Ĭ�ϵ�Option���磬��ѡ��....
			}
			newMap.putAll(map);
			return newMap;
		} catch (Exception e) {
			e.printStackTrace();
			return new HashMap();
		}
	}

}

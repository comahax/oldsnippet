package com.gmcc.pboss.web.common.productcategoryselect;

import java.util.ArrayList;
import java.util.List; 
import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.base.dictitem.DictitemVO; 
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.AAUtilsForStruts2;
import com.sunrise.jop.ui.struts2.BaseAction;
import org.apache.commons.lang.StringUtils;

/**
 * <p>Title: AdvgroupAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lyl
 * @version 1.0
 */
public class ProductCategorySelectAction extends BaseAction{
	
	public static String OBJLIST = "objList"; // 可选商品种类列表
	public static String OBJ_ACCOUNT = "100"; // 显示商品种类数
	
	public ProductCategorySelectAction() {
		this.setForm(new ProductCategorySelectForm());
	}
	
	//获取供选择的商品种类
	public String doCategoryList() throws Exception{
		DictitemDBParam dictiemdbparam = new DictitemDBParam();
		DictitemBO dictitemBO = (DictitemBO)BOFactory.build(DictitemBO.class,this.getDBAccessUser());
		ProductCategorySelectForm form = (ProductCategorySelectForm)getForm();
		dictiemdbparam.set_se_groupid("IM_FXCOMCATEGORY"); 
		dictiemdbparam.set_pagesize(OBJ_ACCOUNT);
		DataPackage dp = dictitemBO.doQuery(dictiemdbparam);
		List<DictitemVO> objList = dp.getDatas();
		getRequest().setAttribute(OBJLIST, objList);
		
		if(AAUtilsForStruts2.isAjaxRequest()){
			AAUtilsForStruts2.addZonesToRefresh("zoneSource");
		}
		
		return "showlist"; 
	}
	                                      
	//获取已选择的选项列表
	public String doCategoryListSel() throws Exception{
		if(AAUtilsForStruts2.isAjaxRequest()){
			ProductCategorySelectForm form = (ProductCategorySelectForm)getForm();  
			DictitemDBParam dictiemdbparam = new DictitemDBParam();
			DictitemBO dictitemBO = (DictitemBO)BOFactory.build(DictitemBO.class,this.getDBAccessUser());
			
			String selectedStr = form.getSelectedStr();
			List<String> opercodeList = new ArrayList<String>();
			if (!StringUtils.isEmpty(selectedStr)) {
				String[] opercodeArray = selectedStr.split(",");
				for(int i=0; i<opercodeArray.length; i++)
				{
					opercodeList.add(opercodeArray[i]);
				}
				dictiemdbparam.set_sin_dictname(opercodeList); 
				dictiemdbparam.set_pagesize("0");
				DataPackage dp = dictitemBO.doQuery(dictiemdbparam);
				List<DictitemVO> dataList = dp.getDatas(); 
				getRequest().setAttribute("dataList", dataList);
			}
			AAUtilsForStruts2.addZonesToRefresh("zoneData");
		}
		return "showlist";
	}
	

	public static String getOBJLIST() {
		return OBJLIST;
	}

	public static void setOBJLIST(String objlist) {
		OBJLIST = objlist;
	}

	public static String getOBJ_ACCOUNT() {
		return OBJ_ACCOUNT;
	}

	public static void setOBJ_ACCOUNT(String obj_account) {
		OBJ_ACCOUNT = obj_account;
	}
	
}
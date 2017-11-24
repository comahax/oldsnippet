package com.sunrise.boss.ui.resmanage.common;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.zifee.pcppproduct.persistent.PcPpProductListVO;
import com.sunrise.boss.business.zifee.pcppproduct.persistent.PcPpProductVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

public class MainprodTreeBean {
	
	private static final String ProdType_Family = "110";
	
	private static final String ProdType_Group = "120";
	
	private static final String ProdType_Person = "130";
	
	private String selectType; // 单选 or 多选
	
	public String getMainprodTree(HttpServletRequest request)throws Exception{
		
		// 默认单选
		selectType = StringUtils.isBlank(selectType) ? "1":selectType;
		
		User user = (User)request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		CommonDelegate delegate = new CommonDelegate(PcPpProductVO.class);
		PcPpProductListVO listVO = new PcPpProductListVO();
		listVO.set_ne_mainprod("1");//主体产品
		listVO.set_se_status("1");//有效产品
		listVO.set_pagesize("0");
		listVO.set_orderby("prodname");
		DataPackage dp = delegate.doQuery(listVO, user, false);
		List list = (List) dp.getDatas();
		int familyCount = 10000;
		int groupCount = 20000;
		int personCount = 30000;
		StringBuffer tree = new StringBuffer();
		tree.append("d = new dTree('d');\n");
		tree.append("d.add('1', -1, '广东产品', '', '广东产品', 'tbody');\n");
		tree.append("d.add('100', 1, '空值', \"").append("javascript:selectMainprod('|');\", '空值', '');\n");
		tree.append("d.add('").append(ProdType_Family).append("', 1, '广东家庭产品', '', '广东家庭产品', 'tbody');\n");
		tree.append("d.add('").append(ProdType_Group).append("', 1, '广东集团产品', '', '广东集团产品', 'tbody');\n");
		tree.append("d.add('").append(ProdType_Person).append("', 1, '广东个人产品', '', '广东个人产品', 'tbody');\n");

		String noteCount = null;
		String parentNote = null;
		String prodid = null;
		String prodname = null;
		
		Iterator it = list.iterator();
		while(it.hasNext()){
			PcPpProductVO vo = (PcPpProductVO)it.next();
			if("ProdType_Family".equalsIgnoreCase(vo.getProducttype())){
				noteCount = String.valueOf(familyCount);
				parentNote = ProdType_Family;
				familyCount += 10;
				prodid = vo.getProdid();
				prodname = vo.getProdname();
			}else if("ProdType_Group".equalsIgnoreCase(vo.getProducttype())){
				noteCount = String.valueOf(groupCount);
				parentNote = ProdType_Group;
				groupCount += 10;
				prodid = vo.getProdid();
				prodname = vo.getProdname();
			}else if("ProdType_Person".equalsIgnoreCase(vo.getProducttype())){
				noteCount = String.valueOf(personCount);
				parentNote = ProdType_Person;
				personCount += 10;
				prodid = vo.getProdid();
				prodname = vo.getProdname();
			}
			if(selectType.equals("1")){	// 单选
				tree.append("d.add('").append(noteCount).append("', ").append(parentNote).append(", '").append(prodname).append(" - (ID:").append(prodid).append(")', \"").append("javascript:selectMainprod('").append(prodid).append("|").append(prodname).append("');\", '").append(prodname).append("', '');\n");
			}else{	// 多选
				tree.append("d.add('").append(noteCount).append("', ").append(parentNote).append(", '<input type=\"checkbox\" styleClass=\"form_input_1x\"").append(" id=\"").append(prodid).append("\" name=\"prodid_checkbox\" value=\"").append(prodid).append("|").append(prodname).append("\"/>").append(prodname).append(" - (ID:").append(prodid).append(")','');\n");
			}
		}
		tree.append("document.write(d);");
		return tree.toString();
	}

	public String getSelectType() {
		return selectType;
	}

	public void setSelectType(String selectType) {
		this.selectType = selectType;
	}
}
